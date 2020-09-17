package com.vodopolov.criticalConnectionInNetwork;

import java.util.*;

/**
 * Created by Anton on 27.02.2020.
 */
public class CriticaalConnectionInNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<List<Integer>>> nodesAndConnections = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> listEntity :
                connections) {
            for (Integer serverId : listEntity) {
                if (!nodesAndConnections.containsKey(serverId)) nodesAndConnections.put(serverId, new ArrayList<>());
                nodesAndConnections.get(serverId).add(listEntity);
            }
        }
        Iterator it = nodesAndConnections.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<List<Integer>>> pair = (Map.Entry)it.next();
            if (pair.getValue().size() == 1) result.add(pair.getValue().get(0));
        }
        return result;
    }
}
