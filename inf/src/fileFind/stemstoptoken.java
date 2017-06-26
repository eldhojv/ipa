package fileFind;
import java.util.StringTokenizer;  
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.List;
import java.io.*;

//import java.util.regex.Pattern;
import org.tartarus.snowball.*;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;


public class stemstoptoken
{  
	
// public void tokenstemstop(String filePath)
// {
//     //ArrayList<String> tokens = new ArrayList<String>();
//     tokenize(filePath);
//     
//    
//     
//     
// }


public static void tokenstemstop(String googleResponse)
{
	// tagTextToFile textObject = new tagTextToFile();
     ArrayList<String> al = new ArrayList<String>();
     ArrayList<String> demo = new ArrayList<String>();
     
     try
     {
     //FileReader fr=new FileReader(filePath1);
     //BufferedReader br= new BufferedReader(fr);
    
    // System.out.println("Enter a sentence to tokenize: ");
    // Scanner scanner = new Scanner(System.in);
     String msg = googleResponse;
    // System.out.println("google response obtained from stemclass:");
     //System.out.println(msg);
     
    
     StringTokenizer st = new StringTokenizer(msg," ");// creating string tokenizer
     while(st.hasMoreTokens())
      {
       String[] tokenArray = {st.nextToken()}; // checking next token
       for( int i = 0; i < tokenArray.length; i++)
        {
           
          al.add(tokenArray[i]); 
        }
      } //end of while

     }
     catch(Exception ex)
     {
         System.out.println(ex);
     } 
//   for (String demostr : al)
//     {
//         System.out.print(demostr+" ");
//     }   
//   
     
     
//stopword removal
     String sCurrentLine;
     int k=0;
     String[] stopwords = new String[319];
       //String[] stopwords = {"and","is","who"};
     try
     {
             FileReader fr1=new FileReader("G:\\IPA workspace\\documentsret\\stopwords.txt");
             BufferedReader br1= new BufferedReader(fr1);
             while ((sCurrentLine = br1.readLine()) != null)
             {
                 stopwords[k]=sCurrentLine;
                 k++;
             }  
             
             for(int ii = 0; ii < al.size(); ii++)
             {
                 for(int jj = 0; jj < k; jj++)
                 {
                     if(al.get(ii).toLowerCase().equals(stopwords[jj]))
                     {
                         al.remove(ii);
                     }
                 }
             }
             /* to print stopword removed words
             for (String str : al)
             {
                 System.out.print(str+" ");
             }   
            */
        
      }
     catch(Exception ex)
         {
             System.out.println(ex);
         } 
  
  // end of tokenization
     
 // stemming start
     try
     {
     //for(int i = 0; i < al.size(); i++)
     //{
         for (String str : al)
         {
             //str=EnglishSnowballStemmerFactory.getInstance().process(str);
        	 
             //System.out.print(str +" ");
             //writing str to arraylist
             demo.add(str);  // demo is the arraylist contaning stemmed words
             
         } 
         
     //}
   // @SuppressWarnings("resource")
	FileWriter writer = new FileWriter("G:\\IPA workspace\\documentsret\\Input\\input.txt",false); 
     String token = " ";
     for (String demostr : demo)
     {
    	token = demostr +" ";
        //System.out.print(token);	
        
    	 writer.write(token + " ");
         //System.out.print(demostr+" ");
        
     }  
     //System.out.print(token);
     writer.close();
     
     //textObject.parseIt();
     
     }
     catch(Exception ex)
     {
         System.out.println(ex);
     } 
     
 // end of stemming  
  
  
}//end of function tokenize


private static String String(String string) {
	// TODO Auto-generated method stub
	return null;
}



}// end of class stemstoptoken