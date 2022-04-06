import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Personnage extends Entite {
    boolean isDead;

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

    public boolean getIsDead(){ return isDead;}
    public void setIsDead(boolean isDead){ this.isDead = isDead;}

    /** Creation de la liste d'image lorsque le personnage ne bouge pas*/
    private void setListeImageIdleDino() {
        Image [] listeImageIdle = new Image[30];
        listeImageIdle[0] = new Image ("SpriteDinoCorrige/Idle/Idle_1.png",50,50,false, false);
        listeImageIdle[1] = listeImageIdle[0];
        listeImageIdle[2] = listeImageIdle[0];
        listeImageIdle[3] = new Image ("SpriteDinoCorrige/Idle/Idle_2.png",50,50,false, false);
        listeImageIdle[4] = listeImageIdle[3];
        listeImageIdle[5] = listeImageIdle[3];
        listeImageIdle[6] = new Image ("SpriteDinoCorrige/Idle/Idle_3.png",50,50,false, false);
        listeImageIdle[7] = listeImageIdle[6];
        listeImageIdle[8] = listeImageIdle[6];
        listeImageIdle[9] = new Image ("SpriteDinoCorrige/Idle/Idle_4.png",50,50,false, false);
        listeImageIdle[10] = listeImageIdle[9];
        listeImageIdle[11] = listeImageIdle[9];
        listeImageIdle[12] = new Image ("SpriteDinoCorrige/Idle/Idle_5.png",50,50,false, false);
        listeImageIdle[13] = listeImageIdle[12];
        listeImageIdle[14] = listeImageIdle[12];
        listeImageIdle[15] = new Image ("SpriteDinoCorrige/Idle/Idle_6.png",50,50,false, false);
        listeImageIdle[16] = listeImageIdle[15];
        listeImageIdle[17] = listeImageIdle[15];
        listeImageIdle[18] = new Image ("SpriteDinoCorrige/Idle/Idle_7.png",50,50,false, false);
        listeImageIdle[19] = listeImageIdle[18];
        listeImageIdle[20] = listeImageIdle[18];
        listeImageIdle[21] = new Image ("SpriteDinoCorrige/Idle/Idle_8.png",50,50,false, false);
        listeImageIdle[22] = listeImageIdle[21];
        listeImageIdle[23] = listeImageIdle[21];
        listeImageIdle[24] = new Image ("SpriteDinoCorrige/Idle/Idle_9.png",50,50,false, false);
        listeImageIdle[25] = listeImageIdle[24];
        listeImageIdle[26] = listeImageIdle[24];
        listeImageIdle[27] = new Image ("SpriteDinoCorrige/Idle/Idle_10.png",50,50,false, false);
        listeImageIdle[28] = listeImageIdle[27];
        listeImageIdle[29] = listeImageIdle[27];

        this.listeImageIdle = listeImageIdle;
    }
    /** Creation de la liste d'image lorsque le personne se déplace vers la droite.*/
    private void setListImageRunDino(){
        Image [] listeImageRun= new Image[32];
        listeImageRun[0] = new Image ("SpriteDinoCorrige/Run/Run_1.png",50,50,false, false);
        listeImageRun[1] = listeImageRun[0];
        listeImageRun[2] = listeImageRun[0];
        listeImageRun[3] = listeImageRun[0];
        listeImageRun[4] = new Image ("SpriteDinoCorrige/Run/Run_2.png",50,50,false, false);
        listeImageRun[5] = listeImageRun[4];
        listeImageRun[6] = listeImageRun[4];
        listeImageRun[7] = listeImageRun[4];
        listeImageRun[8] = new Image ("SpriteDinoCorrige/Run/Run_3.png",50,50,false, false);
        listeImageRun[9] = listeImageRun[8];
        listeImageRun[10] = listeImageRun[8];
        listeImageRun[11] = listeImageRun[8];
        listeImageRun[12] = new Image ("SpriteDinoCorrige/Run/Run_4.png",50,50,false, false);
        listeImageRun[13] = listeImageRun[12];
        listeImageRun[14] = listeImageRun[12];
        listeImageRun[15] = listeImageRun[12];
        listeImageRun[16] = new Image ("SpriteDinoCorrige/Run/Run_5.png",50,50,false, false);
        listeImageRun[17] = listeImageRun[16];
        listeImageRun[18] = listeImageRun[16];
        listeImageRun[19] = listeImageRun[16];
        listeImageRun[20] = new Image ("SpriteDinoCorrige/Run/Run_6.png",50,50,false, false);
        listeImageRun[21] = listeImageRun[20];
        listeImageRun[22] = listeImageRun[20];
        listeImageRun[23] = listeImageRun[20];
        listeImageRun[24] = new Image ("SpriteDinoCorrige/Run/Run_7.png",50,50,false, false);
        listeImageRun[25] = listeImageRun[24];
        listeImageRun[26] = listeImageRun[24];
        listeImageRun[27] = listeImageRun[24];
        listeImageRun[28] = new Image ("SpriteDinoCorrige/Run/Run_8.png",50,50,false, false);
        listeImageRun[29] = listeImageRun[28];
        listeImageRun[30] = listeImageRun[28];
        listeImageRun[31] = listeImageRun[28];

        this.listeImageRun = listeImageRun;
    }

    /** Creation de la liste d'image lorsque le personne se déplace vers la gauche.*/
    private void setListImageRunDinoR(){
        Image [] listeImageRunR= new Image[32];
        listeImageRunR[0] = new Image ("SpriteDinoCorrige/Run/Run_1R.png",50,50,false, false);
        listeImageRunR[1] = listeImageRunR[0];
        listeImageRunR[2] = listeImageRunR[0];
        listeImageRunR[3] = listeImageRunR[0];
        listeImageRunR[4] = new Image ("SpriteDinoCorrige/Run/Run_2R.png",50,50,false, false);
        listeImageRunR[5] = listeImageRunR[4];
        listeImageRunR[6] = listeImageRunR[4];
        listeImageRunR[7] = listeImageRunR[4];
        listeImageRunR[8] = new Image ("SpriteDinoCorrige/Run/Run_3R.png",50,50,false, false);
        listeImageRunR[9] = listeImageRunR[8];
        listeImageRunR[10] = listeImageRunR[8];
        listeImageRunR[11] = listeImageRunR[8];
        listeImageRunR[12] = new Image ("SpriteDinoCorrige/Run/Run_4R.png",50,50,false, false);
        listeImageRunR[13] = listeImageRunR[12];
        listeImageRunR[14] = listeImageRunR[12];
        listeImageRunR[15] = listeImageRunR[12];
        listeImageRunR[16] = new Image ("SpriteDinoCorrige/Run/Run_5R.png",50,50,false, false);
        listeImageRunR[17] = listeImageRunR[16];
        listeImageRunR[18] = listeImageRunR[16];
        listeImageRunR[19] = listeImageRunR[16];
        listeImageRunR[20] = new Image ("SpriteDinoCorrige/Run/Run_6R.png",50,50,false, false);
        listeImageRunR[21] = listeImageRunR[20];
        listeImageRunR[22] = listeImageRunR[20];
        listeImageRunR[23] = listeImageRunR[20];
        listeImageRunR[24] = new Image ("SpriteDinoCorrige/Run/Run_7R.png",50,50,false, false);
        listeImageRunR[25] = listeImageRunR[24];
        listeImageRunR[26] = listeImageRunR[24];
        listeImageRunR[27] = listeImageRunR[24];
        listeImageRunR[28] = new Image ("SpriteDinoCorrige/Run/Run_8R.png",50,50,false, false);
        listeImageRunR[29] = listeImageRunR[28];
        listeImageRunR[30] = listeImageRunR[28];
        listeImageRunR[31] = listeImageRunR[28];

        this.listeImageRunR = listeImageRunR;
    }

    private void setListImageDeadDino(){
        Image [] listeImageDead= new Image[32];
        listeImageDead[0] = new Image ("SpriteDinoCorrige/Dead/Dead_1.png",50,50,false, false);
        listeImageDead[1] = listeImageDead[0];
        listeImageDead[2] = listeImageDead[0];
        listeImageDead[3] = listeImageDead[0];
        listeImageDead[4] = new Image ("SpriteDinoCorrige/Dead/Dead_2.png",50,50,false, false);
        listeImageDead[5] = listeImageDead[4];
        listeImageDead[6] = listeImageDead[4];
        listeImageDead[7] = listeImageDead[4];
        listeImageDead[8] = new Image ("SpriteDinoCorrige/Dead/Dead_3.png",50,50,false, false);
        listeImageDead[9] = listeImageDead[8];
        listeImageDead[10] = listeImageDead[8];
        listeImageDead[11] = listeImageDead[8];
        listeImageDead[12] = new Image ("SpriteDinoCorrige/Dead/Dead_4.png",50,50,false, false);
        listeImageDead[13] = listeImageDead[12];
        listeImageDead[14] = listeImageDead[12];
        listeImageDead[15] = listeImageDead[12];
        listeImageDead[16] = new Image ("SpriteDinoCorrige/Dead/Dead_5.png",50,50,false, false);
        listeImageDead[17] = listeImageDead[16];
        listeImageDead[18] = listeImageDead[16];
        listeImageDead[19] = listeImageDead[16];
        listeImageDead[20] = new Image ("SpriteDinoCorrige/Dead/Dead_6.png",50,50,false, false);
        listeImageDead[21] = listeImageDead[20];
        listeImageDead[22] = listeImageDead[20];
        listeImageDead[23] = listeImageDead[20];
        listeImageDead[24] = new Image ("SpriteDinoCorrige/Dead/Dead_7.png",50,50,false, false);
        listeImageDead[25] = listeImageDead[24];
        listeImageDead[26] = listeImageDead[24];
        listeImageDead[27] = listeImageDead[24];
        listeImageDead[28] = new Image ("SpriteDinoCorrige/Dead/Dead_8.png",50,50,false, false);
        listeImageDead[29] = listeImageDead[28];
        listeImageDead[30] = listeImageDead[28];
        listeImageDead[31] = listeImageDead[28];

        this.listeImageDead = listeImageDead;
    }

    public void chargementFrame(){
        this.setListeImageIdleDino();
        this.setListImageRunDino();
        this.setListImageRunDinoR();
        this.setListImageDeadDino();
    }

    /** Méthode appelée à chaque boucle de l'animation
     * Image renvoyée en fonction de la liste et du compteur d'image*/
    protected Image getFrame(Image[] listeImage){
        Image imageRetourne;
        if (listeImage == this.listeImageIdle){
            imageRetourne = listeImage[this.countImageIdle];
            if (this.countImageIdle < (listeImage.length-1)) setCountImageIdle(this.countImageIdle+1);
            else setCountImageIdle(0);
        }

        else if(listeImage == this.listeImageDead){
            imageRetourne = listeImage[this.countImageDead];
            if(this.countImageDead < (listeImage.length-1)) setCountImageDead(this.countImageDead+1);
            else setCountImageDead(0);
        }

        else if (listeImage == this.listeImageRunR){
            imageRetourne = listeImage[this.countImageRunR];
            if (this.countImageRunR < (listeImage.length-1)) setCountImageRunR(this.countImageRunR+1);
            else setCountImageRunR(0);
        }
        else{
            imageRetourne = listeImage[this.countImageRun];
            if (this.countImageRun < (listeImage.length-1)) setCountImageRun(this.countImageRun+1);
            else setCountImageRun(0);
        }
        return imageRetourne;
    }


    /** Selon la touche sur laquelle on appuie, on applique une certaine vitesse*/
    protected void deplacePerso(KeyCode keycode, Niveau niveau){
        if(!this.getIsDead()) {
            if (keycode == KeyCode.D) this.addVitesse(4, 0); // Ajout d'une vitesse vers la droite

            if (keycode == KeyCode.Q) this.addVitesse(-4, 0); // Ajout d'une vitesse vers la gauche

            if (keycode == KeyCode.R) { // Réinitialise la position du personnage
                setPositionX(20);
                setPositionY(450);
            }

            // Permet le saut si le personnage se trouve sous le "plafond"
            if (keycode == KeyCode.Z) {
                if (!this.plafond(niveau) && blocEnDessous(niveau)) {
                    this.addVitesse(0, -4);
                }
            }
        }
        // Mise à jour des positions en fonction des vitesses
        setPositionX(getPositionX()+this.vitesseX);
        setPositionY(getPositionY()+this.vitesseY);
    }

    /** Permet de remettre à 0 la vitesse lorsque les touches sont relachées */
    protected void ralentissement (KeyCode keycode){
        if (keycode == KeyCode.D) this.addVitesse(-getVitesseX(),0);

        if (keycode == KeyCode.Q) this.addVitesse(-getVitesseX(),0);

        setPositionX(getPositionX()+this.vitesseX);
        setPositionY(getPositionY()+this.vitesseY);
    }

    /** Détermine si le niveau est remporté.
     * Pour cela, le personnage doit se trouver sur le bloc de fin de niveau.*/
    protected boolean remporteNiveau(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
            for (int i = 0; i < niveau.getListeBlocs().size();i++){
                if (this.typeHitBox("Pied").intersects(niveau.getListeBlocs().get(i).getBloc())){
                    if(niveau.getListeBlocs().get(i).getestUnBlocDeFin()) return true;
                }
            }
        return false;
    }

}
