//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.rms.RecordStore;
import ngame.midlet.a;

public class ESGame extends a implements Runnable, CommandListener {
    private static int aT;
    static byte[] at = new byte[2000];
    static String PlutoUrl = null;
    Form w;
    StringItem ad;
    Form ao;
    StringItem ar;
    private static final Command aC = new Command("Menu", 7, 0);
    private static final Command aS = new Command("Exit", 7, 0);
    static int CampWidth;
    static int CampHeight;
    static byte[][] Camp;
    static int J = 1;
    static String log = "";
    private static Thread b = null;
    private static int E = 0;
    private static byte[][] Geomin;
    private static int[][] x = new int[][]{{2, 3, 4, 11, 12, 13, 20, 21, 22, 29, 30, 31}, {5, 6, 7}, {23, 24, 25}, {14, 15, 16}, {8, 9, 10}, {32, 33, 34}, {26, 27, 28}, {17, 18, 19}, {35, 36, 37}};
    private static String[][] MonFNames;
    private static final int[][] ah = new int[][]{{0, 7}, {7, 7}, {14, 7}, {21, 7}, {28, 5}};
    static final String[] DatFNames = new String[]{"/charin.dat", "/droppeditemsin.dat", "/itemsin.dat", "/monstersin.dat", "/npcstrings.dat", "/spellsin.dat", "/geomin.dat", "/dungnamesin.dat"};
    private static int[] l = new int[3];
    private static final String[] aM = new String[]{"Your fingers look gnarled to you.", "The scales on your arms and back itch.", "Your ears dissolve back into your skull.", "Your jaw hurts as it elongates, and your teeth seem to completely fill your mouth.", "Walking hurts, and the camp denizens are sure looking tasty. \n\nYour dreams are filled with the screams of overseers and others as you follow the delicious scent of blood throughout the camp. You awake cold, curled up, with Vander's head tucked under your arm."};
    Display dspl;
    private Form W;
    static Image SplashTop = null;
    static Image SplashBot = null;
    private Menu IntroMenu;
    private Menu aZ;
    private static Menu al;
    private static Menu aQ;
    private Menu ay;
    private Menu MainMenu;
    private Menu NewGameMenu;
    private Menu CharacterMenu;
    private Menu InfoMenu;
    private Menu NewCharMenu;
    private Menu WelcomeMenu;
    private Menu NoSaveGameMenu;
    private Menu f;
    Menu ab;
    Menu NPCHelloMenu;
    Menu RumorMenu;
    Menu[] NPCDlgMenus;
    Menu GiveMenu;
    Menu OracleMenu;
    Menu TrainMenu;
    Menu ae;
    Menu TakeItemMenu;
    Menu X;
    Menu V;
    Menu aJ;
    Menu an;
    Menu EnchantItemMenu;
    Menu aI;
    Menu aL;
    Menu H;
    Menu K;
    Menu s;
    Menu OptionsMenu;
    Menu StatsMenu;
    Menu InventoryMenu;
    Menu aB;
    Menu SkillsListMenu;
    Menu SkillInfoMenu;
    Menu SpellsListMenu;
    Menu SpellInfoMenu;
    Menu LevelUpMenu;
    Menu aV;
    Menu EndOfGameMenu;
    Menu QuitMenu;
    Menu HelpMenu;
    private Menu F;
    Menu CreditsMenu;
    Menu SaveErrMenu;
    private EE av;
    private Form aD;
    private static String[] HelpStrings = new String[12];
    private static String[] helpCats = new String[12];
    private static String CreditString = null;
    public Character k;
    public Character e;
    static Dungeon[] dungeons;
    Thread thread;
    boolean ak;
    boolean aW;
    byte a;
    boolean am;
    static Hashtable[] G;
    static Hashtable[] S;
    static Vector[] au;
    static Menu ax = null;
    int Y;
    int g;
    static boolean aG;
    static Image MformLogo;
    static Image Vir2lLogo;
    boolean ac;
    static Random P;
    private static boolean jj = false;

    public ESGame() {
        super.name = "The Elder Scrolls";
        this.dspl = null;
        PlutoUrl = this.getAppProperty("Pluto-Server-URL");
        if (PlutoUrl != null) {
            System.out.println("FOUND Pluto-Server-URL in JAR! Adding prefix gives: " + PlutoUrl);
        } else {
            PlutoUrl = "http://localhost/essm";
            System.out.println("Did not find Pluto-Server-URL in JAR! Using default of http://localhost/essm");
        }

        String usrid = this.getAppProperty("Mserver-User-Id");
        if (usrid != null) {
            Character.UsrID = usrid;
            System.out.println("User ID is " + Character.UsrID);
        } else {
            System.out.println("User ID is NULL!");
        }

        aT = 1;
    }

    public void Begin() {
        if (this.dspl == null) {
            Log("Very start of startapp");
            this.dspl = Display.getDisplay(this);
            this.Y = -1;
            this.g = -1;
            this.thread = new Thread(this);
            this.ak = false;
            this.aW = false;
            this.a = 0;
            this.am = false;
            Log("Before error form");
            this.y();
            Log("After error form");
            this.InitSplash();
            aT = 2;
        }

    }

    private void InitSplash() {
        try {
            MformLogo = Image.createImage("/mformaLogo.png");
            Vir2lLogo = Image.createImage("/vir2lLogo.png");
            Thread var1 = new Thread(this);
            SplashTop = this.LoadImage("/splashtop.png");
            SplashBot = this.LoadImage("/splashbot.png");
            this.ay = new Menu(this, 2, 1);
            this.ay.e();
            this.ay.c = this.w;
            J = 2;
            this.ac = true;
            aG = false;
            this.a((Object)this.ay);
            var1.start();
        } catch (Exception var2) {
            System.out.println("Barfed in initSplash");
            this.dspl.setCurrent(this.w);
        }

    }

    public void run() {
        if (J == 1) {
            System.out.println("run() Initial download, no longer implemented");
        } else if (J == 2) {
            this.LoadApp();
        } else if (J == 4) {
            this.NewGame();
        } else if (J == 5) {
            if (this.SaveGame()) {
                this.a((Object)this.av);
            } else {
                this.a((Object)this.SaveErrMenu);
            }
        } else if (J == 6) {
            if (this.LoadGame()) {
                this.J();
                this.a = this.k.CurDung;
                this.ak = true;
                jj = true;
                jj = false;
                this.ak = false;
                aQ.m = 100;
                aQ.c();
                aQ.f();
                this.k.w();
                this.av.ax = this.k;
                this.av.v = true;
                this.av.StartGame();
                this.a((Object)this.av);
            } else {
                this.a((Object)this.NoSaveGameMenu);
            }
        } else {
            this.LoadDngImgs();
            this.a((Object)this.av);
        }

    }

    private void LoadApp() {
        try {
            this.ac = true;
            aG = false;

            try {
                Thread.sleep(1000L);
            } catch (Exception var4) {
            }

            this.ac = false;
            this.ay.m = 0;
            this.AllocGame();
            this.AllocUIs();
            this.LoadDungns();
            this.ay.m = 100;
        } catch (Throwable var5) {
            System.out.println("ERROR: CANNOT LOAD APP!!");
            System.out.println(var5);
            this.a("" + var5, true);
            this.a((Object)this.w);

            try {
                Thread.sleep(15000L);
            } catch (Exception var3) {
            }
        }

    }

    private void AllocGame() throws Exception {
        this.a("Start of allocateESGame", true);
        this.a("Start of allocateESGame", true);
        LoadGeomin();
        Dungeon.LoadDungNames();
        this.a("Right before character load", true);
        Character.LoadCharData();
        this.a("ESPersonality load", true);
        k.e();
        this.ay.m = 5;
        this.a("Item load", true);
        Item.LoadAllItems();
        this.a("Spell load", true);
        Spell.LoadSpells();
        this.a("Monster load", true);
        Monster.LoadMonsters();
        this.ay.m = 10;
        this.a("End of allocESGame", true);
    }

    private void LoadDungns() {
        dungeons = null;
        System.gc();
        System.out.println(" >>>> CREATING CAMP DUNGEON <<<<<<");
        Log("    Before dungeon vector");
        dungeons = new Dungeon[37];
        Log("    After dungeon vector");
        this.ay.m = 62;
        dungeons[0] = new Dungeon((byte)1, Geomin[0], CampWidth, CampHeight, Camp);
        Log("    After camp dungeon before GC");
        System.gc();
        Log("    After camp dungeon after GC");

        for(int i = 1; i < 37; ++i) {
            dungeons[i] = new Dungeon((byte)(i + 1), Geomin[i]);
            Log("Before dungeon " + i);
            dungeons[i].MapGen();
            Log("    After dungeon " + i + " before GC");
            System.gc();
            Log("    After dungeon " + i);
            ++this.ay.m;
        }

        System.out.println(" After creating dungeons");
        Log(" After creating dungeons, before GC");
        System.gc();
        Log(" After creating dungeons");
    }

