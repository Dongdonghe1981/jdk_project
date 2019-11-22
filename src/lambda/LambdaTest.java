package lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {

    @Test
    public void test1(){

        //匿名实现类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("this is r1");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("this is r2");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> cp1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(cp1.compare(12,13));

        //lambda表达式的写法
        Comparator<Integer> cp2 = (o1, o2) -> Integer.compare(o1,o2);
        System.out.println(cp2.compare(14,13));

        //方法引用
        Comparator<Integer> cp3 =Integer :: compare;
        System.out.println(cp3.compare(13,13));
    }


    @Test
    public void test3(){
        happyTime(500.0,aDouble -> System.out.println("consume money:"+aDouble));
    }

    public void happyTime (Double money, Consumer<Double> con){
        con.accept(money);
    }
}
