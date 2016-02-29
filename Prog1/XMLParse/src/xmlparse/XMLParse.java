/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparse;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author 7025592
 */
public abstract class XMLParse
{
    public static ArrayList<YearlyStats> yearlyAverages = new ArrayList<>();
    public static ArrayList<MonthlyStats> monthlyAverages = new ArrayList<>();
    public static ArrayList<DailyStats> dailyAverages = new ArrayList<>();
    public static ArrayList<ArrayList<WeatherReading>> weatherReadings = new ArrayList<>();
    
    public static void parseFile( String fileName )
    {
        //Set-up for XML parsing
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( fileName );
        
        //Initialize classes for current year and month
        YearlyStats currYearStats = new YearlyStats();
        MonthlyStats currMonthStats = new MonthlyStats();
        
        try
        {
            //Create new document object from XML file
            Document document = (Document) builder.build(xmlFile);
            
            //Get root node and children from XML file
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("weather");
            
            //Initialize classes for current day
            int currDay = -1;
            ArrayList<WeatherReading> currDayReadings = new ArrayList<WeatherReading>();
            DailyStats currDayStats = new DailyStats();
            
            //Loop over each weather reading
            for (int i = 0; i < list.size(); i++)
            {
                //Get current child
                Element node = (Element) list.get(i);

                //Create object to help with reading in
                WeatherReading currReading = new WeatherReading();

                //Read in data
                currReading.ReadData( node, currDayStats , currMonthStats, currYearStats );
                
                //If current reading from a new day (and not first reading)
                if( currReading.day != currDay && i != 0 )
                {
                    //Add previous day's readings to list of all readings
                    weatherReadings.add( currDayReadings );
                    
                    //Calculate daily averages and add to list of daily averages
                    currDayStats.CalculateAverages();
                    dailyAverages.add( currDayStats );
                    
                    //Create new array for new day
                    currDayReadings = new ArrayList<WeatherReading>();
                    
                    //Create new daily stats object for new day
                    currDayStats = new DailyStats();
                }
                //Else current reading from same day as previous
                {
                    //Add new readings to running totals for daily, monthly, yearly stats
                    currDayStats.AddToRunningTotals( currReading );
                    currMonthStats.AddToRunningTotals( currReading );
                    currYearStats.AddToRunningTotals( currReading );

                    currDayStats.day = currReading.day;
                    currDayStats.month = currReading.month;
                    currDayStats.year = currReading.year;
                    currMonthStats.month = currReading.month;
                    currMonthStats.year = currReading.year;
                    currYearStats.year = currReading.year;
                }
                
                //Save which day was just read from
                currDay = currReading.day;
                
                //Add current reading to list of today's readings
                currDayReadings.add( currReading );
            }
            
            //Add previous day's readings to list of all readings
            weatherReadings.add( currDayReadings );

            //Calculate daily averages and add to list of daily averages
            currDayStats.CalculateAverages();
            dailyAverages.add( currDayStats );
            
            //Calculate monthly stats and add to list of monthly averages
            currMonthStats.CalculateAverages();
            monthlyAverages.add( currMonthStats );
            
            //Calculate yearly stats and add to list of yearly averages
            currYearStats.CalculateAverages();
            yearlyAverages.add( currYearStats );
            
	}
        catch (IOException io)
        {
            System.out.println(io.getMessage());
        }
        catch (JDOMException jdomex) 
        {
            System.out.println(jdomex.getMessage());
        }
    }
}
