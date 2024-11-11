package com.mycompany.bulcehilos2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BucleHilos2 {

    public static void main(String[] args) {
        
        ArrayList<Usuario> listaUsers=new ArrayList();
        
        int NUM_HILOS=1000;
                Thread[] transacciones;
                
                Contabilidad cont= new Contabilidad(listaUsers);
                
                Contador contador=new Contador();

                transacciones=new Thread[NUM_HILOS];
                for (int i=0;i<NUM_HILOS;i++){
                        MyRun t=new MyRun(cont, contador,listaUsers);
                        Thread hilo=new Thread(t);
                        hilo.setName("Hilo: "+i);
                       
                        transacciones[i]=hilo;
                }
                
                for (int i=0;i<NUM_HILOS;i++){
                        transacciones[i].start();
                }


                for (int i=0; i<NUM_HILOS; i++){
                        Thread hilo=transacciones[i];
                        try {hilo.join();} 
                        catch (InterruptedException e) {
                                
                        }
                }
                
                System.out.println("Cuenta final: " + contador.getCuenta());
                System.out.println("El principal ha terminado");
    }
}

class MyRun implements Runnable{
    
     
        
        Contabilidad cont;
        Contador contador;
         ArrayList<Usuario> listaUsers;
        
        public MyRun(Contabilidad cont,Contador contador,ArrayList<Usuario> listaUsers  ) {
            this.cont = cont;
            
            this.contador=contador;
            
            this.listaUsers=listaUsers;
        }
    
        @Override
        public void run() {
            
            for (int i=0; i<100;i++){
                
               int trans = contador.incrementar();
                cont.inicializar(listaUsers, trans);
            }
            
            /*Thread hiloActual=Thread.currentThread();
            String miNombre=hiloActual.getName();
            System.out.println("Inicio el hilo "+miNombre);
            
            try {Thread.sleep(0);} // Variamos la espera y comprobamos lo que ocurre
            catch (InterruptedException ex) {Logger.getLogger(MyRun.class.getName()).log(Level.SEVERE, null, ex);}
            
            System.out.println("Final del hilo "+miNombre);*/
                
        }
}

class Contador{
        int cuenta;
        public Contador(){
                cuenta=0;
        }
        public  int incrementar(){ // sección crítica. Es el pedazo de código en el que quiero
            
            cuenta=cuenta+1;                // que entren los transacciones "por orden", sin estorbarse.
       
        return cuenta;
        
        }
        public int getCuenta(){
                return cuenta;
        }
}
