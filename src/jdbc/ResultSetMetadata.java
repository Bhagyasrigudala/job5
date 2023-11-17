package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetadata 
{
	public static Connection con=null;
	ResultSetMetadata() throws Exception
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
		ResultSetMetaData rd=null;
		String query="select *from emp1";
		try
		{
			st=con.createStatement();
			rs=st.executeQuery(query);
			rd=rs.getMetaData();
			rs.next();
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			int count=rd.getColumnCount();
			for(int i=1;i<=count;i++)
			{
			System.out.println(rd.getColumnName(i));	
			}
			System.out.println(rd.getTableName(1));
			System.out.println(rd.getColumnType(1));
			System.out.println(rd.getColumnType(2));
			System.out.println(rd.getColumnType(3));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception 
	{
		ResultSetMetadata  obj=new ResultSetMetadata ();
		obj.jdbcConnection();
		
	}

}
