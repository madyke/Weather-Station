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
public class XMLParse
{
    public static ArrayList<YearlyStats> yearlyAverages = new ArrayList<>();
    public static ArrayList<MonthlyStats> monthlyAverages = new ArrayList<>();
    public static ArrayList<DailyStats> dailyAverages = new ArrayList<>();
    public static ArrayList<ArrayList<WeatherReading>> dailyReadings = new ArrayList<>();
    
    public static void main(String[] args)
    {
        //Set-up for XML parsing
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( "2010-01.xml" );
        
        try
        {
            //Create new document object from XML file
            Document document = (Document) builder.build(xmlFile);
            
            //Get root node and children from XML file
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("weather");
            
            //Create for new day
            int currDay = 0;
            ArrayList<WeatherReading> currDayReadings = new ArrayList<WeatherReading>();
            
            //Loop over each weather reading
            for (int i = 0; i < list.size(); i++)
            {
                //Get current child
                Element node = (Element) list.get(i);

                //Create object to help with reading in
                WeatherReading currReading = new WeatherReading();

                //Read in data
                currReading.ReadData( node );
                currReading.PrintData();
                
                //If current reading from a new day
                if( currReading.day != currDay && i != 0 )
                {
                    //Add previous day's readings to list of all readings
                    dailyReadings.add( currDayReadings );
                    
                    //Create new array for new day
                    currDayReadings = new ArrayList<WeatherReading>();
                }
                
                //Add current reading to list of today's readings
                currDayReadings.add( currReading );
            }
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
