package platform;

public class PaymentDomain {
     private double paidAmount;
     private boolean paymentCompleted;//depends on whether the client has paid
     private static final int SILVER_PRICE=100;
     private static final int GOLD_PRICE=200;
     private static final int PLATINUM_PRICE=300;

    public double getPaidAmount(Client client) {
        return paidAmount;
    }

    public boolean isPaymentCompleted(Client client) {
        return paymentCompleted;
    }

    public void setPaymentCompleted(Client client) {
        paymentCompleted=client.hasPaid;
    }

    public void setPaidAmmount(Client client,Service s)
    {
        if(client.hasPaid){
            paidAmount =client.getService(client).getPrice();
        }
    }

}
