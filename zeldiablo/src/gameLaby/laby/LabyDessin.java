package gameLaby.laby;

import gameLaby.laby.outils.Sprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    public static Image imageMUR;

    public static Image imagePNJ;

    public static Image imageMONSTRE;

    public static Image imagePIECE;

    public static Image imageSORTIE;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {


        this.imageMUR = Sprite.MUR;

        this.imagePNJ = Sprite.PNJ;

        this.imageMONSTRE = Sprite.MONSTRE;

        this.imagePIECE = Sprite.PIECE;

        this.imageSORTIE = Sprite.SORTIE;


        LabyJeu laby = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        GraphicsContext gc = canvas.getGraphicsContext2D();

//        gc.drawImage(imageMur, 10 * 80,  10 * 80);



        for (int y = 0; y < laby.getLabyrinthe().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLabyrinthe().getLength(); x++) {
                if (laby.getLabyrinthe().getMur(x, y)) {
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                    gc.drawImage(imageMUR, laby.tailleCase * x, laby.tailleCase * y);

                }else if ((laby.getLabyrinthe().getJoueur().getX()==x) && (laby.getLabyrinthe().getJoueur().getY()==y)) {
                    gc.setFill(Color.web("302415"));
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                    gc.drawImage(imagePNJ, laby.tailleCase * x, laby.tailleCase * y);

                }else if (laby.getLabyrinthe().getMonstrePresent(x, y)) {
                    gc.setFill(Color.web("302415"));
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                    gc.drawImage(imageMONSTRE, laby.tailleCase * x, laby.tailleCase * y);

                } else if (laby.getLabyrinthe().getPiecePresente(x, y)) {
                    gc.setFill(Color.web("302415"));
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                    gc.drawImage(imagePIECE, laby.tailleCase * x, laby.tailleCase * y);
                }
                else if (laby.getLabyrinthe().getSortie().getX() == x && laby.getLabyrinthe().getSortie().getY() == y ) {
                    if (laby.getLabyrinthe().getSortie().etreAffiche()){
                        gc.setFill(Color.web("302415"));
                        gc.fillRect(laby.tailleCase * x, laby.tailleCase * y, laby.tailleCase, laby.tailleCase);
                        gc.drawImage(imageSORTIE, laby.tailleCase * x, laby.tailleCase * y);
                    }
                    else {
                        gc.setFill(Color.web("302415"));
                        gc.fillRect(laby.tailleCase * x, laby.tailleCase * y, laby.tailleCase, laby.tailleCase);
                    }
                } else {
                    gc.setFill(Color.web("302415"));
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                }
            }
        }

    }
}