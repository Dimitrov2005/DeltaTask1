package platform;

public class Bill {
    private int price;
    private boolean payable;

    public void setPayable(Client client){
        if(!client.isHasPaid())// if the client hasn't paid=> can pay the bill
            payable=true;

        else payable=false;
    }

    public boolean isPayable() {
        return payable;
    }
}
