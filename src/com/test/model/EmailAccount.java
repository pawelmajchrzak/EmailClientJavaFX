package com.test.model;

import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {

    private String address;
    private String password;
    private Properties properties;
    private Store store;
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return address;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();
        properties.put("incomingHost", "ssl0.ovh.net");
        properties.put("mail.store.protocol","imaps");
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host","ssl0.ovh.net");
        properties.put("mail.smtps.auth","true");
        properties.put("outgoingHost","ssl0.ovh.net");


    }
}
