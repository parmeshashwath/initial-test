import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
class tu{
	public
	 String [] msa;
	tu(int N)
	{
		msa=new String[N];
	}
	
}
public class test1 {
public static void main(String[] args){
	
int N=3;
	 List<String> wordList = new ArrayList();
	BufferedReader br = null;
	BufferedWriter bw=null;
	String sCurrentLine;
	char ch1,ch2,ch3;
	int ch,chi,chii;
	String temp=" ";
	FileWriter outputStream = null;
	char[] cbuf = new char[3];
String tempstr=" ";
try {
	//outputStream = new FileWriter("C:/characteroutput2.txt");
	br = new BufferedReader(new FileReader("C:/characteroutput2.txt"));
	FileWriter fw = new FileWriter("C:/output_enter.txt");
	bw = new BufferedWriter(fw);
	while ((sCurrentLine = br.readLine()) != null) {
		wordList.clear();
		StringTokenizer tokn = new StringTokenizer(sCurrentLine, "^");
		int i=0;
		int flag=0;
		while(tokn.hasMoreTokens() && i<2)
		{
			if(i==0)
				tempstr=tokn.nextToken();
			else
		tokn.nextToken();
		i++;
		flag=1;
		}
		if(flag==1 && tokn.hasMoreTokens())
		{
		String imp=tokn.nextToken();
		StringTokenizer tokn2 = new StringTokenizer(imp, " ");
		while (tokn2.hasMoreTokens()) {
			temp=tokn2.nextToken();
			//System.out.println(temp);
			wordList.add(temp);
			}
		StopWordRemove.stopwordRemove(wordList);
		/*ListIterator<String> itrt1=wordList.listIterator();
		while(itrt1.hasNext())
		{
			//System.out.println(itrt1.next());
		}*/
		while(wordList.size()<=3)
		{
			wordList.add(" ");
		}
		ListIterator<String> itr=wordList.listIterator();
		flag=0;	
		int h=(int)Math.ceil(wordList.size()-(N-1));
		System.out.println(h);
		tu[] ss=new tu[h];
		for( int q=0; q<h; q++ )
		    ss[q] = new tu(N);
		int ii=0;
		while(wordList.size()>=itr.nextIndex()+N)
		{
			
			//System.out.println(wordList.size());
			/*tempc=itr.next();
		temp1=itr.next();
		temp2=itr.next();*/
		for(int jj=0;jj<3;jj++)
		{
			//System.out.println(itr.next());
			ss[ii].msa[jj]=itr.next();
		}
		
		ii++;
		itr.previous();
		itr.previous();
		//System.out.println(itr.nextIndex());
		}
		//System.out.println(ii);
		System.out.println("aaaaaaaaaaaa");
		bw.write("**************************************************************");
		bw.write(tempstr);
		bw.write("**************************************************************");
		bw.write('\n');
		for(int k=0;k<ii;k++)
		{
			bw.write("[");
			for(int jj=0;jj<N;jj++)
			{
				System.out.println(ss[k].msa[jj]);
				
				bw.write(ss[k].msa[jj]);

				bw.write('\t');
				//bw.write('\r');
			}
			bw.write("]");
			System.out.println();
			bw.write('\n');
			//bw.write('\r');
			System.out.println();
			/*bw.write('\n');
			bw.write('\r');
			System.out.println();
			bw.write('\n');
			bw.write('\r');*/
		}
	}
}
}
catch (IOException e) {
	e.printStackTrace();
	} finally {
	try {
	if (br != null)
	{
		
	bw.close();
	br.close();
	}
	} catch (IOException ex) {
	ex.printStackTrace();
	}
	}
}
}