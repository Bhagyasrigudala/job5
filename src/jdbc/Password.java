package jdbc;

import java.util.*;
public class Password 
{
	static int A1=0,d1=0,sp1=0;
	public static char[][] assigning(String as,int count)
	{
		char mat1[][]=new char[3][count];
		//char mat1[][]=new char[3][length];
		char ch[]=as.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if((ch[i]>='A'&&ch[i]<='Z')||(ch[i]>='a'&&ch[i]<='z'))
			{
				mat1[0][A1]=ch[i];
				A1++;
			}
			else if(ch[i]>='0'&&ch[i]<='9')
			{
				mat1[1][d1]=ch[i];
				d1++;
			}
			else
			{
				mat1[2][sp1]=ch[i];
				sp1++;
			}
		}
		return mat1;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String as=null;
		int count=0;
		do
		{
			System.out.println("Enter your option 1-create password and 2-reset password:");
			int option =sc.nextInt();
			switch(option)
			{ 
			case 1:
				String Char="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&''()*+<>^,_-./;:=?@";
				String s="";
				Random r=new Random();
				for(int i=0;i<8;i++)
				{
					int index=r.nextInt(Char.length());
					s+=Char.charAt(index);
				}
				System.out.println(s);
				char ch[]=s.toCharArray();
				int cc=0,scc=0,dc=0,ssc=0;
				if(ch.length>=8) {
					for(int i=0;i<ch.length;i++)
					{
						char c=ch[i];
						if(c>='a'&&c<='z')
						{
							scc++;
						}
						else if(c>='A'&&c<='Z')
						{
							cc++;	
						}
						else if(c>='0'&&c<='9')
						{
							dc++;
						}
						else if((c>=' '&&c<='/')||(c>=':'&&c<='@'))
						{
							ssc++;
						}
					}
					if(cc>=1 && scc>=1)
					{
						if(dc>=1)
						{
							if(ssc>=1)
							{
								as=s;
								count=ch.length;
								System.out.println("Your password is created");
							}
							else
							{
								System.out.println("Make sure password contains special characters.");
							}
						}
						else
						{
							System.out.println("Make sure password contains digits.");
						}
					}
					else
					{
						System.out.println("Make sure password contain both captial and small letters.");
					}
				}
				else
				{
					System.out.println("password should contain minimum 8 characters");
				}
				break;
			case 2:
				System.out.println("Reset your password:");
				String s1=sc.next();
				char chh[]=s1.toCharArray();
				int cc1=0,scc1=0,dc1=0,ssc1=0;
				if(chh.length>=8) {
					for(int i=0;i<chh.length;i++)
					{
						char c=chh[i];
						if(c>='a'&&c<='z')
						{
							scc1++;
						}
						else if(c>='A'&&c<='Z')
						{
							cc1++;	
						}
						else if(c>='0'&&c<='9')
						{
							dc1++;
						}
						else if((c>=' '&&c<='/')||(c>=':'&&c<='@'))
						{
							ssc1++;
						}
					}
					if(cc1>=1 && scc1>=1)
					{
						if(dc1>=1)
						{
							if(ssc1>=1)
							{
								System.out.println("Password created");
								char mat[][]=new char[3][chh.length];
								//char mat1[][]=new char[3][length];
								int A=0,d=0,sp=0;
								for(int i=0;i<chh.length;i++)
								{
									if((chh[i]>='A'&&chh[i]<='Z')||(chh[i]>='a'&&chh[i]<='z'))
									{
										mat[0][A]=chh[i];
										A++;
									}
									else if(chh[i]>='0'&&chh[i]<='9')
									{
										mat[1][d]=chh[i];
										d++;
									}
									else
									{
										mat[2][sp]=chh[i];
										sp++;
									}
								}
								//System.out.println("A:"+A);
								int large = 0;
								int a=A,b=d,c=sp;
								if(a>b&&a>c)
								{
									large=a;
								}
								else if(b>a&&b>c)
								{
									large=b;
								}
								else if(c>a&&c>b)
								{
									large=c;
								}
								else if(a==b||a==c)
								{
									large=a;
								}
								else if(b==a||b==c)
								{
									large=b;
								}
								else if(c==b||c==a)
								{
									large=c;
								}
								char mat1[][]=assigning(as,count);
								int large1 = 0;
								int a1=A1,b1=d1,c1=sp1;
								if(a1>b1&&a1>c1)
								{
									large1=a1;
								}
								else if(b1>a1&&b1>c1)
								{
									large1=b1;
								}
								else if(c1>a1&&c1>b1)
								{
									large1=c1;
								}
								else if(a1==b1||a1==c1)
								{
									large1=a1;
								}
								else if(b1==a1||b1==c1)
								{
									large1=b1;
								}
								else if(c1==b1||c1==a1)
								{
									large1=c1;
								}
								for(int m=0;m<3;m++) {
									for(int i=0;i<large;i++)
									{
										if(mat[m][i]!=0)
										{
										System.out.print(mat[m][i]+" ");
										}
										else
										{
											System.out.print(" "+" ");
										}
									}
									System.out.print(" ");
									for(int i=0;i<large1;i++)
									{
										if(mat1[m][i]!=0)
										{
										System.out.print(mat1[m][i]+" ");
										}
										else
										{
											System.out.print(" ");
										}
									}
									System.out.println();
									
								}
							}
							else
							{
								System.out.println("Make sure password contains special characters.");
							}
						}
						else
						{
							System.out.println("Make sure password contains digits.");
						}
					}
					else
					{
						System.out.println("Make sure password contain both captial and small letters.");
					}
				}
				else
				{
					System.out.println("password should contain minimum 8 characters");
				}
				break;
			}
			char c;
			System.out.println("Do you want to continue Yes-y/No-n?");
			c=sc.next().charAt(0);
			if(c=='n'||c=='N')
			{
				System.out.println("your out of the loop");
				break;
			}
		}
		while(true);
	}
}