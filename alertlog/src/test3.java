import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test3
{
	public static void main(String agr[])
	{
		oraerrors_2 ob1=new oraerrors_2("ORA-6512",'L',"This error is caused by the stack being unwound by unhandled exceptions in your PLSQL code.");
		oraerrors_2 ob2=new oraerrors_2("ORA-20001",'L',"Error fetching column value");
		oraerrors_2 obk=new oraerrors_2("kill",'H',"Oracle sessions getting killed");
		int foo=0;
		int foo1=99;
		char sever=' ';
		String str1=" ";
		String description=" ";
		String msg=" ";
		String n1=" ";
		int n2=0;
		String temp1="";
		String tempr=" ";
		String tempi=" ";
		HashSet days = new HashSet();
	      HashSet months=new HashSet();
	      HashSet results=new HashSet();
	      HashMap<String,Integer> symnew=new HashMap<String,Integer>(); 
	      HashSet dic=new HashSet();
	      int tempint;
	      int cnt=0;
	      // add elements to the hash set
	      dic.add("ORA-6512");
	      dic.add("ORA-20001");
	      dic.add("Kill");
	      days.add("Sun");
	      days.add("Mon");
	      days.add("Tue");
	      days.add("Wed");
	      days.add("Thur");
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
		HashSet<oraerrors_2> sym = new HashSet<oraerrors_2>();
		
		ArrayList<String> wordList = new ArrayList();
		sym.add(ob1);
		sym.add(ob2);
		sym.add(obk);
		//System.out.println("@@@@@@@@@@"+sym.size());
		int flag=0;
	      String sCurrentLine ,temp,tempstr;
	      tempstr=" ";
	      BufferedReader br = null;
			BufferedWriter bw= null;
			BufferedWriter bw1= null;
			try
			{
				
			
			br = new BufferedReader(new FileReader("C:/Users/parma/Desktop/AZAD/project1/data/alert_CG1PRD1.log"));
				//br = new BufferedReader(new FileReader("C:/input_e.txt"));
				//FileOutputStream f = new FileOutputStream("C:/output.txt");
			FileWriter fw = new FileWriter("C:/outputt.txt");
			bw = new BufferedWriter(fw);
			FileWriter fw1 = new FileWriter("C:/oraerrors.txt");
			bw1 = new BufferedWriter(fw1);
			while ((sCurrentLine = br.readLine()) != null) {
				wordList.clear();
				//System.out.println(sCurrentLine);
				StringTokenizer tokn = new StringTokenizer(sCurrentLine, ": ");
				
				if(tokn.countTokens()>2 && days.contains(tokn.nextToken()) && months.contains(tokn.nextToken()))
				{
					
					tempstr=sCurrentLine;
					System.out.println(tempstr);
				//	continue;
					br.mark(1000);
					while ((sCurrentLine = br.readLine()) != null) {
						
						StringTokenizer tokn1 = new StringTokenizer(sCurrentLine, ": ");
						
						if(tokn1.countTokens()>2 && days.contains(tokn1.nextToken()) && months.contains(tokn1.nextToken()))
						{
							//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
							br.reset();
							break;
						}
						StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, ": ");
				while (tokn2.hasMoreTokens()) {
					temp=tokn2.nextToken();
					System.out.println(temp);
					wordList.add(temp);
					}
				br.mark(1000);
					}
					int pp=0;
					for(oraerrors_2 ob4:sym)
					{
						
						pp++;
						cnt=0;
msg="in file description::"+" ";
						flag=0;
Iterator<String> itr=wordList.iterator();
//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
tempi=itr.next();
				while(itr.hasNext())
				{
			//System.out.println("a");
	str1=tempi;			
	if(str1.length()>=4 && (temp1=str1.substring(0,4)).equalsIgnoreCase(ob4.s))
	{
		//System.out.println("kill");
			cnt++;
			n1=temp1;
			
		description=ob4.des;
		sever=ob4.sev;
		flag=1;
			while(itr.hasNext())
			{
				tempi=itr.next();
				
				
				
									if(dic.contains(tempi)){
										
									msg=msg+"^";
										break;
									}
									else
									{
										msg=msg+" "+tempi;
									}
											
			}
				
//break;
		
	}
				
					
					
					
	else if(str1.length()>4 && (temp1=str1.substring(0,4)).equalsIgnoreCase("ORA-")){
						temp=str1.substring(4);
						//System.out.println("********************************");
					foo = Integer.parseInt(temp);
					//System.out.println(temp1+foo+" " +tempstr);
						//ob3=new oraerrors(temp1,foo,' '," ");
		if(ob4.s.length()>4)
		{
			String ww=ob4.s.substring(4);
			 foo1=Integer.parseInt(ww);
		
						if(temp1.equalsIgnoreCase(ob4.s.substring(0,4)) && foo==foo1 )
						{
					//		System.out.println(foo);
							cnt++;
							n1=ob4.s;
							
						description=ob4.des;
						sever=ob4.sev;
						flag=1;
							while(itr.hasNext())
							{
								tempi=itr.next();
								
								
								
													if(dic.contains(tempi)){
														
													msg=msg+"^";
														break;
													}
													else
													{
														msg=msg+" "+tempi;
													}
															
							}
								
				//break;
						}
						else if(pp==1) 
						{
							if(symnew.containsKey(temp1+temp))
							{
								tempint=symnew.get(temp1+temp)+1;
								symnew.put(temp1+temp,tempint);
							}
							else
							{
								symnew.put(temp1+temp, 1);
							}
								tempi=itr.next();
							
						}
						else
							tempi=itr.next();
					
					
				}
		else if(pp==1) 
		{
			if(symnew.containsKey(temp1+temp))
			{
				tempint=symnew.get(temp1+temp)+1;
				symnew.put(temp1+temp,tempint);
			}
			else
			{
				symnew.put(temp1+temp, 1);
			}
				tempi=itr.next();
			
		}
		else
			tempi=itr.next();
	
}				else
				    tempi=itr.next();
				
				}
				//System.out.println(flag);
					if(flag==1)
					{
						tempr=tempstr+"*"+n1+"*"+description+"*"+sever+ "*"+cnt + "*"+msg ;
						//System.out.println(tempr);
						bw.write(tempr);
						bw.write('\n');
						bw.write('\r');
					}
	   }
	}
			}
			/*for(oraerrors_2 ob4:sym)
			{
				int r=ob4.i;
				String ss=String.valueOf(r);
				String sss=ob4.s+ss;
				//System.out.println(":::::::: "+sss);
				if(symnew.containsKey(sss))
				{
					//System.out.println("a");
					symnew.remove(sss);
				}
			}*/
			
			}
			catch (IOException e) {
				e.printStackTrace();
				} finally {
				try {
				if (br != null)
				br.close();
				bw.close();
			
				} catch (IOException ex) {
				ex.printStackTrace();
				}
				}
			Set set = symnew.entrySet();
			Iterator i = set.iterator();
		      // Display elements
			try
			{
		      while(i.hasNext()) {
		         Map.Entry me = (Map.Entry)i.next();
		         System.out.print(me.getKey() + ": ");
		         System.out.println(me.getValue());
		         bw1.write(me.getKey() + ": ");
		         bw1.write(String.valueOf(me.getValue()));
		         bw1.write('\n');
		         bw1.write('\r');
		         
				}
				
	}
			catch (IOException e) {
				e.printStackTrace();
				} finally {
				try {
				bw1.close();
			
				} catch (IOException ex) {
				ex.printStackTrace();
				}
				}
			
	
}
}
