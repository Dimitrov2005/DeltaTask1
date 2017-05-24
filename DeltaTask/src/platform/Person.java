package platform;


public class Person extends Client {
    private String address = new String();
    private int number;
    private double money;
    protected boolean hasPaid;
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
        return person.number;
    }

    public double payMonthlyFee(Service s,double sum)
    {
        if(s.getPrice()>=sum)
        {
            hasPaid=true;
            return sum;
        }
        else {
            hasPaid = false;
            return 0.0;
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
        System.out.println(person.getService(person).getName()+"\n price: "+service.getPrice()+" leva");
        person.payMonthlyFee(service,person.money);
        System.out.println("has paid : "+ person.hasPaid + "  \n ");
        pd.setPaidAmmount(person,service);
        pd.setPaymentCompleted(person);
        System.out.println("paid amount : "+ pd.getPaidAmount(person)+"\n");
        System.out.println("Is the payment completed : "+ pd.isPaymentCompleted(person)+"\n");
        Bill bill=new Bill();
        bill.setPayable(person);
        System.out.println(bill.isPayable());
    }

}
