package CyberPunkReas.CovidSimulator.controller;

import CyberPunkReas.CovidSimulator.models.*;
import CyberPunkReas.CovidSimulator.service.Simulation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SimulationController {
    private final Simulation simulation;

    public SimulationController(Simulation simulation) {
        this.simulation = simulation;
    }

    @RequestMapping("/simulation/new")
    public String newSimulationAreas(Model model, @RequestParam Optional<Integer> areas) {
        if(areas.isEmpty()) {
            return "simulation/selectAreas";
        }

        SimulationDto dto = new SimulationDto();

        ParameterProfile p = simulation.getDefaultParameterProfile();
        Region region = simulation.getDefaultRegion(areas.get());

        dto.setRegion(region);
        dto.setParams(p);

        model.addAttribute("simulation", dto);
        return "simulation/new";
    }

    @PostMapping("/simulation/send")
    public String send(SimulationDto dto, Model model) {
        // save here
        Result r = simulation.run(dto.getParams(), dto.getRegion());
        model.addAttribute("result", r);
        System.out.println(r.getTotalDeaths());
        return "redirect:result";
    }


    @RequestMapping("/simulation/result")
    public String resultView(Model model) {
        // save here
        Result r = simulation.run(simulation.getDefaultParameterProfile(), simulation.getDefaultRegion(5));
        model.addAttribute("result", r);
        System.out.println("Deaths " + r.getTotalDeaths());
        System.out.println("Infected " + r.getTotalInfected());
        return "simulation/result";
    }
}
