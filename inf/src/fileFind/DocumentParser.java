package fileFind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read documents
  */
public class DocumentParser {

    //This variable will hold all terms of each document in an array.
    private List<String[]> termsDocsArray = new ArrayList<String[]>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();
    private List fileNameList = new ArrayList();//to hold nmae of files
    /**
     * Method to read files and store in array.
     */
    int k=0;
    public void parseFiles(String filePath1,String filePath2) throws FileNotFoundException, IOException {
    	fileNameList.clear();
    	List<File> allfiles = new ArrayList<File>();
    	allfiles.clear();
    	allTerms.clear();
    	termsDocsArray.clear();
    	tfidfDocsVector.clear();
    	for(File f : new File(filePath1).listFiles())
    	{
    	allfiles.add(f);
    	}
        //System.out.println(allfiles);
    	for(File f : new File(filePath2).listFiles())
    	{
    	allfiles.add(f);
    	}
    	
        BufferedReader in = null;
        for (File f : allfiles) {
            if (f.getName().endsWith(".txt")) {
            	fileNameList.add(f.getName());
                in = new BufferedReader(new FileReader(f));
                StringBuilder sb = new StringBuilder();
                String s = null;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                }
                String[] tokenizedTerms = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms
                for (String term : tokenizedTerms) {
                    if (!allTerms.contains(term)) {  //avoid duplicate entry
                        allTerms.add(term);
                    }
                    //System.out.println(allTerms);
                }
                termsDocsArray.add(tokenizedTerms);
            }
           
        }
        System.out.println(termsDocsArray);
    }

    /**
     * Method to create termVector according to its tfidf score.
     */
    public void tfIdfCalculator() {
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term requency inverse document frequency        
        for (String[] docTermsArray : termsDocsArray) {
            double[] tfidfvectors = new double[allTerms.size()];
            int count = 0;
            for (String terms : allTerms) {
                tf = new TfIdf().tfCalculator(docTermsArray, terms);
                idf = new TfIdf().idfCalculator(termsDocsArray, terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
                count++;
            }
            tfidfDocsVector.add(tfidfvectors);  //storing document vectors;            
        }
       // System.out.println(tfidfDocsVector);
    }

    /**
     * Method to calculate cosine similarity between all the documents.
     
     */
    public String getCosineSimilarity() {
    	double max=0.0;
    	//int k = 0;
    	double a[]=new double[fileNameList.size()];
        for (int i = 1; i < fileNameList.size(); i++) {
            	
            		a[i]=(double) (new CosineSimilarity().cosineSimilarity
                            (
                                    tfidfDocsVector.get(i), 
                                    tfidfDocsVector.get(0)
                                  ));
            	
               // System.out.println(a[i]);
               
           
            }
            
        
       // max = a[1];
        for(int i = 1; i < fileNameList.size(); i++)
        {
            if(max < a[i])
            {
                max = a[i];
               
                k=i;
                
            }
        }
        if(max == 0.0)
        {
        	//System.out.println("error");
        	return "not found";
        }
        //System.out.println("Maximum value:"+max);
        //System.out.println(fileNameList.get(k));
        else
        {
        	return (String) fileNameList.get(k);
        
        }
       
        
    }

	/*public String getDocument() {
		// TODO Auto-generated method stub
		return (String) docNameList.get(k-1);	
	}*/
}

