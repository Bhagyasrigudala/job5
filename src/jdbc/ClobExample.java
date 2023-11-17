package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.io.*;

public class ClobExample
{
	public static Connection con=null;
	ClobExample() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public void jdbcConnection()
	{
		
		PreparedStatement pstmt=null;
		String query="insert into clobobjtab values(?,?)";
		try
		{
			FileReader fr=new FileReader("C:/Users/Bhagya/Desktop/newone.txt");
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,101);
			pstmt.setCharacterStream(2,fr);
			
			int c=pstmt.executeUpdate();
			System.out.println("c value is :"+c);n
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception 
	{
		ClobExample obj=new ClobExample();
		obj.jdbcConnection();
	}

}
