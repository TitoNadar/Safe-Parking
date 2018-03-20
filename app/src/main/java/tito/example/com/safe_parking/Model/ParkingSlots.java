package tito.example.com.safe_parking.Model;

/**
 * Created by tito on 20/3/18.
 */

public class ParkingSlots {

    private String cityname,name,lat,lng,id;

    public ParkingSlots(String name, String cityname, String lat, String lng, String id) {
        this.name = name;
        this.cityname = cityname;
        this.lat = lat;
        this.lng = lng;
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParkingSlots() {

    }
}
