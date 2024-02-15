package ru.artiushenko.charcounterrest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
@Schema(description = "Class desc")
public class UniqueSymbolsDto {
    @Schema(description = "Method desc")
    Map<Character, Integer> uniqueSymbols;
}
