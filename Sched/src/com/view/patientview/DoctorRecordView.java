/** 
* DoctorRecordView.java
* Created on 9 May, 2017
*/ 

package com.view.patientview; 

import com.model.user.doctor.Doctor;
import com.model.user.doctor.clinic.Clinic;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorRecordView extends JPanel {
    
    private JLabel lblDoctorID;
    private JLabel lblDoctorName;
    private JLabel lblClinicAddress;
    private BookAppointmentButton btnSelectDoctor;
    
    public DoctorRecordView(Doctor doctor) {
        
        lblDoctorID = new JLabel(String.valueOf(doctor.getDoctorID()));
        lblDoctorName = new JLabel(String.valueOf(doctor.getfName() + " " + doctor.getlName()));
        
        Clinic c = doctor.getClinic();
        
        System.out.println(c);
        
        lblClinicAddress = new JLabel(c.getClinicAddress());
        btnSelectDoctor = new BookAppointmentButton(doctor, "Book Appointment");
        
        this.add(lblDoctorID);
        this.add(lblDoctorName);
        this.add(lblClinicAddress);
        this.add(btnSelectDoctor);
    }
    
    public void setButtonBehavior(ActionListener listener) {
        btnSelectDoctor.addActionListener(listener);
    }
}
