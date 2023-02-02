package EstanciaPersistencia;

import EstanciaEntidad.FamiliasEntidad;
import java.util.ArrayList;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class FamiliasDAO extends DAO {

    public void MostrarFamilias() throws Exception {
        try {
            ArrayList<FamiliasEntidad> fami = new ArrayList();
            FamiliasEntidad familias = null;
            String sql = "select * from familias";
            consultarBase(sql);
            while (resultado.next()) {
                familias = new FamiliasEntidad();
                familias.setId_familia(resultado.getInt(1));
                familias.setNombre(resultado.getString(2));
                familias.setEdad_minima(resultado.getInt(3));
                familias.setEdad_maxima(resultado.getInt(4));
                familias.setNum_hijos(resultado.getInt(5));
                familias.setEmail(resultado.getString(6));
                familias.setId_casa_familia(resultado.getInt(7));
                fami.add(familias);
            }
            for (FamiliasEntidad aux : fami) {
                System.out.println(aux.toString());

            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

     public void MostrarFamilias3hijosedadmaximamenor10() throws Exception {
        try {
            ArrayList<FamiliasEntidad> fami = new ArrayList();
            FamiliasEntidad familias = null;
            String sql = "select * from familias where num_hijos >= 3 and edad_maxima < 10";
            consultarBase(sql);
            while (resultado.next()) {
                familias = new FamiliasEntidad();
                familias.setId_familia(resultado.getInt(1));
                familias.setNombre(resultado.getString(2));
                familias.setEdad_minima(resultado.getInt(3));
                familias.setEdad_maxima(resultado.getInt(4));
                familias.setNum_hijos(resultado.getInt(5));
                familias.setEmail(resultado.getString(6));
                familias.setId_casa_familia(resultado.getInt(7));
                fami.add(familias);
            }
            for (FamiliasEntidad aux : fami) {
                System.out.println(aux.toString());

            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
     
     public void MostrarFamiliastenganHotmail() throws Exception {
        try {
            ArrayList<FamiliasEntidad> fami = new ArrayList();
            FamiliasEntidad familias = null;
            String sql = "select * from familias where email like '%hotmail%'";
            consultarBase(sql);
            while (resultado.next()) {
                familias = new FamiliasEntidad();
                familias.setId_familia(resultado.getInt(1));
                familias.setNombre(resultado.getString(2));
                familias.setEdad_minima(resultado.getInt(3));
                familias.setEdad_maxima(resultado.getInt(4));
                familias.setNum_hijos(resultado.getInt(5));
                familias.setEmail(resultado.getString(6));
                familias.setId_casa_familia(resultado.getInt(7));
                fami.add(familias);
            }
            for (FamiliasEntidad aux : fami) {
                System.out.println(aux.toString());

            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
