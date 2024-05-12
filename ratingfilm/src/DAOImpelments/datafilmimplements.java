/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImpelments;
import java.util.List;
import model.*;
/**
 *
 * @author MSI GF63
 */
public interface datafilmimplements {
    public void insert (datafilm p);
    public void update (datafilm p);
    public void delete (String Judul);
    public List<datafilm> getAll();
}
