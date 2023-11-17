package jdbc;
import java.sql.*;
import java.util.*;
class Details
{

	static void compare(ArrayList<Student> b)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of array:");
		int size=sc.nextInt();
		int a[]=new int[size];
		int temp;
		for(int i=0;i<size;i++)
		{
			System.out.println("enter elements a["+i+"]:");
			a[i]=sc.nextInt();
		}
		for(int i=0;i<size;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		for(int i=0;i<size;i++)
		{
			if(a[i]==0)
			{
				continue;
			}
			else 
			{
				for(int j=i+1;j<size;j++)
				{
					if(a[i]==a[j])
					{
						for(int k=j;k<size-1;k++)
						{
							a[k]=a[k+1];
						}
						size--;
					}

				}
			}
		}
		System.out.println();
		System.out.println("After removing duplicates:");
		System.out.println();
		for(int k=0;k<size;k++)//printing
		{
			System.out.print(a[k]+" ");
		}
		System.out.println();
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println();
		System.out.println("After sorting:");
		System.out.println();
		for(int k=0;k<size;k++)//printing
		{
			System.out.print(a[k]+" ");
		}
		System.out.println();
		for(int i=0;i<size;i++)
		{
			if(a[i]==0)
			{
				System.out.println("'0' won't take as id");
				continue;
			}
			else 
			{
				for(Student e:b)
				{
					if(a[i]==e.id)
					{
						System.out.println();
						System.out.println(e.id+"-id's S-NO is:"+e.sno);
						System.out.println(e.id+"-id's Name is:"+e.name);
					}
				}
			}
		}

	}
}
public class Student 
{
	int sno;
	int id;
	String name;
	Student(int sno,int id,String name)
	{
		this.sno=sno;
		this.id=id;
		this.name=name;
	}
	static Connection c=null;
	Student() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("connected");
	}
	public static void main(String[] args) throws Exception
	{
		Student s=new Student();
		Scanner sc=new Scanner(System.in);
		char chh;
		PreparedStatement  pst=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<Student> a=new ArrayList();
		do
		{
			System.out.println("Enter ur choice 1-creating table , 2-inserting data, 3-updating data & 4-deleting data:");
			int option=sc.nextInt();
			System.out.println("Enter table name:");
			String tablename=sc.next();
			switch(option)
			{
			case 1:
				try 
				{
					String query="create table "+tablename+"(SNo number,id number,name varchar2(20))";
					st=c.createStatement();
					st.executeUpdate(query);
					System.out.println("table created");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 2: 
				try 
				{
					String insertq="insert into "+tablename+" "+ "values(?,?,?)";
					System.out.println("how many rows you want to insert ?");
					int rows=sc.nextInt();
					System.out.println(insertq);
					for(int i=1;i<=rows;i++)
					{
						System.out.println("Enter "+i+"-row sno:");
						int sno=sc.nextInt();
						System.out.println("Enter "+i+"-row id:");
						int id=sc.nextInt();
						System.out.println("Enter "+i+"-row name:");
						String name=sc.next();
						pst=c.prepareStatement(insertq);
						pst.setInt(1, sno);
						pst.setInt(2, id);
						pst.setString(3, name);
						pst.executeUpdate();
						System.out.println("data inserted");
						c.commit();
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try
				{
					String updateq="update "+tablename+" set name=? where id=?";
					System.out.println("Enter id where you want to do changes:");
					int id=sc.nextInt();
					System.out.println("Enter the new name:");
					String name=sc.next();
					pst=c.prepareStatement(updateq);
					pst.setString(1, name);
					pst.setInt(2, id);
					pst.executeUpdate();
					System.out.println("Updated");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
			case 4:
				try
				{
					String deletq="delete from "+tablename+" where id=?";
					pst=c.prepareStatement(deletq);
					System.out.println("Enter id which you want to delete:");
					int id=sc.nextInt();
					System.out.println("do you want really delete "+id +"-id's row y/n");
					char ch=sc.next().charAt(0);
					if(ch=='y'||ch=='Y')
					{
						pst.setInt(1,id);
						pst.executeUpdate();
						System.out.println("Deleted");
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try
				{
					String selectq="select * from "+tablename+" ";
					pst=c.prepareStatement(selectq);
					rs=pst.executeQuery();
					while(rs!=null&&rs.next())
					{
						a.add(new Student(rs.getInt(1),rs.getInt(2),rs.getString(3)));
					}
					c.commit();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				//System.out.println(a);
				Details.compare(a);
			}
			System.out.println("do you want continue y/n:");
			chh=sc.next().charAt(0);
		}
		while(chh=='y'||chh=='Y');
		System.out.println("done");
	}
}