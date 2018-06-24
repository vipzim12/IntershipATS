package com.tma.ats.api.service;

public class GpsHelper {

    private GpsHelper() {
    }

    public static double calculateDistance(double lat1, double lon1,
            double lat2, double lon2) {
        double d2r = Math.PI / 180;
        double lon = (lon2 - lon1) * d2r;
        double lat = (lat2 - lat1) * d2r;
        double a = Math.pow(Math.sin(lat / 2.0), 2) + Math.cos(lat1 * d2r)
                * Math.cos(lat2 * d2r) * Math.pow(Math.sin(lon / 2.0), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 6367 * c;
    }
}
