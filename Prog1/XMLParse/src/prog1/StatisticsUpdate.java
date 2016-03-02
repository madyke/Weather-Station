/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

import java.util.ArrayList;

/**
 *  
 *
 * @author Charles Parsons
 */
public abstract class StatisticsUpdate {
    
    /**
     * This method checks through the yearly statistics that have been 
     * calculated, upon finding the desired year it returns the statistics for 
     * that year.
     * 
     * @param year The year for which statistics are desired.
     * @return values The statistics for a specific year, or an empty 
     * YearlyStats object if the year is not found.
     */
    public static YearlyStats getYearlyStats(int year)
    {
        /*Iterate through the yearlyAverages array list from XMLParse looking
          looking for the requested year. Return those stats if found.*/
        for(YearlyStats values : XMLParse.yearlyAverages)
        {
            if(values.year == year)
            {
                return values;
            }
        }
        return new YearlyStats();
    }
    
    /**
     * This method checks through the monthly statistics that have been 
     * calculated, upon finding the desired month and year it returns the 
     * statistics for that month and year.
     * 
     * @param month The month for which statistics are desired.
     * @param year The year for which statistics are desired.
     * @return values The statistics for a specific month and year, or an empty 
     * MonthlyStats object if the year is not found.
     */
    public static MonthlyStats getMonthlyStats(int month, int year)
    {
        /*Iterate through the monthlyAverages array list from XMLParse looking
          looking for the requested month. Return those stats if found.*/
        for(MonthlyStats values : XMLParse.monthlyAverages)
        {
            if(values.year == year && values.month == month)
            {
                return values;
            }
        }
        return new MonthlyStats();
    }
    
    /**
     * This method checks through the daily statistics that have been 
     * calculated, upon finding the desired day, month, and year it returns the 
     * statistics for that day, month, and year.
     * 
     * @param month The month for which statistics are desired.
     * @param day The day for which statistics are desired.
     * @param year The year for which statistics are desired.
     * @return values The statistics for a specific day, month, and year, or an 
     * empty DailyStats object if the year is not found.
     */
    public static DailyStats getDailyStats(int month, int day, int year)
    {
        /*Iterate through the dailyAverages array list from XMLParse looking
          looking for the requested day. Return those stats if found.*/
        for(DailyStats values : XMLParse.dailyAverages)
        {
            if(values.year == year && values.month == month 
               && values.day == day)
            {
                return values;
            }
        }
        return new DailyStats();
    }
    
    public static WeatherStats getCustomStats(AppDate start, AppDate end)
    {
        WeatherStats wStats = new WeatherStats();
        boolean isDone = false; //flag to exit loops when the end date is passed
        
        //start and end in the same month and year
        if(start.getMonth() == end.getMonth() && start.getYear() == end.getYear())
        {
            //loop through the data from each file
            for(ArrayList<WeatherReading> readings : XMLParse.weatherReadings)
            {
                //shortcut exiting the loop
                if(isDone == true)
                {
                    break;
                }
                //loop through to get the individual readings
                for(WeatherReading reading : readings)
                {
                    /*if the reading is between the start and end dates, then
                      track those readings for the aggregate totals/averages*/
                    if((reading.year == start.getYear() && reading.month == start.getMonth()
                            && reading.day >= start.getDay()) &&
                            reading.day <= end.getDay())
                    {
                        wStats.AddToRunningTotals(reading);
                    }
                    else if(end.getYear() <= reading.year || (end.getMonth() <=
                            reading.month & end.getYear() == reading.year))
                    {
                        isDone = true;
                        break;
                    }
                }
            }
        }
        /*start and end are in the same year, but different months or both 
          month and year are different*/
        else
        {
            //loop through the data from each file
            for(ArrayList<WeatherReading> readings : XMLParse.weatherReadings)
            {
                //shortcut exiting the loop
                if(isDone == true)
                {
                    break;
                }
                //loop through to get the individual readings
                for(WeatherReading reading : readings)
                {
                    /*if the reading is between the start and end dates, then
                      track those readings for the aggregate totals/averages*/
                    if((reading.year == start.getYear() && reading.month == start.getMonth()
                            && reading.day >= start.getDay()) ||
                            (reading.day <= end.getDay() && reading.month == end.getMonth()
                            && reading.year == end.getYear()))
                    {
                        wStats.AddToRunningTotals(reading);
                    }
                    else if(end.getYear() <= reading.year || (end.getMonth() <=
                            reading.month & end.getYear() == reading.year))
                    {
                        isDone = true;
                        break;
                    }
                }
            }
        }
        
        //calculate average statistics for the date range
        wStats.CalculateAverages();
        
        return wStats;
    }
}
