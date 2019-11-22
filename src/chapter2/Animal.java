package chapter2;

public interface Animal {

    void run();

    void eat();

    default void breath(){
        System.out.println("使用氧气呼吸");
    }

    static void test(){
        System.out.println("测试方法");
    }
}
