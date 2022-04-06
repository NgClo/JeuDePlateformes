import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.util.Objects;

public class Entite {

    private Rectangle2D hitBox;
    protected double positionX = 25;
    protected double positionY = 520;
    protected double vitesseX;
    protected double vitesseY;
    boolean tombe;
    boolean tombeMoinsUn = true;
    protected double vitesseMaxX = 9;
    protected double vitesseMinY = 9;
    protected Image[] listeImageIdle;
    protected Image[] listeImageRun;
    protected Image[] listeImageRunR;
    Image[] listeImageDead;
    protected int countImageIdle;
    protected int countImageRun;
    protected int countImageRunR;
    int countImageDead;

    protected void setCountImageIdle(int countImage) {
        this.countImageIdle = countImage;
    }
    protected void setCountImageRun(int countImage) {
        this.countImageRun = countImage;
    }
    protected void setCountImageRunR(int countImageRunR) { this.countImageRunR = countImageRunR;}
    public void setCountImageDead(int countImageDead) {this.countImageDead = countImageDead;}

    public int getCountImageDead() {return countImageDead;}

    protected Entite() {
        this.hitBox = new Rectangle2D(positionX, positionY, 50,53);
    }

    public boolean getTombe() {
        return tombe;
    }

    protected void setTombe(boolean tombe) {
        this.tombe = tombe;
    }

    public boolean getTombeMoinsUn() {
        return tombeMoinsUn;
    }

    protected void setTombeMoinsUn(boolean tombeMoinsUn) {
        this.tombeMoinsUn = tombeMoinsUn;
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

    protected void setHitBox(Rectangle2D hitBox) {
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

    /** Permet au personne de chuter lorsqu'il ne se trouve pas sur un bloc
     * La chute s'arrête s'il atteint les blocs*/
    public boolean gravite(Niveau niveau){
        if(!this.estSurUnBloc(niveau)){
            this.addVitesse(0,0.2);
            this.setPositionX(getPositionX()+this.vitesseX);
            this.setPositionY(getPositionY()+this.vitesseY);
            return true;
        }
        return false;
    }

    /** Le plafond est déterminé par le bloc sous le personnage.
     * S'il est dépassé, la méthode retourne true.*/
    protected boolean plafond(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        for (int i = 0; i < niveau.getListeBlocs().size();i++){
            if (this.typeHitBox("Pied").getMinY() < niveau.getListeBlocs().get(i).getBloc().getMinY()-100){
                    if (niveau.getListeBlocs().get(i).getBloc().contains(getPositionX(),niveau.getListeBlocs().get(i).getBloc().getMinY())){
                        return true;}
            }
        }
        return false;
    }

    public boolean blocEnDessous(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
            for (int i = 0; i < niveau.getListeBlocs().size();i++){
                if(niveau.getListeBlocs().get(i).getBloc().contains(this.typeHitBox("Pied").getMinX(),niveau.getListeBlocs().get(i).getBloc().getMaxY())
                || niveau.getListeBlocs().get(i).getBloc().contains(this.typeHitBox("Pied").getMaxX(),niveau.getListeBlocs().get(i).getBloc().getMaxY() ))
                    if(this.getPositionY() <= niveau.getListeBlocs().get(i).getBloc().getMinY())
                    return true;
            }
            return false;

    }

    /** Détermine si le personnage est sur un bloc ou non.*/
    protected boolean estSurUnBloc(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        boolean estSurUnBloc = false;
        for (int i = 0; i < niveau.getListeBlocs().size();i++){
            if (this.typeHitBox("Pied").intersects(niveau.getListeBlocs().get(i).getBloc())) estSurUnBloc = true;
        }
        return estSurUnBloc;
    }

    public boolean estSurUnPike(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        boolean estSurUnBlocPikes = false;
        for (int i = 0; i < niveau.getListeBlocs().size();i++){
            if (this.typeHitBox("Pied").intersects(niveau.getListeBlocs().get(i).getBloc()))
                if(niveau.getListeBlocs().get(i).getEstUnBlocPikes()) estSurUnBlocPikes = true;
        }
        return estSurUnBlocPikes;
    }

    /** A partir de la hitBox de base, retourne une plus petite zone de cette hitbox.
     * D'autres types seront ajoutés selon les besoins, notamment pour la hitbox avec les ennemis. */
    protected Rectangle2D typeHitBox(String typeHitBox){
        Rectangle2D correctHitBox;
        if (Objects.equals(typeHitBox, "Pied")){
            correctHitBox = new Rectangle2D(this.hitBox.getMinX()+20,this.hitBox.getMinY()+45,10,5);
            return correctHitBox;
        }
        return this.hitBox;
    }

    /** Remet à 0 la vitesse.*/
    protected void resetVitesse(){
        this.vitesseX = 0;
        this.vitesseY = 0;
    }

    /** Mise à jour de la vitesse sous réserve qu'elle est inférieure à la vitesse max*/
    protected void addVitesse(double positionX, double positionY) {
        if ((this.vitesseX + positionX) <= this.vitesseMaxX && (this.vitesseX+positionX) >= this.vitesseMaxX *(-1)){
            this.vitesseX = this.vitesseX + positionX;
        }

        if ((this.vitesseY + positionY) <= this.vitesseMinY && (this.vitesseY + positionY) >= this.vitesseMinY * (-1))
        this.vitesseY = this.vitesseY + positionY;
    }

    /** Renvoie le " bloc " (Rectangle2D uniquement) sur lequel se trouve le personnage */
    protected Rectangle2D surQuelBloc(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        for (int i = 0; i < niveau.getListeBlocs().size();i++) {
            if (this.typeHitBox("Pied").intersects(niveau.getListeBlocs().get(i).getBloc())) {
                return niveau.getListeBlocs().get(i).getBloc();
            }
        }
        return niveau.getListeBlocs().get(0).getBloc();
    }

    /** Renvoie la valeur d'écart entre le bloc de dessous et le personnage*/
    protected double ecartPlateforme(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
        for (int i = 0; i < niveau.getListeBlocs().size();i++) {
            if (niveau.getListeBlocs().get(i).getBloc().contains(this.getPositionX(),niveau.getListeBlocs().get(i).getBloc().getMinY())){
                return (this.hitBox.getMaxY() - niveau.getListeBlocs().get(i).getBloc().getMinY());
            }
        }
        return 0;
    }
}
