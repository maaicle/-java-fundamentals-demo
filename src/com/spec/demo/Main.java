package com.spec.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Tool> droidTools = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            droidTools.add(new Tool(Tool.ToolType.STARSHIP_REPAIR));
        }

        Model model = ModelFactory.getModel(ModelFactory.ModelType.ASTROMECH);
        AstromechDroid r2d2 = new AstromechDroid("R2D2", model, droidTools);

        System.out.println(r2d2);
        System.out.println(r2d2.speak());

        System.out.println(droidTools);
        droidTools.remove(0);
        System.out.println(r2d2.getTools());

        System.out.println(r2d2.getClass());
        for (int i = 0; i < 11; i++) {
            r2d2.repairStarship();
            System.out.println("You have a tool count of " + r2d2.getTools().size());
        }

    }
}
