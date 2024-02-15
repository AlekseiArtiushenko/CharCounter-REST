package ru.artiushenko.charcounterrest.service;

import org.springframework.stereotype.Service;
import ru.artiushenko.charcounterrest.dto.UniqueSymbolsDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class UniqueSymbolsService {
    public Map<Character, Integer> parseUniqueSymbols(String line) {
        Map<Character, Integer> uniqueSymbolsCountMap = new HashMap<>();
        int count = 1;
        for (int i = 0; i < line.length(); i++) {
            if (!uniqueSymbolsCountMap.containsKey(line.charAt(i))) {
                uniqueSymbolsCountMap.put(line.charAt(i), count);
            } else {
                uniqueSymbolsCountMap.replace(line.charAt(i), uniqueSymbolsCountMap.get(line.charAt(i)) + 1);
            }
        }

        uniqueSymbolsCountMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed());

        return uniqueSymbolsCountMap;
    }
}
