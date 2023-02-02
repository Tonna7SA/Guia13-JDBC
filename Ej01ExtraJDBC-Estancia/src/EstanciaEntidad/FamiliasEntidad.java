
package EstanciaEntidad;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class FamiliasEntidad {

    protected int id_familia;
    protected String nombre;
    protected int edad_minima;
    protected int edad_maxima;
    protected int num_hijos;
    protected String email;
    protected int id_casa_familia;

    public FamiliasEntidad() {
    }

    public FamiliasEntidad(int id_familia, String nombre, int edad_minima, int edad_maxima, int num_hijos, String email, int id_casa_familia) {
        this.id_familia = id_familia;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.id_casa_familia = id_casa_familia;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public int getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_casa_familia() {
        return id_casa_familia;
    }

    public void setId_casa_familia(int id_casa_familia) {
        this.id_casa_familia = id_casa_familia;
    }

    @Override
    public String toString() {
        return "FamiliasEntidad{" + "id_familia=" + id_familia + ", nombre=" + nombre + ", edad_minima=" + edad_minima + ", edad_maxima=" + edad_maxima + ", num_hijos=" + num_hijos + ", email=" + email + ", id_casa_familia=" + id_casa_familia + '}';
    }
    
    
}