/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** 
* User.java
* Created on 6 May, 2017
*/ 

package com.model.user; 

import java.sql.Date;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
abstract public class User { 
    
    /**
     * First Name of the patient.
     */
    
    private String fName;
    
    /**
     * Middle name of the patient.
     */
    
    private String mName;
    
    /**
     * Last name of the patient.
     */
    
    private String lName;
    
    /**
     * Residence address.
     */
    
    private String address;
    
    /**
     * Date of Birth.
     */
    
    private GregorianCalendar dateOfBirth;
    
    /**
     * Phone number.
     */
    
    private String phoneNumber;
    
    /**
     * EMail ID of the user.
     */
    
    private String emailID;
    
    /**
     * true if the account is deactivated, false otherwise.
     */
    
    private boolean deactivated;
    
    /**
     * Login password.
     */
    
    private String password;
    
    /**
     * Gender of the patient.
     */
    
    private boolean gender;
    
    /**
     * Blood Group of the patient.
     */
    
    private String bloodGroup;

    public User(String fName, String mName, String lName, String address, GregorianCalendar dateOfBirth, String phoneNumber, String emailID, String password, boolean gender, String bloodGroup) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.deactivated = false;
        this.password = password;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }
    
    // Getters

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getlName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public boolean isDeactivated() {
        return deactivated;
    }

    public String getPassword() {
        return password;
    }

    public boolean getGender() {
        return gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
    
    public long getDateOfBirthTimeInMillis() {                                 // Since the class extenders need only milliseconds to store date in SQL
        return dateOfBirth.getTimeInMillis();
    }
}