import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Interface.IPersona;
import Interface.IPersonaController;

public class PersonaController extends UnicastRemoteObject implements IPersonaController {

    private DBManager dbManager;
    private final String TABLE = "Personas";

    protected PersonaController() throws RemoteException {
        dbManager = new DBManager();
    }

    @Override
    public IPersona newInstance() throws RemoteException {
        return new Persona();
    }

    @Override
    public int add(IPersona persona) throws RemoteException {
        boolean existe = false;
        if (persona.getId() != 0) {
            Map<String, Object> where = new HashMap<>();
            where.put("IdPersona", persona.getId());
            Map<String, Object> registro = dbManager.buscarUno(TABLE, where);
            existe = registro.size() > 0;
        }
        if (existe) {
            return ADD_ID_DUPLICADO;
        }

        Map<String, Object> datos = new HashMap<>();
        if (persona.getId() != 0) {
            datos.put("IdPersona", persona.getId());
        }
        if (persona.getNombre() != null) {
            datos.put("Nombre", persona.getNombre());
        }
        if (persona.getTelefono() != null) {
            datos.put("Telefono", persona.getTelefono());
        }
        if (persona.getEmail() != null) {
            datos.put("Email", persona.getEmail());
        }

        int respuesta = dbManager.insertar(TABLE, datos);
        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;
    }

    @Override
    public void update(IPersona persona) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(IPersona persona) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<IPersona> list() throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public IPersona findOne(int idPersona) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

}
