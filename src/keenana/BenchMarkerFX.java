/*
 * Course: CSC 1110 131
 * Term: Fall 2023
 * Assignment:
 * Name: Andrew Keenan
 * Created:
 */
package keenana;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * This is the main class for running the benchmarks and displaying the corresponding
 * data on a javaFX line chart and then saving that image for future use.
 */
public class BenchMarkerFX extends Application {
    private long[][] data;
    @Override
    public void start(Stage stage) throws Exception {
        final Map<String, String> params = getParameters().getNamed();
        final String structure = params.get("implementation");
        final String operation = params.get("operation");
        final String sSize = params.get("startSize");
        int stSize = Integer.parseInt(sSize);
        final String multiplier = params.get("multiplier");
        int multi = Integer.parseInt(multiplier);
        final String numSamples = params.get("numberOfSamples");
        int numSam = Integer.parseInt(numSamples);
        final String file = params.get("output");
        long[] times = new ListBenchmark().runBenchmark(structure, operation, stSize, multi, numSam);
        long[] sizes = new long[times.length];
        int cSize = stSize;
        for (int i = 0; i < times.length; i++){
            sizes[i] = cSize;
            cSize *= multi;
        }
        final int array = 2;
        data = new long[sizes.length][array];
        for (int i = 0; i < sizes.length; i++){
            data[i][0] = sizes[i];
            data[i][1] = times[i];
        }
        stage.setTitle("Time v Size Graph");
        final LineChart<Number, Number> lineChart = makeLineChart("Times v Size", "Size", "Runtime");
        addLines(lineChart);
        Scene s = new Scene(lineChart);
        stage.setScene(s);
        stage.show();
        try {
            saveImage(file, s);
        } catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Saving Graph");
            alert.setContentText("Error saving the graph (IO error)");
            alert.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    private void saveImage(String fileName, Scene scene) throws IOException {
        WritableImage image = scene.snapshot(null);
        File file = new File(fileName == null ? "image1.png" : fileName);
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
    }
    private LineChart<Number, Number> makeLineChart(String title, String xAxisLabel, String yAxisLabel) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel(xAxisLabel);
        yAxis.setLabel(yAxisLabel);
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAnimated(false);
        lineChart.setTitle(title);
        return lineChart;
    }
    private void addLines(LineChart<Number, Number> lineChart){
        lineChart.getData().add(makeLine("Times vs Size", data));
    }
    private XYChart.Series<Number, Number> makeLine(String label, long[][] values) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        final int x = 0;
        final int y = 1;
        for (long[] value : values) {
            series.getData().add(new XYChart.Data<>(value[x], value[y]));
        }
        series.setName(label);
        return series;
    }
}
