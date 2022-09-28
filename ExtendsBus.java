class Main {

    public static void main(String[] args) {
        ExtendsBus bus = new ElectricBus(0.001, 0.1);
        bus.refuel(1);
        System.out.println("запас хода - " + bus.powerReserve()+"km");
        System.out.println("едем 50км - " + bus.run(50));
        System.out.println("запас хода - " + bus.powerReserve()+"km");
        System.out.println("едем 900kм - " + bus.run(900));
        System.out.println("запас хода - " + bus.powerReserve()+"km");
        System.out.println("едем 100км - " + bus.run(100));
    }



}

class ElectricBus extends ExtendsBus {
    private final double minimalFuelRate;

    public ElectricBus(double consumptionRate, double minimalFuelRate) {
        super(consumptionRate);
        this.minimalFuelRate = minimalFuelRate;
    }

    @Override
    public int powerReserve() {
        double remainingRate = getTankFullnessRate() - minimalFuelRate;
        if (remainingRate <= 0) {
            return 0;
        }
        return (int)(remainingRate / getConsumptionRate());
    }
}

class ExtendsBus {

    private double tankFullnessRate;
    private final double consumptionRate;

    public ExtendsBus (double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public boolean run (int distance) {
        if (powerReserve() < distance) {
            return false;
        }
        tankFullnessRate -= distance * consumptionRate;
        return true;
    }

    public final void refuel ( double tankRate) {
        double total = tankFullnessRate + tankRate;
        tankFullnessRate = total > 1 ? 1 : total;
    }

    public int powerReserve () {
        return (int) (tankFullnessRate / consumptionRate);
    }

    public double getTankFullnessRate() {
        return tankFullnessRate;
    }

    public double getConsumptionRate() {
        return consumptionRate;
    }
}
