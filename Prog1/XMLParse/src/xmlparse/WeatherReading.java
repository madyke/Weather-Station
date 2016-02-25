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

        //Read in remaining fields from XML file
        this.time = node.getChildText( "time" );
        this.temperature = Double.parseDouble( node.getChildText( "temperature" ) );
        this.humidity = Double.parseDouble( node.getChildText( "humidity" ) );
        this.barometer = Double.parseDouble( node.getChildText( "barometer" ) );
        this.windSpeed = Double.parseDouble( node.getChildText( "windspeed" ) );
        this.windDirection = node.getChildText( "winddirection" );
        this.windGust = Double.parseDouble( node.getChildText( "windgust" ) );
        this.windChill = Double.parseDouble( node.getChildText( "windchill" ) );
        this.heatIndex = Double.parseDouble( node.getChildText( "heatindex" ) );
        this.uvIndex = Double.parseDouble( node.getChildText( "uvindex" ) );
        this.rainFall = Double.parseDouble( node.getChildText( "rainfall" ) );
    }
    
    public void PrintData()
    {
        System.out.println( this. day + "/" + this.month + "/" + this.year );
        System.out.println( this.time );
        System.out.println( this. temperature );
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
