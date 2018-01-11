import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;
import javafx.animation.PathTransition;
import java.lang.Math;
import javafx.scene.shape.Ellipse;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition.OrientationType;

public class Planet extends CelestialBody {
	public PathTransition pathTransition;

	public Planet (double radius, AnchorPane pane) {
		super(radius, pane);
		PhongMaterial material = new PhongMaterial();
		material.setDiffuseMap(pickPlanetColor(radius));
		sphere.setMaterial(material);		
		pathTransition = new PathTransition();
		pathTransition.setNode(sphere);
		pathTransition.setCycleCount(-1);
		pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setInterpolator(Interpolator.LINEAR);
	}

	
	private Image pickPlanetColor(double radius){
		if (radius >= 0 && radius < 2){
			return new Image("file:y.jpg");
		} else if (radius >= 2 && radius < 4) {
			return new Image("file:x.jpg");
		} else if (radius >= 4 && radius < 6) {
			return new Image("file:w.jpg");
		} else if (radius >= 6 && radius < 8) {
			return new Image("file:v.jpg");
		} else if (radius >= 8 && radius < 10) {
			return new Image("file:u.jpg");
		} else if (radius >= 10 && radius < 12) {
			return new Image("file:t.jpg");
		} else if (radius >= 12 && radius < 14) {
			return new Image("file:s.jpg");
		} else if (radius >= 14 && radius < 16) {
			return new Image("file:r.jpg");
		} else if (radius >= 16 && radius < 18) {
			return new Image("file:q.jpg");
		} else if (radius >= 18 && radius < 20) {
			return new Image("file:p.jpg");
		} else if (radius >= 20 && radius < 22) {
			return new Image("file:o.jpg");
		} else if (radius >= 22 && radius < 24) {
			return new Image("file:n.jpg");
		} else if (radius >= 24 && radius < 26) {
			return new Image("file:m.jpg");
		} else if (radius >= 26 && radius < 28) {
			return new Image("file:l.jpg");
		} else if (radius >= 28 && radius < 30) {
			return new Image("file:k.jpg");
		} else if (radius >= 30 && radius < 32) {
			return new Image("file:j.jpg");
		} else if (radius >= 32 && radius < 34) {
			return new Image("file:i.jpg");
		} else if (radius >= 34  && radius < 36) {
			return new Image("file:h.jpg");
		} else if (radius >= 36 && radius < 38) {
			return new Image("file:g.jpg");
		} else if (radius >= 38 && radius < 40) {
			return new Image("file:f.jpg");
		} else if (radius >= 40 && radius < 42) {
			return new Image("file:e.jpg");
		} else if (radius >= 42 && radius < 44) {
			return new Image("file:d.jpg");
		} else if (radius >= 44 && radius < 46) {
			return new Image("file:c.jpg");
		} else if (radius >= 46 && radius < 48) {
			return new Image("file:b.jpg");
		} else {
			return new Image("file:a.jpg");
		}
	}
}
