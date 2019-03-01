/**
 * DoctorSignUpController.java
 * Created on 10 May, 2017
 */
package com.controller.doctorcontroller;

import com.controller.patientcontroller.SignUpController;
import com.model.user.doctor.Doctor;
import com.model.user.doctor.clinic.Clinic;
import com.view.doctorview.DoctorSignUpView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

/**
 *
 * @version $Revision: 1.0.0 $
 * @author Nikhil Balwani (1641070)
 */
public class DoctorSignUpController {    

    private DoctorSignUpView doctorSignUpView = null;
    
    public DoctorSignUpController() {
        doctorSignUpView = new DoctorSignUpView();
        doctorSignUpView.setVisible(true);
        
        doctorSignUpView.setBackButtonBehavior(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUpController signUpController = new SignUpController();
                doctorSignUpView.dispose();
            }
        });
        
        doctorSignUpView.setGetStartedButtonBehavior(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String fName, mName, lName, address;
                GregorianCalendar dateOfBirth;
                String phoneNumber, emailID, password, bloodGroup, specialization;
                int workExperience;
                boolean gender;
                
                int day = Integer.parseInt(doctorSignUpView.getDay()), month = doctorSignUpView.getMonth(), year = Integer.parseInt(doctorSignUpView.getYear());
                
                fName = doctorSignUpView.getTxtFName();
                mName = doctorSignUpView.getTxtMName();
                lName = doctorSignUpView.getTxtLName();
                address = doctorSignUpView.getTxtAddress();
                
                dateOfBirth = new GregorianCalendar(year, month - 1, day);
                
                phoneNumber = doctorSignUpView.getTxtPhoneNumber();
                emailID = doctorSignUpView.getTxtEmail();
                password = doctorSignUpView.getPassword();
                gender = doctorSignUpView.getGender().equals("Male");
                bloodGroup = doctorSignUpView.getBloodGroup();
                workExperience = doctorSignUpView.getTxtExperience();
                specialization = doctorSignUpView.getSpecialization();
                
                Doctor newDoctor = new Doctor(fName, mName, lName, address, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup, workExperience, specialization);
            
                Clinic c = new Clinic(lName, address, phoneNumber, newDoctor.getDoctorID());
                
                DoctorMainScreenController doctorMainScreenController = new DoctorMainScreenController(newDoctor);
            }
        });
    }
}
