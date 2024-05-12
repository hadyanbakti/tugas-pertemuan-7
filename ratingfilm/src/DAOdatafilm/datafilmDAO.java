/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatafilm;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImpelments.datafilmimplements;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author MSI GF63
 */
public class datafilmDAO implements datafilmimplements{
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?,?,?,?,?)";
    final String update = "Update movie set alur=?, penokohan=?, akting=?, nilai=? where judul=?";
    final String delete = "Delete from movie where judul=?";
    
    public datafilmDAO(){
    connection = connector.connection();
    }

    @Override
    public void insert(datafilm p) {
         PreparedStatement statement = null;
        try{
            if(p.getAlur() < 0 || p.getAlur() > 5 || p.getPenokohan() < 0 || p.getPenokohan() > 5 || p.getAkting() < 0 || p.getAkting() > 5){
                throw new SQLException("Rentang Nilai harus di antara 0 - 5");
            }
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            statement.setDouble(5, p.getNilai());
            statement.executeUpdate();
            throw new SQLException("Data Movie Berhasil Ditambahkan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
  

    @Override
    public void update(datafilm p) {
       PreparedStatement statement = null;
        try{
            if(p.getAlur() < 0 || p.getAlur() > 5 || p.getPenokohan() < 0 || p.getPenokohan() > 5 || p.getAkting() < 0 || p.getAkting() > 5){
                throw new SQLException("Rentang ilai harus di antara 0 - 5");
            }
            statement = connection.prepareStatement(update);
            statement.setString(5, p.getJudul());
            statement.setDouble(1, p.getAlur());
            statement.setDouble(2, p.getPenokohan());
            statement.setDouble(3, p.getAkting());
            statement.setDouble(4, p.getNilai());
            statement.executeUpdate();
            throw new SQLException("Data Movie Berhasil Diupdate");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String Judul) {
     PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, Judul);
            statement.executeUpdate();
            throw new SQLException("Data Movie Berhasil Di Delete");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        } 
    }

    @Override
    public List<datafilm> getAll() {
    List<datafilm> dp = null;
    try{
        dp = new ArrayList<datafilm>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()){
        datafilm fl = new datafilm();
        fl.setJudul(rs.getString("Judul"));
        fl.setAlur(rs.getInt("Alur"));
        fl.setPenokohan(rs.getInt("Penokohan"));
        fl.setAkting(rs.getInt("Akting"));
        fl.setNilai(rs.getInt("Nilai"));
        dp.add(fl);
        }
    }catch(SQLException ex){
    Logger.getLogger(datafilmDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return dp;
    }
}
