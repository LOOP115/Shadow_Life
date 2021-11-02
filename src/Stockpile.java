/** Class that represents a stockpile.
 */
public class Stockpile extends FruitRole {
    /** Type name of stockpile.
     */
    public static final String TYPE = "Stockpile";

    /** Create a stockpile.
     * @param x Stockpile's x position.
     * @param y Stockpile's y position.
     */
    public Stockpile(int x, int y) {
        super("res/images/cherries.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the stockpile.
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

    /** Update when a thief is standing on the stockpile.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        if (!thief.isCarrying()) {
            if (this.numFruit > 0) {
                thief.setCarrying(true);
                thief.setConsuming(false);
                this.numFruit--;
                Direction.turnRight(thief);
            }
        } else {
            Direction.turnRight(thief);
        }
    }
}
