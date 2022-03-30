import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Personnage extends Entite {

    private Image image;
    private int countObjet;
    private double masse;
    private double v;
    private double a;




    Personnage(){
        super();
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public Image getImage() {
        return new Image("SpriteDinoCorrige/Idle_1.png",50,53,false, false);
    }

    public void deplacePerso(KeyCode keycode){
        if (keycode == KeyCode.D){
            setPositionX(getPositionX()+2);
        }
        if (keycode == KeyCode.Q){
            setPositionX(getPositionX()-2);
        }
        if (keycode == KeyCode.R){
            setPositionX(20);
            setPositionY(100);
        }
    }


}

   /*          Personnage perso = new Personnage(Entite.determineHitBox(image),image);*/