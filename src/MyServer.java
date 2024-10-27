import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.RemoteException;
import java.rmi.server.*;

public class MyServer{

    public static void main(String[] args){
        try{
            MethodRemote stub = new MethodRemote();
            MethodWithCallback stubWithCallback = new MethodWithCallbackRemote();
            Naming.rebind("rmi://localhost:5000/lab6", stub);
            Naming.rebind("rmi://localhost:5000/lab7", stubWithCallback);
            System.out.println("The Server is running!");
        }catch(Exception e){System.out.println(e);}
    }
}

