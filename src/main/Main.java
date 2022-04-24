package main;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

//public class Main {
//
//    public static void main(String[] args) {
//
//    }

    // Main class
    public class Main {

        // main driver method
        public static void main(String[] args) throws Exception
        {
            File file = new File( "tesztek\\teszt_1.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;

            int virologistCount = 0;

            int tileCount = 0;
            int shelterCount = 0;
            int storageCount = 0;
            int laboratoryCount = 0;

            int TDPCount = 0;
            int CDPCount = 0;
//            int dUTPCount = 0;        //nincs ilyen a tesztjeinkben
            int valinCount = 0;
//            int lizinCount = 0;
//            int szerinCount = 0;
            int geneticCodeCount = 0;

            int axeCount = 0;
            int capeCount = 0;
            int bonusBagCount = 0;
            int gloveCount = 0;
            int bagCount = 0;

            int bearDanceAgentCount = 0;
            int forgetAgentCount = 0;
            int vitusDanceAgentCount = 0;
            int untouchableAgentCount = 0;
            int paralyzeAgentCount = 0;

            int bearDanceEffectCount = 0;
            int paralyzedEffectCount = 0;
            int untouchableEffectCount = 0;
            int vitusDanceEffectCount = 0;

            //Megszamoljuk elore mibpl mennyit kell letrehozni
            //Hogy ne lokalis valtozok legyenek case-ekben
            while ((st = br.readLine()) != null) {
                int i = st.indexOf(" ");            //ez itt megmondja hol az elso szokoz (elso szo vege)
                String tmp = st.substring(0, i);    //ez itt kikapja a sorbol az elso szot, ez alapjan lehet switchelni
                switch (tmp) {
                    case "create":
                        st = st.substring(i+1, st.length());        //leszedjuk az elso szot
                        i = st.indexOf(" ");                        //megmondja hol a masodik szo vege
                        tmp = st;                   //kikapja a masodik szot

                        switch (tmp) {
                            case "virologist":
                                virologistCount++;
                                break;
                            case "tile":
                                tileCount++;
                                break;
                            case "shelter":
                                shelterCount++;
                                break;
                            case "storage":
                                storageCount++;
                                break;
                            case "laboratory":
                                laboratoryCount++;
                                break;
                            case "axe":
                                axeCount++;
                                break;
                            case "cape":
                                capeCount++;
                                break;
                            case "bonusBag":
                                bonusBagCount++;
                                break;
                            case "glove":
                                gloveCount++;
                                break;
                            case "geneticCode":
                                geneticCodeCount++;
                                break;
                            case "TDP":
                                TDPCount++;
                                break;
                            case "CDP":
                                CDPCount++;
                                break;
//                            case "dUTP":
//                                dUTPCount++;
//                                break;
                            case "valin":
                                valinCount++;
                                break;
//                            case "lizin":
//                                lizinCount++;
//                                break;
//                            case "szerin":
//                                szerinCount++;
//                                break;
                            case "bag":
                                bagCount++;
                                break;
                            case "paralyzeAgent":
                                geneticCodeCount++;
                                break;
                            case "untouchableAgent":
                                geneticCodeCount++;
                                break;
                            case "vitusDanceAgent":
                                geneticCodeCount++;
                                break;
                            case "bearDanceAgent":
                                geneticCodeCount++;
                                break;
                            case "forgetAgent":
                                geneticCodeCount++;
                                break;
                            case "paralyzed":
                                geneticCodeCount++;
                                break;
                            case "untouchable":
                                geneticCodeCount++;
                                break;
                            case "vitusDance":
                                geneticCodeCount++;
                                break;
                            case "bearDance":
                                geneticCodeCount++;
                                break;
                        }
                        break;
                }
            }
            List<Material> materials = new ArrayList<>();
            //Anyagok letrehozasa
            if(TDPCount != 0 || CDPCount != 0 || valinCount != 0) {
                for(int i = 0; i < TDPCount+CDPCount+valinCount; i++) {
                    if(TDPCount > 0) {
                        Material tmp = new Material("TDP");
                        materials.add(tmp);
                        TDPCount--;
                    }
                    if(CDPCount > 0) {
                        Material tmp = new Material("CDP");
                        materials.add(tmp);
                        CDPCount--;
                    }
                    if(valinCount > 0) {
                        Material tmp = new Material("valin");
                        materials.add(tmp);
                        valinCount--;
                    }
                }
            }

            List<ProtectiveGear> protectiveGears = new ArrayList<>();
            //ProtectiveGear-ek letrehozasa
            if(axeCount != 0 || capeCount != 0 || bonusBagCount != 0 || gloveCount != 0) {
                for(int i = 0; i < axeCount+capeCount+bonusBagCount+gloveCount; i++) {
                    if(axeCount > 0) {
                        Axe tmp = new Axe("axe");
                        protectiveGears.add(tmp);
                        axeCount--;
                    }
                    if(capeCount > 0) {
                        Cape tmp = new Cape("cape");
                        protectiveGears.add(tmp);
                        capeCount--;
                    }
                    if(bonusBagCount > 0) {
                        BonusBag tmp = new BonusBag("bonusBag");
                        protectiveGears.add(tmp);
                        bonusBagCount--;
                    }
                    if(gloveCount > 0) {
                        Glove tmp = new Glove("glove");
                        protectiveGears.add(tmp);
                        gloveCount--;
                    }
                }
            }

            List<Effects> effects = new ArrayList<>();
            //Effektek letrehozasa
            if(vitusDanceEffectCount != 0 || untouchableEffectCount != 0 || paralyzedEffectCount != 0 || bearDanceEffectCount != 0) {
                for(int i = 0; i < vitusDanceEffectCount+untouchableEffectCount+paralyzedEffectCount+bearDanceEffectCount; i++) {
                    if(vitusDanceEffectCount > 0) {
                        VitusDance tmp = new VitusDance();
                        effects.add(tmp);
                        vitusDanceEffectCount--;
                    }
                    if(untouchableEffectCount > 0) {
                        Untouchable tmp = new Untouchable();
                        effects.add(tmp);
                        untouchableEffectCount--;
                    }
                    if(paralyzedEffectCount > 0) {
                        Paralyzed tmp = new Paralyzed();
                        effects.add(tmp);
                        paralyzedEffectCount--;
                    }
                    if(bearDanceEffectCount > 0) {
                        BearDance tmp = new BearDance();
                        effects.add(tmp);
                        bearDanceEffectCount--;
                    }
                }
            }

            List<Virologist> virologists = new ArrayList<>();
            if(virologistCount != 0) {
                for (int i = 0; i < virologistCount; i++) {
                    Virologist tmp = new Virologist();
                    virologists.add(tmp);
                    virologistCount--;
                }
            }

            List<GeneticCode> geneticCodes = new ArrayList<>();
            if(geneticCodeCount != 0) {
                for (int i = 0; i < geneticCodeCount; i++) {
                    GeneticCode tmp = new GeneticCode(null);
                    geneticCodes.add(tmp);
                    geneticCodeCount--;
                }
            }

            List<Tile> tiles = new ArrayList<>();
            if(tileCount != 0 || storageCount != 0 || shelterCount != 0 || laboratoryCount != 0){
                for(int i = 0; i < tileCount+storageCount+shelterCount+laboratoryCount; i++) {
                    if (tileCount > 0) {
                        Tile tmp = new Tile();
                        tiles.add(tmp);
                        tileCount--;
                    }
                    if (storageCount > 0) {
                        Storage tmp = new Storage(null);
                        tiles.add(tmp);
                        storageCount--;
                    }
                    if (shelterCount > 0) {
                        Shelter tmp = new Shelter(null);
                        tiles.add(tmp);
                        shelterCount--;
                    }
                    if (laboratoryCount > 0) {
                        Laboratory tmp = new Laboratory(null);
                        tiles.add(tmp);
                        laboratoryCount--;
                    }
                }
            }

            List<Agent> agents = new ArrayList<>();
            if(bearDanceAgentCount != 0 || forgetAgentCount != 0 || vitusDanceAgentCount != 0 || untouchableAgentCount != 0 || paralyzeAgentCount != 0){
                for(int i = 0; i < bearDanceAgentCount+forgetAgentCount+vitusDanceAgentCount+untouchableAgentCount+paralyzeAgentCount; i++) {
                    if (bearDanceAgentCount > 0) {
                        BearDanceAgent tmp = new BearDanceAgent(null, "bear dance");
                        agents.add(tmp);
                        bearDanceAgentCount--;
                    }
                    if (forgetAgentCount > 0) {
                        ForgetAgent tmp = new ForgetAgent(null,"forget" );
                        agents.add(tmp);
                        forgetAgentCount--;
                    }
                    if (vitusDanceAgentCount > 0) {
                        VitusDanceAgent tmp = new VitusDanceAgent(null, "vitus dance");
                        agents.add(tmp);
                        vitusDanceEffectCount--;
                    }
                    if (untouchableAgentCount > 0) {
                        UntouchableAgent tmp = new UntouchableAgent(null, "untouchable");
                        agents.add(tmp);
                        untouchableAgentCount--;
                    }
                    if (paralyzeAgentCount > 0) {
                        ParalyzeAgent tmp = new ParalyzeAgent(null, "paralyze");
                        agents.add(tmp);
                        paralyzeAgentCount--;
                    }
                }



            System.out.println(materials.get(0).name);


        }
    }
}
