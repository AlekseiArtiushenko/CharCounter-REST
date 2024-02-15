package ru.artiushenko.charcounterrest.service;

import org.springframework.stereotype.Service;
import ru.artiushenko.charcounterrest.model.UniqueSymbolsDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class UniqueSymbolsService {
    public UniqueSymbolsDto parseUniqueSymbols(String line) {
        Map<Character, Integer> uniqueSymbolsCount = new HashMap<>();
        int count = 1;
        for(int i = 0; i < line.length(); i++) {
            if (!uniqueSymbolsCount.containsKey(line.charAt(i))) {
                uniqueSymbolsCount.put(line.charAt(i), count);
            } else {
                uniqueSymbolsCount.replace(line.charAt(i), uniqueSymbolsCount.get(line.charAt(i)) + 1);
            }
        }

        return new UniqueSymbolsDto(uniqueSymbolsCount);
    }
}
