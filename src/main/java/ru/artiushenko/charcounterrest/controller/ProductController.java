package ru.artiushenko.charcounterrest.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.artiushenko.charcounterrest.config.ProjectConfig;
import ru.artiushenko.charcounterrest.model.UniqueSymbolsDto;
import ru.artiushenko.charcounterrest.service.UniqueSymbolsService;

@RestController
@AllArgsConstructor
@RequestMapping("/uniqueSymbols")
public class ProductController {

    ProjectConfig projectConfig;
    UniqueSymbolsService uniqueSymbolsService;
    @Validated
    @GetMapping("/parse")
    @ResponseBody
    public UniqueSymbolsDto getData(@RequestParam @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9]+$") String line) {
        return uniqueSymbolsService.parseUniqueSymbols(line);
    }

}
