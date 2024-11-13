/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bulcehilos2;

/**
 *
 * @author Hector.garaboacasas
 */
public class Usuario {
    private final int id;
    private double saldo;

    public Usuario(int id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void agregarSaldo(double cantidad) {
        saldo += cantidad;
    }

    public void restarSaldo(double cantidad) {
        saldo -= cantidad;
    }
}
