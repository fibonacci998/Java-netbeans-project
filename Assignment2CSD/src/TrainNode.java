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
    TrainNode left,right;
    TrainNode(){}
    TrainNode(Train xInfo,TrainNode xLeft, TrainNode xRight){
        info=xInfo;
        left=xLeft;
        right=xRight;
    }
    TrainNode(Train xInfo){
        this(xInfo,null,null);
    }
}
