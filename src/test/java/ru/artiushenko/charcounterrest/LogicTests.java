package ru.artiushenko.charcounterrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.artiushenko.charcounterrest.service.UniqueSymbolsService;

import java.util.Map;

@SpringBootTest
class LogicTests {
    @Test
    void definingRepeatedSymbols() {
        String uniqueSymbolsString = "sГ22";

        UniqueSymbolsService uniqueSymbolsService = new UniqueSymbolsService();
        Map<Character, Integer> testMap = uniqueSymbolsService.parseUniqueSymbols(uniqueSymbolsString);

        Assertions.assertEquals(3, testMap.size(), "Размер результата должен быть равен длине строки с уникальными символами");
        Assertions.assertEquals(1, testMap.get('s'), "Количество символа 's' должно быть 1");
        Assertions.assertEquals(1, testMap.get('Г'), "Количество символа 'Г' должно быть 1");
        Assertions.assertEquals(2, testMap.get('2'), "Количество символа '2' должно быть 2");
    }

    @Test
    void valuesAreInDescendingOrder() {
        String uniqueSymbolsString = "333221AAAББVv";

        UniqueSymbolsService uniqueSymbolsService = new UniqueSymbolsService();
        Map<Character, Integer> testMap = uniqueSymbolsService.parseUniqueSymbols(uniqueSymbolsString);

        Assertions.assertEquals(3, testMap.get('3'), "Количество символа '3' должно быть 3");
        Assertions.assertEquals(2, testMap.get('2'), "Количество символа '2' должно быть 2");
        Assertions.assertEquals(1, testMap.get('1'), "Количество символа '1' должно быть 1");
        Assertions.assertEquals(3, testMap.get('A'), "Количество символа 'A' должно быть 3");
        Assertions.assertEquals(2, testMap.get('Б'), "Количество символа 'Б' должно быть 2");
        Assertions.assertEquals(1, testMap.get('V'), "Количество символа 'V' должно быть 1");
        Assertions.assertEquals(1, testMap.get('v'), "Количество символа 'v' должно быть 1");

        int previousValue = Integer.MAX_VALUE;
        for (int value : testMap.values()) {
            Assertions.assertTrue(value <= previousValue, "Значения в Map должны идти в порядке убывания");
            previousValue = value;
        }
    }
}
