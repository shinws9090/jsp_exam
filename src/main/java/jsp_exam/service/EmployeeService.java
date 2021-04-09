package jsp_exam.service;

import java.sql.Connection;
import java.util.List;

import jsp_exam.dao.impl.EmployeeDaoImpl;
import jsp_exam.dto.Employee;
import jsp_exam.util.jdbcUtil;

public class EmployeeService {
	private Connection conn = jdbcUtil.getConnection();
	private EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	public EmployeeService() {
		dao.setCon(conn);
	}

	public List<Employee> showEmployees() {
		return dao.selectEmployeeByAll();
	}

	public Employee showEmployee(Employee emp) {
		return dao.selectEmployeeByNo(emp);
	}

	public void addEmployee(Employee emp) {
		dao.insertEmployee(emp);
	}

	public void deleteEmployee(Employee emp) {
		dao.deleteEmployee(emp);
	}

	public void modifyEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

}
