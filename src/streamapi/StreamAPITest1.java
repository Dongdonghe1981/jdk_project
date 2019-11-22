package streamapi;

import dto.Employee;
import dto.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StreamAPITest1 {
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployee();
        employees.stream().filter(e -> e.getAge()>26).forEach(System.out::println);
        System.out.println("===============");
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("===============");
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("===============");

        employees.addAll(EmployeeData.getEmployee());
        employees.stream().distinct().forEach(System.out::println);
        System.out.println("===============");
    }

    @Test
    public void test2(){
        //ma(Function f)
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        List<Employee> emptiest = EmployeeData.getEmployee();
        emptiest.stream().map(e -> e.getName().length() > 3).forEach(System.out::println);
        emptiest.stream().filter(e -> e.getName().length() > 3).forEach(System.out::println);

        //flatMap


    }
}
