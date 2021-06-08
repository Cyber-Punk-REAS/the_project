package CyberPunkReas.CovidSimulator.models;


public class SimulationDto {
    private Region region;
    private ParameterProfile params;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public ParameterProfile getParams() {
        return params;
    }

    public void setParams(ParameterProfile params) {
        this.params = params;
    }
}
