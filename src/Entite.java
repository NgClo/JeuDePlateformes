import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Entite {

    private Rectangle2D hitBox;
    private Image image;
    protected double positionX = 25;
    protected double positionY = 520;


    protected Entite() {
        this.hitBox = new Rectangle2D(positionX, positionY, 50,53);
    }

    public Image getImage() {
        return image;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getPositionX() {
        return positionX;
    }

    public Rectangle2D getHitBox() {
        return hitBox;
    }

    private void setHitBox(Rectangle2D hitBox) {
        this.hitBox = hitBox;
    }

    private void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    private void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void modifierPosition(Entite entite, double newX, double newY){
        entite.setPositionX(entite.getPositionX()+newX);
        entite.setPositionY(entite.getPositionY()+newY);

    }

    public void gravite(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        boolean estSurUnBloc = false;
        for (int i = 0; i < niveau.getListeBlocs().size();i++){
            if (this.hitBox.intersects(niveau.getListeBlocs().get(i).getBloc())){
                estSurUnBloc = true;
            }
        }
        if (estSurUnBloc == false){
            modifierPosition(this,0,5);
        }
    }



}
