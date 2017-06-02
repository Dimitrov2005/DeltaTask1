package platform;


public class Invoice extends Receipt {
    private final String companyName="GlobalEntertainmentEOOD";
    private String productName;
    private double totalAmount;
    public int clientNumber;

    public Invoice(String productName,double totalAmount, int clientNumber ){
        this.productName=productName;
        this.totalAmount=totalAmount;
        this.clientNumber=clientNumber;
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

    @Override
    public int getClientNumber() {
        return this.clientNumber;
    }

    public void printInvoice(LegalEntity entity){
        System.out.println(getCompanyName() + "\n");
        System.out.println("Invoice for : "+getClientNumber()+"\n");
        System.out.println("Total Amount : "+getTotalAmount()+"\n");
        System.out.println("Package : "+getProductName());

    }
}
