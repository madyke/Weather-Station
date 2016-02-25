/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlparse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


/**
 *
 * @author 7025592
 */
public class WeatherReading
{
    public int day;
    public int month;
    public int year;
    public String time;
    public double temperature;
    public double humidity;
    public double barometer;
    public double windSpeed;
    public String windDirection;
    public double windGust;
    public double windChill;
    public double heatIndex;
    public double uvIndex;
    public double rainFall;
    
    public void ReadData( Element node )
    {
        //Get date from current reading
        String date = node.getChildText( "date" );
        if( date != null )
        {
            date = date.trim();
        }
        int firstSlash = date.indexOf( "/" );
        int secondSlash = date.lastIndexOf( "/" );
        this.day = Integer.parseInt( date.substring( 0, firstSlash ) );
        this.month = Integer.parseInt( date.substring( firstSlash + 1, secondSlash ) );
        this.year = Integer.parseInt( date.substring( secondSlash + 1 ) );       

        //Read in time of reading
        this.time = node.getChildText( "time" );
        
        //Attempt to read in temperature value
        try
        {
            this.temperature = Double.parseDouble( node.getChildText( "temperature" ) );        
        }
        catch( Exception e)
        {
            //If failure, set temperature to invalid number
            this.temperature = -10000;
        }
        
        //Attempt to read in humidity value
        try
        {
            this.humidity = Double.parseDouble( node.getChildText( "humidity" ) );        
        }
        catch( Exception e)
        {
            //If failure, set humidity to invalid number
            this.humidity = -10000;
        }
        
        //Attempt to read in barometer value
        try
        {
            this.barometer = Double.parseDouble( node.getChildText( "barometer" ) );        
        }
        catch( Exception e)
        {
            //If failure, set barometer to invalid number
            this.barometer = -10000;
        }
        
        //Attempt to read in windSpeed value
        try
        {
            this.windSpeed = Double.parseDouble( node.getChildText( "windSpeed" ) );        
        }
        catch( Exception e)
        {
            //If failure, set windSpeed to invalid number
            this.windSpeed = -10000;
        }
        
        //Attempt to read in windDirection value
        try
        {
            this.windDirection = node.getChildText( "windDirection" ).trim();        
        }
        catch( Exception e)
        {
            //If failure, set windDirection to invalid number
            this.windDirection = "";
        }
        
        //Attempt to read in windGust value
        try
        {
            this.windGust = Double.parseDouble( node.getChildText( "windGust" ) );        
        }
        catch( Exception e)
        {
            //If failure, set windGust to invalid number
            this.windGust = -10000;
        }
        
        //Attempt to read in windChill value
        try
        {
            this.windChill = Double.parseDouble( node.getChildText( "windChill" ) );        
        }
        catch( Exception e)
        {
            //If failure, set windChill to invalid number
            this.windChill = -10000;
        }
        
        //Attempt to read in heatIndex value
        try
        {
            this.heatIndex = Double.parseDouble( node.getChildText( "heatIndex" ) );        
        }
        catch( Exception e)
        {
            //If failure, set heatIndex to invalid number
            this.heatIndex = -10000;
        }
        
        //Attempt to read in uvIndex value
        try
        {
            this.uvIndex = Double.parseDouble( node.getChildText( "uvIndex" ) );        
        }
        catch( Exception e)
        {
            //If failure, set uvIndex to invalid number
            this.uvIndex = -10000;
        }
        
        //Attempt to read in rainFall value
        try
        {
            this.rainFall = Double.parseDouble( node.getChildText( "rainFall" ) );        
        }
        catch( Exception e)
        {
            //If failure, set rainFall to invalid number
            this.rainFall = -10000;
        }
        
        
        //Add new readings to running totals for daily, monthly, yearly stats
        
    }
    
    public void PrintData()
    {
        System.out.println( this.day + "/" + this.month + "/" + this.year );
        System.out.println( this.time );
        System.out.println( this.temperature );
        System.out.println( this.humidity );
        System.out.println( this.barometer );
        System.out.println( this.windSpeed );
        System.out.println( this.windDirection );
        System.out.println( this.windGust );
        System.out.println( this.windChill );
        System.out.println( this.heatIndex );
        System.out.println( this.uvIndex );
        System.out.println( this.rainFall );
    }
}
