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
    private static int GameState;
    static byte[] at = new byte[2000];
    static String PlutoUrl = null;
    Form ErrorForm;
    StringItem ErrorString;
    Form DebugMenu;
    StringItem DebugString;
    private static final Command MenuComm = new Command("Menu", Command.EXIT, 0);
    private static final Command ExitComm = new Command("Exit", Command.EXIT, 0);
    static int CampWidth;
    static int CampHeight;
    static byte[][] Camp;
    static int GameAction = 1;
    static String Log = "";
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
    private Form ExitForm;
    static Image SplashTop = null;
    static Image SplashBot = null;
    private Menu IntroMenu;
    private Menu NewGameLoadMenu;
    private static Menu al;
    private static Menu HelperMenu;
    private Menu SplashMenu;
    private Menu MainMenu;
    private Menu NewGameMenu;
    private Menu CharacterMenu;
    private Menu InfoMenu;
    private Menu NewCharMenu;
    private Menu WelcomeMenu;
    private Menu NoSaveGameMenu;
    private Menu EndCreditsMenu;
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
    private GameCanvas GCanvas;
    private Form NameEntry;
    private static String[] HelpStrings = new String[12];
    private static String[] helpCats = new String[12];
    private static String CreditString = null;
    public Character Player;
    public Character DefaultPlayer;
    static Dungeon[] dungeons;
    Thread thread;
    boolean ak;
    boolean aW;
    byte CurrentDung;
    boolean am;
    static Hashtable[] MonsterTable;
    static Hashtable[] ChestTable;
    static Vector[] DroppedItemsTable;
    static Menu CurrentMenu = null;
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

        GameState = 1;
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
            this.CurrentDung = 0;
            this.am = false;
            Log("Before error form");
            this.y();
            Log("After error form");
            this.InitSplash();
            GameState = 2;
        }

    }

    private void InitSplash() {
        try {
            MformLogo = Image.createImage("/mformaLogo.png");
            Vir2lLogo = Image.createImage("/vir2lLogo.png");
            Thread thrd = new Thread(this);
            SplashTop = this.LoadImage("/splashtop.png");
            SplashBot = this.LoadImage("/splashbot.png");
            this.SplashMenu = new Menu(this, 2, 1);
            this.SplashMenu.SetDisplayableE();
            this.SplashMenu.Next = this.ErrorForm;
            GameAction = 2;
            this.ac = true;
            aG = false;
            this.SetDisplayContent((Object)this.SplashMenu);
            thrd.start();
        } catch (Exception err) {
            System.out.println("Barfed in initSplash");
            this.dspl.setCurrent(this.ErrorForm);
        }

    }

    public void run() {
        if (GameAction == 1) {
            System.out.println("run() Initial download, no longer implemented");
        } else if (GameAction == 2) {
            this.LoadApp();
        } else if (GameAction == 4) {
            this.NewGame();
        } else if (GameAction == 5) {
            if (this.SaveGame()) {
                this.SetDisplayContent((Object)this.GCanvas);
            } else {
                this.SetDisplayContent((Object)this.SaveErrMenu);
            }
        } else if (GameAction == 6) {
            if (this.LoadGame()) {
                this.J();
                this.CurrentDung = this.Player.CurDung;
                this.ak = true;
                jj = true;
                jj = false;
                this.ak = false;
                HelperMenu.LoadPct = 100;
                HelperMenu.Paint();
                HelperMenu.ServiceRepaint();
                this.Player.w();
                this.GCanvas.Char = this.Player;
                this.GCanvas.v = true;
                this.GCanvas.StartGame();
                this.SetDisplayContent((Object)this.GCanvas);
            } else {
                this.SetDisplayContent((Object)this.NoSaveGameMenu);
            }
        } else {
            this.LoadDngImgs();
            this.SetDisplayContent((Object)this.GCanvas);
        }

    }

    private void LoadApp() {
        try {
            this.ac = true;
            aG = false;

            try {
                Thread.sleep(1000L);
            } catch (Exception err) {
            }

            this.ac = false;
            this.SplashMenu.LoadPct = 0;
            this.AllocGame();
            this.AllocUIs();
            this.LoadDungns();
            this.SplashMenu.LoadPct = 100;
        } catch (Throwable thr) {
            System.out.println("ERROR: CANNOT LOAD APP!!");
            System.out.println(thr);
            this.DebugMsg("" + thr, true);
            this.SetDisplayContent((Object)this.ErrorForm);

            try {
                Thread.sleep(15000L);
            } catch (Exception err) {
            }
        }

    }

    private void AllocGame() throws Exception {
        this.DebugMsg("Start of allocateESGame", true);
        this.DebugMsg("Start of allocateESGame", true);
        LoadGeomin();
        Dungeon.LoadDungNames();
        this.DebugMsg("Right before character load", true);
        Character.LoadCharData();
        this.DebugMsg("ESPersonality load", true);
        Player.e();
        this.SplashMenu.LoadPct = 5;
        this.DebugMsg("Item load", true);
        Item.LoadAllItems();
        this.DebugMsg("Spell load", true);
        Spell.LoadSpells();
        this.DebugMsg("Monster load", true);
        Monster.LoadMonsters();
        this.SplashMenu.LoadPct = 10;
        this.DebugMsg("End of allocESGame", true);
    }

    private void LoadDungns() {
        dungeons = null;
        System.gc();
        System.out.println(" >>>> CREATING CAMP DUNGEON <<<<<<");
        Log("    Before dungeon vector");
        dungeons = new Dungeon[37];
        Log("    After dungeon vector");
        this.SplashMenu.LoadPct = 62;
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
            ++this.SplashMenu.LoadPct;
        }

        System.out.println(" After creating dungeons");
        Log(" After creating dungeons, before GC");
        System.gc();
        Log(" After creating dungeons");
    }

    private void NewGame() {
        System.out.println("Start of createNewGame");
        this.NewGameLoadMenu.LoadPct = 0;
        int advLevel = GetGameAdvLevel(0);

        for(int i = 0; i <= advLevel; ++i) {
            this.PopulateDungeons(i);
        }

        this.SetDisplayContent((Object)this.NewGameMenu);
    }

    private void J() {
        int advLevel = GetGameAdvLevel(this.Player.GiftPoints);
        i(advLevel);
    }

    private void AllocUIs() throws Exception {
        System.out.println("Starting allocateAllUIs");
        this.DebugMsg("Start of allocateAllUIs", true);
        System.gc();
        Log("Start of allocateAllUIs");
        this.h();
        this.SplashMenu.LoadPct = 20;
        this.j();
        this.GCanvas = new GameCanvas(this);
        Log("Before floors and walls");
        GameCanvas.floor3 = this.LoadImage("floor3.png");
        Log("after floors");
        GameCanvas.newwallsnok = this.LoadImage("newwallsnok.png");
        Log("After walls");
        this.DebugMsg("After floor and wall images", true);
        GameCanvas.MonImgs = new CusImg[33];

        for(int i = 0; i < 33; ++i) {
            GameCanvas.MonImgs[i] = null;
        }

        this.DebugMsg("After alloc monster images", true);
        this.CurrentDung = 1;
        this.ak = true;
        this.DebugMsg("before runImageLoader", true);
        this.ab = new Menu(this, 11, 304);
        this.ab.SetDisplayableO();
        Log("Before load camp monster images ");
        this.LoadWardenImg();
        this.DebugMsg("After monster images", true);
        Log("After monster images ");
        this.j();
        GameCanvas.ImgBag = new CusImg[3];
        GameCanvas.ImgBag[0] = CusImg.LoadCus("baglarge.cus");
        GameCanvas.ImgBag[1] = CusImg.LoadCus("bagmid.cus");
        GameCanvas.ImgBag[2] = CusImg.LoadCus("bagsmall.cus");
        Log("After bag images ");
        System.gc();
        this.DebugMsg("After bag images ", true);
        GameCanvas.ImgCrystal = new CusImg[3];
        GameCanvas.ImgCrystal[0] = CusImg.LoadCus("crystalnear.cus");
        GameCanvas.ImgCrystal[1] = CusImg.LoadCus("crystalmid.cus");
        GameCanvas.ImgCrystal[2] = CusImg.LoadCus("crystalfar.cus");
        Log("After crystal images ");
        this.DebugMsg("After crystal images ", true);
        this.j();
        Log("After oracle images ");
        this.DebugMsg("After oracle images ", true);
        GameCanvas.AttackImgs = new Image[3];

        for(int i = 0; i < 3; ++i) {
            GameCanvas.AttackImgs[i] = null;
        }

        GameCanvas.AttackImgs[0] = this.LoadImage("blood1.png");
        GameCanvas.AttackImgs[1] = this.LoadImage("monsterspell.png");
        GameCanvas.AttackImgs[2] = this.LoadImage("selfspell.png");
        System.gc();
        Log("After spell images ");
        this.DebugMsg("After effects images ", true);
        GameCanvas.ImgChest = new CusImg[3];
        GameCanvas.ImgChest[0] = CusImg.LoadCus("chestnearclosed.cus");
        GameCanvas.ImgChest[1] = CusImg.LoadCus("chestmidclosed.cus");
        GameCanvas.ImgChest[2] = CusImg.LoadCus("chestfarclosed.cus");
        this.DebugMsg("After chest images ", true);
        this.j();
        GameCanvas.MenuIcons = new Image[6];
        GameCanvas.MenuIcons[0] = this.LoadImage("icon_attack.png");
        GameCanvas.MenuIcons[1] = this.LoadImage("icon_cast.png");
        GameCanvas.MenuIcons[2] = this.LoadImage("icon_change.png");
        GameCanvas.MenuIcons[3] = this.LoadImage("icon_option.png");
        GameCanvas.MenuIcons[4] = this.LoadImage("icon_action.png");
        GameCanvas.MenuIcons[5] = this.LoadImage("icon_camp.png");
        this.DebugMsg("After monster and icon images", true);
        System.gc();
        this.j();
        this.GetHelpStrings();
        this.DebugMsg("After HELP STRINGS", true);
        this.GetHelpCats();
        this.DebugMsg("After HELP TITLES", true);
        CreditString = this.CreditsStr();
        this.DebugMsg("After CREDITS", true);
        this.MainMenu = new Menu(this, 3, 2);
        String[] MainMenuText = new String[]{"New Game", "Continue Game", "Help", "Credits", "Exit"};
        Object var4 = null;
        this.MainMenu.BuildMenu("Main Menu", MainMenuText, (Vector)var4, false);
        this.NewGameMenu = new Menu(this, 5, 3);
        String[] ClassStrs = Character.Classes;
        this.NewGameMenu.BuildMenu("New Game", "Select a Class:", ClassStrs, (Vector)null);
        this.SplashMenu.LoadPct = 35;
        this.DebugMsg("After newGameUI", true);
        this.CharacterMenu = new Menu(this, 6, 4);
        String[] CharMenuText = new String[]{"See Class Info", "Create Character"};
        Object var7 = null;
        this.CharacterMenu.BuildMenu("Character", "You selected:", "", CharMenuText, (Vector)var7);
        this.InfoMenu = new Menu(this, 4, 5);
        this.InfoMenu.BuildMenu("Info", "");
        this.NewCharMenu = new Menu(this, 4, 6);
        this.NewCharMenu.BuildMenu("New Character", "Character Created!\n \nPress 'select' to enter a name");
        this.NewCharMenu.RemoveElement(Menu.OKComm);
        this.NewCharMenu.AddElement(Menu.SelectComm);
        this.NewCharMenu.AddElement(Menu.CancelComm);
        this.WelcomeMenu = new Menu(this, 4, 7);
        this.WelcomeMenu.BuildMenu("Welcome", "Welcome to The Elder Scrolls Travels!");
        Log("After all the welcome screens");
        this.DebugMsg("After all the welcome screens", true);
        this.SaveErrMenu = new Menu(this, 4, 499);
        this.SaveErrMenu.BuildMenu("Save Error", "There was an error in saving your character record. Your previous character record is still saved. Try turning your phone off then on again to clear the memory.");
        Log("Before NPCHelloUI");
        this.NPCHelloMenu = new Menu(this, 4, 8);
        this.NPCHelloMenu.BuildMenu("NPC name here", "NPC text here", true);
        this.RumorMenu = new Menu(this, 4, 360);
        this.RumorMenu.BuildMenu("Rumors", "Rumors text here", true);
        Log("After NPCHelloUI");
        this.DebugMsg("After helloUI", true);
        this.NPCDlgMenus = new Menu[6];

        String[] var9;
        for(int i = 0; i < 4; ++i) {
            this.NPCDlgMenus[i] = new Menu(this, 5, 9 + i);
            var9 = new String[]{"Train", "Give", "Befriend", "Threaten", "Kill"};
            this.NPCDlgMenus[i].BuildMenu("Name", "Aid: <TAG>", var9, (Vector)null);
            this.NPCDlgMenus[i].Prev = this.GCanvas;
        }

        this.NPCDlgMenus[4] = new Menu(this, 5, 13);
        var9 = new String[]{"Give Item", "Take Crystal"};
        this.NPCDlgMenus[4].BuildMenu("Beneca", "Aid: <TAG>", var9, (Vector)null);
        this.NPCDlgMenus[4].Prev = this.GCanvas;
        this.NPCDlgMenus[5] = new Menu(this, 5, 14);
        String[] var10 = new String[]{"Rumors", "Give Crystal", "Enchant", "Bless", "Cure", "Warp", "Recovery"};
        this.NPCDlgMenus[5].BuildMenu("Helga", "Aid: <TAG>", var10, (Vector)null);
        this.NPCDlgMenus[5].Prev = this.GCanvas;
        this.DebugMsg("After choicesUI", true);
        this.OracleMenu = new Menu(this, 4, 23);
        this.OracleMenu.BuildMenu("Oracle", "NPC text here", true);
        this.OptionsMenu = new Menu(this, 3, 31);
        String[] var11 = new String[]{"Stats", "Inventory", "Skills", "Spells", "Save Game", "Load Game", "Help", "Quit Game"};
        this.OptionsMenu.BuildMenu("Options", var11, (Vector)null, false);
        this.OptionsMenu.AddElement(Menu.BackComm);
        this.DebugMsg("After OptionsUI", true);
        this.SplashMenu.LoadPct = 42;
        this.NameEntry = new Form("Enter name");
        StringItem var12 = new StringItem((String)null, "Enter a name for your character");
        this.NameEntry.append(var12);
        TextField var13 = new TextField((String)null, (String)null, 10, 0);
        this.NameEntry.append(var13);
        this.NameEntry.addCommand(Menu.OKComm);
        this.NameEntry.addCommand(Menu.CancelComm);
        this.NameEntry.setCommandListener(this);
        this.NoSaveGameMenu = new Menu(this, 4, 305);
        this.NoSaveGameMenu.BuildMenu("Unavailable", "No game is available for loading. Press OK to return to main menu.");
        this.NoSaveGameMenu.AddElement(Menu.OKComm);
        this.NoSaveGameMenu.SetListener(this);
        this.NoSaveGameMenu.Prev = this.MainMenu;
        this.DebugMsg("After NoSavedGameUI", true);
        this.SplashMenu.Next = this.MainMenu;
        this.NewGameMenu.Prev = this.MainMenu;
        this.CharacterMenu.Prev = this.NewGameMenu;
        this.InfoMenu.Prev = this.CharacterMenu;
        this.InfoMenu.Next = this.CharacterMenu;
        this.NewCharMenu.Prev = this.CharacterMenu;
        this.EndCreditsMenu = new Menu(this, 4, 399);
        this.EndCreditsMenu.BuildEndCreditMenu();
        this.SplashMenu.LoadPct = 55;
        Log("End of loading UI and images");
        this.DebugMsg("End of allocateAllUIs", true);
    }

    private Menu GiveMenu(int npc) {
        System.gc();
        Menu menu = new Menu(this, 5, 22);
        menu.npcID = npc;
        String[] InvStrings = new String[this.Player.InventoryCount];

        for(int i = 0; i < this.Player.InventoryCount; ++i) {
            int ItemID = Math.abs(this.Player.Inventory[i]);
            if (this.Player.IsEquiped(i)) {
                InvStrings[i] = "E:" + Item.GetItemName(ItemID);
            } else {
                InvStrings[i] = Item.GetItemName(ItemID);
            }
        }

        menu.BuildMenu(NPC.NPCNames[npc], "Give What?", InvStrings, (Vector)null, true);
        menu.Prev = this.GCanvas;
        return menu;
    }

    private Menu TrainMenu(int npc) {
        System.gc();
        Log("Start of newTrainWhat");
        Menu menu = new Menu(this, 5, 20);
        menu.npcID = npc;
        String[] skillstrs = new String[3];
        int var4 = 0;

        for(int i = 0; i < 14; ++i) {
            int var6 = this.Player.GetSkillVal(i, false);
            String skillstr = Character.Skills[i] + " (<TAG>)";
            if (Player.c(npc, i)) {
                skillstrs[var4++] = func.StringInsert(skillstr, "<TAG>", var6);
            }
        }

        menu.BuildMenu(NPC.NPCNames[npc], "Train What?", skillstrs, (Vector)null, true);
        menu.Prev = this.GCanvas;
        return menu;
    }

    private Menu TakeItemMenu(int npc) {
        System.gc();
        Log("Start of newTakeWhat");
        Menu menu = new Menu(this, 5, 27);
        menu.npcID = npc;
        String[] crystalStrs = Item.GetCrystals();
        menu.BuildMenu(NPC.NPCNames[npc], "Take What?", crystalStrs, (Vector)null, true);
        menu.Prev = null;
        return menu;
    }

    private Menu EnchantItemMenu(int npc) {
        System.gc();
        Log("Start of newEnchantWhat");
        Menu menu = new Menu(this, 5, 350);
        menu.npcID = npc;
        String[] ItemStrs = new String[this.Player.InventoryCount];

        for(int i = 0; i < this.Player.InventoryCount; ++i) {
            int itemID = Math.abs(this.Player.Inventory[i]);
            ItemStrs[i] = Item.GetItemName(itemID);
        }

        menu.BuildMenu(NPC.NPCNames[npc], "Enchant What?", ItemStrs, (Vector)null, true);
        menu.Prev = this.GCanvas;
        return menu;
    }

    private Menu StatsMenu() {
        Menu menu = new Menu(this, 4, 32);
        menu.BuildMenu("Stats", this.GCanvas.Char.GetStatsString());
        return menu;
    }

    private Menu InventoryMenu() {
        System.gc();
        Menu menu = new Menu(this, 5, 33);
        String[] InvStr = new String[this.Player.InventoryCount];

        for(int i = 0; i < this.Player.InventoryCount; ++i) {
            byte itemID = this.Player.Inventory[i];
            System.out.println("itemid is " + itemID);
            if (itemID < 0) {
                InvStr[i] = "E: " + Item.GetItemName(Math.abs(itemID));
                System.out.println("item is " + InvStr[i]);
            } else {
                InvStr[i] = Item.GetItemName(itemID);
                System.out.println("item is " + InvStr[i]);
            }
        }

        menu.BuildMenu("Inventory", "Items:", InvStr, (Vector)null, true);
        menu.Prev = this.OptionsMenu;
        return menu;
    }

    private Menu QuitMenu(Menu prevmenu) {
        System.gc();
        Menu menu = new Menu(this, 5, 202);
        String[] options = new String[]{"Yes", "No"};
        menu.BuildMenu("Quit?", "Are you sure?", options, (Vector)null, true);
        menu.Prev = prevmenu;
        return menu;
    }

    private Menu HelpMenu(Menu prevmenu) {
        System.gc();
        Menu menu = new Menu(this, 3, 203);
        menu.BuildMenu("Help", helpCats, (Vector)null);
        menu.Prev = prevmenu;
        return menu;
    }

    private Menu SpecHelpMenu(int helpindx) {
        System.gc();
        Menu menu = new Menu(this, 4, 206);
        menu.BuildMenu(helpCats[helpindx], HelpStrings[helpindx], true);
        menu.Prev = this.HelpMenu;
        return menu;
    }

    private Menu CreditsMenu(Menu prevmenu) {
        System.gc();
        Menu menu = new Menu(this, 4, 204);
        menu.BuildMenu("Credits", CreditString, true);
        menu.Prev = prevmenu;
        return menu;
    }

    public void pauseApp() {
        this.GCanvas.PauseGame();
        GameState = 3;
    }

    public void destroyApp(boolean var1) {
        GameState = 4;
    }

    public void commandAction(Command comm, Displayable disp) {
        if (CurrentMenu != null) {
            if (comm == Menu.CancelComm && CurrentMenu.Prev != null) {
                this.SetDisplayContent(CurrentMenu.Prev);
                return;
            }

            int indx;
            String[] optStrs;
            Thread thread1;
            Thread thread2;
            if (CurrentMenu.MenuID == 2) {
                if (comm == Menu.SelectComm) {
                    indx = CurrentMenu.GetSelectedIndex();
                    optStrs = CurrentMenu.GetOptStrings();
                    switch (indx) {
                        case 0:
                            System.gc();
                            this.NewGameLoadMenu = new Menu(this, 8, 301);
                            this.NewGameLoadMenu.SetDisplayableO();
                            thread1 = new Thread(this);
                            GameAction = 4;
                            thread1.start();
                            this.SetDisplayContent((Object)this.NewGameLoadMenu);
                            break;
                        case 1:
                            System.gc();
                            this.GCanvas.ClearGameThread();
                            HelperMenu = new Menu(this, 9, 302);
                            HelperMenu.SetDisplayableO();
                            thread2 = new Thread(this);
                            GameAction = 6;
                            thread2.start();
                            this.SetDisplayContent((Object) HelperMenu);
                            break;
                        case 2:
                            this.HelpMenu = this.HelpMenu(CurrentMenu);
                            this.SetDisplayContent((Object)this.HelpMenu);
                            break;
                        case 3:
                            this.CreditsMenu = this.CreditsMenu(CurrentMenu);
                            this.SetDisplayContent((Object)this.CreditsMenu);
                            break;
                        case 4:
                            this.QuitMenu = this.QuitMenu(CurrentMenu);
                            this.SetDisplayContent((Object)this.QuitMenu);
                    }
                }
            } else if (CurrentMenu.MenuID == 3) {
                if (comm == Menu.SelectComm) {
                    indx = CurrentMenu.GetSelectedIndex();
                    optStrs = CurrentMenu.GetOptStrings();
                    this.DefaultPlayer = null;
                    System.gc();
                    this.DefaultPlayer = new Character(this);
                    this.DefaultPlayer.LoadClassDefaults(indx);
                    this.DefaultPlayer.d(indx);
                    this.CharacterMenu.a(1, optStrs[indx]);
                    this.SetDisplayContent((Object)this.CharacterMenu);
                }
            } else if (CurrentMenu.MenuID == 4) {
                if (comm == Menu.SelectComm) {
                    indx = CurrentMenu.GetSelectedIndex();
                    optStrs = CurrentMenu.GetOptStrings();
                    if (indx == 0) {
                        String infoStr = this.DefaultPlayer.GetClassInfoStr();
                        this.InfoMenu.a(0, infoStr);
                        this.InfoMenu.w = 0;
                        this.SetDisplayContent((Object)this.InfoMenu);
                    } else {
                        this.Player = this.DefaultPlayer;
                        this.SetDisplayContent((Object)this.NewCharMenu);
                    }
                }
            } else if (CurrentMenu.MenuID == 5) {
                if (comm == Menu.OKComm) {
                    this.SetDisplayContent(CurrentMenu.Next);
                }
            } else if (CurrentMenu.MenuID == 6) {
                if (comm == Menu.SelectComm) {
                    this.SetDisplayContent((Object)this.NameEntry);
                }
            } else if (CurrentMenu.MenuID == 7) {
                this.IntroMenu = new Menu(this, 4, 101);
                this.IntroMenu.BuildMenu("Introduction", NPC.NPCStrings[7][3], true);
                this.SetDisplayContent((Object)this.IntroMenu);
            } else if (CurrentMenu.MenuID == 101) {
                if (comm == Menu.OKComm) {
                    this.GCanvas.Char = this.Player;
                    this.GCanvas.StartGame();
                    this.SetDisplayContent((Object)this.GCanvas);
                }
            } else if (CurrentMenu.MenuID != 8 && CurrentMenu.MenuID != 360) {
                if (CurrentMenu.MenuID >= 9 && CurrentMenu.MenuID <= 14) {
                    if (comm == Menu.CancelComm) {
                        this.SetDisplayContent(CurrentMenu.Prev);
                    } else {
                        this.d(CurrentMenu);
                    }
                } else {
                    int i;
                    int var10;
                    if (CurrentMenu.MenuID == 20) {
                        if (comm == Menu.SelectComm) {
                            indx = CurrentMenu.npcID;
                            i = CurrentMenu.GetSelectedIndex();
                            var10 = Player.b(indx, i);
                            this.ae = this.a(CurrentMenu, indx, 21, 5, var10);
                            this.SetDisplayContent((Object)this.ae);
                        } else if (comm == Menu.CancelComm) {
                            indx = CurrentMenu.npcID;
                            this.k(indx);
                            this.SetDisplayContent((Object)this.NPCDlgMenus[indx]);
                        }
                    } else if (CurrentMenu.MenuID == 22) {
                        if (comm == Menu.SelectComm) {
                            System.out.println("Found give what select");
                            indx = CurrentMenu.npcID;
                            i = CurrentMenu.GetSelectedIndex();
                            if (i >= 0) {
                                this.OracleMenu = this.a(CurrentMenu, indx, 23, 4, i);
                                this.SetDisplayContent((Object)this.OracleMenu);
                            }
                        } else if (comm == Menu.CancelComm) {
                            indx = CurrentMenu.npcID;
                            this.k(indx);
                            this.SetDisplayContent((Object)this.NPCDlgMenus[indx]);
                        }
                    } else if (CurrentMenu.MenuID == 27) {
                        if (comm == Menu.SelectComm) {
                            indx = CurrentMenu.npcID;
                            i = CurrentMenu.GetSelectedIndex() + 87;
                            this.aJ = this.a(CurrentMenu, indx, 28, 7, i);
                            this.SetDisplayContent((Object)this.aJ);
                        } else if (comm == Menu.CancelComm) {
                            indx = CurrentMenu.npcID;
                            this.k(indx);
                            this.SetDisplayContent((Object)this.NPCDlgMenus[indx]);
                        }
                    } else if (CurrentMenu.MenuID == 350) {
                        if (comm == Menu.SelectComm) {
                            indx = CurrentMenu.npcID;
                            i = CurrentMenu.GetSelectedIndex();
                            if (i >= 0) {
                                this.aI = this.a(CurrentMenu, indx, 351, 8, i);
                                this.SetDisplayContent((Object)this.aI);
                            }
                        } else if (comm == Menu.CancelComm) {
                            indx = CurrentMenu.npcID;
                            this.k(indx);
                            this.SetDisplayContent((Object)this.NPCDlgMenus[indx]);
                        }
                    } else if (CurrentMenu.MenuID != 23 && CurrentMenu.MenuID != 21 && CurrentMenu.MenuID != 24 && CurrentMenu.MenuID != 25 && CurrentMenu.MenuID != 28) {
                        if (CurrentMenu.MenuID == 26) {
                            this.SetDisplayContent((Object)this.GCanvas);
                        } else if (CurrentMenu.MenuID != 351 && CurrentMenu.MenuID != 352 && CurrentMenu.MenuID != 353 && CurrentMenu.MenuID != 355) {
                            if (CurrentMenu.MenuID == 30) {
                                if (comm == Menu.OKComm) {
                                    this.SetDisplayContent((Object)this.GCanvas);
                                }
                            } else if (CurrentMenu.MenuID == 41) {
                                if (comm == Menu.OKComm) {
                                    this.Player.Q = false;
                                    this.SetDisplayContent((Object)this.GCanvas);
                                }
                            } else if (CurrentMenu.MenuID == 31) {
                                if (comm == Menu.SelectComm) {
                                    indx = CurrentMenu.GetSelectedIndex();
                                    optStrs = CurrentMenu.GetOptStrings();
                                    switch (indx) {
                                        case 0:
                                            this.StatsMenu = this.StatsMenu();
                                            this.SetDisplayContent((Object)this.StatsMenu);
                                            break;
                                        case 1:
                                            this.InventoryMenu = this.InventoryMenu();
                                            this.SetDisplayContent((Object)this.InventoryMenu);
                                            break;
                                        case 2:
                                            this.SkillsListMenu = this.SkillsListMenu();
                                            this.SetDisplayContent((Object)this.SkillsListMenu);
                                            break;
                                        case 3:
                                            this.SpellsListMenu = this.SpellsListMenu();
                                            this.SetDisplayContent((Object)this.SpellsListMenu);
                                            break;
                                        case 4:
                                            al = new Menu(this, 10, 303);
                                            al.SetDisplayableO();
                                            thread1 = new Thread(this);
                                            GameAction = 5;
                                            thread1.start();
                                            this.SetDisplayContent((Object)al);
                                            break;
                                        case 5:
                                            System.gc();
                                            this.GCanvas.ClearGameThread();
                                            HelperMenu = new Menu(this, 9, 302);
                                            HelperMenu.SetDisplayableO();
                                            thread2 = new Thread(this);
                                            GameAction = 6;
                                            thread2.start();
                                            this.SetDisplayContent((Object) HelperMenu);
                                            break;
                                        case 6:
                                            Log("Help");
                                            this.HelpMenu = this.HelpMenu(CurrentMenu);
                                            this.SetDisplayContent((Object)this.HelpMenu);
                                            break;
                                        case 7:
                                            this.QuitMenu = this.QuitMenu(CurrentMenu);
                                            this.SetDisplayContent((Object)this.QuitMenu);
                                            break;
                                        case 8:
                                            this.DebugMenu();
                                            this.SetDisplayContent((Object)this.DebugMenu);
                                    }
                                } else if (comm == Menu.BackComm) {
                                    this.SetDisplayContent((Object)this.GCanvas);
                                }
                            } else if (CurrentMenu.MenuID == 32) {
                                if (comm == Menu.OKComm) {
                                    this.SetDisplayContent((Object)this.OptionsMenu);
                                }
                            } else if (CurrentMenu.MenuID == 33) {
                                if (comm == Menu.SelectComm) {
                                    indx = CurrentMenu.GetSelectedIndex();
                                    if (indx >= 0) {
                                        this.aB = this.InventoryItemMenu(indx);
                                        this.Y = indx;
                                        this.SetDisplayContent((Object)this.aB);
                                    }
                                }
                            } else if (CurrentMenu.MenuID == 34) {
                                if (comm == Menu.SelectComm) {
                                    indx = CurrentMenu.GetSelectedIndex();
                                    Integer var11 = (Integer) CurrentMenu.n.elementAt(indx);
                                    var10 = var11;
                                    if (var10 == 0) {
                                        this.Player.i(this.Y);
                                        this.InventoryMenu = this.InventoryMenu();
                                        this.SetDisplayContent((Object)this.InventoryMenu);
                                    } else if (var10 == 1) {
                                        if (!this.Player.IsEquiped(this.Y)) {
                                            this.Player.d(this.Y, true);
                                        } else {
                                            this.Player.A(this.Y);
                                        }

                                        this.InventoryMenu = this.InventoryMenu();
                                        this.SetDisplayContent((Object)this.InventoryMenu);
                                    } else if (var10 == 2) {
                                        this.Player.r(this.Y);
                                        this.InventoryMenu = this.InventoryMenu();
                                        this.SetDisplayContent((Object)this.InventoryMenu);
                                    } else if (var10 == 3) {
                                        this.Player.a(this.Y);
                                        if (this.Player.Q) {
                                            this.Player.Q = false;
                                            this.SetDisplayContent((Object)this.GCanvas);
                                        } else {
                                            this.InventoryMenu = this.InventoryMenu();
                                            this.SetDisplayContent((Object)this.InventoryMenu);
                                        }
                                    }

                                    this.Y = -1;
                                }
                            } else if (CurrentMenu.MenuID == 35) {
                                if (comm == Menu.SelectComm) {
                                    indx = CurrentMenu.GetSelectedIndex();
                                    this.SkillInfoMenu = this.SkillInfoMenu(indx);
                                    this.SetDisplayContent((Object)this.SkillInfoMenu);
                                }
                            } else if (CurrentMenu.MenuID == 36) {
                                if (comm == Menu.OKComm) {
                                    this.SetDisplayContent((Object)this.SkillsListMenu);
                                }
                            } else if (CurrentMenu.MenuID == 37) {
                                if (comm == Menu.SelectComm) {
                                    indx = CurrentMenu.GetSelectedIndex();
                                    if (indx >= 0) {
                                        this.SpellInfoMenu = this.SpellInfoMenu(indx);
                                        this.g = indx;
                                        this.SetDisplayContent((Object)this.SpellInfoMenu);
                                    }
                                }
                            } else if (CurrentMenu.MenuID == 38) {
                                if (comm == Menu.SelectComm) {
                                    indx = this.Player.IsSpellKnown(this.g);
                                    this.Player.CurSpell = (byte)(indx + 1);
                                    this.SpellsListMenu = this.SpellsListMenu();
                                    this.SetDisplayContent((Object)this.SpellsListMenu);
                                    this.g = -1;
                                }
                            } else if (CurrentMenu.MenuID == 39) {
                                if (comm == Menu.SelectComm) {
                                    String var14 = CurrentMenu.p();
                                    l[CurrentMenu.npcID] = -1;

                                    for(i = 0; i < Character.Attributes.length; ++i) {
                                        if (var14.equals(Character.Attributes[i])) {
                                            l[CurrentMenu.npcID] = i;
                                            break;
                                        }
                                    }

                                    if (CurrentMenu.npcID < 2) {
                                        var10 = CurrentMenu.npcID + 1;
                                        this.LevelUpMenu = this.LevelUpMenu(var10 + 1);
                                        this.SetDisplayContent((Object)this.LevelUpMenu);
                                    } else {
                                        short[] var10000 = this.Player.AttLvl;
                                        int var10001 = l[0];
                                        var10000[var10001] = (short)(var10000[var10001] + 3);
                                        var10000 = this.Player.AttLvl;
                                        var10001 = l[1];
                                        var10000[var10001] = (short)(var10000[var10001] + 2);
                                        ++this.Player.AttLvl[l[2]];
                                        this.Player.CalcAttributesMax();
                                        this.Player.ResetLvlProg();
                                        this.SetDisplayContent((Object)this.GCanvas);
                                        this.GCanvas.UnpauseGame();
                                    }
                                }
                            } else if (CurrentMenu.MenuID == 202) {
                                if (comm == Menu.SelectComm) {
                                    indx = CurrentMenu.GetSelectedIndex();
                                    if (indx == 0) {
                                        this.SetDisplayContent((Object)this.EndCreditsMenu);
                                    } else {
                                        this.SetDisplayContent(CurrentMenu.Prev);
                                    }
                                }
                            } else if (CurrentMenu.MenuID == 202) {
                                this.b();
                            } else if (CurrentMenu.MenuID == 40) {
                                this.SetDisplayContent((Object)this.GCanvas);
                                this.GCanvas.UnpauseGame();
                            } else if (CurrentMenu.MenuID == 102) {
                                this.SetDisplayContent((Object)this.GCanvas);
                                this.GCanvas.UnpauseGame();
                            } else if (CurrentMenu.MenuID == 203) {
                                if (comm == Menu.SelectComm) {
                                    indx = CurrentMenu.GetSelectedIndex();
                                    this.F = this.SpecHelpMenu(indx);
                                    this.SetDisplayContent((Object)this.F);
                                } else {
                                    this.SetDisplayContent(CurrentMenu.Prev);
                                }
                            } else if (CurrentMenu.MenuID == 206) {
                                this.SetDisplayContent(CurrentMenu.Prev);
                            } else if (CurrentMenu.MenuID == 204) {
                                this.SetDisplayContent(CurrentMenu.Prev);
                            } else if (CurrentMenu.MenuID == 305) {
                                this.SetDisplayContent(CurrentMenu.Prev);
                            } else if (CurrentMenu.MenuID == 205) {
                                this.SetDisplayContent(CurrentMenu.Prev);
                            } else if (CurrentMenu.MenuID != 200 && CurrentMenu.MenuID != 201) {
                                if (CurrentMenu.MenuID == 399) {
                                    this.b();
                                } else if (CurrentMenu.MenuID == 499) {
                                    this.b();
                                }
                            } else {
                                this.SetDisplayContent(CurrentMenu.Next);
                            }
                        } else if (comm == Menu.OKComm) {
                            indx = CurrentMenu.npcID;
                            this.k(indx);
                            this.SetDisplayContent((Object)this.NPCDlgMenus[indx]);
                        }
                    } else if (comm == Menu.OKComm) {
                        indx = CurrentMenu.npcID;
                        this.k(indx);
                        this.SetDisplayContent((Object)this.NPCDlgMenus[indx]);
                    }
                }
            } else if (comm == Menu.OKComm) {
                if (CurrentMenu.Next == null) {
                    System.out.println("ERROR: next is null!");
                } else {
                    Menu var7 = (Menu) CurrentMenu.Next;
                    if (var7 == null) {
                        System.out.println("uic.next is null!");
                    }
                }

                this.SetDisplayContent(CurrentMenu.Next);
            }
        } else if (disp == this.ErrorForm) {
            this.b();
        } else if (disp == this.DebugMenu) {
            this.SetDisplayContent((Object)this.GCanvas);
        } else if (disp == this.ExitForm) {
            if (comm == ExitComm) {
                this.b();
            }
        } else if (disp == this.NameEntry) {
            if (comm == Menu.OKComm) {
                TextField textField = (TextField)this.NameEntry.get(1);
                String name = textField.getString();
                if (name.length() < 3) {
                    Alert alert = new Alert("Error", func.StringInsert("Your character name must be at least <TAG> letters", "<TAG>", 3), (Image)null, AlertType.ERROR);
                    alert.setTimeout(-2);
                    this.SetDisplayContent((Object)alert);
                } else {
                    this.Player.CharName = name;
                    this.SetDisplayContent((Object)this.WelcomeMenu);
                }
            } else if (comm == Menu.CancelComm) {
                this.SetDisplayContent((Object)this.NewCharMenu);
            }
        }

    }

    private void d(Menu menu) {
        int var3 = menu.GetSelectedIndex();
        int var4 = menu.MenuID - 9;
        switch (var4) {
            case 0:
            case 1:
            case 2:
            case 3:
                if (var3 == 0) {
                    this.TrainMenu = this.TrainMenu(var4);
                    this.SetDisplayContent((Object)this.TrainMenu);
                } else if (var3 == 1) {
                    if (this.Player.InventoryCount <= 0) {
                        this.OracleMenu.SetTitle(NPC.NPCNames[var4]);
                        this.OracleMenu.SetText("You have nothing to give me!");
                        this.SetDisplayContent((Object)this.OracleMenu);
                    } else {
                        this.GiveMenu = this.GiveMenu(var4);
                        this.SetDisplayContent((Object)this.GiveMenu);
                    }
                } else if (var3 == 2) {
                    this.X = this.a(menu, var4, 24, 2, 0);
                    this.SetDisplayContent((Object)this.X);
                } else if (var3 == 3) {
                    this.V = this.a(menu, var4, 25, 3, 0);
                    this.SetDisplayContent((Object)this.V);
                } else if (var3 == 4) {
                    this.an = this.a(menu, var4, 26, 6, 0);
                    this.SetDisplayContent((Object)this.an);
                }
                break;
            case 4:
                if (var3 == 0) {
                    if (this.Player.InventoryCount <= 0) {
                        this.OracleMenu.SetTitle(NPC.NPCNames[var4]);
                        this.OracleMenu.SetText("You have nothing to give me!");
                        this.SetDisplayContent((Object)this.OracleMenu);
                    } else {
                        this.GiveMenu = this.GiveMenu(var4);
                        this.SetDisplayContent((Object)this.GiveMenu);
                    }
                } else if (var3 == 1) {
                    this.TakeItemMenu = this.TakeItemMenu(var4);
                    this.SetDisplayContent((Object)this.TakeItemMenu);
                }
                break;
            case 5:
                if (var3 == 0) {
                    this.x();
                } else if (var3 == 1) {
                    if (this.Player.InventoryCount <= 0) {
                        this.OracleMenu.SetTitle(NPC.NPCNames[var4]);
                        this.OracleMenu.SetText("You have nothing to give me!");
                        this.SetDisplayContent((Object)this.OracleMenu);
                    } else {
                        this.GiveMenu = this.GiveMenu(var4);
                        this.SetDisplayContent((Object)this.GiveMenu);
                    }
                } else if (var3 == 2) {
                    this.EnchantItemMenu = this.EnchantItemMenu(var4);
                    this.SetDisplayContent((Object)this.EnchantItemMenu);
                } else if (var3 == 3) {
                    this.aL = this.a(menu, var4, 352, 9, 0);
                    this.SetDisplayContent((Object)this.aL);
                } else if (var3 == 4) {
                    this.H = this.a(menu, var4, 353, 10, 0);
                    this.SetDisplayContent((Object)this.H);
                } else if (var3 == 5) {
                    this.K = this.a(menu, var4, 41, 11, 0);
                    this.SetDisplayContent((Object)this.K);
                } else if (var3 == 6) {
                    this.s = this.a(menu, var4, 355, 12, 0);
                    this.SetDisplayContent((Object)this.s);
                }
        }

    }

    private Menu a(Menu menu1, int NPCID, int menuID, int var4, int var5) {
        Menu menu = new Menu(this, 4, menuID);
        menu.BuildMenu("NPC name here", "NPC text here", true);
        String var7 = NPC.a(this.Player, NPCID, var4, var5);
        menu.SetTitle(NPC.NPCNames[NPCID]);
        menu.SetText(var7);
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
        HelperMenu.LoadPct = 0;
        String RecordName = this.GetLastSave();

        try {
            if (RecordName == null) {
                throw new Exception("No valid record store!");
            }

            store = RecordStore.openRecordStore(RecordName, false);
            int recordcount = store.getNumRecords();
            byte[] record = store.getRecord(1);
            this.Player = Character.LoadChar(record, true);
            this.Player.Game = this;
            HelperMenu.LoadPct = 20;
            HelperMenu.Paint();
            HelperMenu.ServiceRepaint();
            int var7 = a((RecordStore)store, 2);
            System.out.println("Read the master lists from RecordStore");
            record = store.getRecord(var7);
            LoadNPCData(record);
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
        RecordStore store = null;
        al.LoadPct = 0;
        String var4 = this.f();

        try {
            store = RecordStore.openRecordStore(var4, true);
            byte[] var5 = this.Player.EncodeCharData(true);
            al.LoadPct = 20;
            al.Paint();
            al.ServiceRepaint();
            store.addRecord(var5, 0, var5.length);
            System.gc();
            a(store);
            var5 = EncodeNPCData();
            store.addRecord(var5, 0, var5.length);
            Object var20 = null;
            System.gc();
            store.closeRecordStore();
            store = null;
            this.L();
            al.LoadPct = 100;
            al.Paint();
            al.ServiceRepaint();
        } catch (Throwable var18) {
            System.out.println("Exception in saveGameState");
            System.out.println(var18);

            try {
                RecordStore.deleteRecordStore(var4);
            } catch (Exception var17) {
            }

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

    private void y() {
        this.ErrorForm = new Form("Error");
        this.ErrorString = new StringItem("Error: ", "Cannot load game");
        this.ErrorForm.append(this.ErrorString);
        Command var1 = new Command("Ok", Command.OK, 1);
        this.ErrorForm.addCommand(var1);
        this.ErrorForm.setCommandListener(this);
    }

    private void DebugMsg(String logstr, boolean var2) {
        this.UpdateLog(logstr);
        boolean var3 = false;
        if (var3) {
            String var4 = this.ErrorString.getText();
            var4 = var4 + "\n" + CheckMem(logstr);
            this.ErrorString.setText(var4);
        } else {
            this.ErrorString.setText(CheckMem(logstr));
        }

    }

    void OutOfMemErrorScreen() {
        this.DebugMsg("Out of memory", true);
        this.dspl.setCurrent(this.ErrorForm);
    }

    static int GetGameAdvLevel(int giftpoints) {
        System.out.println("In getGameAdvancementLevel, giftPoints = " + giftpoints);
        if (giftpoints < 9) {
            return 0;
        } else if (giftpoints < 13) {
            return 1;
        } else if (giftpoints < 17) {
            return 2;
        } else if (giftpoints < 23) {
            return 3;
        } else if (giftpoints < 28) {
            return 4;
        } else if (giftpoints < 34) {
            return 5;
        } else if (giftpoints < 40) {
            return 6;
        } else {
            return giftpoints < 48 ? 7 : 8;
        }
    }

    void PopulateDungeons(int AdvLevel) {
        System.out.println("In checkOpenAndPopulateDungeons, gameAdvLevel = " + AdvLevel);
        int[] var2 = x[AdvLevel];
        int var3 = var2.length;

        for(int i = 0; i < var3; ++i) {
            int var5 = x[AdvLevel][i];
            int var6 = var5 - 1;
            if (!dungeons[var6].k) {
                dungeons[var6].k = true;
                dungeons[var6].e();
            }

            if (this.NewGameLoadMenu != null) {
                this.NewGameLoadMenu.LoadPct = 100 * (i + 1) / var3;
                if (this.NewGameLoadMenu.LoadPct > 100) {
                    this.NewGameLoadMenu.LoadPct = 100;
                }

                this.NewGameLoadMenu.Paint();
                this.NewGameLoadMenu.ServiceRepaint();
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
                HelperMenu.LoadPct = 100 * var1 / var2;
                if (HelperMenu.LoadPct > 100) {
                    HelperMenu.LoadPct = 100;
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

    private static void LoadDungeonTables() {
        MonsterTable = new Hashtable[37];

        for(int i = 1; i < 37; ++i) {
            MonsterTable[i] = new Hashtable();
        }

        ChestTable = new Hashtable[37];

        for(int i = 1; i < 37; ++i) {
            ChestTable[i] = new Hashtable();
        }

        DroppedItemsTable = new Vector[37];

        for(int i = 0; i < 37; ++i) {
            DroppedItemsTable[i] = new Vector();
        }

    }

    private static void LoadNPCData(byte[] btarr) throws Exception {
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(btarr, 0, btarr.length));
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
                Dungeon dung = dungeons[0];
                dung.DngnVec[NPC.NPCXPos[i]][NPC.NPCYPos[i]] = func.c((byte)32, dung.DngnVec[NPC.NPCXPos[i]][NPC.NPCYPos[i]]);
            }
        }

    }

    private static byte[] EncodeNPCData() throws Exception {
        ByteArrayOutputStream btarr = new ByteArrayOutputStream(60);
        DataOutputStream data = new DataOutputStream(btarr);
        data.writeShort(Item.ia);
        data.writeShort(Monster.J);

        for(int i = 0; i < 7; ++i) {
            data.writeBoolean(NPC.b[i]);
        }

        for(int i = 0; i < 7; ++i) {
            data.writeBoolean(NPC.FirstMeet[i]);
        }

        for(int i = 0; i < 4; ++i) {
            data.writeShort(NPC.r[i]);
        }

        for(int i = 0; i < 4; ++i) {
            data.writeShort(NPC.p[i]);
        }

        for(int i = 0; i < 4; ++i) {
            data.writeShort(NPC.h[i]);
        }

        for(int i = 0; i < 4; ++i) {
            data.writeByte(NPC.c[i]);
        }

        for(int i = 0; i < 4; ++i) {
            data.writeByte(NPC.n[i]);
        }

        data.writeByte(NPC.f);
        data.writeBoolean(NPC.WardenPresent);
        data.writeShort(NPC.a);
        data.writeShort(NPC.g);
        data.writeBoolean(NPC.l);
        byte[] arr = btarr.toByteArray();
        return arr;
    }

    private static void a(RecordStore store) throws Exception {
        int var1;
        int var3;
        Enumeration var6;
        Monster var8;
        Enumeration var19;
        for(int i = 1; i < 37; ++i) {
            var3 = MonsterTable[i].size();
            var1 = 4 + var3 * 28;
            ByteArrayOutputStream var4 = new ByteArrayOutputStream(var1);
            DataOutputStream var5 = new DataOutputStream(var4);
            var5.writeInt(var3);
            var6 = MonsterTable[i].elements();

            byte[] var7;
            while(var6.hasMoreElements()) {
                var7 = (byte[])var6.nextElement();
                var8 = Monster.a(var7);
                var8.a(var5);
            }

            var7 = var4.toByteArray();
            store.addRecord(var7, 0, var7.length);

            try {
                var5.close();
            } catch (Exception var13) {
            }

            var5 = null;
            var19 = null;
            System.gc();
            al.LoadPct = 20 + 30 * (i + 1) / 37;
            al.Paint();
            al.ServiceRepaint();
        }

        int var14;
        for(var3 = 1; var3 < 37; ++var3) {
            var14 = ChestTable[var3].size();
            var1 = 4 + var14 * 8;
            ByteArrayOutputStream var15 = new ByteArrayOutputStream(var1);
            DataOutputStream var17 = new DataOutputStream(var15);
            var17.writeInt(var14);
            var19 = ChestTable[var3].elements();

            byte[] var21;
            while(var19.hasMoreElements()) {
                var21 = (byte[])var19.nextElement();
                a(var17, var21, 8);
            }

            var21 = var15.toByteArray();
            store.addRecord(var21, 0, var21.length);

            try {
                var17.close();
            } catch (Exception var12) {
            }

            var6 = null;
            var8 = null;
            System.gc();
            al.LoadPct = 50 + 30 * (var3 + 1) / 37;
            al.Paint();
            al.ServiceRepaint();
        }

        for(var14 = 0; var14 < 37; ++var14) {
            int var16 = DroppedItemsTable[var14].size();
            var1 = 4 + var16 * 7;
            ByteArrayOutputStream var18 = new ByteArrayOutputStream(var1);
            DataOutputStream var20 = new DataOutputStream(var18);
            var20.writeInt(var16);
            Enumeration var22 = DroppedItemsTable[var14].elements();

            byte[] var9;
            while(var22.hasMoreElements()) {
                var9 = (byte[])var22.nextElement();
                a(var20, var9, 7);
            }

            var9 = var18.toByteArray();
            store.addRecord(var9, 0, var9.length);

            try {
                var20.close();
            } catch (Exception var11) {
            }

            var19 = null;
            Object var23 = null;
            System.gc();
            al.LoadPct = 80 + 19 * (var14 + 1) / 37;
            al.Paint();
            al.ServiceRepaint();
        }

    }

    private static int a(RecordStore store, int var1) throws Exception {
        int var2 = var1;

        DataInputStream data;
        int var7;
        for(int i = 1; i < 37; ++i) {
            byte[] record = store.getRecord(var2++);
            data = new DataInputStream(new ByteArrayInputStream(record, 0, record.length));
            MonsterTable[i].clear();
            int var6 = data.readInt();

            for(var7 = 0; var7 < var6; ++var7) {
                Monster var8 = Monster.a(data);
                String var9 = String.valueOf(var8.a);
                MonsterTable[i].put(var9, var8.f());
            }

            try {
                data.close();
            } catch (Exception var13) {
            }

            data = null;
            Object var14 = null;
            System.gc();
            HelperMenu.LoadPct = 20 + 30 * (i + 1) / 37;
            HelperMenu.Paint();
            HelperMenu.ServiceRepaint();
        }

        DataInputStream var18;
        int var21;
        for(int i = 1; i < 37; ++i) {
            byte[] var16 = store.getRecord(var2++);
            var18 = new DataInputStream(new ByteArrayInputStream(var16, 0, var16.length));
            ChestTable[i].clear();
            var7 = var18.readInt();

            for(var21 = 0; var21 < var7; ++var21) {
                byte[] var22 = a((DataInputStream)var18, 8);
                String var10 = func.StrCatComma((int)var22[0], var22[1]);
                ChestTable[i].put(var10, var22);
            }

            try {
                var18.close();
            } catch (Exception var12) {
            }

            var18 = null;
            data = null;
            System.gc();
            HelperMenu.LoadPct = 50 + 30 * (i + 1) / 37;
            HelperMenu.Paint();
            HelperMenu.ServiceRepaint();
        }

        for(int i = 0; i < 37; ++i) {
            byte[] var19 = store.getRecord(var2++);
            DataInputStream var20 = new DataInputStream(new ByteArrayInputStream(var19, 0, var19.length));
            DroppedItemsTable[i].removeAllElements();
            var21 = var20.readInt();

            for(int j = 0; j < var21; ++j) {
                byte[] var24 = a((DataInputStream)var20, 7);
                DroppedItemsTable[i].addElement(var24);
            }

            try {
                var20.close();
            } catch (Exception var11) {
            }

            var20 = null;
            var18 = null;
            System.gc();
            HelperMenu.LoadPct = 80 + 19 * (i + 1) / 37;
            HelperMenu.Paint();
            HelperMenu.ServiceRepaint();
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
        this.ExitForm = new Form("Done");
        StringItem var1 = new StringItem((String)null, "I am done");
        this.ExitForm.append(var1);
        this.ExitForm.addCommand(ExitComm);
        this.ExitForm.setCommandListener(this);
    }

    private void LoadWardenImg() {
        byte[] var1 = new byte[5];
        System.out.println("LOADING WARDEN IMAGES");
        var1[0] = 1;
        var1[1] = 1;
        var1[2] = 1;
        var1[3] = 1;
        var1[4] = 1;
        this.CurrentDung = 1;
        this.ImageLoader(var1);
    }

    void LoadDngImgs() {
        System.out.println("Running image loader thread for new dungeon ID: " + this.CurrentDung);
        this.am = false;
        if (jj) {
            HelperMenu.LoadPct = 80;
        } else {
            this.ab.LoadPct = 0;
        }

        byte[] var1 = new byte[5];

        for(int i = 0; i < 5; ++i) {
            var1[i] = 0;
        }

        if (this.CurrentDung == 1) {
            this.UnloadMonImg();
            this.LoadWardenImg();
        } else {
            Hashtable var3 = MonsterTable[this.CurrentDung - 1];
            if (var3 == null) {
                return;
            }

            Enumeration var4 = var3.elements();

            while(true) {
                while(var4.hasMoreElements()) {
                    byte[] var5 = (byte[])var4.nextElement();
                    Monster var6 = Monster.a(var5);
                    if (var6.MonNum >= 1 && var6.MonNum <= 5) {
                        ++var1[0];
                    } else if (var6.MonNum >= 6 && var6.MonNum <= 10) {
                        ++var1[1];
                    } else if (var6.MonNum >= 11 && var6.MonNum <= 25) {
                        ++var1[2];
                    } else if (var6.MonNum >= 26 && var6.MonNum <= 40) {
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

        GameCanvas.E = true;
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
        this.DebugMsg("Inside runImageLoader", true);

        try {
            for(int i = 0; i < 5; ++i) {
                if (var1[i] > 0) {
                    this.DebugMsg("Handling ichunk = " + i, true);
                    int var3 = ah[i][0];
                    int var4 = ah[i][1];

                    for(int j = 0; j < var4; ++j) {
                        int var6 = var3 + j;
                        if (!this.m(var6)) {
                            GameCanvas.MonImgs[var6] = CusImg.LoadCus(MonFNames[i][j]);
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
                    HelperMenu.LoadPct = 80 + (i + 1) * 20 / 5;
                    HelperMenu.Paint();
                    HelperMenu.ServiceRepaint();
                } else {
                    this.ab.LoadPct = (i + 1) * 100 / 5;
                    this.ab.Paint();
                    this.ab.ServiceRepaint();
                }
            }

            this.am = true;
            System.out.println("SUCCESSFULLY LOADED MONSTER IMAGES!!");
            this.ak = false;
        } catch (Throwable err) {
            System.out.println("ERROR in image loader: " + err);
            this.dspl.setCurrent(this.ErrorForm);
        }

    }

    void UnloadMonImg() {
        int var1 = GameCanvas.MonImgs.length;

        for(int i = 0; i < var1; ++i) {
            if (GameCanvas.MonImgs[i] != null) {
                GameCanvas.MonImgs[i].ImgBuf = null;
                GameCanvas.MonImgs[i] = null;
            }
        }

        System.gc();
        Log("After unloading all monster images");
    }

    static void KillMonster(int dngnID, int var1) {
        System.out.println("In killMonster! dungid is " + dngnID);
        byte[] var2 = (byte[]) MonsterTable[dngnID - 1].remove(String.valueOf(var1));
        byte var3 = var2[4];
        byte var4 = var2[5];
        Dungeon var5 = dungeons[dngnID - 1];
        if (var2 != null) {
            var5.DngnVec[var3][var4] = func.c((byte)2, var5.DngnVec[var3][var4]);
        }

        System.out.println("End of killMonster, size of HT is " + MonsterTable[dngnID - 1].size());
    }

    private Menu InventoryItemMenu(int ItemIndx) {
        Menu menu = new Menu(this, 5, 34);
        System.out.println("In newInventoryItemUI: getting item " + ItemIndx);
        String itemString = this.Player.ItemString(ItemIndx);
        Vector optionvec = new Vector();
        Vector optKeys = new Vector();
        optionvec.addElement("Drop");
        optKeys.addElement(Integer.valueOf(0));
        if (this.Player.IsEquipable(ItemIndx)) {
            if (!this.Player.IsEquiped(ItemIndx)) {
                optionvec.addElement("Equip");
            } else {
                optionvec.addElement("Unequip");
            }

            optKeys.addElement(Integer.valueOf(1));
        }

        if (this.Player.e(ItemIndx)) {
            optionvec.addElement("Learn");
            optKeys.addElement(Integer.valueOf(2));
        }

        if (this.Player.v(ItemIndx)) {
            optionvec.addElement("Use");
            optKeys.addElement(Integer.valueOf(3));
        }

        String[] optionStrs = new String[optionvec.size()];

        for(int i = 0; i < optionvec.size(); ++i) {
            optionStrs[i] = (String)optionvec.elementAt(i);
        }

        menu.BuildMenu("Item", itemString, optionStrs, optKeys);
        menu.A = true;
        menu.Prev = this.InventoryMenu;
        return menu;
    }

    private Menu SkillsListMenu() {
        System.gc();
        Log("Start of newSkillsListUI");
        Menu menu = new Menu(this, 5, 35);
        Vector var2 = this.Player.GetSkillList();
        int var3 = var2.size();
        String[] var4 = new String[var3];

        for(int i = 0; i < var3; ++i) {
            var4[i] = (String)var2.elementAt(i);
        }

        menu.BuildMenu("Skills", "Your Skills:", var4, (Vector)null, true);
        menu.Prev = this.OptionsMenu;
        return menu;
    }

    private Menu SkillInfoMenu(int var1) {
        System.gc();
        Log("Start of newSkillInfoUI");
        Menu menu = new Menu(this, 4, 36);
        int var3 = this.Player.l(var1);
        String var4 = this.Player.GetSkillString(var3);
        menu.BuildMenu("Skill Info", var4);
        menu.Prev = this.SkillsListMenu;
        return menu;
    }

    private Menu SpellsListMenu() {
        System.gc();
        Log("Start of newSpellsListUI");
        Menu menu = new Menu(this, 5, 37);
        Vector knownSpells = this.Player.GetKnownSpells();
        int spellcount = knownSpells.size();
        String[] spellStrings = new String[spellcount];

        for(int i = 0; i < spellcount; ++i) {
            spellStrings[i] = (String)knownSpells.elementAt(i);
        }

        menu.BuildMenu("Spells", "Your Spells:", spellStrings, (Vector)null, true);
        menu.Prev = this.OptionsMenu;
        return menu;
    }

    private Menu SpellInfoMenu(int indx) {
        System.gc();
        Log("Start of newSpellInfoUI");
        Menu menu = new Menu(this, 5, 38);
        int spellindx = this.Player.IsSpellKnown(indx);
        String spellStr = this.Player.GetSpellInfoStr(spellindx);
        String[] headertxt = new String[]{"Ready Spell"};
        menu.BuildMenu("Spell Info", spellStr, headertxt, (Vector)null);
        menu.A = true;
        menu.Prev = this.SpellsListMenu;
        return menu;
    }

    Menu LevelUpMenu(int indx) {
        System.gc();
        Log("Start of newLevelUpUI: index= " + indx);
        Menu menu = new Menu(this, 5, 39);
        String[] skilllist = this.Player.GetSkillIncreases();
        String headrtxt = null;
        if (indx == 1) {
            menu.npcID = 0;
            headrtxt = "Select an attribute to \nincrease 3 points:";
        } else if (indx == 2) {
            headrtxt = "Select an attribute to \nincrease 2 points:";
            menu.npcID = 1;
        } else if (indx == 3) {
            menu.npcID = 2;
            headrtxt = "Select an attribute to \nincrease 1 point:";
        }

        menu.BuildMenu("Level Up", headrtxt, skilllist, (Vector)null);
        menu.displayable.removeCommand(Menu.CancelComm);
        menu.A = true;
        menu.Prev = menu;
        return menu;
    }

    Menu WardenSpeaksMenu(String var1) {
        System.gc();
        Log("Start of newWardenSpeaksUI");
        Menu menu = new Menu(this, 4, 102);
        menu.BuildMenu("Varus", var1);
        return menu;
    }

    Menu EndOfGameMenu() {
        System.gc();
        Log("Start of newEndOfGameUI");
        String var1 = NPC.NPCStrings[7][4];
        Menu menu = new Menu(this, 4, 200);
        menu.BuildMenu("Victory!", var1);
        menu.Next = this.GameOverMenu();
        return menu;
    }

    private Menu GameOverMenu() {
        System.gc();
        Log("Start of newGameOverUI");
        String var1 = NPC.NPCStrings[7][5];
        Menu menu = new Menu(this, 4, 201);
        menu.BuildMenu("Game Over", var1);
        menu.Next = this.MainMenu;
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

    void SetDisplayContent(Object obj) {
        if (CurrentMenu != null) {
            if (obj instanceof Menu) {
                Menu menu = (Menu)obj;
                if (CurrentMenu != menu) {
                    CurrentMenu.q();
                }
            } else {
                CurrentMenu.q();
            }
        }

        if (this.GCanvas != null) {
            this.GCanvas.PauseGame();
        }

        if (this.dspl == null) {
            this.dspl = Display.getDisplay(this);
        }

        if (obj instanceof Menu) {
            CurrentMenu = (Menu)obj;
            MenuCanvas mcanvas = Menu.GetCanvas();
            mcanvas.menu = CurrentMenu;
            CurrentMenu.displayable = mcanvas;
            this.dspl.setCurrent(CurrentMenu.displayable);
            CurrentMenu.StartHelper();
            CurrentMenu.Paint();
            CurrentMenu.ServiceRepaint();
        } else if (obj instanceof Displayable) {
            Displayable displayable = (Displayable)obj;
            CurrentMenu = null;
            this.dspl.setCurrent(displayable);
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

    private void DebugMenu() {
        this.DebugMenu = new Form("Debug");
        String var1 = this.GCanvas.Char.GetDebugString();
        this.DebugString = new StringItem("Debug: ", var1);
        this.DebugMenu.append(this.DebugString);
        Command comm = new Command("Ok", 4, 1);
        this.DebugMenu.addCommand(comm);
        this.DebugMenu.setCommandListener(this);
    }

    synchronized void UpdateLog(String logstr) {
        Log = logstr;
    }

    private void GetHelpCats() {
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

    private void GetHelpStrings() {
        StringBuffer strbuff = new StringBuffer(1200);
        strbuff.append(NPC.NPCStrings[7][7]);
        HelpStrings[0] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][9]);
        strbuff.append(NPC.NPCStrings[7][10]);
        HelpStrings[1] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][12]);
        HelpStrings[2] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][14]);
        strbuff.append(NPC.NPCStrings[7][15]);
        strbuff.append(NPC.NPCStrings[7][16]);
        strbuff.append(NPC.NPCStrings[7][17]);
        strbuff.append(NPC.NPCStrings[7][18]);
        HelpStrings[3] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][20]);
        HelpStrings[4] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][22]);
        strbuff.append(NPC.NPCStrings[7][23]);
        HelpStrings[5] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][25]);
        strbuff.append(NPC.NPCStrings[7][26]);
        strbuff.append(NPC.NPCStrings[7][27]);
        strbuff.append(NPC.NPCStrings[7][28]);
        HelpStrings[6] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][30]);
        HelpStrings[7] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][32]);
        strbuff.append(NPC.NPCStrings[7][33]);
        HelpStrings[8] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][35]);
        strbuff.append(NPC.NPCStrings[7][36]);
        HelpStrings[9] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][38]);
        HelpStrings[10] = strbuff.toString();
        strbuff.delete(0, 1200);
        strbuff.append(NPC.NPCStrings[7][40]);
        HelpStrings[11] = strbuff.toString();
        strbuff.delete(0, 1200);
    }

    private String CreditsStr() {
        StringBuffer CredStr = new StringBuffer(400);
        CredStr.append("Game Design: Anthony Gill and Greg Gorden");
        CredStr.append('\n');
        CredStr.append("Art: Mark Jones");
        CredStr.append('\n');
        CredStr.append("Programming: Marc Ilgen");
        CredStr.append('\n');
        CredStr.append("Technical Director: Andrew Friedman");
        CredStr.append('\n');
        CredStr.append("(C) 2003 Vir2L Studos, a ZeniMax Media company. The Elder Scrolls and Vir2L are ");
        CredStr.append("registered trademarks of ZeniMax Media Inc. All rights reserved.");
        CredStr.append('\n');
        return CredStr.toString();
    }

    private void k(int var1) {
        String var2 = this.NPCDlgMenus[var1].M;
        String var3 = this.NPCDlgMenus[var1].GetText();
        short var4 = 0;
        if (NPC.b(var1)) {
            var4 = NPC.p[var1];
        } else if (var1 == 4) {
            var4 = Player.OldYPos;
        } else if (var1 == 5) {
            var4 = NPC.g;
        }

        var3 = func.StringInsert(var2, "<TAG>", var4);
        this.NPCDlgMenus[var1].SetText(var3);
    }

    private String f() {
        String[] RecordList = RecordStore.listRecordStores();
        boolean var2 = false;
        int var7;
        if (RecordList == null) {
            var7 = 0;
        } else {
            var7 = RecordList.length;
        }

        int var3 = func.a(10000);
        String var4 = "es_gamestate" + var3;

        while(true) {
            boolean var5 = false;

            for(int i = 0; i < var7; ++i) {
                if (var4.equals(RecordList[i])) {
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
        String var1 = NPC.a(this.Player, 5, 13, 0);
        if (var1 == null) {
            var1 = "No rumors!";
        }

        this.RumorMenu.SetTitle(NPC.NPCNames[5]);
        this.RumorMenu.SetText(var1);
        this.RumorMenu.Next = this.NPCDlgMenus[5];
        this.RumorMenu.npcID = 5;
        Menu var2 = (Menu)this.RumorMenu.Next;
        String var3 = var2.M;
        String var4 = var2.GetText();
        boolean var5 = false;
        short var6 = NPC.g;
        var4 = func.StringInsert(var3, "<TAG>", var6);
        var2.SetText(var4);
        this.SetDisplayContent((Object)this.RumorMenu);
    }

    private void j() {
        if (GameState == 4) {
            this.b();
        }

    }

    static {
        try {
            P = new Random(System.currentTimeMillis());
            RunLoadCamp();
            LoadMonsterFPaths();
            LoadDungeonTables();
        } catch (Exception err) {
            System.out.println("ERROR: problem with loading camp or image record HT");
        }

    }
}
