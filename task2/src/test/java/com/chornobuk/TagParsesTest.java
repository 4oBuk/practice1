package com.chornobuk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;


class TagParsesTest {

    @Test
    public void getTop5TagsNullArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TagParser.getTop5Tags(null));
    }

    @Test
    void getTop5TagsEmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TagParser.getTop5Tags(new String[]{}));
    }


    @Test
    void getTop5Tags() {
        String[] tags = new String[]{
                "#twitter #anime #osu! #dota2",
                "#twitter",
                "#twitter",
                "#twitter",
                "#twitter #anime #osu! #dota2",
                "#twitter #anime",
                "#twitter #osu!",
                "#twitter",
                "#anime",
                "#anime"

        };
        Map<String, Long> top5Tags = new LinkedHashMap<>();
        top5Tags.put("twitter",8L);
        top5Tags.put("anime",5L);
        top5Tags.put("osu!", 3L);
        top5Tags.put("dota2",2L);
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));
    }

    @Test
    void getTop5TagsEmptyTags() {
        String[] tags = new String[] {
                "#   #   #java",
                "#   #   #js",
                "#java   #   #js",
                "#   #   #golang",
                "#java   #   #sql",
                "#   #spring  ",
        };
        Map<String, Long> top5Tags = new LinkedHashMap<>();
        top5Tags.put("java",3L);
        top5Tags.put("js",2L);
        top5Tags.put("golang", 1L);
        top5Tags.put("sql",1L);
        top5Tags.put("spring",1L);
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));
    }

    @Test
    void getTop5TagsOneTagMultipleTimesInOneString() {
        String[] tags = new String[]{
                "#twitter #anime #osu! #dota2 #twitter",
                "#twitter #twitter",
                "#twitter",
                "#twitter",
                "#twitter #anime #osu! #dota2 #osu!",
                "#twitter #anime#anime",
                "#twitter #osu!",
                "#twitter",
                "#anime#anime",
                "#anime"

        };
        Map<String, Long> top5Tags = new LinkedHashMap<>();
        top5Tags.put("twitter",8L);
        top5Tags.put("anime",5L);
        top5Tags.put("osu!", 3L);
        top5Tags.put("dota2",2L);
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));

    }

    @Test
    void getTop5MultilineStringWithRepeatedTag() {
        String[] tags = new String[]{
                "#twitter " +
                        "#anime " +
                        "#osu! #dota2 #twitter",
                "#twitter " +
                        "#twitter",
                "#twitter",
                "#twitter",
                "#twitter " +
                        "#anime #osu! #dota2 " +
                        "#osu!",
                "#twitter " +
                        "#anime" +
                        "#anime",
                "#twitter #osu!",
                "#twitter",
                "#anime" +
                        "#anime",
                "#anime"

        };
        Map<String, Long> top5Tags = new LinkedHashMap<>();
        top5Tags.put("twitter",8L);
        top5Tags.put("anime",5L);
        top5Tags.put("osu!", 3L);
        top5Tags.put("dota2",2L);
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));
    }
}