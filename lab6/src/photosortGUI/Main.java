package photosortGUI;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main extends Application{
    Pane root;
    Scene scene;
    File[] FotFiles;
    List<String> photos = new ArrayList<String>();
    ListView<String> list = new ListView<>();
    String photo;
    Image image;
    File selectedDirectory;
    double percentage;


    public static void main (String[] args) throws IndicoException, IOException {
        launch(args);
    }

    @Override
    public void init() throws Exception{
        Indico indico  = new Indico("ce80c3c09f3135a4a7c872c994cf0815");

        String dirname = "/home/kb/Java/JavaLabs/lab6/foto";
        File folder = new File(dirname);

        if(!folder.exists()){
            throw new FileNotFoundException();
        }

        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (!listOfFiles[i].isFile()) {
                throw new IllegalArgumentException();
            }

            IndicoResult single = indico.imageRecognition.predict(listOfFiles[i]);
            Map<String,Double> result = single.getImageRecognition();
            //System.out.println(result);

            Map.Entry<String, Double> maxEntry = null;

            for (Map.Entry<String, Double> entry : result.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            String dirName=maxEntry.getKey().toString();
            percentage=maxEntry.getValue();

            //Files.copy(new File ("/home/kb/Java/JavaLabs/lab6/foto"+listOfFiles[i]), new File ("/home/kb/Java/JavaLabs/lab6/foto/sorted"+"/"+listOfFiles[i]), REPLACE_EXISTING);
            FileUtils.copyFile(listOfFiles[i], new File ("/home/kb/Java/JavaLabs/lab6/foto"+"/"+dirName+"/"+listOfFiles[i].getName()));


        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button browse=new Button("browse");
        browse.setLayoutX(700);
        browse.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent event){
                DirectoryChooser chooser = new DirectoryChooser();
                chooser.setTitle("JavaFX Projects");
                File defaultDirectory = new File("/home/kb/Java/JavaLabs/lab6/foto");
                chooser.setInitialDirectory(defaultDirectory);
                selectedDirectory = chooser.showDialog(stage);

                FotFiles = selectedDirectory.listFiles();
                for (File f : FotFiles)
                {
                    photos.add(f.getName());
                }

                displayPhoto();
            }
        });


        root=new Pane();
        scene=new Scene(root);

        stage.setTitle("PhotoSort");
        root.getChildren().add(browse);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(800);
        stage.show();


    }

    public void displayPhoto() {
        list.setItems(FXCollections.observableArrayList(photos));
        list.setMaxSize(200,80);
        list.setLayoutY(0);
        list.setLayoutX(0);
        root.getChildren().add(list);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                photo=newValue;
                System.out.println(photo);
                    try {
                        image=new Image(new FileInputStream("/home/kb/Java/JavaLabs/lab6/foto/"+selectedDirectory.getName()+"/"+newValue));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ImageView imageView = new ImageView(image);
                    imageView.setLayoutX(10);
                    imageView.setLayoutY(250);
                    root.getChildren().add(imageView);

                    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList
                            (new PieChart.Data(photo,percentage), new PieChart.Data("",1-percentage));
                    final PieChart chart = new PieChart(pieChartData);
                    chart.setLayoutX(600);
                    chart.setLayoutY(300);
                    chart.setMaxSize(100,100);
                    root.getChildren().add(chart);

            }
        });
    }
}
