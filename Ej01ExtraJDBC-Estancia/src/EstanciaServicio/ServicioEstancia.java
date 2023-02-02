package EstanciaServicio;

import EstanciaPersistencia.CasasDAO;
import EstanciaPersistencia.ClientesDAO;
import EstanciaPersistencia.FamiliasDAO;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioEstancia {

    FamiliasDAO FDAO = new FamiliasDAO();
    CasasDAO CDAO = new CasasDAO();
    ServicioCasas SC = new ServicioCasas();
    ClientesDAO CLDAO = new ClientesDAO();

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void Menu() throws Exception {
        int opc;
        do {
            System.out.println("--------------------------------Menu Estancia-----------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.");
            System.out.println("2 - Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de \n"
                    +          "2020 y el 31 de agosto de 2020 en Reino Unido.");
            System.out.println("3 - Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.");
            System.out.println("4 - Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada \n"
                    +          "y un número de días específico.");
            System.out.println("5 - Listar los datos de todos los clientes que en algún momento realizaron una estancia y la \n"
                    +          "descripción de la casa donde la realizaron.");
            System.out.println("6 - Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y \n"
                    +          "ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a \n"
                    +          "la anterior");
            System.out.println("7 - Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el \n"
                    +          "precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios \n"
                    +          "actualizados.");
            System.out.println("8 - Obtener el número de casas que existen para cada uno de los países diferentes.");
            System.out.println("9 - Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) \n"
                    +          "que están ‘limpias’.");
            System.out.println("10 - Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.");
            System.out.println("0 - Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    FDAO.MostrarFamilias3hijosedadmaximamenor10();
                    break;
                case 2:
                    CDAO.MostrarCasasDisponiblesmesAgostodereinounido();
                    break;
                case 3:
                    FDAO.MostrarFamiliastenganHotmail();
                    break;
                case 4:
                    SC.CasasDisponiblesporFecha();
                    break;
                case 5:
                    CLDAO.MostarClientes();
                    break;
                case 6:
                    CLDAO.MostarClientesconreserva();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 0:
                    System.out.println("Fin del programa...");
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);

    }

}
