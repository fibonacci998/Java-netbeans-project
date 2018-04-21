/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ReadOnlyBufferException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuans
 */
public class P0025 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        String text="";
              
        FileReader fileReader=initFileReader("input.txt");
        BufferedReader bufferReader=new BufferedReader(fileReader);
        
        FileWriter fileWriter=initFileWriter("output.txt");
        BufferedWriter bufferWriter=new BufferedWriter(fileWriter);
       
        try {
            String currentLine;
            while (bufferReader.ready() && (currentLine=bufferReader.readLine())!=null){
                if (currentLine=="")continue; 
                
                currentLine=fixUpperCaseLetter(currentLine);
         
                currentLine=fixSpaceInText(currentLine);

                currentLine=addDotAtEndText(currentLine);
                
                bufferWriter.write(currentLine+" ");
            }
        } catch (IOException ex) {
            Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            bufferReader.close();
            bufferWriter.close();
            fileReader.close();
            fileWriter.close();
        } catch (Exception e) {
             Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        
//        closeReader(fileReader,bufferReader);
//        closeWriter(fileWriter,bufferWriter);
    }

    private static String getInputFromFile() {
        String contentOfFile=new String();
        FileReader fileReader=null;
        BufferedReader bufferReader=null;
        try {
            fileReader=new FileReader("input.txt");
            bufferReader=new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine=bufferReader.readLine())!=null){
                contentOfFile+=(currentLine+" ");
            }
            bufferReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Your file not exits");
        } catch (ReadOnlyBufferException e){
            System.out.println("Error can not read from file");
        } catch (IOException e ){
            System.out.println("IO error");
        }
        
        return contentOfFile;
    }

    private static void writeTextToFile(String text) {
        FileWriter fileWriter=null;
        BufferedWriter bufferWriter=null;
        try {
            fileWriter=new FileWriter("output.txt");
            bufferWriter=new BufferedWriter(fileWriter);
            bufferWriter.write(text);
            bufferWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String fixSpaceInText(String text) {
        //keep 1 space between word
        StringBuilder temp=new StringBuilder(text);
        while (temp.charAt(0)==' ') temp.deleteCharAt(0);
        while (temp.charAt(temp.length()-1)==' ') temp.deleteCharAt(temp.length()-1);
        
        
        for (int i=temp.length()-1;i>0;i--){
            if (temp.charAt(i)==' ' && temp.charAt(i-1)==' '){
                temp.deleteCharAt(i);
            }
        }
        //keep 1 space between word after . , : 
        for (int i=0;i<temp.length()-1;i++){
            while ((temp.charAt(i)==','||temp.charAt(i)=='.'||temp.charAt(i)==';')
                    &&temp.charAt(i+1)==' ' && temp.charAt(i+2)==' '){
                temp.deleteCharAt(i+2);
            }
        }
        //no space between word before . , :
        for (int i=1;i<temp.length();i++){
            while ((temp.charAt(i)==','||temp.charAt(i)=='.'||temp.charAt(i)==';')
                    && temp.charAt(i-1)==' '){
                temp.deleteCharAt(i-1);
                if (i==temp.length()){
                    break;
                }
            }
        }
        
        //no space between open and close quote
        int i=0;
        while (i<temp.length()){
            if (temp.charAt(i)=='"'){
                int pos=0;
                for (int j=i+1;j<temp.length()-1;j++){
                    if (temp.charAt(j)=='"'){
                        pos=j;
                        break;
                    }
                }
                if (pos==0){
                    i++;
                    continue;
                }
                while (temp.charAt(pos-1)==' '&& (pos-1)>=0) 
                    temp.deleteCharAt(pos-1);
                while (temp.charAt(i+1)==' ') 
                    temp.deleteCharAt(i+1);
                
                i=pos+1;
            }else
                i++;
        }
        return temp.toString();
    }

    private static String fixUpperCaseLetter(String text) {
        text=text.toLowerCase();
        StringBuilder temp=new StringBuilder(text);
        int firstCharacter=0;
        while(true){
            if (Character.isAlphabetic(temp.charAt(firstCharacter))){
                temp.setCharAt(firstCharacter, Character.toUpperCase(temp.charAt(firstCharacter)));
                break;
            }
            firstCharacter++;
        }
        
        //upper case after dot
        for (int i=0;i<temp.length()-1;i++){
            if (temp.charAt(i)=='.'){          
                for (int j=i;j<temp.length();j++){
                    char ch=temp.charAt(j);
                    if (Character.isLowerCase(ch)){
                        temp.setCharAt(j, Character.toUpperCase(ch));
                        break;
                    }
                }
                
            }
        }
        return temp.toString();
    }

    private static String addDotAtEndText(String text) {
        StringBuilder temp=new StringBuilder(text);
        if (temp.charAt(temp.length()-1)!='.')
            temp.append(".");
        return temp.toString();
    }

    private static void initReader(FileReader fileReader, BufferedReader bufferReader) {
        try {
            fileReader=new FileReader("input.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, ex);
        }
        bufferReader=new BufferedReader(fileReader);
    }

    private static void initWriter(FileWriter fileWriter, BufferedWriter bufferWriter) {
        try {
            fileWriter=new FileWriter("output.txt");
        } catch (IOException ex) {
            Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, ex);
        }
        bufferWriter=new BufferedWriter(fileWriter);
    }

    private static void closeReader(FileReader fileReader, BufferedReader bufferReader) {
        try {
            fileReader.close();
            bufferReader.close();
        } catch (IOException ex) {
            Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void closeWriter(FileWriter fileWriter, BufferedWriter bufferWriter) {
        try {
            fileWriter.close();
            bufferWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void init(FileReader fileReader) {
        fileReader=null;
    }

    private static FileReader initFileReader(String nameFileInput) {
        FileReader fileReader=null;
        try {
            fileReader=new FileReader(nameFileInput);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileReader;
    }

    private static FileWriter initFileWriter(String nameFileOutput) {
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(nameFileOutput);
        } catch (IOException ex) {
            Logger.getLogger(P0025.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileWriter;
    }
    
}
