package com.example.gold.recyclerviewstudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gold on 2018. 2. 7..
 */

public class ListData {

    public String title;
    public String desc;
    public String meta;

    public ListData(String title, String desc, String meta) {
        this.title = title;
        this.desc = desc;
        this.meta = meta;
    }

    public static List<ListData> createListDataListSorted() {
        final List<ListData> list = createListDataList();
        Collections.sort(list, new Comparator<ListData>() {
            @Override
            public int compare(ListData lhs, ListData rhs) {
                return lhs.title.compareToIgnoreCase(rhs.title);
            }
        });
        return list;
    }

    public static List<ListData> createListDataList() {
        return Arrays.asList(
                new ListData("Bacon", "ipsum", "dolor"),
                new ListData("amet", "frankfurter", "meatball"),
                new ListData("pork", "belly", "strip"),
                new ListData("steak", "ham", "hock"),
                new ListData("doner", "alcatra", "pork"),
                new ListData("chop", "beef", "ribs"),
                new ListData("Beef", "salami", "flank"),
                new ListData("sirloin", "ribeye", "Landjaeger"),
                new ListData("leberkas", "tail", "cow"),
                new ListData("hamburger", "pork", "loin"),
                new ListData("rump", "picanha", "meatball"),
                new ListData("andouille", "beef", "ribs"),
                new ListData("flank", "sausage", "andouille"),
                new ListData("Turkey", "salami", "corned"),
                new ListData("beef", "chicken", "shankle"),
                new ListData("sausage", "capicola", "fatback"),
                new ListData("Meatball", "tail", "venison"),
                new ListData("hamburger", "chuck", "shank"),
                new ListData("pork", "loin", "shankle"),
                new ListData("drumstick", "Fatback", "hamburger"),
                new ListData("salami", "porchetta", "biltong"),
                new ListData("boudin", "bacon", "pork"),
                new ListData("loin", "Pork", "belly"),
                new ListData("pork", "beef", "ribs"),
                new ListData("shoulder", "doner", "ham"),
                new ListData("ground", "round", "landjaeger"),
                new ListData("Rump", "cow", "jowl"),
                new ListData("ball", "tip", "strip"),
                new ListData("steak", "brisket", "biltong")
        );
    }

}
