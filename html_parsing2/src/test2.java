import java.io.File;  
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  

public class test2 {
	
public static void main(String[] args){
	try {
		Document doc = Jsoup.parse(new File("C:/JAVA WORKSPACE/html_parsing2/WebContent/test.html"),"utf-8");
		//String title=doc.title();
	    //System.out.println(title);
		System.out.println(doc.text());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//assuming register.html file in e drive  
	
}

}
