package EstanciaServicio;

import EstanciaPersistencia.CasasDAO;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioCasas {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    CasasDAO CDAO = new CasasDAO();

    public void CasasDisponiblesporFecha() throws Exception {
        
        System.out.println("Ingrese la fecha para su estancia: ");
        System.out.println("");
        System.out.println("Ingrese el dia");
        int dia = leer.nextInt();
        System.out.println("Ingrese el mes");
        int mes = leer.nextInt();
        System.out.println("Ingrese el año");
        int ano = leer.nextInt();
        Date fecha = new java.sql.Date(ano-1900, mes-1, dia);
        System.out.println(fecha);
        System.out.println("Ingrese la cantidad de dias a alquilar: ");
        int alquiler = leer.nextInt();
        CDAO.MostrarCasasDisponibleporfechaycantidaddedias(fecha, alquiler);
    }
}
