import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class enterremove {
public static void main(String[] args){
	BufferedReader br = null;
	
	char ch1,ch2,ch3;
	int ch,chi,chii;
	
	FileWriter outputStream = null;
	char[] cbuf = new char[3];

try {
	outputStream = new FileWriter("C:/characteroutput2.txt");
	br = new BufferedReader(new FileReader("C:/as.csv"));
	//br = new BufferedReader(new FileReader("C:/test_enter.txt"));
	ch = br.read();
	//System.out.println(ch);
	while (ch != -1) {
		
		ch1=(char)ch;
		//System.out.println(ch);
		//System.out.println(ch1);
		if(ch==13 || ch==10){
			
			chi=br.read();
			ch2=(char)chi;
			//System.out.println(chi);
			//chii=br.read();
			//ch3=(char)chi;
			while(chi==10||chi==13)
			{
				
				chi=br.read();
			ch2=(char)chi;
			//chii=br.read();
			//ch3=(char)chii;
			}
			
			br.read(cbuf, 0, 2);
			System.out.println("**************************************");
			System.out.println(ch2);
			System.out.println(cbuf);
			if(ch2=='I' && cbuf[0]=='N' && cbuf[1]=='C'){
				//System.out.print(',');
				//System.out.print(ch2);
				
				outputStream.write(ch1);
				//outputStream.write('\r');
				//if(ch2!='"')
				outputStream.write(ch2);
				//outputStream.write(ch3);
				for(int i=0;i<2;i++)
					//if(cbuf[i]!='"')
				outputStream.write(cbuf[i]);
			}
		
			else
			{
				//System.out.print(ch1);
			//System.out.print(ch2);
//if(ch1!='"')
				outputStream.write(' ');
				if(ch2!='\n' && ch2!= '\r')
					outputStream.write(ch2);
					//outputStream.write(ch3);
					for(int i=0;i<2;i++)
						if(cbuf[i]!='\n' && cbuf[i]!='\r')
					outputStream.write(cbuf[i]);
				
		}
		}
		else{
			//System.out.print(ch1);
			//if(ch1!='"')
			outputStream.write(ch1);
		}
			ch=br.read();
	    //do something 
	
	}
}
	catch (IOException e) {
		e.printStackTrace();
		} finally {
		try {
		if (br != null)
		{
			outputStream.close();
		
		br.close();
		}
		} catch (IOException ex) {
		ex.printStackTrace();
		}
		}
		}
	
}

