/** Abstract class that represents a stationary role.
 */
public abstract class StationaryRole extends Actor{
    /** Create a stationary role.
     * @param filename File which stores the stationary role's image.
     * @param type     Type of the stationary role.
     * @param x        Stationary role's x position.
     * @param y        Stationary role's y position.
     */
    public StationaryRole(String filename, String type, int x, int y) {
        super(filename, type, x, y);
    }

    /** Update the stationary role's status.
     */
    @Override
    public void update() {}
}
