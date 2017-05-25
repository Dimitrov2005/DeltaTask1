package platform;

import java.util.ArrayList;

public class LegalEntity extends Client
{
    private ArrayList<String> numberArray=new ArrayList<String>();
    private ArrayList<String> addressArray= new ArrayList<String>();
    private double money;
    Invoice invoice = new Invoice();
    Bill bill = new Bill();
    //constructor
    public LegalEntity(String num, String address){
        this.addressArray.add(address);
        this.numberArray.add(num);
    }
    // Setter for private variable money
    public void setMoney(double money){
        this.money = money;
    }

    // if we have multiple addresses and numbers we can add them

    public void addAnotherAddress(LegalEntity client,String newAddress){
        this.addressArray.add(newAddress);
    }
    public void addAnotherNumber(LegalEntity client,String newNumber){
        this.numberArray.add(newNumber);
    }

    //getters

    public String getAddresses(LegalEntity entity,int indexOfAddress){
        return this.addressArray.get(indexOfAddress);
    }
    public String getNumbers(LegalEntity entity,int indexOfNumber){
        return this.numberArray.get(indexOfNumber);
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
            temp=0.0;
            return temp;
        }
    }


    public static void main(String[] args) {

        Service s = new Service(Service.Services.GOLD);
        LegalEntity client =new LegalEntity("988893","13,Khan Krum str.");
        client.addAnotherAddress(client,"23,AnotherStreet str.");
        client.addAnotherNumber(client,"098s90s0a");
        client.setService(s);
        System.out.println(client.getService().getName()+" \n "+client.getAddresses(client,1));
        System.out.println(client.getNumbers(client,1));
        PaymentDomain pd = new PaymentDomain();
        client.invoice.setProductName(client);
        client.invoice.setTotalAmount(client);

        client.setMoney(200.0);
        // client.payMonthlyFee(client.getService(),client.money);

        /*System.out.println("has paid : "+ client.isHasPaid()+ "  \n ");
        pd.setPaymentCompleted(client);
        pd.setPaidAmount(client);
*/
        System.out.println("paid amount : "+ pd.getPaidAmount()+"\n");
        System.out.println("Is the payment completed : "+ pd.isPaymentCompleted()+"\n");

        client.invoice.printInvoice(client);
        client.bill.setPayable(client);
        System.out.println(client.bill.isPayable());

    }
}
