/** Class that represents a left sign.
 */
public class SignLeft extends StationaryRole {
    /** Type of left sign.
     */
    public static final String TYPE = "SignLeft";
    public final int direction = 2;

    /** Create a left sign.
     * @param x Left sign's x position.
     * @param y Left Sign's y position.
     */
    public SignLeft(int x, int y) {
        super("res/images/left.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the left sign.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        gatherer.setDirection(Direction.LEFT);
    }

    /**
     * Update when a thief is standing on the left sign.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        thief.setDirection(Direction.LEFT);
    }
}
