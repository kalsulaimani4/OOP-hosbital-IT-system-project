import java.security.InvalidParameterException;
import java.util.Vector;

public class Patient {


    // data members
    private String id;
    private String name;
    private String address;
    private String number;
    private String email;
    private String type;

    // constructors
    public Patient(String id,String name,String address,String number,String email,String type){
        this.id=id;
        this.name=name;
        this.address=address;
        this.number=number;
        this.email=email;
        this.type=type;
    }
    // call to the other constructor using the empty one
    public Patient(){
        this("xxx","xxx","xxx","0","xxxx","A");
    }

    //setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type){
        this.type = type;
    }
    // getter methods

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }


    public static void checkPatientID(String id, Vector idVec) throws InvalidParameterException{
        if (!(idVec.contains( id ))) {
            throw new InvalidParameterException( "given id dose not  exist" );
        }
    }

    public static int getPatientIndex(String ID, Vector patientIdVec) throws InvalidParameterException {
            int index=0;
            for(int i=0;i<patientIdVec.size();i++){
                if(patientIdVec.elementAt( i ).equals( ID )){
                    index=i;
                    break;
                }else{
                    continue;
                }
            }

            return index;
        }

    public static void patientInfo(int index,Vector name,Vector address,Vector number,Vector email,Vector type) {
        System.out.println( "Name: " + name.elementAt( index ) );
        System.out.println( "Address: " + address.elementAt( index ) );
        System.out.println( "Number: " + number.elementAt( index ) );
        System.out.println( "Email: " + email.elementAt( index ) );
        System.out.println("patient type : "+type.elementAt(index));
    }

    }




