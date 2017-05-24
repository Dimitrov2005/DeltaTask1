package platform;

import java.util.ArrayList;

public class LegalEntity extends Client
{
    private ArrayList<String> numberArray=new ArrayList<String>();
    private ArrayList<String> addressArray= new ArrayList<String>();
    private double money;
    protected boolean hasPaid;
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
    public double payMonthlyFee(Service s,double sum)
    {
        if(s.getPrice()>=sum)
        {
            hasPaid=true;
            return sum;
        }
        else return 0.0;
    }


    public static void main(String[] args) {
        Service s = new Service(Service.Services.GOLD);
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
