/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

/**
 * The base class for all derived (monthly, daily, yearly) statistics classes.
 * Used to track average temp, humidity, barometric pressure, wind speed, UV
 * index, and rain fall, as well as max high temperature, min low temperature,
 * max wind gust, and prevailing wind direction.
 *
 * @author Matt Dyke
 */
public class WeatherStats
{
    public double highTemp;
    public int    highTempYear;
    public int    highTempMonth;
    public int    highTempDay;
    public int    highTempHour;
    public int    highTempMinute;
    public double lowTemp;
    public int    lowTempYear;
    public int    lowTempMonth;
    public int    lowTempDay;
    public int    lowTempHour;
    public int    lowTempMinute;
    public double avgTemp;
    public double avgHumidity;
    public double avgBarometer;
    public double avgWindSpeed;
    public double windDirection;
    public String prevailingWindDirection;
    public double windGust;
    public int    windGustYear;
    public int    windGustMonth;
    public int    windGustDay;
    public int    windGustHour;
    public int    windGustMinute;
    public double avgWindChill;
    public double avgHeatIndex;
    public double avgUVIndex;
    public double totalRainFall;
    public double avgRainFall;
    
    private double totalTemp;
    private int numTempReadings;
    private double totalHumidity;
    private int numHumidityReadings;
    private double totalBarometer;
    private int numBarometerReadings;
    private double totalWindSpeed;
    private int numWindSpeedReadings;
    private double totalWindChill;
    private int numWindChillReadings;
    private double totalHeatIndex;
    private int numHeatIndexReadings;
    private double totalUVIndex;
    private int numUVIndexReadings;
    private int numRainFallReadings;
    private int INVALID_DATA = -10000;
    
    /**
     * Constructor for the WeatherStats object. Sets all initial values in the
     * data fields.
     */
    public WeatherStats()
    {
        //Initialize variables
        this.highTemp       = -10000;
        this.lowTemp        = 10000;
        this.avgTemp        = 0;
        this.avgHumidity    = 0;
        this.avgBarometer   = 0;
        this.avgWindSpeed   = 0;
        this.windDirection  = 0;
        this.prevailingWindDirection = "";
        this.windGust       = 0;
        this.avgWindChill   = 0;
        this.avgHeatIndex   = 0;
        this.avgUVIndex     = 0;
        this.totalRainFall  = 0;
        this.avgRainFall    = 0;

        this.totalTemp              = 0;
        this.numTempReadings        = 0;
        this.totalHumidity          = 0;
        this.numHumidityReadings    = 0;
        this.totalBarometer         = 0;
        this.numBarometerReadings   = 0;
        this.totalWindSpeed         = 0;
        this.numWindSpeedReadings   = 0;
        this.totalWindChill         = 0;
        this.numWindChillReadings   = 0;
        this.totalHeatIndex         = 0;
        this.numHeatIndexReadings   = 0;
        this.totalUVIndex           = 0;
        this.numUVIndexReadings     = 0;
        this.numRainFallReadings    = 0;
        
        this.INVALID_DATA           = -10000;
    }
    
