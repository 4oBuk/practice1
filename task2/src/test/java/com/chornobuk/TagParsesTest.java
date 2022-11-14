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
        Map<Long, String> top5Tags = new LinkedHashMap<>();
        top5Tags.put(8L, "#twitter");
        top5Tags.put(5L, "#anime");
        top5Tags.put(3L, "#osu!");
        top5Tags.put(2L, "#dota2");
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));
    }

    @Test
    void getTop5TagsEmptyTags() {
        String[] tags = new String[]{
                "#   #   #java",
                "#   #   #js",
                "#java   #   #js",
                "#   #   #golang",
                "#java   #   #sql",
                "#   #spring  ",
        };
        Map<Long, String> top5Tags = new LinkedHashMap<>();
        top5Tags.put(3L, "#java");
        top5Tags.put(2L, "#js");
        top5Tags.put(1L, "#golang,#sql,#spring");
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
        Map<Long, String> top5Tags = new LinkedHashMap<>();
        top5Tags.put(8L, "#twitter");
        top5Tags.put(5L, "#anime");
        top5Tags.put(3L, "#osu!");
        top5Tags.put(2L, "#dota2");
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
        Map<Long, String> top5Tags = new LinkedHashMap<>();
        top5Tags.put(8L, "#twitter");
        top5Tags.put(5L, "#anime");
        top5Tags.put(3L, "#osu!");
        top5Tags.put(2L, "#dota2");
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));
    }

    @Test
    public void getTop5TagsFewTagsHaveSameFrequency() {
        String[] tags = new String[]{
                "#twitter #anime #osu! #dota2 #twitter",
                "#twitter #twitter",
                "#twitter",
                "#twitter",
                "#twitter #anime #osu! #dota2 #osu!",
                "#twitter #anime#anime",
                "#twitter #osu!",
                "#twitter",
                "#anime#anime#osu!",
                "#anime#osu!",
                "#osu!#csgo",
                "#osu!#csgo",
                "#osu!#fortnite",
        };
        Map<Long, String> top5Tags = new LinkedHashMap<>();
        top5Tags.put(8L, "#twitter,#osu!");
        top5Tags.put(5L, "#anime");
        top5Tags.put(2L, "#dota2,#csgo");
        top5Tags.put(1L, "#fortnite");
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));
    }


    @Test
    public void getTop5TagsWithTextBetweenTags() {
        String[] tags = new String[]{
                "#twitter #anime #osu! #dota2 #twitter naruto",
                "#twitter #twitter ramen",
                "#twitter elon musk",
                "#twitter emacs",
                "#twitter #anime #osu! #dota2 #osu!",
                "#twitter #anime#anime",
                "#twitter #osu!",
                "#twitter",
                "#anime#anime",
                "#anime"

        };
        Map<Long, String> top5Tags = new LinkedHashMap<>();
        top5Tags.put(8L, "#twitter");
        top5Tags.put(5L, "#anime");
        top5Tags.put(3L, "#osu!");
        top5Tags.put(2L, "#dota2");
        Assertions.assertEquals(top5Tags, TagParser.getTop5Tags(tags));
    }
}