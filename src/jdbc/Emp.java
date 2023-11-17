package jdbc;
import java.util.*;
public class Emp 
{
	int id;
	String name;
	float sal;
	Emp(int id,String name,float sal)
	{
		this.id=id;
		this.name=name;
		this.sal=sal;
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Emp obj1=new Emp(1,"bhagya",10001);
		Emp obj2=new Emp(2,"navya",10002);
		Emp obj3=new Emp(3,"deepu",10003);
		Emp obj4=new Emp(4,"chandrika",10004);
		ArrayList a=new ArrayList();
		a.add(obj1);
		a.add(obj2);
		a.add(obj3);
		a.add(obj4);
		HashMap h=new HashMap();
		System.out.println("Enter the employee ID: ");
		int Id = sc.nextInt();
		h.put(Id, a);
		ArrayList<Emp> se=(ArrayList) h.get(Id);
		if(Id<=se.size())
		{
			for(Emp e:se)
			{
				if(e.id==Id)
				{
					System.out.println("Name:"+e.name);
					System.out.println("Salary:"+e.sal);
				}
			}
		}
		else
		{
			System.out.println("Invaild key");
		}
	}
}