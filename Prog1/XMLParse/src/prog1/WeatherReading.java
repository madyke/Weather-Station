/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prog1;

import org.jdom2.Element;


/**
 * This is a class that is used to hold the weather data read in from an XML
 * file.
 *
 * @author Matt Dyke
 */
public class WeatherReading
{
    public int day;
    public int month;
    public int year;
    public String time;
    public int hour;
    public int minute;
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
    
    private int INVALID_DATA;
    
    /**
     * The constructor for a WeatherReading object used to hold data.
     * Initializes all data fields in case of missing values.
     */
    public WeatherReading()
    {
        //Initialize all variables to 0
        this.day    = 0;
        this.month  = 0;
        this.year   = 0;
        this.time   = "";
        this.hour   = 0;
        this.minute = 0;
        this.temperature    = 0;
        this.humidity       = 0;
        this.barometer      = 0;
        this.windSpeed      = 0;
        this.windDirection  = "";
        this.windGust       = 0;
        this.windChill      = 0;
        this.heatIndex      = 0;
        this.uvIndex        = 0;
        this.rainFall       = 0;
        
        //Set invalid data flag
        this.INVALID_DATA   = -10000;
    }
    
    /**
     * This method reads in the data from an intermediate node that was read
     * into from an XML data file. If there are missing data elements then
     * empty values are used.
     * 
     * @param node An XML element tree from a data file.
     * @param currDayStats Stores the daily statistics.
     */
    public void ReadData( Element node, DailyStats currDayStats )
    {
        //Get date from current reading
        String date = node.getChildText( "date" );
        if( date != null )
        {
            date = date.trim();
        }
        int firstSlash = date.indexOf( "/" );
        int secondSlash = date.lastIndexOf( "/" );
        this.month = Integer.parseInt( date.substring( 0, firstSlash ) );
        this.day = Integer.parseInt( date.substring( firstSlash + 1, secondSlash ) );
        this.year = Integer.parseInt( date.substring( secondSlash + 1 ) ) + 2000;       

        //Attempt to read in time value
        try
        {
            this.time = node.getChildText( "time" ).trim(); 
            
            int colon = this.time.indexOf( ":" );
            this.minute = Integer.parseInt( this.time.substring( colon + 1, colon + 3 ) );
            this.hour = Integer.parseInt( this.time.substring( 0, colon ) );
            
            //Adjust for 12 o'clock
            if( this.time.charAt( colon + 3 ) == 'P' && hour != 12 )
                this.hour += 12;
            if( this.time.charAt( colon + 3 ) == 'A' && hour == 12 )
                this.hour -= 12;
        }
        catch( Exception e)
        {
            //If failure, set time to empty string
            this.time = "";
        }
        
        //Attempt to read in temperature value
        try
        {
            this.temperature = Double.parseDouble( node.getChildText( "temperature" ) );        
        }
        catch( Exception e)
        {
            //If failure, set temperature to invalid number
            this.temperature = INVALID_DATA;
        }
        
        //Attempt to read in humidity value
        try
        {
            this.humidity = Double.parseDouble( node.getChildText( "humidity" ) );        
        }
        catch( Exception e)
        {
            //If failure, set humidity to invalid number
            this.humidity = INVALID_DATA;
        }
        
        //Attempt to read in barometer value
        try
        {
            this.barometer = Double.parseDouble( node.getChildText( "barometer" ) );        
        }
        catch( Exception e)
        {
            //If failure, set barometer to invalid number
            this.barometer = INVALID_DATA;
        }
        
        //Attempt to read in windSpeed value
        try
        {
            this.windSpeed = Double.parseDouble( node.getChildText( "windspeed" ) );        
        }
        catch( Exception e)
        {
            //If failure, set windSpeed to invalid number
            this.windSpeed = INVALID_DATA;
        }
        
        //Attempt to read in windDirection value
        try
        {
            this.windDirection = node.getChildText( "winddirection" ).trim();        
        }
        catch( Exception e)
        {
            //If failure, set windDirection to empty string
            this.windDirection = "";
        }
        
        //Attempt to read in windGust value
        try
        {
            this.windGust = Double.parseDouble( node.getChildText( "windgust" ) );        
        }
        catch( Exception e)
        {
            //If failure, set windGust to invalid number
            this.windGust = INVALID_DATA;
        }
        
        //Attempt to read in windChill value
        try
        {
            this.windChill = Double.parseDouble( node.getChildText( "windchill" ) );        
        }
        catch( Exception e)
        {
            //If failure, set windChill to invalid number
            this.windChill = INVALID_DATA;
        }
        
        //Attempt to read in heatIndex value
        try
        {
            this.heatIndex = Double.parseDouble( node.getChildText( "heatindex" ) );        
        }
        catch( Exception e)
        {
            //If failure, set heatIndex to invalid number
            this.heatIndex = INVALID_DATA;
        }
        
        //Attempt to read in uvIndex value
        try
        {
            this.uvIndex = Double.parseDouble( node.getChildText( "uvindex" ) );        
        }
        catch( Exception e)
        {
            //If failure, set uvIndex to invalid number
            this.uvIndex = INVALID_DATA;
        }
        
        //Attempt to read in rainFall value
        try
        {
            this.rainFall = Double.parseDouble( node.getChildText( "rainfall" ) );        
        }
        catch( Exception e)
        {
            //If failure, set rainFall to invalid number
            this.rainFall = INVALID_DATA;
        }
    }
    
    /**
     * This method outputs the data held in a WeatherReading object.
     */
    public void PrintData()
    {
        System.out.println( this.month + "/" + this.day + "/" + this.year );
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
