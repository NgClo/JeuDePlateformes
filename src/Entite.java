import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Entite {

    Rectangle2D hitBox;
    Image image;
    double positionX = 25;
    double positionY = 520;

    public Entite() {
        this.hitBox = new Rectangle2D(positionX, positionY, 365,389);
    }

    public Image getImage() {
        return image;
    }

    public void modifierPosition(Personnage perso, double newX, double newY){
        perso.setPositionX(perso.getPositionX()+newX);
        perso.setPositionY(perso.getPositionY()+newY);

    }



}
