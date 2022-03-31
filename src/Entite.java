import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Entite {

    private Rectangle2D hitBox;
    private Image image;
    protected double positionX = 25;
    protected double positionY = 520;
    protected double vitesseX;
    protected double vitesseY;
    boolean tombe;
    boolean tombeMoinsUn = true;
    protected double vitesseMaxX = 9;
    protected double vitesseMinY = 9;




    protected Entite() {
        this.hitBox = new Rectangle2D(positionX, positionY, 50,53);
    }

    public boolean getTombe() {
        return tombe;
    }

    public void setTombe(boolean tombe) {
        this.tombe = tombe;
    }
    public boolean getTombeMoinsUn() {
        return tombeMoinsUn;
    }

    public void setTombeMoinsUn(boolean tombeMoinsUn) {
        this.tombeMoinsUn = tombeMoinsUn;
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

    public double getVitesseX() {
        return vitesseX;
    }

    public double getVitesseY() {
        return vitesseY;
    }

    /** Permet au personne de chuter lorsqu'il ne se trouve pas sur un bloc
     * La chute s'arrête s'il atteint les blocs*/
    public boolean gravite(Niveau niveau){
        if(this.estSurUnBloc(niveau) == false){
            this.addVitesse(0,1);
            this.setPositionX(getPositionX()+this.vitesseX);
            this.setPositionY(getPositionY()+this.vitesseY);
            return true;
        }
        this.resetVitesse();
        return false;
    }

    /** Le plafond est déterminé par le bloc sous le personnage.
     * S'il est dépassé, la méthode retourne true.*/
    public boolean plafond(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        for (int i = 0; i < niveau.getListeBlocs().size();i++){
            if (this.typeHitBox("Pied").getMinY() < niveau.getListeBlocs().get(i).getBloc().getMinY()-100){
                return true;

            }

        }
        return false;
    }

    /** Détermine si le personne est sur un bloc ou non.*/
    protected boolean estSurUnBloc(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        boolean estSurUnBloc = false;
        for (int i = 0; i < niveau.getListeBlocs().size();i++){
            if (this.typeHitBox("Pied").intersects(niveau.getListeBlocs().get(i).getBloc())){
                estSurUnBloc = true;
            }
        }
        return estSurUnBloc;
    }

    /** A partir de la hitBox de base, retourne une plus petite zone de cette hitbox.
     * D'autres types seront ajoutés selon les besoins. */
    protected Rectangle2D typeHitBox(String typeHitBox){
        Rectangle2D correctHitBox;
        if (typeHitBox == "Pied"){
            correctHitBox = new Rectangle2D(this.hitBox.getMinX()+16,this.hitBox.getMinY()+52,33,1);
            return correctHitBox;
        }
        return this.hitBox;
    }

    /** Remet à 0 la vitesse.*/
    public void resetVitesse(){
        this.vitesseX = 0;
        this.vitesseY = 0;
    }

    /** Mise à jour de la vitesse*/
    public void addVitesse(double positionX, double positionY) {
        if ((this.vitesseX + positionX) <= this.vitesseMaxX){
            this.vitesseX = this.vitesseX + positionX;

        }

        if ((this.vitesseY + positionY) <= 420)
        this.vitesseY = this.vitesseY + positionY;
    }

}
