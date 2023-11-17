package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.io.*;

public class BlobExample
{
	public static Connection con=null;
	BlobExample() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public void jdbcConnection()
	{
		//to store image object in the database
		PreparedStatement pstmt=null;
		String query="insert into imagetab values(?,?)";
		try
		{
			FileInputStream fin=new FileInputStream("C:/Users/Bhagya/Desktop/new.jpg");
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,101);
			pstmt.setBlob(2,fin);
			
			int count=pstmt.executeUpdate();
			System.out.println("count is :"+count);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception 
	{
		BlobExample obj=new BlobExample();
		obj.jdbcConnection();
	}

}
