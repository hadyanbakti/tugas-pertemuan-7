/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdatafilm.datafilmDAO;
import DAOImpelments.datafilmimplements;
import model.*;
import view.Mainv;
        
/**
 *
 * @author MSI GF63
 */
public class datafilmcontroller {
    Mainv frame;
    datafilmimplements impldatafilm;
    List <datafilm> dp;
    
    public datafilmcontroller(Mainv frame){
    this.frame = frame;
    impldatafilm = new datafilmDAO();
    dp = impldatafilm.getAll();
    }
    public void isitabel(){
    dp = impldatafilm.getAll();
    modeltabeldatafilm mp = new modeltabeldatafilm(dp);
    frame.gettabeldatafilm().setModel(mp);
    }
    
    public void insert(){
        datafilm dp = new datafilm();
    double txtalur = Double.parseDouble(frame.getInAlur().getText());
    double txtpenokohan = Double.parseDouble(frame.getInPenokohan().getText());
    double txtakting = Double.parseDouble(frame.getInAkting().getText());
    double txtnilai = (txtalur+txtpenokohan+txtakting)/3;
    
    dp.setJudul(frame.getInJudul().getText());
    dp.setAlur(txtalur);
    dp.setAkting(txtakting);
    dp.setPenokohan(txtpenokohan);
    dp.setNilai(txtnilai);
    impldatafilm.insert(dp);
    }
    
    public void update(){
     datafilm dp = new datafilm();
    double txtalur = Double.parseDouble(frame.getInAlur().getText());
    double txtpenokohan = Double.parseDouble(frame.getInPenokohan().getText());
    double txtakting = Double.parseDouble(frame.getInAkting().getText());
    double txtnilai = (txtalur+txtpenokohan+txtakting)/3;
    
    dp.setJudul(frame.getInJudul().getText());
    dp.setAlur(txtalur);
    dp.setAkting(txtakting);
    dp.setPenokohan(txtpenokohan);
    dp.setNilai(txtnilai);
    impldatafilm.update(dp);
    }
    
    public void delete(){
    String judul = frame.getInJudul().getText();
    impldatafilm.delete(judul);
    }
    
    public void clear(){
    frame.getInJudul().setText(null);
    frame.getInAlur().setText(null);
    frame.getInPenokohan().setText(null);
    frame.getInAkting().setText(null);
    }
    
}
