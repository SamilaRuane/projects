package br.ufs.projetos.gocidade.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.ufs.projetos.gocidade.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    lateinit var mOrigem : LatLng


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        fragment.getMapAsync { callback ->
                    callback.mapType = GoogleMap.MAP_TYPE_NORMAL
                    mOrigem = LatLng(-23.561706, -46.655981)
                    callback.animateCamera(CameraUpdateFactory.newLatLng(mOrigem))
                    callback.addMarker(MarkerOptions()
                            .position(mOrigem)
                            .title("Av. Paulista")
                            .snippet("São Paulo"))

            val auxPlace = LatLng(-23.88888, -46.77777)

            callback.addMarker(MarkerOptions()
                    .position(auxPlace)
                    .title("Av. Paulista")
                    .snippet("São Paulo"))


            callback.uiSettings.isMapToolbarEnabled = false
            callback.uiSettings.isZoomControlsEnabled = true
            callback.uiSettings.setAllGesturesEnabled(true)

        }
    }
}
