package ec.demo.usniffer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

public class UtilTools {

	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();// 得到一个Calendar的实例
		return sdf.format(cal.getTime());
	}

	public static String getname(String name) {
		int counts = name.indexOf(":");
		String tempname = name.substring(0, counts);
		return tempname;
	}

	public static int getdata(String name) {
		int counts = name.indexOf(":");
		String tempname = name.substring(counts + 1);
		return Integer.parseInt(tempname);
	}

	public static String bytetoint16(byte by) {
		int xx = by & 0xff;
		return Integer.toHexString(xx);
	}
	public static JFreeChart createChart1(XYDataset dataset,String titlename ) {
	        JFreeChart chart = ChartFactory.createXYLineChart(
	            "实时"+titlename+"曲线图", 
	            "时间", 
	            titlename,
	            dataset, 
	            PlotOrientation.VERTICAL,
	            false,     // legend? no, we'll create our own
	            false,      // tooltips?
	            false      // URLs?
	        );
	        
	        XYPlot plot = (XYPlot) chart.getPlot();
	        NumberAxis axis1 = (NumberAxis) plot.getRangeAxis();
	        //删除小数点的显示
	        axis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	        axis1.setAutoRangeIncludesZero(false);
	        XYLineAndShapeRenderer renderer 
	                = (XYLineAndShapeRenderer) plot.getRenderer();
	        BlockContainer container = new BlockContainer(new BorderArrangement());
	        container.add(new EmptyBlock(100, 0));
	        CompositeTitle legends = new CompositeTitle(container);
	        legends.setPosition(RectangleEdge.BOTTOM);
	        chart.addSubtitle(legends);
	        return chart;
	    }
}
