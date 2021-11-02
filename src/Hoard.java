/** Class that represents a hoard.
 */
public class Hoard extends FruitRole {
    /** Type name of hoard.
     */
    public static final String TYPE = "Hoard";

    /** Create a hoard.
     * @param x Hoard's x position.
     * @param y Hoard's y position.
     */
    public Hoard(int x, int y) {
        super("res/images/hoard.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the hoard.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        if (gatherer.isCarrying()) {
            gatherer.setCarrying(false);
            this.numFruit++;
        }
        Direction.reverse(gatherer);
    }

    /** Update when a thief is standing on the hoard.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        if (thief.isConsuming()) {
            thief.setConsuming(false);
            if (!thief.isCarrying()) {
                if (this.numFruit > 0) {
                    thief.setCarrying(true);
                    this.numFruit--;
                } else {
                    Direction.turnRight(thief);
                }
            }
        } else if (thief.isCarrying()) {
            thief.setCarrying(false);
            this.numFruit++;
            Direction.turnRight(thief);
        }
    }
}
