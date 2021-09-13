import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ChartBuilder {
    ChartBuilder(double aParam, AnswerFinder solution) {
        int start = (int)(Math.floor(solution.secondAnswer)-1);
        int finish = (int)(Math.ceil(solution.firstAnswer)+1);
        XYSeries seriesExp = new XYSeries("exp(x)");
        XYSeries seriesXPlusA = new XYSeries("x + " + aParam);
        XYSeries seriesOX= new XYSeries("Ox");
        XYSeries seriesOY = new XYSeries("Oy");
        for (float i = start; i <= finish; i += 0.1) {
            seriesOX.add(i,0);
            seriesExp.add(i, Math.exp(i));
            seriesXPlusA.add(i, i + aParam);
        }
        for(double i = seriesXPlusA.getMinY();i<=seriesExp.getMaxY();i+=0.1){
            seriesOY.add(0,i);
        }
        XYSeriesCollection xyDataset = new XYSeriesCollection();
        xyDataset.addSeries(seriesExp);
        xyDataset.addSeries(seriesXPlusA);
        xyDataset.addSeries(seriesOX);
        xyDataset.addSeries(seriesOY);
        JFreeChart chart = ChartFactory
                .createXYLineChart("exp(x) = x + " + aParam, "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame = new JFrame("Chart");
        frame.setSize(1000, 800);
        ///frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        if(solution.countOfAnswers == 1 || solution.countOfAnswers == 2){
            JLabel label1 = new JLabel("Answer 1: " + solution.secondAnswer);
            panel.add(label1);
            if(solution.countOfAnswers == 2){
                JLabel label2 = new JLabel("Answer 2: " + solution.firstAnswer);
                panel.add(label2);
            }
        }
        else{
            JLabel label = new JLabel("Have not answers!");
            panel.add(label);
        }
        panel.add(new ChartPanel(chart));
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
