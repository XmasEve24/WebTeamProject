package model.common;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDI {
	public Connection connect() {
		Connection conn=null;
		Context initialContext;
		try {
			initialContext = new InitialContext();
			Context envContext=(Context)initialContext.lookup("java:comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/orcl");
//			DataSource ds=(DataSource)envContext.lookup("jdbc/mysql");
			conn=ds.getConnection();
		} catch (Exception e) {
			System.out.println("JNDI Exception Occured");
			e.printStackTrace();
		}
		return conn;
	}
}
