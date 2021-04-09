package jsp_exam.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jsp_exam.dao.impl.EmployeeDaoImpl;
import jsp_exam.dto.Department;
import jsp_exam.dto.Employee;
import jsp_exam.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private static Connection con;
	private static EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();

	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectEmployeeByAll() {
		System.out.println("test01SelectEmployeeByAll");
		List<Employee> list = dao.selectEmployeeByAll();

		Assert.assertNotNull(list);

		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectEmployeeByNo() {
		System.out.println("test02SelectEmployeeByNo");
		Employee employee = dao.selectEmployeeByNo(new Employee(4377));

		Assert.assertNotNull(employee);
		System.out.println(employee);
	}

	@Test
	public void test03InsertEmployee() {
		System.out.println("test03InsertEmployee");

		Employee employee = new Employee(9999, "이름", new Title(1), new Employee(4377), 5000000, new Department(3), new Date());
		int res = dao.insertEmployee(employee);

		Assert.assertEquals(res, 1);
		System.out.println(dao.selectEmployeeByNo(new Employee(9999)));
	}

	@Test
	public void test04UpdateEmployee() {
		System.out.println("test04UpdateEmployee");

		int res = dao.updateEmployee(new Employee(9999, "이름이다", new Title(2), new Employee(4377), 34343343, new Department(4), new Date()));

		Assert.assertEquals(res, 1);
		System.out.println(dao.selectEmployeeByNo(new Employee(9999)));
	}

	@Test
	public void test05DeleteEmployee() {
		System.out.println("test05DeleteEmployee");

		int res = dao.deleteEmployee(new Employee(9999));

		Assert.assertEquals(res, 1);
	}

}
