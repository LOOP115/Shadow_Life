/** Class that represents a fence.
 */
public class Fence extends StationaryRole {
    /** Type name of fence.
     */
    public static final String TYPE = "Fence";

    /** Create a fence.
     * @param x Fence's x position.
     * @param y Fence's y position.
     */
    public Fence(int x, int y) {
        super("res/images/fence.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the fence.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        if (gatherer.isActive()) {
            gatherer.setActive(false);
            Direction.reverse(gatherer);
            gatherer.directionMove();
            ShadowLife.numInactive++;
        }
    }

    /** Update when a thief is standing on the fence.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        if (thief.isActive()) {
            thief.setActive(false);
            Direction.reverse(thief);
            thief.directionMove();
            ShadowLife.numInactive++;
        }
    }
}
