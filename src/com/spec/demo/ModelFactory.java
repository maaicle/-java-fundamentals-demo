package com.spec.demo;

import java.util.Map;

public class ModelFactory {
    //nested classes need to be fully qualified when used.
    public enum ModelType {
        ASTROMECH,
        SEEKER,
        BATTLE

    }

    static Map<ModelType, Model> modelMap = Map.of(
            ModelType.ASTROMECH, new Model ("Astromech", "Starship repair/support"),
            ModelType.SEEKER, new Model ("Seeker", "Seeks things"),
            ModelType.BATTLE, new Model ("Battle", "To terminate")
    );

    public static Model getModel(ModelType modelType) {return modelMap.get(modelType);}


}
