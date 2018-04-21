package com.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    /*Insert your other code right after this comment*/
     public ResultSet getData(String sql){
        ResultSet rs=null;
        //1nf, default
        //Statement state=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        //==Statement state=conn.createStatement();
        try {
            //Statement state=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            Statement state=getConnection().createStatement();
            rs=state.executeQuery(sql);
        } catch (Exception ex) {
             Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
         }
        return rs;
    }
    public void runUpdateData(String sql){
        Statement state;
        try {
            state = getConnection().createStatement();
            state.executeUpdate(sql);
        } catch (Exception ex) {
             Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
     
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "TREAPT";
    private final String dbName = "PRJ311";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";
}