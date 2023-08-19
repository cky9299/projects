import java.util.Scanner;
import cred.*;


class Program
{
        
    
    public static void main(String[] args)
    {
        UserCredentials userCredentials = new UserCredentials();
        AdminCredentials adminCredentials = new AdminCredentials();
                        Scanner scan = new Scanner(System.in);



        System.out.println("Taxi Reservation System\n\nRegistration\n1. user\n2. admin\n\nEnter a number: ");
                    int chosenId=0;

        boolean continueInput = true;
        int option=1;
        do
        {
            try
            {

                option = scan.nextInt();
                while (option!=1 && option!=2)
                {
                    System.out.println("Invalid option.\n Taxi Reservation System\n\nRegistration\n1. user\n2. admin\n\nEnter a number: ");
                    option = scan.nextInt();
                }
                continueInput = false;
            }   
            catch (Exception ex)
            {
                System.out.println("Incorrect input: an integer is required");scan.nextLine();
                
            } 
        } while (continueInput);
            

            //instantiate obj for each class
//(int _taxiId, boolean _isAvailable, String _departDate, String _departTime, String _seatType, int _noSeats);
            Sedan sedan = new Sedan(1,true,"2024-5-10","1025","leather",2);
            Sedan sedan1 = new Sedan(2,true,"2023-6-10","0012","canvas",2);
            
            SUV suv = new SUV(3,true,"2023-7-10","1150","cushion",6);
            SUV suv1 = new SUV(4,true,"2024-8-10","0610","nylon",6);

            Limousine limousine = new Limousine(5,true,"2024-6-10","2110","cotton",8);
            Limousine limousine1 = new Limousine(6,true,"2023-9-10","1430","wool",8);
           
//append suv,suv1... to arr. index=0 to end. each ele is obj. cust enter index num so onj accessed bia
//arr[i].attr
            sedan.setTotalFee(sedan.calculateTotalFee(1.2,10.));
            sedan1.setTotalFee(sedan1.calculateTotalFee(1.5,12.));
            
            suv.setTotalFee(suv.calculateTotalFee(1.3,20.5));
            suv1.setTotalFee(suv1.calculateTotalFee(3.1,23.1));
            
            limousine.setTotalFee(limousine.calculateTotalFee(5.2,40.));
            limousine1.setTotalFee(limousine1.calculateTotalFee(4.2,35.4));
        

        if (option==1)
        {
            userCredentials.register();
            userCredentials.login();

            System.out.println("\n\nOrder Taxi:\n\ntaxiId  isAvailable  totalFee  departTime      departDate  seatType  noSeats");
            System.out.println(sedan.toString());
            System.out.println(sedan1.toString());
            System.out.println(suv.toString());
            System.out.println(suv1.toString());
            System.out.println(limousine.toString());
            System.out.println(limousine1.toString());

  
            System.out.println("enter a taxi id: ");
            continueInput = true;
        do {
        try
        {
    
             chosenId = scan.nextInt();
            while (chosenId > 6 || chosenId < 1)
            {
                System.out.println("enter a taxi id: ");
                chosenId = scan.nextInt();
            }
                    continueInput = false;
}
        catch (Exception ex)
        {
            System.out.println("Incorrect input: an integer is required");scan.nextLine();
            } }while (continueInput);            
            switch(chosenId)
            {
                case 1:                    
                    if (sedan.getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        sedan.setIsAvailable(false);
                        userCredentials.setPaidTaxiId(1);
                        userCredentials.setTotalPrice(sedan.getTotalFee());
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;
                case 2:                    
                    if (sedan1.getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        sedan1.setIsAvailable(false);
                        userCredentials.setPaidTaxiId(2);
                        userCredentials.setTotalPrice(sedan1.getTotalFee());
                        
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;
                case 3:                    
                    if (suv.getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        suv.setIsAvailable(false);
                        userCredentials.setPaidTaxiId(3);
                        userCredentials.setTotalPrice(suv.getTotalFee());
                        
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;
                case 4:                    
                    if (suv1.getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        suv1.setIsAvailable(false);
                        userCredentials.setPaidTaxiId(4);
                        userCredentials.setTotalPrice(suv1.getTotalFee());
                        
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;
                case 5:                    
                    if (limousine.getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        limousine.setIsAvailable(false);
                        userCredentials.setPaidTaxiId(5);
                        userCredentials.setTotalPrice(limousine.getTotalFee());
                        
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;
                case 6:                    
                    if (limousine1.getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        limousine1.setIsAvailable(false);
                        userCredentials.setPaidTaxiId(6);
                        userCredentials.setTotalPrice(limousine1.getTotalFee());
                        
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;
            }

            System.out.println("Total fee is: " + userCredentials.getTotalPrice());
            System.out.println("Enter credit card details:");
            System.out.println("First Name: ");
            String userName = scan.next();
            System.out.println("\nCard Num: ");
            String cardNo = scan.next();

            
            System.out.println("\nExpiry: ");
            String expiry = scan.next();
            do
            {
                try
                {
                    continueInput = true;
                
                    System.out.println("\nCCV: ");
                    int ccv = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                }
            }while (continueInput);


            System.out.println("\n\nPayment success.\nYou have been logged out.");

            System.out.println("\n\nfor admin to verify details");

                        adminCredentials.register();
            adminCredentials.login();
            
            int adminOption = 1;
            while (adminOption !=4)
            {
            do
            {
                try
                {
                    continueInput = true;
             System.out.println("\n\nAdmin options\n1. Status report\n2. View all payments\n3. Maintenance\n4. logout");
            adminOption = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);          
            switch (adminOption)
            {
                case 1:
            System.out.println("\n\ntaxiId  isAvailable  totalFee  departTime      departDate  seatType  noSeats");
            System.out.println(sedan.toString());
            System.out.println(sedan1.toString());
            System.out.println(suv.toString());
            System.out.println(suv1.toString());
            System.out.println(limousine.toString());
            System.out.println(limousine1.toString());

                
                break;

                case 2:
                System.out.println("\n\nEmail                      TaxiId");//3 ltr @gmail.com
                System.out.println(userCredentials.getEmail() + "               " + userCredentials.getPaidTaxiId());
                break;

                case 3:
            System.out.println("\n\ntaxiId  isAvailable  totalFee  departTime      departDate  seatType  noSeats");
            System.out.println(sedan.toString());
            System.out.println(sedan1.toString());
            System.out.println(suv.toString());
            System.out.println(suv1.toString());
            System.out.println(limousine.toString());
            System.out.println(limousine1.toString());

            do
            {
                try
                {
                    continueInput = true;
            System.out.println("\n\nto edit:\nenter a taxi id: ");
            chosenId = scan.nextInt();
            while (chosenId > 6 || chosenId < 1)
            {
                System.out.println("enter a taxi id: ");
                chosenId = scan.nextInt();
            }
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);

String[] attribute = {"noSeats", "seatType", "departDate", "departTime", "totalFee", "isAvailable"};

System.out.println("     attribute    id");
                for (int i=0; i<6; i++)
                {
                    System.out.println(String.format("%14s %4d",attribute[i],i));
                }
int attrid=1;
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter attribute id to edit: ");
                attrid = scan.nextInt();

                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);

                int newNoSeats=1;                 double newTotalFee=1.;
               boolean newIsAvailable=true;

                                
            switch(chosenId)
            {
                case 1:                    
            switch(attrid)
            {
                case 0:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                sedan.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                sedan.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                sedan.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan.setIsAvailable(newIsAvailable);
                break;
            }                

                
                
                    break;
                case 2:                    
            switch(attrid)
            {
                case 0:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan1.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                sedan1.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                sedan1.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                sedan1.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan1.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan1.setIsAvailable(newIsAvailable);
                break;
            }                
                    break;
                case 3:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                suv.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                suv.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                suv.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                suv.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                suv.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                suv.setIsAvailable(newIsAvailable);
                break;
            }                
                    break;
                case 4:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                suv1.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                suv1.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                suv1.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                suv1.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                suv1.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                suv1.setIsAvailable(newIsAvailable);
                break;
            }                
                    break;
                
                case 5:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                limousine.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                limousine.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                limousine.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine.setIsAvailable(newIsAvailable);
                break;
            }                
                 break;

                case 6:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine1.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                limousine1.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                limousine1.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                limousine1.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine1.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine1.setIsAvailable(newIsAvailable);
                break;
            }

                break;

            }}
                
        }

            
           
        }
        else
        {
                        adminCredentials.register();
            adminCredentials.login();
            
            int adminOption = 1;
            while (adminOption !=4)
            {
            do
            {
                try
                {
                    continueInput = true;
             System.out.println("\n\nAdmin options\n1. Status report\n2. View all payments\n3. Maintenance\n4. logout");
            adminOption = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }     while (continueInput);          
            switch (adminOption)
            {
                case 1:
            System.out.println("\n\ntaxiId  isAvailable  totalFee  departTime      departDate  seatType  noSeats");
            System.out.println(sedan.toString());
            System.out.println(sedan1.toString());
            System.out.println(suv.toString());
            System.out.println(suv1.toString());
            System.out.println(limousine.toString());
            System.out.println(limousine1.toString());

                
                break;

                case 2:
                System.out.println("\n\nEmail                      TaxiId");//3 ltr @gmail.com
                System.out.println(userCredentials.getEmail() + "               " + userCredentials.getPaidTaxiId());
                break;

                case 3:
            System.out.println("\n\ntaxiId  isAvailable  totalFee  departTime      departDate  seatType  noSeats");
            System.out.println(sedan.toString());
            System.out.println(sedan1.toString());
            System.out.println(suv.toString());
            System.out.println(suv1.toString());
            System.out.println(limousine.toString());
            System.out.println(limousine1.toString());

            do
            {
                try
                {
                    continueInput = true;
            System.out.println("\n\nto edit:\nenter a taxi id: ");
            chosenId = scan.nextInt();
            while (chosenId > 6 || chosenId < 1)
            {
                System.out.println("enter a taxi id: ");
                chosenId = scan.nextInt();
            }
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);

String[] attribute = {"noSeats", "seatType", "departDate", "departTime", "totalFee", "isAvailable"};

System.out.println("     attribute    id");
                for (int i=0; i<6; i++)
                {
                    System.out.println(String.format("%14s %4d",attribute[i],i));
                }
int attrid=1;
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter attribute id to edit: ");
                attrid = scan.nextInt();

                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);

                int newNoSeats=1;                 double newTotalFee=1.;
               boolean newIsAvailable=true;

                                
            switch(chosenId)
            {
                case 1:                    
            switch(attrid)
            {
                case 0:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                sedan.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                sedan.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                sedan.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan.setIsAvailable(newIsAvailable);
                break;
            }                

                
                
                    break;
                case 2:                    
            switch(attrid)
            {
                case 0:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan1.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                sedan1.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                sedan1.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                sedan1.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan1.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                sedan1.setIsAvailable(newIsAvailable);
                break;
            }                
                    break;
                case 3:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                suv.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                suv.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                suv.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                suv.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                suv.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                suv.setIsAvailable(newIsAvailable);
                break;
            }                
                    break;
                case 4:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                suv1.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                suv1.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                suv1.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                suv1.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                suv1.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                suv1.setIsAvailable(newIsAvailable);
                break;
            }                
                    break;
                
                case 5:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                limousine.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                limousine.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                limousine.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine.setIsAvailable(newIsAvailable);
                break;
            }                
                 break;

                case 6:                    
            switch(attrid)
            {
                case 0:
                do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                newNoSeats = scan.nextInt();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an integer is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine1.setNoSeats(newNoSeats);
                break;

                case 1:
                System.out.println("enter new value: ");
                String newSeatType = scan.next();
                limousine1.setSeatType(newSeatType);
                break;

                
                case 2:
                System.out.println("enter new value: ");
                String newDepartDate = scan.next();
                limousine1.setDepartDate(newDepartDate);
                break;
                

                case 3:
                System.out.println("enter new value: ");
                String newDepartTime = scan.next();
                limousine1.setDepartTime(newDepartTime);
                break;
                

                case 4:
            do
            {
                try
                {
                    continueInput = true;
                    System.out.println("\ntotal fee: ");
                System.out.println("enter new value: ");
                newTotalFee = scan.nextDouble();continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an double is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine1.setTotalFee(newTotalFee);
                break;
                

                case 5:
            do
            {
                try
                {
                    continueInput = true;
                System.out.println("enter new value: ");
                 newIsAvailable = scan.nextBoolean();
                    continueInput = false;
                }
                catch (Exception ex)
                {
                    System.out.println("Incorrect input: an boolean is required");scan.nextLine();
                } 
            }while (continueInput);
                limousine1.setIsAvailable(newIsAvailable);
                break;
            }

                break;

            }}
                
        }

            
         
    }

}}        
/*

admin
3. print admin menu
 a. view sta rpt
 b. view all payments
 c. maintenance
 d. logout


            switch (wantBookTaxiType)
            {
                case "sedan":
                    if (sedanArr.get(wantBookTaxiIndex).getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        sedanArr.get(wantBookTaxiIndex).setIsAvailable(false);
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;

                case "suv":
                    if (suvArr.get(wantBookTaxiIndex).getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        suvArr.get(wantBookTaxiIndex).setIsAvailable(false);
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;

                case "limousine":
                    if (limousineArr.get(wantBookTaxiIndex).getIsAvailable())
                    {
                        System.out.println("taxi successfully selected.");
                        limousineArr.get(wantBookTaxiIndex).setIsAvailable(false);
                    }
                    else
                    {
                        System.out.println("taxi unavailable");
                    }
                    break;
            }


         interf
          ^
          |
seat  a  TAXI  c   time
          ^
         poly

noSeats
    seatType
    departTimestamp
    totalFee
    isAvailable
    taxiId
*/
