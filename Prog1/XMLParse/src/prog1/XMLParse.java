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
import java.util.regex.Pattern;
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
    
    private static File[] fileList;
    
    public static void parseInitialFiles()
    {
        //Get current working directory
        String dir = getWorkingDirectory();
        
        //Get list of files matching required format in current working dir
        getFileList( dir );
        
        
        //Loop over each file in the file list
        for( File currFile : fileList )
        {
            System.out.println( currFile );
        }
        
        parseFile( "2010-01.xml" );
    }
    
    private static void parseFile( String fileName )
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
    }
    
    private static String getWorkingDirectory()
    {
        //Return directory string from where application launched
        return System.getProperty("user.dir");
    }
}
