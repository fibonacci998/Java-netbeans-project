public class Person {
    String name;
    int age;
    Person(){}
    Person(String xname,int xage){
        this.name=xname;
        this.age=xage;
    }
    public String toString(){
        String s="["+name+","+age+"]";
        return s;
    }
}
