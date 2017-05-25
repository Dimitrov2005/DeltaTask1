package platform;

public class Bill {
    private int price;
    private boolean payable;

    public void setPayable(Client client){
        if(!client.isHasPaid())// if the client hasn't paid=> can pay the bill
            this.payable=true;


        else this.payable=false;
    }

    public boolean isPayable() {
        return payable;
    }
}
