package cred;
import java.util.Scanner;

import cred.Credentials;

public class UserCredentials extends Credentials
{
    private int paidTaxiId;
    private double totalPrice = 0.;
    
    public void setPaidTaxiId(int _paidTaxiId) {this.paidTaxiId = _paidTaxiId;}
    public void setTotalPrice(double _totalPrice) {this.totalPrice = _totalPrice;}

    public int getPaidTaxiId() {return this.paidTaxiId;}
    public double getTotalPrice() {return this.totalPrice;}

    public void register()
    {
        System.out.println("Enter email: ");
        Scanner scan = new Scanner(System.in);
        this.email = scan.nextLine();
        while (!this.email.contains(Character.toString('@')))
        {
            System.out.println("Invalid email. Please try again.");
            this.email = scan.nextLine();            
        }
        System.out.println("Enter password (min 8 char): ");
        this.password = scan.nextLine();
        while (this.password.length()<8)
        {
            System.out.println("Invalid password length. Enter password (min 8 char): ");
            this.password = scan.nextLine();            
        }
        System.out.println("Register success");
    }



    public String toString()
    {
        return super.toString() + "\npaidTaxiId is " + paidTaxiId + "\ntotalPrice is " + totalPrice;
    }


    public boolean equals(Object obj)
    {
        if (obj instanceof AdminCredentials) {return super.equals(obj);}
        else {return false;}
    }
}
