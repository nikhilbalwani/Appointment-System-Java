/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** 
* ClinicStorageUtility.java
* Created on 7 May, 2017
*/ 

package com.model.user.doctor.clinic; 

import com.model.connectivity.DBConnection;
import com.model.user.doctor.Doctor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class ClinicStorageUtility { 
    
    Connection conn = null;
    
    public ClinicStorageUtility() throws SQLException, Exception {
        conn = DBConnection.getConnection();
    }
    
    public Clinic getClinic(int doctorID) throws SQLException {
        Statement stmt = null;
        
        String clinicName, clinicAddress, clinicPhoneNumber;
        int clinicID;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tblclinic WHERE doctorID = '" + doctorID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                clinicID = rs.getInt("clinicID");
                clinicName = rs.getString("clinicName");
                clinicAddress = rs.getString("clinicAddress");
                clinicPhoneNumber = rs.getString("clinicPhoneNumber");
                
                return new Clinic(clinicID, clinicName, clinicAddress, clinicPhoneNumber, doctorID);
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return null;
    }
    
    public void add(Clinic c) throws SQLException, Exception {
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();

            String sql = "INSERT INTO `schedschema`.`tblclinic` (`clinicID`, `clinicName`, `clinicAddress`, `clinicPhoneNumber`, `doctorID`) VALUES ('" + 
                    c.getClinicID() + "', '" +
                    c.getClinicName() + "', '" +
                    c.getClinicAddress() + "', '" +
                    c.getClinicPhoneNumber() + "', '" +
                    c.getDoctorID() + "');";
            
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
            
            sql = "SELECT MAX(clinicID) FROM tblclinic;";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            String strNextID = rs.getString("MAX(clinicID)");
            
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
    
    public static void main(String[] args) {
        
    }
}
