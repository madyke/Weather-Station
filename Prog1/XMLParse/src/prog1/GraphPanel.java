// ImageDisplay.java
// Java Swing program to display an image in a JLabel.
// Author: John M. Weiss, Ph.D.
// Class: CSC468 GUI Programming, Spring 2016

package prog1;

// import statements
import javax.swing.*;
import java.util.ArrayList;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphPanel extends JPanel
{
   public GraphPanel( String chartTitle )
   {
        JFreeChart lineChart = ChartFactory.createLineChart(
           chartTitle,
           "Day","High Temperature",
           createDataset( XMLParse.dailyAverages ),
           PlotOrientation.VERTICAL,
           true,true,false);
         
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        add( chartPanel );
        
        System.out.println( "SHOW GRAPH" );
        chartPanel.setVisible( true );
        this.setVisible( true ); 
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

       GraphPanel chart = new GraphPanel( "Daily High Temperatures" );
      
       //chart.pack( );
       //RefineryUtilities.centerFrameOnScreen( chart );
       chart.setVisible( true );
   }
}