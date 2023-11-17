package jdbc;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class RetriveingClobFile 
{
	public static Connection con=null;
	RetriveingClobFile() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public void jdbcConnection()
	{
		PreparedStatement pstmt=null;
		try
		{
			String query="select *from clobObjtab";
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			Clob obj=rs.getClob(2);
			Reader r=obj.getCharacterStream();
			FileWriter fw=new FileWriter("");
			int i=0;
			while((i=r.read())!=-1)
				fw.write(i);
			    fw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception 
	{
		RetriveingClobFile  obj=new RetriveingClobFile();
		obj.jdbcConnection();
		
		

	}

}
