/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * This class is used to parse the XML data files using the jdom object.
 * 
 * @author Matt Dyke
 */
public abstract class XMLParse
{
    public static ArrayList<YearlyStats> yearlyAverages = new ArrayList<>();
    public static ArrayList<MonthlyStats> monthlyAverages = new ArrayList<>();
    public static ArrayList<DailyStats> dailyAverages = new ArrayList<>();
    public static ArrayList<ArrayList<WeatherReading>> weatherReadings = new ArrayList<>();
    
    private static File[] fileList;

    
    /**
     * This method parses the individual XML data files within a specified
     * directory. The data is stored in the weatherReadings array list. The
     * statistics for that data are stored in the corresponding daily, weekly,
     * monthly, and yearly array lists.
     * 
     * @param dir The directory that the XML data files are in.
     */
    public static void parseFiles( String dir )
    {        
        yearlyAverages = new ArrayList<>();
        monthlyAverages = new ArrayList<>();
        dailyAverages = new ArrayList<>();
        weatherReadings = new ArrayList<>();
        
        int loopYear = -1;  //Year to loop over
        
        //Get the directory whose path is in the string dir

        
        //Get list of files matching required format in current working dir
        getFileList( dir );
        
        //If there was at least one data file, get year from first one
        if( fileList.length != 0 )
        {
            loopYear = Integer.parseInt( fileList[0].getName().substring(  0, 4 ));
        }
        
        //Create new yearly stats object
        YearlyStats currYearStats = new YearlyStats();

        //Loop over each file in the file list
        for( File currFile : fileList )
        {
            //Get year for current data file
            int currYear = Integer.parseInt( currFile.getName().substring( 0, 4 ) );
            
            //If current data file is for a new year
            if( currYear != loopYear )
            {
                //Calculate statistics for year that just finished
                currYearStats.CalculateAverages();
                
                //Add year that just finished to list of yearly averages
                XMLParse.yearlyAverages.add( currYearStats );
                
                //Get new yearly stats object
                currYearStats = new YearlyStats();
                
                //Save new year
                loopYear = currYear;
            }
            
            //Initialize classes for current year and month
            MonthlyStats currMonthStats = new MonthlyStats();
            
            //Parse XML data from current file
            parseFile( currFile, currMonthStats, currYearStats );
            
            //Calculate statistics for month from current file
            currMonthStats.CalculateAverages();

            //Add month from previous file to list of monthly averages
            XMLParse.monthlyAverages.add( currMonthStats );
        }
        
        //Calculate statistics for year that ended with file
        currYearStats.CalculateAverages();

        //Add year that just finished to list of yearly averages
        XMLParse.yearlyAverages.add( currYearStats );
    }
    
    /**
     * This method does the actual parsing of an individual XML data file.
     * 
     * @param xmlFile The XML data file to be parsed.
     * @param currMonthStats Statistics for the month that pertains to the data
     * file.
     * @param currYearStats Statistics for the year that pertains to the data
     * file.
     */
    private static void parseFile( File xmlFile, MonthlyStats currMonthStats, YearlyStats currYearStats )
    {
        //Set-up for XML parsing
        SAXBuilder builder = new SAXBuilder();
        
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
                currReading.ReadData( node, currDayStats );
                
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

                //Add new readings to running totals for daily, monthly, yearly stats
                currDayStats.AddToRunningTotals( currReading );
                currMonthStats.AddToRunningTotals( currReading );
                currYearStats.AddToRunningTotals( currReading );

                //Save when current reading was
                currDayStats.day = currReading.day;
                currDayStats.month = currReading.month;
                currDayStats.year = currReading.year;
                currMonthStats.month = currReading.month;
                currMonthStats.year = currReading.year;
                currYearStats.year = currReading.year;

                
                //Save which day was just read from
                currDay = currReading.day;
                
                //Add current reading to list of today's readings
                currDayReadings.add( currReading );
            }
            
            //Add final day's readings to list of all readings
            weatherReadings.add( currDayReadings );

            //Calculate final daily averages and add to list of daily averages
            currDayStats.CalculateAverages();
            dailyAverages.add( currDayStats );
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
    
