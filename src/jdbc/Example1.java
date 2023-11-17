package jdbc;
import java.sql.*;
public class Example1 {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			System.out.println("connection created");
			String query="create table emp3(id number,name varchar2(25))";
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

}
