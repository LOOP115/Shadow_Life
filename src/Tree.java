/** Class that represents a tree.
 */
public class Tree extends FruitRole {
    /** Type name of tree.
     */
    public static final String TYPE = "Tree";

    /** Create a tree.
     * @param x Tree's x position.
     * @param y Tree's y position.
     */
    public Tree(int x, int y) {
        super("res/images/tree.png", TYPE, x, y);
        this.numFruit = 3;
    }

    /** Update when a gatherer is standing on the tree.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        if (!gatherer.isCarrying()) {
            if (this.numFruit > 0) {
                this.numFruit--;
                gatherer.setCarrying(true);
                Direction.reverse(gatherer);
            }
        }
    }

    /** Update when a thief is standing on the tree.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        if (!thief.isCarrying()) {
            if (this.numFruit > 0) {
                this.numFruit--;
                thief.setCarrying(true);
            }
        }
    }
}
