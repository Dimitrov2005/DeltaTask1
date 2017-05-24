package platform;

public class PurchaseOrder extends Receipt {
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
