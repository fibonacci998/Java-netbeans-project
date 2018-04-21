/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tuans
 */
public  class Mark implements IMark{
    public Mark(){}
    @Override
    
    public Student creatStudent(String name, String xclass, double point1,
            double point2, double point3) {
        Student temp=new Student(name, xclass, point1, point2, point3);
        return temp;
       }

    private double getAveragePoint(double point1, double point2, double point3){
        return ((point1+point2+point3)/3);
    }
    
    @Override
    public List<Student> averageStudent(List<Student> students) {
        ArrayList classified=new ArrayList();
        for (int i=0;i<students.size();i++){
            Student temp=students.get(i);
            double ave=getAveragePoint(temp.getMath(), temp.getChemistry(), temp.getPhysics());
            temp.setAve(ave);
            classified.add(temp);
        }
        return classified;
    }

    private String getRank(double point){
        if (point>7.5) return "A";
        if (point>=6) return "B";
        if (point>=4) return "C";
        return "D";
    }
    
    @Override
    public HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        double typeA,typeB,typeC,typeD;
        typeA=typeB=typeC=typeD=0;
        for (int i=0;i<students.size();i++){
            Student temp=students.get(i);
            String rank= getRank(temp.getAve());
            students.get(i).setType(rank);
            if (rank.compareTo("A")==0) typeA++;
            else if (rank.compareTo("B")==0) typeB++;
            else if (rank.compareTo("C")==0) typeC++;
            else if (rank.compareTo("D")==0) typeD++;
        }
        HashMap<String,Double> temp=new HashMap<>();
        temp.put("A",typeA*100/students.size());
        temp.put("B",typeB*100/students.size());
        temp.put("C",typeC*100/students.size());
        temp.put("D",typeD*100/students.size());
        return temp;
    }
    
}
