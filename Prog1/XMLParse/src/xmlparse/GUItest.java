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
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class GUItest extends JFrame
{
    private XYPlot plot;
    
    public GUItest( String applicationTitle , String chartTitle )
    {
        super(applicationTitle);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Weather Statistics", "Day", "Temperature", null, true, true, false
        );
        this.plot = chart.getXYPlot();

        //Create high and low temperature datasets
        final TimeSeriesCollection highTempDataset = createHighTempDataset( XMLParse.dailyAverages, "High Temperatures" );
        final TimeSeriesCollection lowTempDataset = createLowTempDataset( XMLParse.dailyAverages, "Low Temperatures" );
        final TimeSeriesCollection avgTempDataset = createAvgTempDataset( XMLParse.dailyAverages, "Average Tempeartures" );

        //Plot high temperatures
        XYLineAndShapeRenderer highTempRenderer = createRenderer( 0, "High Temperature: ", Color.RED );
        this.plot.setDataset( 0, highTempDataset );
        this.plot.setRenderer( 0, highTempRenderer );

        //Plot low temperatures
        XYItemRenderer lowTempRenderer = createRenderer( 1, "Low Temperature: ", Color.BLUE );
        this.plot.setDataset( 1, lowTempDataset );
        this.plot.setRenderer( 1, lowTempRenderer );

        //Plot average temperatures
        XYItemRenderer avgTempRenderer = createRenderer( 0, "Average Temperature: ", Color.GREEN );
        this.plot.setDataset( 2, avgTempDataset );       
        this.plot.setRenderer( 2, avgTempRenderer );

        JPanel content = new JPanel(new BorderLayout());

        ChartPanel chartPanel = new ChartPanel(chart);
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
    
    private XYLineAndShapeRenderer createRenderer( int seriesIndex, String toolTip, Color col ) 
   {
        //Create new renderer
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        //Set renderer properties
        renderer.setSeriesPaint( 0, col );
        renderer.setSeriesShape( 0, new Rectangle(-1, -1, 2, 2));
        renderer.setSeriesToolTipGenerator( 0, new StandardXYToolTipGenerator() {
                   private static final long serialVersionUID = 1L;
                   public String generateToolTip(XYDataset dataset, int series, int item) {
                      String toolTipStr = toolTip + dataset.getYValue(series, item);
                      return toolTipStr;
                }} );
        
        return renderer;
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
   private TimeSeriesCollection createAvgTempDataset( ArrayList<DailyStats> stats, String name )
   {
        TimeSeries series = new TimeSeries( name );
        
        for( Integer i = 0; i < stats.size(); i++ )
        {
            RegularTimePeriod t = new Day(stats.get(i).day, 1, 2010);
            series.add( t, stats.get( i ).avgTemp );
        }
      
      return new TimeSeriesCollection(series);
   }

   public static void main( String[ ] args ) 
   {    
       //Parse test file
       XMLParse.parseFile( "2010-01.xml" );

       GUItest chart = new GUItest(
       "GUI Test" ,
       "Daily Temperatures");
      
       chart.pack( );
       RefineryUtilities.centerFrameOnScreen( chart );
       chart.setVisible( true );
   }
}