/** Class that represents a right sign.
 */
public class SignRight extends StationaryRole {
    /** Type of right sign.
     */
    public static final String TYPE = "SignRight";
    public final int direction = 3;

    /** Create a right sign.
     * @param x Right sign's x position.
     * @param y Right sign's y position.
     */
    public SignRight(int x, int y) {
        super("res/images/right.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the right sign.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        gatherer.setDirection(Direction.RIGHT);
    }

    /** Update when a thief is standing on the right sign.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        thief.setDirection(Direction.RIGHT);
    }
}
