package service;

import model.MerchantStock;
import model.Product;
import model.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class Product_Service {
    private ArrayList<Product> productList = new ArrayList<>();

    public ArrayList<Product> getProductList() {
        return getProductList();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(int index, Product product) {
        productList.set(index, product);
    }

    public void deleteProduct(int index) {
        productList.remove(index);
    }


    public int productPurchase(String userid, String productId, int merchantid) {
        User user = User_Service.getUser(userid);
        MerchantStock merchantStock = MerchantStock_Service.getMerchantStocks(merchantid);
        Product product = Product_Service.getProduct(productId);
        if (product == null || user == null || merchantStock == null) {
            return -1;
        }
        if (user.getBalance() < product.getPrice()) {
            return 0;
        }
        if (merchantStock.getStock() == 0) {
            return 1;
        }// reduce the stock from the MerchantStock
        int oldStock=merchantStock.getStock();
        merchantStock.setStock(oldStock-1);
        int oldBalance=user.getBalance();
        user.setBalance(oldBalance-product.getPrice());

        return oldStock;
    }
}
