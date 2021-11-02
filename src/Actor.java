import bagel.Image;

/** Abstract class that represents an actor.
 * Based on Project 1 sample solution.
 */
public abstract class Actor {
    private int x;
    private int y;
    protected final Image image;
    protected final String type;

    /** Create an actor.
     * @param filename File which stores the actor's image.
     * @param type Type name of the actor.
     * @param x Actor's x position.
     * @param y Actor's y position.
     */
    public Actor(String filename, String type, int x, int y) {
        image = new Image(filename);
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /** Get actor's x position.
     * @return Actor's x position.
     */
    public int getX() {
        return x;
    }

    /** Get actor's y position.
     * @return Actor's y position.
     */
    public int getY() {
        return y;
    }

    /** Move the actor to a new position.
     * @param deltaX Change of x position.
     * @param deltaY Change of y position.
     */
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    /** Update the actor's status in a tick.
     */
    public final void tick() {
        update();
    }

    /** Render the actor.
     */
    public void render() {
        image.drawFromTopLeft(x, y);
    }

    /** Update the actor's status.
     */
    public abstract void update();

    /** Update when encounter a gatherer.
     * @param gatherer The gatherer encountered.
     */
    public abstract void meetGatherer(Gatherer gatherer);

    /** Update when encounter a thief.
     * @param thief The thief encountered.
     */
    public abstract void meetThief(Thief thief);
}
