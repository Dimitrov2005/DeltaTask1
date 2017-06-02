package platform;

public class Service {
    //enum for different packages
    public enum Services {
        GOLD,
        SILVER,
        PLATINUM
    }
    Services services;
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
    public double getPrice() // gets package price
    {
        switch (services)
        {
            case GOLD:
                return 200.0;
            case SILVER:
                return 100.0;
            case PLATINUM:
                return 300.0;
            default:
                return 0;
        }
    }

}