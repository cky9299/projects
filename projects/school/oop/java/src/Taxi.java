package cred;
import cred.TaxiInterface;

public class Taxi implements TaxiInterface
{
    protected int taxiId;
    protected boolean isAvailable;

    protected double totalFee; //distance*taxiFee
    
    protected Time time = new Time();
    protected Seat seat = new Seat();

    public Taxi()
    {
     this.totalFee=0.;
     this.isAvailable=true;
     this.taxiId=0;
    }


    public double calculateTotalFee(double distance, double taxiFee) {return distance*taxiFee;} //cal then disp. polym = same signature but diff method contents

    public void setTaxiId(int _taxiId) {this.taxiId = _taxiId;}
    public void setIsAvailable(boolean _isAvailable) {this.isAvailable = _isAvailable;}
    public void setTotalFee(double _totalFee) {this.totalFee = _totalFee;}
    public void setDepartTime(String _departTime) {this.time.departTime = _departTime;}
    public void setDepartDate(String _departDate) {this.time.departDate = _departDate;}
    public void setSeatType(String _seatType) {this.seat.seatType = _seatType;}
    public void setNoSeats(int _noSeats) {this.seat.noSeats = _noSeats;}//no need obj arr since sedan0.seat.; sedan1.seat. these seats r diff

    public int getTaxiId() {return this.taxiId;}
    public boolean getIsAvailable() {return this.isAvailable;}
    public double getTotalFee() {return this.totalFee;}
    public String getDepartTime() {return this.time.departTime;}
    public String getDepartDate() {return this.time.departDate;}
    public String getSeatType() {return this.seat.seatType;}
    public int getNoSeats() {return this.seat.noSeats;}

    public String toString()
    {
        return String.format("%-8d %-13s %-10.2f %-12s %-10s", this.taxiId, this.isAvailable, this.totalFee, this.time.toString(), this.seat.toString());
    }

    public boolean equals (Object obj)
    {
        return (this == obj);
    }
}
