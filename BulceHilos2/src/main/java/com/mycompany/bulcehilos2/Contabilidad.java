/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bulcehilos2;

import java.util.ArrayList;

/**
 *
 * @author Hector.garaboacasas
 */
public class Contabilidad {
    
    public Contabilidad(ArrayList<Usuario> listaUser){
        
        Double dineroinicial=0.0;
        
        for(int i=0;i<100;i++){
            
        double a=(Math.random()*1500)+1;
        double dinero=(double)Math.round(a * 100d) / 100d;
        
        int id=(int)(Math.random()*100);
        
        
        
        Usuario user=new Usuario(id, dinero);
        
        listaUser.add(user);
        
        dineroinicial+=dinero;
            
        }
        
        System.out.println(dineroinicial);
        
    
        
        
        
       
        
        
        
    }
    public void inicializar(ArrayList<Usuario> listaUser, int trans){
        
        int id1=(int)(Math.random()*100);
        
      Usuario user1= listaUser.get(id1);
      
      int id2=(int)(Math.random()*100);
      
      Usuario user2= listaUser.get(id2);
      
      
      
      //da nums negativos
      double bizum= (double)Math.round(((Math.random()*500)+1) * 100d) / 100d;
      
      if(user1!=user2){
          System.out.println("transaccion nº " + trans +" entre: ");
          
          double user1dinero=user1.getDinero();
          
          double user1dinerofinal=user1dinero-bizum;
          
          user1.setDinero(user1dinerofinal);
          
         double user2dinero=user2.getDinero();
          
          user2.setDinero(user2dinero);
          
          
          System.out.println(user1.toString() + " Emisor");
          System.out.println(" transaccion de "+ bizum + " euros");
          System.out.println(user2.toString() +" receptor");
          
          System.out.println("-----------------------------");
      }
      if(user1==user2){
          System.out.println(" Mismo usuario " + user1.getId());
          System.out.println("-----------------------------");
      }
      
      
      
       
        
        
        
    }
    
//    public static void main(String[] args) {
//        
//        
//        for(int i =0;i<10000;i++){
//        
//        
//        double a=(Math.random()*500)+1;
//        System.out.println((double)Math.round(a * 100d) / 100d);
//        }
//    }
}
