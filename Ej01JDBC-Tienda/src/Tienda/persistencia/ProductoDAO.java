package Tienda.persistencia;

import Tienda.entidades.Producto;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ProductoDAO extends DAO {

    FabricanteDAO FDAO = new FabricanteDAO();
    

    public void IngresarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto");
            }
            String sql = "insert into Producto (codigo, nombre, precio, codigo_fabricante) values ('" + producto.getCodigo()
                    + "','" + producto.getNombre() + "','" + producto.getPrecio() + "','" + producto.getCodigoFabricante() + "')";
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }

    public Producto BuscarProductopornombre(String nombrenuevo) throws Exception {
        try {
            String sql = "select * from Producto where nombre = '" + nombrenuevo + "'";
            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getNString(2));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Producto BuscarProductoporcodigo(Integer codigonuevo) throws Exception {
        try {

            String sql = "select codigo from producto where codigo = " + codigonuevo + "";
            consultarBase(sql);

            Producto fabricante = null;
            while (resultado.next()) {
                fabricante = new Producto();
                fabricante.setCodigo(resultado.getInt(1));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Producto EditarProducto(Integer codigo) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;
        Producto producto = null;
        System.out.println("-------Opcion de Edicion------");
        System.out.println("1 - Editar Nombre del producto");
        System.out.println("2 - Editar Precio del producto");
        System.out.println("3 - Editar Codigo del fabricante");
        System.out.println("Elija opcion: ");
        opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nuevo nombre del producto");
                String nuevonombre = leer.next();
                try {
                    String sql = "UPDATE Producto SET "
                            + "nombre = '" + nuevonombre + "' WHERE codigo = '" + codigo + "'";
                    insertarModificarEliminar(sql);
                } catch (Exception e) {
                    throw e;
                } finally {
                    desconectarBase();
                }
                System.out.println("Modificacion exitosa");
                break;
            case 2:
                System.out.println("Ingrese el nuevo precio del producto");
                int nuevoprecio = leer.nextInt();
                try {
                    String sql = "UPDATE Producto SET "
                            + "precio = '" + nuevoprecio + "' WHERE codigo = '" + codigo + "'";
                    insertarModificarEliminar(sql);
                } catch (Exception e) {
                    throw e;
                } finally {
                    desconectarBase();
                }
                System.out.println("Modificacion exitosa");
                break;
            case 3:
                FDAO.MostrarFabricantes();
                System.out.println("Ingrese el nuevo codigo del Fabricante");
                int nuevocodigo = leer.nextInt();
                try {
                    String sql = "UPDATE Producto SET "
                            + "codigo_fabricante = '" + nuevocodigo + "' WHERE codigo = '" + codigo + "'";
                    insertarModificarEliminar(sql);
                } catch (Exception e) {
                    throw e;
                } finally {
                    desconectarBase();
                }
                System.out.println("Modificacion exitosa");
                break;
            default:
                System.out.println("Esa opcion no es valida");
        }
        return producto;
    }
}
