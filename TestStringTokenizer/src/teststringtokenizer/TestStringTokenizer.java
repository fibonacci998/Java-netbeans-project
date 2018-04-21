/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teststringtokenizer;

import java.util.StringTokenizer;

/**
 *
 * @author tuans
 */
public class TestStringTokenizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String string="\tR [label=\"RED\",color=\"red\"]";
        StringTokenizer st=new StringTokenizer(string,"\t ");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
    
}
