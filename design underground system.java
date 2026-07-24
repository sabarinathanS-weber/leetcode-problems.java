import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        int totalTime;
        int count;

        Route(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn data = checkInMap.get(id);

        String route = data.station + "->" + stationName;

        int travelTime = t - data.time;

        Route stats = routeMap.getOrDefault(route, new Route(0, 0));

        stats.totalTime += travelTime;
        stats.count++;

        routeMap.put(route, stats);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        Route stats = routeMap.get(startStation + "->" + endStation);

        return (double) stats.totalTime / stats.count;
    }
}
