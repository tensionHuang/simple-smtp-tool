package com.antena.mail.smtp.tool;

import com.antena.mail.smtp.tool.config.ContextConfig;
import com.antena.mail.smtp.tool.sender.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

/**
 * Created by Rickey Huang on 2015/3/4.
 */
public class Main implements CommandLineRunner {

    @Autowired
    MailSender mailSender;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Object[]{Main.class, ContextConfig.class}, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mailSender.send();
    }
}
