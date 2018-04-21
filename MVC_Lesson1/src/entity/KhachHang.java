/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author tuans
 */
public class KhachHang implements Serializable{
    private int cid;
    private String cname,address,phone,username,password;
    private int status;

    public KhachHang() {
    }

    public KhachHang(int cid, String cname, String address, String phone, String username, String password, int status) {
        this.cid = cid;
        this.cname = cname;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.status = status;
    }
    //primary key is identity

    public KhachHang(String cname, String address, String phone, String username, String password, int status) {
        this.cname = cname;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return cname + " " + address + " " + phone;
    }
    
}
