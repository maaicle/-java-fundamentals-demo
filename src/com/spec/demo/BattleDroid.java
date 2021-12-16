package com.spec.demo;

import java.util.List;
import java.util.Optional;

public class BattleDroid extends Droid implements Defender {

    public BattleDroid(String serial, Model model, List<Tool> tools) {
        super(serial, model, tools);
    }

    public void shootEnemy() {
        Optional<Tool> rifleOptional = tools.stream().filter(tool -> tool.getToolType().equals(Tool.ToolType.RIFLE) && tool.getDurability() >= 1).findFirst();
        if (rifleOptional.isPresent()) {
            Tool rifle = rifleOptional.get();
            rifle.useTool();
            System.out.println("Enemy has been shot");
            if (rifle.getDurability() <= 0) {
                tools.remove(rifle);
            }
        }
        else
            System.out.println("You aint got no bullets for shootin!");
    }

    @Override
    public void defend() {
        shootEnemy();
    }

}
