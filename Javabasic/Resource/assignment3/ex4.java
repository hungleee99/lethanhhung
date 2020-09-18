/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author admin
 */
public class ex4 {
    
    
    public static void main(String[] args) throws IOException {  
     //Q3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // doc 
        
        String name = br.readLine();
        // cat vtri dau va viet hoa
        String s1 = name.substring(0, 1).toUpperCase();
        String nameCapitalized = s1 + name.substring(1);
        System.out.println(nameCapitalized);
      //Q4
        String name1 = br.readLine();
        String v1 = name1.substring(0, 1).toUpperCase();
        String v2 = name1.substring(1, 2).toUpperCase();
        String v3 = name1.substring(2, 3).toUpperCase();
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
      //Q15
        System.out.println("I am developer \n");
//        System.out.println(reverseWord1("I am developer"));
//        System.out.println(reverseWord1(""));
//        System.out.println(reverseWord1(null));
        System.out.println(reverseWord2("I am developer"));

    }
    //cach 1
    /*public static String reverseWord1(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        List<String> words = Arrays.asList(sentence.split("\\s"));
        StringBuilder sb = new StringBuilder(sentence.length());

        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i));
            sb.append(' ');
        }

        return sb.toString().trim();
    }*/
    //cach 2
    public static String reverseWord2(String line) {
        if (line.trim().isEmpty()) {
            return line;
        }

        StringBuilder reverse = new StringBuilder();
        String[] sa = line.trim().split("\\s");

        for (int i = sa.length - 1; i >= 0; i--) {
            reverse.append(sa[i]);
            reverse.append(' ');
        }

        return reverse.toString().trim();
    }

}
