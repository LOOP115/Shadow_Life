/** Class that deal with directions.
 */
public class Direction {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    /** Rotate direction by 180 degrees.
     * @param role The role that needs to change direction.
     */
    public static void reverse(MovingRole role) {
        switch (role.getDirection()) {
            case Direction.UP:
                role.setDirection(Direction.DOWN);
                break;
            case Direction.DOWN:
                role.setDirection(Direction.UP);
                break;
            case Direction.LEFT:
                role.setDirection(Direction.RIGHT);
                break;
            case Direction.RIGHT:
                role.setDirection(Direction.LEFT);
                break;
        }
    }

    /** Rotate direction by 90 degrees counter-clockwise.
     * @param role The role that needs to change direction.
     */
    public static void turnLeft(MovingRole role) {
        switch (role.getDirection()) {
            case Direction.UP:
                role.setDirection(Direction.LEFT);
                break;
            case Direction.DOWN:
                role.setDirection(Direction.RIGHT);
                break;
            case Direction.LEFT:
                role.setDirection(Direction.DOWN);
                break;
            case Direction.RIGHT:
                role.setDirection(Direction.UP);
                break;
        }
    }

    /** Rotate direction by 90 degrees clockwise.
     * @param role The role that needs to change direction.
     */
    public static void turnRight(MovingRole role) {
        switch (role.getDirection()) {
            case Direction.UP:
                role.setDirection(Direction.RIGHT);
                break;
            case Direction.DOWN:
                role.setDirection(Direction.LEFT);
                break;
            case Direction.LEFT:
                role.setDirection(Direction.UP);
                break;
            case Direction.RIGHT:
                role.setDirection(Direction.DOWN);
                break;
        }
    }
}
