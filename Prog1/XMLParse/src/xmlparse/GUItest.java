// ImageDisplay.java
// Java Swing program to display an image in a JLabel.
// Author: John M. Weiss, Ph.D.
// Class: CSC468 GUI Programming, Spring 2016

package xmlparse;

// import statements
import javax.swing.*;
import java.util.ArrayList;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RefineryUtilities;
import java.awt.*;
import java.awt.event.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class GUItest extends JFrame
{
    private XYPlot plot;
    
    public GUItest( String applicationTitle , String chartTitle )
    {
         super(applicationTitle);

         final TimeSeriesCollection dataset1 = createHighTempDataset( XMLParse.dailyAverages, "High Temperatures" );
         final TimeSeriesCollection dataset2 = createLowTempDataset( XMLParse.dailyAverages, "Low Temperatures" );
         final JFreeChart chart = ChartFactory.createTimeSeriesChart(
             "Multiple Dataset Demo 1", "Time", "Value", dataset1, true, true, false
         );
         this.plot = chart.getXYPlot();

         this.plot.setDataset( 1, dataset2 );
         this.plot.setRenderer( 1, new StandardXYItemRenderer());

         final JPanel content = new JPanel(new BorderLayout());

         final ChartPanel chartPanel = new ChartPanel(chart);
         content.add(chartPanel);

         chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
         setContentPane(content);

        // another way to exit app when window is closed
        addWindowListener( new WindowAdapter()
        {
            public void windowClosing( WindowEvent e )
            {
                System.exit( 0 );
            }
        } );
    }
   
   private TimeSeriesCollection createHighTempDataset( ArrayList<DailyStats> stats, String name )
   {
        TimeSeries series = new TimeSeries( name );
        
        for( Integer i = 0; i < stats.size(); i++ )
        {
            RegularTimePeriod t = new Day(stats.get(i).day, 1, 2010);
            series.add( t, stats.get( i ).highTemp );
        }
      
      return new TimeSeriesCollection(series);
   }
   private TimeSeriesCollection createLowTempDataset( ArrayList<DailyStats> stats, String name )
   {
        TimeSeries series = new TimeSeries( name );
        
        for( Integer i = 0; i < stats.size(); i++ )
        {
            RegularTimePeriod t = new Day(stats.get(i).day, 1, 2010);
            series.add( t, stats.get( i ).lowTemp );
        }
      
      return new TimeSeriesCollection(series);
   }

   public static void main( String[ ] args ) 
   {    
       //Parse test file
       XMLParse.parseFile( "XMLTest.xml" );

       GUItest chart = new GUItest(
       "GUI Test" ,
       "Daily High Temperatures");
      
       chart.pack( );
       RefineryUtilities.centerFrameOnScreen( chart );
       chart.setVisible( true );
   }
}