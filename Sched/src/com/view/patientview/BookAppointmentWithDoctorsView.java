/** 
* BookAppointmentWithDoctorsView.java
* Created on 9 May, 2017
*/ 

package com.view.patientview; 

import com.model.user.doctor.Doctor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class BookAppointmentWithDoctorsView extends JFrame {
    
    // Constructor : param :- the doctors to be displayed in booking list
    
    public BookAppointmentWithDoctorsView(ActionListener listener, Doctor... doctorList) {
        
        setTitle("Doctor Details");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        for (Doctor doctor : doctorList) {
            
            DoctorRecordView v = new DoctorRecordView(doctor);
            this.add(v);
            v.setButtonBehavior(listener);
            v.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        
        Doctor d = new Doctor(1, "Nick", "Naresh", "Balwani", "add", new GregorianCalendar(), "999898", "nikhilbalwani1998@gmail.com", "pass", true, "A+", 1, "Physician");
        new BookAppointmentWithDoctorsView(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            } 
        }, d, d).setVisible(true);
    }
}
