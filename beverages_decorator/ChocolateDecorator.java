package beverages_decorator;

public class ChocolateDecorator extends BeverageDecorator {

    public ChocolateDecorator(Beverage beverage){
        super(beverage);
    }
    
    @Override
    public int cost() {
        return this.beverage.cost() + 100;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }
}
