/** Class that represents a down sign.
 */
public class SignDown extends StationaryRole {
    /** Type name of down sign.
     */
    public static final String TYPE = "SignDown";
    public final int direction = 1;

    /** Create a down sign.
     * @param x Down sign's x position.
     * @param y Down sign's y position.
     */
    public SignDown(int x, int y) {
        super("res/images/down.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the down sign.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        gatherer.setDirection(Direction.DOWN);
    }

    /** Update when a thief is standing on the down sign.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        thief.setDirection(Direction.DOWN);
    }
}
