package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.jdbc.Driver;

public class WriteToExcel {

	public static void main(String[] args) throws Throwable {
		// DataBase values
		String url = "jdbc:mysql://rmgtestingserver:3333/projects";
		String un = "root@%";
		String psd = "root";
		String query = "SELECT PROJECT_ID FROM PROJECT;";
		Connection con = null;

		// BackEnd Validation
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		con = DriverManager.getConnection(url, un, psd);
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		// Excel
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\WriteData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");

		for (int i = 0; res.next(); i++) {
			System.out.println(res.getString(1));
			String DV = res.getString(1);
			sh.createRow(i).createCell(0).setCellValue(DV);
			FileOutputStream FOS = new FileOutputStream(".\\src\\test\\resources\\WriteData.xlsx");
			wb.write(FOS);

		}
		wb.close();
		con.close();

	}

}
