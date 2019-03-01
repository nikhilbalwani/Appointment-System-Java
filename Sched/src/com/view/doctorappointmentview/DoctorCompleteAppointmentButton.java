/** 
* DoctorCompeleAppointmentButton.java
* Created on 10 May, 2017
*/ 

package com.view.doctorappointmentview; 

import javax.swing.JButton;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorCompleteAppointmentButton extends JButton { 
    public DoctorCompleteAppointmentButton(DoctorCompleteAppointmentListener listener, String name) {
        super(name);
        this.addActionListener(listener);
    }
}
