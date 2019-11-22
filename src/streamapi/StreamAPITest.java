package streamapi;

import dto.Employee;
import org.junit.jupiter.api.Test;
import dto.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {

    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployee();
        //串行流
        Stream<Employee> stream = employees.stream();
        //并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    @Test
    public void test2(){
        Employee[] employees = (Employee[]) EmployeeData.getEmployee().toArray();
        Stream<Employee> stream = Arrays.stream(employees);
    }
    
    @Test
    public void test3(){
        Stream<List<Employee>> employee = Stream.of(EmployeeData.getEmployee());
    }

    @Test
    public void test4(){
        //
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
