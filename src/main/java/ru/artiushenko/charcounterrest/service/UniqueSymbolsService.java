package ru.artiushenko.charcounterrest.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

        Map<Character, Integer> sortedMap = uniqueSymbolsCountMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMap;
    }
}
