# MiniProject2_PBO
# Deskripsi Program 
pada program sistem penjadwalan praktikum yang menerapkan konsep oop dan juga ketentuan yang telah diberikan
# Fitur Utama
pada program yang saya buat memiliki fitur CRUD untuk mngelola data jadwal praktikum.antara lain:
1. tambah praktikum
2. lihat daftar praktikum
3. hapus praktikum
4. ubah jadwal praktium
5. keluar
# struktur program 
program yang saya buat tergbagi menjadi beberapa bagian 
- Main class: SistemPenjadwalanPraktikumyang berfungsi sebagai titik utama menjalankan program
- Model class:  Praktikum, PraktikumLab, dan PraktikumTeori digunakan untuk mewakili data praktikum. Kelas Praktikum merupakan parent class, sementara PraktikumLab dan PraktikumTeori adalah subclass yang mewarisi atribut dan method dari Praktikum.
- Service Class: PenjadwalanService berisi logika untuk melakukan operasi CRUD pada daftar praktikum.
- Interface: CRUDService adalah interface yang mendefinisikan metode CRUD untuk kelas layanan.
# Cara kerja Program 
1. Yang pastinya jalankan program, dan menu utama akan ditampilkan dengan beberapa pilihan.
2. lalu akan muncul opsi
   - tambah praktikum
   - lihat daftar praktikum
   - hapus praktikum
   - ubah jadwal praktikum
   - keluar
dan selesai jadi program yang saya buat merupakan pengelolaan jadwal praktikum dengan menerapkan ketentuan yang telah dibuat
# Berikut kode program yang telah saya buat

package com.mycompany.sistempenjadwalanpraktikum;

import model.Praktikum;
import service.PenjadwalanService;
import java.util.Scanner;
/**
 *
 * @author MyBook Hype AMD
 */
