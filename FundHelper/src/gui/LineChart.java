package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.FundInfoManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class LineChart {
	@SuppressWarnings("deprecation")
	static ChartPanel createLineChart(FundInfoManager fim, String...fundCodes) throws IOException{
	
		XYDataset xydataset= createDataset(fim, fundCodes);
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("", "", "",xydataset,true, true, true);
        jfreechart.setTitle(new TextTitle("", new Font("隶书", Font.ITALIC, 8)));
        jfreechart.setAntiAlias(true);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        
        xyplot.setOutlineVisible(false);
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.lightGray);
        xyplot.setRangeGridlinesVisible(true);
        
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer(); 
        xylineandshaperenderer.setShapesVisible(true); 
        xylineandshaperenderer.setShapesFilled(true); 
        xylineandshaperenderer.setShape(new Rectangle(4, 4)); 
        
        StandardXYToolTipGenerator tipGenerator = new StandardXYToolTipGenerator("{1}:{2}", 
        new SimpleDateFormat("yy年MM月dd"),NumberFormat.getNumberInstance()); 
        xylineandshaperenderer.setToolTipGenerator(tipGenerator); 
        
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("yy-MM-dd"));
        
        return new ChartPanel(jfreechart, true);
        
	} 
        
        private static XYDataset createDataset(FundInfoManager fim, String...fundCodes) throws IOException {  
             TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
             for(int i=0;i<fundCodes.length;i++){
                 TimeSeries timeseries = new TimeSeries(fundCodes[i],Day.class);
               List<List<String>> records = fim.getRecords(fundCodes[i]);
               
               for(List<String> record : records){
            	   timeseries.add(new Day(Integer.parseInt(record.get(2)), Integer.parseInt(record.get(1)), Integer.parseInt(record.get(0))), Double.parseDouble(record.get(3)));
               }
              
               timeseriescollection.addSeries(timeseries);
             }
            return timeseriescollection;
        }
}