/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class TrainNode {
    Train info;
    TrainNode next,prev;
    TrainNode(){}
    TrainNode(Train xInfo,TrainNode xPrev, TrainNode xNext){
        info=xInfo;
        prev=xPrev;
        next=xNext;
    }
    TrainNode(Train xInfo){
        this(xInfo,null,null);
    }
}
