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
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUItest extends JFrame
{
   public GUItest( String applicationTitle , String chartTitle )
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Day","High Temperature",
         createDataset( XMLParse.dailyAverages ),
         PlotOrientation.VERTICAL,
         true,true,false);
         
    ChartPanel chartPanel = new ChartPanel( lineChart );
    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
    setContentPane( chartPanel );

    // another way to exit app when window is closed
    addWindowListener( new WindowAdapter()
    {
        public void windowClosing( WindowEvent e )
        {
            System.exit( 0 );
        }
    } );
   }

   private DefaultCategoryDataset createDataset( ArrayList<DailyStats> stats )
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
      for( Integer i = 0; i < stats.size(); i++ )
      {
          Integer currDay = stats.get( i ).day;
          dataset.addValue( stats.get( i ).highTemp, "High Temp", currDay.toString() );
      }
      
      return dataset;
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