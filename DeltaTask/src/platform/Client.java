package platform;

public abstract class Client {//abstract class for client.
    static Service service;
    public boolean hasPaid;
    public Service getService(Client client){
        return this.service;
    }
    public void setService(Service s){
        this.service=s;
    }
    public abstract  double payMonthlyFee(Service s,double sum);

}
