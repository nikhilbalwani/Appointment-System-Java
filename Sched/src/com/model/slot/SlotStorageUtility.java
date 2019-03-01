/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** 
* SlotStorage.java
* Created on 7 May, 2017
*/ 

package com.model.slot; 

import com.model.connectivity.DBConnection;
import com.model.slot.exceptions.InvalidSlotIDException;
import com.model.user.doctor.clinic.Clinic;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class SlotStorageUtility { 
    Connection conn = null;
    
    public SlotStorageUtility() throws SQLException, Exception {
        conn = DBConnection.getConnection();
    }
    
    public void add(Slot s) throws SQLException, Exception {
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();

            String sql = "INSERT INTO `schedschema`.`tblslot` (`slotID`, `dayOfWeek`, `startTime`, `endTime`, `doctorID`) VALUES ('" +
                    s.getSlotID() + "', '" +
                    s.getDayOfWeek() + "', '" +
                    Time.valueOf(s.getStartTime()) + "', '" +
                    Time.valueOf(s.getEndTime()) + "', '" +
                    s.getDoctorID() + "');";
            
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
            
            sql = "SELECT MAX(slotID) FROM tblslot;";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            String strNextID = rs.getString("MAX(slotID)");
            
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
    
    public int getDoctorID(int slotID) throws SQLException, InvalidSlotIDException {
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT doctorID FROM tblslot WHERE slotID = " + slotID + ";";// SQL command to fetch doctorID for the given slot ID
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next())
                throw new InvalidSlotIDException(slotID);
            
            else {
                String strDoctorID = rs.getString("doctorID");
                return Integer.parseInt(strDoctorID);                           // Returning doctorID in integer format.
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
    }
    
    /**
     * If a slot already exists under a doctor.
     * @param dayOfWeek
     * @param startTime
     * @return
     * @throws SQLException 
     */
    
    public boolean exists(int doctorID, int dayOfWeek, LocalTime startTime) throws SQLException {
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
     
            sql = "SELECT * FROM tblslot WHERE dayOfWeek = " + dayOfWeek + " AND doctorID = " + doctorID + " AND startTime = '" + Time.valueOf(startTime) + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next())
                return false;
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return true;
    }

    
     /**
     * Returns slots under a doctor on a given week day.
     * @param doctorID Doctor ID of the doctor.
     * @return doctorIDs
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    
    public Slot[] getSlots(int doctorID, int dayOfWeek) throws SQLException, Exception {
        Statement stmt = null;
        
        ArrayList <Slot> slots = new ArrayList<>();
        int slotID;
        LocalTime startTime, endTime;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tblslot WHERE doctorID = '" + doctorID + "' AND dayOfWeek = '" + dayOfWeek + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                slotID = Integer.parseInt(rs.getString("slotID"));
                startTime = rs.getTime("startTime").toLocalTime();
                endTime = rs.getTime("endTime").toLocalTime();
                slots.add(new Slot(slotID, dayOfWeek, startTime, endTime, doctorID));
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return slots.toArray(new Slot[slots.size()]);
    }
    
    public static void main(String[] args) {
        System.out.println();
        
        SlotStorageUtility storage = null;
        
        try {
            storage = new SlotStorageUtility();
            System.out.println(storage.exists(1, 3, LocalTime.of(4, 30)));
        }
        
        catch (Exception err) {
            err.printStackTrace();
        }
        
        finally {
            if (storage != null)
                storage.close();
        }
    }
}
