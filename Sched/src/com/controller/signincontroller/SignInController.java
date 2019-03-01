/** 
* SignInController.java
* Created on 10 May, 2017
*/ 

package com.controller.signincontroller; 

import com.controller.doctorcontroller.DoctorMainScreenController;
import com.controller.patientcontroller.PatientMainScreenController;
import com.controller.patientcontroller.SignUpController;
import com.model.user.doctor.Doctor;
import com.model.user.patient.Patient;
import com.view.doctorview.DoctorMainScreenView;
import com.view.signin.SignInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class SignInController { 
    
    SignInView signInView = null;
    
    public SignInController() {
        signInView = new SignInView();
        signInView.setVisible(true);
        
        signInView.setSignUpButtonBehavior(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                signInView.dispose();
                SignUpController signUpController = new SignUpController();
            }
        });
        
        signInView.setSignInButtonBehavior(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (signInView.getRadiobtnDoctor())
                    if (Doctor.login(signInView.getTxtEmail(), signInView.getTxtPassWord()) != null)
                        new DoctorMainScreenController(Doctor.login(signInView.getTxtEmail(), signInView.getTxtPassWord()));
            }
        });
        
        signInView.setSignInButtonBehavior(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (signInView.getRadiobtnPatient())
                    if (Patient.login(signInView.getTxtEmail(), signInView.getTxtPassWord()) != null)
                        new PatientMainScreenController(Patient.login(signInView.getTxtEmail(), signInView.getTxtPassWord()));
            }
        });
    }
    
    public static void main(String[] args) {
        SignInController s = new SignInController();
    }
}
