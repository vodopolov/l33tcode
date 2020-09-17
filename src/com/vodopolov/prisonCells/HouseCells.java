package com.vodopolov.prisonCells;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Anton on 14.03.2020.
 */
public class HouseCells {

    public static void main(String[] args) {
        HouseCells cells = new HouseCells();
        int[] result = cells.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 1);
        for (int i :
                result) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        return processDay(cells, N);
    }

    private int[] processDay(int[] list, int days) {
        if (days == 0) return list;
        int[] newDay = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            newDay[i] = isNextDayActive(list, i) ? 1 : 0;
        }
        return processDay(newDay, days - 1);
    }

    private boolean isNextDayActive(int[] list, int id) {
        if (id == 0) return false;
        if (id == list.length - 1) return false;
        return list[id - 1] == list[id + 1];
    }

//
//    public ArrayList<String> popularNToys(int numToys,
//                                          int topToys,
//                                          List<String> toys,
//                                          int numQuotes,
//                                          List<String> quotes)
//    {
//        HashMap<String, Integer> toysMentions = new HashMap<String, Integer>();
//        for(String quote: quotes) {
//            for (String toy: toys) {
//                String lowerCaseQuote = quote.toLowerCase();
//                String lowerCaseToy = toy.toLowerCase();
//                int currentMatchId = 0;
//                do {
//                    currentMatchId = quote.indexOf(lowerCaseToy, currentMatchId);
//                    if (currentMatchId != -1) {
//                        if (toysMentions.containsKey(lowerCaseToy)) {
//                            int counter = toysMentions.get(lowerCaseToy);
//                            toysMentions.replace(lowerCaseToy, counter + 1);
//                        }
//                        else {
//                            toysMentions.put(lowerCaseToy, 1);
//                        }
//                        quote = quote.replaceFirst(lowerCaseToy, "");
//                    }
//                } while(currentMatchId != -1);
//            }
//        }
//
////        Map<String, Integer> topMentions;
////        topMentions = toysMentions.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()).limit(topToys).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//        ArrayList<String> result = new ArrayList<String>();
////        for(Map.Entry<String, Integer> entry : topMentions.entrySet()) {
////            result.add(entry.getKey());
////        }
//        return result;
//    }

}
