package data;

public class Product
{
    private String productName;
    private int price;
    private String sellerName;


    public Product() {
    }


    public Product(String productName, int price, String sellerName) {
        this.productName = productName;
        this.price = price;
        this.sellerName = sellerName;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}