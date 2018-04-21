

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Counter {
    
    
    public static String input()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
        return content;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if ("hello".compareTo("world")>0){
            System.out.println("Lon hon");
        }
        else System.out.println("Nho hon");
        HashMap<Character, Integer> charCounter = 
            new HashMap<Character, Integer>();
    
        HashMap<String, Integer> wordCounter =

            new HashMap<String, Integer>();
        String content=input();
       
        analyze(content,charCounter,wordCounter);
        display(charCounter,wordCounter);
    }
    
    public static void display(HashMap<Character, Integer> charCounter,HashMap<String, Integer> wordCounter) {
        
        Iterator it = wordCounter.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }      
    }
    
    public static void analyze(String content,HashMap<Character, Integer> charCounter,HashMap<String, Integer> wordCounter) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }
}
