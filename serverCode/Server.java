package serverCode;

import interfaceCode.ProductService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            ProductService service = new ProductServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ProductService", service);
            System.out.println("🟢 Serveur RMI prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
