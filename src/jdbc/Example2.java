package jdbc;
import java.sql.*;
public class Example2 {

	static Connection con=null;
	Example2()throws Exception //constructor
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
			String query="create table emp4(id number,name varchar2(25))";
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("table created");
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
            Example2 obj=new Example2();
            obj.jdbcConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
}
