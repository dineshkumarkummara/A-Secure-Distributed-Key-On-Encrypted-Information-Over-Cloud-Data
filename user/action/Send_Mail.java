package com.user.action;



import java.io.File;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import javax.mail.internet.*;

public class Send_Mail
{
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
   
	public static boolean sendPersonalizedMail(String recipient, String subject,String message)  
	{
		boolean debug = true;
		String from="internsangular@gmail.com";
		try
		{
			
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");
			

			Session session = Session.getInstance(props,	new javax.mail.Authenticator() 
			{
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication("internsangular@gmail.com", "internship");
				}
			});

			session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(from);
			msg.setFrom(addressFrom);
		
			InternetAddress addressTo = new InternetAddress();

		
				addressTo = new InternetAddress(recipient);


			msg.setRecipient(Message.RecipientType.TO, addressTo);

			// Setting the Subject and Content Type
			
			msg.setSubject(subject);
			msg.setText(message);
		
			  
			       Transport.send(msg);
		}
		catch(Exception e)
		{
			System.out.println(e);
			 debug = false;
		}		
		return debug;
	}
	
	

}
