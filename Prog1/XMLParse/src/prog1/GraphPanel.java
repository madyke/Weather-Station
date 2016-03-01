// ImageDisplay.java
// Java Swing program to display an image in a JLabel.
// Author: John M. Weiss, Ph.D., adapted by Matt Dyke.
// Class: CSC468 GUI Programming, Spring 2016

package prog1;

// import statements
import javax.swing.*;
import java.util.ArrayList;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import java.awt.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 * This class creates a panel for displaying a graph in a swing GUI.
 * 
 * @author Dr. John Weiss & Matt Dyke
 */
public class GraphPanel extends JPanel
{
    private XYPlot plot; //the graph
    private ArrayList<TimeSeriesCollection> datasets = new ArrayList<>();
    
    /**
     * The constructor for the graph panel. It takes a title string for use in 
     * rendering the graph.
     * 
     * @param chartTitle A string the is the title of the graph.
     */
    public GraphPanel( String chartTitle )
    {
        //Create datasets
        createDailyDatasets( XMLParse.dailyAverages );
        
        //Build empty chart
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Weather Statistics", "Day", "Temperature", null, true, true, false
        );
        
        //Get chart plot object
        this.plot = chart.getXYPlot();
        this.plot.setNoDataMessage( "No data for this period." );

        //Plot high temperatures
        XYLineAndShapeRenderer highTempRenderer = createRenderer(0, "High Temperature: ", Color.RED );
        this.plot.setDataset( 0, datasets.get( 0 ) );
        this.plot.setRenderer( 0, highTempRenderer );

        //Plot average temperatures
        XYItemRenderer avgTempRenderer = createRenderer( 0, "Average Temperature: ", Color.GREEN );
        this.plot.setDataset( 1, datasets.get( 1 ) );       
        this.plot.setRenderer( 1, avgTempRenderer );
         
        //Plot low temperatures
        XYItemRenderer lowTempRenderer = createRenderer( 0, "Low Temperature: ", Color.BLUE );
        this.plot.setDataset( 2, datasets.get( 2 ) );
        this.plot.setRenderer( 2, lowTempRenderer );

        ChartPanel chartPanel = new ChartPanel( chart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1 , 1 ) );
        add( chartPanel );
    }

    /**
     * Creates the renderer for the graph.
     * 
     * @param seriesIndex
     * @param toolTip
     * @param col
     * @return renderer The renderer for the graph.
     */
    private XYLineAndShapeRenderer createRenderer( int seriesIndex, String toolTip, Color col ) 
   {
        //Create new renderer
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        //Set renderer properties
        renderer.setSeriesPaint( seriesIndex, col );
        //renderer.setSeriesShape( seriesIndex, new Rectangle(-1, -1, 2, 2));
        renderer.setSeriesToolTipGenerator( seriesIndex, new StandardXYToolTipGenerator() {
                   private static final long serialVersionUID = 1L;
                   public String generateToolTip(XYDataset dataset, int series, int item) {
                      String toolTipStr = toolTip + dataset.getYValue(series, item);
                      return toolTipStr;
                }} );
        
        return renderer;
    }
    
    private void createDailyDatasets( ArrayList<DailyStats> stats )
    {
        TimeSeries highTemp  = new TimeSeries( "High Temp" );
        TimeSeries avgTemp   = new TimeSeries( "Avgerage Temp" );
        TimeSeries lowTemp   = new TimeSeries( "Low Temp" );
        TimeSeries humidity  = new TimeSeries( "Humidity" );
        TimeSeries pressure  = new TimeSeries( "Pressue" );
        TimeSeries windSpeed = new TimeSeries( "Wind Speed" );
        TimeSeries UVIndex   = new TimeSeries( "UV Index" );
        TimeSeries rainfall  = new TimeSeries( "Rainfall" );
        
        //Loop over each item in stats ArrayList
        for( DailyStats item : stats )
        {
            //Build time object to track time of current entry
            RegularTimePeriod t = new Day( item.day, item.month, item.year );
            
            //Add current entry's fields to series
            highTemp.add( t, item.highTemp );
            avgTemp.add( t, item.avgTemp );
            lowTemp.add( t, item.lowTemp );
            humidity.add( t, item.avgHumidity );
            pressure.add( t, item.avgBarometer );
            windSpeed.add( t, item.avgWindSpeed );
            UVIndex.add( t, item.avgUVIndex );
            rainfall.add( t, item.avgRainFall );
        }
        
        //Add series to datasets
        this.datasets.add( new TimeSeriesCollection( highTemp ) );
        this.datasets.add( new TimeSeriesCollection( avgTemp ) );
        this.datasets.add( new TimeSeriesCollection( lowTemp ) );
        this.datasets.add( new TimeSeriesCollection( humidity ) );
        this.datasets.add( new TimeSeriesCollection( pressure ) );
        this.datasets.add( new TimeSeriesCollection( windSpeed ) );
        this.datasets.add( new TimeSeriesCollection( UVIndex ) );
        this.datasets.add( new TimeSeriesCollection( rainfall ) );
    }
}