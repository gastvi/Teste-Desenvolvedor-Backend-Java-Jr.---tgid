//package com.br.BackendJavaJr.infra.security;
//
//import java.util.Properties;
//
//import org.apache.logging.log4j.message.Message;
//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
//
//import jakarta.mail.Authenticator;
//import jakarta.mail.MessagingException;
//import jakarta.mail.PasswordAuthentication;
//import jakarta.mail.Session;
//import jakarta.mail.Transport;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeMessage;
//
//public class JavaMailApp {
//	public static void main(String[] args) {
//
//		Properties props = new Properties();
//		/** Parâmetros de conexão com servidor Gmail */
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "465");
//
//		Session session = Session.getDefaultInstance(props, new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("gabriel.viestel22@gmail.com", "suasenha123");
//			}
//		});
//
//		/** Ativa Debug para sessão */
//		session.setDebug(true);
//
//		try {
//
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("gabriel.viestel22@gmail.com"));
//			// Remetente
//
//			InternetAddress[] toUser = InternetAddress // Destinatário(s)
//					.parse("seuamigo@gmail.com");
//
//			message.setRecipients(Message.RecipientType.TO, toUser);
//			message.setSubject("Enviando email com JavaMail");// Assunto
//			message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
//			/** Método para enviar a mensagem criada */
//			Transport.send(message);
//
//			System.out.println("Feito!!!");
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
