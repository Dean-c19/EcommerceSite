package data;

public class Bid {
    private String biddersName;
    private String productName;
    private double bidAmount;

    public Bid () {
    }

    public Bid(String biddersName, String productName, double bidAmount) {
        this.biddersName = biddersName;
        this.productName = productName;
        this.bidAmount = bidAmount;
    }


    public String getBiddersName() {
        return biddersName;
    }

    public void setBiddersName(String biddersName) {
        this.biddersName = biddersName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

}
