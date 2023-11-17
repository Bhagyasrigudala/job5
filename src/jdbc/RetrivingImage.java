package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;
public class RetrivingImage 
{
	public static Connection con=null;
	RetrivingImage() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public void jdbcConnection()
	{
		PreparedStatement pstmt=null;
		String query="select *from imagetab";
		try
		{
			FileOutputStream fout=new FileOutputStream("C:/Users/Bhagya/Desktop/java22.jpg");
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			Blob obj=rs.getBlob(2);
			fout.write(obj.getBytes(1,(int)obj.length()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws Exception
	{
		RetrivingImage obj=new RetrivingImage ();
		obj.jdbcConnection();
		

	}

}
