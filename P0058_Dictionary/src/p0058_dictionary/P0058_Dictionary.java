/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0058_dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuans
 */
class Dictionary{
    private HashMap<String, String> dictionary;
    final File saveFile=new File("save.txt");
    final Scanner sc=new Scanner(System.in);
    
    public Dictionary(){
        dictionary = new HashMap<>();
        loadDataFromFile();  
    }
    public void addWord(String eng, String viet) throws IOException{
        if (dictionary.get(eng)==null){
            dictionary.put(eng.toLowerCase(), viet);
            FileWriter fw = new FileWriter(saveFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(eng+"|"+viet);
            out.close();bw.close();fw.close();
        }
    }
    public void deleteWord(String eng) throws FileNotFoundException, IOException{
        dictionary.remove(eng);
        File tempFile=new File("temp.txt");
        BufferedReader br1=new BufferedReader(new FileReader(saveFile));
        BufferedWriter br2=new BufferedWriter(new FileWriter(tempFile));
        String current;
        while ((current=br1.readLine())!=null){
            String temp=current.trim();
            if (temp.substring(0, eng.length()).compareToIgnoreCase(eng)==0) 
                continue;
            br2.write(temp+System.getProperty("line.separator"));
        }
        br1.close();
        br2.close();
        boolean del=saveFile.delete();
        //System.out.println(del);
        boolean check=tempFile.renameTo(saveFile);
        //System.out.println(check);
        tempFile.delete();

    }
    public String searchWord(String eng){
        return (dictionary.get(eng.toLowerCase()));
    }

    private void loadDataFromFile() {
        FileReader fr = null;
        BufferedReader br;
        if (!saveFile.exists()){
            try {
                saveFile.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error when create file save dictionary!");
            }
        }
        try {
            fr=new FileReader(saveFile);
            br=new BufferedReader(fr);
            String current;
            while ((current=br.readLine())!=null){
                StringTokenizer st=new StringTokenizer(current,"|");
                String temp1=st.nextToken();
                String temp2=st.nextToken();
                dictionary.put(temp1, temp2);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("File save not found!!");
        }
    }
}
public class P0058_Dictionary {
    static Scanner sc=new Scanner(System.in);
    static int getValidNum(int min,int max){
        while(true){
            try {
                int temp=Integer.parseInt(sc.nextLine());
                if (temp<min || temp>max) throw new Exception();
                return temp;
            } catch (Exception e) {
                System.out.print("Please enter valid integer"
                        + " from "+min+" to "+max+": ");
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Dictionary myDictionary=new Dictionary();
        
        displayMenu();
        
        while(true){
            System.out.print("Enter your choose: ");
            int choose=getValidNum(1, 4);
            switch (choose){
                case 1: addWordFunction(myDictionary);
                        break;
                case 2: deleteWordFunction(myDictionary);
                        break;
                case 3: translateFunction(myDictionary);
                        break;
                case 4: return;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("====Dictionary program====");
        System.out.println("\t1. Add Word\n\t2. Delete word\n"
                + "\t3. Translate\n\t4. Exit");
    }

    private static void addWordFunction(Dictionary myDictionary) throws IOException {
        System.out.println("----------Add-------");
        System.out.print("Enter English: ");
        String eng=sc.nextLine();
        System.out.print("Enter Vietnamess: ");
        String viet=sc.nextLine();
        String search=myDictionary.searchWord(eng);
        if (search==null){
            myDictionary.addWord(eng, viet);
            System.out.println("Successful");
        }else{
            System.out.print("Do you want to update?(y/n): ");
            String choose=sc.nextLine();
            if (choose.compareToIgnoreCase("n")==0) return;
            myDictionary.deleteWord(eng);
            myDictionary.addWord(eng, viet);
            System.out.println("Successful");
        }
    }

    private static void deleteWordFunction(Dictionary myDictionary) throws IOException {
        System.out.println("--------Delete-------");
        System.out.print("Enter English: ");
        String eng=sc.nextLine();
        String search=myDictionary.searchWord(eng);
        if (search==null){
            System.out.println("Word not found in database!");
        }else{
            myDictionary.deleteWord(eng);
            System.out.println("Successful");
        }
    }

    private static void translateFunction(Dictionary myDictionary) throws IOException {
        System.out.println("-----Translate------");
        System.out.print("Enter English: ");
        String eng=sc.nextLine();
        String search=myDictionary.searchWord(eng);
        if (search==null){
            System.out.println("Word not found in database!");
        }else{
            System.out.println("Vietnamese: "+search);
        }
    }
    
}