    private void NewGame() {
        System.out.println("Start of createNewGame");
        this.aZ.m = 0;
        int var1 = d(0);

        for(int i = 0; i <= var1; ++i) {
            this.PopulateDungeons(i);
        }

        this.a((Object)this.NewGameMenu);
    }

    private void J() {
        int var1 = d(this.k.GiftPoints);
        i(var1);
    }

    private void AllocUIs() throws Exception {
        System.out.println("Starting allocateAllUIs");
        this.a("Start of allocateAllUIs", true);
        System.gc();
        Log("Start of allocateAllUIs");
        this.h();
        this.ay.m = 20;
        this.j();
        this.av = new EE(this);
        Log("Before floors and walls");
        EE.floor3 = this.LoadImage("floor3.png");
        Log("after floors");
        EE.newwallsnok = this.LoadImage("newwallsnok.png");
        Log("After walls");
        this.a("After floor and wall images", true);
        EE.MonImgs = new CusImg[33];

        for(int i = 0; i < 33; ++i) {
            EE.MonImgs[i] = null;
        }

        this.a("After alloc monster images", true);
        this.a = 1;
        this.ak = true;
        this.a("before runImageLoader", true);
        this.ab = new Menu(this, 11, 304);
        this.ab.o();
        Log("Before load camp monster images ");
        this.LoadWardenImg();
        this.a("After monster images", true);
        Log("After monster images ");
        this.j();
        EE.ImgBag = new CusImg[3];
        EE.ImgBag[0] = CusImg.LoadCus("baglarge.cus");
        EE.ImgBag[1] = CusImg.LoadCus("bagmid.cus");
        EE.ImgBag[2] = CusImg.LoadCus("bagsmall.cus");
        Log("After bag images ");
        System.gc();
        this.a("After bag images ", true);
        EE.ImgCrystal = new CusImg[3];
        EE.ImgCrystal[0] = CusImg.LoadCus("crystalnear.cus");
        EE.ImgCrystal[1] = CusImg.LoadCus("crystalmid.cus");
        EE.ImgCrystal[2] = CusImg.LoadCus("crystalfar.cus");
        Log("After crystal images ");
        this.a("After crystal images ", true);
        this.j();
        Log("After oracle images ");
        this.a("After oracle images ", true);
        EE.AttackImgs = new Image[3];

        for(int i = 0; i < 3; ++i) {
            EE.AttackImgs[i] = null;
        }

        EE.AttackImgs[0] = this.LoadImage("blood1.png");
        EE.AttackImgs[1] = this.LoadImage("monsterspell.png");
        EE.AttackImgs[2] = this.LoadImage("selfspell.png");
        System.gc();
        Log("After spell images ");
        this.a("After effects images ", true);
        EE.ImgChest = new CusImg[3];
        EE.ImgChest[0] = CusImg.LoadCus("chestnearclosed.cus");
        EE.ImgChest[1] = CusImg.LoadCus("chestmidclosed.cus");
        EE.ImgChest[2] = CusImg.LoadCus("chestfarclosed.cus");
        this.a("After chest images ", true);
        this.j();
        EE.MenuIcons = new Image[6];
        EE.MenuIcons[0] = this.LoadImage("icon_attack.png");
        EE.MenuIcons[1] = this.LoadImage("icon_cast.png");
        EE.MenuIcons[2] = this.LoadImage("icon_change.png");
        EE.MenuIcons[3] = this.LoadImage("icon_option.png");
        EE.MenuIcons[4] = this.LoadImage("icon_action.png");
        EE.MenuIcons[5] = this.LoadImage("icon_camp.png");
        this.a("After monster and icon images", true);
        System.gc();
        this.j();
        this.a();
        this.a("After HELP STRINGS", true);
        this.u();
        this.a("After HELP TITLES", true);
        CreditString = this.CreditsStr();
        this.a("After CREDITS", true);
        this.MainMenu = new Menu(this, 3, 2);
        String[] MainMenuText = new String[]{"New Game", "Continue Game", "Help", "Credits", "Exit"};
        Object var4 = null;
        this.MainMenu.a("Main Menu", MainMenuText, (Vector)var4, false);
        this.NewGameMenu = new Menu(this, 5, 3);
        String[] ClassStrs = Character.Classes;
        this.NewGameMenu.a("New Game", "Select a Class:", ClassStrs, (Vector)null);
        this.ay.m = 35;
        this.a("After newGameUI", true);
        this.CharacterMenu = new Menu(this, 6, 4);
        String[] CharMenuText = new String[]{"See Class Info", "Create Character"};
        Object var7 = null;
        this.CharacterMenu.a("Character", "You selected:", "", CharMenuText, (Vector)var7);
        this.InfoMenu = new Menu(this, 4, 5);
        this.InfoMenu.a("Info", "");
        this.NewCharMenu = new Menu(this, 4, 6);
        this.NewCharMenu.a("New Character", "Character Created!\n \nPress 'select' to enter a name");
        this.NewCharMenu.RemoveElement(Menu.OKComm);
        this.NewCharMenu.AddElement(Menu.SelectComm);
        this.NewCharMenu.AddElement(Menu.CancelComm);
        this.WelcomeMenu = new Menu(this, 4, 7);
        this.WelcomeMenu.a("Welcome", "Welcome to The Elder Scrolls Travels!");
        Log("After all the welcome screens");
        this.a("After all the welcome screens", true);
        this.SaveErrMenu = new Menu(this, 4, 499);
        this.SaveErrMenu.a("Save Error", "There was an error in saving your character record. Your previous character record is still saved. Try turning your phone off then on again to clear the memory.");
        Log("Before NPCHelloUI");
        this.NPCHelloMenu = new Menu(this, 4, 8);
        this.NPCHelloMenu.a("NPC name here", "NPC text here", true);
        this.RumorMenu = new Menu(this, 4, 360);
        this.RumorMenu.a("Rumors", "Rumors text here", true);
        Log("After NPCHelloUI");
        this.a("After helloUI", true);
        this.NPCDlgMenus = new Menu[6];

        String[] var9;
        for(int i = 0; i < 4; ++i) {
            this.NPCDlgMenus[i] = new Menu(this, 5, 9 + i);
            var9 = new String[]{"Train", "Give", "Befriend", "Threaten", "Kill"};
            this.NPCDlgMenus[i].a("Name", "Aid: <TAG>", var9, (Vector)null);
            this.NPCDlgMenus[i].prev = this.av;
        }

        this.NPCDlgMenus[4] = new Menu(this, 5, 13);
        var9 = new String[]{"Give Item", "Take Crystal"};
        this.NPCDlgMenus[4].a("Beneca", "Aid: <TAG>", var9, (Vector)null);
        this.NPCDlgMenus[4].prev = this.av;
        this.NPCDlgMenus[5] = new Menu(this, 5, 14);
        String[] var10 = new String[]{"Rumors", "Give Crystal", "Enchant", "Bless", "Cure", "Warp", "Recovery"};
        this.NPCDlgMenus[5].a("Helga", "Aid: <TAG>", var10, (Vector)null);
        this.NPCDlgMenus[5].prev = this.av;
        this.a("After choicesUI", true);
        this.OracleMenu = new Menu(this, 4, 23);
        this.OracleMenu.a("Oracle", "NPC text here", true);
        this.OptionsMenu = new Menu(this, 3, 31);
        String[] var11 = new String[]{"Stats", "Inventory", "Skills", "Spells", "Save Game", "Load Game", "Help", "Quit Game"};
        this.OptionsMenu.a("Options", var11, (Vector)null, false);
        this.OptionsMenu.AddElement(Menu.BackComm);
        this.a("After OptionsUI", true);
        this.ay.m = 42;
        this.aD = new Form("Enter name");
        StringItem var12 = new StringItem((String)null, "Enter a name for your character");
        this.aD.append(var12);
        TextField var13 = new TextField((String)null, (String)null, 10, 0);
        this.aD.append(var13);
        this.aD.addCommand(Menu.OKComm);
        this.aD.addCommand(Menu.CancelComm);
        this.aD.setCommandListener(this);
        this.NoSaveGameMenu = new Menu(this, 4, 305);
        this.NoSaveGameMenu.a("Unavailable", "No game is available for loading. Press OK to return to main menu.");
        this.NoSaveGameMenu.AddElement(Menu.OKComm);
        this.NoSaveGameMenu.SetListener(this);
        this.NoSaveGameMenu.prev = this.MainMenu;
        this.a("After NoSavedGameUI", true);
        this.ay.c = this.MainMenu;
        this.NewGameMenu.prev = this.MainMenu;
        this.CharacterMenu.prev = this.NewGameMenu;
        this.InfoMenu.prev = this.CharacterMenu;
        this.InfoMenu.c = this.CharacterMenu;
        this.NewCharMenu.prev = this.CharacterMenu;
        this.f = new Menu(this, 4, 399);
        this.f.n();
        this.ay.m = 55;
        Log("End of loading UI and images");
        this.a("End of allocateAllUIs", true);
    }

