
package EstanciaPersistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public abstract class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String user = "root";
    private final String password = "root";
    private final String database = "estancias_exterior";
    private final String driver = "com.mysql.jdbc.Driver";
    
    protected void conectarBase() throws Exception {
        try {
            Class.forName(driver);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
            conexion = (Connection) DriverManager.getConnection(urlBaseDeDatos, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
    
    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = (Statement) conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            // conexion.rollback();
            /*  Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda */
            
            throw ex;
        } finally {
            desconectarBase();
        }
    }
    
    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = (Statement) conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}


