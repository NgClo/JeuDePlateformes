import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.ArrayList;


public class Niveau {
    private static final Image fondEcran = new Image("2224.png");
    private ArrayList <BlocsDeConstruction> listeBlocs;
    private Personnage perso;



    public static Image getFondEcran() {
        return fondEcran;
    }

    public Niveau(Personnage perso){
        this.perso = perso;
        }

    public Niveau(){
        }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }


    /** Getter pour la liste des blocs dans un niveau */
    public ArrayList<BlocsDeConstruction> getListeBlocs() {
        return listeBlocs;
    }

    public Personnage getPerso() {
        return perso;
    }


    /** Construction du niveau 1
     */
    public void constructionPremierNiveau() {

        // Mise en place des blocs en les ajoutant dans la liste des blocs
        this.listeBlocs = new ArrayList<>();
        int intervalle = 33;
        this.listeBlocs.add(new BlocsDeConstruction("Bloc1",0,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*2,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*3,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc2",intervalle*4,629));

        this.listeBlocs.add(new BlocsDeConstruction("Bloc1",intervalle*7,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*8,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*9,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*10,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*11,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc2",intervalle*12,629));

        this.listeBlocs.add(new BlocsDeConstruction("Bloc1",intervalle*16,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*17,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*18,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*19,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*20,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*21,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*22,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*23,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*24,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*25,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*26,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc3",intervalle*27,630));
        this.listeBlocs.add(new BlocsDeConstruction("Bloc2",intervalle*28,629));

        this.perso.setPositionX(20);
        this.perso.setPositionY(550);


    }

    public void drawNiveau(Canvas canvasPremierNiveau,  double X, double Y){
        GraphicsContext gcDraw = canvasPremierNiveau.getGraphicsContext2D();

        gcDraw.drawImage(fondEcran, 0, 0,1000,650);

        for (int i = 0 ; i < this.listeBlocs.size() ; i++){
            gcDraw.drawImage(this.listeBlocs.get(i).getSkin(),this.listeBlocs.get(i).getBloc().getMinX(),this.listeBlocs.get(i).getBloc().getMinY());
        }

        gcDraw.drawImage(this.perso.getImage(),X,Y);


    }



}
