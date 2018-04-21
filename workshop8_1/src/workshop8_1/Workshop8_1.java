/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop8_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Workshop8_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(new File("input.txt"));
        Writer out=new FileWriter("output.txt");
        
        while (in.hasNextLine()){
            String temp=in.nextLine();
            for (int i=0;i<temp.length();i++){
                char ch=(char) (temp.charAt(i)+3);
                    out.write(ch);
            }
        }
        out.flush();
        out.close();
    }
}
