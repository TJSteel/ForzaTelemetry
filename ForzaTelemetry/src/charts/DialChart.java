package charts;

import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.chart.ui.GradientPaintTransformType;
import org.jfree.chart.ui.StandardGradientPaintTransformer;

public class DialChart extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultValueDataset dataset;
	private int minValue;
	private int maxValue;
	private String label;
	private int panelSize;

	private DialPlot createDialPlot(double majorTickCount, int minorTickCount)	{
		DialPlot dialplot = new DialPlot();
		dialplot.setDataset(this.getDataset());
		dialplot.setDialFrame(new StandardDialFrame());
		dialplot.setBackground(new DialBackground());

		DialTextAnnotation dialtextannotation = new DialTextAnnotation(getLabel());
		dialtextannotation.setFont(new Font("Dialog", 1, 14));
		dialtextannotation.setRadius(0.70D);
		dialplot.addLayer(dialtextannotation);
		
		DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
		dialplot.addLayer(dialvalueindicator);
		//public StandardDialScale(double lowerBound, double upperBound, double startAngle, double extent, double majorTickIncrement, int minorTickCount);
		
		StandardDialScale standarddialscale = new StandardDialScale(this.getMinValue(), this.getMaxValue(), -120D, -300D, majorTickCount, minorTickCount);
		standarddialscale.setTickRadius(0.88D);
		standarddialscale.setTickLabelOffset(0.15D);
		standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));
		dialplot.addScale(0, standarddialscale);
		dialplot.addPointer(new org.jfree.chart.plot.dial.DialPointer.Pin());
		
		DialCap dialcap = new DialCap();
		dialplot.setCap(dialcap);
		
		StandardDialRange standarddialrange = new StandardDialRange(9000D, 10000D, Color.red);
		standarddialrange.setInnerRadius(0.55D);
		standarddialrange.setOuterRadius(0.60D);
		dialplot.addLayer(standarddialrange);
		
		StandardDialRange standarddialrange1 = new StandardDialRange(8000D, 9000D, Color.orange);
		standarddialrange1.setInnerRadius(0.55D);
		standarddialrange1.setOuterRadius(0.60D);
		dialplot.addLayer(standarddialrange1);
		
		StandardDialRange standarddialrange2 = new StandardDialRange(0D, 8000D, Color.green);
		standarddialrange2.setInnerRadius(0.55D);
		standarddialrange2.setOuterRadius(0.60D);
		dialplot.addLayer(standarddialrange2);
		
		GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
		DialBackground dialbackground = new DialBackground(gradientpaint);
		dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
		dialplot.setBackground(dialbackground);
		dialplot.removePointer(0);
		dialplot.setBackgroundImageAlpha(0.0f);
		dialplot.setBackgroundAlpha(0.0f);
		
		org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer();
		pointer.setFillPaint(Color.green);
		dialplot.addPointer(pointer);
		
		return dialplot;
	}

	public DialChart(int minValue, int maxValue, String label, int panelSize) {
		this.setMinValue(minValue);
		this.setMaxValue(maxValue);
		this.setLabel(label);
		this.setLayout(new GridLayout(1, 1));
		setDataset(new DefaultValueDataset(1000D));
		DialPlot dialplot = createDialPlot(1000D, 0);
		JFreeChart jfreechart = new JFreeChart(dialplot);
		jfreechart.setBackgroundPaint(null);
		
		ChartPanel chartpanel = new ChartPanel(jfreechart);
		chartpanel.setPreferredSize(new Dimension(this.getPanelSize(),this.getPanelSize()));
		chartpanel.setOpaque(false);
		add(chartpanel);
	}

	/**
	 * @return the dataset
	 */
	public DefaultValueDataset getDataset() {
		return dataset;
	}

	/**
	 * @param dataset the dataset to set
	 */
	void setDataset(DefaultValueDataset dataset) {
		this.dataset = dataset;
	}

	/**
	 * @return the label
	 */
	private String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	private void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the minValue
	 */
	private int getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue the minValue to set
	 */
	private void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the maxValue
	 */
	private int getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	private void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the panelSize
	 */
	private int getPanelSize() {
		return panelSize;
	}

	/**
	 * @param panelSize the panelSize to set
	 */
	private void setPanelSize(int panelSize) {
		this.panelSize = panelSize;
	}

}