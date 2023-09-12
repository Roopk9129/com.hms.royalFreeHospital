package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class JDBC_NonSelectTest {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/d1";
		String un = "root";
		String psd = "root";
		String query = "insert into d2_table values('s_002','rose','mysore','done');";
		int res=0;
		Connection con = null;
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);

		con = DriverManager.getConnection(url, un, psd);
		Statement state = con.createStatement();
		res = state.executeUpdate(query);
		if(res>=1) {
			System.out.println("Data has been Created");
			
		}else {
			System.out.println("Data creation failed");
		}con.close();
		

	}

}
