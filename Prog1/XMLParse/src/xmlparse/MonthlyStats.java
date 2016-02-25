/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparse;

/**
 *
 * @author 7025592
 */
public class MonthlyStats extends WeatherStats
{
    public int month;
    public int year;
    
    @Override
    public void PrintStats()
    {
        System.out.println( "\nMONTHLY : " + month + "/" + year );
        super.PrintStats();
    }
}
