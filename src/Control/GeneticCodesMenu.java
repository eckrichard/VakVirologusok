package Control;

import Model.GeneticCode;
import Model.Item;
import Model.Virologist;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GeneticCodesMenu {
    private JOptionPane jPopup;
    private JLabel lCodes;
    private JPanel pCodes;
    private MenuController menuController;
    private Virologist virologist;
    private GameMenu gameMenu;
    private JTable geneticCOdeTable;

    private GeneticCodeMenuData geneticcodes;

    public GeneticCodesMenu(Virologist v, GameMenu gameMenu) {
        virologist = v;
        this.gameMenu = gameMenu;
        init();
    }

    public void init(){
        JFrame geneteicCodes = new JFrame("Genteic Codes");
        geneteicCodes.setSize(new Dimension(300, 500));
        final JPanel jPanel = new JPanel(new BorderLayout());
        final JPanel jEmptyLeft = new JPanel();
        final JPanel jEmptyRight = new JPanel();
        final JPanel jEmptyBottom = new JPanel();
        pCodes = new JPanel();
        lCodes = new JLabel("Codes");

        geneticcodes = new GeneticCodeMenuData(new ArrayList<GeneticCode>(virologist.getGeneticCodes()));
        pCodes.setLayout(new BorderLayout());
        geneticCOdeTable = new JTable(geneticcodes);
        geneticCOdeTable.setFillsViewportHeight(true);
        geneticCOdeTable.setTableHeader(null);
        pCodes.add(new JScrollPane(geneticCOdeTable), BorderLayout.CENTER);

        geneticCOdeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boolean axe = false;
                int row = geneticCOdeTable.rowAtPoint(evt.getPoint());
                int col = geneticCOdeTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    JFrame jFrame = new JFrame();
                    Object[] options = {"Create Agent!"};
                    int result = jPopup.showOptionDialog(jFrame, "What would you like to do with the genetic code?", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (result == 0){
                        geneticcodes.removeItem(row);
                        virologist.getGeneticCodes().get(row).CreateAgent(virologist);
                        gameMenu.updateStats();
                    }
                }
            }
        });

        geneteicCodes.add(jPanel);
        jPanel.add(lCodes, BorderLayout.PAGE_START);
        jPanel.add(pCodes, BorderLayout.CENTER);
        jPanel.add(jEmptyLeft, BorderLayout.LINE_START);
        jPanel.add(jEmptyRight, BorderLayout.LINE_END);
        jPanel.add(jEmptyBottom, BorderLayout.PAGE_END);

        geneteicCodes.setVisible(true);
    }
}
