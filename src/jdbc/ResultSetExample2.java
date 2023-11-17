package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetExample2 
{
	public static Connection con=null;
	ResultSetExample2() throws Exception
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
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println((2));
				System.out.println(rs.getString(3));
			}
			System.out.println("backward direction");
			while(rs.previous())
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
		ResultSetExample2 obj=new ResultSetExample2();
		obj.jdbcConnection();
	}

}