    private Menu GiveMenu(int npc) {
        System.gc();
        Menu menu = new Menu(this, 5, 22);
        menu.npcID = npc;
        String[] InvStrings = new String[this.k.InventoryCount];

        for(int i = 0; i < this.k.InventoryCount; ++i) {
            int ItemID = Math.abs(this.k.Inventory[i]);
            if (this.k.C(i)) {
                InvStrings[i] = "E:" + Item.GetItemName(ItemID);
            } else {
                InvStrings[i] = Item.GetItemName(ItemID);
            }
        }

        menu.a(NPC.NPCNames[npc], "Give What?", InvStrings, (Vector)null, true);
        menu.prev = this.av;
        return menu;
    }

    private Menu TrainMenu(int npc) {
        System.gc();
        Log("Start of newTrainWhat");
        Menu menu = new Menu(this, 5, 20);
        menu.npcID = npc;
        String[] var3 = new String[3];
        int var4 = 0;

        for(int i = 0; i < 14; ++i) {
            int var6 = this.k.b(i, false);
            String var7 = Character.Skills[i] + " (<TAG>)";
            if (k.c(npc, i)) {
                var3[var4++] = func.StringInsert(var7, "<TAG>", var6);
            }
        }

        menu.a(NPC.NPCNames[npc], "Train What?", var3, (Vector)null, true);
        menu.prev = this.av;
        return menu;
    }

    private Menu TakeItemMenu(int var1) {
        System.gc();
        Log("Start of newTakeWhat");
        Menu menu = new Menu(this, 5, 27);
        menu.npcID = var1;
        String[] var3 = Item.b();
        menu.a(NPC.NPCNames[var1], "Take What?", var3, (Vector)null, true);
        menu.prev = null;
        return menu;
    }

    private Menu EnchantItemMenu(int var1) {
        System.gc();
        Log("Start of newEnchantWhat");
        Menu menu = new Menu(this, 5, 350);
        menu.npcID = var1;
        String[] var3 = new String[this.k.InventoryCount];

        for(int i = 0; i < this.k.InventoryCount; ++i) {
            int var5 = Math.abs(this.k.Inventory[i]);
            var3[i] = Item.GetItemName(var5);
        }

        menu.a(NPC.NPCNames[var1], "Enchant What?", var3, (Vector)null, true);
        menu.prev = this.av;
        return menu;
    }

    private Menu StatsMenu() {
        Menu menu = new Menu(this, 4, 32);
        menu.a("Stats", this.av.ax.GetStatsString());
        return menu;
    }

    private Menu InventoryMenu() {
        System.gc();
        Menu menu = new Menu(this, 5, 33);
        String[] var2 = new String[this.k.InventoryCount];

        for(int i = 0; i < this.k.InventoryCount; ++i) {
            byte var4 = this.k.Inventory[i];
            System.out.println("itemid is " + var4);
            if (var4 < 0) {
                var2[i] = "E: " + Item.GetItemName(Math.abs(var4));
                System.out.println("item is " + var2[i]);
            } else {
                var2[i] = Item.GetItemName(var4);
                System.out.println("item is " + var2[i]);
            }
        }

        menu.a("Inventory", "Items:", var2, (Vector)null, true);
        menu.prev = this.OptionsMenu;
        return menu;
    }

    private Menu QuitMenu(Menu var1) {
        System.gc();
        Menu menu = new Menu(this, 5, 202);
        String[] var3 = new String[]{"Yes", "No"};
        menu.a("Quit?", "Are you sure?", var3, (Vector)null, true);
        menu.prev = var1;
        return menu;
    }

    private Menu HelpMenu(Menu var1) {
        System.gc();
        Menu menu = new Menu(this, 3, 203);
        menu.a("Help", helpCats, (Vector)null);
        menu.prev = var1;
        return menu;
    }

    private Menu SpecHelpMenu(int var1) {
        System.gc();
        Menu menu = new Menu(this, 4, 206);
        menu.a(helpCats[var1], HelpStrings[var1], true);
        menu.prev = this.HelpMenu;
        return menu;
    }

    private Menu CreditsMenu(Menu var1) {
        System.gc();
        Menu menu = new Menu(this, 4, 204);
        menu.a("Credits", CreditString, true);
        menu.prev = var1;
        return menu;
    }

    public void pauseApp() {
        this.av.e();
        aT = 3;
    }

    public void destroyApp(boolean var1) {
        aT = 4;
    }

