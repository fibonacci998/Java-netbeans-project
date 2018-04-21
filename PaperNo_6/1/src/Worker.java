
public class Worker extends Person{  
    double workingHour;
    double paymentRate;
    public Worker() {
        super();
    }
    
    public Worker(String name, double hours, double rate) { 
        super(name);
        this.workingHour=hours;
        this.paymentRate=rate;
    }   
    
     /*Complete the below function for second test case*/
    public double getIncome() {
        double incomeTax;
        double salary=this.workingHour*this.paymentRate;
        if (salary>5000) incomeTax=(10*1.0/100)*salary;
        else incomeTax=(5*1.0/100)*salary;
        return (salary+incomeTax);
    }  
    
    @Override
    public String toString(){
        return this.name+' '+this.workingHour+' '+this.paymentRate;
    }
    //add and complete your other methods here (if needed)

}
