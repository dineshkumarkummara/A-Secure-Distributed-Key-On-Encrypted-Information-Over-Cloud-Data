
package com.supportclass;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTP_CreateDirecoryOnCloud 
{
	 
    public static boolean createDirectoryOnCloud(String directoryToCreate)
    {
    	String server = "ftp.drivehq.com";
        int port = 21;//Port Number Any Thing
        String user = "blrstore1";
        String pass = "*blrstore123";
        //String rootDirectory="/"+"folderNameToCreate";//It will create the folder on cloud root directory
        String dirToCreate = "Cloud_Mona/"+directoryToCreate;//create a direcory inside PHR_Records folder
       
        //String dirToCreate = directoryToCreate;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server,port);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return true;
            }
            boolean success = ftpClient.login(user,pass);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return true;
            }
            // Creates a directory
            success = ftpClient.makeDirectory(dirToCreate);
           
//            /* Now inside username directory,create one more directory for SupportFiles (Starts)*/
//	            String supportFileDir = dirToCreate+"/EncryptFiles";
//	            success = ftpClient.makeDirectory(supportFileDir);
//            /* Now inside username directory,create one more directory for SupportFiles (Ends)*/
//            
           System.out.println(" ftpClient : "+ftpClient);
            showServerReply(ftpClient);
            if (success) {
                System.out.println("Successfully created directory: " + dirToCreate);
            } else {
                System.out.println("Failed to create directory. See server's reply.");
            }
            // logs out
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        }
        
        return true;
    }
    
    private static void showServerReply(FTPClient ftpClient)
	 {
	        String[] replies = ftpClient.getReplyStrings();
	        if (replies != null && replies.length > 0) 
	        {
	            for (String aReply : replies) 
	            {
	                System.out.println("SERVER: " + aReply);
	            }
	        }
	}
    
    public static void main(String[] args)
    {
    	String folder ="Hi";
    	FTP_CreateDirecoryOnCloud.createDirectoryOnCloud(folder);
		
	}
}
