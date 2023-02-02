package EstanciaPersistencia;

import EstanciaEntidad.CasasEntidad;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class CasasDAO extends DAO {

    public void MostrarCasas() throws Exception {
        try {
            ArrayList<CasasEntidad> casi = new ArrayList();
            CasasEntidad casas = null;
            String sql = "select * from casas";
            consultarBase(sql);
            while (resultado.next()) {
                casas = new CasasEntidad();
                casas.setId_casa(resultado.getInt(1));
                casas.setCalle(resultado.getString(2));
                casas.setNumero(resultado.getInt(3));
                casas.setCodigo_postal(resultado.getString(4));
                casas.setCiudad(resultado.getString(5));
                casas.setPais(resultado.getString(6));
                casas.setFecha_desde(resultado.getDate(7));
                casas.setFecha_hasta(resultado.getDate(8));
                casas.setTiempo_minimo(resultado.getInt(9));
                casas.setTiempo_maximo(resultado.getInt(10));
                casas.setPrecio_habitacion(resultado.getDouble(11));
                casas.setTipo_vivienda(resultado.getString(12));
                casi.add(casas);
            }
            for (CasasEntidad aux : casi) {
                System.out.println(aux.toString());

            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void MostrarCasasDisponiblesmesAgostodereinounido() throws Exception {
        try {
            ArrayList<CasasEntidad> casi = new ArrayList();
            CasasEntidad casas = null;
            String sql = "select * from casas where fecha_desde >= '2020-08-01' and fecha_hasta <= '2020-08-31' and pais like 'reino unido'";
            consultarBase(sql);
            while (resultado.next()) {
                casas = new CasasEntidad();
                casas.setId_casa(resultado.getInt(1));
                casas.setCalle(resultado.getString(2));
                casas.setNumero(resultado.getInt(3));
                casas.setCodigo_postal(resultado.getString(4));
                casas.setCiudad(resultado.getString(5));
                casas.setPais(resultado.getString(6));
                casas.setFecha_desde(resultado.getDate(7));
                casas.setFecha_hasta(resultado.getDate(8));
                casas.setTiempo_minimo(resultado.getInt(9));
                casas.setTiempo_maximo(resultado.getInt(10));
                casas.setPrecio_habitacion(resultado.getDouble(11));
                casas.setTipo_vivienda(resultado.getString(12));
                casi.add(casas);
            }
            for (CasasEntidad aux : casi) {
                System.out.println(aux.toString());

            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void MostrarCasasDisponibleporfechaycantidaddedias(Date fecha, int dias) throws Exception {

        try {
            ArrayList<CasasEntidad> casi = new ArrayList();
            CasasEntidad casas = null;

            String sql = "select * from casas where fecha_desde <= '" + fecha + "' and fecha_hasta >= '" + fecha 
                    + "' and tiempo_maximo >= '" + dias + "' and tiempo_minimo <= '" + dias + "'";
            consultarBase(sql);
            while (resultado.next()) {
                casas = new CasasEntidad();
                casas.setId_casa(resultado.getInt(1));
                casas.setCalle(resultado.getString(2));
                casas.setNumero(resultado.getInt(3));
                casas.setCodigo_postal(resultado.getString(4));
                casas.setCiudad(resultado.getString(5));
                casas.setPais(resultado.getString(6));
                casas.setFecha_desde(resultado.getDate(7));
                casas.setFecha_hasta(resultado.getDate(8));
                casas.setTiempo_minimo(resultado.getInt(9));
                casas.setTiempo_maximo(resultado.getInt(10));
                casas.setPrecio_habitacion(resultado.getDouble(11));
                casas.setTipo_vivienda(resultado.getString(12));
                casi.add(casas);
            }
            for (CasasEntidad aux : casi) {
                System.out.println(aux.toString());

            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

}
