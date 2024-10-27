import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class MethodWithCallbackRemote extends UnicastRemoteObject implements MethodWithCallback {

    protected MethodWithCallbackRemote() throws RemoteException {
        super();
    }

    @Override
    public void action(String textInput, ClientCallback callback) throws RemoteException {
        String result;
        if ("time".equals(textInput)) {
            result = new Date().toString();
        } else {
            result = textInput.toUpperCase();
        }

        // Call the client's callback method to send the result
        callback.receiveResult(result);
    }
}
