package com.spec.demo;

import java.util.List;
import java.util.Optional;

public class AstromechDroid extends Droid {

    public AstromechDroid(String serial, Model model, List<Tool> tools) {
        super(serial, model, tools);
    }

    public void repairStarship() {
        Optional<Tool> repairToolOptional = tools.stream().filter(tool -> tool.getToolType().equals(Tool.ToolType.STARSHIP_REPAIR) && tool.getDurability() >= 1).findFirst();
        if (repairToolOptional.isPresent()) {
            Tool repairTool = repairToolOptional.get();
            repairTool.useTool();
            System.out.println("The starship is repaired");
            if (repairTool.getDurability() <= 0) {
                tools.remove(repairTool);
            }
        }
        else
            System.out.println("You aint got no tools for this job.");
    }

}
