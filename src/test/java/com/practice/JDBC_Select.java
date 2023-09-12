package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Select {

	public static void main(String[] args) throws Throwable {

		String url = "jdbc:mysql://localhost:3306/schooldetails";
		String un = "root";
		String psd = "root";
		String query = "select * from emp;";
		Connection con = null;

		try {
			Driver drive = new Driver();
			DriverManager.registerDriver(drive);
			con = DriverManager.getConnection(url, un, psd);
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(query);
			while (res.next()) {
				System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " "
						+ res.getString(4) + " " + res.getString(5) + " " + res.getString(6));

			}

		} catch (Exception e) {

		} finally {
			con.close();
		}
	}
}
