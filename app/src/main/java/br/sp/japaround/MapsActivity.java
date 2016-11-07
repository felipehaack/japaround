package br.sp.japaround;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import br.sp.japaround.models.Address;
import br.sp.japaround.models.Attraction;
import br.sp.japaround.models.Province;
import br.sp.japaround.models.Region;
import br.sp.japaround.utils.JsonUtils;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private JsonUtils jsonUtils;
    private List<Region> regions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        jsonUtils = new JsonUtils();
        regions = jsonUtils.convertJsonStringToModel(
                jsonUtils.convertJsonFileToString(
                        getApplicationContext(), getResources().getString(R.string.maps_places_filename)
                )
        );
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng place = null;

        for (Region region : regions) {

            for (Province province : region.getProvinces()) {

                for (Attraction attraction : province.getAttractions()) {

                    String gps = null;
                    Address address = attraction.getAddress();

                    if (address.getGps() != null)
                        if (address.getGps().length() > 0)
                            gps = address.getGps();

                    if (gps == null && address.getGpsa() != null)
                        if (address.getGpsa().length() > 0)
                            gps = address.getGpsa();

                    String[] split = gps.replaceAll(" ", "").split(",");

                    place = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));

                    mMap.addMarker(new MarkerOptions().position(place).
                            title(StringUtils.capitalize(attraction.getAttraction())).
                            snippet("price \n schedules")
                    );
                }
            }
        }

        if (place != null)
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 6F));
    }
}
