import java.security.InvalidParameterException;
import java.util.Vector;

public class Doctor extends Employee {
    // data members
    private String rank;
    private String specialty;

    // constructors
    public Doctor(String id, String name, String address, String number, String email, double salary, String rank, String specialty) {
        super(id, name, address, number, email, salary);// call to super constructor of parent class Employee
        this.rank = rank;
        this.specialty = specialty;
    }

    // call to the other Doctor constructor using the empty Doctor constructor
    public Doctor() {
        this("xxx", "xxx", "xxx", "0", "xxx", 0.0, "xxx", "default");
    }

    // setter methods
    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    // getter methods
    public String getRank() {
        return rank;
    }

    public String getSpecialty() {
        return specialty;
    }

    public static int getDocIndex(String id,Vector docIDs)throws InvalidParameterException{
        int index=0;
            for(int i=0;i<docIDs.size();i++){
                if(docIDs.elementAt( i ).equals( id )){
                     index=i;
                    break;
                }else{
                    continue;
                }
            }

        return index;
    }

    public static void checkID(String id,Vector IDoc)throws InvalidParameterException {
        if (!(IDoc.contains( id ))) {
            throw new InvalidParameterException( "given id dosnt exist" );
        }
    }

    public static void docInfo(int index,Vector name,Vector address,Vector number,Vector email,Vector salary,Vector rank,Vector speciality){
        System.out.println("Name: "+name.elementAt(index));
        System.out.println("Address: "+address.elementAt(index));
        System.out.println("Number: "+number.elementAt(index));
        System.out.println("Email: "+email.elementAt(index));
        System.out.println("Salary: "+salary.elementAt(index));
        System.out.println("Rank: "+rank.elementAt(index));
        System.out.println("Specialty: "+speciality.elementAt(index));
        System.out.println( "--------------------------------------" );

    }
}


