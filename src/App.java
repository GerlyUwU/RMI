import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface.IPersonaController;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            LocateRegistry.createRegistry(1099);

            IPersonaController personaController = new PersonaController();
            Naming.rebind("rmi://localhost/personaController", personaController);
            System.out.println("Escuchando...");
        } catch (RemoteException ex) {
            // TODO Auto-generated catch block
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null, ex);
            
        }catch(MalformedURLException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null,ex);
        }

    }
}
