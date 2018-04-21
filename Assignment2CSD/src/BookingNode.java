/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class BookingNode {
    Booking info;
    BookingNode next,prev;
    BookingNode(){}
    BookingNode(Booking xInfo){
        info=xInfo;
        next=prev=null;
    }
    BookingNode(Booking xInfo,BookingNode xPrev,BookingNode xNext){
        info=xInfo;
        prev=xPrev;
        next=xNext;
    }
}
