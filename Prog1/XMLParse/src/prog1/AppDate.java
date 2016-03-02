/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

/**
 * A date class for use in Java applications.
 * 
 * @author Charles Parsons, based in part from MyDate.java by Dr. John Weiss
 */
public class AppDate {
    
    private int month;
    private int day;
    private int year;
    
    /**
     * A no argument constructor for the AppDate class.
     */
    public AppDate()
    {
        this(1, 1, 2010);
    }
    
    /**
     * A standard constructor for the AppDate class that requires a month, day,
     * and year in order to create an AppDate object.
     * 
     * @param m month
     * @param d day
     * @param y year
     */
    public AppDate(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }
    
    /**
     * This method allows for use of the equality operator "==" on AppDate class
     * objects. It returns true if the month, day, and year of both objects
     * match. It returns false otherwise.
     * 
     * @param rhs the right hand side argument.
     * @return true if the dates are equal
     * @return false if the dates are not equal
     */
    public boolean equals(AppDate rhs)
    {
        if(rhs.month == month && rhs.day == day && rhs.year == year)
        {
            return true;
        }
        return false;
    }
    
    /**
     * This method allows for use of the less than operator on AppDate class
     * objects. It returns true if the AppDate object on the left hand side
     * of the operator came before that on the right hand side. It returns false
     * otherwise.
     * 
     * @param rhs the right hand side argument.
     * @return true if the date on the right hand side came after the date on 
     * the left hand side.
     * @return false if the date on the right hand side came before the date on
     * the left hand side.
     */
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
    
    /**
     * This method converts an AppDate object into a String class object. This
     * is used for output.
     * 
     * @return s The string representation of the AppDate object.
     */
    public String toString()
    {
        //use a format string to convert an AppDate into a String.
        String s = String.format("%d/%d/%d", month, day, year);
        return s;
    }
    
    /**
     * This method returns the value of the month private variable in an AppDate
     * object.
     * 
     * @return month The month value of the date.
     */
    public int getMonth()
    {
        return month;
    }
    
    /**
     * This method returns the value of the day private variable in an AppDate
     * object.
     * 
     * @return day The day value of the date.
     */
    public int getDay()
    {
        return day;
    }
    
    /**
     * This method returns the value of the year private variable in an AppDate
     * object.
     * 
     * @return year The month year of the date.
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * This method sets the value of the month private variable in an AppDate
     * object.
     * 
     * @param m The month value for the date.
     */
    public void setMonth(int m)
    {
        month = m;
    }
    
    /**
     * This method sets the value of the day private variable in an AppDate
     * object.
     * 
     * @param d The day value for the date.
     */
    public void setDay(int d)
    {
        day = d;
    }
    
    /**
     * This method sets the value of the year private variable in an AppDate
     * object.
     * 
     * @param y The year value for the date.
     */
    public void setYear(int y)
    {
        year = y;
    }
}
