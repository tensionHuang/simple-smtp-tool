package com.antena.mail.smtp.tool.sender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Rickey Huang on 2015/4/16.
 */
@Component
public class MailSender {

    private static final Logger log = LogManager.getLogger(MailSender.class);

    @Autowired
    MailInfo mailInfo;

    private Session session;
    private Transport transport;

    public void send() throws MessagingException {

        log.info(mailInfo.toString());
        Properties properties = initProperties();
        session = Session.getInstance(properties, null);
        MimeMessage message = initMessage();
        connectAndSendMail(message);
    }

    private void connectAndSendMail(MimeMessage message) throws MessagingException {
        try {
            log.info("connect to mail server......");
            transport = session.getTransport("smtp");
            transport.connect(mailInfo.getHost(), mailInfo.getPort()
                    , mailInfo.getUsername(), mailInfo.getPassword());
            if (transport.isConnected()) {
                log.info("sending mail");
                transport.sendMessage(message, message.getAllRecipients());
            }
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
    }

    private Properties initProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.connectiontimeout", mailInfo.getTimeout());
        properties.put("mail.smtp.timeout", mailInfo.getTimeout());
        if (mailInfo.isSsl()) {
            properties.put("mail.smtp.host", mailInfo.getHost());
            properties.put("mail.smtp.starttls.enable", "true");
        } else {
            properties.put("mail.smtp.host", mailInfo.getHost());
        }
        return properties;
    }

    private MimeMessage initMessage() throws MessagingException {

        MimeMessage message = new MimeMessage(session);
        message.setSubject("Mail Test");
        message.setSentDate(new Date());
        message.setText("Just saying Hi.");
        message.setFrom(new InternetAddress(mailInfo.getSender(), false));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(mailInfo.getRecipient(), false));
        return message;
    }

}
