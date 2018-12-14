package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import entity.Employee;

public class Stream {

	@Test
	public void test1() {
		List<Employee> list = new ArrayList();
		list.add(new Employee("张三",22,5000));
		list.add(new Employee("李四",23,4000));
		list.add(new Employee("王五",25,3000));
		list.add(new Employee("赵六",32,6000));
		list.add(new Employee("陈琪",19,4500));
		list.add(new Employee("解雨臣",27,8000));
		list.add(new Employee("吴邪",24,7000));
		list.add(new Employee("张起灵",26,10000));
		
		list.stream()
		.filter((employee) -> employee.getAge() > 25) 
		.forEach(System.out::println);
		
		System.out.println("===============================");
		
//		list.stream()
//		.map((e) -> e.getName())
//		.forEach(System.out::println);
		
		list.stream()
		.map(Employee::getName)
		.forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		List<String> list1 = Arrays.asList("aa","cc","AA","ab","Ab");
		list1.stream().sorted().forEach(System.out::println);
		System.out.println("------------------------");
		
		List<Employee> list = new ArrayList();
		list.add(new Employee("张三",22,5000));
		list.add(new Employee("李四",23,4000));
		list.add(new Employee("王五",25,3000));
		list.add(new Employee("赵六",32,6000));
		list.add(new Employee("陈琪",19,4500));
		list.add(new Employee("解雨臣",27,8000));
		list.add(new Employee("吴邪",24,7000));
		list.add(new Employee("张起灵",26,10000));
		
		list.stream().sorted((e1,e2) -> {
			if(e1.getAge()==e2.getAge()) {
				return e1.getSalary()-e2.getSalary();
			}else {
				return e1.getAge()-e2.getAge();
			}
		}).forEach(System.out::println);
		
	}
	
}
