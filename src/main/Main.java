package main;

import gui.GameMenu;
import gui.GeneticCodesMenu;
import gui.MainMenu;
import gui.ThrowbackMenu;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        MainMenu mainMenu = new MainMenu(game);
        //GameMenu gameMenu = new GameMenu(game);
        //ThrowbackMenu throwbackMenu = new ThrowbackMenu();
    }
}


/*
    // Main class
    public class Main {

        // main driver method
        public static void main(String[] args) throws Exception
        {
            Boolean tesztOn = true;
            while(tesztOn) {
                System.out.println("\\Teszt sorszama:");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String tesztSorszam = reader.readLine();
                String path = "tesztek\\teszt_" + tesztSorszam + ".txt";
                File file = new File(path);

                BufferedReader br = new BufferedReader(new FileReader(file));

                String st;

                List<Material> materials = new ArrayList<>();
                List<ProtectiveGear> protectiveGears = new ArrayList<>();
                List<Effects> effects = new ArrayList<>();
                List<Virologist> virologists = new ArrayList<>();
                List<GeneticCode> geneticCodes = new ArrayList<>();
                List<Tile> tiles = new ArrayList<>();
                List<Bag> bags = new ArrayList<>();
                List<Agent> agents = new ArrayList<>();

                while ((st = br.readLine()) != null) {
                    int i = st.indexOf(" ");            //ez itt megmondja hol az elso szokoz (elso szo vege)
                    String tmp = st.substring(0, i);    //ez itt kikapja a sorbol az elso szot, ez alapjan lehet switchelni
                    switch (tmp) {
                        case "create":
                            st = st.substring(i + 1, st.length());        //leszedjuk az elso szot
                            i = st.indexOf(" ");                        //megmondja hol a masodik szo vege
                            tmp = st;                   //kikapja a masodik szot

                            switch (tmp) {
                                case "virologist":
                                    Virologist v = new Virologist();
                                    virologists.add(v);
                                    v.setId(virologists.size() - 1);
                                    break;
                                //TILES INICILIZATION
                                case "tile":
                                    Tile tile = new Tile();
                                    tiles.add(tile);
                                    tile.setId(tiles.size() - 1);
                                    break;

                                case "shelter":
                                    Shelter shelter = new Shelter(null);
                                    tiles.add(shelter);
                                    shelter.setId(tiles.size() - 1);
                                    break;
                                case "storage":
                                    Storage storage = new Storage(null);
                                    tiles.add(storage);
                                    storage.setId(tiles.size() - 1);
                                    break;
                                case "laboratory":
                                    Laboratory laboratory = new Laboratory(null);
                                    tiles.add(laboratory);
                                    laboratory.setId(tiles.size() - 1);
                                    break;
                                //PROTECTIVE GEAR INICIALIZATION
                                case "axe":
                                    Axe axe = new Axe("axe");
                                    protectiveGears.add(axe);
                                    axe.setId(protectiveGears.size() - 1);
                                    break;
                                case "cape":
                                    Cape cape = new Cape("cape");
                                    protectiveGears.add(cape);
                                    cape.setId(protectiveGears.size() - 1);
                                    break;
                                case "bonusBag":
                                    BonusBag bonusBag = new BonusBag("bonusBag");
                                    protectiveGears.add(bonusBag);
                                    bonusBag.setId(protectiveGears.size() - 1);
                                    break;
                                case "glove":
                                    Glove glove = new Glove("glove");
                                    protectiveGears.add(glove);
                                    glove.setId(protectiveGears.size() - 1);
                                    break;
                                case "geneticCode":
                                    GeneticCode geneticCode = new GeneticCode(null);
                                    geneticCodes.add(geneticCode);
                                    geneticCode.setId(geneticCodes.size() - 1);
                                    break;
                                case "TDP":
                                    Material tdp = new Material("TDP");
                                    materials.add(tdp);
                                    tdp.setId(materials.size() - 1);
                                    break;
                                case "CDP":
                                    Material cdp = new Material("CDP");
                                    materials.add(cdp);
                                    cdp.setId(materials.size() - 1);
                                    break;
//                            case "dUTP":
//                                dUTPCount++;
//                                break;
                                case "valin":
                                    Material valin = new Material("valin");
                                    materials.add(valin);
                                    valin.setId(materials.size() - 1);
                                    break;
//                            case "lizin":
//                                lizinCount++;
//                                break;
//                            case "szerin":
//                                szerinCount++;
//                                break;
                                case "bag":
                                    Bag bag = new Bag();
                                    bags.add(bag);
                                    bag.setId(bags.size() - 1);
                                    break;
                                // AGENTS
                                case "paralyzeAgent":
                                    ParalyzeAgent paralyzeAgent = new ParalyzeAgent(null, "paralyze");
                                    agents.add(paralyzeAgent);
                                    paralyzeAgent.setId(agents.size() - 1);
                                    break;
                                case "untouchableAgent":
                                    UntouchableAgent untouchableAgent = new UntouchableAgent(null, "untouchable");
                                    agents.add(untouchableAgent);
                                    untouchableAgent.setId(agents.size() - 1);
                                    break;
                                case "vitusDanceAgent":
                                    VitusDanceAgent vitusDanceAgent = new VitusDanceAgent(null, "vitus dance");
                                    agents.add(vitusDanceAgent);
                                    vitusDanceAgent.setId(agents.size() - 1);
                                    break;
                                case "bearDanceAgent":
                                    BearDanceAgent bearDanceAgent = new BearDanceAgent(null, "bear dance");
                                    agents.add(bearDanceAgent);
                                    bearDanceAgent.setId(agents.size() - 1);
                                    break;
                                case "forgetAgent":
                                    ForgetAgent forgetAgent = new ForgetAgent(null, "forget");
                                    agents.add(forgetAgent);
                                    forgetAgent.setId(agents.size() - 1);
                                    break;
                                //EFFECTS
                                case "paralyzed":
                                    Paralyzed paralyzed = new Paralyzed();
                                    effects.add(paralyzed);
                                    paralyzed.setId(effects.size() - 1);
                                    break;
                                case "untouchable":
                                    Untouchable untouchable = new Untouchable();
                                    effects.add(untouchable);
                                    untouchable.setId(effects.size() - 1);
                                    break;
                                case "vitusDance":
                                    VitusDance vitusDance = new VitusDance();
                                    effects.add(vitusDance);
                                    vitusDance.setId(effects.size() - 1);
                                    break;
                                case "bearDance":
                                    BearDance bearDance = new BearDance();
                                    effects.add(bearDance);
                                    bearDance.setId(effects.size() - 1);
                                    break;
                            }
                            break;
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
                                        case "virologists": {
                                            //Leszedjük a "virologist" et
                                            st = st.substring(i+1, st.length());
                                            i = st.indexOf(" ");
                                            //Leszedjük a virológus id-ját
                                            st = st.substring(i+1, st.length());
                                            int virologistId = Integer.parseInt(st) -1;
                                            //Beállítjuk a virológusnak ezt a tile-t
                                            Virologist virologist = virologists.get(virologistId);
                                            virologist.setTile(tiles.get(id_a));
                                            //Beállítjuk a virológust a tile-ra
                                            tiles.get(id_a).Accept(virologist);
                                            break;
                                        }
                                        case "adjacentTiles":
                                            st = st.substring(i+1, st.length());
                                            int id_n = Integer.parseInt(st) - 1;
                                            //System.out.println(tiles.size());
                                            tiles.get(id_a).setNeighbor(tiles.get(id_n));
                                            //Mivel az egyiknek beálltjuk így a másiknak is be kell.
                                            tiles.get(id_n).setNeighbor(tiles.get(id_a));
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
                                        case "LaboratoryInfect":
                                            st = st.substring(i+1, st.length());
                                            i = st.indexOf(" ");
                                            tmp = st.substring(0, i);
                                            st = st.substring(i+1, st.length());
                                            i = st.indexOf(" ");
                                            tmp = st.substring(0, i);
                                            int virologistID=Integer.parseInt(tmp)-1;
                                            Laboratory laboratory=(Laboratory) tiles.get(id_a);
                                            laboratory.LaboratoryInfect(virologists.get(virologistID));
                                            break;
                                    }
                                    break;
                                case "virologist":
                                    st = st.substring(i+1, st.length());        //leszedjuk a virologistot
                                    i = st.indexOf(" ");                        //megmondja hol a virologist
                                    tmp = st.substring(0, i);                   //kikapja a számot
                                    int idVirologistA=Integer.parseInt(tmp)-1;
                                    st = st.substring(i+1, st.length());        //leszedjuk a szamot
                                    i = st.indexOf(" ");                        //megmondja hol a szam
                                    tmp = st.substring(0, i);                   //kikapja a szettelendo dolgot
                                    switch (tmp)
                                    {
                                        case "bag":
                                            st = st.substring(i+1, st.length());        //leszedjuk a baget
                                            i = st.indexOf(" ");                        //megmondja hol a bag
                                            tmp = st.substring(0, i);                   //kikapja a bag utani utasitast
                                            st = st.substring(i+1, st.length());        //leszedjuk a bag utani utasitast
                                            //kikapja a szettelendo szamot
                                            int bagID=Integer.parseInt(st)-1;
                                            Bag bag = bags.get(bagID);
                                            Virologist virologist = virologists.get(idVirologistA);
                                            //Bagnek beállítjuk a virológust
                                            bag.setVirologist(virologist);
                                            //Virológusnak beállítjuk a baget
                                            virologist.setBag(bag);
                                            break;
                                        case "codeCount":
                                            st = st.substring(i+1, st.length());        //leszedjuk a codeCountot
                                            i = st.indexOf(" ");                        //megmondja hol a codecount
                                            st = st.substring(i+1, st.length());                   //kikapja a codecountot
                                            int codeCount=Integer.parseInt(st);
                                            virologists.get(idVirologistA).setCodeCount(codeCount);
                                            break;
                                        case "geneticCodes":
                                            st = st.substring(i+1, st.length());        //leszedjuk a geneticCodest
                                            i = st.indexOf(" ");                        //megmondja hol a geneticCodes
                                            st = st.substring(i+1, st.length());        //kikapja az id-t
                                            int geneticCodeID=Integer.parseInt(st)-1;
                                            virologists.get(idVirologistA).setGeneticCodes(geneticCodes.get(geneticCodeID));
                                            break;
                                    }
                                    break;
                                case "bag":
                                    st = st.substring(i+1, st.length());        //leszedjuk a baget
                                    i = st.indexOf(" ");                        //megmondja hol a bag
                                    tmp = st.substring(0, i);                   //kikapja az idjet
                                    int bagID=Integer.parseInt(tmp)-1;
                                    st = st.substring(i+1, st.length());        //leszedjuk a idt
                                    i = st.indexOf(" ");                        //megmondja hol id
                                    tmp = st.substring(0, i);                   //kikapja az utasitást
                                    st = st.substring(i+1, st.length());        //leszedjuk a utasitast
                                    i = st.indexOf(" ");                        //megmondja hol az utasitas
                                    int bagSize=Integer.parseInt(st);
                                    bags.get(bagID).setSize(bagSize);
                                    break;

                                case "geneticCode":
                                    //Meghatarozzuk az id-t, kinek allitunk be
                                    st = st.substring(i+1, st.length());
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);
                                    int id_geneticCode = Integer.parseInt(tmp) - 1;

                                    //Meghatarozzuk melyik attributumot allitjuk be
                                    st = st.substring(i+1, st.length());
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);

                                    if(tmp.equals("agent")){
                                        st = st.substring(i+1, st.length());        //leszedjuk a geneticCodest
                                        i = st.indexOf(" ");                        //megmondja hol a geneticCodes
                                        st = st.substring(i+1, st.length());        //kikapja az id-t
                                        int id_agent=Integer.parseInt(st)-1;
                                        geneticCodes.get(id_geneticCode).setAgent(agents.get(id_agent));
                                    }
                                    break;
                                case "agent":
                                    //Meghatarozzuk az id-t, kinek allitunk be
                                    st = st.substring(i+1, st.length());
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);
                                    int id_agent = Integer.parseInt(tmp) - 1;

                                    //Meghatarozzuk melyik attributumot allitjuk be
                                    st = st.substring(i+1, st.length());
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);

                                    if(tmp.equals("materials")){
                                        //Meghatarozzuk melyik attributumot allitjuk be
                                        st = st.substring(i+1, st.length());
                                        i = st.indexOf(" ");
                                        tmp = st.substring(0, i);

                                        if(tmp.equals("material")){
                                            st = st.substring(i+1, st.length());        //leszedjuk a geneticCodest
                                            i = st.indexOf(" ");                        //megmondja hol a geneticCodes
                                            st = st.substring(i+1, st.length());        //kikapja az id-t
                                            int id_material = Integer.parseInt(st)-1;
                                            agents.get(id_agent).setMaterial(materials.get(id_material));
                                        }
                                    }
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
                            if(i > 0){
                                tmp = st.substring(0, i);
                            }
                            else {
                                tmp = st.substring(0, st.length());
                            }

                            switch(tmp)
                            {
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

                                    if(st.length() > 1){
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
                            break;
                        case "info":
                            st = st.substring(i+1, st.length());        //leszedjuk az infot
                            i = st.indexOf(" ");                        //megmondja hol az info
                            tmp = st.substring(0, i);                   //kikapja a kovetkezo stringet
                            switch (tmp)
                            {
                                case "tile":
                                    st = st.substring(i+1, st.length());        //leszedjuk a tilet
                                    i = st.indexOf(" ");                        //megmondja hol a tile
                                    tmp = st.substring(0, i);                   //kikapja az idt
                                    int tileID=Integer.parseInt(tmp)-1;
                                    st = st.substring(i+1, st.length());        //leszedjuk a tilet
                                    tmp = st.substring(0, st.length());                   //kikapja az idt
                                    switch (tmp)
                                    {
                                        case "all":
                                            if (tiles.get(tileID) instanceof Laboratory)
                                            {
                                                Laboratory laboratory=(Laboratory) tiles.get(tileID);
                                                laboratory.Print();
                                            }
                                            else {
                                                tiles.get(tileID).Print('a');
                                            }
                                            break;
                                        case "virologists":
                                            tiles.get(tileID).Print('t');
                                            break;
                                        case "materials":
                                            if (tiles.get(tileID) instanceof Storage)
                                            {
                                                Storage storage=(Storage) tiles.get(tileID);
                                                storage.Print('m');
                                            }
                                            break;
                                    }
                                    break;
                                case "virologist":
                                    st = st.substring(i+1, st.length());        //leszedjuk a virologistet
                                    i = st.indexOf(" ");                        //megmondja hol a virologist
                                    tmp = st.substring(0, i);                   //kikapja az idt
                                    int virologistID=Integer.parseInt(tmp)-1;
                                    virologists.get(virologistID).Print();
                                    break;
                                case "protectiveGear":
                                    st = st.substring(i+1, st.length());        //leszedjuk a protectivegeart
                                    i = st.indexOf(" ");                        //megmondja hol a protecrivegear
                                    tmp = st.substring(0, i);                   //kikapja az idt
                                    int protectiveGearID=Integer.parseInt(tmp)-1;
                                    for (ProtectiveGear pg : protectiveGears)
                                    {
                                        if (pg instanceof Glove)
                                        {
                                            Glove glove=(Glove) pg;
                                            glove.Print();
                                        }
                                    }
                                    break;
                                case "bag":
                                    st = st.substring(i+1, st.length());        //leszedjuk a baget
                                    i = st.indexOf(" ");                        //megmondja hol a bag
                                    tmp = st.substring(0, i);                   //kikapja az idt
                                    int bagID=Integer.parseInt(tmp) - 1 ;
                                    st = st.substring(i+1, st.length());        //leszedjuk az idt
                                    i = st.indexOf(" ");                        //megmondja hol az id
                                    switch (st)
                                    {
                                        case "all":
                                            bags.get(bagID).Print('a');
                                            break;
                                        case "agents":
                                            bags.get(bagID).Print('c');
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case "laboratory":
                            st = st.substring(i+1, st.length());
                            i = st.indexOf(" ");
                            tmp = st.substring(0, i);
                            switch (tmp)
                            {
                                case"laboratoryInfect":
                                    st = st.substring(i+1, st.length());
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);
                                    st = st.substring(i+1, st.length());
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);
                                    int virologistID=Integer.parseInt(tmp)-1;
                                    Laboratory laboratory=new Laboratory(null);
                                    laboratory.LaboratoryInfect(virologists.get(virologistID));
                                    break;
                            }
                            break;
                        case "tile":
                            st = st.substring(i+1, st.length());
                            i = st.indexOf(" ");
                            tmp = st.substring(0, i);
                            int tileID=Integer.parseInt(tmp)-1;
                            st = st.substring(i+1, st.length());
                            i = st.indexOf(" ");
                            tmp = st.substring(0, i);
                            switch (tmp)
                            {
                                case "destoryMaterial":
                                    Storage storage =(Storage)tiles.get(tileID);
                                    storage.DestroyMaterial();
                                    break;
                                case "LaboratoryInfect":
                                    st = st.substring(i+1, st.length());
                                    i = st.indexOf(" ");
                                    tmp = st.substring(0, i);
                                    st = st.substring(i+1, st.length());
                                    tmp = st.substring(0, st.length());
                                    int virologistID=Integer.parseInt(tmp)-1;
                                    Laboratory laboratory=(Laboratory) tiles.get(tileID);
                                    laboratory.LaboratoryInfect(virologists.get(virologistID));
                                    break;
                            }
                            break;
                        case "add":
                            st = st.substring(i+1, st.length());        //leszedjuk az elso szot
                            i = st.indexOf(" ");                        //megmondja hol a masodik szo vege
                            tmp = st.substring(0, i);                   //kikapja a masodik szot
                            switch (tmp)
                            {
                                case "virologist":
                                    st = st.substring(i+1, st.length());        //leszedjuk a virologistot
                                    i = st.indexOf(" ");                        //megmondja hol a virologist
                                    tmp = st.substring(0, i);                   //kikapja a számot
                                    int idVirologistA=Integer.parseInt(tmp)-1;
                                    st = st.substring(i+1, st.length());        //leszedjuk a szamot
                                    i = st.indexOf(" ");                        //megmondja hol a szam
                                    tmp = st.substring(0, i);                   //kikapja a virologus cselekveset
                                    switch (tmp)
                                    {
                                        case "effects":
                                            st = st.substring(i+1, st.length());        //leszedjuk a effectset
                                            i = st.indexOf(" ");                        //megmondja hol az effectset
                                            tmp = st.substring(0, i);                   //kikapja az effectet
                                            st = st.substring(i+1, st.length());        //leszedjuk a effectet
                                            tmp = st.substring(0, st.length());                   //kikapja a számát
                                            int effectID=Integer.parseInt(tmp)-1;
                                            virologists.get(idVirologistA).addEffect(effects.get(effectID));
                                            break;
                                        case "wear":
                                            st = st.substring(i+1, st.length());        //leszedjuk a weart
                                            i = st.indexOf(" ");                        //megmondja hol az wear
                                            tmp = st.substring(0, i);                   //kikapja az ProtectiveGeart
                                            st = st.substring(i+1, st.length());        //leszedjuk a ProtectiveGeart
                                            tmp = st.substring(0, st.length());                   //kikapja a számot
                                            int protectiveGearID=Integer.parseInt(tmp)-1;
                                            virologists.get(idVirologistA).Wear(protectiveGears.get(protectiveGearID));
                                            break;
                                    }
                                    break;
                                case "bag":
                                    st = st.substring(i+1, st.length());        //leszedjuk a baget
                                    i = st.indexOf(" ");                        //megmondja hol a bag
                                    tmp = st.substring(0, i);                   //kikapja a számot
                                    int bagID=Integer.parseInt(tmp)-1;
                                    st = st.substring(i+1, st.length());        //leszedjuk a számot
                                    i = st.indexOf(" ");                        //megmondja hol a szám
                                    tmp = st.substring(0, i);                   //kikapja a szót
                                    switch (tmp)
                                    {
                                        case "materials":
                                            st = st.substring(i+1, st.length());        //leszedjuk a materialst
                                            i = st.indexOf(" ");                        //megmondja hol a materials
                                            tmp = st.substring(0, i);                   //kikapja a szót
                                            st = st.substring(i+1, st.length());        //leszedjuk a materialt
                                            tmp = st.substring(0, st.length());                   //kikapja a számot
                                            int materialID=Integer.parseInt(tmp)-1;
                                            bags.get(bagID).Add(materials.get(materialID));
                                            break;
                                        case "agents":
                                            st = st.substring(i+1, st.length());        //leszedjuk az agentst
                                            i = st.indexOf(" ");                        //megmondja hol a agents
                                            tmp = st.substring(0, i);                   //kikapja a szót
                                            st = st.substring(i+1, st.length());        //leszedjuk az agentet
                                            tmp = st.substring(0, st.length());                   //kikapja a számot
                                            int agentID=Integer.parseInt(tmp)-1;
                                            bags.get(bagID).Add(agents.get(agentID));
                                            break;
                                    }
                            }
                            break;
                        case "attack":
                            st = st.substring(i+1, st.length());        //leszedjuk az agentst
                            i = st.indexOf(" ");                        //megmondja hol a agents
                            tmp = st.substring(0, i);                   //kikapja a szót
                            st = st.substring(i+1, st.length());        //leszedjuk az agentet
                            tmp = st.substring(0, st.length());                   //kikapja a számot
                            int virologistID=Integer.parseInt(tmp)-1;
                            Axe axe=new Axe("axe");
                            axe.Attack(virologists.get(virologistID));
                            break;
                        case "agent":
                            for(Virologist virologist : virologists) {
                                int iter = 0;
                              while (virologist.getBag().getAgents() != null  && iter < virologist.getBag().getAgents().size()) {
                                  virologist.getBag().getAgents().get(iter).Step();
                                  iter++;
                              }
                              int iter1 = 0;
                              while(virologist.getEffects() != null && iter < virologist.getEffects().size()) {
                                 virologist.getEffects().get(iter1).Step();
                                 iter1++;
                              }

                            }

                            break;
                    }
                }

            }
        }
    }*/