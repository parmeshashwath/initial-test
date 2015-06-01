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
class outkey{
	String outcome;
	int grp;
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof outkey) {
            return outcome.equals(((outkey)obj).outcome) && grp==((outkey)obj).grp;
        }
        return false;
    }

    @Override
    public int hashCode() {
    	return Integer.valueOf(grp).hashCode()+(outcome).hashCode();
    }
}

public class test2{
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
		outdet testv=new outdet();
			
		
		outkey obk1=new outkey();
		outkey obk2=new outkey();
		outkey obk3=new outkey();
		outkey obk4=new outkey();
		outkey obk5=new outkey();
		outkey obk6=new outkey();
		outkey obk7=new outkey();
		outkey obk8=new outkey();
		outkey testk=new outkey();
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
		fun(c,br2,days,months,dic);
		fun(c,br3,days,months,dic);
		
		testk.grp=1;
		testk.outcome="o1";
		testv=symhash.get(testk);
		
				
		
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
		System.out.println("************************************"+tempstr);
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
		br2.close();
		br3.close();

			} catch (IOException ex) {
			ex.printStackTrace();
			}
			}
		}
		}
