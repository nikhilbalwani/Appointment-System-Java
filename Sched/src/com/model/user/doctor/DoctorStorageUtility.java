/** 
* DoctorStorageUtility.java
* Created on 6 May, 2017
*/ 

package com.model.user.doctor; 

import com.model.connectivity.DBConnection;
import com.model.slot.Slot;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class DoctorStorageUtility { 

    Connection conn = null;
    
    public DoctorStorageUtility() throws Exception {
        conn = DBConnection.getConnection();
    }
    
    public void add(Doctor d) throws SQLException, Exception {
        
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();

            int deactivated = (d.isDeactivated()) ? 1 : 0;
            int gender = (d.getGender()) ? 1 : 0;

            String sql = "INSERT INTO `schedschema`.`tbldoctor` (`doctorID`, `fName`, `mName`, `lName`, `residenceAddress`, `dateOfBirth`, `phoneNumber`, `emailID`, `deactivated`, `password`, `gender`, `bloodGroup`, `workExperience`, `specialization`) VALUES ('"+ 
                    d.getDoctorID() +"', '" +
                    d.getfName() + "', '" +
                    d.getmName() + "', '" +
                    d.getlName() + "', '" +
                    d.getAddress() + "', '" +
                    new Timestamp(d.getDateOfBirthTimeInMillis()) + "', '" +
                    d.getPhoneNumber() + "', '" +
                    d.getEmailID() + "', '" +
                    deactivated + "', '" +
                    d.getPassword() + "', '" +
                    gender + "', '" +
                    d.getGender() + "', '" +
                    d.getWorkExperience() + "', '" +
                    d.getSpecialization() + "');";

            stmt.execute(sql);
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
    }
    
    public void close() {
        
        try {
            conn.close();
            conn = null;
        }
        
        catch (SQLException err) {
            err.printStackTrace();
        }
    }
    
    public int getNextID() throws SQLException, Exception {
        Statement stmt = null;
        int nextID;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT MAX(doctorID) FROM tbldoctor;";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            String strNextID = rs.getString("MAX(doctorID)");
            
            if (strNextID == null)
                nextID = 0;
            
            else
                nextID = Integer.parseInt(strNextID) + 1;
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return nextID;
    }
    
    public Doctor[] getDoctors(String specialization) throws SQLException, Exception {
        Statement stmt = null;
        
        ArrayList <Doctor> doctors = new ArrayList<>();
        
        int doctorID, workExperience;
        boolean deactivated, gender;
        String fName, mName, lName, residenceAddress, phoneNumber, emailID, password, bloodGroup;
        GregorianCalendar dateOfBirth = null;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Timestamp timestamp;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tbldoctor WHERE specialization = '" + specialization + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                doctorID = Integer.parseInt(rs.getString("doctorID"));
                fName = rs.getString("fName");
                mName = rs.getString("mName");
                lName = rs.getString("lName");
                residenceAddress = rs.getString("residenceAddress");
                
                timestamp = rs.getTimestamp("dateOfBirth");
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTimeInMillis(timestamp.getTime());
                
                phoneNumber = rs.getString("phoneNumber");
                emailID = rs.getString("emailID");
                deactivated = (rs.getInt("deactivated") == 1) ? true : false;
                password = rs.getString("password");
                gender = (rs.getInt("gender") == 1) ? true : false;
                bloodGroup = rs.getString("bloodGroup");
                workExperience = rs.getInt("workExperience");
                
                doctors.add(new Doctor(doctorID, fName, mName, lName, lName, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup, workExperience, specialization));
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return doctors.toArray(new Doctor[doctors.size()]);
    }
    
    /**
     * Returns an instance of doctor with the specified doctorID.
     * @param doctorID Doctor ID of the doctor whose instance is to be created.
     * @return The instance of doctor. null if the doctorID is invalid.
     */
    
    public Doctor getDoctor(int doctorID) throws SQLException {
        Statement stmt = null;
        
        LocalTime startTime, endTime;
        String fName, mName, lName, residenceAddress, phoneNumber, emailID, password, bloodGroup, specialization;
        GregorianCalendar dateOfBirth;
        int workExperience;
        boolean deactivated, gender;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tbldoctor WHERE doctorID = '" + doctorID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                doctorID = Integer.parseInt(rs.getString("doctorID"));
                fName = rs.getString("fName");
                mName = rs.getString("mName");
                lName = rs.getString("lName");
                residenceAddress = rs.getString("residenceAddress");
                Timestamp timestamp = rs.getTimestamp("dateOfBirth");
                
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTimeInMillis(timestamp.getTime());
                
                phoneNumber = rs.getString("phoneNumber");
                emailID = rs.getString("emailID");
                deactivated = (rs.getInt("deactivated") == 1) ? true : false;
                password = rs.getString("password");
                gender = (rs.getInt("gender") == 1) ? true : false;
                bloodGroup = rs.getString("bloodGroup");
                workExperience = rs.getInt("workExperience");
                specialization = rs.getString("specialization");
                
                return new Doctor(doctorID, fName, mName, lName, lName, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup, workExperience, specialization);
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return null;
    }
    
    
    public Doctor getDoctor(String emailID) throws SQLException {
        Statement stmt = null;
        
        LocalTime startTime, endTime;
        int doctorID;
        String fName, mName, lName, residenceAddress, phoneNumber, password, bloodGroup, specialization;
        GregorianCalendar dateOfBirth;
        int workExperience;
        boolean deactivated, gender;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tbldoctor WHERE emailID = '" + emailID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                doctorID = Integer.parseInt(rs.getString("doctorID"));
                fName = rs.getString("fName");
                mName = rs.getString("mName");
                lName = rs.getString("lName");
                residenceAddress = rs.getString("residenceAddress");
                Timestamp timestamp = rs.getTimestamp("dateOfBirth");
                
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTimeInMillis(timestamp.getTime());
                
                phoneNumber = rs.getString("phoneNumber");
                emailID = rs.getString("emailID");
                deactivated = (rs.getInt("deactivated") == 1) ? true : false;
                password = rs.getString("password");
                gender = (rs.getInt("gender") == 1) ? true : false;
                bloodGroup = rs.getString("bloodGroup");
                workExperience = rs.getInt("workExperience");
                specialization = rs.getString("specialization");
                
                return new Doctor(doctorID, fName, mName, lName, lName, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup, workExperience, specialization);
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return null;
    }
    
    /**
     * Returns the Doctor instance after login.
     * @param emailID EMail ID for login.
     * @param password Password for login.
     * @return null if the login was unsuccessful, else the doctor's instance.
     * @throws SQLException
     * @throws Exception 
     */
    
    public Doctor login(String emailID, String password) throws SQLException, Exception {
        Statement stmt = null;
        
        ArrayList <Doctor> doctors = new ArrayList<>();
        
        GregorianCalendar dateOfBirth = null;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Timestamp timestamp;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT password, doctorID FROM tbldoctor WHERE emailID = '" + emailID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            String fetchedPassword = rs.getString("password");
            
            if (fetchedPassword == null)
                return null;
            
            else
                return getDoctor(rs.getInt("doctorID"));
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
    }
    
    public static void main(String[] args) {
        
        try {
            DoctorStorageUtility s = new DoctorStorageUtility();
            System.out.println(s.getDoctor(0).getfName());
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
    }
}
