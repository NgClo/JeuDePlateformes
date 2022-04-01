import javafx.geometry.Rectangle2D;
import javafx.scene.image.*;

import java.util.Objects;

public class BlocsDeConstruction {
    private final Rectangle2D bloc;
    private Image skin;
    private boolean estUnBlocDeFin;

    public Rectangle2D getBloc() {
        return bloc;
    }

    public Image getSkin() {
        return skin;
    }

    public boolean getestUnBlocDeFin(){return estUnBlocDeFin;}

    public void setEstUnBlocDeFin(boolean estUnBlocDeFin) {
        this.estUnBlocDeFin = estUnBlocDeFin;
    }

    /** Constructeur des blocs
     * avec leur skin et leur rectangle
     * ET l'information du bloc de fin. */
    public BlocsDeConstruction(String nomBloc, double positionX, double positionY, boolean estUnBlocDeFin){
        this.estUnBlocDeFin = estUnBlocDeFin;
        this.bloc = new Rectangle2D(positionX,positionY, 34, 26); // Tous les blocs ont la même taille (34*26)
        if (Objects.equals(nomBloc, "Bloc1")) {
                this.skin = new Image("PlateformesBloc1.png");}
        if (Objects.equals(nomBloc, "Bloc2")) {
            this.skin = new Image("PlateformesBloc2.png");}
        if (Objects.equals(nomBloc, "Bloc3")) {
                this.skin = new Image("PlateformesBloc3.png");}
        }
    /** Constructeur des blocs
     * avec leur skin et leur rectangle. */
    public BlocsDeConstruction(String nomBloc, double positionX, double positionY){
        this.bloc = new Rectangle2D(positionX,positionY, 34, 26);
        if (Objects.equals(nomBloc, "Bloc1")) {
            this.skin = new Image("PlateformesBloc1.png");}
        if (Objects.equals(nomBloc, "Bloc2")) {
            this.skin = new Image("PlateformesBloc2.png");}
        if (Objects.equals(nomBloc, "Bloc3")) {
            this.skin = new Image("PlateformesBloc3.png");}
    }
}

