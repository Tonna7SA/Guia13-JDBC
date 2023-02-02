package Tienda.servicios;

import Tienda.persistencia.DAO;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class TiendaServicio extends DAO {

    ProductoServicio p1 = new ProductoServicio();
    FabricanteServicio f1 = new FabricanteServicio();

    public void Tienda() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc;
        do {
            System.out.println("---------------------------------Menu Tienda------------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Lista el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("2 - Lista los nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("3 - Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("4 - Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("5 - Listar el nombre y el precio del producto más barato.");
            System.out.println("6 - Ingresar un producto a la base de datos.");
            System.out.println("7 - Ingresar un fabricante a la base de datos");
            System.out.println("8 - Editar un producto con datos a elección.");
            System.out.println("9 - SALIR");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    p1.MostrarProductospornombre();
                    break;
                case 2:
                    p1.MostrarProductospornombreyprecio();
                    break;
                case 3:
                    p1.MostrarProductosyprecioentre120y202();
                    break;
                case 4:
                    p1.MostrarProductosqueseanportatiles();
                    break;
                case 5:
                    p1.MostrarProductomasbarato();
                    break;
                case 6:
                    p1.IngresarNuevoProducto();
                    break;
                case 7:
                    f1.CrearFabricante();
                    break;
                case 8:
                    p1.EditarProducto();
                    break;
                case 9:
                    System.out.println("Fin del programa...");
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);
    }

}
