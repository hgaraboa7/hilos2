/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bulcehilos2;

/**
 *
 * @author hector.garaboacasas
 */
public class Usuario {

    public int id;

    public Double dinero;

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", dinero=" + dinero + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getDinero() {
        return dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }

    public Usuario(int id, Double dinero) {
        this.id = id;
        this.dinero = dinero;
    }

}
