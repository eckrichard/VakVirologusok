package Control;

import Model.Bag;

import javax.swing.*;
import java.awt.*;

public class BagMenu {
    private JOptionPane jPopup;
    private JLabel lAgent;
    private JLabel lProtectiveGears;
    private JLabel lMaterials;
    private JPanel pAgent;
    private JPanel pProtectiveGears;
    private JPanel pMaterials;
    private MenuController menuController;
    private Bag virologistBag;

    public BagMenu(Bag b){
        virologistBag = b;
        init();
    }

    public void init(){
        JFrame bag = new JFrame("Bag");
        bag.setSize(new Dimension(400, 500));
        final JPanel jPanel = new JPanel(new BorderLayout());
        final JPanel grid = new JPanel(new GridLayout(0,1));
        final JPanel jEmptyLeft = new JPanel();
        final JPanel jEmptyRight = new JPanel();
        final JPanel jEmptyBottom = new JPanel();
        final JPanel jEmptyTop = new JPanel();
        pAgent = new JPanel();
        JPanel agent = new JPanel(new BorderLayout());
        pProtectiveGears = new JPanel();
        JPanel gear = new JPanel(new BorderLayout());
        pMaterials = new JPanel();
        JPanel material = new JPanel(new BorderLayout());
        // Csak, hogy látszódjon
        pAgent.setBackground(Color.RED);
        pProtectiveGears.setBackground(Color.WHITE);
        pMaterials.setBackground(Color.GREEN);

        lAgent = new JLabel("Agents");
        lProtectiveGears = new JLabel("Protecive gears");
        lMaterials = new JLabel("Materials");

        //csak teszteléshez
/*
        ParalyzeAgent a1 = new ParalyzeAgent(null, "agent1");
        ForgetAgent a2 = new ForgetAgent(null, "agent2");
        UntouchableAgent a3 = new UntouchableAgent(null, "agent3");

        virologistBag.Add(a1);
        virologistBag.Add(a2);
        virologistBag.Add(a3);

        Glove g = new Glove("glove");
        Cape c = new Cape("cape");
        virologistBag.Add(g);
        virologistBag.Add(c);

        for(int i = 0; i < 20; i++){
            virologistBag.Add(new Material("material"));
        }
        */
        pAgent.setLayout(new BoxLayout(pAgent, BoxLayout.Y_AXIS));
        pProtectiveGears.setLayout(new BoxLayout(pProtectiveGears, BoxLayout.Y_AXIS));
        pMaterials.setLayout(new FlowLayout());
        if(virologistBag != null){
            for(int i = 0; i < virologistBag.getAgents().size(); i++){
                pAgent.add(new JLabel(virologistBag.getAgents().get(i).getName()));
            }
            for(int i = 0; i < virologistBag.getProtectiveGears().size(); i++){
                pProtectiveGears.add(new JLabel(virologistBag.getProtectiveGears().get(i).getName()));
            }
            for(int i = 0; i < virologistBag.getMaterials().size(); i++){
                pMaterials.add(new JLabel(virologistBag.getMaterials().get(i).getName()));
            }
        }

        bag.add(jPanel);
        jPanel.add(grid);
        grid.add(agent);
        grid.add(gear);
        grid.add(material);
        agent.add(lAgent, BorderLayout.PAGE_START);
        agent.add(pAgent, BorderLayout.CENTER);
        gear.add(lProtectiveGears, BorderLayout.PAGE_START);
        gear.add(pProtectiveGears, BorderLayout.CENTER);
        material.add(lMaterials, BorderLayout.PAGE_START);
        material.add(pMaterials, BorderLayout.CENTER);
        jPanel.add(jEmptyLeft, BorderLayout.LINE_START);
        jPanel.add(jEmptyRight, BorderLayout.LINE_END);
        jPanel.add(jEmptyBottom, BorderLayout.PAGE_END);
        jPanel.add(jEmptyTop, BorderLayout.PAGE_START);

        bag.setVisible(true);
    }
}
