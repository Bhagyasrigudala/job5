package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example3 {

	static Connection con=null;
	Example3()throws Exception //constructor
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connection created");
	}
	public void jdbcConnection()
	{
		Statement stmt=null;
		try
		{
			String query="insert into emp4 values(101,'AAA')";
			String query1="insert into emp4 values(102,'BBB')";
			System.out.println(query);
			stmt=con.createStatement();
			int i=stmt.executeUpdate(query);
			int j=stmt.executeUpdate(query1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) 
	{
		try
		{
            Example3 obj=new Example3();
            obj.jdbcConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
}
