package helpers.nameGenerator;

import com.github.javafaker.Faker;
import pimpek.pimpekModel.PimpekGenre;
import java.util.HashSet;
import java.util.Set;

public class BasicNameGenerator implements NameGenerator{

    private Set<String> usedName = new HashSet<>();

    public String generate(PimpekGenre genre) {
        Faker faker = new Faker();
        String name;
        do{
            name = genre.name() + " " + faker.name().firstName();
        }while(!usedName.add(name));
        return name;
    }

}
