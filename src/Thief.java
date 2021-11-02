/** Class that represents a thief.
 */
public class Thief extends MovingRole {
    /** Type name of thief.
     */
    public static final String TYPE = "Thief";

    private boolean consuming;

    /** Create a thief.
     * @param x Thief's x position.
     * @param y Thief's y position.
     */
    public Thief(int x, int y) {
        super("res/images/thief.png", TYPE, x, y);
        this.setDirection(Direction.UP);
        this.consuming = false;
    }

    /** Get the consuming status of the thief.
     * @return The consuming boolean.
     */
    public boolean isConsuming() {
        return consuming;
    }

    /** Set the consuming status of the thief.
     * @param consuming New consuming status.
     */
    public void setConsuming(boolean consuming) {
        this.consuming = consuming;
    }

    /** Update the thief's status.
     */
    @Override
    public void update() {
        if (this.isActive()) {
            directionMove();
        }
        if (this.stand(ShadowLife.actors) != null) {
            Actor actor = this.stand(ShadowLife.actors);
            actor.meetThief(this);
        }
    }

    /** Update when a gatherer is standing on the thief.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {}

    /** Update when a thief is standing on the thief.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {}
}
