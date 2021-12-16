package com.spec.demo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Create tool set for Astromech
        List<Tool> droidTools = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            droidTools.add(new Tool(Tool.ToolType.STARSHIP_REPAIR));
        }
        //Create tool set for Battle
        List<Tool> battleTools = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            battleTools.add(new Tool(Tool.ToolType.RIFLE));
        }

        //Create droids as instances of the Droid subclass
        Model model = ModelFactory.getModel(ModelFactory.ModelType.ASTROMECH);
        AstromechDroid r2d2 = new AstromechDroid("R2D2", model, droidTools);
        ProtocolDroid c3p0 = new ProtocolDroid("C3P0", ModelFactory.getModel(ModelFactory.ModelType.PROTOCOL), new ArrayList<Tool>());
        BattleDroid oom9 = new BattleDroid("OOM-9", ModelFactory.getModel(ModelFactory.ModelType.BATTLE), battleTools);

        //put droids in a list of the Droid superclass
        List<Droid> droidList = List.of(r2d2, c3p0, oom9);
        //Have each droid speak
        droidList.forEach(droid -> System.out.println(droid.speak()));

        //Create a couple droids in the defender interface and put them in a list.
        AstromechDroid r2d5 = new AstromechDroid("R2D5", model, droidTools);
        BattleDroid oom7 = new BattleDroid("OOM-7", ModelFactory.getModel(ModelFactory.ModelType.BATTLE), battleTools);
        //This list can be of Type interface. It will only allow classes that implement that interface.
        List<Defender> defenders = List.of(r2d5, oom7);
        //Calling defender method
        for (Defender droid : defenders) {
            droid.defend();
        }

        for (int i = 0; i < 11; i++) {
            r2d2.repairStarship();
            oom9.shootEnemy();
        }

    }
}
