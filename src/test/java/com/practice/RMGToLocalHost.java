package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class RMGToLocalHost {

	public static void main(String[] args) throws Throwable {

		// RMG DataBase values
		String Serverurl = "jdbc:mysql://rmgtestingserver:3333/projects";
		String Serverun = "root@%";
		String Serverpsd = "root";
		String Serverquery = "SELECT * FROM PROJECT;";

		// Local DB end Values
		String LocalUrlName = "jdbc:mysql://localhost:3306/d1";
		String LocalUN = "root";
		String LocalPSD = "root";
		String TableName = "";

		// RMG database setup
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection(Serverurl, Serverun, Serverpsd);
		Statement state = conn.createStatement();
		ResultSet sRes = state.executeQuery(Serverquery);
		int count = 0;
		while (sRes.next()) {

			String PId = sRes.getString(1);
			String Cby = sRes.getString(2);
			String Con = sRes.getString(3);
			String Pna = sRes.getString(4);
			String Status = sRes.getString(5);
			String Tsi = sRes.getString(6);
			System.out.println(PId + Cby + Con + Pna + Status + Tsi);
			String Localquery = "import in to "+TableName+" values";

			count++;
		}
		System.out.println(count);

	}

}
