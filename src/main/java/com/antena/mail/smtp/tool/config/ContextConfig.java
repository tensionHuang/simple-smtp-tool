package com.antena.mail.smtp.tool.config;

import com.antena.mail.smtp.tool.sender.MailInfo;
import com.antena.mail.smtp.tool.sender.MailSender;
import com.antena.mail.smtp.tool.util.PropertiesUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rickey Huang on 2015/3/4.
 */
@Configuration
public class ContextConfig {

    @Bean
    public MailSender mailSender() {
        return new MailSender();
    }

    @Bean
    public MailInfo mailInfo() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setTimeout(PropertiesUtil.getString("smtp.mail.timeout"));
        mailInfo.setHost(PropertiesUtil.getString("smtp.mail.host"));
        mailInfo.setPort(PropertiesUtil.getInt("smtp.mail.port"));
        mailInfo.setUsername(PropertiesUtil.getString("smtp.mail.username"));
        mailInfo.setPassword(PropertiesUtil.getString("smtp.mail.password"));
        mailInfo.setSender(PropertiesUtil.getString("smtp.mail.sender.address"));
        mailInfo.setRecipient(PropertiesUtil.getString("smtp.mail.recipient.address"));
        mailInfo.setSsl(PropertiesUtil.getBoolean("smtp.mail.isSSL"));
        return mailInfo;
    }

}
