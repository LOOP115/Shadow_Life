/** Class that represents a gatherer.
 */
public class Gatherer extends MovingRole {
    /** Type name of gatherer.
     */
    public static final String TYPE = "Gatherer";

    /** Create a gatherer.
     * @param x Gatherer's x position.
     * @param y Gatherer's y position.
     */
    public Gatherer(int x, int y) {
        super("res/images/gatherer.png", TYPE, x, y);
    }

    /** Update the gatherer's status.
     */
    @Override
    public void update() {
        if (this.isActive()) {
            directionMove();
        }
        if (this.stand(ShadowLife.actors) != null) {
            Actor actor = this.stand(ShadowLife.actors);
            actor.meetGatherer(this);
        }
    }

    /** Update when a gatherer is standing on the gatherer.
     * @param gatherer The gatherer encountered.
     */
    @Override
    public void meetGatherer(Gatherer gatherer) {}

    /** Update when a thief is standing on the gatherer.
     * @param thief The thief encountered.
     */
    @Override
    public void meetThief(Thief thief) {
        Direction.turnLeft(thief);
    }
}