    public void commandAction(Command comm, Displayable disp) {
        if (ax != null) {
            if (comm == Menu.CancelComm && ax.prev != null) {
                this.a(ax.prev);
                return;
            }

            int var3;
            String[] var4;
            Thread var5;
            Thread var6;
            if (ax.B == 2) {
                if (comm == Menu.SelectComm) {
                    var3 = ax.a();
                    var4 = ax.r();
                    switch (var3) {
                        case 0:
                            System.gc();
                            this.aZ = new Menu(this, 8, 301);
                            this.aZ.o();
                            var5 = new Thread(this);
                            J = 4;
                            var5.start();
                            this.a((Object)this.aZ);
                            break;
                        case 1:
                            System.gc();
                            this.av.g();
                            aQ = new Menu(this, 9, 302);
                            aQ.o();
                            var6 = new Thread(this);
                            J = 6;
                            var6.start();
                            this.a((Object)aQ);
                            break;
                        case 2:
                            this.HelpMenu = this.HelpMenu(ax);
                            this.a((Object)this.HelpMenu);
                            break;
                        case 3:
                            this.CreditsMenu = this.CreditsMenu(ax);
                            this.a((Object)this.CreditsMenu);
                            break;
                        case 4:
                            this.QuitMenu = this.QuitMenu(ax);
                            this.a((Object)this.QuitMenu);
                    }
                }
            } else if (ax.B == 3) {
                if (comm == Menu.SelectComm) {
                    var3 = ax.a();
                    var4 = ax.r();
                    this.e = null;
                    System.gc();
                    this.e = new Character(this);
                    this.e.c(var3);
                    this.e.d(var3);
                    this.CharacterMenu.a(1, var4[var3]);
                    this.a((Object)this.CharacterMenu);
                }
            } else if (ax.B == 4) {
                if (comm == Menu.SelectComm) {
                    var3 = ax.a();
                    var4 = ax.r();
                    if (var3 == 0) {
                        String var9 = this.e.m();
                        this.InfoMenu.a(0, var9);
                        this.InfoMenu.w = 0;
                        this.a((Object)this.InfoMenu);
                    } else {
                        this.k = this.e;
                        this.a((Object)this.NewCharMenu);
                    }
                }
            } else if (ax.B == 5) {
                if (comm == Menu.OKComm) {
                    this.a(ax.c);
                }
            } else if (ax.B == 6) {
                if (comm == Menu.SelectComm) {
                    this.a((Object)this.aD);
                }
            } else if (ax.B == 7) {
                this.IntroMenu = new Menu(this, 4, 101);
                this.IntroMenu.a("Introduction", NPC.NPCStrings[7][3], true);
                this.a((Object)this.IntroMenu);
            } else if (ax.B == 101) {
                if (comm == Menu.OKComm) {
                    this.av.ax = this.k;
                    this.av.StartGame();
                    this.a((Object)this.av);
                }
            } else if (ax.B != 8 && ax.B != 360) {
                if (ax.B >= 9 && ax.B <= 14) {
                    if (comm == Menu.CancelComm) {
                        this.a(ax.prev);
                    } else {
                        this.d(ax);
                    }
                } else {
                    int i;
                    int var10;
                    if (ax.B == 20) {
                        if (comm == Menu.SelectComm) {
                            var3 = ax.npcID;
                            i = ax.a();
                            var10 = k.b(var3, i);
                            this.ae = this.a(ax, var3, 21, 5, var10);
                            this.a((Object)this.ae);
                        } else if (comm == Menu.CancelComm) {
                            var3 = ax.npcID;
                            this.k(var3);
                            this.a((Object)this.NPCDlgMenus[var3]);
                        }
                    } else if (ax.B == 22) {
                        if (comm == Menu.SelectComm) {
                            System.out.println("Found give what select");
                            var3 = ax.npcID;
                            i = ax.a();
                            if (i >= 0) {
                                this.OracleMenu = this.a(ax, var3, 23, 4, i);
                                this.a((Object)this.OracleMenu);
                            }
                        } else if (comm == Menu.CancelComm) {
                            var3 = ax.npcID;
                            this.k(var3);
                            this.a((Object)this.NPCDlgMenus[var3]);
                        }
                    } else if (ax.B == 27) {
                        if (comm == Menu.SelectComm) {
                            var3 = ax.npcID;
                            i = ax.a() + 87;
                            this.aJ = this.a(ax, var3, 28, 7, i);
                            this.a((Object)this.aJ);
                        } else if (comm == Menu.CancelComm) {
                            var3 = ax.npcID;
                            this.k(var3);
                            this.a((Object)this.NPCDlgMenus[var3]);
                        }
                    } else if (ax.B == 350) {
                        if (comm == Menu.SelectComm) {
                            var3 = ax.npcID;
                            i = ax.a();
                            if (i >= 0) {
                                this.aI = this.a(ax, var3, 351, 8, i);
                                this.a((Object)this.aI);
                            }
                        } else if (comm == Menu.CancelComm) {
                            var3 = ax.npcID;
                            this.k(var3);
                            this.a((Object)this.NPCDlgMenus[var3]);
                        }
                    } else if (ax.B != 23 && ax.B != 21 && ax.B != 24 && ax.B != 25 && ax.B != 28) {
                        if (ax.B == 26) {
                            this.a((Object)this.av);
                        } else if (ax.B != 351 && ax.B != 352 && ax.B != 353 && ax.B != 355) {
                            if (ax.B == 30) {
                                if (comm == Menu.OKComm) {
                                    this.a((Object)this.av);
                                }
                            } else if (ax.B == 41) {
                                if (comm == Menu.OKComm) {
                                    this.k.Q = false;
                                    this.a((Object)this.av);
                                }
                            } else if (ax.B == 31) {
                                if (comm == Menu.SelectComm) {
                                    var3 = ax.a();
                                    var4 = ax.r();
                                    switch (var3) {
                                        case 0:
                                            this.StatsMenu = this.StatsMenu();
                                            this.a((Object)this.StatsMenu);
                                            break;
                                        case 1:
                                            this.InventoryMenu = this.InventoryMenu();
                                            this.a((Object)this.InventoryMenu);
                                            break;
                                        case 2:
                                            this.SkillsListMenu = this.SkillsListMenu();
                                            this.a((Object)this.SkillsListMenu);
                                            break;
                                        case 3:
                                            this.SpellsListMenu = this.SpellsListMenu();
                                            this.a((Object)this.SpellsListMenu);
                                            break;
                                        case 4:
                                            al = new Menu(this, 10, 303);
                                            al.o();
                                            var5 = new Thread(this);
                                            J = 5;
                                            var5.start();
                                            this.a((Object)al);
                                            break;
                                        case 5:
                                            System.gc();
                                            this.av.g();
                                            aQ = new Menu(this, 9, 302);
                                            aQ.o();
                                            var6 = new Thread(this);
                                            J = 6;
                                            var6.start();
                                            this.a((Object)aQ);
                                            break;
                                        case 6:
                                            Log("Help");
                                            this.HelpMenu = this.HelpMenu(ax);
                                            this.a((Object)this.HelpMenu);
                                            break;
                                        case 7:
                                            this.QuitMenu = this.QuitMenu(ax);
                                            this.a((Object)this.QuitMenu);
                                            break;
                                        case 8:
                                            this.Debug();
                                            this.a((Object)this.ao);
                                    }
                                } else if (comm == Menu.BackComm) {
                                    this.a((Object)this.av);
                                }
                            } else if (ax.B == 32) {
                                if (comm == Menu.OKComm) {
                                    this.a((Object)this.OptionsMenu);
                                }
                            } else if (ax.B == 33) {
                                if (comm == Menu.SelectComm) {
                                    var3 = ax.a();
                                    if (var3 >= 0) {
                                        this.aB = this.InventoryItemMenu(var3);
                                        this.Y = var3;
                                        this.a((Object)this.aB);
                                    }
                                }
                            } else if (ax.B == 34) {
                                if (comm == Menu.SelectComm) {
                                    var3 = ax.a();
                                    Integer var11 = (Integer)ax.n.elementAt(var3);
                                    var10 = var11;
                                    if (var10 == 0) {
                                        this.k.i(this.Y);
                                        this.InventoryMenu = this.InventoryMenu();
                                        this.a((Object)this.InventoryMenu);
                                    } else if (var10 == 1) {
                                        if (!this.k.C(this.Y)) {
                                            this.k.d(this.Y, true);
                                        } else {
                                            this.k.A(this.Y);
                                        }

                                        this.InventoryMenu = this.InventoryMenu();
                                        this.a((Object)this.InventoryMenu);
                                    } else if (var10 == 2) {
                                        this.k.r(this.Y);
                                        this.InventoryMenu = this.InventoryMenu();
                                        this.a((Object)this.InventoryMenu);
                                    } else if (var10 == 3) {
                                        this.k.a(this.Y);
                                        if (this.k.Q) {
                                            this.k.Q = false;
                                            this.a((Object)this.av);
                                        } else {
                                            this.InventoryMenu = this.InventoryMenu();
                                            this.a((Object)this.InventoryMenu);
                                        }
                                    }

                                    this.Y = -1;
                                }
                            } else if (ax.B == 35) {
                                if (comm == Menu.SelectComm) {
                                    var3 = ax.a();
                                    this.SkillInfoMenu = this.SkillInfoMenu(var3);
                                    this.a((Object)this.SkillInfoMenu);
                                }
                            } else if (ax.B == 36) {
                                if (comm == Menu.OKComm) {
                                    this.a((Object)this.SkillsListMenu);
                                }
                            } else if (ax.B == 37) {
                                if (comm == Menu.SelectComm) {
                                    var3 = ax.a();
                                    if (var3 >= 0) {
                                        this.SpellInfoMenu = this.SpellInfoMenu(var3);
                                        this.g = var3;
                                        this.a((Object)this.SpellInfoMenu);
                                    }
                                }
                            } else if (ax.B == 38) {
                                if (comm == Menu.SelectComm) {
                                    var3 = this.k.B(this.g);
                                    this.k.b = (byte)(var3 + 1);
                                    this.SpellsListMenu = this.SpellsListMenu();
                                    this.a((Object)this.SpellsListMenu);
                                    this.g = -1;
                                }
                            } else if (ax.B == 39) {
                                if (comm == Menu.SelectComm) {
                                    String var14 = ax.p();
                                    l[ax.npcID] = -1;

                                    for(i = 0; i < Character.Attributes.length; ++i) {
                                        if (var14.equals(Character.Attributes[i])) {
                                            l[ax.npcID] = i;
                                            break;
                                        }
                                    }

                                    if (ax.npcID < 2) {
                                        var10 = ax.npcID + 1;
                                        this.LevelUpMenu = this.LevelUpMenu(var10 + 1);
                                        this.a((Object)this.LevelUpMenu);
                                    } else {
                                        short[] var10000 = this.k.AttLvl;
                                        int var10001 = l[0];
                                        var10000[var10001] = (short)(var10000[var10001] + 3);
                                        var10000 = this.k.AttLvl;
                                        var10001 = l[1];
                                        var10000[var10001] = (short)(var10000[var10001] + 2);
                                        ++this.k.AttLvl[l[2]];
                                        this.k.g();
                                        this.k.d();
                                        this.a((Object)this.av);
                                        this.av.b();
                                    }
                                }
                            } else if (ax.B == 202) {
                                if (comm == Menu.SelectComm) {
                                    var3 = ax.a();
                                    if (var3 == 0) {
                                        this.a((Object)this.f);
                                    } else {
                                        this.a(ax.prev);
                                    }
                                }
                            } else if (ax.B == 202) {
                                this.b();
                            } else if (ax.B == 40) {
                                this.a((Object)this.av);
                                this.av.b();
                            } else if (ax.B == 102) {
                                this.a((Object)this.av);
                                this.av.b();
                            } else if (ax.B == 203) {
                                if (comm == Menu.SelectComm) {
                                    var3 = ax.a();
                                    this.F = this.SpecHelpMenu(var3);
                                    this.a((Object)this.F);
                                } else {
                                    this.a(ax.prev);
                                }
                            } else if (ax.B == 206) {
                                this.a(ax.prev);
                            } else if (ax.B == 204) {
                                this.a(ax.prev);
                            } else if (ax.B == 305) {
                                this.a(ax.prev);
                            } else if (ax.B == 205) {
                                this.a(ax.prev);
                            } else if (ax.B != 200 && ax.B != 201) {
                                if (ax.B == 399) {
                                    this.b();
                                } else if (ax.B == 499) {
                                    this.b();
                                }
                            } else {
                                this.a(ax.c);
                            }
                        } else if (comm == Menu.OKComm) {
                            var3 = ax.npcID;
                            this.k(var3);
                            this.a((Object)this.NPCDlgMenus[var3]);
                        }
                    } else if (comm == Menu.OKComm) {
                        var3 = ax.npcID;
                        this.k(var3);
                        this.a((Object)this.NPCDlgMenus[var3]);
                    }
                }
            } else if (comm == Menu.OKComm) {
                if (ax.c == null) {
                    System.out.println("ERROR: next is null!");
                } else {
                    Menu var7 = (Menu)ax.c;
                    if (var7 == null) {
                        System.out.println("uic.next is null!");
                    }
                }

                this.a(ax.c);
            }
        } else if (disp == this.w) {
            this.b();
        } else if (disp == this.ao) {
            this.a((Object)this.av);
        } else if (disp == this.W) {
            if (comm == aS) {
                this.b();
            }
        } else if (disp == this.aD) {
            if (comm == Menu.OKComm) {
                TextField var15 = (TextField)this.aD.get(1);
                String name = var15.getString();
                if (name.length() < 3) {
                    Alert var12 = new Alert("Error", func.StringInsert("Your character name must be at least <TAG> letters", "<TAG>", 3), (Image)null, AlertType.ERROR);
                    var12.setTimeout(-2);
                    this.a((Object)var12);
                } else {
                    this.k.CharName = name;
                    this.a((Object)this.WelcomeMenu);
                }
            } else if (comm == Menu.CancelComm) {
                this.a((Object)this.NewCharMenu);
            }
        }

    }

