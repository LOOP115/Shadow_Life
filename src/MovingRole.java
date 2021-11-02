import java.util.concurrent.CopyOnWriteArrayList;

/** Abstract Class that represents a moving role.
 */
public abstract class MovingRole extends Actor{
    private boolean carrying = false;
    private boolean active = true;
    private int direction;

    /** Create a moving role.
     * @param filename File which stores the moving role's image.
     * @param type     Type of the moving role.
     * @param x        Moving role's x position.
     * @param y        Moving role's y position.
     */
    public MovingRole(String filename, String type, int x, int y) {
        super(filename, type, x, y);
        this.direction = Direction.LEFT;
    }

    /** Get the carrying status.
     * @return Return the carrying boolean.
     */
    public boolean isCarrying() {
        return carrying;
    }

    /** Set the carrying status.
     * @param carrying The carrying boolean.
     */
    public void setCarrying(boolean carrying) {
        this.carrying = carrying;
    }

    /** Get the active status.
     * @return Return the active boolean.
     */
    public boolean isActive() {
        return active;
    }

    /** Set the active status.
     * @param active The active boolean.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /** Get the current direction.
     * @return Return the direction.
     */
    public int getDirection() {
        return this.direction;
    }

    /** Set the direction.
     * @param direction The new direction.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /** Move the role in its direction.
     */
    public void directionMove() {
        switch (direction) {
            case Direction.UP:
                move(0, -ShadowLife.TILE_SIZE);
                break;
            case Direction.DOWN:
                move(0, ShadowLife.TILE_SIZE);
                break;
            case Direction.LEFT:
                move(-ShadowLife.TILE_SIZE, 0);
                break;
            case Direction.RIGHT:
                move(ShadowLife.TILE_SIZE, 0);
                break;
        }
    }

    /** Check if the moving role is standing on another actor.
     * @param actor The actor to be checked.
     * @return Return a boolean.
     */
    public boolean samePosition(Actor actor) {
        return this.getX() == actor.getX() && this.getY() == actor.getY();
    }

    /** Check which actor is the moving role standing on.
     * @param actors The list of all actors.
     * @return Return a actor if the moving role is standing on it.
     */
    public Actor stand(CopyOnWriteArrayList<Actor> actors) {
        for (Actor actor: actors) {
            if (this.type.equals(actor.type)) continue;
            if (this.samePosition(actor)) return actor;
        }
        return null;
    }
}
