package clientCode;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

import interfaceCode.ProductService;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("server", 1099);
            ProductService service = (ProductService) registry.lookup("ProductService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();

            while (true) {
                System.out.println("\n1. Lister les produits\n2. Commander\n3. Historique\n4. Quitter");
                System.out.print("> ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        List<String> products = service.listProducts();
                        System.out.println("Produits disponibles : " + products);
                        break;
                    case 2:
                        System.out.print("Nom du produit à commander : ");
                        String product = scanner.nextLine();
                        boolean success = service.placeOrder(product, username);
                        System.out.println(success ? "Commande réussie." : "Produit invalide.");
                        break;
                    case 3:
                        List<String> history = service.getOrderHistory(username);
                        System.out.println("Historique de commande : " + history);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Choix invalide.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}