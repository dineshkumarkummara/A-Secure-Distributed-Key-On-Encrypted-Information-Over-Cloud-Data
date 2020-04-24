package com.supportclass;

import java.io.File;
import java.util.Properties;

import javax.mail.*;

import java.util.*;
import javax.mail.internet.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;


public class CL_SendMail
{
	
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	 	 
	 public static final boolean sendMail(String[] emailaddress, final String fromemailid,final String password,String subject,String message, String attachfilepath,String hostname,String portnumber)  
		{
	    	String[] recipients=new String[emailaddress.length];
	    		    	
	    	int count=0;
	    	
	    	for(int i=0;i<emailaddress.length;i++)
	    	{
	    		if(emailaddress[i].equals(""))
	    		{
	    			
	    		}
	    		
	    		else
	    		{
	    			count++;
	    			recipients[i]=emailaddress[i];
	    		}
	    	 		
	    	}
	        	    	
	    	System.out.println(count);
	    	    	
			System.out.println("Total Number of Recepients is "+count);
			System.out.println("Subject "+subject.trim());
			System.out.println("Message "+message.trim());
			System.out.println("From "+fromemailid.trim());
		
			boolean debug = true;
			boolean flag=true;
			
					
			Properties props = new Properties();
			props.put("mail.smtp.host", hostname);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.put("mail.smtp.port", portnumber);
			props.put("mail.smtp.socketFactory.port", portnumber);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");
			
			

			Session session = Session.getInstance(props,new javax.mail.Authenticator() 
			{
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
				{
					return new javax.mail.PasswordAuthentication(fromemailid, password);
				}
			});

			session.setDebug(debug);
			
			Message msg = new MimeMessage(session);
			InternetAddress addressFrom=null;
			
			try 
			{
				addressFrom = new InternetAddress(fromemailid);
				
				msg.setFrom(addressFrom);
				
				InternetAddress[] addressTo = new InternetAddress[count];

				for (int i = 0; i < count; i++) 
				{
				addressTo[i] = new InternetAddress((String) recipients[i]);
				}
				
				msg.setRecipients(Message.RecipientType.BCC, addressTo);
				
				msg.setSubject(subject);
				
				msg.setText(message);
				
				msg.setContent(message, "text/html");
				
				if(attachfilepath!="")
				{
					
					System.out.println("Filename is "+attachfilepath);
					
					BodyPart messageBodyPart = new MimeBodyPart();
					//messageBodyPart.setText(message);
					messageBodyPart.setContent(message, "text/html");
				    Multipart multipart = new MimeMultipart();
				    multipart.addBodyPart(messageBodyPart);
				    messageBodyPart = new MimeBodyPart();
				    
				    DataSource source = new FileDataSource(attachfilepath);
				    messageBodyPart.setDataHandler(new DataHandler(source));
				    
				    messageBodyPart.setFileName(attachfilepath);
				    multipart.addBodyPart(messageBodyPart);
				    msg.setContent(multipart);
				    
					
				}
				
			
			
			Transport.send(msg);
			
			}
			catch (AddressException e1) 
			{
						
				flag=false;
			}
		
			catch (MessagingException e1) 
			{
				
					flag=false;
					//e2.printStackTrace();
					//TestLog.writeException(e2);
				
			}
			return flag;
			
			
		}
	 
	 public static final boolean sendPersonalizedMail(String emailid,final String fromemailid,final String password,String subject,String message, String attachfilepath,String hostname,String portnumber)  
		{
		 
		 			
			System.out.println("Subject "+subject.trim());
			System.out.println("Message "+message.trim());
			System.out.println("From "+fromemailid.trim());
			
		
			boolean debug = true;
			boolean flag=true;
			
					
			Properties props = new Properties();
			
			props.put("mail.smtp.host", hostname);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.put("mail.smtp.port", portnumber);
			props.put("mail.smtp.socketFactory.port", portnumber);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");
			
			Session session = Session.getInstance(props,new javax.mail.Authenticator() 
			{
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() 
				{
					return new javax.mail.PasswordAuthentication(fromemailid, password);
				}
			});

			session.setDebug(debug);
			Message msg = new MimeMessage(session);
			InternetAddress addressFrom=null;
				
			
		 		
		 		try 
				{
					addressFrom = new InternetAddress(fromemailid);
					
					msg.setFrom(addressFrom);
					
					InternetAddress addressTo=new InternetAddress();
					
					addressTo.setAddress(emailid);
					
					msg.setRecipient(Message.RecipientType.BCC, addressTo);
								
					msg.setSubject(subject);
					
										
					msg.setText(message);
							
					msg.setContent(message, "text/html");
					
					
					if(attachfilepath!="")
					{
						
						System.out.println("Filename is "+attachfilepath);
						
						File file = new File(attachfilepath);
						String name = file.getName();
						
						BodyPart messageBodyPart = new MimeBodyPart();
						//messageBodyPart.setText(message);
						messageBodyPart.setContent(message, "text/html");
					    Multipart multipart = new MimeMultipart();
					    multipart.addBodyPart(messageBodyPart);
					    messageBodyPart = new MimeBodyPart();
					    
					    DataSource source = new FileDataSource(attachfilepath);
					    messageBodyPart.setDataHandler(new DataHandler(source));
					    
					    messageBodyPart.setFileName(name);
					    multipart.addBodyPart(messageBodyPart);
					    msg.setContent(multipart);
					    
					}	
				
				Transport.send(msg);
				
				}
				catch (AddressException e1) 
				{
							
					flag=false;
				}
			
				catch(SendFailedException sendingfailed)
				{
					flag=false;
					//Address[] invalidaddress=sendingfailed.getInvalidAddresses();
					
					//System.out.println("Total Number of Invalid Address "+invalidaddress);
					
				}
				catch (MessagingException e1) 
				{
					
						flag=false;
						//e2.printStackTrace();
						//TestLog.writeException(e2);
					
				}
				
		 	
			return flag;
			
			
		}
	 

}
