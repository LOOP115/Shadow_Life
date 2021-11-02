/** Class that represents a pad.
 */
public class Pad extends StationaryRole {
    /** Type name of pad.
     */
    public static final String TYPE = "Pad";

    /** Create a pad.
     * @param x Pad's x position.
     * @param y Pad's y position.
     */
    public Pad(int x, int y) {
        super("res/images/pad.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the pad.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {}

    /** Update when a thief is standing on the pad.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        thief.setConsuming(true);
    }
}
