package edu.esprit.managedBeans;

import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class MailBean {

	public String msg;
	public String name;
	public String subject;
	public String mailAddress;

	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public void sendMail() {
		final String username = "admegovernment@gmail.com";
		final String password = "dreamteam";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("aa@aa.aa"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject("Sujet");
			message.setText(name+" : <"+mailAddress+"> \n\n\n" + msg);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
