
public class Room implements Comparable{   
    String name;
    int size;
    public Room(String name, int size) {
        this.name=name;
        this.size=size;
    }

    public String getName() {
        return this.name;
    }
    public int getSize(){
        return this.size;
    }
    //add and complete you other methods (if needed) here   

    @Override
    public int compareTo(Object t) {
        Room temp=(Room) t;
        return this.name.compareToIgnoreCase(temp.getName());
    }

    
}
