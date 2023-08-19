package cred;

public class Seat
{
    String seatType;
    int noSeats;

    public Seat()
    {
        noSeats=0;
        seatType="";
    }
    
    public String toString()
    {
        
        return String.format("%-10s %-9d", seatType, noSeats);
    }
}
