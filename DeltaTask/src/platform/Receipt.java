package platform;


public abstract class Receipt {
    public abstract double getTotalAmount();
    public abstract String getProductName();
    public abstract void setProductName(Client client);
    public abstract void setTotalAmount(Client client);

}
