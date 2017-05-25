package platform;

public class PurchaseOrder extends Receipt {
    private double totalAmount;
    private String productName;
    @Override
    public void setTotalAmount(Client client) {
        totalAmount=client.getService().getPrice();
    }

    @Override
    public void setProductName(Client client) {
        productName=client.getService().getName();
    }

    @Override
    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    public void printPO(Person person){

            System.out.println("Invoice for "+person.getNumber(person));
            System.out.println("Total Amount : "+ getTotalAmount());
            System.out.println("\n Package : "+ getProductName());
    }
}
