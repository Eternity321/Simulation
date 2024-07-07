package simulation;

import simulation.entity.Coordinates;
import simulation.entity.World;

import java.util.*;

public class AStarPathfinding {
    public static List<Coordinates> findPath(Coordinates start, Coordinates goal, World world) {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(Node::getF));
        Map<Coordinates, Node> allNodes = new HashMap<>();

        Node startNode = new Node(start, null, 0, getHeuristicCost(start, goal));
        openList.add(startNode);
        allNodes.put(start, startNode);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.getCoordinates().equals(goal)) {
                return reconstructPath(current);
            }

            for (Coordinates neighbor : getNeighbors(current.getCoordinates(), world)) {
                if (!world.isSquareEmpty(neighbor) && !neighbor.equals(goal)) {
                    continue;
                }

                int tentativeG = current.getG() + 1;
                Node neighborNode = allNodes.getOrDefault(neighbor, new Node(neighbor));

                if (tentativeG < neighborNode.getG()) {
                    neighborNode.setCameFrom(current);
                    neighborNode.setG(tentativeG);
                    neighborNode.setH(getHeuristicCost(neighbor, goal));
                    allNodes.put(neighbor, neighborNode);

                    if (!openList.contains(neighborNode)) {
                        openList.add(neighborNode);
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    private static int getHeuristicCost(Coordinates a, Coordinates b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private static List<Coordinates> getNeighbors(Coordinates coordinates, World world) {
        List<Coordinates> neighbors = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            Coordinates neighbor = new Coordinates(coordinates.y + dy[i], coordinates.x + dx[i]);
            if (neighbor.x >= 0 && neighbor.x < world.getWidth() && neighbor.y >= 0 && neighbor.y < world.getHeight()) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    private static List<Coordinates> reconstructPath(Node node) {
        List<Coordinates> path = new ArrayList<>();
        while (node != null) {
            path.add(node.getCoordinates());
            node = node.getCameFrom();
        }
        Collections.reverse(path);
        return path;
    }
}