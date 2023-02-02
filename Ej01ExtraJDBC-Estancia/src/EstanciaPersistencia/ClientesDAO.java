package EstanciaPersistencia;

import EstanciaEntidad.CasasEntidad;
import EstanciaEntidad.ClientesEntidad;
import EstanciaEntidad.ComentariosEntidad;
import java.util.ArrayList;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ClientesDAO extends DAO {

    public void MostarClientes() throws Exception {

        try {
            String sql = "select c.*, co.comentario from clientes c inner join "
                    + "estancias e on c.id_cliente = e.id_cliente"
                    + " inner join casas ca on e.id_casa = ca.id_casa"
                    + " inner join comentarios co on ca.id_casa = co.id_casa;";
            consultarBase(sql);
            ClientesEntidad cliente = null;
            ComentariosEntidad comenta = null;
            ArrayList<ClientesEntidad> clien = new ArrayList();
            ArrayList<ComentariosEntidad> come = new ArrayList();
            while (resultado.next()) {
                ClientesEntidad clientes = new ClientesEntidad();
                ComentariosEntidad comentas = new ComentariosEntidad();
                clientes.setId_cliente(resultado.getInt(1));
                clientes.setNombre(resultado.getString(2));
                comentas.setComentario(resultado.getNString("comentario"));
                clien.add(clientes);
                come.add(comentas);
            }
            int i = 0;
            for (ClientesEntidad aux1 : clien) {
                System.out.println(+aux1.getId_cliente() + " " + aux1.getNombre() + " " + come.get(i).getComentario());
                i++;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void MostarClientesconreserva() throws Exception {

        try {
            String sql = "select c.*, ca.* from clientes c inner join "
                    + "estancias e on c.id_cliente = e.id_cliente"
                    + " inner join casas ca on e.id_casa = ca.id_casa";
            consultarBase(sql);
            ClientesEntidad cliente = null;
            CasasEntidad casucha = null;
            ArrayList<ClientesEntidad> clien = new ArrayList();
            ArrayList<CasasEntidad> casi = new ArrayList();
            while (resultado.next()) {
                ClientesEntidad clientes = new ClientesEntidad();
                CasasEntidad casuchas = new CasasEntidad();
                clientes.setId_cliente(resultado.getInt(1));
                clientes.setNombre(resultado.getString(2));
                clientes.setPais(resultado.getString(7));
                clientes.setCiudad(resultado.getString(6));
                casuchas.setCalle(resultado.getString("calle"));
                casuchas.setNumero(resultado.getInt("numero"));
                casuchas.setCiudad(resultado.getString("ciudad"));
                casuchas.setPais(resultado.getString("pais"));
                casuchas.setTipo_vivienda(resultado.getString("tipo_vivienda"));
                clien.add(clientes);
                casi.add(casuchas);
            }
            int i = 0;
            for (ClientesEntidad aux1 : clien) {
                System.out.println("Nombre Cliente: " + aux1.getNombre() + " Reserva: " + casi.get(i).getCalle() + " "
                        + casi.get(i).getNumero() + " " + casi.get(i).getCiudad() + " " + casi.get(i).getPais() + " " + casi.get(i).getTipo_vivienda() + " ");
                i++;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
