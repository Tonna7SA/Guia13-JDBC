package Tienda.servicios;

import Tienda.entidades.Fabricante;
import Tienda.entidades.Producto;
import Tienda.persistencia.DAO;
import Tienda.persistencia.FabricanteDAO;
import Tienda.persistencia.ProductoDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ProductoServicio extends DAO {

    Producto p1 = new Producto();
    Fabricante f1 = new Fabricante();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    FabricanteDAO FDAO = new FabricanteDAO();
    ProductoDAO PDAO = new ProductoDAO();

    public ArrayList<Producto> MostrarProductospornombre() throws Exception {
        try {
            String sql = "SELECT * from producto";
            consultarBase(sql);
            Producto producto = null;
            ArrayList<Producto> prod;
            prod = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                producto.setCodigo(resultado.getInt(1));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                prod.add(producto);
            }
            System.out.println("----------------------------------");
            System.out.println("Nombres de los productos de Tienda");
            System.out.println("----------------------------------");
            for (Producto aux : prod) {
                System.out.println("");
                System.out.println(aux.getNombre());
            }
            System.out.println("");
            desconectarBase();
            return prod;
        } catch (Exception e) {
            System.out.println("Error de Base de Datos");
            desconectarBase();
            throw e;
        }
    }

    public ArrayList<Producto> MostrarProductospornombreyprecio() throws Exception {
        try {
            String sql = "SELECT * from producto";
            consultarBase(sql);
            Producto producto = null;
            ArrayList<Producto> prod;
            prod = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                producto.setCodigo(resultado.getInt(1));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                prod.add(producto);
            }
            System.out.println("-------------------------------------------");
            System.out.println("Nombres y Precio de los productos de Tienda");
            System.out.println("-------------------------------------------");
            for (Producto aux : prod) {
                System.out.println("");
                System.out.println("Producto: " + aux.getNombre() + " -- Precio: $ " + aux.getPrecio());
            }
            System.out.println("");
            desconectarBase();
            return prod;
        } catch (Exception e) {
            System.out.println("Error de Base de Datos");
            desconectarBase();
            throw e;
        }
    }

    public ArrayList<Producto> MostrarProductosyprecioentre120y202() throws Exception {
        try {
            String sql = "select * from producto where precio between 120 and 200";
            consultarBase(sql);
            Producto producto = null;
            ArrayList<Producto> prod;
            prod = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                producto.setCodigo(resultado.getInt(1));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                prod.add(producto);
            }
            System.out.println("-----------------------------------------------------------");
            System.out.println("Nombres y Precio entre 120 y 202 de los productos de Tienda");
            System.out.println("-----------------------------------------------------------");
            for (Producto aux : prod) {
                System.out.println("");
                System.out.println("Producto: " + aux.getNombre() + " -- Precio: $ " + aux.getPrecio());
            }
            System.out.println("");
            desconectarBase();
            return prod;
        } catch (Exception e) {
            System.out.println("Error de Base de Datos");
            desconectarBase();
            throw e;
        }
    }

    public ArrayList<Producto> MostrarProductosqueseanportatiles() throws Exception {
        try {
            String sql = "select * from producto where nombre like '%portatil%'";
            consultarBase(sql);
            Producto producto = null;
            ArrayList<Producto> prod;
            prod = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                producto.setCodigo(resultado.getInt(1));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                prod.add(producto);
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("Nombres y Precio de los productos de Tienda que son portatiles");
            System.out.println("--------------------------------------------------------------");
            for (Producto aux : prod) {
                System.out.println("");
                System.out.println("Producto: " + aux.getNombre() + " -- Precio: $ " + aux.getPrecio());
            }
            System.out.println("");
            desconectarBase();
            return prod;
        } catch (Exception e) {
            System.out.println("Error de Base de Datos");
            desconectarBase();
            throw e;
        }
    }

    public ArrayList<Producto> MostrarProductomasbarato() throws Exception {
        try {
            String sql = "select * from producto where precio=(select min(precio) from producto)";
            consultarBase(sql);
            Producto producto = null;
            ArrayList<Producto> prod;
            prod = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                producto.setCodigo(resultado.getInt(1));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                prod.add(producto);
            }
            System.out.println("-----------------------------------------------------");
            System.out.println("Nombres y Precio del producto mas barato de la Tienda");
            System.out.println("-----------------------------------------------------");
            for (Producto aux : prod) {
                System.out.println("");
                System.out.println("Producto: " + aux.getNombre() + " -- Precio: $ " + aux.getPrecio());
            }
            System.out.println("");
            desconectarBase();
            return prod;
        } catch (Exception e) {
            System.out.println("Error de Base de Datos");
            desconectarBase();
            throw e;
        }
    }

    public ArrayList<Producto> MostrarTodosLosProductos() throws Exception {
        try {
            String sql = "SELECT * from producto";
            consultarBase(sql);
            Producto producto = null;
            ArrayList<Producto> prod;
            prod = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(2));
                producto.setCodigo(resultado.getInt(1));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                prod.add(producto);
            }
            System.out.println("----------------------------------");
            System.out.println("Nombres de los productos de Tienda");
            System.out.println("----------------------------------");
            for (Producto aux : prod) {
                System.out.println("");
                System.out.println(aux);
            }
            System.out.println("");
            desconectarBase();
            return prod;
        } catch (Exception e) {
            System.out.println("Error de Base de Datos");
            desconectarBase();
            throw e;
        }
    }
    
    public void IngresarNuevoProducto() throws Exception {
        String consultaCodigo = "SELECT * FROM Producto  ORDER BY codigo DESC LIMIT 1";
        consultarBase(consultaCodigo);
        Producto producto = new Producto();
        int codigo = 0;
        while (resultado.next()) {
            codigo = resultado.getInt(1);
            producto.setCodigo(codigo + 1);
        }
        codigo = codigo + 1;

        System.out.println("------------INGRESAR PRODUCTO------------");
        Fabricante fabricante = new Fabricante();
        System.out.println("Ingrese nombre del nuevo producto");
        producto.setNombre(leer.next());
        System.out.println("Ingrese precio del nuevo producto");
        producto.setPrecio(leer.nextDouble());
        System.out.println("Lista de Fabricantes");
        FDAO.MostrarFabricantes();
      try {
//            int codigofabricante = leer.nextInt();
//            if (FDAO.BuscarFabricanteporcodigo(codigofabricante)!=null){
//            }
//                fabricante.getNombre();
//                fabricante.setCodigo(codigofabricante);
//                producto.setCodigo(codigo);
//                producto.setCodigoFabricante(fabricante.getCodigo());
//                PDAO.IngresarProducto(producto);
//                System.out.println("El producto ingresado es: " + producto.toString());
            System.out.println("Elija el nombre del Fabricante: ");
            String nombre = leer.next();
            fabricante = FDAO.BuscarFabricantepornombre(nombre);
            if (fabricante!= null) {
            System.out.println("Entro");
            producto.setCodigo(codigo);
            producto.setCodigoFabricante(fabricante.getCodigo());
            
            PDAO.IngresarProducto(producto);
            System.out.println("El producto ingresado es: " + producto.toString());
            }else{
                System.out.println("El codigo no se encuentra en la base de Datos");
            }
            
        } catch (Exception e){
            System.out.println("El codigo no se encuentra en la base de Datos");
            desconectarBase();
        }
    }    
    
    public void EditarProducto() throws Exception{
        System.out.println("----------EDITAR PRODUCTO---------");
        MostrarTodosLosProductos();
        System.out.println("Ingrese el codigo del producto a editar: ");
        int codigo = leer.nextInt();
        try{
            if(PDAO.BuscarProductoporcodigo(codigo)!=null){
             PDAO.EditarProducto(codigo);
            }else{
                System.out.println("El codigo del producto no esta en la base de Datos...");
            }
           
        }catch(Exception e){
            System.out.println("El codigo del producto no esta en la base de Datos...");
            desconectarBase();
            throw e;
        }
    }
}
