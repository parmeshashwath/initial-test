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


public class test4{
	static String tempstr=" ",tempstr2=" ";;
	static int pp=0;
	static BufferedReader br2 = null;
	static BufferedReader br3 = null;
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
			br2 = new BufferedReader(new FileReader("C:/log2.txt"));
			br3 = new BufferedReader(new FileReader("C:/log3.txt"));
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
						tempstr2=sCurrentLine;
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
				fun2(c,br2,days, months,dic,tempstr,tempstr2);
				//fun2(c,br3,days, months,dic,tempstr2);
			}
			//
			
	}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}
	
	
	
	
	static void fun2(Connection c,BufferedReader br,HashSet days, HashSet months,HashSet dic,String timestamp1,String timestamp2)
	{
		String sCurrentLine=" ";
		String qw1,qw2,qw3,qw4,qw5,qw6,qw7,qw8,qw9,temp;
		String qw11,qw21,qw31,qw41,qw51;
		StringTokenizer toknm = new StringTokenizer(timestamp2, ": ");
		
		int wq1=0,wq2=0,wq3=0,flag=0;
		toknm.nextToken();
		toknm.nextToken();
		qw1=toknm.nextToken();
		qw2=toknm.nextToken();
		qw3=toknm.nextToken();
		qw4=toknm.nextToken();
		qw5=qw1+qw2+qw3+qw4;
		wq1=Integer.parseInt(qw5);
	//	System.out.println("wq1:"+ wq1);
StringTokenizer toknm1 = new StringTokenizer(timestamp1, ": ");
		
		int wq11=0,wq21=0,wq31=0,flag1=0;
		toknm1.nextToken();
		toknm1.nextToken();
		qw11=toknm1.nextToken();
		qw21=toknm1.nextToken();
		qw31=toknm1.nextToken();
		qw41=toknm1.nextToken();
		qw51=qw11+qw21+qw31+qw41;
		wq11=Integer.parseInt(qw5);
		try
		{
			
		while((sCurrentLine=br.readLine())!=null)
		{
			StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
			if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
			{
			qw1=tokn.nextToken();
			qw2=tokn.nextToken();
			qw3=tokn.nextToken();
			qw4=tokn.nextToken();
			qw5=qw1+qw2+qw3+qw4;
			wq2=Integer.parseInt(qw5);
			//System.out.println("wq2:"+ wq2);
			if(wq2>wq1-100)
			{
				//flag=1;
				//System.out.println("aqaqaqaqaqaqaqa");
				br.mark(100000);
			}
			while ((sCurrentLine = br.readLine()) != null) {
				
				StringTokenizer tokn1 = new StringTokenizer(sCurrentLine, ": ");
				
				if(tokn1.countTokens()>2 && days.contains(tokn1.nextToken()) && months.contains(tokn1.nextToken()))
				{
					//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					qw1=tokn1.nextToken();
					qw2=tokn1.nextToken();
					qw3=tokn1.nextToken();
					qw4=tokn1.nextToken();
					qw5=qw1+qw2+qw3+qw4;
					wq3=Integer.parseInt(qw5);
					if(wq3<wq11+100 )
					{
						br.reset() ;
						break;
					}
					
					
					
					
					
				}
				StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, " ");
		while (tokn2.hasMoreTokens()) {
			temp=tokn2.nextToken();
			//System.out.println(temp);
			if(dic.contains(temp)&& !wordList.contains(temp))
			wordList.add(temp);
			}
		
			}
			}
			
		}
		//System.out.println("q1q1q1qq"+ wq1+")))"+wq3);
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
		int id;
		Connection c = null;
		HashSet days = new HashSet();
		HashSet months=new HashSet();
		HashMap<outkey,outdet> symhash=new HashMap<outkey,outdet>();
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
		outdet obv1=new outdet();
		outdet obv2=new outdet();
		outdet obv3=new outdet();
		outdet obv4=new outdet();
		outdet obv5=new outdet();
		outdet obv6=new outdet();
		outdet obv7=new outdet();
		outdet obv8=new outdet();
	
			
		
		outkey obk1=new outkey();
		outkey obk2=new outkey();
		outkey obk3=new outkey();
		outkey obk4=new outkey();
		outkey obk5=new outkey();
		outkey obk6=new outkey();
		outkey obk7=new outkey();
		outkey obk8=new outkey();
		
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
		
		br1.mark(1000);
	//	br2.mark(1000);
		//br3.mark(1000);
		//while(br1.readLine()!=null || br2.readLine()!=null || br3.readLine()!=null )
			while(br1.readLine()!=null)
		{	
				
			br1.reset();
			//br2.reset();
			//br3.reset();
			obv1.cnt=0;
			obv1.symptoms=" ";
			obv2.cnt=0;
			obv2.symptoms=" ";
			obv3.cnt=0;
			obv3.symptoms=" ";
			obv4.cnt=0;
			obv4.symptoms=" ";
			obv5.cnt=0;
			obv5.symptoms=" ";
			obv6.cnt=0;
			obv6.symptoms=" ";
			obv7.cnt=0;
			obv7.symptoms=" ";
			obv8.cnt=0;
			obv8.symptoms=" ";
			
			
			obk1.grp=1;
			obk1.outcome="o1";
			obk2.grp=2;
			obk2.outcome="o1";
			obk3.grp=1;
			obk3.outcome="o2";
			obk4.grp=1;
			obk4.outcome="o3";
			obk5.grp=1;
			obk5.outcome="o4";
			obk6.grp=1;
			obk6.outcome="o5";
			obk7.grp=1;
			obk7.outcome="o6";
			obk8.grp=1;
			obk8.outcome="o7";
				symhash.put(obk1,obv1);
				symhash.put(obk2,obv2);
				symhash.put(obk3,obv3);
				symhash.put(obk4,obv4);
				symhash.put(obk5,obv5);
				symhash.put(obk6,obv6);
				symhash.put(obk7,obv7);
				symhash.put(obk8,obv8);
		wordList.clear();
		fun(c,br1,days,months,dic);
		//fun(c,br2,days,months,dic);
		//fun(c,br3,days,months,dic);
		
		
		
				
		
		ListIterator<String> itr=wordList.listIterator();

		while(itr.hasNext())
		{
			outdet obnv=null;
			outkey obnk=new outkey();
			temp=itr.next();
			//System.out.println("jj"+temp);
			try
			{
				Statement st = c.createStatement();
			ResultSet r = st.executeQuery(query1+ "'"+temp+"'");
			while(r.next())
			{
				str2=r.getString(1);
				
				id=r.getInt(3);
				
				obnk.grp=id;
				obnk.outcome=str2;
				
			obnv=symhash.get(obnk);
			//System.out.println("##############################");
			//System.out.println(obnv.symptoms+obnv.cnt);
				obnv.cnt++;
				
				obnv.symptoms=obnv.symptoms+temp;
				symhash.put(obnk, obnv);
			
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
		         outkey y=(outkey)me.getKey();
		         
			Statement st = c.createStatement();
			//System.out.println("SELECT * FROM OUT_SYM WHERE OUT="+ "'"+y.outcome+"'"+ "AND"+"ID= "+y.grp);
		ResultSet r = st.executeQuery("SELECT * FROM OUT_SYM WHERE OUT="+ "'"+y.outcome+"'"+ " AND "+"ID= "+y.grp);
		while(r.next())
		{
			v++;
			
		// System.out.println("aaaaaaaaa"+sym);
		}
		if(v!=0)
		{
		System.out.println("************************************"+tempstr+"************************************");
		System.out.println("Symptoms"+u.symptoms);
		System.out.println("error::"+y.outcome);
		System.out.println((float)u.cnt/v);
		//System.out.println(u.cnt);
		}
		
		}
		    //  System.out.println(pp);
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
		

			} catch (IOException ex) {
			ex.printStackTrace();
			}
			}
		}
		}
