
public class ColorPrinter extends Printer {
    double price;
    String color;
    public ColorPrinter() {
        super();
    }
    
    public ColorPrinter(String name, double price, int speed, String color) {
        super(speed,name);
        this.price=price;
        this.color=color;
    }    
    
    public double getSalePrice() {
         if (this.speed<40){
             return this.price-this.price*10.0/100;
         }
         return this.price-this.price*5.0/100;
    }
    @Override
    public String toString(){
        return (super.getSpeed()+" "+super.getName()+" "+this.color+" "+this.price);
    }
  
}
