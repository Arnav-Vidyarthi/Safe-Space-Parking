//Parking Management

//Made by - Arnav Vidyarthi

/*To Be Done Using Only Java Basics And OOPS Concepts Till Static And Non-Static 
 without importing anything*/
class ParkingLot {
    
    //Static Array to Store the Name Of Cars In The Parking
    static String[] data= new String[20];
    static int i = 0;  //Static integer used as index for the array
    static boolean spaceAvailable = false;  //Available Parking Space 
    
    //Instance Variables
    String carOwner;
    String carName;
    int carNumber;
    int time;
    
    //Constructor
    ParkingLot(String co,String cName,int cNum,int t){
        // Assigning Car Details
        carOwner = co;  
        carName = cName;
        carNumber = cNum;
        time = t;

        //Storing Car Name in the array
        ParkingLot.data[i] = carName ;

        //Incerasing Index Value for next Customer
        if(i < 20){
            spaceAvailable = true; //Space is Available If i is less than 20 
            i += 1;
        }

        //Parking space is not available
        else{
            spaceAvailable = false;
            System.out.println("Sorry....No Parking Space is Available");
            System.out.println("+------------------+------------------+");
        } 
    }

    // Removing the Car 
    static void remove(String carName) {
        boolean isInParking = false;
        
        //Checking if the car is in parking
        for (int j = 0 ; j < i; j++){
            if (data[j] == carName) {

                isInParking = true;
                System.out.println();
                System.out.println("+----------------------------------+");
                System.out.println(carName + " is no longer in the parking");
                
                // Shifting the elements in the array from the car to remove to the end 
                for (int s = j; s < i-1; s++) {
                    data[s] = data[s + 1];
                }

                data[i - 1] = null; //Changing the last value to null 
                i -= 1;
                break;
            }   
        }
        if(!isInParking){

            System.out.println();
            System.out.println("No Such Car in the Parking");        
        }
    }

    static void Show(){

        //Just for Some Designing
        System.out.println();
        System.out.println();
        System.out.println("+-----------------------------------+");
        System.out.println("Cars in parking : ");

        for(String i : ParkingLot.data){
            if (i != null){
                System.out.println(i);
            }
        }
    }

    void charge(){
        if(spaceAvailable){
            // Charge for Parking the Car for No. of Days
            if(time <= 5){
            switch (time) {
                case 1:
                    System.out.println("Your charge will be 150Rs");
                    System.out.println();
                    System.out.println("+----------------------+");
                    break;
                case 2:
                    System.out.println("Your charge will be 250Rs");
                    System.out.println();
                    System.out.println("+-----------------------+");
                    break;
                case 3:
                    System.out.println("Your charge will be 320Rs");
                    System.out.println();
                    System.out.println("+-----------------------+");
                    break;
                case 4:
                    System.out.println("Your charge will be 380Rs");
                    System.out.println();
                    System.out.println("+-----------------------+");
                    break;
                case 5:
                    System.out.println("Your charge will be 450Rs");
                    System.out.println();
                    System.out.println("+-----------------------+");
                    break;
                default:
                    break;
                }
            }
            //Parking for more than 5 days is not available
            else{
            System.out.println("Parking for more than 5 Days is not allowed");
            System.out.println("+-------------------++--------------------+");
            }
        }       
    }

    //Details of the car for parking
    void showRecord(){
        System.out.println("+-----------------------+");
        System.out.println("Car Owner ---- " + carOwner);
        System.out.println("Car Name ---- " + carName);
        System.out.println("Car Number ---- " + carNumber);
        System.out.println("Days Car is to be Parked ---- " + time);
        System.out.println("+------------------------++------------------------+");
    }
}

//Main Class
public class Project{
    public static void main(String[] args) {
        //Greeting
        System.out.println("Welcome to Safe Space Parking");

        //Customer no.1
        ParkingLot Customer1 = new ParkingLot("Myself","G-Wagon R",4545,4);
        Customer1.showRecord();
        Customer1.charge();
        
        //Customer no.2
        ParkingLot Customer2 = new ParkingLot("You","BMW",4565,2);
        Customer2.showRecord();
        Customer2.charge();

        //Customer no.3
        ParkingLot Customer3 = new ParkingLot("Anant","Omni",0401, 5);
        Customer3.showRecord();
        Customer3.charge();  
        
        //Showing the Name of Cars in the Parking
        ParkingLot.Show();

        ParkingLot.remove("BMW");

        ParkingLot.Show();
    }
}