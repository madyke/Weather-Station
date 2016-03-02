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
import org.jfree.chart.plot.XYPlot.*;
import java.awt.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class GraphPanel extends JPanel
{
    private JFreeChart graph;
    private XYPlot plot; //the graph
    private ArrayList<TimeSeriesCollection> datasets = new ArrayList<>();
    
    private XYLineAndShapeRenderer highTempRenderer;
    private XYLineAndShapeRenderer avgTempRenderer;
    private XYLineAndShapeRenderer lowTempRenderer;
    private XYLineAndShapeRenderer humidityRenderer;
    private XYLineAndShapeRenderer pressureRenderer;
    private XYLineAndShapeRenderer windSpeedRenderer;
    private XYLineAndShapeRenderer uvIndexRenderer;
    private XYLineAndShapeRenderer rainfallRenderer;
    
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
        this.graph = ChartFactory.createTimeSeriesChart(
            "Weather Statistics", "Day", null, null, true, true, false
        );
        
        //Get chart plot object
        this.plot = this.graph.getXYPlot();
        this.plot.setNoDataMessage( "No data for this period." );
        
        //Create and set all renderers
        CreateAndSetAllRenderers();

        //Render temperature graphs initially
        RenderTemperature();

        ChartPanel chartPanel = new ChartPanel( this.graph );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1 , 1 ) );
        add( chartPanel );
    }
    
    private void CreateAndSetAllRenderers()
    {
        //Create and set high temperature renderer
        this.highTempRenderer = createRenderer(0, "High Temperature: ", Color.RED );
        this.plot.setRenderer( 0, this.highTempRenderer );

        //Create and set average temperature renderer
        this.avgTempRenderer = createRenderer( 0, "Average Temperature: ", Color.GREEN );
        this.plot.setRenderer( 1, this.avgTempRenderer );
         
        //Create and set low temperature renderer
        this.lowTempRenderer = createRenderer( 0, "Low Temperature: ", Color.BLUE );
        this.plot.setRenderer( 2, this.lowTempRenderer );

        //Create and set humidity renderer
        this.humidityRenderer = createRenderer(0, "Humidity: ", Color.RED );
        this.plot.setRenderer( 3, this.humidityRenderer );

        //Create and set pressure renderer
        this.pressureRenderer = createRenderer(0, "Pressure: ", Color.RED );
        this.plot.setRenderer( 4, this.pressureRenderer );

        //Create and set wind speed renderer
        this.windSpeedRenderer = createRenderer(0, "Wind Speed: ", Color.RED );
        this.plot.setRenderer( 5, this.windSpeedRenderer );

        //Create and set UV Index renderer
        this.uvIndexRenderer = createRenderer(0, "UV Index: ", Color.RED );
        this.plot.setRenderer( 6, this.uvIndexRenderer );

        //Create and set rainfall renderer
        this.rainfallRenderer = createRenderer(0, "Rainfall: ", Color.RED );
        this.plot.setRenderer( 7, this.rainfallRenderer );
 }
    
    public void RenderTemperature()
    {
        //Plot high temperatures
        this.plot.setDataset( 0, datasets.get( 0 ) );

        //Plot average temperatures
        this.plot.setDataset( 1, datasets.get( 1 ) );
         
        //Plot low temperatures
        this.plot.setDataset( 2, datasets.get( 2 ) );
        
        //Set axis label
        this.plot.getRangeAxis().setLabel( "Temperature (\u00b0F)" );
    }

    public void RenderHumidity()
    {
        //Plot humidity
        this.plot.setDataset( 3, datasets.get( 3 ) );
        
        //Set axis label
        this.plot.getRangeAxis().setLabel( "Humidity (%)" );
    }

    public void RenderPressure()
    {
        //Plot pressure
        this.plot.setDataset( 4, datasets.get( 4 ) );
        
        //Set axis label
        this.plot.getRangeAxis().setLabel( "Pressure (in. Hg.)" );
    }

    public void RenderWindSpeed()
    {
        //Plot wind speed
        this.plot.setDataset( 5, datasets.get( 5 ) );
        
        //Set axis label
        this.plot.getRangeAxis().setLabel( "Wind Speed (mph)" );
    }

    public void RenderUVIndex()
    {
        //Plot pressure
        this.plot.setDataset( 6, datasets.get( 6 ) );
        
        //Set axis label
        this.plot.getRangeAxis().setLabel( "UV Index" );
    }

    public void RenderRainfall()
    {
        //Plot pressure
        this.plot.setDataset( 7, datasets.get( 7 ) );
        
        //Set axis label
        this.plot.getRangeAxis().setLabel( "Rainfall (in)" );
    }

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
    
    public void ClearGraph()
    {
        for( int i = 0; i < this.plot.getRendererCount(); i++ )
        {
            this.plot.setDataset( i, null );
        }
    }
}