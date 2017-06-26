package fileFind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * class to split the paragraph file into sentence and store each sentence into a file
 */
public class splitSentence {
	String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        
	   
	    String a[]=stringBuilder.toString().split("\\.|\\?|\\!");
	    //Write every sentence to a new file
	    for (int i=0; i<a.length;i++) {
	    	String file1="Sentence"+i;
	       // File file = new File("Paragraph_"+i+".txt");
	        File dir1=new File("G:\\IPA workspace\\documentsret\\Sentence");
	        File tagFile1=new File(dir1,file1+".txt");
	        FileWriter writer1 = new FileWriter(tagFile1, false);
	        PrintWriter output = new PrintWriter(writer1);
	        output.println(a[i]);
	        output.close();
	    }
	    return stringBuilder.toString(); 
	}
	    
	    finally {
		    reader.close();
	    }
	    
	}
	
}
