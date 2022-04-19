package pl.edu.pwsztar;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements ShoppingCartOperation {

    public List<Product> products = new ArrayList<>();

    public List<Product> getProducts(){
        return products;
    }

    public boolean addProducts(String productName, int price, int quantity) {
        if(quantity <= 0 || price < 0){return false;}
        if(products.size() >= PRODUCTS_LIMIT){return false;}
        if(products.size()==0){
            products.add(new Product(productName, price, quantity));
            return true;
        }else{
            for(Product product: products){
                if(product.getName().equals(productName)){
                    if(product.getPrice() == price ){
                        product.setQuantity(product.getQuantity()+quantity);
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    products.add(new Product(productName, price, quantity));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteProducts(String productName, int quantity) {
        if(quantity <= 0){return false;}

        for(Product product: products){
            if(product.getName().equals(productName) && product.getQuantity()-quantity >= 0){
                product.setQuantity((product.getQuantity()-quantity));
                return true;
            }
        }
        return false;
    }

    public int getQuantityOfProduct(String productName) {
        for(Product product: products){
            if(product.getName().equals(productName)){
                return product.getQuantity();
            }
        }
        return 0;
    }

    public int getSumProductsPrices() {
        int sum = 0;
        for(Product product: products){
            sum = sum + (product.getPrice()*product.getQuantity());
        }
        return sum;
    }

    public int getProductPrice(String productName) {
        for(Product product: products){
            if(product.getName().equals(productName)){
                return product.getPrice();
            }
        }
        return 0;
    }

    public List<String> getProductsNames() {
        List<String> names = new ArrayList<>();
        for(Product product: products){
            names.add(product.getName());
        }
        return names;
    }
}
