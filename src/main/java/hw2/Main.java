package hw2;

import hw2.concreteCreators.*;
import hw2.creator.ItemGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<ItemGenerator> generatorList = new ArrayList<>();
        generatorList.add(new CopperGenerator());
        generatorList.add(new DiamondGenerator());
        generatorList.add(new GoldGenerator());
        generatorList.add(new PlatinumGenerator());
        generatorList.add(new SilverGenerator());

        int count = 10;

        for (int i = 0; i < count; i++) {
            ItemGenerator generator = generatorList.get(random.nextInt(generatorList.size()));
            generator.openReward();
        }
    }
}
