package polynomial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PolyDraw extends Application {
    TextField coefficients, sampling, min, max;
    Text ymin, ymax, xmin, xmax;
    Button calculate;
    Group root;
    Scene scene;
    Canvas plot;
    Drawer drawer;

    @Override
    public void init() throws Exception {
        drawer = new Drawer(this);
    }

    @Override
    public void start(Stage stage) throws Exception {
        coefficients = new TextField();
        coefficients.setLayoutX(50);
        coefficients.setLayoutY(310);
        sampling = new TextField();
        sampling.setLayoutX(300);
        sampling.setLayoutY(310);


        calculate = new Button("calculate");
        calculate.setLayoutX(550);
        calculate.setLayoutY(310);

        calculate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent event){
                drawer.draw();
            }
        });


        plot = new Canvas();
        plot.setHeight(300);
        plot.setWidth(600);
        //plot.setLayoutX(200);
        //plot.setLayoutY(20);
        GraphicsContext gc = plot.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        gc.fillOval(0, 0, 30, 30);

        root = new Group(coefficients, sampling, calculate, plot);
        scene = new Scene(root, 800, 400);
        stage.setTitle("Polynomial");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String args[]){
        launch(args);
    }
}
