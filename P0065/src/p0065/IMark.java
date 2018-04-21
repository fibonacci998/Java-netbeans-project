/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0065;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tuans
 */
public interface IMark {
    
    public Student creatStudent(String name,String xclass,
            double point1,double point2,double point3);
   
    public List<Student> averageStudent(List<Student>students);
    
    public HashMap<String,Double> getPercentTypeStudent(List<Student>students);
    
}
