package charts;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.io.Serializable;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialPointer.Pointer;
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.GradientPaintTransformType;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.StandardGradientPaintTransformer;

public class DialChartWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private class LegendItemSourceImpl implements  Serializable, LegendItemSource {
		private static final long serialVersionUID = 1L;
		private Paint one;
		private Paint two;
		private Paint three;
		private Paint four;
		private Paint five;
		
		public LegendItemSourceImpl(Paint one, Paint two, Paint three, Paint four, Paint five) {
			this.one = one;
			this.two = two;
			this.three = three;
			this.four = four;
			this.five = five;
		}
		
	    @Override
		public final LegendItemCollection getLegendItems() {
	    	LegendItemCollection result = new LegendItemCollection();
	    	result.add(new LegendItem("One     ", one));
	    	result.add(new LegendItem("Two     ", two));
	    	result.add(new LegendItem("Three   ", three));
	    	result.add(new LegendItem("Four    ", four));
	    	result.add(new LegendItem("Five    ", five));

	        return result;
	    }
	}
	
	public void wrapToDialChart(JFreeChart chart)	{
		//create DialPlot object using Plot data from a given JFreeChart object
		DialPlot dialPlot = (DialPlot) chart.getPlot();
		
		//apply dark gray rim and light gray interior for dial
		StandardDialFrame standardDialFrame = new StandardDialFrame();
        standardDialFrame.setBackgroundPaint(Color.lightGray);
        standardDialFrame.setForegroundPaint(Color.darkGray);
        dialPlot.setDialFrame(standardDialFrame);
        
        //apply a bluish-to-white gradient texture to inner frame
        GradientPaint gradientPaint = new GradientPaint(new Point(), new Color(188, 201, 255), new Point(), new Color(255, 255, 255));
        DialBackground dialBackground = new DialBackground(gradientPaint);
        dialBackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
        dialPlot.setBackground(dialBackground);
        
        //This adds a text within the dial starting at a specified radius
        DialTextAnnotation dialTextAnnotation = new DialTextAnnotation("DialTextAnnotation");
        dialTextAnnotation.setFont(new Font(Font.DIALOG, 1, 14));
        dialTextAnnotation.setRadius(0.69999999999999996D);
        dialPlot.addLayer(dialTextAnnotation);
        
        //Adds needle for dial
        DialValueIndicator dialValueIndicator = new DialValueIndicator(0);
        dialPlot.addLayer(dialValueIndicator);
        
        //applied definition of bounds of dial, starting angle of needle, travelable range of needle,
        //and I think the change needed to move the needle a certain arc 
        StandardDialScale standardDialScale = new StandardDialScale(0D, 100D, -120D, -300D, 10D, 4);
        standardDialScale.setMajorTickIncrement(10);
        standardDialScale.setMinorTickCount(4);
        standardDialScale.setTickRadius(0.88D);
        standardDialScale.setTickLabelOffset(0.14999999999999999D);
        standardDialScale.setTickLabelFont(new Font(Font.DIALOG, 0, 10));
        dialPlot.addScale(0, standardDialScale);
        
        //note: the procedures for adding these 5 color layers were in reverse order, but I don't think it makes a difference 
        //Colors 1/5 of the dial green by defining the arc range, color, and a radial section
        StandardDialRange standarddialrange1 = new StandardDialRange(0D, 21D, Color.decode("#00CC99"));
        standarddialrange1.setInnerRadius(0.52000000000000002D);
        standarddialrange1.setOuterRadius(0.55000000000000004D);
        dialPlot.addLayer(standarddialrange1);
        
        //Colors 1/5 of the dial yellow by defining the arc range, color, and a radial section
        StandardDialRange standarddialrange2 = new StandardDialRange(21D, 41D, Color.decode("#C8C800"));
        standarddialrange2.setInnerRadius(0.52000000000000002D);
        standarddialrange2.setOuterRadius(0.55000000000000004D);
        dialPlot.addLayer(standarddialrange2);
        
        //Colors 1/5 of the dial orange by defining the arc range, color, and a radial section
        StandardDialRange standarddialrange3 = new StandardDialRange(41D, 61D, Color.decode("#FF6600"));
        standarddialrange3.setInnerRadius(0.52000000000000002D);
        standarddialrange3.setOuterRadius(0.55000000000000004D);
        dialPlot.addLayer(standarddialrange3);
        
        //Colors 1/5 of the dial red by defining the arc range, color, and a radial section
        StandardDialRange standarddialrange4 = new StandardDialRange(61D, 81D, Color.decode("#CC0000"));
        standarddialrange4.setInnerRadius(0.52000000000000002D);
        standarddialrange4.setOuterRadius(0.55000000000000004D);
        dialPlot.addLayer(standarddialrange4);
 
        //Colors 1/5 of the dial dark red by defining the arc range, color, and a radial section
        StandardDialRange standardDialRange5 = new StandardDialRange(81D, 100D, Color.decode("#990000"));
        standardDialRange5.setInnerRadius(0.52000000000000002D);
        standardDialRange5.setOuterRadius(0.55000000000000004D);
        dialPlot.addLayer(standardDialRange5);
        
        //Adds a dialpointer to the Dial
        Pointer dialPointer = new DialPointer.Pointer();

        dialPlot.addPointer(dialPointer);
        
        //Legends for chart
        LegendTitle legend = new LegendTitle(new LegendItemSourceImpl(
        		Color.decode("#00CC99"),
        		Color.decode("#C8C800"),
        		Color.decode("#FF6600"),
        		Color.decode("#CC0000"),
        		Color.decode("#990000")));
    	legend.setPosition(RectangleEdge.RIGHT); 
    	legend.setFrame(new BlockBorder());
    	legend.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        chart.addLegend(legend); //note: this was commented out before I touched it
        
        //note: this block didn't exist before so I added it for completeness to link to container4
        LegendTitle legend2 = new LegendTitle(new LegendItemSourceImpl(
        		Color.decode("#00CC99"),
        		Color.decode("#C8C800"),
        		Color.decode("#FF6600"),
        		Color.decode("#CC0000"),
        		Color.decode("#990000")));
    	legend2.setPosition(RectangleEdge.RIGHT); 
    	legend2.setFrame(new BlockBorder());
    	legend2.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        chart.addLegend(legend2);

    	TextTitle outerDialTextTitle = new TextTitle("Outer Dial Text Title");
    	TextTitle innerDialTextTitle = new TextTitle("Inner Dial Text Title");
    	TextTitle spacer = new TextTitle("  ");
        
    	BorderArrangement borderArrangement1 = new BorderArrangement();
		BorderArrangement borderArrangement2 = new BorderArrangement();
		BorderArrangement borderArrangement3 = new BorderArrangement();
		BorderArrangement borderArrangement4 = new BorderArrangement();
        
		BlockContainer container1 = new BlockContainer(borderArrangement1);
		BlockContainer container2 = new BlockContainer(borderArrangement2);
		BlockContainer container3 = new BlockContainer(borderArrangement3);
		BlockContainer container4 = new BlockContainer(borderArrangement4);
		
		container1.add(spacer, RectangleEdge.LEFT);
		container1.add(container2, RectangleEdge.RIGHT);
		
		container2.add(container3, RectangleEdge.TOP);
		container2.add(container4, RectangleEdge.BOTTOM);
		
		container3.add(outerDialTextTitle, RectangleEdge.TOP); //note: this was commented out before I touched it
		container3.add(legend, RectangleEdge.BOTTOM);
				
		container4.add(innerDialTextTitle, RectangleEdge.TOP); //note: this was commented out before I touched it
		container4.add(legend2, RectangleEdge.BOTTOM); //note: this was commented out before I touched it
		
        container1.add(new EmptyBlock(80,80));
        
        CompositeTitle main = new CompositeTitle(container1);
        chart.addSubtitle(main);
        main.setPosition(RectangleEdge.RIGHT);
	}
}