import com.sun.javaws.exceptions.InvalidArgumentException;

import java.security.InvalidParameterException;
import java.util.Vector;

public class AdministrationStaff extends Employee {
    //data members
    private String position;

    // constructor
    public AdministrationStaff(String id, String name, String address, String number, String email, double salary, String position) {
        super(id, name, address, number, email, salary);// call to super constructor
        this.position = position;
    }

    public AdministrationStaff() {
        this("00000000", "xxxx", "xxxxx", "0000", "xxxxx", 0.0, "backup");
    }

    //setter methods
    public void setPosition(String Position) {
        this.position = position;
    }

    // getter method
    public String getPosition() {
        return position;
    }

    public static String testAdmin(Vector vec, String admin) throws InvalidParameterException {
        if(!vec.contains(admin)){
            throw new InvalidParameterException("invalid admin name ");
        }else{
            return admin;
        }

    }
}

