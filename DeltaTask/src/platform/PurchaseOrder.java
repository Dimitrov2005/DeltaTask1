package platform;

public class PurchaseOrder extends Receipt {
    private int clientNumber;
    private double totalAmount;
    private String productName;
    //constructor
    public PurchaseOrder(double price, String productName,int clientNumber){
        this.totalAmount=price;
        this.productName= productName;
        this.clientNumber=clientNumber;
    }



    public double getTotalAmount() {
        return this.totalAmount;
    }

    public String getProductName() {
        return this.productName;
    }
    public int getClientNumber(){
        return this.clientNumber;
    }
    public void printPO(Person person){
                if(person.getNumber()== getClientNumber()) {
                    System.out.println("Invoice for " + getClientNumber() + "\n");
                    System.out.println("Total Amount : " + getTotalAmount());
                    System.out.println("\n Package : " + getProductName());
                }
    }
}
