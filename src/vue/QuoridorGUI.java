package vue;

import java.awt.*;

import static java.awt.GridBagConstraints.NORTHWEST;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import Class.Coordonnees;
import java.util.Map;

public class QuoridorGUI extends JFrame implements MouseListener, MouseMotionListener {

    private JLayeredPane layeredPane;
    private JPanel PlateauQuoridor;
    // private JLabel chessPiece;
    private int xAdjustment;
    private int yAdjustment;
    private HashMap<Coordonnees,JPanel> mapCoordPanelPion ;
    private HashMap<Coordonnees,JPanel> mapCoordPanelMur ;

    public QuoridorGUI(String title, Dimension dim, int Taille) {
        super(title);
        mapCoordPanelPion = new HashMap<Coordonnees,JPanel>();
        mapCoordPanelMur = new HashMap<Coordonnees,JPanel>();
        Dimension boardSize = new Dimension(Taille * 100, Taille * 100);
        int TailleIHM = Taille * 100 ;
        int tailleCasePion = (int) ((0.8 * TailleIHM) / Taille);
        int tailleCaseMur = (int) ((0.2 * TailleIHM) / Taille);
        System.out.println(Taille+","+tailleCasePion +","+tailleCaseMur);
        //  Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane
        PlateauQuoridor = new JPanel();
        layeredPane.add(PlateauQuoridor, JLayeredPane.DEFAULT_LAYER);
        PlateauQuoridor.setLayout(new GridBagLayout());
        PlateauQuoridor.setPreferredSize(boardSize);
        PlateauQuoridor.setBounds(0, 0, boardSize.width, boardSize.height);
        int casePosX = 0; // used to set starting gridX position
        int casePosY = 0; // used to set starting gridY position


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;

        for (int i = 0; i < (Taille * 2 - 1); i++) {
            constraints.gridx = i ;

            for (int j = 0; j < (Taille * 2 - 1); j++) {

                constraints.gridy = j ;
                if (i % 2 == 0 && j % 2 == 0) {
                    JPanel square = new JPanel();
                    constraints.ipadx = tailleCasePion;
                    constraints.ipady = tailleCasePion;
                    square.setBackground(Color.DARK_GRAY);
                    PlateauQuoridor.add(square,constraints);
                    casePosX += tailleCasePion ;
                    casePosY += tailleCasePion ;
                    mapCoordPanelPion.put(new Coordonnees(i,j),square);
                } else if (i % 2 == 0 && j % 2 == 1) {
                    JPanel square = new JPanel();
                    constraints.ipadx = tailleCasePion;
                    constraints.ipady = tailleCaseMur;
                    square.setBackground(Color.WHITE);
                    PlateauQuoridor.add(square,constraints);
                    casePosX += tailleCasePion ;
                    casePosY += tailleCaseMur ;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    JPanel square = new JPanel();
                    constraints.ipadx = tailleCaseMur;
                    constraints.ipady = tailleCasePion;
                    square.setBackground(Color.WHITE);
                    PlateauQuoridor.add(square,constraints);
                    casePosX += tailleCaseMur ;
                    casePosY += tailleCasePion ;
                } else if (i % 2 == 1 && j % 2 == 1) {
                    JPanel square = new JPanel();
                    constraints.ipadx = tailleCaseMur;
                    constraints.ipady = tailleCaseMur;
                    square.setBackground(Color.WHITE);
                    PlateauQuoridor.add(square,constraints);
                    casePosX += tailleCaseMur ;
                    casePosY += tailleCaseMur ;
                    mapCoordPanelMur.put(new Coordonnees(i,j),square);
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        System.out.println(o);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public HashMap<Coordonnees, JPanel> getMapCoordPanelPion() {
        return mapCoordPanelPion;
    }

    public HashMap<Coordonnees, JPanel> getMapCoordPanelMur() {
        return mapCoordPanelMur;
    }
}