/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

/**
 *
 * @author 7025592
 */
public class YearlyStats extends WeatherStats
{
    public int year;
    
    public YearlyStats()
    {
        //Call parent constructor
        super();
        
        //Initialize year to zero
        this.year   = 0;
    }
    
    @Override
    public void PrintStats()
    {
        System.out.println( "\nYEARLY : " + year );
        super.PrintStats();
    }
}
