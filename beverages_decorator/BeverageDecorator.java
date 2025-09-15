package beverages_decorator;

/**
 * Base decorator class for beverages.
 * All concrete decorators should extend this class.
 */
public abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public abstract String getDescription();
}