    private void d(Menu var1) {
        int var3 = var1.a();
        int var4 = var1.B - 9;
        switch (var4) {
            case 0:
            case 1:
            case 2:
            case 3:
                if (var3 == 0) {
                    this.TrainMenu = this.TrainMenu(var4);
                    this.a((Object)this.TrainMenu);
                } else if (var3 == 1) {
                    if (this.k.InventoryCount <= 0) {
                        this.OracleMenu.a(NPC.NPCNames[var4]);
                        this.OracleMenu.e("You have nothing to give me!");
                        this.a((Object)this.OracleMenu);
                    } else {
                        this.GiveMenu = this.GiveMenu(var4);
                        this.a((Object)this.GiveMenu);
                    }
                } else if (var3 == 2) {
                    this.X = this.a(var1, var4, 24, 2, 0);
                    this.a((Object)this.X);
                } else if (var3 == 3) {
                    this.V = this.a(var1, var4, 25, 3, 0);
                    this.a((Object)this.V);
                } else if (var3 == 4) {
                    this.an = this.a(var1, var4, 26, 6, 0);
                    this.a((Object)this.an);
                }
                break;
            case 4:
                if (var3 == 0) {
                    if (this.k.InventoryCount <= 0) {
                        this.OracleMenu.a(NPC.NPCNames[var4]);
                        this.OracleMenu.e("You have nothing to give me!");
                        this.a((Object)this.OracleMenu);
                    } else {
                        this.GiveMenu = this.GiveMenu(var4);
                        this.a((Object)this.GiveMenu);
                    }
                } else if (var3 == 1) {
                    this.TakeItemMenu = this.TakeItemMenu(var4);
                    this.a((Object)this.TakeItemMenu);
                }
                break;
            case 5:
                if (var3 == 0) {
                    this.x();
                } else if (var3 == 1) {
                    if (this.k.InventoryCount <= 0) {
                        this.OracleMenu.a(NPC.NPCNames[var4]);
                        this.OracleMenu.e("You have nothing to give me!");
                        this.a((Object)this.OracleMenu);
                    } else {
                        this.GiveMenu = this.GiveMenu(var4);
                        this.a((Object)this.GiveMenu);
                    }
                } else if (var3 == 2) {
                    this.EnchantItemMenu = this.EnchantItemMenu(var4);
                    this.a((Object)this.EnchantItemMenu);
                } else if (var3 == 3) {
                    this.aL = this.a(var1, var4, 352, 9, 0);
                    this.a((Object)this.aL);
                } else if (var3 == 4) {
                    this.H = this.a(var1, var4, 353, 10, 0);
                    this.a((Object)this.H);
                } else if (var3 == 5) {
                    this.K = this.a(var1, var4, 41, 11, 0);
                    this.a((Object)this.K);
                } else if (var3 == 6) {
                    this.s = this.a(var1, var4, 355, 12, 0);
                    this.a((Object)this.s);
                }
        }

    }

    private Menu a(Menu var1, int NPCID, int var3, int var4, int var5) {
        Menu menu = new Menu(this, 4, var3);
        menu.a("NPC name here", "NPC text here", true);
        String var7 = NPC.a(this.k, NPCID, var4, var5);
        menu.a(NPC.NPCNames[NPCID]);
        menu.e(var7);
        menu.npcID = NPCID;
        return menu;
    }

    private Image LoadImage(String var1) throws Exception {
        return !var1.startsWith("/") ? Image.createImage("/" + var1) : Image.createImage(var1);
    }

    private boolean LoadGame() {
        boolean var1 = true;
        boolean var2 = false;
        RecordStore store = null;
        aQ.m = 0;
        String RecordName = this.GetLastSave();

        try {
            if (RecordName == null) {
                throw new Exception("No valid record store!");
            }

            store = RecordStore.openRecordStore(RecordName, false);
            int var5 = store.getNumRecords();
            byte[] record = store.getRecord(1);
            this.k = Character.LoadChar(record, true);
            this.k.Game = this;
            aQ.m = 20;
            aQ.c();
            aQ.f();
            int var7 = a((RecordStore)store, 2);
            System.out.println("Read the master lists from RecordStore");
            record = store.getRecord(var7);
            b(record);
        } catch (Exception var17) {
            System.out.println("Exception in loadGameState");
            System.out.println(var17);
            var1 = false;
        } finally {
            if (store != null) {
                try {
                    store.closeRecordStore();
                } catch (Exception var16) {
                }
            }

        }

        return var1;
    }

    private boolean SaveGame() {
        boolean var1 = true;
        boolean var2 = false;
        RecordStore var3 = null;
        al.m = 0;
        String var4 = this.f();

        try {
            var3 = RecordStore.openRecordStore(var4, true);
            byte[] var5 = this.k.g(true);
            al.m = 20;
            al.c();
            al.f();
            var3.addRecord(var5, 0, var5.length);
            System.gc();
            a(var3);
            var5 = k();
            var3.addRecord(var5, 0, var5.length);
            Object var20 = null;
            System.gc();
            var3.closeRecordStore();
            var3 = null;
            this.L();
            al.m = 100;
            al.c();
            al.f();
        } catch (Throwable var18) {
            System.out.println("Exception in saveGameState");
            System.out.println(var18);

            try {
                RecordStore.deleteRecordStore(var4);
            } catch (Exception var17) {
            }

            var1 = false;
        } finally {
            if (var3 != null) {
                try {
                    var3.closeRecordStore();
                } catch (Exception var16) {
                }
            }

        }

        return var1;
    }

    private void y() {
        this.w = new Form("Error");
        this.ad = new StringItem("Error: ", "Cannot load game");
        this.w.append(this.ad);
        Command var1 = new Command("Ok", 4, 1);
        this.w.addCommand(var1);
        this.w.setCommandListener(this);
    }

    private void a(String var1, boolean var2) {
        this.b(var1);
        boolean var3 = false;
        if (var3) {
            String var4 = this.ad.getText();
            var4 = var4 + "\n" + CheckMem(var1);
            this.ad.setText(var4);
        } else {
            this.ad.setText(CheckMem(var1));
        }

    }

    void B() {
        this.a("Out of memory", true);
        this.dspl.setCurrent(this.w);
    }

    static int d(int var0) {
        System.out.println("In getGameAdvancementLevel, giftPoints = " + var0);
        if (var0 < 9) {
            return 0;
        } else if (var0 < 13) {
            return 1;
        } else if (var0 < 17) {
            return 2;
        } else if (var0 < 23) {
            return 3;
        } else if (var0 < 28) {
            return 4;
        } else if (var0 < 34) {
            return 5;
        } else if (var0 < 40) {
            return 6;
        } else {
            return var0 < 48 ? 7 : 8;
        }
    }

    void PopulateDungeons(int var1) {
        System.out.println("In checkOpenAndPopulateDungeons, gameAdvLevel = " + var1);
        int[] var2 = x[var1];
        int var3 = var2.length;

        for(int i = 0; i < var3; ++i) {
            int var5 = x[var1][i];
            int var6 = var5 - 1;
            if (!dungeons[var6].k) {
                dungeons[var6].k = true;
                dungeons[var6].e();
            }

            if (this.aZ != null) {
                this.aZ.m = 100 * (i + 1) / var3;
                if (this.aZ.m > 100) {
                    this.aZ.m = 100;
                }

                this.aZ.c();
                this.aZ.f();
            }
        }

    }

    static void i(int var0) {
        int var1 = 0;
        int var2 = 0;

        for(int i = 0; i <= var0; ++i) {
            int[] var4 = x[i];
            int var5 = var4.length;
            var2 += var5;
        }

        for(int i = 0; i <= var0; ++i) {
            int[] var11 = x[i];
            int var6 = var11.length;

            for(int j = 0; j < var6; ++j) {
                int var8 = x[i][j];
                int var9 = var8 - 1;
                dungeons[var9].k = true;
                dungeons[var9].h();
                ++var1;
                aQ.m = 100 * var1 / var2;
                if (aQ.m > 100) {
                    aQ.m = 100;
                }
            }
        }

    }

    static void RunLoadCamp() throws Exception {
        LoadCamp();
    }

