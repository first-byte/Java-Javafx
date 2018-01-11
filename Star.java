import javafx.scene.shape.Sphere;
import javafx.scene.layout.AnchorPane;
import javafx.scene.PointLight;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class Star extends CelestialBody {
	private PointLight light;	
	
	public Star(double radius, AnchorPane pane) {
		super(radius, pane);
		PhongMaterial material = new PhongMaterial();
		material.setSelfIlluminationMap(pickSunColor(radius));
		sphere.setMaterial(material);
		
		light = new PointLight();
		light.setTranslateZ(-75);
		pane.getChildren().add(light);
		
		pane.setOnMouseMoved(new EventHandler<MouseEvent>(){
			public void handle (MouseEvent event) {
				sphere.setLayoutX(event.getX());
				sphere.setLayoutY(event.getY());
				light.setLayoutX(event.getX());
				light.setLayoutY(event.getY());
			}
		});	
	}


	private Image pickSunColor(double radius){
		if (radius >= 50 && radius < 57) {
			return new Image("file:red.jpg");
		} else if (radius >= 57 && radius < 64) {
			return new Image("file:sun1.jpg");
		} else if (radius >= 64 && radius < 71) {
			return new Image("file:sun.jpg");
		} else if (radius >= 71 && radius < 78) {
			return new Image("file:yellow.jpg");
		} else if (radius > 78 && radius <= 85) {
			return new Image("file:yellowstar.jpg");
		} else if (radius >	85 && radius <= 92) {
			return new Image("file:white.jpg");
		} else {
			return new Image("file:blue.jpg");
		}
	}
}
