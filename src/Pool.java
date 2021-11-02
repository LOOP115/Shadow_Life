/** Class that represents a pool.
 */
public class Pool extends StationaryRole {
    /** Type name of pool.
     */
    public static final String TYPE = "Pool";

    /** Create a pool.
     * @param x Pool's x position.
     * @param y Pool's y position.
     */
    public Pool(int x, int y) {
        super("res/images/pool.png", TYPE, x, y);
    }

    /** Update when a gatherer is standing on the pool.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {
        // Modify the original gatherer.
        Direction.turnLeft(gatherer);
        gatherer.setCarrying(false);

        // Create a new gatherer and modify it.
        Gatherer gatherer2 = new Gatherer(gatherer.getX(), gatherer.getY());
        gatherer2.setDirection(gatherer.getDirection());
        Direction.reverse(gatherer2);
        ShadowLife.actors.add(gatherer2);
        ShadowLife.numMovingRole++;

        // Move the two gatherers.
        gatherer.directionMove();
        gatherer2.directionMove();
    }

    /** Update when a thief is standing on the pool.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        // Modify the original thief.
        Direction.turnLeft(thief);
        thief.setCarrying(false);

        // Create a new thief and modify it.
        Thief thief2 = new Thief(thief.getX(), thief.getY());
        thief2.setDirection(thief.getDirection());
        Direction.reverse(thief2);
        ShadowLife.actors.add(thief2);
        ShadowLife.numMovingRole++;

        // Move the two thieves.
        thief.directionMove();
        thief2.directionMove();
    }
}
