package cred;
import java.util.regex.*;
import java.util.Scanner;
public abstract class Credentials
{
    protected String email;
    protected String password;

    protected Credentials()
    {
        this.email="";
        this.password="";
    }

    public void setEmail(String _email)
    {
        email=_email;
    }

    public void setPassword(String _password)
    {
        password=_password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String toString()
    {
        return "email is "+email+"\npassword is "+password;
    }

    public boolean equals (Object obj)
    {
        return (this == obj);
    }
    
    public abstract void register();

    public void login()
    {
        System.out.println("\n\nLogin\nEnter email: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.nextLine().equals(this.email))
        {
            System.out.println("Invalid email. Please try again.");
        }

        System.out.println("Enter password: ");
        while (!scan.nextLine().equals(this.password))
        {
            System.out.println("Invalid password. Please try again.");
        }

        System.out.println("Login success"); 
    }
        
    public static void main(String[] args)
    {
    }
}