    /**
     * This method adds the data from an individual reading to the running 
     * totals used for calculating averages and tracking max/min values.
     * 
     * @param currReading An individual data reading from the weather station.
     */
    public void AddToRunningTotals( WeatherReading currReading )
    {
        //If temperature not invalid
        if( currReading.temperature != INVALID_DATA )
        {
            //Add temperature to running total and increment count
            this.totalTemp += currReading.temperature;
            this.numTempReadings++;
            
            //Check if current temperature is bigger than curr max
            if( currReading.temperature > this.highTemp )
            {
                this.highTemp = currReading.temperature;
                this.highTempHour = currReading.hour;
                this.highTempMinute = currReading.minute;
                this.highTempYear = currReading.year;
                this.highTempMonth = currReading.month;
                this.highTempDay = currReading.day;
            }
            //Check if current temperature is smaller than curr min
            if( currReading.temperature < this.lowTemp )
            {
                this.lowTemp = currReading.temperature;  
                this.lowTempHour = currReading.hour;
                this.lowTempMinute = currReading.minute; 
                this.lowTempYear = currReading.year;
                this.lowTempMonth = currReading.month;
                this.lowTempDay = currReading.day;         
            }
        }
        
        //If humidity not invalid
        if( currReading.humidity != INVALID_DATA )
        {
            //Add humidity to running total and increment count
            this.totalHumidity += currReading.humidity;
            this.numHumidityReadings++;
        }
        
        //If barometer not invalid
        if( currReading.barometer != INVALID_DATA )
        {
            //Add barometer to running total and increment count
            this.totalBarometer += currReading.barometer;
            this.numBarometerReadings++;
        }
        
        //If wind speed not invalid
        if( currReading.windSpeed != INVALID_DATA )
        {
            //Add wind speed to running total and increment count
            this.totalWindSpeed += currReading.windSpeed;
            this.numWindSpeedReadings++;
        }
        
        //If wind speed not invalid
        if( currReading.windSpeed != INVALID_DATA )
        {
            //Add wind speed to running total and increment count
            this.totalWindSpeed += currReading.windSpeed;
            this.numWindSpeedReadings++;
        }
        
        //If wind gust not invalid
        if( currReading.windGust != INVALID_DATA )
        {
            //Check if current wind gust bigger than max wind gust
            if( currReading.windGust > this.windGust )
            {
                this.windGust = currReading.windGust;
                this.prevailingWindDirection = currReading.windDirection;
                this.windGustHour = currReading.hour;
                this.windGustMinute = currReading.minute; 
                this.windGustYear = currReading.year;
                this.windGustMonth = currReading.month;
                this.windGustDay = currReading.day; 
                
            }
        }
        
        //If heat index not invalid
        if( currReading.heatIndex != INVALID_DATA )
        {
            //Add heat index to running total and increment count
            this.totalHeatIndex += currReading.heatIndex;
            this.numHeatIndexReadings++;
        }
        
        //If UV Index not invalid
        if( currReading.uvIndex != INVALID_DATA )
        {
            //Add UV Index to running total and increment count
            this.totalUVIndex += currReading.uvIndex;
            this.numUVIndexReadings++;
        }
        
        //If rain fall not invalid
        if( currReading.rainFall != INVALID_DATA )
        {
            //Add rain fall to running total and increment count
            this.totalRainFall += currReading.rainFall;
            this.numRainFallReadings++;
        }
    }
    
    /**
     * This method calculates the averages for different data.
     */
    public void CalculateAverages()
    {
        //Check for division by zero
        if( numTempReadings != 0 )
        {
            avgTemp = totalTemp / numTempReadings;
        }
        
        //Check for division by zero
        if( numHumidityReadings != 0 )
        {
            avgHumidity = totalHumidity / numHumidityReadings;
        }
        
        //Check for division by zero
        if( numBarometerReadings != 0 )
        {
            avgBarometer = totalBarometer / numBarometerReadings;
        }
        
        //Check for division by zero
        if( numWindSpeedReadings != 0 )
        {
            avgWindSpeed = totalWindSpeed / numWindSpeedReadings;
        }
        
        //Check for division by zero
        if( numWindChillReadings != 0 )
        {
            avgWindChill = totalWindChill / numWindChillReadings;
        }
        
        //Check for division by zero
        if( numHeatIndexReadings != 0 )
        {
            avgHeatIndex = totalHeatIndex / numHeatIndexReadings;
        }
        
        //Check for division by zero
        if( numUVIndexReadings != 0 )
        {
            avgUVIndex = totalUVIndex / numUVIndexReadings;
        }
        
        //Check for division by zero
        if( numRainFallReadings != 0 )
        {
            avgRainFall = totalRainFall / numRainFallReadings;
        }
    }
    
    /**
     * This method outputs the statistics that have been calculated for a given
     * dataset.
     */
    public void PrintStats()
    {
        System.out.println( "High Temp : " + this.highTemp );
        System.out.println( "Low Temp : " + this.lowTemp );
        System.out.println( "Avg Temp : " + this.avgTemp );
        System.out.println( "Avg Humidity : " + this.avgHumidity );
        System.out.println( "Avg Barometer : " + this.avgBarometer );
        System.out.println( "Avg Wind Speed : " + this.avgWindSpeed );
        System.out.println( "Wind Gust: " + this.windGust );
        System.out.println( "Avg Wind Chill: " + this.avgWindChill );
        System.out.println( "Avg Heat Index: " + this.avgHeatIndex );
        System.out.println( "Avg UV Index: " + this.avgUVIndex );
        System.out.println( "Total Rainfall :" + this.totalRainFall );
        System.out.println( "Avg Rainfall : " + this.avgRainFall );
    }
}
