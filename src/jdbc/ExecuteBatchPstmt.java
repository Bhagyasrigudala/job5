package jdbc;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExecuteBatchPstmt 
{
	public static Connection con=null;
	ExecuteBatchPstmt()throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public void jdbcConnection()
	{
		Statement st=null;
		PreparedStatement ps=null;
		try
		{
          ps=con.prepareStatement("insert into emp2 values(?,?,?)");
          ps.setInt(1,105);
          ps.setString(2,"bhagya");
          ps.setInt(3,100000);
          ps.addBatch();
          
          ps.setInt(1,106);
          ps.setString(2,"navya");
          ps.setInt(3,200000);
          ps.addBatch();
          
          ps.setInt(1,107);
          ps.setString(2,"deep");
          ps.setInt(3,300000);
          ps.addBatch();
          
          int a[]=ps.executeBatch();
          for(int i:a)
				System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	public static void main(String[] args) throws Exception
	{
		ExecuteBatchPstmt obj=new ExecuteBatchPstmt();
		obj.jdbcConnection();
		
	}

}