    private static void LoadCamp() {
        CampWidth = 19;
        CampHeight = 19;
        Camp = new byte[CampHeight][CampWidth];

        int j;
        for(int i = 0; i < CampHeight; ++i) {
            for(j = 0; j < CampWidth; ++j) {
                Camp[i][j] = 1;
            }
        }

        for(j = 0; j < CampWidth; ++j) {
            Camp[j][9] = 0;
        }

        for(int i = 0; i < CampHeight; ++i) {
            Camp[9][i] = 0;
        }

        for(int i = 0; i < 3; ++i) {
            for(int k = 0; k < 3; ++k) {
                Camp[8 + i][8 + k] = 0;
            }
        }

        Camp[4][8] = 0;
        Camp[4][7] = 0;
        Camp[3][7] = 0;
        Camp[16][8] = 0;
        Camp[16][7] = 0;
        Camp[15][7] = 0;
        Camp[8][3] = 0;
        Camp[7][3] = 0;
        Camp[7][2] = 0;
        Camp[10][4] = 0;
        Camp[11][4] = 0;
        Camp[12][4] = 0;
        Camp[12][3] = 0;
        Camp[6][14] = 0;
        Camp[7][14] = 0;
        Camp[8][14] = 0;
        Camp[9][14] = 0;
        Camp[10][14] = 0;
        Camp[11][14] = 0;
        Camp[12][14] = 0;
        Camp[6][13] = 0;
        Camp[12][13] = 0;
    }

    private static void K() {
        G = new Hashtable[37];

        for(int i = 1; i < 37; ++i) {
            G[i] = new Hashtable();
        }

        S = new Hashtable[37];

        for(int i = 1; i < 37; ++i) {
            S[i] = new Hashtable();
        }

        au = new Vector[37];

        for(int i = 0; i < 37; ++i) {
            au[i] = new Vector();
        }

    }

    private static void b(byte[] var0) throws Exception {
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(var0, 0, var0.length));
        Item.ia = data.readShort();
        Monster.J = data.readShort();

        for(int i = 0; i < 7; ++i) {
            NPC.b[i] = data.readBoolean();
        }

        for(int i = 0; i < 7; ++i) {
            NPC.FirstMeet[i] = data.readBoolean();
        }

        for(int i = 0; i < 4; ++i) {
            NPC.r[i] = data.readShort();
        }

        for(int i = 0; i < 4; ++i) {
            NPC.p[i] = data.readShort();
        }

        for(int i = 0; i < 4; ++i) {
            NPC.h[i] = data.readShort();
        }

        for(int i = 0; i < 4; ++i) {
            NPC.c[i] = data.readByte();
        }

        for(int i = 0; i < 4; ++i) {
            NPC.n[i] = data.readByte();
        }

        NPC.f = data.readByte();
        NPC.WardenPresent = data.readBoolean();
        NPC.a = data.readShort();
        NPC.g = data.readShort();
        NPC.l = data.readBoolean();

