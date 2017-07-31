package org.roberto.spring.email;

import java.util.Vector;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Emailer {

	private JavaMailSender mailSender;
	private Vector<Resource> attachments = new Vector<Resource>();
	private String from;
	private String to;
	private String subject;
	private String text;
	
	public Emailer() {
	}

	public Emailer(String from, String to, String subject, String text) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public Boolean send(){
		Boolean result = false;
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		try{
			helper = new MimeMessageHelper(message, true);
			
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			
			for(int i=0; i<attachments.size(); i++){
				helper.addAttachment(attachments.get(i).getFilename(),attachments.get(i));
			}
			mailSender.send(message);
			attachments.clear();
			result = true;
		}catch(MessagingException e){
			System.err.println("MessagingException :" + e.getMessage());
		}catch(Exception e){
			System.err.println("General Exception :" + e.getMessage());
		}
		
		return result;
	}
	
	public void addAttachment(Resource fileName){
		attachments.add(fileName);
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Emailer [from=" + from + ", to=" + to + ", subject=" + subject + ", text=" + text + "]";
	}
}
