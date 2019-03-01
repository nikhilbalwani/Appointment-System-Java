/** 
* AppointmentRecordView.java
* Created on 10 May, 2017
*/ 

package com.view.doctorappointmentview; 

import com.model.appointment.Appointment;
import com.model.user.doctor.Doctor;
import com.model.user.patient.PatientStorageUtility;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorAppointmentRecordView extends JPanel {
    
    private JLabel lblPatientID;
    private JLabel lblPatientName;
    private JLabel lblAppointmentTime;
    private DoctorCancelAppointmentButton btnCancelAppointment;
    private DoctorCompleteAppointmentButton btnCompleteAppointment;
    Doctor owner;
    
    public DoctorAppointmentRecordView(Appointment a, Doctor d) throws SQLException, Exception {
        PatientStorageUtility patientStorageUtility = new PatientStorageUtility();
        
        lblPatientID.setText(String.valueOf(a.getPatientID()));
        lblPatientID.setText(String.valueOf(patientStorageUtility.getPatient(a.getPatientID())));
        lblAppointmentTime.setText(String.valueOf(patientStorageUtility.getPatient(a.getPatientID())));
        btnCancelAppointment = new DoctorCancelAppointmentButton(new DoctorCancelAppointmentListener(a.getAppointmentID(), a.getPatientID(), d), "Cancel Appointment");
        btnCompleteAppointment = new DoctorCompleteAppointmentButton(new DoctorCompleteAppointmentListener(a.getAppointmentID(), a.getPatientID(), d), "Complete Appointment");
        
        add(lblPatientID);
        add(lblPatientName);
        add(lblAppointmentTime);
        add(btnCancelAppointment);
        add(btnCompleteAppointment);
    }
}
