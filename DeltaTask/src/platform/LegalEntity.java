package platform;

import java.util.ArrayList;

public class LegalEntity
{
    private Service service;
    private boolean hasPaid;
    private ArrayList<String> numberArray=new ArrayList<>();
    private ArrayList<String> addressArray= new ArrayList<>();
    private double money;
    Invoice invoice;
    Bill bill;

    //constructor
    public LegalEntity(String num, String address,Bill bill, Invoice invoice,Service service){
        this.addressArray.add(address);
        this.numberArray.add(num);
        this.bill = bill;
        this.invoice=invoice;
        this.service=service;
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
    public Service getService(LegalEntity entity){
        return this.service;
    }
    public Bill getBill(LegalEntity entity){
        return this.bill;
    }
    public Invoice getInvoice(LegalEntity entity){
        return this.invoice;
    }
    public boolean hasPaid(LegalEntity entity){
        return this.hasPaid;
    }


  /*  public double payMonthlyFee(Service s,double sum)
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
*/


}
