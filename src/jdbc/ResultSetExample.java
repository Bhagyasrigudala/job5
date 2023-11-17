package jdbc;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class ResultSetExample 
{
	public static Connection con=null;
	ResultSetExample() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public void jdbcConnection()
	{
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="select *from emp1";
		try
		{
			st=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println((2));
				System.out.println(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception
	{
		ResultSetExample obj=new ResultSetExample();
		obj.jdbcConnection();

	}

}
