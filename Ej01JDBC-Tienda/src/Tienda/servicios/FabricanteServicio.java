package Tienda.servicios;

import Tienda.entidades.Fabricante;
import Tienda.persistencia.DAO;
import Tienda.persistencia.FabricanteDAO;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class FabricanteServicio extends DAO {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    FabricanteDAO FDAO = new FabricanteDAO();

    public void CrearFabricante() throws Exception {

        TiendaServicio TS = new TiendaServicio();
        Fabricante fabricante = new Fabricante();
        String consultaCodigo = "SELECT * FROM Fabricante ORDER BY codigo DESC LIMIT 1";
        consultarBase(consultaCodigo);
        int codigo = 0;
        while (resultado.next()) {
            codigo = resultado.getInt(1);
            fabricante.setCodigo(codigo + 1);
        }
        codigo = codigo + 1;
        try {
            System.out.println("Ingrese el Nombre del Fabricante: ");
            String nombre = leer.next();
            if (FDAO.BuscarFabricantepornombre(nombre) != null) {
            }
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            FDAO.IngresarFabricante(fabricante);
            System.out.println("Nuevo Fabricante ingresado: Codigo " + fabricante.getCodigo() + " Nombre: " + fabricante.getNombre());
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            System.out.println("El Fabricante ya existe en la Base de Datos...");
            TS.Tienda();
            throw e;

        }
    }
}
