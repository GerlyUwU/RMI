import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import Interface.IPersona;

public class Persona extends UnicastRemoteObject implements IPersona {

    private int id;
    private String nombre;
    private String email;
    private String telefono;

    public Persona() throws RemoteException {

    }

    public Persona(int id, String nombre, String email, String telefono) throws RemoteException {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() throws RemoteException {
        return id;
    }

    public void setId(int id) throws RemoteException {
        this.id = id;
    }

    public String getNombre() throws RemoteException {
        return nombre;
    }

    public void setNombre(String nombre) throws RemoteException {
        this.nombre = nombre;
    }

    public String getEmail() throws RemoteException {
        return email;
    }

    public void setEmail(String email) throws RemoteException {
        this.email = email;
    }

    public String getTelefono() throws RemoteException {
        return telefono;
    }

    public void setTelefono(String telefono) throws RemoteException {
        this.telefono = telefono;
    }

    public String getString() throws RemoteException {
        return String.format("Id: %d, Nombre: %s, Email: %s, Telefono: %s",
                id, nombre, email, telefono);
    }

    public static IPersona fromMap (Map<String, Object> map) throws RemoteException {
        IPersona persona = new Persona();


        if (map.containsKey("IdPersona")) {
            persona.setId((Integer) map.get("IdPersona"));
        }

        if (map.containsKey("Nombre")) {
            persona.setNombre((String) map.get("Nombre"));
        }

        if (map.containsKey("Telefono") && map.get("Telefono") != null) {
            persona.setTelefono((String) map.get("Telefono"));
        }

            if (map.containsKey("Email")) {
                persona.setEmail((String) map.get("Email"));
            }
            return persona;
        

    }
}
