import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Entite {

    Rectangle2D hitBox;
    ImageView image;

    public Entite(int[] list, Image image) {
        this.hitBox = new Rectangle2D(list[0], list[1], list[2], list[3]);
        this.image = skinPerso(this.hitBox, image);
    }

/*    protected static int[] determineHitBox(Image image){
        int [] list = new int[4];
        int debutX = 384;
        int debutY = 512;
        int finX = 0;
        int finY = 0;
        for (int i = 0; i < 384 ; i++) { // Lecture par ligne
            for (int j = 0; j < 512; j++) { // Lecture par colonne
                if (BlocsDeConstruction.pixelTransparent(i, j) == false) {
                    if (i < debutX) debutX = i;
                    if (j < debutY) debutY = j;
                    if (i > finX) finX = i;
                    if (j > finY) finY = j;
                }
            }
        }
        list[0] = debutX;
        list[1] = debutY;
        list[2] = finX-debutX;
        list[3] = finY-debutY;
        return list;
    }*/

    public ImageView skinPerso(Rectangle2D hitBox, Image image) {
        ImageView blocView = new ImageView(image);
        blocView.setViewport(hitBox);
        return blocView;
    }

    public void modifierPosition(Group groupNiveau, double newX, double newY){
        Personnage.placerPerso(groupNiveau,image.getX()+newX,image.getY()+newY);


    }
    public void gravite(Entite entite, Group groupNiveau, Niveau nomNiveau){
        boolean surUnBloc;

        entite.hitBox = new Rectangle2D(entite.image.getX(),entite.image.getY(),371,395);
         for (int i = 0; i < nomNiveau.getListeBlocs().size();i++){
             if (!entite.hitBox.intersects(nomNiveau.getListeBlocs().get(i).getBloc())){
                surUnBloc = false;
                modifierPosition(groupNiveau, 0,1);
             }
         }

    }


}
