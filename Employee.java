public class Employee{
    // data members
    private String id;
    private String name;
    private String address;
    private String number;
    private String email;
    private double salary;

    //constructors
    public Employee(String id, String name, String address, String number, String email, double salary){
        this.id=id;
        this.name=name;
        this.address=address;
        this.number=number;
        this.email = email;
        this.salary=salary;
    }
    // empty constructor
    public Employee(){
        this(" "," "," ","0"," ",0.0);
    }

    //setter methods
    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public void setNumber(String number){
        this.number=number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // getter methods
    public String getId(){
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public static void Options(){
        System.out.println("select from the following by entering the number  : ");
        System.out.println("1- Add a doctor ");                     //printing all the selections
        System.out.println("2- Add a service");
        System.out.println("3- Add a patient");
        System.out.println("4- Print all doctors information");
        System.out.println("5- Print all patients information");
        System.out.println("6- Display specific doctor data ");
        System.out.println("7- Display specific patient data");
        System.out.println("8- Print a specific patient’s bill");
        System.out.println("9- Exit the program");
    }


}
