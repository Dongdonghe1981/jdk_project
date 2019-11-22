package streamapi;

import dto.Employee;
import dto.EmployeeData;
import org.junit.jupiter.api.Test;

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
}
