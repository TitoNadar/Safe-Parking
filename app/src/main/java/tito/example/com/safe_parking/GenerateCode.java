package tito.example.com.safe_parking;

import android.graphics.Bitmap;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;

import tito.example.com.safe_parking.Helper.Common;
import tito.example.com.safe_parking.Model.Constants;

public class GenerateCode extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,LocationListener {
int slot;

    private GoogleApiClient googleApiClient;
    public static final String TAG = GenerateCode.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_code);


        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).build();


        ActivityCompat.requestPermissions(GenerateCode.this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);

if(getIntent()!=null)
{
        ImageView myImage=(ImageView) findViewById(R.id.imageView);
slot=getIntent().getIntExtra("no",1);
        VCard abhay=new VCard(Common.user)
                .setEmail(Common.email)
                .setAddress(slot+"")
                .setTitle("Demo user"+Common.user)
                .setCompany("Rajasthan Hackathon");
        Bitmap myBitmap= QRCode.from(abhay).bitmap();
        myImage.setImageBitmap(myBitmap);}

}

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d(TAG, "Google Api Client Connected");
        startLocationMonitor();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "Google Api Client suspended");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "Google Api Client Connectn failed");
    }

    @Override
    public void onLocationChanged(Location location) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.reconnect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                googleApiClient, this);
    }

    private void startLocationMonitor() {
        Log.d(TAG, "start location monitor");
        LocationRequest locationRequest = LocationRequest.create()
                .setInterval(2000)
                .setFastestInterval(1000)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        try {
            LocationServices.FusedLocationApi.requestLocationUpdates
                    (googleApiClient, locationRequest, new LocationListener()
                    {
                        @Override
                        public void onLocationChanged(Location location) {
                  ...
                            Log.d(TAG, "Location Change Lat Lng " +
                                    location.getLatitude() + " " + location.getLongitude());
                        }
                    });
        } catch (SecurityException e) {
            Log.d(TAG, e.getMessage());
        }

    }

    @NonNull
    private Geofence getGeofence() {
        LatLng latLng = Constants.AREA_LANDMARKS.get(Constants.GEOFENCE_ID_STAN_UNI);
        return new Geofence.Builder()
                .setRequestId(Constants.GEOFENCE_ID_STAN_UNI)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setCircularRegion(latLng.latitude, latLng.longitude, Constants.GEOFENCE_RADIUS_IN_METERS)
                .setNotificationResponsiveness(1000)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT)
                .build();
    }

    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(getGeofence());
        return builder.build();
    }
}
