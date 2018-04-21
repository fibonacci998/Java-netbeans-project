/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tuans
 */
public class HangSanXuat {
    private int hid;
    private String hname,website;
    private int status;

    public HangSanXuat() {
    }

    public HangSanXuat(int hid, String hname, String website, int status) {
        this.hid = hid;
        this.hname = hname;
        this.website = website;
        this.status = status;
    }

    public HangSanXuat(String hname, String website, int status) {
        this.hname = hname;
        this.website = website;
        this.status = status;
    }

    public int getHid() {
        return hid;
    }

    public String getHname() {
        return hname;
    }

    public String getWebsite() {
        return website;
    }

    public int getStatus() {
        return status;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return hname ;
    }
    
}
