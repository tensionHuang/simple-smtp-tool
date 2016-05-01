package com.antena.mail.smtp.tool;

import com.antena.mail.smtp.tool.config.ContextConfig;
import com.antena.mail.smtp.tool.sender.MailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Rickey Huang on 2015/4/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ContextConfig.class})
public class BaseTest {

    @Autowired
    MailSender mailSender;

    @Test
    public void sendTest() throws Exception {
        mailSender.send();
    }
}
