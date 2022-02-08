package ex1;

public class CoffeeTest {
    public static void main(String[] args) {
        CofeeMaker mk = new CofeeMaker();
        CofeeDrinker d = new CofeeDrinker();

        for (int i = 0; i < 15; i++) {
            Cofee c = mk.makeCofee();
            try {
                d.drinkCofee(c);
            } catch (numberException e) {
                System.out.println("Exception:" + e.getMessage() + " number " + e.getNum());
            } catch (TemperatureException e) {
                System.out.println("Exception:" + e.getMessage() + " temp=" + e.getTemp());
            } catch (ConcentrationException e){
            System.out.println("Exception:" + e.getMessage() + " conc=" + e.getConc());
            }
            finally{
                System.out.println("Throw the cofee cup.\n");
            }
        }
    }
}