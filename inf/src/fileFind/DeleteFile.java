package fileFind;

import java.io.File;

public class DeleteFile 
 {
    public void deleteFiles(String path)
	//public static void main(String[] args)
    { 
		File file = new File(path);      
		   String[] myFiles;    
		       if(file.isDirectory()){
		           myFiles = file.list();
		           for (int i=0; i<myFiles.length; i++) {
		               File myFile = new File(file, myFiles[i]); 
		               //System.out.println(myFiles);
		               myFile.delete();
		           }
		        }
     }
    }