/** 
* SignUpController.java
* Created on 8 May, 2017
*/ 

package com.controller.patientcontroller; 

import com.controller.doctorcontroller.DoctorSignUpController;
import com.view.signup.SignUpView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class SignUpController { 
    
    SignUpView signUpView = null;
    
    public SignUpController() {
        signUpView = new SignUpView();
        signUpView.setVisible(true);
        signUpView.setDoctorButtonBehavior(new BtnDoctorSignUpListener());
        signUpView.setPatientButtonBehavior(new BtnPatientSignUpListener());
    }
    
    private class BtnDoctorSignUpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            signUpView.dispose();
            new DoctorSignUpController();
        }
    }
    
    private class BtnPatientSignUpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            signUpView.dispose();
            new PatientSignUpController();
        }
    }
    
    public static void main(String[] args) {
        SignUpController s = new SignUpController();
        
    }
}
