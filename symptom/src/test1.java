import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.io.*;
public class test1{
//static Connection c;
	static int A=0x0000;
	static int B=0x0000;
	static int C=0x0000;
static String sCurrentLine,tempstr,temp;
static List<String> wordList = new ArrayList();
static int fun(Connection c,BufferedReader br,HashSet days, HashSet months,HashSet dic)
{
	List<Integer> symtemp = new ArrayList();
	List<Integer> symfin = new ArrayList();
	int n=0;
	try {
		String query1 = "SELECT * FROM SYMPTOM WHERE DES=";
		String query2 = "SELECT * FROM OUTCOME WHERE ID=";
		int row = 0;
		Statement st = c.createStatement();
		
		
		System.out.println("**********************************");
		
		// System.out.println(contentInBytes);
		
		
	String temp1=" ";
	try
	{
		int sym=0;
		int flag=0;
	while ((sCurrentLine = br.readLine()) != null && flag==0) {
		wordList.clear();
		//System.out.println(sCurrentLine);
		StringTokenizer tokn = new StringTokenizer(sCurrentLine, " ");
		
		if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
		{
			
			tempstr=sCurrentLine;
			System.out.println(tempstr);
		//	continue;
			br.mark(1000);
			while ((sCurrentLine = br.readLine()) != null) {
				
				StringTokenizer tokn1 = new StringTokenizer(sCurrentLine, " ");
				
				if(tokn1.countTokens()>2 && days.contains(tokn1.nextToken()) && months.contains(tokn1.nextToken()))
				{
					//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					br.reset();
					flag=1;
					break;
					
				}
				StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, ": ");
		while (tokn2.hasMoreTokens()) {
			temp=tokn2.nextToken();
			//System.out.println(temp);
			wordList.add(temp);
			}
		br.mark(1000);
			}
		}
		//
		ListIterator<String> itr=wordList.listIterator();
		while(itr.hasNext())
		{
			temp1=itr.next();
			if(dic.contains(temp1))
			{
				//System.out.println(query+temp1);
				ResultSet r = st.executeQuery(query1+ "'"+temp1+"'");
				while(r.next())
				{
					sym=r.getInt(1);
				System.out.println(sym);
				symtemp.add(sym);
				// System.out.println("aaaaaaaaa"+sym);
				}
			}
		}
			ListIterator<Integer> itrsymtemp1=symtemp.listIterator();
			
			while(itrsymtemp1.hasNext())
			{
				
				n=itrsymtemp1.next();
				symfin.add(n);
				ListIterator<Integer> itrsymtemp2=symtemp.listIterator();
				int i=0;
				while(itrsymtemp1.hasNext())
				{
					i++;
					n=n|itrsymtemp1.next();
					if(!symfin.contains(n))
					symfin.add(n);
				}
				while(i!=0)
				{
					itrsymtemp1.previous();
					i--;
				}
			}
			ListIterator<Integer> itrsymfin=symfin.listIterator();
				while(itrsymfin.hasNext())
				{
			int t=itrsymfin.next();
			System.out.println(t);
				ResultSet r2 = st.executeQuery(query2+t);
				while(r2.next())
				{
					//
					//sym=r.getInt(1);
					
				System.out.println(r2.getString(2));
				// System.out.println(contentInBytes);
				}
				}
		
	}
	}
	//st.close( );
	catch(Exception e)
	{
	e.printStackTrace();
	}
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return n;
}
public static void main(String args[ ]) throws Exception {
int ch;
Connection c = null;
HashSet days = new HashSet();
HashSet months=new HashSet();
List<Integer> symtemp = new ArrayList();
List<Integer> symfin = new ArrayList();
int n=0;
int A=0x0000;
int B=0x0000;
int C=0x0000;
String query2 = "SELECT * FROM OUTCOME WHERE ID=";

/*  pt.put(t1, ob1);
pt.put(t2, ob2);
pt.put(t3, obk);*/
HashSet dic=new HashSet();
int tempint;
int cnt=0;
String str2=" ";
String str3=" ";
String str4=" ";
// add elements to the hash set
dic.add("s0");
dic.add("s1");
dic.add("s2");
dic.add("s3");
dic.add("s4");
dic.add("s5");
days.add("Sun");
days.add("Mon");
days.add("Tue");
days.add("Wed");
days.add("Thu");
days.add("Fri");
months.add("Jan");
months.add("Feb");
months.add("Mar");
months.add("Apr");
months.add("May");
months.add("Jun");
months.add("Jul");
months.add("Aug");
months.add("Sep");
months.add("Oct");
months.add("Nov");
months.add("Dec");
BufferedReader br1 = null;
BufferedReader br2 = null;
BufferedReader br3 = null;
String sCurrentLine;
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","azadAZAD1");
}
catch(ClassNotFoundException error) {
System.err.println("Unable to load the JDBC/ODBC bridge" + error.getMessage( ));
System.exit(1);
}
catch(SQLException error) {
System.err.println("Unable to connect to database---" + error.getMessage( ));
System.exit(2);
}
catch(Exception e) { }
try
{
br1 = new BufferedReader(new FileReader("C:/log1.txt"));
br2 = new BufferedReader(new FileReader("C:/log2.txt"));
br3 = new BufferedReader(new FileReader("C:/log3.txt"));
A=fun(c,br1,days,months,dic);
B=fun(c,br2,days,months,dic);
C=fun(c,br3,days,months,dic);
System.out.println("SSSSSSSSSSSSSs"+A+B+C);
Statement st = c.createStatement();
symtemp.add(A);
symtemp.add(B);
symtemp.add(C);
ListIterator<Integer> itrsymtemp1=symtemp.listIterator();

while(itrsymtemp1.hasNext())
{
	System.out.println("jj");
	n=itrsymtemp1.next();
	symfin.add(n);
	int i=0;
	while(itrsymtemp1.hasNext())
	{
		n=n|itrsymtemp1.next();
		System.out.println("tttttttttttttttttttttttttt"+n);
		if(!symfin.contains(n))
		symfin.add(n);
		i++;
	}
	while(i!=0)
	{
		itrsymtemp1.previous();
		i--;
	}
}
ListIterator<Integer> itrsymtemp2=symtemp.listIterator();
n=0;
while(itrsymtemp1.hasNext())
{
	n=n|itrsymtemp1.next();
}
ListIterator<Integer> itrsymfin=symfin.listIterator();
	while(itrsymfin.hasNext())
	{
int t=itrsymfin.next();

	ResultSet r2 = st.executeQuery(query2+t);
	while(r2.next())
	{
		//
		//sym=r.getInt(1);
		
	System.out.println(r2.getString(2));
	// System.out.println(contentInBytes);
	}
	}
}
catch (IOException e) {
	e.printStackTrace();
	} finally {
	try {
br1.close();
br2.close();
br3.close();

	} catch (IOException ex) {
	ex.printStackTrace();
	}
	}
}
}
