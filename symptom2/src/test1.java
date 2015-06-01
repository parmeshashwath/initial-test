import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.*;
class outdet
{
	public
		int cnt;
String symptoms;
}

public class test1{
	static String tempstr=" ";
	static int pp=0;
	static List<String> wordList = new ArrayList();
	static void fun(Connection c,BufferedReader br,HashSet days, HashSet months,HashSet dic)
	{
		int n=0;
		 pp++;
		
		String sCurrentLine=" ",temp=" ";
		
			
			
			// System.out.println(contentInBytes);
			
			
		String temp1=" ";
		try
		{
			int sym=0;
			int flag=0;
		while ((sCurrentLine = br.readLine()) != null && flag==0) {
			//wordList.clear();
			//System.out.println(sCurrentLine);
			StringTokenizer tokn = new StringTokenizer(sCurrentLine, " ");
			
			if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
			{
				
				tempstr=sCurrentLine;
				//System.out.println(tempstr);
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
					StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, " ");
			while (tokn2.hasMoreTokens()) {
				temp=tokn2.nextToken();
				//System.out.println(temp);
				if(dic.contains(temp)&& !wordList.contains(temp))
				wordList.add(temp);
				}
			br.mark(1000);
				}
			}
			//
			
	}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}
	public static void main(String ar[])
	{
		String query1 = "SELECT * FROM OUT_SYM WHERE SYM=";
		String query2 = "SELECT * FROM OUT_SYM WHERE OUT=";
		 List<String> wordListA = new ArrayList();
		 List<String> wordListB= new ArrayList();
		 List<String> wordListC = new ArrayList();
		int ch;
		Connection c = null;
		HashSet days = new HashSet();
		HashSet months=new HashSet();
		HashMap<String,outdet> symhash=new HashMap<String,outdet>();
		String temp=" ";
		int n=0;
		int A=0x0000;
		int B=0x0000;
		int C=0x0000;
		

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
		dic.add("s1");
		dic.add("s2");
		dic.add("s3");
		dic.add("s4");
		dic.add("s5");
		outdet ob1=new outdet();
		outdet ob2=new outdet();
		outdet ob3=new outdet();
		outdet ob4=new outdet();
		outdet ob5=new outdet();
		outdet ob6=new outdet();
		
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
		br1.mark(1000);
		br2.mark(1000);
		br3.mark(1000);
		while(br1.readLine()!=null || br2.readLine()!=null || br3.readLine()!=null )
		{	
			br1.reset();
			br2.reset();
			br3.reset();
			ob1.cnt=0;
			ob1.symptoms=" ";
			ob2.cnt=0;
			ob2.symptoms=" ";
			ob3.cnt=0;
			ob3.symptoms=" ";
			ob4.cnt=0;
			ob4.symptoms=" ";
			ob5.cnt=0;
			ob5.symptoms=" ";
			ob6.cnt=0;
			ob6.symptoms=" ";
			
				symhash.put("o1",ob1);
				symhash.put("o2",ob2);
				symhash.put("o3",ob3);
				symhash.put("o4",ob4);
				symhash.put("o5",ob5);
				symhash.put("o6",ob6);
		wordList.clear();
		fun(c,br1,days,months,dic);
		fun(c,br2,days,months,dic);
		fun(c,br3,days,months,dic);
		
		
		
		ListIterator<String> itr=wordList.listIterator();

		while(itr.hasNext())
		{
			outdet obn=null;
			
			temp=itr.next();
			//System.out.println("jj"+temp);
			try
			{
				Statement st = c.createStatement();
			ResultSet r = st.executeQuery(query1+ "'"+temp+"'");
			while(r.next())
			{
				str2=r.getString(1);
			//System.out.println(str2);
			obn=symhash.get(str2);
			
				obn.cnt++;
				
				obn.symptoms=obn.symptoms+temp;
				symhash.put(str2, obn);
			
			// System.out.println("aaaaaaaaa"+sym);
			}
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
		try
		{
			Set set = symhash.entrySet();
			Iterator i = set.iterator();
		      // Display elements
			
			
		      while(i.hasNext()) {
		    	  int v=0;
		         Map.Entry me = (Map.Entry)i.next();
		         
		         outdet u=(outdet)me.getValue();
		         
		         
			Statement st = c.createStatement();
		ResultSet r = st.executeQuery(query2+ "'"+me.getKey()+"'");
		while(r.next())
		{
			v++;
			
		// System.out.println("aaaaaaaaa"+sym);
		}
		System.out.println("************************************"+tempstr);
		System.out.println("Symptoms"+u.symptoms);
		System.out.println("error::"+me.getKey());
		System.out.println((float)u.cnt/v);
		//System.out.println(u.cnt);
		
		
		}
		      System.out.println(pp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
