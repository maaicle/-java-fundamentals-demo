package com.spec.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Droid {
    private final String serial;
    private final Model model;
    private final List<Tool> tools;

    //Constructor
    public Droid(String serial, Model model, List<Tool> tools) {
        this.serial = serial;
        this.model = model;
        //Copying the tools list passed through the argument. This makes it immutable to anything outside the Droid class.
        //Copied this from solution. It's cooler than what I tried plus what I tried didn't work: this.tools = new ArrayList<>(tools)
        this.tools = tools.stream().map(Tool::new).collect(Collectors.toList());
    };

    //Getters and Setters
    public String getSerial() {return serial;}
    //removing serial setter since it is final.
//    public void setSerial(String serial) {this.serial = serial;}

    public Model getModel() {return model;}
    //remove cause final
//    public void Model(Model model) {this.model = model;}

    public List<Tool> getTools() {return tools;}
    //removing cause final
//    public void setTools(Tool tools) {this.tools = (List<Tool>) tools;}

    //To String. Adding Override annotation because it is overriding the super class's (Object) method.
    @Override
    public String toString() {
        return String.format("Droid {" +
                " serial = %s,%n" +
                "model = %s }%n", serial, model.getType());
    }

    //Two speak methods. One to tell it what to say and a default with no param.
    public String speak() {
        return String.format("Hi, I'm a %s Droid. Beep boop beep", serial);
    }

    public String speak(String phrase) {
        return phrase;
    }

    //Repair Starship
    public void repairStarship() {
        //I copied this from the solution file, but I can explain what's happening. The type for the variable is the interface Optional. This allows us to safely
        //return a value because if it's missing the app won't crash, it will just return Optional.empty.
        //.stream() makes a stream of the tools list. .filter uses a lambda expression to find and return all of the STARSHIP_REPAIR tools that have at least one durability
        // in the list. Finally, findFirst() is a stream method that returns the first instance of our filtered list. Neat stuff.
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
