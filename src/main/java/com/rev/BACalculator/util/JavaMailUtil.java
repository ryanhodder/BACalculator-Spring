package com.rev.BACalculator.util;

import java.util.Properties;
import java.util.logging.Level;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import com.rev.BACalculator.dao.UserDAO;
import com.sun.istack.internal.logging.Logger;

public class JavaMailUtil {
	public static void sendEmail(String recipient) throws Exception {

		System.out.println("Preparing to send email...");

		String myAccountEmail = "jerkins1337@gmail.com";
		String password = "JackieChan420";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		// properties.setProperty("mail.smtp.user", myAccountEmail);
		// properties.setProperty("mail.smtp.password", password);
		// properties.setProperty("mail.smtp.auth", "true");

		System.out.println("Properties set...");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		System.out.println("Session created...");

		Message message = prepareMassage(session, myAccountEmail, recipient);

		System.out.println("Message created and prepared...");

		Transport.send(message);

		System.out.println("Message sent!");
	}

private static Message prepareMassage(Session session, String myAccountEmail, String recipient) { //what goes in the message
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject("Your password details");
                
        String content = "<h2>Hello!</h2>"
                + "<br/>Your request to find your password has been received!"
                + "<br/>"
                + "<br/>Your password is: "
                + "<br/>"
                + "<br/>Best regards,"
                + "<br/>"
                + "<br/>Team Boozy"
                + "<br/>P.S. Don't drink and drive!";
        message.setContent(content, "text/html");
        //message.setText("Hey there, your ");
        return message;
    } catch(Exception e) {
    	System.out.println(e.getMessage());
    	Logger.getLogger(JavaMailUtil.class.getName(), null).log(Level.SEVERE, null);
    }
    return null;
}