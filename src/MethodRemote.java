import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class MethodRemote extends UnicastRemoteObject implements Method{

    MethodRemote()throws RemoteException{
        super();
    }

    public String action(String textInput) {
        String result;
        if ("time".equals(textInput)) {
            result = new Date().toString();
        } else {
            result = textInput.toUpperCase();
        }
        return result;
    }
}
