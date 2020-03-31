import java.security.InvalidParameterException;
import java.util.Vector;

public class Service {
    // data members
    private String serviceName;
    private String serviceId;
    private double servicePrice;

    //constructors
    public Service(String serviceName, String serviceId, double servicePrice) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.servicePrice = servicePrice;
    }

    // setter methods
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    // getter methods
    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public static double getServicePrice(int index ,String type, double servicePrices )  {
        double price=0;
        if (type.equalsIgnoreCase("a")) {
            price =servicePrices;
        } else if (type.equalsIgnoreCase("B")) {
            double dicount =(servicePrices * 0.25);
            price =servicePrices-dicount;
        }
        return price;
    }

    public static void invoice(int index,Vector name,Vector id,Vector priceInvoice){
        System.out.println("invoice for "+name.elementAt( index )+" ID "+id.elementAt( index ));
        System.out.println( "total invoice amount "+priceInvoice.elementAt( index ) );

    }
}

