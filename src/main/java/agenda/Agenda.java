
package agenda;

//import exceptions.ContactoInexistenteException;
import exceptions.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author loned
 */
public class Agenda {

    private HashMap<String, Contacto> contactos = new HashMap();
    private static int n = 0;
    private static int count = 0;
    
    private static String nombreAgenda="";

    

    public String getnombreAgenda(Agenda a){
            return this.nombreAgenda;
    }
    public void setnombreAgenda(String name){
            this.nombreAgenda=name;
    }
    
    public Agenda(String name){
        
        if (name != ""){
            this.nombreAgenda = name;
        }
        else this.nombreAgenda = "Untitled";
        
    }
    Agenda() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
 /**
  * Añade un contacto
  * @param contacto Contacto que queremos añadir
  * @return Objeto contacto añadido o genera una excepción si ya existía
  * @throws ContactoRepetidoException Excepcion programada, paquete exception 
  */
   public Contacto addContacto(Contacto contacto) throws ContactoRepetidoException {
        if (contactos.containsKey(contacto.getEmail())) {
            //
            throw new ContactoRepetidoException("Ya existe un contacto con email: " + contacto.getEmail());
        }
        n++;
        contacto.setN(n);
        contactos.put(contacto.getEmail(), contacto);
        count++;
        return contacto;
    }
/**
 *  Elimina un contacto
 * @param email Correo electronico del objeto que queremos eliminar
 * @return Contacto eliminado sino null
 */
    public Contacto eliminarContacto(String email) { 
        Contacto contacto = buscarContacto(email);
        if (contacto != null) {
        contactos.remove(email);
        count--;
        }
        return contacto;
    }
/**
 *  Busca un contacto en la agenda
 * @param email Correo electronico del objeto que se quiere encontar
 * @return  El email del contacto buscado sino null
 */
    public Contacto buscarContacto(String email) { 
        Contacto contacto = null;
        if (!contactos.containsKey(email)) {

            return null;
        }
        else{
        return contactos.get(email);
        }
    }
/**
 * Coge todos los contactos en la agenda
 * @return Lista de contactos
 */
    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        contactosList.addAll(contactos.values());
        return contactosList;
    }
    
    

}
