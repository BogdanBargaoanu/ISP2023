package isp.lab8.airways;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String name;
    private List<Waypoint> waypoints;

    public Route(String name) {
        this.name = name;
        this.waypoints = new ArrayList<>();
    }

    public void addWaypoint(Waypoint waypoint) {
        this.waypoints.add(waypoint);
    }

    public void removeWaypoint(Waypoint waypoint) {
        this.waypoints.remove(waypoint);
    }

    public String getName() {
        return name;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public double calculateDistance() {
        double totalDistance = 0;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint wp1 = waypoints.get(i);
            Waypoint wp2 = waypoints.get(i + 1);
            double distance = WaypointDistanceCalculator.calculateDistance(wp1.getLatitude(), wp1.getLongitude(), wp2.getLatitude(), wp2.getLongitude());
            totalDistance += distance;
        }
        return totalDistance;
    }
}
