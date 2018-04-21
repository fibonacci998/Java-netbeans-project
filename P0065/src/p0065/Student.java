/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0065;

/**
 *
 * @author tuans
 */
public class Student {
    private String name;
    private String classes;
    private double math;
    private double chemistry;
    private double physics;
    private double average;
    private String type;

    public Student(String name, String classes, double math, double chemistry, double physics) {
        this.name = name;
        this.classes = classes;
        this.math = math;
        this.chemistry = chemistry;
        this.physics = physics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

   
    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getPhysics() {
        return physics;
    }
    public void setPhysics(double physics) {
        this.physics = physics;
    }
    public void setAve(double ave){
        this.average=ave;
    }
    public double getAve(){
        return this.average;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
}
