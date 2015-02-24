import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
public class test {  
     public static void main( String[] args ) throws IOException{
    	 String test1 ="<html><title>test</title><body><h1>azad parmesh</h1></body></html>";
    	 String Test2=Jsoup.parse(test1).text();
    	 System.out.println(Test2);
     }
}