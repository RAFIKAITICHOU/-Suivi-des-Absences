package services;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Classe responsable de l'envoi des emails via SMTP
 * @author ichou
 */
public class EmailSender {

    private static final String FROM_EMAIL = "r.aitichou2678@uca.ac.ma";
    private static final String PASSWORD = "testtesttest111111";

    /**
     * Envoie un email à un destinataire avec un sujet et un contenu donnés
     * @param to Destinataire
     * @param subject Sujet de l'email
     * @param messageText Contenu du message (HTML accepté)
     * @return true si l'envoi est réussi, false sinon
     */
    public static boolean sendEmail(String to, String subject, String messageText) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(FROM_EMAIL));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setContent(messageText, "text/html; charset=UTF-8"); 
            msg.setSentDate(new java.util.Date());

            Transport.send(msg);
            System.out.println("✅ Email envoyé avec succès à " + to);
            return true;
        } catch (MessagingException e) {
            System.err.println("❌ Erreur lors de l'envoi de l'email : " + e.getMessage());
            return false;
        }
    }
}
