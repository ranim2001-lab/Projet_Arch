package interfaceCode;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductService extends Remote {
    List<String> listProducts() throws RemoteException;
    boolean placeOrder(String productName, String username) throws RemoteException;
    List<String> getOrderHistory(String username) throws RemoteException;
}