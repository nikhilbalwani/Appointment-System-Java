/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** 
* Appointment.java
* Created on 7 May, 2017
*/ 

package com.model.appointment;

import com.model.slot.SlotStorageUtility;
import java.util.GregorianCalendar;
import com.model.slot.exceptions.InvalidSlotIDException;
import java.sql.Date;
import java.sql.SQLException;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class Appointment { 
    
    private int appointmentID;
    private int slotID;
    private int doctorID;
    private int patientID;
    private String status;
    private GregorianCalendar dateOfBooking;
    private GregorianCalendar dateOfAppointment;

    public Appointment(int slotID, int patientID, GregorianCalendar dateOfBooking, GregorianCalendar dateOfAppointment) throws InvalidSlotIDException {
        
        SlotStorageUtility slotStorage = null;
        AppointmentStorageUtility appointmentStorage = null;
        
        this.slotID = slotID;
        this.patientID = patientID;
        this.status = "pending";
        this.dateOfBooking = dateOfBooking;
        this.dateOfAppointment = dateOfAppointment;
        
        try {
            slotStorage = new SlotStorageUtility();
            this.doctorID = slotStorage.getDoctorID(slotID);                    // Getting the doctorID of the slot
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (slotStorage != null)
                slotStorage.close();
        }
        
        try {
            appointmentStorage = new AppointmentStorageUtility();
            this.appointmentID = appointmentStorage.getNextID();
            
            appointmentStorage.add(this);
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (appointmentStorage != null)
                appointmentStorage.close();
        }
    }
    
    public Appointment(int appointmentID, int slotID, int patientID, GregorianCalendar dateOfBooking, GregorianCalendar dateOfAppointment) {
        
        SlotStorageUtility slotStorage = null;
        AppointmentStorageUtility appointmentStorage = null;
        
        this.slotID = slotID;
        this.patientID = patientID;
        this.status = "pending";
        this.dateOfBooking = dateOfBooking;
        this.dateOfAppointment = dateOfAppointment;
        this.appointmentID = appointmentID;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public int getSlotID() {
        return slotID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getStatus() {
        return status;
    }

    public GregorianCalendar getDateOfBooking() {
        return dateOfBooking;
    }

    public GregorianCalendar getDateOfAppointment() {
        return dateOfAppointment;
    }
    
    public long getDateOfBookingTimeInMillis() {                                // Since the class extenders need only milliseconds to store date in SQL
        return dateOfBooking.getTimeInMillis();
    }
    
    public long getDateOfAppointmentTimeInMillis() {                            // Since the class extenders need only milliseconds to store date in SQL
        return dateOfAppointment.getTimeInMillis();
    }
    
    public boolean isCompleted() {
        AppointmentStorageUtility storage = null;
        
        try {
            storage = new AppointmentStorageUtility();
            
            return storage.isCompleted(appointmentID);
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (storage != null)
                storage.close();
        }
        
        return false;
    }
    
    public boolean isPending() {
        AppointmentStorageUtility storage = null;
        
        try {
            storage = new AppointmentStorageUtility();
            
            return storage.isPending(appointmentID);
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (storage != null)
                storage.close();
        }
        
        return false;
    }
    
    public boolean isCancelled() {
        AppointmentStorageUtility storage = null;
        
        try {
            storage = new AppointmentStorageUtility();
            
            return storage.isCancelled(appointmentID);
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (storage != null)
                storage.close();
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    }
}