        for(int i = 0; i < 7; ++i) {
            if (!NPC.b[i]) {
                Dungeon var10 = dungeons[0];
                var10.DngnVec[NPC.NPCXPos[i]][NPC.NPCYPos[i]] = func.c((byte)32, var10.DngnVec[NPC.NPCXPos[i]][NPC.NPCYPos[i]]);
            }
        }

    }

    private static byte[] k() throws Exception {
        ByteArrayOutputStream var0 = new ByteArrayOutputStream(60);
        DataOutputStream var1 = new DataOutputStream(var0);
        var1.writeShort(Item.ia);
        var1.writeShort(Monster.J);

        for(int i = 0; i < 7; ++i) {
            var1.writeBoolean(NPC.b[i]);
        }

        for(int i = 0; i < 7; ++i) {
            var1.writeBoolean(NPC.FirstMeet[i]);
        }

        for(int i = 0; i < 4; ++i) {
            var1.writeShort(NPC.r[i]);
        }

        for(int i = 0; i < 4; ++i) {
            var1.writeShort(NPC.p[i]);
        }

        for(int i = 0; i < 4; ++i) {
            var1.writeShort(NPC.h[i]);
        }

        for(int i = 0; i < 4; ++i) {
            var1.writeByte(NPC.c[i]);
        }

        for(int i = 0; i < 4; ++i) {
            var1.writeByte(NPC.n[i]);
        }

        var1.writeByte(NPC.f);
        var1.writeBoolean(NPC.WardenPresent);
        var1.writeShort(NPC.a);
        var1.writeShort(NPC.g);
        var1.writeBoolean(NPC.l);
        byte[] var9 = var0.toByteArray();
        return var9;
    }

    private static void a(RecordStore var0) throws Exception {
        int var1;
        int var3;
        Enumeration var6;
        Monster var8;
        Enumeration var19;
        for(int i = 1; i < 37; ++i) {
            var3 = G[i].size();
            var1 = 4 + var3 * 28;
            ByteArrayOutputStream var4 = new ByteArrayOutputStream(var1);
            DataOutputStream var5 = new DataOutputStream(var4);
            var5.writeInt(var3);
            var6 = G[i].elements();

            byte[] var7;
            while(var6.hasMoreElements()) {
                var7 = (byte[])var6.nextElement();
                var8 = Monster.a(var7);
                var8.a(var5);
            }

            var7 = var4.toByteArray();
            var0.addRecord(var7, 0, var7.length);

            try {
                var5.close();
            } catch (Exception var13) {
            }

            var5 = null;
            var19 = null;
            System.gc();
            al.m = 20 + 30 * (i + 1) / 37;
            al.c();
            al.f();
        }

        int var14;
        for(var3 = 1; var3 < 37; ++var3) {
            var14 = S[var3].size();
            var1 = 4 + var14 * 8;
            ByteArrayOutputStream var15 = new ByteArrayOutputStream(var1);
            DataOutputStream var17 = new DataOutputStream(var15);
            var17.writeInt(var14);
            var19 = S[var3].elements();

            byte[] var21;
            while(var19.hasMoreElements()) {
                var21 = (byte[])var19.nextElement();
                a(var17, var21, 8);
            }

            var21 = var15.toByteArray();
            var0.addRecord(var21, 0, var21.length);

            try {
                var17.close();
            } catch (Exception var12) {
            }

            var6 = null;
            var8 = null;
            System.gc();
            al.m = 50 + 30 * (var3 + 1) / 37;
            al.c();
            al.f();
        }

        for(var14 = 0; var14 < 37; ++var14) {
            int var16 = au[var14].size();
            var1 = 4 + var16 * 7;
            ByteArrayOutputStream var18 = new ByteArrayOutputStream(var1);
            DataOutputStream var20 = new DataOutputStream(var18);
            var20.writeInt(var16);
            Enumeration var22 = au[var14].elements();

            byte[] var9;
            while(var22.hasMoreElements()) {
                var9 = (byte[])var22.nextElement();
                a(var20, var9, 7);
            }

            var9 = var18.toByteArray();
            var0.addRecord(var9, 0, var9.length);

            try {
                var20.close();
            } catch (Exception var11) {
            }

            var19 = null;
            Object var23 = null;
            System.gc();
            al.m = 80 + 19 * (var14 + 1) / 37;
            al.c();
            al.f();
        }

    }

    private static int a(RecordStore store, int var1) throws Exception {
        int var2 = var1;

        DataInputStream data;
        int var7;
        for(int i = 1; i < 37; ++i) {
            byte[] record = store.getRecord(var2++);
            data = new DataInputStream(new ByteArrayInputStream(record, 0, record.length));
            G[i].clear();
            int var6 = data.readInt();

            for(var7 = 0; var7 < var6; ++var7) {
                Monster var8 = Monster.a(data);
                String var9 = String.valueOf(var8.a);
                G[i].put(var9, var8.f());
            }

            try {
                data.close();
            } catch (Exception var13) {
            }

            data = null;
            Object var14 = null;
            System.gc();
            aQ.m = 20 + 30 * (i + 1) / 37;
            aQ.c();
            aQ.f();
        }

        DataInputStream var18;
        int var21;
        for(int i = 1; i < 37; ++i) {
            byte[] var16 = store.getRecord(var2++);
            var18 = new DataInputStream(new ByteArrayInputStream(var16, 0, var16.length));
            S[i].clear();
            var7 = var18.readInt();

            for(var21 = 0; var21 < var7; ++var21) {
                byte[] var22 = a((DataInputStream)var18, 8);
                String var10 = func.StrCatComma((int)var22[0], var22[1]);
                S[i].put(var10, var22);
            }

            try {
                var18.close();
            } catch (Exception var12) {
            }

            var18 = null;
            data = null;
            System.gc();
            aQ.m = 50 + 30 * (i + 1) / 37;
            aQ.c();
            aQ.f();
        }

        for(int i = 0; i < 37; ++i) {
            byte[] var19 = store.getRecord(var2++);
            DataInputStream var20 = new DataInputStream(new ByteArrayInputStream(var19, 0, var19.length));
            au[i].removeAllElements();
            var21 = var20.readInt();

            for(int j = 0; j < var21; ++j) {
                byte[] var24 = a((DataInputStream)var20, 7);
                au[i].addElement(var24);
            }

            try {
                var20.close();
            } catch (Exception var11) {
            }

            var20 = null;
            var18 = null;
            System.gc();
            aQ.m = 80 + 19 * (i + 1) / 37;
            aQ.c();
            aQ.f();
        }

        return var2;
    }

    private static byte[] a(DataInputStream stream, int len) throws Exception {
        byte[] btarr = new byte[len];

        for(int i = 0; i < len; ++i) {
            btarr[i] = stream.readByte();
        }

        return btarr;
    }

    private static void a(DataOutputStream stream, byte[] btarr, int len) throws Exception {
        for(int i = 0; i < len; ++i) {
            stream.writeByte(btarr[i]);
        }

    }

    public static void Log(String var0) {
    }

    static String CheckMem(String str) {
        if (str == null) {
            str = "";
        }

        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        return ">>> MEMORY: " + str + ": Free memory is " + freeMemory + ", Total memory is " + totalMemory;
    }

    private void h() {
        this.W = new Form("Done");
        StringItem var1 = new StringItem((String)null, "I am done");
        this.W.append(var1);
        this.W.addCommand(aS);
        this.W.setCommandListener(this);
    }

    private void LoadWardenImg() {
        byte[] var1 = new byte[5];
        System.out.println("LOADING WARDEN IMAGES");
        var1[0] = 1;
        var1[1] = 1;
        var1[2] = 1;
        var1[3] = 1;
        var1[4] = 1;
        this.a = 1;
        this.ImageLoader(var1);
    }

    void LoadDngImgs() {
        System.out.println("Running image loader thread for new dungeon ID: " + this.a);
        this.am = false;
        if (jj) {
            aQ.m = 80;
        } else {
            this.ab.m = 0;
        }

        byte[] var1 = new byte[5];

        for(int i = 0; i < 5; ++i) {
            var1[i] = 0;
        }

        if (this.a == 1) {
            this.UnloadMonImg();
            this.LoadWardenImg();
        } else {
            Hashtable var3 = G[this.a - 1];
            if (var3 == null) {
                return;
            }

            Enumeration var4 = var3.elements();

            while(true) {
                while(var4.hasMoreElements()) {
                    byte[] var5 = (byte[])var4.nextElement();
                    Monster var6 = Monster.a(var5);
                    if (var6.l >= 1 && var6.l <= 5) {
                        ++var1[0];
                    } else if (var6.l >= 6 && var6.l <= 10) {
                        ++var1[1];
                    } else if (var6.l >= 11 && var6.l <= 25) {
                        ++var1[2];
                    } else if (var6.l >= 26 && var6.l <= 40) {
                        ++var1[3];
                    } else {
                        ++var1[4];
                    }
                }

                this.UnloadMonImg();
                this.ImageLoader(var1);
                break;
            }
        }

        EE.E = true;
    }

    private boolean m(int var1) {
        switch (var1) {
            case 4:
            case 11:
            case 18:
            case 23:
            case 30:
                return true;
            default:
                return false;
        }
    }

    void ImageLoader(byte[] var1) {
        this.am = false;
        this.a("Inside runImageLoader", true);

        try {
            for(int i = 0; i < 5; ++i) {
                if (var1[i] > 0) {
                    this.a("Handling ichunk = " + i, true);
                    int var3 = ah[i][0];
                    int var4 = ah[i][1];

                    for(int j = 0; j < var4; ++j) {
                        int var6 = var3 + j;
                        if (!this.m(var6)) {
                            EE.MonImgs[var6] = CusImg.LoadCus(MonFNames[i][j]);
                        }

                        if (!this.ak) {
                            return;
                        }

                        if (this.aW) {
                            this.aW = false;
                            return;
                        }
                    }
                }

                if (jj) {
                    aQ.m = 80 + (i + 1) * 20 / 5;
                    aQ.c();
                    aQ.f();
                } else {
                    this.ab.m = (i + 1) * 100 / 5;
                    this.ab.c();
                    this.ab.f();
                }
            }

            this.am = true;
            System.out.println("SUCCESSFULLY LOADED MONSTER IMAGES!!");
            this.ak = false;
        } catch (Throwable var7) {
            System.out.println("ERROR in image loader: " + var7);
            this.dspl.setCurrent(this.w);
        }

    }

    void UnloadMonImg() {
        int var1 = EE.MonImgs.length;

        for(int i = 0; i < var1; ++i) {
            if (EE.MonImgs[i] != null) {
                EE.MonImgs[i].g = null;
                EE.MonImgs[i] = null;
            }
        }

        System.gc();
        Log("After unloading all monster images");
    }

    static void KillMonster(int dngnID, int var1) {
        System.out.println("In killMonster! dungid is " + dngnID);
        byte[] var2 = (byte[])G[dngnID - 1].remove(String.valueOf(var1));
        byte var3 = var2[4];
        byte var4 = var2[5];
        Dungeon var5 = dungeons[dngnID - 1];
        if (var2 != null) {
            var5.DngnVec[var3][var4] = func.c((byte)2, var5.DngnVec[var3][var4]);
        }

        System.out.println("End of killMonster, size of HT is " + G[dngnID - 1].size());
    }

    private Menu InventoryItemMenu(int ItemIndx) {
        Menu menu = new Menu(this, 5, 34);
        System.out.println("In newInventoryItemUI: getting item " + ItemIndx);
        String var3 = this.k.ItemString(ItemIndx);
        Vector var4 = new Vector();
        Vector var5 = new Vector();
        var4.addElement("Drop");
        var5.addElement(Integer.valueOf(0));
        if (this.k.w(ItemIndx)) {
            if (!this.k.C(ItemIndx)) {
                var4.addElement("Equip");
            } else {
                var4.addElement("Unequip");
            }

            var5.addElement(Integer.valueOf(1));
        }

        if (this.k.e(ItemIndx)) {
            var4.addElement("Learn");
            var5.addElement(Integer.valueOf(2));
        }

        if (this.k.v(ItemIndx)) {
            var4.addElement("Use");
            var5.addElement(Integer.valueOf(3));
        }

        String[] var6 = new String[var4.size()];

        for(int i = 0; i < var4.size(); ++i) {
            var6[i] = (String)var4.elementAt(i);
        }

        menu.a("Item", var3, var6, var5);
        menu.A = true;
        menu.prev = this.InventoryMenu;
        return menu;
    }

    private Menu SkillsListMenu() {
        System.gc();
        Log("Start of newSkillsListUI");
        Menu var1 = new Menu(this, 5, 35);
        Vector var2 = this.k.GetSkillList();
        int var3 = var2.size();
        String[] var4 = new String[var3];

        for(int i = 0; i < var3; ++i) {
            var4[i] = (String)var2.elementAt(i);
        }

        var1.a("Skills", "Your Skills:", var4, (Vector)null, true);
        var1.prev = this.OptionsMenu;
        return var1;
    }

    private Menu SkillInfoMenu(int var1) {
        System.gc();
        Log("Start of newSkillInfoUI");
        Menu var2 = new Menu(this, 4, 36);
        int var3 = this.k.l(var1);
        String var4 = this.k.GetSkillString(var3);
        var2.a("Skill Info", var4);
        var2.prev = this.SkillsListMenu;
        return var2;
    }

    private Menu SpellsListMenu() {
        System.gc();
        Log("Start of newSpellsListUI");
        Menu var1 = new Menu(this, 5, 37);
        Vector var2 = this.k.J();
        int var3 = var2.size();
        String[] var4 = new String[var3];

        for(int i = 0; i < var3; ++i) {
            var4[i] = (String)var2.elementAt(i);
        }

        var1.a("Spells", "Your Spells:", var4, (Vector)null, true);
        var1.prev = this.OptionsMenu;
        return var1;
    }

    private Menu SpellInfoMenu(int var1) {
        System.gc();
        Log("Start of newSpellInfoUI");
        Menu var2 = new Menu(this, 5, 38);
        int var3 = this.k.B(var1);
        String var4 = this.k.s(var3);
        String[] var5 = new String[]{"Ready Spell"};
        var2.a("Spell Info", var4, var5, (Vector)null);
        var2.A = true;
        var2.prev = this.SpellsListMenu;
        return var2;
    }

    Menu LevelUpMenu(int var1) {
        System.gc();
        Log("Start of newLevelUpUI: index= " + var1);
        Menu menu = new Menu(this, 5, 39);
        String[] var3 = this.k.q();
        String var4 = null;
        if (var1 == 1) {
            menu.npcID = 0;
            var4 = "Select an attribute to \nincrease 3 points:";
        } else if (var1 == 2) {
            var4 = "Select an attribute to \nincrease 2 points:";
            menu.npcID = 1;
        } else if (var1 == 3) {
            menu.npcID = 2;
            var4 = "Select an attribute to \nincrease 1 point:";
        }

        menu.a("Level Up", var4, var3, (Vector)null);
        menu.t.removeCommand(Menu.CancelComm);
        menu.A = true;
        menu.prev = menu;
        return menu;
    }

    Menu WardenSpeaksMenu(String var1) {
        System.gc();
        Log("Start of newWardenSpeaksUI");
        Menu menu = new Menu(this, 4, 102);
        menu.a("Varus", var1);
        return menu;
    }

    Menu EndOfGameMenu() {
        System.gc();
        Log("Start of newEndOfGameUI");
        String var1 = NPC.NPCStrings[7][4];
        Menu menu = new Menu(this, 4, 200);
        menu.a("Victory!", var1);
        menu.c = this.GameOverMenu();
        return menu;
    }

    private Menu GameOverMenu() {
        System.gc();
        Log("Start of newGameOverUI");
        String var1 = NPC.NPCStrings[7][5];
        Menu menu = new Menu(this, 4, 201);
        menu.a("Game Over", var1);
        menu.c = this.MainMenu;
        return menu;
    }

    static DataInputStream LoadDatRaw(String file) throws Exception {
        InputStream stream = (new Object()).getClass().getResourceAsStream(func.FormatString(file));
        if (stream == null) {
            return null;
        } else {
            byte[] btarr = func.LoadBytes(stream.available(), stream);
            return new DataInputStream(new ByteArrayInputStream(btarr));
        }
    }

    static int h(int var0) {
        return Math.abs(P.nextInt() % var0);
    }

    static int f(int var0) {
        return 1 + Math.abs(P.nextInt() % var0);
    }

    static int a(Random var0, int var1) {
        return 1 + Math.abs(var0.nextInt() % var1);
    }

    void a(Object obj) {
        if (ax != null) {
            if (obj instanceof Menu) {
                Menu var2 = (Menu)obj;
                if (ax != var2) {
                    ax.q();
                }
            } else {
                ax.q();
            }
        }

        if (this.av != null) {
            this.av.e();
        }

        if (this.dspl == null) {
            this.dspl = Display.getDisplay(this);
        }

        if (obj instanceof Menu) {
            ax = (Menu)obj;
            CC var3 = Menu.j();
            var3.menu = ax;
            ax.t = var3;
            this.dspl.setCurrent(ax.t);
            ax.h();
            ax.c();
            ax.f();
        } else if (obj instanceof Displayable) {
            Displayable var4 = (Displayable)obj;
            ax = null;
            this.dspl.setCurrent(var4);
        }

    }

    private static void LoadGeomin() throws Exception {
        DataInputStream data = func.LoadDatStream("/geomin.dat");
        Geomin = new byte[37][6];

        for(int i = 0; i < 37; ++i) {
            for(int j = 0; j < 6; ++j) {
                Geomin[i][j] = data.readByte();
            }
        }

    }

    private static void LoadMonsterFPaths() throws Exception {
        InputStream stream = (new Object()).getClass().getResourceAsStream("/monsterfilenamesin.dat");
        byte[] btarr = func.LoadBytes(stream.available(), stream);
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(btarr));
        MonFNames = new String[5][7];

        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 7; ++j) {
                MonFNames[i][j] = data.readUTF();
            }
        }

    }

    private void Debug() {
        this.ao = new Form("Debug");
        String var1 = this.av.ax.K();
        this.ar = new StringItem("Debug: ", var1);
        this.ao.append(this.ar);
        Command var2 = new Command("Ok", 4, 1);
        this.ao.addCommand(var2);
        this.ao.setCommandListener(this);
    }

    synchronized void b(String var1) {
        log = var1;
    }

    private void u() {
        helpCats[0] = NPC.NPCStrings[7][6];
        helpCats[1] = NPC.NPCStrings[7][8];
        helpCats[2] = NPC.NPCStrings[7][11];
        helpCats[3] = NPC.NPCStrings[7][13];
        helpCats[4] = NPC.NPCStrings[7][19];
        helpCats[5] = NPC.NPCStrings[7][21];
        helpCats[6] = NPC.NPCStrings[7][24];
        helpCats[7] = NPC.NPCStrings[7][29];
        helpCats[8] = NPC.NPCStrings[7][31];
        helpCats[9] = NPC.NPCStrings[7][34];
        helpCats[10] = NPC.NPCStrings[7][37];
        helpCats[11] = NPC.NPCStrings[7][39];
    }

    private void a() {
        StringBuffer var1 = new StringBuffer(1200);
        var1.append(NPC.NPCStrings[7][7]);
        HelpStrings[0] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][9]);
        var1.append(NPC.NPCStrings[7][10]);
        HelpStrings[1] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][12]);
        HelpStrings[2] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][14]);
        var1.append(NPC.NPCStrings[7][15]);
        var1.append(NPC.NPCStrings[7][16]);
        var1.append(NPC.NPCStrings[7][17]);
        var1.append(NPC.NPCStrings[7][18]);
        HelpStrings[3] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][20]);
        HelpStrings[4] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][22]);
        var1.append(NPC.NPCStrings[7][23]);
        HelpStrings[5] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][25]);
        var1.append(NPC.NPCStrings[7][26]);
        var1.append(NPC.NPCStrings[7][27]);
        var1.append(NPC.NPCStrings[7][28]);
        HelpStrings[6] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][30]);
        HelpStrings[7] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][32]);
        var1.append(NPC.NPCStrings[7][33]);
        HelpStrings[8] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][35]);
        var1.append(NPC.NPCStrings[7][36]);
        HelpStrings[9] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][38]);
        HelpStrings[10] = var1.toString();
        var1.delete(0, 1200);
        var1.append(NPC.NPCStrings[7][40]);
        HelpStrings[11] = var1.toString();
        var1.delete(0, 1200);
    }

    private String CreditsStr() {
        StringBuffer var1 = new StringBuffer(400);
        var1.append("Game Design: Anthony Gill and Greg Gorden");
        var1.append('\n');
        var1.append("Art: Mark Jones");
        var1.append('\n');
        var1.append("Programming: Marc Ilgen");
        var1.append('\n');
        var1.append("Technical Director: Andrew Friedman");
        var1.append('\n');
        var1.append("(C) 2003 Vir2L Studos, a ZeniMax Media company. The Elder Scrolls and Vir2L are ");
        var1.append("registered trademarks of ZeniMax Media Inc. All rights reserved.");
        var1.append('\n');
        return var1.toString();
    }

    private void k(int var1) {
        String var2 = this.NPCDlgMenus[var1].M;
        String var3 = this.NPCDlgMenus[var1].t();
        short var4 = 0;
        if (NPC.b(var1)) {
            var4 = NPC.p[var1];
        } else if (var1 == 4) {
            var4 = k.a;
        } else if (var1 == 5) {
            var4 = NPC.g;
        }

        var3 = func.StringInsert(var2, "<TAG>", var4);
        this.NPCDlgMenus[var1].e(var3);
    }

    private String f() {
        String[] var1 = RecordStore.listRecordStores();
        boolean var2 = false;
        int var7;
        if (var1 == null) {
            var7 = 0;
        } else {
            var7 = var1.length;
        }

        int var3 = func.a(10000);
        String var4 = "es_gamestate" + var3;

        while(true) {
            boolean var5 = false;

            for(int i = 0; i < var7; ++i) {
                if (var4.equals(var1[i])) {
                    var5 = true;
                }
            }

            if (!var5) {
                return var4;
            }

            var3 = func.a(10000);
            var4 = "es_gamestate" + var3;
        }
    }

    private String GetLastSave() {
        String[] StoreList = RecordStore.listRecordStores();
        boolean var2 = false;
        int StoreCount;
        if (StoreList == null) {
            StoreCount = 0;
        } else {
            StoreCount = StoreList.length;
        }

        String RecordName = null;
        if (StoreCount == 0) {
            return null;
        } else {
            long time = 0L;
            RecordStore Store = null;

            for(int i = 0; i < StoreCount; ++i) {
                try {
                    Store = RecordStore.openRecordStore(StoreList[i], false);
                    int recordCount = Store.getNumRecords();
                    long lastModified = Store.getLastModified();
                    if (lastModified > time) {
                        RecordName = StoreList[i];
                        time = lastModified;
                    }
                } catch (Throwable var20) {
                } finally {
                    try {
                        if (Store != null) {
                            Store.closeRecordStore();
                        }

                        Store = null;
                    } catch (Exception var19) {
                    }

                }
            }

            return RecordName;
        }
    }

    private void L() {
        String var1 = this.GetLastSave();
        String[] var2 = RecordStore.listRecordStores();
        boolean var3 = false;
        int var7;
        if (var2 == null) {
            var7 = 0;
        } else {
            var7 = var2.length;
        }

        if (var7 != 0) {
            for(int i = 0; i < var7; ++i) {
                if (var1 == null || !var1.equals(var2[i])) {
                    try {
                        RecordStore.deleteRecordStore(var2[i]);
                    } catch (Exception var6) {
                    }
                }
            }

        }
    }

    void x() {
        String var1 = NPC.a(this.k, 5, 13, 0);
        if (var1 == null) {
            var1 = "No rumors!";
        }

        this.RumorMenu.a(NPC.NPCNames[5]);
        this.RumorMenu.e(var1);
        this.RumorMenu.c = this.NPCDlgMenus[5];
        this.RumorMenu.npcID = 5;
        Menu var2 = (Menu)this.RumorMenu.c;
        String var3 = var2.M;
        String var4 = var2.t();
        boolean var5 = false;
        short var6 = NPC.g;
        var4 = func.StringInsert(var3, "<TAG>", var6);
        var2.e(var4);
        this.a((Object)this.RumorMenu);
    }

    private void j() {
        if (aT == 4) {
            this.b();
        }

    }

    static {
        try {
            P = new Random(System.currentTimeMillis());
            RunLoadCamp();
            LoadMonsterFPaths();
            K();
        } catch (Exception err) {
            System.out.println("ERROR: problem with loading camp or image record HT");
        }

    }
}
