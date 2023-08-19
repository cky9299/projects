package cred;
public interface TaxiInterface
{
    public double calculateTotalFee(double distance, double taxiFee);
    
    public void setTaxiId(int _taxiId);
    public void setIsAvailable(boolean _isAvailable);
    public void setTotalFee(double _totalFee);
    public void setDepartTime(String _departTime);
    public void setDepartDate(String _departDate);
    public void setSeatType(String _seatType);
    public void setNoSeats(int _noSeats);

    public int getTaxiId();
    public boolean getIsAvailable();
    public double getTotalFee();
    public String getDepartTime();
    public String getDepartDate();
    public String getSeatType();
    public int getNoSeats();
    public String toString();
    public boolean equals(Object obj);
}


