/** 
* Clinic.java
* Created on 6 May, 2017
*/ 

package com.model.user.doctor.clinic; 

import java.sql.SQLException;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class Clinic {
    
    private int clinicID;
    private String clinicName;
    private String clinicAddress;
    private String clinicPhoneNumber;
    private int doctorID;                                                       // The doctorID this clinic is linked to (foreign key in the database)

    public Clinic(String clinicName, String clinicAddress, String clinicPhoneNumber, int doctorID) {
        this.clinicName = clinicName;
        this.clinicAddress = clinicAddress;
        this.clinicPhoneNumber = clinicPhoneNumber;
        this.doctorID = doctorID;
        
        try {
            ClinicStorageUtility storage = new ClinicStorageUtility();
            this.clinicID = storage.getNextID();
            
            storage.add(this);
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
    }
    
    public Clinic(int clinicID, String clinicName, String clinicAddress, String clinicPhoneNumber, int doctorID) {
        this.clinicID = clinicID;
        this.clinicName = clinicName;
        this.clinicAddress = clinicAddress;
        this.clinicPhoneNumber = clinicPhoneNumber;
        this.doctorID = doctorID;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public String getClinicPhoneNumber() {
        return clinicPhoneNumber;
    }
    
    public int getClinicID() {
        return clinicID;
    }
    
    public int getDoctorID() {
        return doctorID;
    }
    
    public static void main(String[] args) {
        Clinic c = new Clinic("CG Road", "Commerce Six Road", "9409074890", 1);
    }
}
