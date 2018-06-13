package model.foodGenerator;

import model.configuration.Configuration;
import model.food.Food;

import java.util.HashSet;
import java.util.Set;

public class BasicFoodGenerator implements FoodGenerator {

    private final Configuration configuration;

    public BasicFoodGenerator(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Set<Food> generate() {


        // to implement



        return new HashSet<>();
    }
}
