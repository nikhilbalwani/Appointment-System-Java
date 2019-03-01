/** 
* PatientMainScreenController.java
* Created on 9 May, 2017
*/ 

package com.controller.patientcontroller; 

import com.model.user.patient.Patient;
import com.view.patientview.PatientMainScreenView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class PatientMainScreenController { 
    PatientMainScreenView patientMainScreenView = null;
    
    /**
     * 
     * @param p Instance of patient who has logged in.
     */
    
    public PatientMainScreenController(Patient p) {
        patientMainScreenView = new PatientMainScreenView();
        patientMainScreenView.setVisible(true);
        
        patientMainScreenView.setBookAppointmentButtonBehavior(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BookAppointmentFirstController(p);
            }
        });
        
        patientMainScreenView.setMyProfileButtonBehavior(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