public class SistemPenjadwalanPraktikum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
         do {
            System.out.println("\nSistem Penjadwalan Praktikum Kelas B");
            System.out.println("1. Tambah Praktikum");
            System.out.println("2. Lihat Daftar Praktikum");
            System.out.println("3. Hapus Praktikum");
            System.out.println("4. Ubah Jadwal Praktikum");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Membaca newline

            switch (pilihan) {
                case 1:
                    // Tambah Praktikum
                    System.out.print("Masukkan kode praktikum: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan nama praktikum: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan jadwal praktikum: ");
                    String jadwal = scanner.nextLine();
                    Praktikum praktikumBaru = new Praktikum(kode, nama, jadwal);
                    PenjadwalanService.tambahPraktikum(praktikumBaru);
                    break;

                case 2:
                    // Tampilkan semua praktikum
                    PenjadwalanService.tampilkanPraktikum();
                    break;

                case 3:
                    // Hapus praktikum
                    System.out.print("Masukkan kode praktikum yang ingin dihapus: ");
                    String kodeHapus = scanner.nextLine();
                    PenjadwalanService.hapusPraktikum(kodeHapus);
                    break;

                case 4:
                    // Ubah jadwal praktikum
                    System.out.print("Masukkan kode praktikum yang ingin diubah: ");
                    String kodeUbah = scanner.nextLine();
                    System.out.print("Masukkan jadwal baru: ");
                    String jadwalBaru = scanner.nextLine();
                    PenjadwalanService.ubahJadwalPraktikum(kodeUbah, jadwalBaru);
                    break;

                case 5:
                    System.out.println("Keluar dari sistem...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan != 5);
       
    }
}

package model pada package ini saya menambahkan subclass dari praktikum terdapat 2 subclass praktiukm teori dan praktikum lab lalu menambahkan final keyword pada atribut kode prkatikum dan getter setter pada kode praktikum nama prkatikum dan jadwal yang mana bersifat private

package model;

/**
 *
 * @author MyBook Hype AMD
 */
public class Praktikum {
    
    private final String kodePraktikum;
    private String namaPraktikum;
    private String jadwal;

    // Constructor
    public Praktikum(String kodePraktikum, String namaPraktikum, String jadwal) {
        this.kodePraktikum = kodePraktikum;
        this.namaPraktikum = namaPraktikum;
        this.jadwal = jadwal;
    }

    // Getter dan Setter
    public String getKodePraktikum() {
        return kodePraktikum;
    }

    public String getNamaPraktikum() {
        return namaPraktikum;
    }

    public void setNamaPraktikum(String namaPraktikum) {
        this.namaPraktikum = namaPraktikum;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    // Method menampilkan informasi praktikum
    public void displayInfo() {
        System.out.println("Kode Praktikum: " + kodePraktikum);
        System.out.println("Nama Praktikum: " + namaPraktikum);
        System.out.println("Jadwal Praktikum: " + jadwal);
    }  
}

package model;

/**
 *
 * @author MyBook Hype AMD
 */
    public class PraktikumLab extends Praktikum {
        public PraktikumLab(String kodePraktikum, String namaPraktikum, String jadwal) {
            super(kodePraktikum, namaPraktikum, jadwal);
    }

    @Override
    public void displayInfo() {
        System.out.println("Praktikum Lab:");
        super.displayInfo();
    }
}

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


package service pada package ini saya menambahkan service crud

package service;
import model.Praktikum;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author MyBook Hype AMD
 */
    public class PenjadwalanService {

    private static List<Praktikum> daftarPraktikum = new ArrayList<>();

    // Method untuk menambah praktikum (static)
    public static void tambahPraktikum(Praktikum praktikum) {
        daftarPraktikum.add(praktikum);
        System.out.println("Praktikum berhasil ditambahkan!");
    }

    // Method untuk menampilkan semua praktikum (static)
    public static void tampilkanPraktikum() {
        System.out.println("\nDaftar Praktikum:");
        for (Praktikum praktikum : daftarPraktikum) {
            praktikum.displayInfo();
            System.out.println("------------------------");
        }
    }

    // Method untuk menghapus praktikum berdasarkan kode (static)
    public static void hapusPraktikum(String kodePraktikum) {
        for (Praktikum praktikum : daftarPraktikum) {
            if (praktikum.getKodePraktikum().equals(kodePraktikum)) {
                daftarPraktikum.remove(praktikum);
                System.out.println("Praktikum dengan kode " + kodePraktikum + " berhasil dihapus!");
                return;
            }
        }
        System.out.println("Praktikum tidak ditemukan!");
    }

    // Method untuk mengubah jadwal praktikum (static)
    public static void ubahJadwalPraktikum(String kodePraktikum, String jadwalBaru) {
        for (Praktikum praktikum : daftarPraktikum) {
            if (praktikum.getKodePraktikum().equals(kodePraktikum)) {
                praktikum.setJadwal(jadwalBaru);
                System.out.println("Jadwal praktikum berhasil diubah!");
                return;
            }
        }
        System.out.println("Praktikum tidak ditemukan!");
    }
}


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

package service;
import model.Praktikum;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author MyBook Hype AMD
 */
    public class PenjadwalanService {

    private static List<Praktikum> daftarPraktikum = new ArrayList<>();

    // Method untuk menambah praktikum (static)
    public static void tambahPraktikum(Praktikum praktikum) {
        daftarPraktikum.add(praktikum);
        System.out.println("Praktikum berhasil ditambahkan!");
    }

    // Method untuk menampilkan semua praktikum (static)
    public static void tampilkanPraktikum() {
        System.out.println("\nDaftar Praktikum:");
        for (Praktikum praktikum : daftarPraktikum) {
            praktikum.displayInfo();
            System.out.println("------------------------");
        }
    }

    // Method untuk menghapus praktikum berdasarkan kode (static)
    public static void hapusPraktikum(String kodePraktikum) {
        for (Praktikum praktikum : daftarPraktikum) {
            if (praktikum.getKodePraktikum().equals(kodePraktikum)) {
                daftarPraktikum.remove(praktikum);
                System.out.println("Praktikum dengan kode " + kodePraktikum + " berhasil dihapus!");
                return;
            }
        }
        System.out.println("Praktikum tidak ditemukan!");
    }

    // Method untuk mengubah jadwal praktikum (static)
    public static void ubahJadwalPraktikum(String kodePraktikum, String jadwalBaru) {
        for (Praktikum praktikum : daftarPraktikum) {
            if (praktikum.getKodePraktikum().equals(kodePraktikum)) {
                praktikum.setJadwal(jadwalBaru);
                System.out.println("Jadwal praktikum berhasil diubah!");
                return;
            }
        }
        System.out.println("Praktikum tidak ditemukan!");
    }
}
