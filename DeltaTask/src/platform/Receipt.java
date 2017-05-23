package platform;


public abstract class Receipt {
    public abstract double getTotalAmount();
    public abstract String getProductName();
    public abstract void setProductName(Client client);
    public abstract void setTotalAmount(Client client);

}
class PurchaseOrder extends Receipt {
    private double totalAmount;
    private String productName;
    @Override
    public void setTotalAmount(Client client) {
       totalAmount=Person.service.getPrice();
    }

    @Override
    public void setProductName(Client client) {
        productName=Person.service.getName();
    }

    @Override
    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String getProductName() {
        return productName;
    }
}
class Invoice extends Receipt {
    private final String companyName="GlobalEntertainmentEOOD";
    private String productName;
    private double totalAmount;

    public void setProductName(Client client){
        productName=LegalEntity.service.getName();
    }

    @Override
    public void setTotalAmount(Client client) {
        totalAmount=LegalEntity.service.getPrice();
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getTotalAmount() {
        return totalAmount;
    }

    public String getCompanyName() {
        return companyName;
    }
}