package jsp_exam.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class jdbcUtil {
	public static DataSource ds;
	
	
	public jdbcUtil() {}


	static {
		
		try{
			Context init = new InitialContext(); 
			ds = (DataSource)init.lookup("java:comp/env/jdbc/web_gradle_erp");
		}catch(NamingException e){
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
