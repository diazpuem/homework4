import java.rmi.*;
import java.util.Scanner;

public class MyClient{

    public static void main(String[] args){
        try{
            Method stub=(Method)Naming.lookup("rmi://localhost:5000/lab6");

            Scanner scanner = new Scanner(System.in);
            String textInput;
            do {
                textInput = scanner.nextLine();
                System.out.println("Please enter an input: ");
                System.out.println(stub.action(textInput));
            } while (!textInput.isEmpty());
        }catch(Exception e){System.out.println(e);}
    }
}
