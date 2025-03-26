package services;

import com.mysql.cj.Session;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Classe responsable de l'envoi des emails via SMTP
 *
 * @author ichou
 */


public class EmailSender {

    public static void sendEmail(String toEmail, String newPassword) {
        final String username = "contact.a.ichou.rafik@gmail.com";
        final String password = "Cleinfo2025##testProjetJava";
       Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Serveur SMTP de Gmail
        props.put("mail.smtp.port", "587"); // Port pour Gmail

        // creation de la session
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {
            // creation du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Réinitialisation de votre mot de passe");
            message.setText("Votre nouveau mot de passe temporaire est : " + newPassword);

            // envoi du message
            Transport.send(message);

            System.out.println("Email envoyé avec succès.");

        } catch (MessagingException e) {
            throw new RuntimeException("Erreur lors de l'envoi de l'email : " + e.getMessage());
        }
}