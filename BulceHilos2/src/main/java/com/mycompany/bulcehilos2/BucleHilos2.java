package com.mycompany.bulcehilos2;
import java.util.Random;

public class BucleHilos2 {
    public static void main(String[] args) {
        int numeroUsuarios = 10; 
        int numeroTransacciones = 10000;

        Contabilidad contabilidad = new Contabilidad(numeroUsuarios);
        double saldoInicial = contabilidad.calcularSaldoTotal();
        System.out.printf("Saldo total inicial: %.2f euros\n", saldoInicial);

        Thread[] hilos = new Thread[numeroTransacciones];
        Random random = new Random();

        for (int i = 0; i < numeroTransacciones; i++) {
            hilos[i] = new Thread(() -> {
                int origen = random.nextInt(numeroUsuarios) + 1;
                int destino = random.nextInt(numeroUsuarios) + 1;
                double cantidad = 0.01 + (500 - 0.01) * random.nextDouble(); 
                contabilidad.realizarTransaccion(origen, destino, cantidad);
            });
            hilos[i].start();
        }

          for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double saldoFinal = contabilidad.calcularSaldoTotal();
        System.out.printf("Saldo total final: %.2f euros\n", saldoFinal);

     
        if (Math.abs(saldoInicial - saldoFinal) < 0.01) {
            System.out.println("La contabilidad es correcta.");
        } else {
            System.out.println("La contabilidad tiene inconsistencias.");
        }
    }
}
