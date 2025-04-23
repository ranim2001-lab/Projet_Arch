package serverCode;

import interfaceCode.ProductService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ProductServiceImpl extends UnicastRemoteObject implements ProductService {
    private List<String> products;
    private Map<String, List<String>> orders;

    protected ProductServiceImpl() throws RemoteException {
        products = new ArrayList<>(Arrays.asList("Laptop", "Smartphone", "Tablet", "Headphones"));
        orders = new HashMap<>();
    }

    public List<String> listProducts() throws RemoteException {
        return products;
    }

    public boolean placeOrder(String productName, String username) throws RemoteException {
        if (!products.contains(productName)) return false;
        orders.computeIfAbsent(username, k -> new ArrayList<>()).add(productName);
        return true;
    }

    public List<String> getOrderHistory(String username) throws RemoteException {
        return orders.getOrDefault(username, new ArrayList<>());
    }
}