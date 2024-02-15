package ru.artiushenko.charcounterrest.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);

        return new OpenAPI()
                .servers(
                        List.of(
                                new Server().url("http://localhost:8080")
                        )
                )
                .info(
                        new Info().title("Char counters API")
                )
                .components(new Components()
                .addSchemas("UniqueSymbolsMapDto", new Schema<Map<Character, Integer>>()
                        .addProperties("< A|a|...|Z|z >", new IntegerSchema()
                                .description("Sum of unique characters.")).example(map)
                ));
    }
}
