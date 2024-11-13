/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bulcehilos2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Contabilidad {
    private final Map<Integer, Usuario> usuarios;
    private final Random random = new Random();

    public Contabilidad(int numeroUsuarios) {
        usuarios = new HashMap<>();
        for (int i = 1; i <= numeroUsuarios; i++) {
            double saldoInicial = 1000 + (500 * random.nextDouble()); // Saldo inicial aleatorio entre 1000 y 1500 euros
            usuarios.put(i, new Usuario(i, saldoInicial));
        }
    }

    //synchronized
    
    public  void realizarTransaccion(int origen, int destino, double cantidad) {
        if (origen != destino && usuarios.get(origen).getSaldo() >= cantidad) {
            usuarios.get(origen).restarSaldo(cantidad);
            usuarios.get(destino).agregarSaldo(cantidad);
            System.out.printf("Transaccion: %d -> %d, Cantidad: %.2f euros\n", origen, destino, cantidad);
        }
    }

    public double calcularSaldoTotal() {
        return usuarios.values().stream().mapToDouble(Usuario::getSaldo).sum();
    }

    public Map<Integer, Usuario> getUsuarios() {
        return usuarios;
    }
}
