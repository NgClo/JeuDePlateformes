import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.ArrayList;


public class Niveau {
    private static final Image fondEcran = new Image("2224.png");
    private ArrayList <BlocsDeConstruction> listeBlocs; // Liste des blocs dans un niveau
    private final Personnage perso;

    public Niveau(Personnage perso){
        this.perso = perso;
        }

    public ArrayList<BlocsDeConstruction> getListeBlocs() {
        return listeBlocs;
    }

    /** Permet de construire une " plateforme ",
     * avec un bloc de début, un certain nombre de blocs au total et un bloc de fin.*/
    private ArrayList<BlocsDeConstruction> constrPlateformes(int positionX, int positionY, int nombreBlocs){
        ArrayList <BlocsDeConstruction> listeBlocsPlateforme = new ArrayList<>();
        int intervalle = 33;
        listeBlocsPlateforme.add(new BlocsDeConstruction("Bloc1", intervalle *positionX,positionY));
        for (int i = 0; i < nombreBlocs-3; i++){
            listeBlocsPlateforme.add(new BlocsDeConstruction("Bloc3", intervalle * (positionX+1+i),positionY));
        }
        listeBlocsPlateforme.add(new BlocsDeConstruction("Bloc2", intervalle * (positionX + nombreBlocs-2),positionY-1));
        return listeBlocsPlateforme;
    }

    /** Construction du niveau 1
     * avec placement des blocs
     * et placement du personnage
     */
    public void constructionPremierNiveau() {
        // Mise en place des blocs en les ajoutant dans la liste des blocs
        this.listeBlocs = new ArrayList<>();
        this.listeBlocs.addAll(constrPlateformes(0,630,5));
        this.listeBlocs.addAll(constrPlateformes(10,630,8));

        this.listeBlocs.addAll(constrPlateformes(6,520,4));

        this.listeBlocs.addAll(constrPlateformes(20,630,13));

        this.listeBlocs.get(this.listeBlocs.size()-1).setEstUnBlocDeFin(true); // Le dernier bloc ajouté à la liste est le bloc de fin

        this.perso.setPositionX(20);
        this.perso.setPositionY(450);
    }


    /** Permet de dessiner le niveau en fonction de la position du personnage
     * Les blocs sont dans une liste associée au niveau et cette liste est récupérée pour redessiner le niveau.*/
    public void drawNiveau(Canvas canvasNiveau,  double X, double Y){
        GraphicsContext gcDraw = canvasNiveau.getGraphicsContext2D();

        gcDraw.drawImage(fondEcran, 0, 0,1000,650);

        // Boucle qui passe en revue tous les blocs de la liste et les dessine
        for (BlocsDeConstruction listeBloc : this.listeBlocs) {
            gcDraw.drawImage(listeBloc.getSkin(), listeBloc.getBloc().getMinX(), listeBloc.getBloc().getMinY());
        }

        Image [] listeAChoisir;
        // Selon la vitesse horizontale du personnage, on change quelle liste d'animation est choisie
        if (perso.getVitesseX() == 0){
            listeAChoisir = this.perso.listeImageIdle;
        }
        else {listeAChoisir = this.perso.listeImageRun;}

        gcDraw.drawImage(this.perso.getFrame(listeAChoisir),X,Y);
    }
}