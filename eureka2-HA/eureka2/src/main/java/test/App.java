package test;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        try {
            test();
        } catch (Exception e) {
            System.out.println("_____________-----");
        }
//        try {
//            int i = 1/0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("进入异常了");
//        }
    }

    public static void test() throws Exception{
        try {
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("进入异常了2222222222");
            throw  e;
        }
    }




}
