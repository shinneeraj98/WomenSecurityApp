package com.example.anand.womensecurity;

import android.*;
import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,LocationListener {

    private GoogleMap mMap;
    public LatLng currentLocation;
    String str, str1, str2, str3, str4, str5, str6,str9;
    int m = 1, n = 1,k=1;//  k uses for send current latitude and longtitude to database in policestation table.
    String[] al2;
    String[] al1;
    String[] al3;
    String[] al4;
    String[] al5;
    String[] al6;
    String email;
    SmsManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Bundle b1 = getIntent().getExtras();
        email = b1.getString("email");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.SEND_SMS}, 0);
        ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Sorry GPS is Off", Toast.LENGTH_SHORT).show();
        } else {
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5, 0, (LocationListener) this);
            Toast.makeText(this, "GPS is working", Toast.LENGTH_SHORT).show();
            sm = SmsManager.getDefault();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }

    @Override
    public void onLocationChanged(Location location) {
        currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
        if (currentLocation == null) {
            Toast.makeText(this, "Please Wait GPS is on Working", Toast.LENGTH_SHORT).show();
        } else {
            Geocoder gc = new Geocoder(MapsActivity.this);
            try {
                ArrayList<Address> al = (ArrayList) gc.getFromLocation(currentLocation.latitude, currentLocation.longitude, 1);
                android.location.Address ad = al.get(0);
                str = ad.getSubLocality() + "," + ad.getLocality();
                LatLng sydney = new LatLng(currentLocation.latitude, currentLocation.longitude);
                if (n == 1) {
                    mMap.addMarker(new MarkerOptions().position(sydney).title("" + str));
                    n++;
                }
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 20));
                str2 = Mydata.recpolat();
                str3 = Mydata.recpolon();
                al4 = str2.split(",");
                al5 = str3.split(",");
                for (int a = 0; a < al4.length; a++) {
                    Circle circle = mMap.addCircle(new CircleOptions() // make round color at police station area
                            .center(new LatLng(Double.parseDouble(al4[a]), Double.parseDouble(al5[a])))
                            .radius(300)
                            .strokeColor(Color.GREEN)
                            .fillColor(Color.GREEN));
                }
                if (currentLocation.latitude == currentLocation.latitude && m == 1) { // if current location and danger location is same.
                    String str7 = Mydata.recpno(email);
                    Log.d("numbers", "" + str7);
                    Toast.makeText(this, "Number" + str7, Toast.LENGTH_SHORT).show();
                    al3 = str7.split(",");
                    for (int i = 0; i < al3.length; i++) {
                        sm.sendTextMessage(al3[i], null, "Your Friend in Danger Zone at that Location " + str, null, null);
                        Toast.makeText(this, "Message Send", Toast.LENGTH_SHORT).show();
                    }
                    m++;
                }
                if (k == 1) {
                    str9 = Mydata.adddangerlocation("" + currentLocation.latitude, "" + currentLocation.longitude, email);
                    String policeno = Mydata.recpolicepno();
                    al6 = policeno.split(",");
                    ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                    SmsManager sm = SmsManager.getDefault();
                    for (int l = 0; l < al6.length; l++) { // for sending current latitude and longtitude to police.
                        Toast.makeText(this, "" + al6[l], Toast.LENGTH_SHORT).show();
                        sm.sendTextMessage(al6[l], null, "Someone is in Danger at " + str + " " + "please respond this message as soon as possible", null, null);
                        Toast.makeText(this, "PoliceMan is Coming", Toast.LENGTH_SHORT).show();
                    }
                    k++;
                }

            } catch (Exception ex) {
                Toast.makeText(this, "Permission" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

            str1 = Mydata.reclon();
            str4 = Mydata.reclocation();
            al2 = str1.split(",");
            al1 = str4.split(",");
            for (int i = 0; i < al2.length; i++) {
                Circle circle = mMap.addCircle(new CircleOptions()
                        .center(new LatLng(Double.parseDouble(al1[i]), Double.parseDouble(al2[i])))
                        .radius(300)
                        .strokeColor(Color.RED)
                        .fillColor(Color.RED));
                    if (((currentLocation.latitude == Double.parseDouble(al1[i]) && currentLocation.latitude == Double.parseDouble(al2[i]))) && m == 1) {
                        String str7 = Mydata.recpno(email).toString();
                        al3 = str7.split(",");
                        ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                        SmsManager sm = SmsManager.getDefault();
//                        for (int j = 0; i < al3.length; i++) {
//                            sm.sendTextMessage(al3[j], null, "Your Friend in Danger Zone at that Location " + str, null, null);
//                            Toast.makeText(this, "Message Send", Toast.LENGTH_SHORT).show();
//                        }
                        m++;
                    }
                }

        }

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
