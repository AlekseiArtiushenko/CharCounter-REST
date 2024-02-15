package ru.artiushenko.charcounterrest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.artiushenko.charcounterrest.config.SwaggerConfig;
import ru.artiushenko.charcounterrest.service.UniqueSymbolsService;
import java.util.Map;

@Tag(name = "unique_symbols")
@RestController
@AllArgsConstructor
@RequestMapping("/uniqueSymbols")
public class UniqueSymbolsController {

    SwaggerConfig swaggerConfig;
    UniqueSymbolsService uniqueSymbolsService;

    @Operation(
            summary = "Принимает и обрабатывает строки",
            description = "Принимает в себя значение новой строки," +
                    " обрабатывает строку в Service, возвращает DTO"
    )
    @Validated
    @ApiResponse(
            responseCode = "200",
            description = "Response code 200.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(ref = "#/components/schemas/UniqueSymbolsMapDto"))
    )
    @GetMapping("/parse")
    public ResponseEntity<Map<Character, Integer>> getData(@RequestParam
                                                           @NotEmpty(message = "Line should not be empty.")
                                                           @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9]+$",
                                                                   message = "Line must contain only letters and numbers.")
                                                           String line) {

        return ResponseEntity.ok(uniqueSymbolsService.parseUniqueSymbols(line));
    }
}
