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
public class MonthlyStats extends WeatherStats
{
    public int month;
    public int year;
    
    public MonthlyStats()
    {
        //Call parent constructor
        super();
        
        //Initialize month to 0
        this.month  = 0;
        this.year   = 0;
    }
    
    @Override
    public void PrintStats()
    {
        System.out.println( "\nMONTHLY : " + month + "/" + year );
        super.PrintStats();
    }
}
