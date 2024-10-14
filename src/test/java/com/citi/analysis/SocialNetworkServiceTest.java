package com.citi.analysis;

import com.citi.analysis.exception.UserMgmtException;
import com.citi.analysis.helper.FriendshipMgmntHelper;
import com.citi.analysis.helper.UserMgmntHelper;
import com.citi.analysis.service.SocialNetworkService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkServiceTest {

    private SocialNetworkService network;
    private UserMgmntHelper userMgmntHelper;
    private FriendshipMgmntHelper friendshipMgmntHelper;

    @Before("")
    public void setUp() {
        network = new SocialNetworkService();
        userMgmntHelper.addUser("1", "Alice", "alice@example.com");
        userMgmntHelper.addUser("2", "Bob", "bob@example.com");
        userMgmntHelper.addUser("3", "Charlie", "charlie@example.com");
    }

    @Test
    public void testAddUser() {
        userMgmntHelper.addUser("4", "David", "david@example.com");
        assertNotNull(network.findShortestPath("4", "1"));
    }

    @Test
    public void testRemoveUser() {
        userMgmntHelper.removeUser("2");
        userMgmntHelper.listUsers();
        assertEquals(2, network.users.size());
        assertNull(network.friendships.get("2"));
    }

    @Test
    public void testCreateFriendship() throws UserMgmtException {
        friendshipMgmntHelper.createFriendship("1", "2");
        assertTrue(network.friendships.get("1").contains("2"));
        assertTrue(network.friendships.get("2").contains("1"));
    }

    @Test
    public void testRemoveFriendship() throws UserMgmtException {
        friendshipMgmntHelper.createFriendship("1", "2");
        friendshipMgmntHelper.removeFriendship("1", "2");
        assertFalse(network.friendships.get("1").contains("2"));
        assertFalse(network.friendships.get("2").contains("1"));
    }

    @Test
    public void testListFriends() throws UserMgmtException {
        friendshipMgmntHelper.createFriendship("1", "2");
        Set<String> expectedFriends = new HashSet<>(Arrays.asList("2"));
        assertEquals(expectedFriends, network.friendships.get("1"));
    }

    @Test
    public void testFindShortestPath() throws UserMgmtException {
        friendshipMgmntHelper.createFriendship("1", "2");
        friendshipMgmntHelper.createFriendship("2", "3");
        List<String> expectedPath = Arrays.asList("1", "2", "3");
        assertEquals(expectedPath, network.findShortestPath("1", "3"));
    }

    @Test
    public void testCalculateDegreeCentrality() throws UserMgmtException {
        friendshipMgmntHelper.createFriendship("1", "2");
        friendshipMgmntHelper.createFriendship("2", "3");
        Map<String, Integer> centrality = network.calculateDegreeCentrality();
        assertEquals(1, (int) centrality.get("1"));
        assertEquals(2, (int) centrality.get("2"));
        assertEquals(1, (int) centrality.get("3"));
    }

    @Test
    public void testIdentifyCommunities() throws UserMgmtException {
        friendshipMgmntHelper.createFriendship("1", "2");
        friendshipMgmntHelper.createFriendship("2", "3");
        List<Set<String>> communities = network.identifyCommunities();
        assertEquals(1, communities.size());
        assertTrue(communities.get(0).contains("1"));
        assertTrue(communities.get(0).contains("2"));
        assertTrue(communities.get(0).contains("3"));
    }

    @Test
    public void testIdentifyMultipleCommunities() throws UserMgmtException {
        friendshipMgmntHelper.createFriendship("1", "2");
        friendshipMgmntHelper.createFriendship("3", "4");
        List<Set<String>> communities = network.identifyCommunities();
        assertEquals(2, communities.size());
    }
}