    /**
     * This method gets the list of the XML data files using a regular 
     * expression that represents the file naming scheme for those XML files.
     * 
     * @param dirPath The path to the directory in which to search for the XML
     * files.
     */
    private static void getFileList( String dirPath )
    {
        //Regular Expression to match with weather data file names
        Pattern p = Pattern.compile( "\\d{4}-\\d{2}\\.xml" );
        
        //Try to open given directory, make sure it is a directory
        File dir = new File( dirPath );
        if( !dir.isDirectory() )
        {
            throw new IllegalArgumentException( "ERROR: " + dir + " is not a valid directory." );
        }
        
        //Get list of files that match regular expression
        fileList = dir.listFiles(
            new FileFilter()
            {
                @Override
                public boolean accept(File file)
                {
                    return p.matcher(file.getName()).matches();
                }
            }
        );
        Arrays.sort(fileList);
    }
    
    /**
     * This method gets the path to the directory in which the application was
     * run.
     * 
     * @return The path to the directory in which the application was
     * run.
     */
    public static String getWorkingDirectory()
    {
        //Return directory string from where application launched
        return System.getProperty("user.dir");
    }
    
    /**
     * This method gets the daily readings for a specific date.
     * 
     * @param date The date desired.
     * @return day An array list containing all of the readings for a 
     * specified day.
     */
    public static ArrayList<WeatherReading> GetDailyReadings( AppDate date )
    {
        //Create new Arraylist
        ArrayList<WeatherReading> day = new ArrayList<>();
        
        //Get begin and end times
        int beginDay   = date.getDay();
        int beginMonth = date.getMonth();
        int beginYear  = date.getYear();
        
        int i = 0;  //Loop counter
        
        try
        {
            //Get to beginning year
            while( XMLParse.weatherReadings.get( i ).get( 0 ).year < beginYear )
            {
                i++;
            }
            //Get to beginning month
            while( XMLParse.weatherReadings.get( i ).get( 0 ).month < beginMonth )
            {
                i++;
            }
            //Get to beginning day
            while( XMLParse.weatherReadings.get( i ).get( 0 ).day < beginDay )
            {
                i++;
            }
        }
        catch( IndexOutOfBoundsException e )
        {
            //Data did not go up to beginning date return no data
            return day;
        }
        
        return XMLParse.weatherReadings.get( i );
    }
        
    /**
     * This method gets the daily statistics over a date range.
     * 
     * @param begin The starting date of the date range.
     * @param end The ending date of the date range.
     * @return period The array list containing the aggregated daily statistics.
     */
    public static ArrayList<DailyStats> GetDailyAggregatePeriod( AppDate begin, AppDate end )
    {
        //Create new Arraylist
        ArrayList<DailyStats> period = new ArrayList<>();
        
        //Get begin and end times
        int beginDay   = begin.getDay();
        int beginMonth = begin.getMonth();
        int beginYear  = begin.getYear();
        int endDay     = end.getDay();
        int endMonth   = end.getMonth();
        int endYear    = end.getYear();
        
        int i = 0;  //Loop counter
        
        try
        {
            //Get to beginning year
            while( XMLParse.dailyAverages.get( i ).year < beginYear )
            {
                i++;
            }
            //Get to beginning month
            while( XMLParse.dailyAverages.get( i ).month < beginMonth )
            {
                i++;
            }
            //Get to beginning day
            while( XMLParse.dailyAverages.get( i ).day < beginDay )
            {
                i++;
            }
        }
        catch( IndexOutOfBoundsException e )
        {
            //Data did not go up to beginning date return no data
            return period;
        }

        try
        {
            //Get to ending year
            while( XMLParse.dailyAverages.get( i ).year < endYear )
            {
                //Add record
                period.add( XMLParse.dailyAverages.get( i ) );
                i++;
            }
            //Get to ending month
            while( XMLParse.dailyAverages.get( i ).month < endMonth )
            {
                //Add record
                period.add( XMLParse.dailyAverages.get( i ) );
                i++;
            }
            //Get to ending day
            while( XMLParse.dailyAverages.get( i ).day <= endDay
                && XMLParse.dailyAverages.get( i ).month <= endMonth
                && XMLParse.dailyAverages.get( i ).year <= endYear )
            {
                //Add record
                period.add( XMLParse.dailyAverages.get( i ) );
                i++;
            }
        }
        catch( IndexOutOfBoundsException e )
        {
            //Data did not cover entire period, return data so far
            return period;
        }
        
        //Return period of daily averages
        return period;
    }
}
