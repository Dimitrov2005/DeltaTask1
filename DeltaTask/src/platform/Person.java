package platform;


public class Person extends Client {
    private String address = new String();
    private int number;
    private double money;
    Bill bill = new Bill();
    PurchaseOrder po=new PurchaseOrder();
    // class constructor//
    public Person (String address, int number){
        this.address=address;
        this.number=number;
    }
    // getter for address
    public String getAddress(Person person){
        return this.address;
    }
    // getter for number//
    public int getNumber(Person person){
        return this.number;
    }

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

    public static void main(String[] args) {
        Person person = new Person("Kambana str.# 3",35919013);
        PaymentDomain pd = new PaymentDomain();
        System.out.println(person.getAddress(person));
        System.out.println(person.getNumber(person));
        person.money=200;
        Service service = new Service(Service.Services.GOLD);
        person.setService(service);
        System.out.println(person.getService().getName()+"\n price: "+service.getPrice()+" leva");
        person.payMonthlyFee(service,person.money);
        System.out.println("has paid : "+ person.isHasPaid() + "  \n ");
        pd.setPaidAmount(person);
        pd.setPaymentCompleted(person);
        System.out.println("paid amount : "+ pd.getPaidAmount()+"\n");
        System.out.println("Is the payment completed : "+ pd.isPaymentCompleted()+"\n");

        person.bill.setPayable(person);
        System.out.println("is the bill payable: " + person.bill.isPayable());

        person.po.setProductName(person);
        person.po.setTotalAmount(person);
        person.po.printPO(person);
    }

}
