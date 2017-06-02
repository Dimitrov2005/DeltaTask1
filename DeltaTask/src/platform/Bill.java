package platform;

public class Bill {
    public int clientNumber;
    private double price;
    private boolean payable;

    public Bill(double price, boolean payable,int clientNumber){
        this.price=price;
        this.payable=payable;
        this.clientNumber=clientNumber;
    }

    public void printBill(){
        System.out.println("Client number : "+clientNumber+"\n");
        System.out.println("Bill price : "+price+"\n");
        System.out.println("Client has paid the bill : "+payable);

    }

    /*
    public void setPayable(Client client){
        if(!client.isHasPaid())// if the client hasn't paid=> can pay the bill
            this.payable=true;


        else this.payable=false;
    }

    public boolean isPayable() {
        return payable;
    }
    */
}
