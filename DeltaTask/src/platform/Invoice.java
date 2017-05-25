package platform;


public class Invoice extends Receipt {
    private final String companyName="GlobalEntertainmentEOOD";
    private String productName;
    private double totalAmount;

    public void setProductName(Client client){
        productName=client.getService().getName();
    }

    @Override
    public void setTotalAmount(Client client) {
        totalAmount=client.getService().getPrice();
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public double getTotalAmount() {
        return this.totalAmount;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void printInvoice(LegalEntity entity){
        System.out.println("Invoice for "+entity.getNumbers(entity,1));
        System.out.println("Total Amount : "+ getTotalAmount());
        System.out.println("\n Package : "+ getProductName());

    }
}
