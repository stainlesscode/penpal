package com.stainlesscode.penpal;

/**
 * Created with IntelliJ IDEA.
 * User: dstieglitz
 * Date: 2/4/14
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Geometry {
    private double latitude;
    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geometry)) return false;

        Geometry geometry = (Geometry) o;

        if (Double.compare(geometry.latitude, latitude) != 0) return false;
        if (Double.compare(geometry.longitude, longitude) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
