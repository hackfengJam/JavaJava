package thread;

public class Test extends Thread {


    public static void main(String[] args) throws InterruptedException {
        String str = "111";
        String str2 = "1112";
        String str3 = "111";
        System.out.println(str == str3);
        MyThread mt1 = new MyThread(str);
        MyThread mt2 = new MyThread(str2);
        mt1.start();
        mt2.start();
        mt1.join();
        mt2.join();
    }
}
