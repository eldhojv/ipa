package fileFind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * class to split the file into paragraph and store each paragraph into a file
 */
public class splitParagraph {
	
    
	public void  readFileParagraphs(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = br.readLine();
		    }
		    // Split the content of the file into an array of paragraphs
		    String parags[]= sb.toString().split("\n"); 
		    //Write every paragraph to a new file
		    for (int i=0; i<parags.length;i++) {
		    	String file="Paragraph"+i;
		       // File file = new File("Paragraph_"+i+".txt");
		        File dir=new File("G:\\IPA workspace\\documentsret\\Paragraph");
		        File tagFile=new File(dir,file+".txt");
		        FileWriter writer = new FileWriter(tagFile, false);
		        PrintWriter output = new PrintWriter(writer);
		        output.println(parags[i]);
		        output.close();
		    }
		} finally {
		    br.close();
		}
	}
	
	
}
