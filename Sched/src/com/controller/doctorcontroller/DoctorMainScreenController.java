/** 
* DoctorMainScreenController.java
* Created on 10 May, 2017
*/ 

package com.controller.doctorcontroller; 

import com.controller.signincontroller.SignInController;
import com.model.user.doctor.Doctor;
import com.view.doctorappointmentview.DoctorAppointmentsView;
import com.view.doctorview.DoctorMainScreenView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorMainScreenController { 
    DoctorMainScreenView doctorMainScreenView = null;
    
    public DoctorMainScreenController(Doctor loggedInDoctor) {
        doctorMainScreenView = new DoctorMainScreenView();
        doctorMainScreenView.setVisible(true);
        
        doctorMainScreenView.setEditScheduleButtonBehavior(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetScheduleController setScheduleController = new SetScheduleController(loggedInDoctor);
                doctorMainScreenView.dispose();
            }
        });
        
        doctorMainScreenView.setViewAppointmentsButtonBehavior(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new DoctorAppointmentsView(loggedInDoctor);
                }
                
                catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });
        
        doctorMainScreenView.setLogOutButtonBehavior(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctorMainScreenView.dispose();
                new SignInController();
            }
        });
    }
}
