package com.model.user.patient; 

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import com.model.connectivity.DBConnection;
import com.model.user.doctor.Doctor;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PatientStorageUtility {

    private Connection conn = null;

    public PatientStorageUtility() throws Exception {
        conn = DBConnection.getConnection();
    }
    
    public void add(Patient p) throws SQLException, Exception {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = null;

            int deactivatedInt = (p.isDeactivated()) ? 1 : 0;
            int genderInt = (p.getGender()) ? 1 : 0;
            
            sql = "INSERT INTO `schedschema`.`tblpatient` (`patientID`, `fName`, `mName`, `lName`, `residenceAddress`, `dateOfBirth`, `phoneNumber`, `emailID`, `deactivated`, `password`, `gender`, `bloodGroup`) VALUES ('" + 
                    p.getPatientID() + "', '" + 
                    p.getfName() + "', '" +
                    p.getmName() + "', '" +
                    p.getlName() + "', '" +
                    p.getAddress() +"', '" +
                    new Timestamp(p.getDateOfBirthTimeInMillis()) +"', '" +
                    p.getPhoneNumber() + "', '" +
                    p.getEmailID() + "', '" +
                    deactivatedInt + "', '" +
                    p.getPassword() + "', '" +
                    genderInt +"', '" +
                    p.getBloodGroup() + "');";

            stmt.execute(sql);
        }
        
        finally {
            if(stmt != null)
                stmt.close();
        }
    }

    public void close() throws SQLException, Exception{
        if(conn != null)
            conn.close();
    }
    
    public int getNextID() throws SQLException, Exception {
        Statement stmt = null;
        int nextID;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT MAX(patientID) FROM tblpatient;";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            String strNextID = rs.getString("MAX(patientID)");
            
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
    
    public Patient getPatient(int patientID) throws SQLException {
        Statement stmt = null;
        
        LocalTime startTime, endTime;
        String fName, mName, lName, residenceAddress, phoneNumber, emailID, password, bloodGroup;
        GregorianCalendar dateOfBirth;
        int workExperience;
        boolean deactivated, gender;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tblpatient WHERE patientID = '" + patientID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                patientID = Integer.parseInt(rs.getString("patientID"));
                fName = rs.getString("fName");
                mName = rs.getString("mName");
                lName = rs.getString("lName");
                residenceAddress = rs.getString("residenceAddress");
                Timestamp timestamp = rs.getTimestamp("dateOfBirth");
                
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTimeInMillis(timestamp.getTime());
                
                phoneNumber = rs.getString("phoneNumber");
                emailID = rs.getString("emailID");
                deactivated = (rs.getInt("deactivated") == 1);
                password = rs.getString("password");
                gender = (rs.getInt("gender") == 1);
                bloodGroup = rs.getString("bloodGroup");
                
                return new Patient(patientID, fName, mName, lName, lName, dateOfBirth, phoneNumber, emailID, password, gender, bloodGroup);
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return null;
    }
    
    public Patient login(String emailID, String password) throws SQLException, Exception {
        Statement stmt = null;
        
        ArrayList <Doctor> doctors = new ArrayList<>();
        
        GregorianCalendar dateOfBirth = null;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Timestamp timestamp;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT password, patientID FROM tblpatient WHERE emailID = '" + emailID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            String fetchedPassword = rs.getString("password");
            
            if (fetchedPassword == null)
                return null;
            
            else
                return getPatient(rs.getInt("patientID"));
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public static void main(String[] args) {

        PatientStorageUtility storage = null;

        try {
            storage = new PatientStorageUtility();
        }

        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            try {
            storage.close();
            storage = null;
            }
            
            catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}