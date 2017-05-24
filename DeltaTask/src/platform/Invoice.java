package platform;


public class Invoice extends Receipt {
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
