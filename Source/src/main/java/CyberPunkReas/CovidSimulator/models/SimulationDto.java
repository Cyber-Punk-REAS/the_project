package CyberPunkReas.CovidSimulator.models;

public class SimulationDto {
    private Region region;

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
}
