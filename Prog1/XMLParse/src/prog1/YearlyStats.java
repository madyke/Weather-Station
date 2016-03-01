/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

/**
 * A class to track yearly statistics of weather data.
 * 
 * @author Matt Dyke
 */
public class YearlyStats extends WeatherStats
{
    public int year;
    
    /**
     * Constructor of YearlyStats object.
     */
    public YearlyStats()
    {
        //Call parent constructor
        super();
        
        //Initialize year to zero
        this.year   = 0;
    }
    
    /**
     * This method prints the yearly statistics for a dataset.
     */
    @Override
    public void PrintStats()
    {
        System.out.println( "\nYEARLY : " + year );
        super.PrintStats();
    }
}
