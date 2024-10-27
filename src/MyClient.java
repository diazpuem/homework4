import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class MyClient extends UnicastRemoteObject implements ClientCallback{

    protected MyClient() throws RemoteException {
        super();
    }

    public static void main(String[] args){
        try{
            Method stub=(Method)Naming.lookup("rmi://localhost:5000/lab6");
            MethodWithCallback stubWithCallback=(MethodWithCallback)Naming.lookup("rmi://localhost:5000/lab7");
            Scanner scanner = new Scanner(System.in);
            String textInput;
            do {
                System.out.println("Please enter an input: ");
                textInput = scanner.nextLine();
                if (textInput.isEmpty()) {
                    break;
                }
                MyClient myClient = new MyClient();
                System.out.println("Using RMI:" + stub.action(textInput));
                stubWithCallback.action(textInput, myClient);
            } while (true);
        }catch(Exception e){System.out.println(e);}
    }

    @Override
    public void receiveResult(String result) throws RemoteException {
        System.out.println("Using Callback:" + result);
    }
}
