package io.github.rvdxk.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.rvdxk.entity.CarWash;
import io.github.rvdxk.repository.CarWashRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class JsonDataLoader {

    @Bean
    public CommandLineRunner loadCarWashData(CarWashRepository carWashRepository) {
        return args -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = new String(Files.readAllBytes(Paths.get("src/main/resources/carwash-data.json")));
                JsonNode jsonArray = objectMapper.readTree(json);

                for (JsonNode node : jsonArray) {
                    CarWash carWash = objectMapper.treeToValue(node, CarWash.class);
                    carWashRepository.save(carWash);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}