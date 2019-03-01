/** 
* SampleMailApplication.java
* Created on 8 May, 2017
*/ 

package com.model.email; 

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class MailApplication implements Runnable {
    
    private volatile boolean exit = false;
    
    private String senderEmailAddress;
    private String senderPassword;
    private String receiverEmailAddress;
    private String subject;
    private String message;
    
    Thread t;

    public MailApplication(String senderEmailAddress, String senderPassword, String receiverEmailAddress, String subject, String message) {
        this.senderEmailAddress = senderEmailAddress;
        this.senderPassword = senderPassword;
        this.receiverEmailAddress = receiverEmailAddress;
        this.subject = subject;
        this.message = message;
        
        t = new Thread(this);
        t.start();
    }
    
    public void run() {
        Mailer.send(senderEmailAddress, senderPassword, receiverEmailAddress, subject, message);
        t.stop();
        System.out.println("Maza nahi aya!");
    }
    
    public void stop() {
        exit = true;
    }
    
    public static void main(String[] args) {
        new MailApplication("nikhilbalwani1998@gmail.com", "Cheshirecat1!", "nikhil.b.btechi16@ahduni.edu.in", "Test again", "nikhil");
    }
}
