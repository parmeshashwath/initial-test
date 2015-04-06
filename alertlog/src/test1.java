import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class test1 {

   public static void main(String args[]) {
      // create a hash set
	   ArrayList<String> wordList = new ArrayList();
		ArrayList<String> keywordList = new ArrayList();
      HashSet days = new HashSet();
      HashSet months=new HashSet();
      int cnt=0;
      // add elements to the hash set
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
      
      int flag=0;
      String sCurrentLine ,temp,tempstr;
      tempstr=" ";
      BufferedReader br = null;
		BufferedWriter bw= null;
		try
		{
			System.out.println("enter keywords");
			InputStreamReader r=new InputStreamReader(System.in);  
			BufferedReader bri=new BufferedReader(r);  
			//String name=bri.readLine();
			while (!(sCurrentLine = bri.readLine()) .equals( "aaa")){
				//System.out.println(sCurrentLine);
				StringTokenizer tokn = new StringTokenizer(sCurrentLine, " ");
				while (tokn.hasMoreTokens()) 
				{
				keywordList.add(tokn.nextToken());
			}
				
				}
		
		br = new BufferedReader(new FileReader("C:/Users/parma/Desktop/AZAD/project1/data/alert_CG1PRD1.log"));
			//br = new BufferedReader(new FileReader("C:/input.txt"));
			//FileOutputStream f = new FileOutputStream("C:/output.txt");
		FileWriter fw = new FileWriter("C:/output.txt");
		bw = new BufferedWriter(fw);
		while ((sCurrentLine = br.readLine()) != null) {
			wordList.clear();
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
						break;
					}
					StringTokenizer tokn2 = new StringTokenizer(sCurrentLine, " ");
			while (tokn2.hasMoreTokens()) {
				temp=tokn2.nextToken();
				//System.out.println(temp);
				wordList.add(temp);
				}
			br.mark(1000);
				}
			for (String str2:keywordList)
			{
				cnt=0;
			for(String str1 :wordList)
				
				{
				
				//while (itr.hasNext()) {
				
					//temp=(String)itr.next();
					if(str1.equalsIgnoreCase(str2))
						cnt=cnt+1;
					
				}
				System.out.println(str2+"    "+cnt+" " +tempstr);
				//bw.write(count[i]);
				bw.write( String.valueOf(cnt) );
				bw.write(' ');
				bw.write(str2);
				bw.write(' ');
				bw.write(tempstr);
				bw.write('\r');
				bw.write('\n');
				
			}
			
			}
   }
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
		
			}
			
	}