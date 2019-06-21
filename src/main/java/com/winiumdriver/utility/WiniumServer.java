package com.winiumdriver.utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WiniumServer {

	/**
	 * This method is used to start the winium server
	 * @throws InterruptedException
	 */
	public static void startWiniumServer() throws InterruptedException {
		
		 try
	        { 
	            String command = System.getProperty("user.dir")+"/Resources/Winium.Desktop.Driver.exe"; 
	            Runtime run  = Runtime.getRuntime(); 
	            Process proc = run.exec(command); 
	            proc.waitFor(20, TimeUnit.SECONDS);
	        } 
	  
	        catch (IOException e) 
	        { 
	            e.printStackTrace(); 
	        } 
	}
}
