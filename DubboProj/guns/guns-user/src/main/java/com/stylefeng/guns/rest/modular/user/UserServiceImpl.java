package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.dao.HackfunUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.HackfunUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Service(interfaceClass = UserAPI.class)
public class UserServiceImpl implements UserAPI {

    @Autowired
    private HackfunUserTMapper hackfunUserTMapper;

    @Override
    public int login(String username, String password) {
        // 根据登录账号获取数据库信息
        HackfunUserT hackfunUserT = new HackfunUserT();
        hackfunUserT.setUserName(username);
        HackfunUserT result = hackfunUserTMapper.selectOne(hackfunUserT);

        // 获取到的结果，然后与加密后密码做匹配
        if (result != null && result.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (result.getUserPwd().equals(md5Password)) {
                return result.getUuid();
            }
        }

        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {

        // 获取注册信息

        // 将注册信息实体转换为数据实体[hackfun_user_t]
        HackfunUserT hackfunUserT = new HackfunUserT();
        hackfunUserT.setUserName(userModel.getUsername());
        hackfunUserT.setUserPwd(userModel.getPassword());
        hackfunUserT.setEmail(userModel.getEmail());
        hackfunUserT.setAddress(userModel.getAddress());
        hackfunUserT.setUserPhone(userModel.getPhone());

        // 创建时间和修改时间 -> current_timestamp

        // 数据加密 【MD5混淆加密 + 加盐 -> Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        hackfunUserT.setUserPwd(md5Password);


        // 将数据实体存入数据库
        Integer insert = hackfunUserTMapper.insert(hackfunUserT);
        if (insert > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean checkUsername(String username) {
        EntityWrapper<HackfunUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", username);
        Integer result = hackfunUserTMapper.selectCount(entityWrapper);
        if (result != null && result > 0) {
            return false;
        } else {
            return true;
        }
    }

    private UserInfoModel do2UserInfo(HackfunUserT hackfunUserT) {
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(hackfunUserT.getUuid());
        userInfoModel.setUsername(hackfunUserT.getUserName());
        userInfoModel.setUpdateTime(hackfunUserT.getUpdateTime().getTime());
        userInfoModel.setSex(hackfunUserT.getUserSex());
        userInfoModel.setPhone(hackfunUserT.getUserPhone());
        userInfoModel.setNickname(hackfunUserT.getNickName());
        userInfoModel.setLifeState("" + hackfunUserT.getLifeState());
        userInfoModel.setHeadAddress(hackfunUserT.getHeadUrl());
        userInfoModel.setEmail(hackfunUserT.getEmail());
        userInfoModel.setBeginTime(hackfunUserT.getBeginTime().getTime());
        userInfoModel.setBirthday(hackfunUserT.getBirthday());
        userInfoModel.setBiography(hackfunUserT.getBiography());
        userInfoModel.setAddress(hackfunUserT.getAddress());

        return userInfoModel;

    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        // 根据主键查询用户信息[HackfunUserT]
        HackfunUserT hackfunUserT = hackfunUserTMapper.selectById(uuid);
        // 将HackfunUserT转换UserInfoModel
        UserInfoModel userInfoModel = do2UserInfo(hackfunUserT);
        // 返回UserInfoModel
        return userInfoModel;
    }

    private Date time2Date(long time) {
        Date date = new Date(time);
        return date;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        // 将传入的数据转换为HackfunUserT
        HackfunUserT hackfunUserT = new HackfunUserT();
        hackfunUserT.setUuid(userInfoModel.getUuid());
        hackfunUserT.setUserSex(userInfoModel.getSex());
        hackfunUserT.setUpdateTime(time2Date(System.currentTimeMillis()));
        hackfunUserT.setNickName(userInfoModel.getNickname());
        hackfunUserT.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        hackfunUserT.setHeadUrl(userInfoModel.getHeadAddress());
        hackfunUserT.setBirthday(userInfoModel.getBirthday());
        hackfunUserT.setBiography(userInfoModel.getBiography());
        hackfunUserT.setBeginTime(time2Date(userInfoModel.getBeginTime()));
        hackfunUserT.setEmail(userInfoModel.getEmail());
        hackfunUserT.setAddress(userInfoModel.getAddress());
        hackfunUserT.setUserPhone(userInfoModel.getPhone());

        // 将数据存入数据库
        Integer isSuccess = hackfunUserTMapper.updateById(hackfunUserT);

        if (isSuccess > 0) {
            // 按照Id 将用户信息查出来（购物车、库存等要求数据准确性非常高，则切记查回）
            UserInfoModel userInfo = getUserInfo(hackfunUserT.getUuid());

            // 返回给前端
            return userInfo;
        } else {
            return userInfoModel;
        }
    }

}
