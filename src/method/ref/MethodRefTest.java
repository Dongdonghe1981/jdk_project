package method.ref;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class MethodRefTest {

    @Test
    public void test1(){
        Consumer<String> con = str -> System.out.println(str);
        con.accept("lambda");

        Consumer<String> con2 = System.out :: println;
        con2.accept("method ref");
    }

    @Test
    public void test2(){
        Comparator<Integer> com = (i1,i2) -> Integer.compare(i1,i2);
        System.out.println(com.compare(1,2));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(1,2));
    }

    @Test
    public void test3(){
        Comparator<String> com = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com.compare("ab","ac"));

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("ad","ac"));
    }
}
