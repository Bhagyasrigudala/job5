package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseMetaDataExample 
{
	public static Connection con=null;
	DataBaseMetaDataExample() throws Exception
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
		try
		{
			DatabaseMetaData db=con.getMetaData();
			System.out.println("driver name:"+db.getDriverName());
			System.out.println("database name:"+db.getDatabaseProductName());
			System.out.println("version:"+db.getDatabaseProductVersion());
			System.out.println("URL:"+db.getURL());
			System.out.println("Username:"+db.getUserName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception 
	{
		DataBaseMetaDataExample obj=new DataBaseMetaDataExample();
		obj.jdbcConnection();
	}
}
