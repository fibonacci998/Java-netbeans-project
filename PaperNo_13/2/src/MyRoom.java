

 
import java.util.*;

public class MyRoom implements IRoom { 

    @Override
    public List<Room> f1(List<Room> r, int size) {
        ArrayList<Room> temp=new ArrayList<Room>();
        for (Room x:r){
            if (x.getSize()>=size){
                temp.add(x);
            }
        }
        return temp;
    }
    public static Comparator obj=new Comparator(){
        @Override
        public int compare(Object t, Object t1) {
            Room p1=(Room)t;
            Room p2=(Room)t1;
            int d=p1.getSize()-p2.getSize();
            if (d<0) return 1;
            if (d==0) return 0;
            return -1;
        }
    };
    @Override
    public void f2(List<Room> r) {
        int size=r.size();
        if (size%2==0){
            Collections.sort(r);
        }else{
            Collections.sort(r,obj);
        }
    }

     
}
