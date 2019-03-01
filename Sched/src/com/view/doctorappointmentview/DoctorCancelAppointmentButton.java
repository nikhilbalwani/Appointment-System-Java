/** 
* CancelAppointmentButton.java
* Created on 10 May, 2017
*/ 

package com.view.doctorappointmentview; 

import com.model.user.doctor.Doctor;
import javax.swing.JButton;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorCancelAppointmentButton extends JButton { 
    
    public DoctorCancelAppointmentButton(DoctorCancelAppointmentListener listener, String name) {
        super(name);
        this.addActionListener(listener);
    }
}
