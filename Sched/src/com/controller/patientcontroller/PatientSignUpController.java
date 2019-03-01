/** 
* PatientSignUpController.java
* Created on 9 May, 2017
*/ 

package com.controller.patientcontroller; 

import com.view.patientview.PatientSignUpView;
import com.model.user.patient.Patient;
import com.view.signin.SignInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class PatientSignUpController {
    
    PatientSignUpView patientSignUpView = null;
    
    public PatientSignUpController() {
        patientSignUpView = new PatientSignUpView();
        patientSignUpView.setVisible(true);
        
        patientSignUpView.setBackButtonBehavior(new BackButtonListener());
        patientSignUpView.setSignUpButtonBehavior(new SignUpButtonListener());
    }
    
    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SignUpController signUpController = new SignUpController();
            patientSignUpView.dispose();
        }
    }
    
    private class SignUpButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String fName = patientSignUpView.getFName();
            String mName = patientSignUpView.getFName();
            String lName = patientSignUpView.getLName();
            String address = patientSignUpView.getTxtAddress();;
            GregorianCalendar dateOfBirth = new GregorianCalendar(patientSignUpView.getYear(), patientSignUpView.getMonth() - 1, patientSignUpView.getDay());
            String phoneNumber = patientSignUpView.getTxtPhoneNumber();
            String emailID = patientSignUpView.getTxtEmail();
            String password = "" + patientSignUpView.getTxtConfirmPassWord();
            boolean gender = (patientSignUpView.getCombobxGender().equals("Male"));
            String bloodGroup = patientSignUpView.getCombobxBloodGroup();

            Patient p = null;
            
            try {
                p = new Patient(fName, mName, lName, address, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup);
            }

            catch (Exception err) {
                System.out.println("err");
                return;
            }
            
            patientSignUpView.dispose();
            PatientMainScreenController patientMainScreenController = new PatientMainScreenController(p);
        }
    }
}
