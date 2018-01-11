import javafx.scene.shape.Sphere;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class CelestialBody {
	public Sphere sphere;
		
	public CelestialBody(double radius, AnchorPane pane) {
		sphere = new Sphere(radius);
		pane.getChildren().add(sphere);
	
		pane.setOnMouseMoved(new EventHandler<MouseEvent>(){
			public void handle (MouseEvent event) {
				sphere.setLayoutX(event.getX());
				sphere.setLayoutY(event.getY());
			}
		});	
	
		sphere.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {	
			public void handle (MouseEvent event) {
				pane.setOnMouseMoved(new EventHandler<MouseEvent>(){
					public void handle (MouseEvent event) {}
				});
			}	
		});        
	}
}
