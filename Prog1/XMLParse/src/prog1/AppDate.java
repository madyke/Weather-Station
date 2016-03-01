/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

/**
 *
 * @author cparsons
 */
public class AppDate {
    
    private int month;
    private int day;
    private int year;
    
    public AppDate()
    {
        this(1, 10, 2015);
    }
    
    public AppDate(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }
    
    public boolean equals(AppDate rhs)
    {
        if(rhs.month == month && rhs.day == day && rhs.year == year)
        {
            return true;
        }
        return false;
    }
    
    public boolean lessThan(AppDate rhs)
    {
        //both within the same year
        if(year == rhs.year && month < rhs.month)
        {
            return true;
        }
        else if(year == rhs.year && month == rhs.month && day < rhs.day)
        {
            return true;
        }
        //lhs in previous year than rhs
        else if(year < rhs.year)
        {
            return true;
        }
        //otherwise
        return false;
    }
    
    public String toString()
    {
        //use a format string to convert an AppDate into a String.
        String s = String.format("%d/%d/%d", month, day, year);
        return s;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public void setMonth(int m)
    {
        month = m;
    }
    
    public void setDay(int d)
    {
        day = d;
    }
    
    public void setYear(int y)
    {
        year = y;
    }
}
