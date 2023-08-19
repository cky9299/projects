package cred;

public class Time
{
    String departTime;
    String departDate;

    public Time()
    {
        departDate="";
        departTime="";
    }

    public String toString()
    {
        //%s refers to a string data type, %f refers to a float data type, and %d refers to a integer data type.
        //return String.format("%-10s %-8d %s", plateno, year, cartype.toString());
        
        return String.format("%-12s %-12s", departTime, departDate);
    }
}
