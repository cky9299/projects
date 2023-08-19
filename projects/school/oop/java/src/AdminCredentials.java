package cred;
import java.util.Scanner;

import cred.Credentials;

public class AdminCredentials extends Credentials
{

    public void register()
    {
        System.out.println("Enter email with domain name as admin.taxi: ");
        Scanner scan = new Scanner(System.in);
        this.email = scan.nextLine();
        while (!this.email.matches("\\b[A-Za-z0-9._%+-]+@admin\\.taxi\\b"))
        {
            System.out.println("Invalid admin email. Please try again.");
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
        return super.toString();
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof AdminCredentials) {return super.equals(obj);}
        else {return false;}
    }
}
