package ru.artiushenko.charcounterrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class UniqueSymbolsDto {
    Map<Character, Integer> uniqueSymbols;
}
