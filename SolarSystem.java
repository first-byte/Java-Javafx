import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Math;
import javafx.util.Duration;

public class SolarSystem extends Application{
	public static void main(String[] args){
		launch(args);
	}

	
	public void start(Stage stage){
		stage.setTitle("Hello, universe!");
        AnchorPane anchorPane = new AnchorPane();
		BorderPane borderPane = new BorderPane();
		borderPane.setRight(anchorPane);
	  	stage.setScene(new Scene(borderPane, 1000, 1000));
		
		Image image = new Image("file:stars.jpg");		  
		ImageView imView = new ImageView();
	    imView.setImage(image);	
		anchorPane.getChildren().add(imView);
		
		addButtons(borderPane, anchorPane);
		stage.show();
	}	


	private static void addButtons(BorderPane borderPane, AnchorPane anchorPane) {
		Button create = new Button("Create");
		Button start = new Button("Start");
		Button clear = new Button("Clear");
		Button stop = new Button("Stop");
	
		VBox buttonBox = new VBox();
		buttonBox.getChildren().addAll(radiusLabel, 
				slider, create, clear, start, stop);
		borderPane.setLeft(buttonBox);		
	
		start.setPrefWidth(140);
		create.setPrefWidth(140);		
		clear.setPrefWidth(140);
		stop.setPrefWidth(140);
		
		Label radiusLabel = new Label("Radius");
		Slider slider = new Slider(0, 100, 1);
		
		ArrayList<CelestialBody> neighborhood = new ArrayList<>();
		
		clear.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
        		neighborhood.remove(neighborhood.size() - 1);
				anchorPane.getChildren().remove(anchorPane.getChildren().size() - 1);
    		}
		});
		
		create.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				double radius = slider.getValue();
				CelestialBody body = whichBody(radius, anchorPane);
				neighborhood.add(body);
			}
		});

		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				for (CelestialBody body : neighborhood) {
					if (body.getClass() == Planet.class) {
						Planet planet = (Planet) body;
						
						double x = (430 - planet.sphere.getLayoutX());
					    double y = (430 - planet.sphere.getLayoutY());
						double radius = Math.pow(x*x + y*y, 0.5);	
						Ellipse ellipse = new Ellipse(x, y, radius, radius);
					    planet.pathTransition.setPath(ellipse);	
						
						planet.pathTransition.setDuration(Duration.seconds(
									Math.pow(Math.pow(radius, 3), 0.5))); 
						planet.pathTransition.play();
					}
				}
			}	
		});
	
		stop.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				for (CelestialBody body : neighborhood) {
					if (body.getClass() == Planet.class) {
						Planet planet = (Planet) body;
						planet.pathTransition.stop();	
					}
				}
			}
		});

	
	}


	private static CelestialBody whichBody(double radius, AnchorPane anchorPane) {	
		if (radius > 50) {
			return new Star(radius, anchorPane);
		} else {
			return new Planet(radius, anchorPane);
		}
	}
}
