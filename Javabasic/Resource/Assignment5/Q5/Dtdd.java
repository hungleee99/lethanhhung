/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5.Ex2.Q5;

/**
 *
 * @author admin
 */
public abstract class Dtdd implements IVukhi{
   public void nghe(){
       System.out.println("Đang nghe......");
   }
   public void goi(){
       System.out.println("Đang gọi.......");
   }
   public void soantn(){
       System.out.println("Đang soạn tin nhắn...");
   }
   public void guitn(){
       System.out.println("Đang gửi tin nhắn...");
   }

    @Override
    public abstract void Tancongkexau();
   
}
