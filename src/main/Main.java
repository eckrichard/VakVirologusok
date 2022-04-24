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
//}

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
                                paralyzeAgentCount++;
                                break;
                            case "untouchableAgent":
                                untouchableAgentCount++;
                                break;
                            case "vitusDanceAgent":
                                vitusDanceAgentCount++;
                                break;
                            case "bearDanceAgent":
                                bearDanceAgentCount++;
                                break;
                            case "forgetAgent":
                                forgetAgentCount++;
                                break;
                            case "paralyzed":
                                paralyzedEffectCount++;
                                break;
                            case "untouchable":
                                untouchableEffectCount++;
                                break;
                            case "vitusDance":
                                vitusDanceEffectCount++;
                                break;
                            case "bearDance":
                                bearDanceEffectCount++;
                                break;
                        }
                        break;
                }
            }
            List<Material> materials = new ArrayList<>();
            //Anyagok letrehozasa
            if(TDPCount != 0 || CDPCount != 0 || valinCount != 0) {
                int j = TDPCount+CDPCount+valinCount;
                for(int i = 0; i < j; i++) {
                    if(TDPCount > 0) {
                        Material tmp = new Material("TDP");
                        materials.add(tmp);
                        TDPCount--;
                    }
                    else if(CDPCount > 0) {
                        Material tmp = new Material("CDP");
                        materials.add(tmp);
                        CDPCount--;
                    }
                    else if(valinCount > 0) {
                        Material tmp = new Material("valin");
                        materials.add(tmp);
                        valinCount--;
                    }
                }
            }

            List<ProtectiveGear> protectiveGears = new ArrayList<>();
            //ProtectiveGear-ek letrehozasa
            if(axeCount != 0 || capeCount != 0 || bonusBagCount != 0 || gloveCount != 0) {
                int j = axeCount+capeCount+bonusBagCount+gloveCount;
                for(int i = 0; i < j; i++) {
                    if(axeCount > 0) {
                        Axe tmp = new Axe("axe");
                        protectiveGears.add(tmp);
                        axeCount--;
                    }
                    else if(capeCount > 0) {
                        Cape tmp = new Cape("cape");
                        protectiveGears.add(tmp);
                        capeCount--;
                    }
                    else if(bonusBagCount > 0) {
                        BonusBag tmp = new BonusBag("bonusBag");
                        protectiveGears.add(tmp);
                        bonusBagCount--;
                    }
                    else if(gloveCount > 0) {
                        Glove tmp = new Glove("glove");
                        protectiveGears.add(tmp);
                        gloveCount--;
                    }
                }
            }

            List<Effects> effects = new ArrayList<>();
            //Effektek letrehozasa
            if(vitusDanceEffectCount != 0 || untouchableEffectCount != 0 || paralyzedEffectCount != 0 || bearDanceEffectCount != 0) {
                int j = vitusDanceEffectCount+untouchableEffectCount+paralyzedEffectCount+bearDanceEffectCount;
                for(int i = 0; i < j; i++) {
                    if(vitusDanceEffectCount > 0) {
                        VitusDance tmp = new VitusDance();
                        effects.add(tmp);
                        vitusDanceEffectCount--;
                    }
                    else if(untouchableEffectCount > 0) {
                        Untouchable tmp = new Untouchable();
                        effects.add(tmp);
                        untouchableEffectCount--;
                    }
                    else if(paralyzedEffectCount > 0) {
                        Paralyzed tmp = new Paralyzed();
                        effects.add(tmp);
                        paralyzedEffectCount--;
                    }
                    else if(bearDanceEffectCount > 0) {
                        BearDance tmp = new BearDance();
                        effects.add(tmp);
                        bearDanceEffectCount--;
                    }
                }
            }

            List<Virologist> virologists = new ArrayList<>();
            if(virologistCount != 0) {
                int  j = virologistCount;
                for (int i = 0; i < j; i++) {
                    Virologist tmp = new Virologist();
                    virologists.add(tmp);
                }
            }

            List<GeneticCode> geneticCodes = new ArrayList<>();
            if(geneticCodeCount != 0) {
                int j = geneticCodeCount;
                for (int i = 0; i < j; i++) {
                    GeneticCode tmp = new GeneticCode(null);
                    geneticCodes.add(tmp);
                }
            }

            List<Tile> tiles = new ArrayList<>();
            if(tileCount != 0 || storageCount != 0 || shelterCount != 0 || laboratoryCount != 0){
                int j = tileCount+storageCount+shelterCount+laboratoryCount;
                for(int i = 0; i < j; i++) {
                    if (tileCount > 0) {
                        Tile tmp = new Tile();
                        tiles.add(tmp);
                        tileCount--;
                    }
                    else if (storageCount > 0) {
                        Storage tmp = new Storage(null);
                        tiles.add(tmp);
                        storageCount--;
                    }
                    else if (shelterCount > 0) {
                        Shelter tmp = new Shelter(null);
                        tiles.add(tmp);
                        shelterCount--;
                    }
                    else if (laboratoryCount > 0) {
                        Laboratory tmp = new Laboratory(null);
                        tiles.add(tmp);
                        laboratoryCount--;
                    }
                }
            }

            List<Agent> agents = new ArrayList<>();
            if(bearDanceAgentCount != 0 || forgetAgentCount != 0 || vitusDanceAgentCount != 0 || untouchableAgentCount != 0 || paralyzeAgentCount != 0) {
                int j = bearDanceAgentCount + forgetAgentCount + vitusDanceAgentCount + untouchableAgentCount + paralyzeAgentCount;
                for (int i = 0; i < j; i++) {
                    if (bearDanceAgentCount > 0) {
                        BearDanceAgent tmp = new BearDanceAgent(null, "bear dance");
                        agents.add(tmp);
                        bearDanceAgentCount--;
                    }
                    else if (forgetAgentCount > 0) {
                        ForgetAgent tmp = new ForgetAgent(null, "forget");
                        agents.add(tmp);
                        forgetAgentCount--;
                    }
                    else if (vitusDanceAgentCount > 0) {
                        VitusDanceAgent tmp = new VitusDanceAgent(null, "vitus dance");
                        agents.add(tmp);
                        vitusDanceEffectCount--;
                    }
                    else if (untouchableAgentCount > 0) {
                        UntouchableAgent tmp = new UntouchableAgent(null, "untouchable");
                        agents.add(tmp);
                        untouchableAgentCount--;
                    }
                    else if (paralyzeAgentCount > 0) {
                        ParalyzeAgent tmp = new ParalyzeAgent(null, "paralyze");
                        agents.add(tmp);
                        paralyzeAgentCount--;
                    }
                }
            }


            br = new BufferedReader(new FileReader(file));  //visszaall a szoveg tetejere
            while ((st = br.readLine()) != null) {
                int i = st.indexOf(" ");            //ez itt megmondja hol az elso szokoz (elso szo vege)
                String tmp = st.substring(0, i);    //ez itt kikapja a sorbol az elso szot, ez alapjan lehet switchelni
                switch (tmp) {
                    case "set":
                        st = st.substring(i+1, st.length());        //leszedjuk az elso szot
                        i = st.indexOf(" ");                        //megmondja hol a masodik szo vege
                        tmp = st.substring(0, i);                   //kikapja a masodik szot

                        switch (tmp) {
                            case "tile":
                                //Meghatarozzuk az id-t, kinek allitunk be
                                st = st.substring(i+1, st.length());
                                i = st.indexOf(" ");
                                tmp = st.substring(0, i);
                                int id_a = Integer.parseInt(tmp) - 1;
                                //Meghatarozzuk melyik attributumot allitjuk be
                                st = st.substring(i+1, st.length());
                                i = st.indexOf(" ");
                                tmp = st.substring(0, i);

                                switch (tmp) {
                                    case "adjacentTiles":
                                        st = st.substring(i+1, st.length());
                                        int id_n = Integer.parseInt(st) - 1;
                                        //System.out.println(tiles.size());
                                        tiles.get(id_a).setNeighbor(tiles.get(id_n));
                                        break;
                                    case "p_g":
                                        st = st.substring(i+1, st.length());
                                        int id_pG = Integer.parseInt(st) - 1;
                                        tiles.get(id_a).setCollectable(protectiveGears.get(id_pG));
                                        break;
                                    case "geneticCode":
                                        st = st.substring(i+1, st.length());
                                        int id_gC = Integer.parseInt(st) - 1;
                                        tiles.get(id_a).setCollectable(geneticCodes.get(id_gC));
                                        break;
                                    case "materials":
                                        st = st.substring(i+1, st.length());
                                        int id_m = Integer.parseInt(st) - 1;
                                        tiles.get(id_a).setCollectable(materials.get(id_m));
                                        break;
                                }
                                break;
                            case "virologist":
                                ;
                                break;
                            case "bag":
                                 ;
                                 break;
                        }
                        break;
                }
            }

            br = new BufferedReader(new FileReader(file));  //visszaall a szoveg tetejere
            while ((st = br.readLine()) != null) {
                int i = st.indexOf(" ");            //ez itt megmondja hol az elso szokoz (elso szo vege)
                String tmp = st.substring(0, i);    //ez itt kikapja a sorbol az elso szot, ez alapjan lehet switchelni
                switch (tmp) {
                    case "set":
                        st = st.substring(i+1, st.length());        //leszedjuk az elso szot
                        i = st.indexOf(" ");                        //megmondja hol a masodik szo vege
                        tmp = st.substring(0, i);                   //kikapja a masodik szot

                        switch (tmp) {
                            case "tile":
                                //Meghatarozzuk az id-t, kinek allitunk be
                                st = st.substring(i+1, st.length());
                                i = st.indexOf(" ");
                                tmp = st.substring(0, i);
                                int id_a = Integer.parseInt(tmp) - 1;
                                //Meghatarozzuk melyik attributumot allitjuk be
                                st = st.substring(i+1, st.length());
                                i = st.indexOf(" ");
                                tmp = st.substring(0, i);

                                switch (tmp) {
                                    case "adjacentTiles":
                                        st = st.substring(i+1, st.length());
                                        int id_n = Integer.parseInt(st) - 1;
                                        //System.out.println(tiles.size());
                                        tiles.get(id_a).setNeighbor(tiles.get(id_n));
                                        break;
                                    case "p_g":
                                        st = st.substring(i+1, st.length());
                                        int id_pG = Integer.parseInt(st) - 1;
                                        tiles.get(id_a).setCollectable(protectiveGears.get(id_pG));
                                        break;
                                    case "geneticCode":
                                        st = st.substring(i+1, st.length());
                                        int id_gC = Integer.parseInt(st) - 1;
                                        tiles.get(id_a).setCollectable(geneticCodes.get(id_gC));
                                        break;
                                    case "materials":
                                        st = st.substring(i+1, st.length());
                                        int id_m = Integer.parseInt(st) - 1;
                                        tiles.get(id_a).setCollectable(materials.get(id_m));
                                        break;
                                }
                                break;
                            case "virologist":
                                ;
                                break;
                            case "bag":
                                ;
                                break;
                        }
                        break;

                    // Módosítás eleje
                    case "virologist":
                        //Meghatarozzuk az id-t, kinek allitunk be
                        st = st.substring(i+1, st.length());
                        i = st.indexOf(" ");
                        tmp = st.substring(0, i);
                        int id_v = Integer.parseInt(tmp) - 1;

                        st = st.substring(i+1, st.length());
                        i = st.indexOf(" ");
                        tmp = st.substring(0, i);


                        switch(tmp){
                            case "createagent":
                                //Meghatarozzuk az id-t, a genetikai kódnak
                                st = st.substring(i+1, st.length());
                                int id_gc = Integer.parseInt(st) - 1;

                                geneticCodes.get(id_gc).CreateAgent(virologists.get(id_v));
                                break;
                            case "move":
                                st = st.substring(i+1, st.length());
                                i = st.indexOf(" ");
                                tmp = st.substring(0, i);
                                if(tmp.equals("tile")){
                                    //Meghatarozzuk az id-t, a mezőnek
                                    st = st.substring(i+1, st.length());
                                    int id_t = Integer.parseInt(st) - 1;

                                    virologists.get(id_v).Move(id_t);
                                }
                                break;
                            case "palpatewall":
                                virologists.get(id_v).PalpateWall();
                                break;
                            case "collectProtectiveGear":
                                virologists.get(id_v).CollectProtectiveGear();
                                break;
                            case "useAgent":
                                //Meghatarozzuk az id-t, kinek allitunk be
                                st = st.substring(i+1, st.length());

                                if(st.length() > 0){
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);
                                    int id_v2 = Integer.parseInt(tmp) - 1;

                                    //Meghatarozzuk az id-t, melyik ágens
                                    st = st.substring(i+1, st.length());
                                    int id_a = Integer.parseInt(st) - 1;

                                    virologists.get(id_v).UseAgent(virologists.get(id_v2), agents.get(id_a));
                                    break;
                                }
                                else {
                                    int id_a = Integer.parseInt(st) - 1;
                                    virologists.get(id_v).UseAgent(virologists.get(id_v), agents.get(id_a));
                                }

                                break;
                            case "takeGear":
                                //Meghatarozzuk az id-t, kinek allitunk be
                                st = st.substring(i+1, st.length());
                                i = st.indexOf(" ");
                                tmp = st.substring(0, i);
                                int id_v2 = Integer.parseInt(tmp) - 1;

                                //Meghatarozzuk az id-t, melyik védőfelszerelést
                                st = st.substring(i+1, st.length());
                                int id_pg = Integer.parseInt(st) - 1;

                                virologists.get(id_v).TakeGear(virologists.get(id_v2), protectiveGears.get(id_pg));
                                break;
                        } // Módosítás vége
                }
            }
        }
    }