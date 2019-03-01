/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** 
* AppointmentStorageUtility.java
* Created on 7 May, 2017
*/ 

package com.model.appointment; 

import com.model.appointment.exceptions.InvalidAppointmentIDException;
import com.model.connectivity.DBConnection;
import com.model.slot.Slot;
import com.model.slot.exceptions.InvalidSlotIDException;
import com.model.user.doctor.Doctor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
* 
* @version $Revision: 1.0.0 $
* @author Nikhil Balwani (1641070) 
*/ 
public class AppointmentStorageUtility { 
    Connection conn = null;
    
    public AppointmentStorageUtility() throws SQLException, Exception {
        conn = DBConnection.getConnection();
    }
    
    public void add(Appointment a) throws SQLException, Exception {
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();

            String sql = "INSERT INTO `schedschema`.`tblappointment` (`appointmentID`, `slotID`, `doctorID`, `patientID`, `status`, `dateOfAppointment`, `dateOfBooking`) VALUES ('" +
                    a.getAppointmentID() + "', '" +
                    a.getSlotID() + "', '" +
                    a.getDoctorID() + "', '" +
                    a.getPatientID() + "', '" +
                    a.getStatus() + "', '" +
                    new Timestamp(a.getDateOfAppointmentTimeInMillis()) + "', '" +
                    new Timestamp(a.getDateOfBookingTimeInMillis()) + "');";
            
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
    
    public Appointment getAppointment(int appointmentID) throws SQLException {
        Statement stmt = null;
        int slotID, patientID;
        GregorianCalendar dateOfBooking, dateOfAppointment;
        
        Timestamp t = null;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tblappointment WHERE appointmentID = " + appointmentID + ";";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            appointmentID = rs.getInt("appointmentID");
            slotID = rs.getInt("slotID");
            patientID = rs.getInt("patientID");
            
            t = rs.getTimestamp("dateOfBooking");
            dateOfBooking = new GregorianCalendar();
            dateOfBooking.setTimeInMillis(t.getTime());
            
            t = rs.getTimestamp("dateOfAppointment");
            dateOfAppointment = new GregorianCalendar();
            dateOfAppointment.setTimeInMillis(t.getTime());
            
            return new Appointment(appointmentID, slotID, patientID, dateOfBooking, dateOfAppointment);
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
    }
    
    public Appointment[] getAppointmentByDoctorID(int doctorID) throws SQLException {
        Statement stmt = null;
        
        ArrayList <Appointment> appointments = new ArrayList<>();
        
        int slotID, patientID, appointmentID;
        GregorianCalendar dateOfBooking, dateOfAppointment;
        Timestamp timestamp = null;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tblappointment WHERE doctorID = '" + doctorID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                appointmentID = Integer.parseInt(rs.getString("appointmentID"));
                doctorID = Integer.parseInt(rs.getString("doctorID"));
                slotID = rs.getInt("slotID");
                patientID = rs.getInt("patientID");
                
                timestamp = rs.getTimestamp("dateOfBooking");
                dateOfBooking = new GregorianCalendar();
                dateOfBooking.setTimeInMillis(timestamp.getTime());
            
                timestamp = rs.getTimestamp("dateOfBooking");
                dateOfAppointment = new GregorianCalendar();
                dateOfAppointment.setTimeInMillis(timestamp.getTime());
                
                appointments.add(new Appointment(appointmentID, slotID, patientID, dateOfBooking, dateOfAppointment));
            }
        }
        
        finally {
            if (conn != null)
                conn.close();
        }
        
