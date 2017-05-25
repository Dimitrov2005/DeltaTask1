package platform;

public class PaymentDomain {
     private double paidAmount;
     private boolean paymentCompleted;//depends on whether the client has paid
     private static final double SILVER_PRICE=100;
     private static final double GOLD_PRICE=200;
     private static final double PLATINUM_PRICE=300;

    public double getPaidAmount() {
        return this.paidAmount;
    }

    public boolean isPaymentCompleted() {
        return this.paymentCompleted;
    }

    public void setPaymentCompleted(Client client)
    {
        if(client.isHasPaid())
        this.paymentCompleted=true;
    }

    public void setPaidAmount(Client client)
    {
        if(client.isHasPaid())
            this.paidAmount =client.getService().getPrice();

    }

}
