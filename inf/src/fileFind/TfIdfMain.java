package fileFind;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

public class TfIdfMain {
	private String iparesponse;
	String sentence;
    /**
     * Main method 
     * @return 
     */
	
	
	
	
	
    public void  processResponse(String gRes) throws FileNotFoundException, IOException
    {  
    	
    	//stemming stopward elimination and tokenisation
    	String file;
    	//BufferedReader in = null;
    	stemstoptoken sp = new stemstoptoken();
    	//sp.tokenstemstop("G:\\IPA workspace\\documentsret\\Sample\\sample.txt");//call to the function tokenstemstop in class stemstoptoken
    	
    	sp.tokenstemstop(gRes);
    	
    	
    	//end of stemming stopward elimination and tokenisation
    	
    	//delete contents of paragraph and sentence file
    	DeleteFile del = new DeleteFile();
        del.deleteFiles("G:\\IPA workspace\\documentsret\\Paragraph");//call to class DeleteFile to delete paragraph file for each execution
        del.deleteFiles("G:\\IPA workspace\\documentsret\\Sentence");//call to class DeleteFile to delete sentence file for each execution
        //end of deleting
    	
    	//selecting files from document
        DocumentParser dp = new DocumentParser();
        dp.parseFiles("G:\\IPA workspace\\documentsret\\Input","G:\\IPA workspace\\documentsret\\Documents");//call to the function parsFiles in class DocumentParser
        dp.tfIdfCalculator(); //calculates tfidf  //call to the function fIdfCalculator in class DocumentParser
        file=dp.getCosineSimilarity(); //calculated cosine similarity //  call to the function getCosineSimilarity in class DocumentParser
        if(file=="not found")
        {
        	System.out.println("sorry cannot find");
        	setIparesponse("sorry cannot find");
        }
        else
        {
        String path="G:\\IPA workspace\\documentsret\\Documents\\" + file;
        System.out.println(path);
        //end of finding file
        
        //finding paragraph
        splitParagraph par = new splitParagraph();
        par.readFileParagraphs(path);    //split the given file to paragraph
        String file2;
        //ParagraphParser pr = new ParagraphParser();
        dp.parseFiles("G:\\IPA workspace\\documentsret\\Input","G:\\IPA workspace\\documentsret\\Paragraph");
        dp.tfIdfCalculator(); //calculates tfidf
        file2=dp.getCosineSimilarity();//calculated cosine similarity  
        if(file2=="sorry cannot find")
        {
        	System.out.println("not found");
        	setIparesponse("not found");
        }
        else
        {
        String path1="G:\\IPA workspace\\documentsret\\Paragraph\\" + file2;
        System.out.println(path1);
       // end of finding paragraph
        
        
      //finding sentence
        splitSentence sn = new splitSentence();
        sn.readFile(path1);//split the given paragraph into sentence
        String file3;
        //sentenceParser sr = new sentenceParser();
        dp.parseFiles("G:\\IPA workspace\\documentsret\\Input","G:\\IPA workspace\\documentsret\\Sentence");
        dp.tfIdfCalculator(); //calculates tfidf
        file3=dp  .getCosineSimilarity();//calculated cosine similarity 
        if(file2=="not found")
        {
        	System.out.println("sorry cannot find");
        	setIparesponse("sorry cannot find");
        	
        }
        String path2="G:\\IPA workspace\\documentsret\\Sentence\\" + file3;
        System.out.println(path2);
        sentence = sn.readFile(path2);
        System.out.println(sentence);
        setIparesponse(sentence); 
        }
       //end of finding sentence
        
        }
        
    }
    
    
//    public void dummyProcessReponse() throws FileNotFoundException, IOException{
//      processResponse();
//    	setIparesponse(sentence);// change this after the function is ready
//	   	System.out.println(sentence);
//	   	 }

    
		public  String getIparesponse() {
//			System.out.println("getiparesponse output");
//			System.out.println(iparesponse);
			return iparesponse;
		}

		public void setIparesponse(String iparesponse) {
			this.iparesponse = iparesponse;
		}

		

		
    
    
}
