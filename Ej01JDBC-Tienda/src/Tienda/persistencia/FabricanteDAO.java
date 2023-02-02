package Tienda.persistencia;

import Tienda.entidades.Fabricante;
import java.util.ArrayList;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public final class FabricanteDAO extends DAO {

    public void IngresarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("Debe ingresar un fabricante");
            }
            String sql = "insert into Fabricante (codigo, nombre) values ('" + fabricante.getCodigo() + "','" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }
    
    public Fabricante BuscarFabricantepornombre(String nombrenuevo) throws Exception {
        try {
            String sql = "select * from fabricante where nombre like '"+ nombrenuevo +"';";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Fabricante BuscarFabricanteporcodigo(Integer codigonuevo) throws Exception {
        try {

            String sql = "select * from fabricante where codigo = '" + codigonuevo + "'";
            consultarBase(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            System.out.println("");
            throw e;
        }
    }

    public ArrayList<Fabricante> MostrarFabricantes() throws Exception {
        try {
            String sql = "SELECT * from fabricante";
            consultarBase(sql);
            Fabricante fabricante = null;
            ArrayList<Fabricante> fabri;
            fabri = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setNombre(resultado.getString(2));
                fabricante.setCodigo(resultado.getInt(1));
                fabri.add(fabricante);
            }
            System.out.println("----------------------------------");
            System.out.println("    Fabricantes de la Tienda");
            System.out.println("----------------------------------");
            for (Fabricante aux : fabri) {
                System.out.println("");
                System.out.println("Codigo Fabricante: " + aux.getCodigo() + " --- Nombre: " + aux.getNombre());
            }
            System.out.println("");
            desconectarBase();
            return fabri;
        } catch (Exception e) {
            System.out.println("Error de Base de Datos");
            desconectarBase();
            throw e;
        }
    }
    
//    public Fabricante BuscarFabricantepornombre1() throws Exception {
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//        try {
//            System.out.println("Ingrese nombre");
//            String nombrenuevo = leer.next();
//            String sql = "select producto.nombre from fabricante inner join producto on producto.codigo_fabricante = fabricante.codigo where fabricante.nombre like '"+ nombrenuevo +"';";
//            consultarBase(sql);
//            Fabricante fabricante = null;
//            while (resultado.next()) {
//                fabricante = new Fabricante();
//                fabricante.setCodigo(resultado.getInt(1));
//                fabricante.setNombre(resultado.getString(2));
//            }
//            desconectarBase();
//            return fabricante;
//        } catch (Exception e) {
//            desconectarBase();
//            throw e;
//        }
//    }
}
