/** 
* DoctorCompeleteAppointmentListener.java
* Created on 10 May, 2017
*/ 

package com.view.doctorappointmentview; 

import com.model.user.doctor.Doctor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorCompleteAppointmentListener implements ActionListener { 
        
    private int appointmentID;
    private int patientID;
    private Doctor owner;
    
    public void actionPerformed(ActionEvent e) {
        owner.completeAppointment(appointmentID);                                // As the doctor cancels an appointment
    }
    
    public DoctorCompleteAppointmentListener(int appointmentID, int patientID, Doctor d) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.owner = d;
    }
}
