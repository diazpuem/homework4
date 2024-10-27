import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MethodWithCallback extends Remote {

    void action(String textInput, ClientCallback callback) throws RemoteException;
}