        return null;
    }
    
    public Appointment[] getAppointmentByPatientID(int patientID) throws SQLException {
        Statement stmt = null;
        
        ArrayList <Appointment> appointments = new ArrayList<>();
        
        int slotID, doctorID, appointmentID;
        GregorianCalendar dateOfBooking, dateOfAppointment;
        Timestamp timestamp = null;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM tblappointment WHERE doctorID = '" + patientID + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                appointmentID = Integer.parseInt(rs.getString("appointmentID"));
                doctorID = Integer.parseInt(rs.getString("doctorID"));
                slotID = rs.getInt("slotID");
                patientID = rs.getInt("patientID");
                
                timestamp = rs.getTimestamp("dateOfBooking");
                dateOfBooking = new GregorianCalendar();
                dateOfBooking.setTimeInMillis(timestamp.getTime());
            
                timestamp = rs.getTimestamp("dateOfBooking");
                dateOfAppointment = new GregorianCalendar();
                dateOfAppointment.setTimeInMillis(timestamp.getTime());
                
                appointments.add(new Appointment(appointmentID, slotID, patientID, dateOfBooking, dateOfAppointment));
            }
        }
        
        finally {
            if (conn != null)
                conn.close();
        }
        
        return null;
    }
    
    public int getNextID() throws SQLException, Exception {
        Statement stmt = null;
        int nextID;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT MAX(appointmentID) FROM tblappointment;";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            String strNextID = rs.getString("MAX(appointmentID)");
            
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
    
    public boolean isAvailable(int slotID) throws SQLException {
        Statement stmt = null;
        GregorianCalendar dateOfAppointment = null;
        
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT dateOfAppointment FROM tblappointment WHERE slotID = " + slotID + ";";// SQL command to fetch doctorID for the given slot ID
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                dateOfAppointment = new GregorianCalendar();
                
                dateOfAppointment.setTimeInMillis(rs.getTimestamp("dateOfAppointment").getTime());
                
                if (dateOfAppointment.after(new GregorianCalendar()))           // If the date of appointment is after today
                    return false;
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return true;
    }
    
    public boolean isPending(int appointmentID) throws SQLException, InvalidAppointmentIDException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT status FROM tblappointment WHERE appointmentID = " + appointmentID + ";";// SQL command to fetch doctorID for the given slot ID
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next())
                throw new InvalidAppointmentIDException(appointmentID);
            
            if (rs.getString("status").equals("pending"))
                return true;
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return false;
    }
    
    public boolean isCancelled(int appointmentID) throws SQLException, InvalidAppointmentIDException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT status FROM tblappointment WHERE appointmentID = " + appointmentID + ";";// SQL command to fetch doctorID for the given slot ID
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next())
                throw new InvalidAppointmentIDException(appointmentID);
            
            if (rs.getString("status").equals("cancelled"))
                return true;
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return false;
    }
    
    public boolean isCompleted(int appointmentID) throws SQLException, InvalidAppointmentIDException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT status FROM tblappointment WHERE appointmentID = " + appointmentID + ";";// SQL command to fetch doctorID for the given slot ID
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next())
                throw new InvalidAppointmentIDException(appointmentID);
            
            if (rs.getString("status").equals("completed"))
                return true;
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
        
        return false;
    }
    
    public void completeAppointment(int appointmentID) throws InvalidAppointmentIDException, Exception {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT status FROM tblappointment WHERE appointmentID = " + appointmentID + ";";// SQL command to fetch doctorID for the given slot ID
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next())
                throw new InvalidAppointmentIDException(appointmentID);
            
            else if (rs.getString("status").equals("completed"))
                throw new Exception("The appointment is already complete. ");
            
            else {
                sql = "UPDATE `schedschema`.`tblappointment` SET `status`='" + "completed" + "' WHERE `appointmentID`='" + appointmentID + "';";
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
    }
    
    public void cancelAppointment(int appointmentID) throws InvalidAppointmentIDException, Exception {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = null;
            
            sql = "SELECT status FROM tblappointment WHERE appointmentID = " + appointmentID + ";";// SQL command to fetch doctorID for the given slot ID
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next())
                throw new InvalidAppointmentIDException(appointmentID);
            
            else if (rs.getString("status").equals("cancelled"))
                throw new Exception("The appointment is already cancelled. ");
            
            else {
                sql = "UPDATE `schedschema`.`tblappointment` SET `status`='" + "cancelled" + "' WHERE `appointmentID`='" + appointmentID + "';";
            }
        }
        
        finally {
            if (stmt != null)
                stmt.close();
        }
    }
}
