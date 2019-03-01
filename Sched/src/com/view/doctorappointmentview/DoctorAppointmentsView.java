/** 
* DoctorAppointmentsView.java
* Created on 10 May, 2017
*/ 

package com.view.doctorappointmentview; 

import com.model.appointment.Appointment;
import com.model.appointment.AppointmentStorageUtility;
import com.model.user.doctor.Doctor;
import javax.swing.JFrame;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorAppointmentsView extends JFrame { 
    public DoctorAppointmentsView(Doctor loggedIn) throws Exception {
        
        AppointmentStorageUtility s = new AppointmentStorageUtility();
        Appointment[] appointmentList = s.getAppointmentByDoctorID(loggedIn.getDoctorID());
        
        System.out.println(s);
        
        setTitle("Doctor Details");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        for (Appointment a : appointmentList) {
            DoctorAppointmentRecordView v = new DoctorAppointmentRecordView(a, loggedIn);
            this.add(v);
            v.setVisible(true);
        }
    }
}
