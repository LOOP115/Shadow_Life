/** Class that represents an up sign.
 */
public class SignUp extends StationaryRole {
    /** Type of up sign.
     */
    public static final String TYPE = "SignUp";
    public final int direction = 0;

    /** Create an up sign.
     * @param x Up sign's x position.
     * @param y Up sign's y position.
     */
    public SignUp(int x, int y) {
        super("res/images/up.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the up sign.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        gatherer.setDirection(Direction.UP);
    }

    /** Update when a thief is standing on the up sign.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        thief.setDirection(Direction.UP);
    }
}
