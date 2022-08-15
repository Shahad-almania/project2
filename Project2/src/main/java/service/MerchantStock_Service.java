package service;

import model.Merchant;
import model.MerchantStock;
import model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class MerchantStock_Service {
    private ArrayList<MerchantStock> merchantStockArrayList = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStockArrayList;
    }

    public void addMerchantStocks(MerchantStock merchantStock) {

        merchantStockArrayList.add(merchantStock);
    }

    public void updateMerchantStocks(int index, MerchantStock merchantStock) {
        merchantStockArrayList.set(index, merchantStock);
    }

    public void deleteMerchantStocks(int index) {
        merchantStockArrayList.remove(index);
    }


    private ArrayList<MerchantStock>addNewProductList=new ArrayList<>();
    private final User_Service userService;

    public MerchantStock_Service(User_Service userService) {                   //////////2
        this.userService = userService;
    }

    public ArrayList<MerchantStock> getaddNewProduct(String productID, int merchantID, int stock){
        return getaddNewProduct(productID,merchantID,stock);
    }
    public static int addNewProduct(String productID, int merchantID, int stock) {

        if (stock < 0) {
           return 2;
       }
      for (int i = 0; i <addNewProductList.size(); i++) {
            if (addNewProductList.get(i).getProductID().equals(productID)) {
              return 1;
           }
       }
       return 3 ;
    }


    public static MerchantStock getMerchantStocks(int merchantid) {
       for(MerchantStock merchantStock:merchantStockArrayList){
           if(merchantStock.getId().equals(merchantid)){
                return merchantStock;
           }
       }return null;
    }
    }


