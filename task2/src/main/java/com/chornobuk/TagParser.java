package com.chornobuk;

import java.util.*;
import java.util.stream.Collectors;

public class TagParser {
    public static Map<String, Long> getTop5Tags(String[] strings) {
        if (strings == null || strings.length == 0) throw new IllegalArgumentException("Array cannot be null or empty");


        Map<String, Long> popularity = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            Arrays.stream(strings[i].split("[\\t]?[#]{1}"))
                    .map(String::trim)
                    .distinct()
                    .filter(x -> !x.isEmpty())
                    .forEach(x -> {
                        if (popularity.containsKey(x)) {
                            popularity.put(x, popularity.get(x) + 1);
                            return;
                        }
                        popularity.put(x, 1L);
                    });
        }
        return popularity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                        )
                );
    }

}
