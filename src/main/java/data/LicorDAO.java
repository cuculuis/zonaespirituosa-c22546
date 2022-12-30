package data;

import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Licor;

public class LicorDAO {
    private static final String SQL_SELECT = "SELECT * FROM licores";
    private static final String SQL_SELECT_BY_ID = "SELECT idlicor, tipo, marca, precio, stock FROM licores WHERE idlicor = ?";
   
    private static final String SQL_INSERT = "INSERT INTO licores(tipo, marca, precio, stock) VALUES(?, ?, ?, ?)";
    
    //private static final String SQL_UPDATE = "UPDATE users SET username = ?, password = ? WHERE iduser = ?";
    
    private static final String SQL_DELETE = "DELETE FROM licores WHERE idlicor = ?";
   
    
    public List<Licor> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Licor licor = null;
        List<Licor> licores = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idlicor = rs.getInt(1);
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                Double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");

                licor = new Licor(idlicor, tipo, marca, precio, stock);

                licores.add(licor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LicorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return licores;
    }
    
    public int insertar(Licor licor){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, licor.getTipo());
            stmt.setString(2, licor.getMarca());
            stmt.setDouble(3, licor.getPrecio());
            stmt.setInt(4, licor.getStock());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LicorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);               
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
//    public int actualizar(Licor licor){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registros = 0;
//        try {
//            conn = getConexion();
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getPassword());
//            stmt.setInt(3, user.getIduser());
//            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
//        finally{
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//        return registros;
//    }
//    
//    public int actualizarNombre(String username,String newname){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registros = 0;
//        Users user = seleccionarPorNombre(username);
//        user.setUsername(newname);
//        try {
//            conn = getConexion();
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getPassword());
//            stmt.setInt(3, user.getIduser());
//            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
//        finally{
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//        return registros;
//    }
    
     public int eliminar(Licor licor){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, licor.getIdlicor());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LicorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
    public Licor seleccionarPorId(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Licor licor = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idlicor = rs.getInt("idlicor");
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");

                licor = new Licor(idlicor, tipo, marca, precio, stock);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LicorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return licor;
    }   
}
