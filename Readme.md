Overview
This Java implementation of a Social Network Analysis Tool allows users to manage a social network, perform analyses such as finding the shortest path between users, identifying communities, and calculating degree centrality.

Class: User
Represents a user in the social network.

Attributes:
userId: A unique identifier for the user.
name: The name of the user.
email: The email address of the user.
Class: SocialNetwork
Manages users and friendships, and performs network analyses.

Attributes:
users: A map storing user IDs and corresponding User objects.
friendships: A map that associates user IDs with sets of friends (represented as user IDs).
Methods
User Management
void addUser(String userId, String name, String email)

Adds a new user to the network.
Time Complexity: O(1) - Adding to a map is generally O(1).
Space Complexity: O(1) - Constant space used for a new user.
void removeUser(String userId)

Removes a user and their associated friendships from the network.
Time Complexity: O(n) - Where n is the number of users. It may involve iterating through all friendships.
Space Complexity: O(1) - No additional space used.
void listUsers()

Prints the details of all users in the network.
Time Complexity: O(n) - Where n is the number of users.
Space Complexity: O(1) - Only uses space for output.
Friendship Management
void createFriendship(String userId1, String userId2)

Creates a bidirectional friendship between two users.
Time Complexity: O(1) - Adding to sets is generally O(1).
Space Complexity: O(1) - Constant space used for friendships.
void removeFriendship(String userId1, String userId2)

Removes the friendship between two users.
Time Complexity: O(1) - Removing from sets is generally O(1).
Space Complexity: O(1) - Constant space used.
void listFriends(String userId)

Prints the friends of a specific user.
Time Complexity: O(f) - Where f is the number of friends of the user.
Space Complexity: O(1) - Only uses space for output.
Network Analysis
List<String> findShortestPath(String startId, String endId)

Finds the shortest path between two users using Breadth-First Search (BFS).
Time Complexity: O(V + E) - Where V is the number of users and E is the number of friendships.
Space Complexity: O(V) - For the queue and the map used to store previous nodes.
Map<String, Integer> calculateDegreeCentrality()

Calculates the degree centrality for each user.
Time Complexity: O(n) - Where n is the number of users, iterating through each user's friends.
Space Complexity: O(n) - For storing degree centrality results.
List<Set<String>> identifyCommunities()

Identifies communities using depth-first search (DFS) for connected components.
Time Complexity: O(V + E) - Where V is the number of users and E is the number of friendships.
Space Complexity: O(V) - For the visited set and recursion stack.
private void dfs(String userId, Set<String> visited, Set<String> community)

A helper method for DFS.
Time Complexity: O(V + E) - Same as the identifyCommunities method.
Space Complexity: O(V) - For the visited set and recursion stack.