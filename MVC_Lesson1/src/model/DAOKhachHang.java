/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import connectDB.ConnectDB;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tuans
 */
public class DAOKhachHang {//database access object
    ConnectDB conDB;
    Connection conn;
    public DAOKhachHang(ConnectDB conDB) {
        this.conDB = conDB;
        conn=conDB.getConnection();
    }
    public int addKhachHang(KhachHang kh){
        int n=0;
        String sql="INSERT INTO dbo.KhachHang\n" +
        "(\n" +
        "    cname,\n" +
        "    address,\n" +
        "    phone,\n" +
        "    username,\n" +
        "    password,\n" +
        "    status\n" +
        ")\n" +
        "VALUES\n" +
        "(   N'"+kh.getCname()+"', " +
        "    N'"+kh.getAddress()+"', " +
        "    '"+kh.getPhone()+"',  " +
        "    '"+kh.getUsername()+"',  " +
        "    '"+kh.getPassword()+"',  " +
        "    "+kh.getStatus()+" " +
        ")";
        try {
            Statement statement=conn.createStatement();
            n=statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println(sql);
        return n;
    }
    public int insertKhachHang(KhachHang kh){
        int n=0;
        String sql="INSERT INTO dbo.KhachHang\n" +
        "(\n" +
        "    cname,\n" +
        "    address,\n" +
        "    phone,\n" +
        "    username,\n" +
        "    password,\n" +
        "    status\n" +
        ")\n" +
        "VALUES\n" +
        "(?,?,?,?,?,? )";
        try {
            PreparedStatement pre=conn.prepareCall(sql);
            //pre.setDataType
            pre.setString(1, kh.getCname());
            pre.setString(2, kh.getAddress());
            pre.setString(3, kh.getPhone());
            pre.setString(4, kh.getUsername());
            pre.setString(5, kh.getPassword());
            pre.setInt(6, 1);
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateKhachHang(KhachHang kh){
        int n=0;
        String sql="UPDATE dbo.KhachHang SET cname=?, address=?, phone=? WHERE cid=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1, kh.getCname());
            pre.setString(2, kh.getAddress());
            pre.setString(3, kh.getPhone());
            pre.setInt(4, kh.getCid());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int changeStatus(KhachHang kh){
        int n=0;
        String sql="UPDATE dbo.KhachHang SET status= "+kh.getStatus()+ " WHERE cid= "+kh.getCid();
        try {
            Statement statement=conn.createStatement();
            n=statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    public int changePassword(String username, String oldPass, String newPass){
        int n=0;
        //check
        String sql="select * from KhachHang where username=? and password=? and status=1";
        try {
            PreparedStatement pre=conn.prepareCall(sql);
            pre.setString(1, username);
            pre.setString(2, oldPass);
            ResultSet rs=pre.executeQuery();
            if (rs.next()){//user, pass: ok
                String sqlUpdate="update KhachHang set password='"+newPass+"' where username='"+username+"'";
                Statement statement=conn.createStatement();
                n=statement.executeUpdate(sqlUpdate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    public int removeKhachHang(int cid){
        int n=0;
        String sql="delete from KhachHang where cid="+cid;
        Statement statement;
        try {
            statement = conn.createStatement();
            n=statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public void display(){
        String sql="select * from KhachHang";
        //1nf, default
        //Statement state=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        //==Statement state=conn.createStatement();
        try {
            Statement state=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(sql);
            //top down
            while (rs.next()){
                int cid=rs.getInt("cid");//rs.getInt(1);
                String cname=rs.getString("cname");//rs.getString(2);
                String phone=rs.getString("phone");//rs.getString(3);
                System.out.println(cid+"\t"+cname+"\t"+phone);
            }
            //bottom up
//            while (rs.previous()){
//                
//            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        KhachHang kh=new KhachHang("abcnew", "vn", "2444", "srg", "123", 1);
        ConnectDB connDB=new ConnectDB();
        DAOKhachHang dao=new DAOKhachHang(connDB);
        //dao.changePassword("srg", "123", "456");
        //dao.removeKhachHang(3);
        dao.display();
    }
}
