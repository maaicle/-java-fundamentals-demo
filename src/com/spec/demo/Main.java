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
        //Create droids as instances of the Droid subclass
        Model model = ModelFactory.getModel(ModelFactory.ModelType.ASTROMECH);
        AstromechDroid r2d2 = new AstromechDroid("R2D2", model, droidTools);
        ProtocolDroid c3p0 = new ProtocolDroid("C3P0", ModelFactory.getModel(ModelFactory.ModelType.PROTOCOL), new ArrayList<Tool>());
        ProtocolDroid oom9 = new ProtocolDroid("OOM-9", ModelFactory.getModel(ModelFactory.ModelType.BATTLE), new ArrayList<Tool>());

        //put droids in a list of the Droid superclass
        List<Droid> droidList = List.of(r2d2, c3p0, oom9);
        //Have each droid speak
        droidList.forEach(droid -> System.out.println(droid.speak()));
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
