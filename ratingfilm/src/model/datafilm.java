/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI GF63
 */
public class datafilm {
    private String Judul;
    private double Alur;
    private double Penokohan;
    private double Akting;
    private double Nilai;
    
    public String getJudul(){
    return Judul;
    }
    public void setJudul(String Judul){
    this.Judul = Judul;
    }
    public double getAlur(){
    return Alur;
    }
    public void setAlur(double Alur){
    this.Alur = Alur;
    }
    public double getPenokohan(){
    return Penokohan;
    }
    public void setPenokohan(double Penokohan){
    this.Penokohan = Penokohan;
    }
    
    public double getAkting(){
    return Akting;
    }
    public void setAkting(double Akting){
    this.Akting = Akting;
    }
    public double getNilai(){
    return (Alur+Penokohan+Akting)/3;
    }
    public void setNilai(double Nilai){
    this.Nilai = Nilai;
    }
}
