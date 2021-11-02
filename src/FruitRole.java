import bagel.Font;

/** Class that represents a role with limited fruit.
 */
public abstract class FruitRole extends StationaryRole{
    protected int numFruit;
    private final Font font = new Font("res/VeraMono.ttf", 24);

    /**Create a role with limited fruit.
     * @param filename File which stores the role's image.
     * @param type     Type name of the role.
     * @param x        Role's x position.
     * @param y        Role's y position.
     */
    public FruitRole(String filename, String type, int x, int y) {
        super(filename, type, x, y);
        this.numFruit = 0;
    }

    /** Render the role and its number of fruit.
     */
    @Override
    public void render() {
        image.drawFromTopLeft(this.getX(), this.getY());
        font.drawString(Integer.toString(numFruit), this.getX(), this.getY());
    }
}
