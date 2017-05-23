package platform;

/**
 * Created by User on 18.5.2017 г..
 */
public abstract class Service {

    public double getPrice(){
        return 0.0;
    }
    public String getBandwidth(){
     return "unknown";
    }
    public String getName(){
        return "Unknown Service";
    }

}
class Gold extends Service{
    @Override
    public String getBandwidth() {
        return "200";
    }

    @Override
    public double getPrice() {
        return 200.0;
    }

    @Override
    public String getName() {
        return "Gold Package";
    }
}

class Silver extends Service{
    @Override
    public String getBandwidth() {
        return "100";
    }

    @Override
    public double getPrice() {
        return 100.0;
    }

    @Override
    public String getName() {
        return "Silver Package";
    }
}
class Platinum extends Service{
    @Override
    public String getBandwidth() {
        return "300";
    }

    @Override
    public double getPrice() {
        return 300.0;
    }

    @Override
    public String getName() {
        return "Platinum Package";
    }
}
