package com.citi.analysis.service;

import com.citi.analysis.dto.User;

import java.util.*;

public class SocialNetworkService {

    public static Map<String, User> users;
    public static Map<String, Set<String>> friendships;

    public SocialNetworkService() {
        users = new HashMap<>();
        friendships = new HashMap<>();
    }

    // Network Analysis
    public List<String> findShortestPath(String startId, String endId) {
        Map<String, String> previous = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startId);
        visited.add(startId);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(endId)) {
                return buildPath(previous, startId, endId);
            }
            for (String friend : friendships.get(current)) {
                if (!visited.contains(friend)) {
                    visited.add(friend);
                    previous.put(friend, current);
                    queue.add(friend);
                }
            }
        }
        return Collections.emptyList(); // no path found
    }

    private List<String> buildPath(Map<String, String> previous, String startId, String endId) {
        List<String> path = new LinkedList<>();
        for (String at = endId; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public Map<String, Integer> calculateDegreeCentrality() {
        Map<String, Integer> degreeCentrality = new HashMap<>();
        for (String userId : friendships.keySet()) {
            degreeCentrality.put(userId, friendships.get(userId).size());
        }
        return degreeCentrality;
    }

    // Community detection can be complex, here's a simple version based on connected components
    public List<Set<String>> identifyCommunities() {
        Set<String> visited = new HashSet<>();
        List<Set<String>> communities = new ArrayList<>();

        for (String userId : users.keySet()) {
            if (!visited.contains(userId)) {
                Set<String> community = new HashSet<>();
                dfs(userId, visited, community);
                communities.add(community);
            }
        }
        return communities;
    }

    private void dfs(String userId, Set<String> visited, Set<String> community) {
        visited.add(userId);
        community.add(userId);
        for (String friend : friendships.get(userId)) {
            if (!visited.contains(friend)) {
                dfs(friend, visited, community);
            }
        }
    }
}