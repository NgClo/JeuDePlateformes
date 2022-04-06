import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Niveau {
    private static final Image fondEcran = new Image("jungle.png");
    private ArrayList<BlocsDeConstruction> listeBlocs; // Liste des blocs dans un niveau
    private final Personnage perso;
    private double debutNiveau;
    private double finNiveau;
    static private int numeroNiveauActuel = 1;
    final static private int totalNiveaux = 2;

    public Niveau(Personnage perso) {
        this.perso = perso;
    }

    public static int getNumeroNiveauActuel() {
        return numeroNiveauActuel;
    }

    private void setNumeroNiveauActuel(int numeroNiveau) {numeroNiveauActuel = numeroNiveau;}

    public ArrayList<BlocsDeConstruction> getListeBlocs() {
        return listeBlocs;
    }

    /**
     * Permet de construire une " plateforme ",
     * avec un bloc de début, un certain nombre de blocs au total et un bloc de fin.
     */
    private ArrayList<BlocsDeConstruction> constrPlateformes(int positionX, int positionY, int nombreBlocs) {
        ArrayList<BlocsDeConstruction> listeBlocsPlateforme = new ArrayList<>();
        int intervalle = 33;
        listeBlocsPlateforme.add(new BlocsDeConstruction("Bloc1", intervalle * positionX, positionY));
        for (int i = 0; i < nombreBlocs - 3; i++) {
            listeBlocsPlateforme.add(new BlocsDeConstruction("Bloc3", intervalle * (positionX + 1 + i), positionY));
        }
        listeBlocsPlateforme.add(new BlocsDeConstruction("Bloc2", intervalle * (positionX + nombreBlocs - 2), positionY - 1));
        return listeBlocsPlateforme;
    }

    /**
     * Construction du niveau 1
     * avec placement des blocs
     * et placement du personnage */
    private void constructionPremierNiveau() {
        // Mise en place des blocs en les ajoutant dans la liste des blocs
        this.listeBlocs = new ArrayList<>();
        this.listeBlocs.addAll(constrPlateformes(0, 630, 5));
        this.listeBlocs.addAll(constrPlateformes(10, 630, 8));

        this.listeBlocs.addAll(constrPlateformes(6, 520, 4));

        this.listeBlocs.addAll(constrPlateformes(20, 630, 30));

        this.listeBlocs.addAll(constrPlateformes(73, 500, 10));

        this.listeBlocs.addAll(constrPlateformes(58, 550, 10));

        this.listeBlocs.addAll(constrPlateformes(88, 580, 30));

        int emplacementDernierBloc = this.listeBlocs.size() - 1;

        this.debutNiveau = this.listeBlocs.get(0).getBloc().getMinX();
        this.finNiveau = this.listeBlocs.get(emplacementDernierBloc).getBloc().getMaxX();

        // Pour ce niveau, le dernier bloc ajouté à la liste est le bloc de fin
        this.listeBlocs.get(emplacementDernierBloc).setEstUnBlocDeFin(true);

        this.perso.setPositionX(20);
        this.perso.setPositionY(450);
    }

    private void constructionDeuxiemeNiveau(){
        this.listeBlocs = new ArrayList<>();
        this.listeBlocs.addAll(constrPlateformes(0, 630, 5));

        this.listeBlocs.addAll(constrPlateformes(6, 520, 4));

        this.listeBlocs.addAll(constrPlateformes(20, 450, 30));

        this.listeBlocs.addAll(constrPlateformes(73, 500, 10));

        this.listeBlocs.addAll(constrPlateformes(58, 550, 10));

        this.listeBlocs.addAll(constrPlateformes(88, 580, 30));

        int emplacementDernierBloc = this.listeBlocs.size() - 1;

        this.debutNiveau = this.listeBlocs.get(0).getBloc().getMinX();
        this.finNiveau = this.listeBlocs.get(emplacementDernierBloc).getBloc().getMaxX();

        // Pour ce niveau, le dernier bloc ajouté à la liste est le bloc de fin
        this.listeBlocs.get(emplacementDernierBloc).setEstUnBlocDeFin(true);

        this.perso.setPositionX(20);
        this.perso.setPositionY(450);
    }

    /**Permet de dessiner le niveau en fonction de la position du personnage, avec scrolling
     * Les blocs sont dans une liste associée au niveau et cette liste est récupérée pour redessiner le niveau.
     * Dans un premier temps, le fond est dessiné
     * Dans un second temps, les blocs sont dessinés selon la position du personnage
     * Dans un troisième temps, le personnage est dessiné selon sa position et la direction dans laquelle il se dirige.*/
    public void drawNiveau(Canvas canvasNiveau, double X, double Y) {
        GraphicsContext gcDraw = canvasNiveau.getGraphicsContext2D();

        gcDraw.drawImage(fondEcran, 0, 0, 1000, 650);
        Graphique.nomNiveau(numeroNiveauActuel,canvasNiveau);
        Image[] listeAChoisir;
        // Selon la vitesse horizontale du personnage, on change quelle liste d'animation est choisie
        if (perso.getVitesseX() == 0) listeAChoisir = this.perso.listeImageIdle;
        else if (perso.getVitesseX() > 0) listeAChoisir = this.perso.listeImageRun;
        else listeAChoisir = this.perso.listeImageRunR;

        if (X < 500){
            // Boucle qui passe en revue tous les blocs de la liste et les dessine
            for (BlocsDeConstruction listeBloc : this.listeBlocs) {
                gcDraw.drawImage(listeBloc.getSkin(), listeBloc.getBloc().getMinX(), listeBloc.getBloc().getMinY());
            }
            gcDraw.drawImage(this.perso.getFrame(listeAChoisir), X, Y);
        }
        else if (X > (this.finNiveau - 500)){
            for (BlocsDeConstruction listeBloc : this.listeBlocs) {
                if(listeBloc.getBloc().getMinX() > (this.finNiveau - 1000))
                    gcDraw.drawImage(listeBloc.getSkin(), 1000-(this.finNiveau - listeBloc.getBloc().getMinX()), listeBloc.getBloc().getMinY());
            }
            gcDraw.drawImage(this.perso.getFrame(listeAChoisir), 1000-(this.finNiveau-X), Y);
        }

        else {
            for (BlocsDeConstruction listeBloc : this.listeBlocs) {
                if(listeBloc.getBloc().getMinX() >= (X-500) && listeBloc.getBloc().getMinX() <= (X+500)){
                    gcDraw.drawImage(listeBloc.getSkin(), listeBloc.getBloc().getMinX() - X + 500, listeBloc.getBloc().getMinY());
                }
            }
            gcDraw.drawImage(this.perso.getFrame(listeAChoisir), 500, Y);
        }
    }
    /** Permet de ne pas dépasser le début et la fin du niveau*/
    public void bordNiveau(){
        if (perso.getPositionX() < debutNiveau){
            perso.resetVitesse();
            perso.addVitesse(2,0);
        }
        if (perso.getPositionX() > finNiveau){
            perso.resetVitesse();
            perso.addVitesse(-2,0);
        }
    }

    public void lancementNiveau(int numNiveau, Personnage perso, Canvas canvasNiveau){
        if (numNiveau == 1){
            this.constructionPremierNiveau(); // Construction du premier niveau
            this.drawNiveau(canvasNiveau, perso.getPositionX(), perso.getPositionY()); // premier Niveau dessiné
        }
        if (numNiveau == 2){
            this.constructionDeuxiemeNiveau(); // Construction du premier niveau
            this.drawNiveau(canvasNiveau, perso.getPositionX(), perso.getPositionY()); // premier Niveau dessiné
        }
    }

    /** Remet la vitesse à 0 une fois que le personnage a atteri
    Si le personnage n'est pas en train de tomber mais qu'il tombait à la boucle précédent
    Alors la vitesse est remise à O.*/
    public void resetVitesseApresChute(Personnage perso){
        perso.setTombe(perso.gravite(this));
        if (!perso.getTombe()) {
            if (perso.getTombeMoinsUn()) {
                perso.resetVitesse();
            }
        }
        perso.setTombeMoinsUn(perso.gravite(this));
    }

    /** Cas où le personnage tombe = GAME OVER
       Avec possibilité de rejouer ou de revenir au menu*/
    public void mortPerso(Personnage perso, AnimationTimer aT, Stage stage, Canvas canvasNiveau, Scene sceneMenu){
        if (perso.getPositionY() > 1000) { // Le personnage tombe
            perso.resetVitesse();
            aT.stop();
            Graphique rectangleVictoire = new Graphique();
            rectangleVictoire.dessinerRectangleInfo("GAME OVER", canvasNiveau);
            stage.getScene().setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.R) {
                    perso.deplacePerso(e.getCode(), this);
                    aT.start();
                }
                if (e.getCode() == KeyCode.M) { stage.setScene(sceneMenu);}
            });
        }
    }

    /** Cas où le personnage remporte le niveau
     * Avec possibilité de rejouer ou de revenir au menu*/
    public void finNiveauAtteint(AnimationTimer aT, Canvas canvasNiveau, Stage stage, Scene sceneMenu,Personnage perso, ArrayList<Niveau> listeNiveau){
        if (perso.remporteNiveau(this)) {
            System.out.println("Gagné !");
            if (numeroNiveauActuel == totalNiveaux) {
                aT.stop();
                setNumeroNiveauActuel(1);
                Graphique rectangleVictoire = new Graphique();
                rectangleVictoire.dessinerRectangleInfo("VICTOIRE", canvasNiveau);
                stage.getScene().setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.R) {
                        perso.deplacePerso(e.getCode(), this);
                        aT.start();
                    }
                    if (e.getCode() == KeyCode.M) stage.setScene(sceneMenu);
                });
            }
            else {
                setNumeroNiveauActuel(numeroNiveauActuel=numeroNiveauActuel+1);
                listeNiveau.get(numeroNiveauActuel-1).lancementNiveau(numeroNiveauActuel,perso, canvasNiveau);
            }
        }
    }


    static public ArrayList<Niveau> creationNiveau(Personnage perso){
        ArrayList<Niveau> listeNiveau= new ArrayList<>();
        Niveau premierNiveau = new Niveau(perso);
        listeNiveau.add(premierNiveau);
        Niveau deuxiemeNiveau = new Niveau(perso);
        listeNiveau.add(deuxiemeNiveau);

        return listeNiveau;
    }
}