package com.spec.demo;

import java.util.Map;

public class ModelFactory {
    //nested classes need to be fully qualified when used.
    public enum ModelType {
        ASTROMECH,
        PROTOCOL,
        BATTLE

    }

    static Map<ModelType, Model> modelMap = Map.of(
            ModelType.ASTROMECH, new Model ("Astromech", "Starship repair/support"),
            ModelType.PROTOCOL, new Model ("Prtotocol", "Glorified Translater"),
            ModelType.BATTLE, new Model ("Battle", "To terminate")
    );

    public static Model getModel(ModelType modelType) {return modelMap.get(modelType);}


}
