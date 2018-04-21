/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class Train {
    String tcode,train_name,depart_place;
    int seat,booked;
    double depart_time;
    public Train(){}
    public Train(String xTcode,String xTrain_Name,int xSeat,int xBooked,
            double xDepart_Time,String xDepart_Place){
        tcode=xTcode;train_name=xTrain_Name;seat=xSeat;booked=xBooked;
        depart_place=xDepart_Place;depart_time=xDepart_Time;
    }

    @Override
    public String toString() {
        return tcode + " | " + train_name + " | " + depart_place + " | " + seat + " | " + booked + " | " + depart_time ;
    }
    
}
