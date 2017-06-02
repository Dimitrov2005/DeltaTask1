package platform;

public class Person {
    private String address;
    private int clientNumber;
    private boolean hasPaid;
    private Bill bill;
    private Service service;
    private PurchaseOrder purchaseOrder;

    // class constructor//
    public Person (String address, int number,boolean hasPaid, Bill bill,Service service, PurchaseOrder purchaseOrder){
        this.address=address;
        this.clientNumber=number;
        this.hasPaid=hasPaid;
        this.bill=bill;
        this.service=service;
        this.purchaseOrder=purchaseOrder;
    }

    // getter for address
    public String getAddress()
    {
        return this.address;
    }
    // getter for number//
    public int getNumber()
    {
        return this.clientNumber;
    }
    // getter for service ref
    public Service getService()
    {
        return this.service;
    }
    //getter for bill ref
    public Bill getBill ()
    {
        return this.bill;
    }
    //getter for hasPaid
    public boolean hasPaid()
    {
        return this.hasPaid;
    }
    public PurchaseOrder getPurchaseOrder(){return this.purchaseOrder;}

    /*
    public double payMonthlyFee(Service s,double sum)
    {   double temp;
        if(s.getPrice()>=sum)
        {
           setHasPaid(true);
           temp=sum;
           return temp;
        }
        else {
            setHasPaid(false);
            temp=0;
            return temp;
        }
    }

    public void printPerson(){
        System.out.println(hasPaid);
        System.out.println(address);
        System.out.println(service.getName());
        bill.printBill();
        System.out.println(number);
    }
    */
}
