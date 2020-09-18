/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3;
import java.text.Collator;
import java.util.Collections;
import java.util.Locale;
import java.util.Vector;
import java.util.Arrays;

public class ex5 {

  public ex5() {
    Vector<String> list = new Vector<String>(Arrays.asList(new String[]{"Accounting","Department","Sale","Marketing"}));
    Collator collate = Collator.getInstance(new Locale("vi"));
    Collections.sort(list, collate);

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      result.append(list.elementAt(i));
      result.append(" ");
    }
    System.out.println(result.toString());
  }

  public static void main(String s[]) {
    ex5 vn = new ex5();
  }
}