import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    
    public Server() throws RemoteException {}

    public String sayHello() {
        return "Hello World !!";
    }
    
    public double lireSolde(String str){
        return Double.parseDouble(str);
    }
    
    public double debiter(double n, double d){
        return n-d;
    }
    
    public double crediter(double n, double c){
        return n+c;
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }
}
