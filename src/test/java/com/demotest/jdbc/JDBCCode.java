/*package com.demotest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demotest.tetscase.BaseClass;
import com.demotest.utilities.ReadConfig;
*/


/*public class JDBCCode extends BaseClass
{
	

	public void jdbcConnection(WebDriver driver) throws SQLException
	{
	    class.forName("com.mysql.jdbc.driver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@ip-172-30-2-34:3306/bizommysql","dhulappa.rn","Anand@12345");
		Statement stmt= con.createStatement();
		String s = "SELECT id FROM schemes ORDER BY ID DESC LIMIT 1";
		ResultSet rs = stmt.executeQuery(s);
		while(rs.next())
		{
		    String SchemeId =rs.getStringId();
		    String schemeName =rs.getStringName();
		    
		}
		

	}
}*/
