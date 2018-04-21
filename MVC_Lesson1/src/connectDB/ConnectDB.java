/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAOKhachHang;

/**
 *
 * @author tuans
 */
public class ConnectDB {
    Connection conn=null;
    public ConnectDB(){
        //C1:fix code
        //call driver {using multi driver}
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //get connect
            conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BanHang","sa","123456");
            //System.out.println("Connected");
        } catch (Exception e) {
            e.getStackTrace();
        }         
    }
    public ConnectDB(String URL, String userName, String password){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //get connect
            conn=DriverManager.getConnection(URL, userName, password);
            //System.out.println("Connected");
        } catch (Exception e) {
            e.getStackTrace();
        }     
    }
    public Connection getConnection(){
        return this.conn;
    }
    public ResultSet getData(String sql){
        ResultSet rs=null;
        //1nf, default
        //Statement state=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        //==Statement state=conn.createStatement();
        try {
            //Statement state=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            Statement state=conn.createStatement();
            rs=state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void runUpdateData(String sql){
        Statement state;
        try {
            state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new ConnectDB();
    }
}
