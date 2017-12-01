package photosortGUI;

import io.indico.api.utils.IndicoException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application{
    StackPane root;
    Scene scene;
    File[] FotFiles;
    List<String> photos = new ArrayList<String>();
    ListView<String> list = new ListView<>();


    public static void main (String[] args) throws IndicoException, IOException {
        launch(args);
    }

    @Override
    public void init() throws Exception{
//        Indico indico  = new Indico("ce80c3c09f3135a4a7c872c994cf0815");
//
//        String dirname = "/home/kb/Java/JavaLabs/lab6/foto";
//        File folder = new File(dirname);
//
//        if(!folder.exists()){
//            throw new FileNotFoundException();
//        }
//
//        File[] listOfFiles = folder.listFiles();
//
//        for (int i = 0; i < listOfFiles.length; i++) {
//            if (!listOfFiles[i].isFile()) {
//                throw new IllegalArgumentException();
//            }
//
//            IndicoResult single = indico.imageRecognition.predict(listOfFiles[i]);
//            Map<String,Double> result = single.getImageRecognition();
//            //System.out.println(result);
//
//            Map.Entry<String, Double> maxEntry = null;
//
//            for (Map.Entry<String, Double> entry : result.entrySet())
//            {
//                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
//                {
//                    maxEntry = entry;
//                }
//            }
//
//            String dirName=maxEntry.getKey().toString();
//
//            //Files.copy(new File ("/home/kb/Java/JavaLabs/lab6/foto"+listOfFiles[i]), new File ("/home/kb/Java/JavaLabs/lab6/foto/sorted"+"/"+listOfFiles[i]), REPLACE_EXISTING);
//            FileUtils.copyFile(listOfFiles[i], new File ("/home/kb/Java/JavaLabs/lab6/foto"+"/"+dirName+"/"+listOfFiles[i].getName()));
//
//
//        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button browse=new Button("browse");
        browse.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent event){
                DirectoryChooser chooser = new DirectoryChooser();
                chooser.setTitle("JavaFX Projects");
                File defaultDirectory = new File("/home/kb/Java/JavaLabs/lab6/foto");
                chooser.setInitialDirectory(defaultDirectory);
                File selectedDirectory = chooser.showDialog(stage);

                FotFiles = selectedDirectory.listFiles();
                for (File f : FotFiles)
                {
                    photos.add(f.getName());
                }

                displayPhoto();
            }
        });


        root=new StackPane();
        scene=new Scene(root);

        stage.setTitle("PhotoSort");
        root.getChildren().add(list);
        root.getChildren().add(browse);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(800);
        stage.show();


    }

    public void displayPhoto(){
        list.setItems(FXCollections.observableArrayList(photos));
    }
}
