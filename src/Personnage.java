import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Personnage extends Entite {

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

    /** Creation de la liste d'image lorsque le personnage ne bouge pas*/
    public void setListeImageIdleDino() {
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

    public void setListImageRunDino(){
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

    protected Image getFrame(Image[] listeImage){
        if (listeImage == this.listeImageIdle){
            Image imageRetourne = listeImage[this.countImageIdle];
            if (this.countImageIdle < (listeImage.length-1)){
                setCountImageIdle(this.countImageIdle+1);
            }
            else setCountImageIdle(0);
            return imageRetourne;
        }
        else{
            Image imageRetourne = listeImage[this.countImageRun];
            if (this.countImageRun < (listeImage.length-1)){
                setCountImageRun(this.countImageRun+1);
            }
            else setCountImageRun(0);
            return imageRetourne;
        }
    }


    /** Selon la touche sur laquelle on appuie, on applique une certaine vitesse*/
    protected void deplacePerso(KeyCode keycode, Niveau niveau){
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
            if (!this.plafond(niveau)){
                this.addVitesse(0,-4);
            }
        }

        // Mise à jour des positions en fonction des vitesses
        setPositionX(getPositionX()+this.vitesseX);
        setPositionY(getPositionY()+this.vitesseY);
    }

    /** Permet de remettre à 0 la vitesse lorsque les touches sont relachées */
    protected void ralentissement (KeyCode keycode){
        if (keycode == KeyCode.D){
            this.addVitesse(-getVitesseX(),0);
        }
        if (keycode == KeyCode.Q){
            this.addVitesse(+getVitesseX(),0);
        }

        setPositionX(getPositionX()+this.vitesseX);
        setPositionY(getPositionY()+this.vitesseY);
    }

    /** Détermine si le niveau est remporté.
     * Pour cela, le personnage doit se trouver sur le bloc de fin de niveau.*/
    protected boolean remporteNiveau(Niveau niveau){
        setHitBox(new Rectangle2D(this.getPositionX(),this.getPositionY(),this.getHitBox().getWidth(), this.getHitBox().getHeight()));
            for (int i = 0; i < niveau.getListeBlocs().size();i++){
                if (this.typeHitBox("Pied").intersects(niveau.getListeBlocs().get(i).getBloc())){
                    if(niveau.getListeBlocs().get(i).getestUnBlocDeFin()){
                            return true;
                    }
                }
            }
        return false;
    }
}
