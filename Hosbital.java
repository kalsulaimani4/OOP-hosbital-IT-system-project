import com.sun.javaws.exceptions.InvalidArgumentException;

import java.security.InvalidParameterException;
import java.util.Vector;
import java.util.Scanner;

public class Hosbital {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);// creating scanner object

        // initiating three AdministrationStaff staff members
         Employee moaid= new AdministrationStaff("1009320","moaid","mecca","023212","moaid@mail.com",32232.3,"reception");
        AdministrationStaff mohanad = new AdministrationStaff("1009326","mohanad","mecca","0314","moaid@mail.com",30232.3,"reception");
        Employee khalil = new AdministrationStaff("100006","khalil","mecca","03231","moaid@mail.com",130232.3,"manger");

        // creating a vector to put all the staff in to check later if the given name belongs to the vector list
        Vector<String> admins= new Vector(10);
        admins.add(khalil.getName());
        admins.add(mohanad.getName());
        admins.add(moaid.getName());

        // creating a vector to add all the doctors emelents that will be added later so when we display them we have easy acces to the data
        Vector<Doctor>doctors=new Vector<>(50);
        Vector<String> doctorID= new Vector<>(50);
        Vector<String> doctorName= new Vector<>(50);
        Vector<String> doctorAddress= new Vector<>(50);
        Vector<String> doctorNumber= new Vector<>(50);
        Vector<String> doctorEmail= new Vector<>(50);
        Vector<Double> doctorSalary= new Vector<>(50);
        Vector<String> doctorRanks = new Vector<>(50);
        Vector<String> doctorSpeciality= new Vector<>(50);

        // creating vector for all the patinace that will be added later
        Vector<Patient>patients= new Vector<>(50);
        Vector<String> patientID= new Vector<>(50);
        Vector<String> patientName= new Vector<>(50);
        Vector<String> patientAddress= new Vector<>(50);
        Vector<String> patientNumber= new Vector<>(50);
        Vector<String> patientEmail= new Vector<>(50);
        Vector<String> patientType= new Vector<>(50);
        Vector<Double> patientInvoice= new Vector<>( 50 );

        // creating vector for all the services  that will be added later
        Vector<Service> services= new Vector<>(50);
        Vector<String> servicesId = new Vector<>( 20 );
        Vector<String> servicesName = new Vector<>( 20 );
        Vector<Double> servicesPrice = new Vector<>( 20 );

        /* this block is to take in user input and to test if its within the vector for employees it calls the test method
        to see if the given name is valid if not it throws a exception if given name is write exit the label
         */
        String adminName="";
        Admin:
        while (true){
            System.out.println("enter Admin name ");
             adminName = scan.next();
            if(!admins.contains(adminName)) {
                try {
                    AdministrationStaff.testAdmin(admins, adminName);//method call
                } catch (Exception e) {
                    System.out.println(e.getMessage());// calling for exception message that's made in the method
                    continue Admin;
                }
            }else{
                break Admin;
            }
        }

        System.out.println("Hello "+adminName);

        int numOfTerminate=0;// in case 9 if it is used this number is changed to end the while loop
        int option=0;//read the number the user inputs to know which option they selected
        Top:
        while(numOfTerminate!=9) {//while loop runs till 9 is selected

            int numOfDoctors = 0;// initializing a counter for all the added Doctors
            int numOfPatience = 0;// initializing a counter for all the added patience
            int numOfServices = 0;//initializing a counter for all the added services

            Employee.Options();
            option = scan.nextInt();
            switch (option) {
                case 1:// adding a doctor
                    System.out.println( "enter the doctors id " );
                    String id = scan.next();
                    doctorID.add( numOfDoctors , id );// the id to the vector using the number of added doctors to know the index

                    System.out.println( "enter the doctors name " );
                    String name = scan.next();

                    doctorName.add( numOfDoctors , name );//adding the name to the vector using the number of added doctors to know the index

                    System.out.println( "enter the doctors address" );
                    String address = scan.next();
                    doctorAddress.add( numOfDoctors , address );

                    System.out.println( "enter the doctors number " );
                    String num = scan.next();
                    doctorNumber.add( numOfDoctors , num );

                    String email;
                    Emails:
                    while(true) {
                        System.out.println( "enter the doctors email" );
                         email = scan.next();
                        try {// testing if the given emial is a true email so it must contain @ sign and end with .com
                            if (!(email.contains( "@" ) && email.endsWith( ".com" ))) {
                                throw new InvalidParameterException( "invalid email address" );
                            }else{
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println( e.getMessage() );
                            continue Emails;

                        }
                    }
                    doctorEmail.add( numOfDoctors , email );// adding element after testing its valid

                    System.out.println( "enter doctors rank " );
                    String ranks = scan.next();
                    doctorRanks.add( numOfDoctors , ranks );

                    String salary;
                    double salarys;
                    salarys:
                    while(true) {
                        System.out.println( "enter the doctors salary" );
                        salary=scan.next();
                        try {
                            salarys=Double.parseDouble(salary);
                            if(salarys==salarys){
                                break;
                            }else{
                                throw new NumberFormatException("salary contains string invalid input ");
                            }
                        } catch (Exception e) {
                            System.out.println( e.getMessage() );
                            continue salarys;
                        }
                    }

                    doctorSalary.add( numOfDoctors , salarys );

                    System.out.println( "enter the doctors speciality" );
                    String speciality = scan.next();
                    doctorSpeciality.add( numOfDoctors , speciality );


                    Doctor newDoctor = new Doctor( id , name , address , num , email , salarys , ranks , speciality );// giving the constructor all the doctors info

                    doctors.add( newDoctor );

                    numOfDoctors++;// increments every time a new doctor is added
                    continue;// going to the while loop again to show selection again

                case 2:// adding a service

                    System.out.println( "enter service name : " );
                    String servName = scan.next();
                    servicesName.add( numOfServices , servName );

                    System.out.println( "enter service Id : " );
                    String servID = scan.next();
                    servicesId.add( numOfServices , servID );

                    System.out.println( "enter service price : " );
                    double price = scan.nextDouble();
                    servicesPrice.add( numOfServices , price );

                    Service newService = new Service( servName , servID , price );// call to constructor

                    services.add( newService );// adding service to vector

                    numOfServices++;// after a service is add increment counter
                    continue;

                case 3:// add a patient
                    System.out.println( "enter the patient id " );
                    String patientId = scan.next();
                    patientID.add( numOfPatience , patientId );

                    System.out.println( "enter the patient name " );
                    String patientsName = scan.next();
                    patientName.add( numOfPatience , patientsName );

                    System.out.println( "enter the patient address" );
                    String patientsAddress = scan.next();
                    patientAddress.add( numOfPatience , patientsAddress );

                    System.out.println( "enter the patient number " );
                    String patientNum = scan.next();
                    patientNumber.add( numOfPatience , patientNum );

                    String emails;
                    Emails:
                    while(true) {
                        System.out.println( "enter the doctors email" );
                        emails = scan.next();
                        try {// testing if the given emial is a true email so it must contain @ sign and end with .com
                            if (!(emails.contains( "@" ) && emails.endsWith( ".com" ))) {
                                throw new InvalidParameterException( "invalid email address" );
                            }else{
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println( e.getMessage() );
                            continue Emails;

                        }
                    }
                    patientEmail.add( numOfPatience , emails );

                    String type;
                    Types:
                    while (true) {
                        System.out.println( "enter patient type " );
                        type = scan.next().toUpperCase();
                        try {// testing if the inputted type is A or B if not then try throws a exception
                            if (!(type.equals( "A" ) || type.equals( "B" ))) {
                                throw new InvalidParameterException( "invalid patient type chose from type A or B " );
                            }else{
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println( e.getMessage() );
                            continue Types;
                        }
                    }
                    patientType.add( numOfPatience , type );

                    Patient newPatient = new Patient( patientId , patientsName , patientsAddress , patientNum , emails , type );// calling constructor

                    patients.add( newPatient );

                    numOfPatience++;
                    continue;
                case 4:// print all doctors information
                    int size = numOfDoctors;
                    for (int i = 0; i < doctorID.size(); i++) {
                        System.out.println( "ID: " + doctorID.elementAt( i ) );
                        System.out.println( "Name: " + doctorName.elementAt( i ) );
                        System.out.println( "Address: " + doctorAddress.elementAt( i ) );
                        System.out.println( "Number: " + doctorNumber.elementAt( i ) );
                        System.out.println( "Email: " + doctorEmail.elementAt( i ) );
                        System.out.println( "Salary: " + doctorSalary.elementAt( i ) );
                        System.out.println( "Rank: " + doctorRanks.elementAt( i ) );
                        System.out.println( "Specialty: " + doctorSpeciality.elementAt( i ) );
                        System.out.println( "--------------------------------------" );
                    }
                    continue Top;// jumps to label top so it dosnt jump to the local loop
                case 5://display data for all patience
                    for (int i = 0; i < patientID.size(); i++) {
                        System.out.println( "ID: " + patientID.elementAt( i ) );
                        System.out.println( "Name: " + patientName.elementAt( i ) );
                        System.out.println( "Address: " + patientAddress.elementAt( i ) );
                        System.out.println( "Number: " + patientNumber.elementAt( i ) );
                        System.out.println( "Email: " + patientEmail.elementAt( i ) );
                        System.out.println( "type: " + patientType.elementAt( i ) );
                        System.out.println( "----------------------------------" );
                    }
                    continue Top;// jumps to label top so it dose not jump to the local loop
                case 6:// getting a doctors id and showing all his information
                    ID:
                    while (true) {
                        System.out.println( "enter the ID of the Doctor your looking for " );
                        String getDoc = scan.next();
                        int index = 0;
                       /* method takes given id tests to see if the vector contains first
                       if it does not belong to the vector a exception is throw otherwise it returns the right index*/
                        try {
                            Doctor.checkID( getDoc , doctorID );
                        } catch (Exception e) {
                            System.out.println( e.getMessage() );
                            continue ID;
                        }
                        index = Doctor.getDocIndex( getDoc , doctorID );// giving the needed index to the variable index

                        // method takes the given index and all the Vectors to print all the doctors information
                        Doctor.docInfo( index , doctorName , doctorAddress , doctorNumber , doctorEmail , doctorSalary , doctorRanks , doctorSpeciality );
                        continue Top;
                    }
                case 7:// getting a patience information using there id
                    PID:
                    while (true) {
                        System.out.println( "enter the ID of the Patient your looking for " );
                        String getP = scan.next();
                        int index = 0;
                       /* method takes given id tests to see if the vector contains first
                       if it does not belong to the vector a exception is throw otherwise it returns the right index*/
                        try {
                            Patient.checkPatientID( getP , patientID );
                        } catch (Exception e) {
                            System.out.println( e.getMessage() );
                            continue PID;
                        }
                        index = Patient.getPatientIndex( getP , patientID );// giving the needed index to the variable index

                        // method takes the given index and all the Vectors to print all the patient information
                        Patient.patientInfo( index , patientName , patientAddress , patientNumber , patientEmail , patientType );
                        continue Top;

                    }

                case 8:// taking patient id then entering all the services and taking what type they are to calculate the bill
                    int index = 0;
                    invoice:
                    while (true) {
                        System.out.println( "enter the ID of the Patient to add services : " );
                        String getP = scan.next();
                       /* method takes given id tests to see if the vector contains first
                       if it does not belong to the vector a exception is throw otherwise it returns the right index*/
                        try {
                            Patient.checkPatientID( getP , patientID );
                        } catch (Exception e) {
                            System.out.println( e.getMessage() );
                            continue invoice;
                        }
                        index = Patient.getPatientIndex( getP , patientID );// giving the needed index to the variable index
                        break;
                    }
                    Adds:
                    while(true) {
                        int i;
                        for (i=0; i < servicesName.size(); i++) {// loop to print out all services information
                            System.out.println( "ID: " + servicesId.elementAt( i ) );
                            System.out.println( "Name : " + servicesName.elementAt( i ) );
                            System.out.println( "Price : " + servicesPrice.elementAt( i ) );
                            System.out.println( "---------------------------------------" );
                        }
                        System.out.println( "enter the id of the service that has been given " );// takes id of the needed service
                        int add = scan.nextInt();

                        patientInvoice.add( index , Service.getServicePrice( index , patientType.elementAt( index ) , servicesPrice.elementAt( index ) ) );
                        // vector to store bill amount saved in the place if the patient id
                        // the method takes the type of the patient to see if it needs to adjust the price and returns the price

                        System.out.println( "want to add more services ? " );// makes sure thats all the servies the patient recived
                        String more = scan.next();
                        if(more.equalsIgnoreCase( "yes" )){
                            i=0;
                            continue Adds;
                        }else{
                            break;
                        }
                    }
                    // displaying invoice
                    Service.invoice( index , patientName , servicesId , patientInvoice );
                    System.out.println( "--------------------------" );
                    continue Top;
                case 9:
                    System.out.println("program terminated ");
                    numOfTerminate=9;// terminates program by ending the while loop
            }

        }
    }
}
