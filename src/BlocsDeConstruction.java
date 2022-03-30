import javafx.geometry.Rectangle2D;
import javafx.scene.image.*;


public class BlocsDeConstruction {
    private static final Image lesBlocs = new Image("Plataformas.png");
    private static int xImage = 384;
    private static int yImage = 512;
    private Rectangle2D bloc;
    private Image skin;

    public Rectangle2D getBloc() {
        return bloc;
    }

    public Image getSkin() {
        return skin;
    }

    public void setBloc(Rectangle2D bloc) {
        this.bloc = bloc;
    }

    public void setSkin(Image skin) {
        this.skin = skin;
    }

    /** Constructeur des blocs
     * avec leur skin et leur rectangle
     * */
    public BlocsDeConstruction(String nomBloc, double positionX, double positionY){
        if (nomBloc == "Bloc1") {
                this.skin = new Image("PlateformesBloc1.png");
                this.bloc = new Rectangle2D(positionX,positionY, 34, 26);}
        if (nomBloc == "Bloc2") {
                this.skin = new Image("PlateformesBloc2.png");
                this.bloc = new Rectangle2D(positionX,positionY, 34, 26);}
        if (nomBloc == "Bloc3") {
                this.skin = new Image("PlateformesBloc3.png");
                this.bloc = new Rectangle2D(positionX,positionY, 34, 26);}
    }



}

