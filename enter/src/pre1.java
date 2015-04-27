import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
public class pre1 {
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
	br = new BufferedReader(new FileReader("C:/pre1.txt"));
	FileWriter fw = new FileWriter("C:/output_pre1.txt");
	bw = new BufferedWriter(fw);
	while ((sCurrentLine = br.readLine()) != null) {
		wordList.clear();
		StringTokenizer tokn = new StringTokenizer(sCurrentLine, " ");
		while(tokn.hasMoreTokens())
		{
			bw.write("\"");
			bw.write(tokn.nextToken());
			bw.write("\"");
			bw.write(",");
					
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