import bagel.AbstractGame;
import bagel.Image;
import bagel.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/** Class that simulate the virtual world.
 * Based on Project 1 sample solution.
 */
public class ShadowLife extends AbstractGame {
    /** Size of one tile.
     */
    public static final int TILE_SIZE = 64;

    private final int TICK_RATE;
    private final int MAX_TICK;
    private final String FILE;

    private long lastTick = 0;
    private int tickCount = 0;
    private final Image BACKGROUND = new Image("res/images/background.png");
    // Create a list of all stockpiles and hoards.
    private ArrayList<Actor> warehouses;

    /** A list of all actors.
     */
    public static CopyOnWriteArrayList<Actor> actors;
    /** Number of moving roles.
     */
    public static int numMovingRole = 0;
    /** Number of inactive moving roles.
     */
    public static int numInactive = 0;

    /** Create a simulation,
     * @param arg0 The first argument.
     * @param arg1 The second argument.
     * @param arg2 The third argument.
     */
    public ShadowLife(String arg0, String arg1, String arg2) {
        this.TICK_RATE = Integer.parseInt(arg0);
        this.MAX_TICK = Integer.parseInt(arg1);
        if (TICK_RATE < 0 || MAX_TICK < 0) {
            argError();
        }
        this.FILE = arg2;
        loadActors();
    }

    // Read data from the given file and load all the actors.
    private void loadActors() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.FILE))) {
            String line;
            actors = new CopyOnWriteArrayList<>();
            warehouses = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                // Line format: type,x,y
                count++;
                String[] parts = line.split(",");
                try {
                    String type = parts[0];
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    if (x < 0 || x > 1024 || y < 0 || y > 768) {
                        lineError(this.FILE, count);
                    }
                    switch (type) {
                        case Tree.TYPE:
                            actors.add(new Tree(x, y));
                            break;
                        case GoldenTree.TYPE:
                            actors.add(new GoldenTree(x, y));
                            break;
                        case Stockpile.TYPE:
                            Actor stockpile = new Stockpile(x, y);
                            actors.add(stockpile);
                            warehouses.add(stockpile);
                            break;
                        case Hoard.TYPE:
                            Actor hoard = new Hoard(x, y);
                            actors.add(hoard);
                            warehouses.add(hoard);
                            break;
                        case Fence.TYPE:
                            actors.add(new Fence(x, y));
                            break;
                        case Pool.TYPE:
                            actors.add(new Pool(x, y));
                            break;
                        case Pad.TYPE:
                            actors.add(new Pad(x, y));
                            break;
                        case SignUp.TYPE:
                            actors.add(new SignUp(x, y));
                            break;
                        case SignDown.TYPE:
                            actors.add(new SignDown(x, y));
                            break;
                        case SignLeft.TYPE:
                            actors.add(new SignLeft(x, y));
                            break;
                        case SignRight.TYPE:
                            actors.add(new SignRight(x, y));
                            break;
                        case Thief.TYPE:
                            actors.add(new Thief(x, y));
                            numMovingRole++;
                            break;
                        case Gatherer.TYPE:
                            actors.add(new Gatherer(x, y));
                            numMovingRole++;
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    lineError(this.FILE, count);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error: file \"" + this.FILE + "\" not found");
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    // Check if all the moving roles are inactive.
    private boolean inactive() {
        return numMovingRole == numInactive;
    }

    // Print the amount of fruit at each stockpile and hoard.
    private void printFruit() {
        for (Actor actor: warehouses) {
            FruitRole warehouse = (FruitRole) actor;
            System.out.println(warehouse.numFruit);
        }
    }

    /** Update all the actors' status and render them.
     * @param input Provide access to input devices.
     */
    @Override
    protected void update(Input input) {
        // Check if all the moving roles are inactive.
        // Print the results it the program ends.
        if (inactive()) {
            System.out.println(tickCount);
            printFruit();
            System.exit(0);
        }
        // If enough time has passed, run the next tick.
        if (System.currentTimeMillis() - lastTick > TICK_RATE) {
            lastTick = System.currentTimeMillis();
            tickCount++;
            // If more than the max number of ticks pass, stop the simulation.
            if (tickCount == MAX_TICK) {
                System.out.println("Timed out");
                System.exit(-1);
            }
            // Update actors' status in one tick.
            for (Actor actor: actors) {
                if (actor != null) {
                    actor.tick();
                }
            }
        }
        // Render the background and all the actors.
        BACKGROUND.drawFromTopLeft(0, 0);
        for (Actor actor: actors) {
            if (actor != null) {
                actor.render();
            }
        }
    }

    // Exit the program if error occurs in command-line arguments.
    private static void argError() {
        System.out.println("usage: ShadowLife <tick rate> <max ticks> <world file>");
        System.exit(-1);
    }

    // Exit the program if error occurs when reading a line.
    private static void lineError(String file, int line) {
        System.out.println("error: in file \"" + file + "\" at line " + line + ".");
        System.exit(-1);
    }

    // Read arguments from args.txt. (MACOS bug)
    private static String[] argsFromFile() {
        try {
            return Files.readString(Path.of("args.txt"), Charset.defaultCharset()) .split(" ");
        } catch (IOException e) { e.printStackTrace();
        }
        return null;
    }

    /** Main method to run the simulation.
     */
    public static void main(String[] args) {
        String[] arg = argsFromFile();
        // Check if the number of arguments is 3.
        if (Objects.requireNonNull(arg).length != 3) {
            argError();
        }
        // Run the simulation.
        ShadowLife test = new ShadowLife(arg[0], arg[1], arg[2]);
        test.run();
    }
}
