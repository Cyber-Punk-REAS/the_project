package CyberPunkReas.CovidSimulator.models;


public class SimulationDto {
    private Region region;
    private ParameterProfile params;

    public SimulationDto() {
        region = new Region();
        params = new ParameterProfile();
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void addAreas(int areas) {
        region.setAreasNumber(areas);
        for (int i = 0; i < areas; i++) {
            region.addArea(new Area());
        }
    }

    public ParameterProfile getParams() {
        return params;
    }

    public void setParams(ParameterProfile params) {
        this.params = params;
    }
}
