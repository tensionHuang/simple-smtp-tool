package com.antena.mail.smtp.tool.sender;

import org.springframework.stereotype.Component;

/**
 * Created by Rickey Huang on 2015/4/16.
 */
@Component
public class MailInfo {

    private String timeout;
    private String host;
    private int port;
    private String username;
    private String password;
    private String sender;
    private String recipient;
    private boolean ssl;

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username.isEmpty() ? null : username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password.isEmpty() ? null : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    @Override
    public String toString() {
        return "\n=============Mail Info============" +
                "\nhost=" + getHost() +
                "\nport=" + getPort() +
                "\npassword=" + getPassword() +
                "\nusername=" + getUsername() +
                "\nssl=" + isSsl() +
                "\nrecipient=" + getRecipient() +
                "\nsender=" + getSender() +
                "\ntimeout=" + getTimeout() +
                "\n=================================";
    }
}
