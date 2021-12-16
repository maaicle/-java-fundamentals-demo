package com.spec.demo;

public class Tool {
    private final ToolType toolType;
    private int durability;

    public enum ToolType {
        STARSHIP_REPAIR
    }

    public Tool(ToolType toolType) {
        this.toolType = toolType;
        this.durability = 3;
    }

    //This second constructor lets me create a copy of a tool as a new tool.
    public Tool(Tool tool) {
        this.toolType = tool.getToolType();
        this.durability = tool.getDurability();
    }

    public ToolType getToolType() {return toolType;}
    //removed toolType setter now that it's final.
//    public void setToolType(ToolType toolType) {this.toolType = toolType;}

    public int getDurability() {return durability;}
    //removed durability setter and replaced it with the useTool method.
//    public void setDurability(int durability) {this.durability = durability;}

    @Override
    public String toString() {
        return String.format("Tool {" +
                " toolType = %s,%n" +
                "durability = %s }%n", toolType, durability);
    }

    public void useTool() {
        this.durability--;
    }
}
