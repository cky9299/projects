package cred;
import cred.*;

public class SUV extends Taxi
{
    public SUV(int _taxiId, boolean _isAvailable, String _departDate, String _departTime, String _seatType, int _noSeats)
    {
        this.taxiId = _taxiId;
        this.isAvailable = _isAvailable;
        this.time.departTime = _departTime;
        this.time.departDate = _departDate;
        this.seat.seatType = _seatType;
        this.seat.noSeats = _noSeats;
    }
    
    public double calculateTotalFee(double distance, double taxiFee)
    {
        return distance*taxiFee + taxiFee*2;
    }

    public String toString()
    {
        return super.toString();
    }
    
    public boolean equals (Object o)
    {
        if (o instanceof Taxi) {
            return taxiId == ((Taxi)o).taxiId;
        }
        else
            return false;
    }
}
