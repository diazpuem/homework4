import java.rmi.*;
import java.rmi.server.*;

public interface Method extends Remote{

    String action(String textInput)throws RemoteException;
}
