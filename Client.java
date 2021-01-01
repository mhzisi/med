import java.rmi.Naming;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        try {
            MyInterface service1 = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Entrer votre solde :");
            String str = scanner.nextLine();
            double n=service1.lireSolde(str);
            
            System.out.println("Débiter :");
            str = scanner.nextLine();
            double d = Double.parseDouble(str);
            System.out.println("Nouveau solde :"); 
            n=service1.debiter(n,d);
            System.out.println(n);
            
            System.out.println("Créditer :");
            str = scanner.nextLine();
            double c = Double.parseDouble(str);
            System.out.println("Nouveau solde :");  
            n=service1.crediter(n,c);          
            System.out.println(n);

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
    }

}