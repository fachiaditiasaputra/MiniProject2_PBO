/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyBook Hype AMD
 */
    public class PraktikumTeori extends Praktikum {
        public PraktikumTeori(String kodePraktikum, String namaPraktikum, String jadwal) {
            super(kodePraktikum, namaPraktikum, jadwal);
    }

    @Override
    public void displayInfo() {
        System.out.println("Praktikum Teori:");
        super.displayInfo();
    }
}

