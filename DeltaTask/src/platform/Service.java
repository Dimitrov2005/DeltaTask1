package platform;

public class Service {
    //private constant variables for package prices
    private final double GOLD_PRICE=200.0;
    private final double SILVER_PRICE=100.0;
    private final double PLATINUM_PRICE=300.0;
    //enum for different packages
    public enum Services {
        GOLD,
        SILVER,
        PLATINUM
    }
    private Services services;
    // class constructor
    public Service(Services services) {
        this.services = services;
    }


    public String getName() { //gets package name
        switch (services) {
            case GOLD:
                return "Golden Package";
            case SILVER:
                return "Silver Package";
            case PLATINUM:
                return "Platinum Package";
            default:
                return "Unknown service";
        }

    }
    public double getPrice()
    {
        switch (services)
        {
            case GOLD:
                return GOLD_PRICE;
            case SILVER:
                return SILVER_PRICE;
            case PLATINUM:
                return PLATINUM_PRICE;
            default:
                return 0;
        }
    }

}