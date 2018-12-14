package functionalInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import entity.Employee;

public class Demo1 {

	@Test
	public void test1() {
			
		Consumer<String> con = (s)->System.out.println(s);
		con.accept("hello java8");
		
		Supplier<Date> supplier = ()->new Date();
		System.out.println(supplier.get());
		
		Function<Date, String> fun = (Date date)->{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			return sdf.format(date);
		};
		System.out.println(fun.apply(new Date()));
		
		Predicate<Integer> pre = (n)->n>10;
		System.out.println(pre.test(11));
		
		Consumer<String> con2 = System.out::println;
		con2.accept("hello Method Reference");
	}
	
	@Test
	public void test2() {
		List<Employee> list = new ArrayList();
		Employee employee1 = new Employee("zhangsan",25,5000);
		Employee employee2 = new Employee("lisi",35,3000);
		Employee employee3 = new Employee("wangwu",18,4000);
		Employee employee4 = new Employee("zaoliu",41,8000);
		Employee employee5 = new Employee("chengqi",29,6000);
		
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);
		list.add(employee5);
		
		Function<List<Employee>,List<Employee>> fun = (source)->{
			List<Employee> result = new ArrayList();
			for (Employee employee : source) {
				if(employee.getAge()>25) {
					result.add(employee);
				}
			}
			return result;
		};
		
		List<Employee> list2 = fun.apply(list);
		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}

}
