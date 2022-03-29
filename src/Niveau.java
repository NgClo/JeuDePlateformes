import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;


public class Niveau {
    private static final Image fondEcran = new Image("2224.png");
    private ArrayList <BlocsDeConstruction> listeBlocs;
    private Personnage perso;
    private Scene sceneNiveau;


    private Niveau(Scene sceneNiveau){
        this.sceneNiveau = sceneNiveau;
        }

    public Niveau(){
        }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    /** Lors de la construction du niveau, on lui associe la dispoition du premier niveau */
    public void setSceneNiveau() {
        this.sceneNiveau = this.constructionPremierNiveau();
    }

    /** Getter pour la liste des blocs dans un niveau */
    public ArrayList<BlocsDeConstruction> getListeBlocs() {
        return listeBlocs;
    }

    public Scene getSceneNiveau() {
        return sceneNiveau;
    }

    /** A partir de la quantité de blocs, du placement et du groupe,
     * les blocs sont dessinés et ajoutés à une liste qui est renvoyée.*/
    private ArrayList<BlocsDeConstruction> miseEnPlaceDesBlocs(int quantiteBloc,int placement, Group groupNiveau){
        Niveau premierNiveau = new Niveau();
        premierNiveau.listeBlocs = new ArrayList<BlocsDeConstruction>();
        premierNiveau.listeBlocs.addAll(BlocsDeConstruction.placerBloc(1,placement,"bloc1",groupNiveau));
        premierNiveau.listeBlocs.addAll(BlocsDeConstruction.placerBloc(quantiteBloc-2,placement+1,"bloc3",groupNiveau));
        premierNiveau.listeBlocs.addAll(BlocsDeConstruction.placerBloc(1,placement+quantiteBloc-1,"bloc2",groupNiveau));
        return premierNiveau.listeBlocs;
    }

    /** Construction du niveau 1
     * Renvoie la scene à afficher*/
    private Scene constructionPremierNiveau() {

        // Creation du groupe contenant le fond, les blocs et le personnage
        Group groupNiveau = new Group();
        // Creation de la scene contenant ce groupe
        Scene sceneNiveau = new Scene(groupNiveau, 1000, 650);
        // Creation du niveau avec comme attribut sceneNiveau la scene créée
        Niveau premierNiveau = new Niveau(sceneNiveau);

        // Creation du canvas sur lequel le gc dessinera
        Canvas canvasPremierNiveau = new Canvas(1000, 650);

        // Creation gc qui permettra de dessiner sur le canvas créé
        GraphicsContext gc = canvasPremierNiveau.getGraphicsContext2D();

        // Fond d'écran statique est dessiné sur toute la fenêtre et ajout au canvas
        gc.drawImage(fondEcran, 0, 0,1000,650);
        groupNiveau.getChildren().addAll(canvasPremierNiveau);

        // Mise en place des blocs en les ajoutant dans la liste des blocs et en les dessinant
        premierNiveau.listeBlocs = new ArrayList<>();

        premierNiveau.listeBlocs.addAll(miseEnPlaceDesBlocs(5,0,groupNiveau));
        premierNiveau.listeBlocs.addAll(miseEnPlaceDesBlocs(10,7,groupNiveau));
        premierNiveau.listeBlocs.addAll(miseEnPlaceDesBlocs(13,19,groupNiveau));

        // Le personnage (unique) est associé au niveau créé
        premierNiveau.setPerso(Personnage.placerPerso(groupNiveau,25,520));

        return sceneNiveau;
    }



}
