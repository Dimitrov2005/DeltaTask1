package platform;

import java.util.ArrayList;

public abstract class Client {
    static Service service;
    static boolean hasPaid;
    public Service getService(Client client){
        return client.service;
    }
    public void setService(Service s){
        this.service=s;
    }
    public static double payMonthlyFee(Service s,double sum){
        if(s.getPrice()==sum)
        {
            hasPaid=true;
            return sum;
        }
        else return 0.0;
    }
}
class Person extends Client{
    private String address = new String();
    private int number;
    private double money;

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


    public static void main(String[] args) {
        Person person = new Person("Kapana str.# 3",35919013);
        PaymentDomain pd = new PaymentDomain();
        System.out.println(person.getAddress(person));
        System.out.println(person.getNumber(person));
        person.money=200;
        Service service = new Gold();
        person.setService(service);
        System.out.println(person.getService(person).getName()+"\n price: "+service.getPrice()+" leva");
        payMonthlyFee(service,person.money);
        System.out.println("has paid : "+ person.hasPaid + "  \n ");
        pd.setPaidAmmount(person,service);
        pd.setPaymentCompleted(person);
        System.out.println("paid amount : "+ pd.getPaidAmount(person)+"\n");
        System.out.println("Is the payment completed : "+ pd.isPaymentCompleted(person)+"\n");

        }
        }
class LegalEntity extends Client{

    private ArrayList<String> numberArray=new ArrayList<String>();
    private ArrayList<String> addressArray= new ArrayList<String>();
    private double money;
    //contructor
    public LegalEntity(String num, String address){
        addressArray.add(address);
        numberArray.add(num);
    }
    public void setMoney(LegalEntity e, double money){

        this.money = money;
    }
    // if we have multiple addresses and numbers we can add them
    public void addAnotherAddress(LegalEntity client,String newAddress){
        addressArray.add(newAddress);
    }
    public void addAnotherNumber(LegalEntity client,String newNumber){
        numberArray.add(newNumber);
    }
    //getters
    public String getAddresses(LegalEntity entity,int indexOfAddress){
       return addressArray.get(indexOfAddress);
    }
    public String getNumbers(LegalEntity entity,int indexOfNumber){
        return numberArray.get(indexOfNumber);
    }



    public static void main(String[] args) {
        Service s = new Silver();
        LegalEntity client =new LegalEntity("988893","13,Khan Krum str.");
        client.addAnotherAddress(client,"23,AnotherStreet str.");
        client.addAnotherNumber(client,"098s90s0a");
        client.setService(s);
        System.out.println(client.getService(client).getName()+" \n "+client.getAddresses(client,1));
        System.out.println(client.getNumbers(client,1));
        PaymentDomain pd = new PaymentDomain();
        client.setMoney(client,10.0);
        client.payMonthlyFee(client.getService(client),client.money);
        System.out.println("has paid : "+ client.hasPaid + "  \n ");
        pd.setPaidAmmount(client,service);
        pd.setPaymentCompleted(client);
        System.out.println("paid amount : "+ pd.getPaidAmount(client)+"\n");
        System.out.println("Is the payment completed : "+ pd.isPaymentCompleted(client)+"\n");

    }
}