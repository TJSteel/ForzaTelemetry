package charts;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultValueDataset;

public class DialChart extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultValueDataset dataset;
	private int minValue;
	private int maxValue;
	private String label;
	private int panelSize;

	private DialPlot createDialPlot(double majorTickCount, int minorTickCount)	{
		DialPlot dialplot = new DialPlot();
		dialplot.setDataset(0, this.getDataset());
		dialplot.setDialFrame(new StandardDialFrame());
		dialplot.setBackground(new DialBackground());

		DialTextAnnotation dialtextannotationRPM = new DialTextAnnotation(getLabel());
		dialtextannotationRPM.setFont(new Font("Arial", 1, 20));
		dialtextannotationRPM.setRadius(0.50D);
		dialtextannotationRPM.setAngle(-45);
		dialplot.addLayer(dialtextannotationRPM);

		DialTextAnnotation dialtextannotationRPMMultiplier = new DialTextAnnotation("x1000");
		dialtextannotationRPMMultiplier.setFont(new Font("Arial", 1, 12));
		dialtextannotationRPMMultiplier.setRadius(0.70D);
		dialtextannotationRPMMultiplier.setAngle(-60);
		dialplot.addLayer(dialtextannotationRPMMultiplier);

		//DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
		//dialplot.addLayer(dialvalueindicator);

		//public StandardDialScale(double lowerBound, double upperBound, double startAngle, double extent, double majorTickIncrement, int minorTickCount);
		StandardDialScale standarddialscaleValue = new StandardDialScale(this.getMinValue(), this.getMaxValue(), -90D, -285D, majorTickCount, minorTickCount);
		standarddialscaleValue.setVisible(false);
		dialplot.addScale(0, standarddialscaleValue);

		StandardDialScale standarddialscaleLabel = new StandardDialScale(this.getMinValue()/1000, this.getMaxValue()/1000, -90D, -285D, majorTickCount/1000, minorTickCount);
		standarddialscaleLabel.setTickRadius(0.88D);
		standarddialscaleLabel.setMajorTickLength(.15);
		standarddialscaleLabel.setMinorTickLength(.1);
		standarddialscaleLabel.setTickLabelPaint(Color.black);
		standarddialscaleLabel.setTickLabelOffset(0.3D);
		standarddialscaleLabel.setTickLabelFont(new Font("Arial", 1, 25));
		NumberFormat formatter = DecimalFormat.getInstance();
		formatter.setMinimumFractionDigits(0);
		standarddialscaleLabel.setTickLabelFormatter(formatter);
		dialplot.addScale(1, standarddialscaleLabel);
		dialplot.mapDatasetToScale(1, 1);

		dialplot.addPointer(new org.jfree.chart.plot.dial.DialPointer.Pin());
		DialCap dialcap = new DialCap();
		dialcap.setFillPaint(Color.gray);
		dialcap.setOutlinePaint(Color.darkGray);
		dialcap.setRadius(.08);;
		dialplot.setCap(dialcap);
		
		StandardDialRange standarddialrange = new StandardDialRange(9000D, 10000D, Color.red);
		standarddialrange.setInnerRadius(0.85D);
		standarddialrange.setOuterRadius(0.90D);
		dialplot.addLayer(standarddialrange);
		
		//GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(100, 100, 100), new Point(), new Color(50, 50, 50));
		DialBackground dialbackground = new DialBackground(Color.white);
		//dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
		dialplot.setBackground(dialbackground);
		dialplot.removePointer(0);
		dialplot.setBackgroundImageAlpha(0.0f);
		dialplot.setBackgroundAlpha(0.0f);
		
		org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer();
		pointer.setFillPaint(Color.red);
		pointer.setOutlinePaint(Color.gray);
		pointer.setRadius(0.75);
		pointer.setWidthRadius(.05);
		dialplot.addPointer(pointer);
		
		return dialplot;
	}

	public DialChart(int minValue, int maxValue, String label, int panelSize) {
		this.setMinValue(minValue);
		this.setMaxValue(maxValue);
		this.setLabel(label);
		this.setLayout(new GridLayout(1, 1));
		setDataset(new DefaultValueDataset(1000D));
		DialPlot dialplot = createDialPlot(1000D, 10);
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