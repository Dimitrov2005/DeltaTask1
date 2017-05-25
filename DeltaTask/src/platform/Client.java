package platform;

public abstract class Client {//abstract class for client.
    private static Service service;
    private boolean hasPaid;

    public Service getService(){
        return this.service;
    }

    public void setService(Service s){
        this.service=s;
    }

    public boolean isHasPaid() {
        return this.hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public abstract  double payMonthlyFee(Service s, double sum);

}
