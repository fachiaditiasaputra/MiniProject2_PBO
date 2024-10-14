/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Praktikum;
import java.util.List;
/**
 *
 * @author MyBook Hype AMD
 */
    public interface CRUDService {
        void tambahPraktikum(Praktikum praktikum);
        List<Praktikum> tampilkanPraktikum();
        boolean hapusPraktikum(String kodePraktikum);
        boolean ubahJadwalPraktikum(String kodePraktikum, String jadwalBaru);
    }