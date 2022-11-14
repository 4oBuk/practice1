package com.chornobuk;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TagParser {
    public static Map<Long, String> getTop5Tags(String[] strings) {
        if (strings == null || strings.length == 0) throw new IllegalArgumentException("Array cannot be null or empty");
        Map<String, Long> popularity = new LinkedHashMap<>();

        for (String string : strings) {
            Matcher matcher = Pattern.compile("\\t*#[\\w\\p{Punct}&&[^#]]*").matcher(string);
            List<String> tags = new ArrayList<>();
            while (matcher.find()) {
                tags.add(matcher.group());
            }
            tags.stream()
                    .distinct()
                    .filter(x -> !x.equals("#"))
                    .forEach(x -> {
                        if (popularity.containsKey(x)) {
                            popularity.put(x, popularity.get(x) + 1);
                            return;
                        }
                        popularity.put(x, 1L);
                    });
        }
        Map<Long, String> result = popularity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                                Map.Entry::getValue, Map.Entry::getKey, (e1, e2) -> String.join(",", e1, e2), LinkedHashMap::new
                        )
                );
        return result.entrySet().stream()
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)
                );
    }

}
