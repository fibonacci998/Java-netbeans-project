
public class Printer {
    String name;
    int speed; 
    public Printer() {}
    
    public Printer(int speed, String name) {
       this.name=name;
       this.speed=speed;
    }    

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }
    
    @Override
    public String toString(){
        return (this.speed+" "+this.name);
    }
}
