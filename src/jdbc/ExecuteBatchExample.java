package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class ExecuteBatchExample 
{
	public static Connection con=null;
	ExecuteBatchExample()throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public void jdbcConnection()
	{
		Statement st=null;
		try
		{
			String query="create table emp2(id number,name varchar2(25),sal float)";
			st=con.createStatement();
			st.executeUpdate(query);
			System.out.println("table created");
			st=con.createStatement();
			st.addBatch("insert into emp2 values(101,'bhagya',10000)");
			st.addBatch("insert into emp2 values(102,'navya',20000)");
			st.addBatch("insert into emp2 values(103,'deepu',30000)");
			st.addBatch("insert into emp2 values(104,'chandrika',40000)");
			st.addBatch("update emp2 set sal=8000 where id=102");
			int a[]=st.executeBatch();
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
		ExecuteBatchExample obj=new ExecuteBatchExample();
		obj.jdbcConnection();
	}
}
