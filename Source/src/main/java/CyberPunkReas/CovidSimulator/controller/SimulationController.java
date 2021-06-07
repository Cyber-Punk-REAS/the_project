package CyberPunkReas.CovidSimulator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimulationController {
    @RequestMapping("/simulation/new")
    public String newSimulation(Model model) {
        return "simulation/new";
    }
}
