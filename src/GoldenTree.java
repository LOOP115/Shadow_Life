/** Class that represents a golden tree.
 */
public class GoldenTree extends StationaryRole{
    /** Type name of golden tree.
     */
    public static final String TYPE = "GoldenTree";

    /** Create a golden tree.
     * @param x Golden tree's x position.
     * @param y Golden tree's y position.
     */
    public GoldenTree(int x, int y) {
        super("res/images/gold-tree.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the golden tree.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        if (!gatherer.isCarrying()) {
            gatherer.setCarrying(true);
            Direction.reverse(gatherer);
        }
    }

    /** Update when a thief is standing on the golden tree.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        if (!thief.isCarrying()) {
            thief.setCarrying(true);
        }
    }
}
