package tito.example.com.safe_parking.Model;

/**
 * Created by tito on 20/3/18.
 */

public class Individual {
    private String lat,lng,name,id,status;

    public Individual() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Individual(String lat, String lng, String name, String id, String status) {

        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.id = id;
        this.status = status;
    }
}
