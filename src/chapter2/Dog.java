package chapter2;

public class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("Dog 跑");
    }

    @Override
    public void eat() {
        System.out.println("Dog 吃");
    }
}
