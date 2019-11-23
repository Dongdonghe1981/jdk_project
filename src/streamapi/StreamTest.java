package streamapi;

import dto.Employee;
import dto.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    //匹配与查找
    @Test
    public void test1() {
        List<Employee> emptiest = EmployeeData.getEmployee();
        boolean b = emptiest.stream().allMatch(e -> e.getAge() > 24);
        System.out.println(b);

        emptiest.stream().filter(e -> e.getAge() > 24).count();

        Stream<Integer> integerStream = emptiest.stream().map(e -> e.getAge());
        System.out.println(integerStream.max(Integer::compareTo));

        Optional<Employee> min = emptiest.stream().min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
    }

    // 规约
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.stream().reduce(0,Integer::sum);
    }

    // 收集
    @Test
    public void test3(){
        List<Employee> emptiest = EmployeeData.getEmployee();
        List<Employee> list = emptiest.stream().filter(e -> e.getAge() > 25).collect(Collectors.toList());


    }
}