package Assignment;

import java.sql.*;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;
/*
 * @author S Roop Kumar
 */
public class Assignment_08Sep {
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name: ");
		String str = sc.next();
		String SelectQuery = "Select * from TYSS; ";
		String NonSelectQuery = "insert into tyss(name)values(" + "'" + str + "'" + ");";
		sc.close();

		// database connectivity
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "root");
		Statement state = conn.createStatement();
		ResultSet set = state.executeQuery(SelectQuery);
		boolean flag = false;

		for (; set.next();) {
			if (set.getString(2).equalsIgnoreCase(str)) {
				flag = true;
			}
		}
		if (flag) {
			System.out.println("The Name "+'"' + str + '"' + " is already inserted in to Database");

		} else {
			System.out.println('"' + str + '"' + " not found in Database \n");
			Statement Updatestate = conn.createStatement();
			int Updateset = Updatestate.executeUpdate(NonSelectQuery);
			if (Updateset >= 1) {
				System.out.println('"' + str + '"' + " has been inserted in to Database");
			}
		}
	}

}
