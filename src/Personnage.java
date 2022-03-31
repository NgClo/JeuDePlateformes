import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Personnage extends Entite {

    private Image image;
    private int countObjet;
    private double masse;


    Personnage(){
        super();
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    protected void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    protected void setPositionY(double positionY) {
        this.positionY = positionY;
    }




    @Override
    public Image getImage() {
        return new Image("SpriteDinoCorrige/Idle_1.png",50,53,false, false);
    }

    /** Selon la touche sur laquelle on appuie, on applique une certaine vitesse*/
    public void deplacePerso(KeyCode keycode, Niveau niveau){
        if (keycode == KeyCode.D){
            this.addVitesse(4,0); // Ajout d'une vitesse vers la droite
        }
        if (keycode == KeyCode.Q){
            this.addVitesse(-4,0); // Ajout d'une vitesse vers la gauche
        }

        if (keycode == KeyCode.R){ // Réinitialise la position du personnage
            setPositionX(20);
            setPositionY(450);
        }

        // Permet le saut si le personnage se trouve sous le "plafond"
        if (keycode == KeyCode.Z){
            if (this.plafond(niveau) == false){
                this.addVitesse(0,-15);
            }
        }

        // Mise à jour des positions en fonction des vitesses
        setPositionX(getPositionX()+this.vitesseX);
        setPositionY(getPositionY()+this.vitesseY);

    }

    /** Permet de remettre à 0 la vitesse lorsque les touches sont relachées */
    public void ralentissement (KeyCode keycode, Niveau niveau){
        if (keycode == KeyCode.D){
            //setPositionX(getPositionX()+4);
            this.addVitesse(-getVitesseX(),0);
        }
        if (keycode == KeyCode.Q){
            //setPositionX(getPositionX()-4);
            this.addVitesse(+getVitesseX(),0);
        }

        setPositionX(getPositionX()+this.vitesseX);
        setPositionY(getPositionY()+this.vitesseY);
    }


}