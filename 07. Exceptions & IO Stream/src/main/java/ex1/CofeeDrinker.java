package ex1;

public class CofeeDrinker{
    void drinkCofee(Cofee c) throws numberException, TemperatureException, ConcentrationException {
        if(c.getNumber()>10)
            throw new numberException(c.getNumber(),"Over 10 Coffees have already been made!");
        if(c.getTemp()>60)
            throw new TemperatureException(c.getTemp(),"Cofee is to hot!");
        if(c.getConc()>50)
            throw new ConcentrationException(c.getConc(),"Cofee concentration to high!");
        System.out.println("Drink cofee:"+c);
    }
}
