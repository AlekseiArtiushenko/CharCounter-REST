package ru.artiushenko.charcounterrest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.artiushenko.charcounterrest.config.SwaggerConfig;
import ru.artiushenko.charcounterrest.dto.UniqueSymbolsDto;
import ru.artiushenko.charcounterrest.service.UniqueSymbolsService;

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
    @GetMapping("/parse")
    @ResponseBody
    public UniqueSymbolsDto getData(@RequestParam @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9]+$") String line) {
        return uniqueSymbolsService.parseUniqueSymbols(line);
    }

}
