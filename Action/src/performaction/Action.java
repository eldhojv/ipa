package performaction;



public class Action {

		
	String intentResponse;
    
	public void processAction(String args) {
        		 

		    	String argscase=args.toLowerCase();
		    	switch(argscase)
		    	{
		    	case "hey computer":
		    		try{
		 		       
		 		       setActResponse("what is it.");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "Are you good":
		    		try{
		 		       
		 		       setActResponse("I am good thanks for asking");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "your names":
		    		try{
		 		       
		 		       setActResponse("call me computer");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "your name":
		    		try{
		 		       
		 		       setActResponse("call me computer");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "do you have name":
		    		try{
		 		       
		 		       setActResponse("I dont have one but you can call me suku");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "do you have names":
		    		try{
		 		       
		 		       setActResponse("I dont have one but you can call me suku");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "how old r u":
		    		try{
		 		       
		 		       setActResponse("No idea first thing i saw was a baby dianosar");
		 		        }
		    		catch(Exception e){}
		    		break;	
		    		
		    	case "close command":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
		 		       setActResponse("closing command");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "command":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start cmd");
		 		       setActResponse("opening windows command");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open photoshop":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start photoshop");
		 		       setActResponse("opening photoshop");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open windows security center":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c wscui.cpl");
		 		       setActResponse("opening windows security center");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open calculator":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start calc");
		 		       setActResponse("opening calculator");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open music players":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start wmplayer");
		 		       setActResponse("opening music player");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open control panel":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start control");
		 		       setActResponse("opening control panel");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open paint":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start mspaint");
		 		       setActResponse("opening paint");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "close paint":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im mspaint.exe /f");
		 		       setActResponse("closing paint");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "close calculator":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im calc.exe /f");
		 		       setActResponse("closing calculator");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    		
		    	case "close browser":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
		 		       setActResponse("closing browser");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open browser":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start chrome.exe");
		 		       setActResponse("opening browser");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "windows task manager":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskmgr.exe");
		 		       setActResponse("opening windows task manager");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    		
		    	case "open website facebook":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.facebook.com");
		 		       setActResponse("opening facebook");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "website google":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.google.com");
		 		       setActResponse("opening google");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open gmail":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start chrome https://mail.google.com");
		 		       setActResponse("opening gmail");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "close task manager":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im taskmgr.exe /f");
		 		       setActResponse("closing taskmanager");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open notepad":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start notepad");
		 		       setActResponse("opening notepad");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    		
		    	case "close notepad":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im notepad.exe /f");
		 		       setActResponse("closing notepad");
		 		        }
		    		catch(Exception e){}
		    		break;
		    	
		    	case "open word":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start winword");
		 		       setActResponse("opening word");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "close word":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im winword.exe /f");
		 		       setActResponse("closing word");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "start wordpad":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c  write");
		 		       setActResponse("opening wordpad");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "stop wordpad":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c  start taskkill /im wordpad.exe /f");
		 		       setActResponse("closing wordpad");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open excel":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start excel");
		 		       setActResponse("opening excel");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "stop excel":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im excel.exe /f");
		 		       setActResponse("closing excel");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open firewall":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start firewall.cpl");
		 		       setActResponse("opening firewall");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	case "open device manager":
		    		try{
		 		        Process p;	
		 		        p = Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
		 		       setActResponse("opening device manager");
		 		        }
		    		catch(Exception e){}
		    		break;
		    		
		    	default:
		    		setActResponse("I dont get it, whether its an action or question. Include question tag");
		    		
		    	}// end of switch
		    			    	
		    }// end of else
	
		    
	public  String getActResponse() {
		return intentResponse;
	}

	public void setActResponse(String intentResponse) {
		this.intentResponse = intentResponse;
	}

 			

    }
