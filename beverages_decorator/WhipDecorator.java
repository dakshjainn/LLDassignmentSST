package beverages_decorator;

public class WhipDecorator extends BeverageDecorator {

    public WhipDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 25;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }
}
