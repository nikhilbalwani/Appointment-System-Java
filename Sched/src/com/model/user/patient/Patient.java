/** 
* Patient.java
* Created on 6 May, 2017
*/ 

package com.model.user.patient; 

import com.model.appointment.Appointment;
import com.model.slot.Slot;
import com.model.slot.exceptions.InvalidSlotIDException;
import com.model.user.User;
import com.model.user.doctor.Doctor;
import com.model.user.doctor.DoctorStorageUtility;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class Patient extends User { 

    private int patientID;
    
    public Patient(String fName, String mName, String lName, String address, GregorianCalendar dateOfBirth, String phoneNumber, String emailID, String password, boolean gender, String bloodGroup) {
        super(fName, mName, lName, address, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup);
        
        PatientStorageUtility storage = null;
        
        try {
            storage = new PatientStorageUtility();
            this.patientID = storage.getNextID();
            storage.add(this);
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
    }
    
    public Patient(int patientID, String fName, String mName, String lName, String address, GregorianCalendar dateOfBirth, String phoneNumber, String emailID, String password, boolean gender, String bloodGroup) {
        super(fName, mName, lName, address, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup);
        
        PatientStorageUtility storage = null;
    }

    public int getPatientID() {
        return patientID;
    }
    
    public Doctor[] getDoctors(String specialization) {
        
        DoctorStorageUtility doctorStorage = null;
        
        try {
            doctorStorage = new DoctorStorageUtility();
            return doctorStorage.getDoctors(specialization);
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (doctorStorage != null)
                doctorStorage.close();
        }
        
        return null;
    }
    
    /**
     * Books an appointment at the given slot.
     * @param slot The slot to book the appointment at.
     * @return The Appointment object after booking has happened.
     */
    
    public Appointment bookAppointment(Slot slot) {
        
        GregorianCalendar dateOfAppointment = null, dateOfBooking = null;
        dateOfAppointment = new GregorianCalendar();
        dateOfBooking = new GregorianCalendar();
        
        while (dateOfAppointment.get(Calendar.DAY_OF_WEEK) != slot.getDayOfWeek())
            dateOfAppointment.add(Calendar.DAY_OF_MONTH, 1);
        
        try {
            if (slot.isAvailable())
                return new Appointment(slot.getSlotID(), patientID, dateOfBooking, dateOfAppointment);
        }
        
        catch (InvalidSlotIDException err) {
            err.printStackTrace();
        }
            
        return null;
    }
    
    public static void main(String[] args) {
        
        Patient p = new Patient("Nikhil", "Naresh", "Balwani", "L701 Sarjan", new GregorianCalendar(1998, 8, 27), "9998986080", "nikhilbalwani1998@gmail.com", "cheshirecat1", false, "A+");
        
        DoctorStorageUtility storage = null;
        
        try {
            storage = new DoctorStorageUtility();
            
            Doctor[] narrowedDoctors = storage.getDoctors("BA");
            System.out.println(narrowedDoctors[0].getfName());
            
            System.out.println(narrowedDoctors[0].getSlots(3).length);
            
            System.out.println(narrowedDoctors[0].getSlots(3)[0].isAvailable());
            
            p.bookAppointment(narrowedDoctors[0].getSlots(3)[0]);
            
            System.out.println(narrowedDoctors[0].getSlots(3)[0].isAvailable());
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (storage != null)
                storage.close();
        }
    }
    
    public static Patient login(String emailID, String password) {
        PatientStorageUtility storage = null;
        
        try {
            storage = new PatientStorageUtility();
            
            return storage.login(emailID, password);
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            try {
                if (storage != null)
                    storage.close();
            }
            
            catch (SQLException err) {
                err.printStackTrace();
            }
            
            catch (Exception err) {
                err.printStackTrace();
            }
        }
        
        return null;
    }
}
