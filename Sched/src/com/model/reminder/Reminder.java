/** 
* Reminder.java
* Created on 8 May, 2017
*/ 

package com.model.reminder; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import com.model.email.MailApplication;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public abstract class Reminder extends Timer {
    private GregorianCalendar reminderTime;
    private boolean pending;
    private String message;
    private String recipient;
    private String subject;
    private String body;
    
    protected Reminder(GregorianCalendar reminderTime, String message, String recipient, String subject, String body) {
        super();                                                                // Call to timer constructor
        
        this.reminderTime = reminderTime;
        pending = true;
        this.message = message;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        
        this.schedule(new TimerTask() {                                         // Schedule this task to reminder time
            public void run() {
                new MailApplication("nikhilbalwani1998@gmail.com", "<PWD>", recipient, subject, body);
            }
            
        }, reminderTime.getTime());
        
        completeReminder();
    }
    
    public void completeReminder() {
        pending = false;
    }
    
    protected Reminder(String message, String recipient, String subject, String body) {
        new MailApplication("nikhilbalwani1998@gmail.com", "<PWD>", recipient, subject, body);
        completeReminder();
    }
}
