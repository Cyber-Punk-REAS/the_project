package CyberPunkReas.CovidSimulator.controller;

import CyberPunkReas.CovidSimulator.models.Region;
import CyberPunkReas.CovidSimulator.models.SimulationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SimulationController {
    @RequestMapping("/simulation/new")
    public String newSimulationAreas(Model model, @RequestParam Optional<Integer> areas) {
        if(areas.isEmpty()) {
            return "simulation/selectAreas";
        }

        SimulationDto dto = new SimulationDto();
        dto.addAreas(areas.get());
        model.addAttribute("simulation", dto);
        return "simulation/new";
    }

    @PostMapping("/simulation/send")
    public String send(SimulationDto simulation) {
        // save here
        System.out.println("number " + simulation.getRegion().getAreasNumber());
        System.out.println("amount " + simulation.getRegion().getAreas().size());
        System.out.println("infected " + simulation.getParams().getInitialInfectedPeople());
        System.out.println("Contagious Day " + simulation.getParams().getAverageContagiousDays());
        System.out.println("Day Contagious " + simulation.getParams().getAverageDaysContagious());
        System.out.println("Average contagiousness " + simulation.getParams().getAverageContagiousness());
        System.out.println("Average Friends " + simulation.getParams().getAverageFriends());
        System.out.println("Immunity Chance " + simulation.getParams().getImmunityChance());
        System.out.println("Execution Time " + simulation.getParams().getExecutionTime());
        System.out.println("unemployement " + simulation.getParams().getUnemployment());
        
        
        return "redirect:/simulation/new";
    }
}
