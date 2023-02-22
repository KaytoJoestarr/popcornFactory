package com.flores.elizabeth.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        var ns = 0
        val bundle = intent.extras
        var id = -1
        var title = ""

        if (bundle != null){
            ns = bundle.getInt("numberSeats")
            title=bundle.getString("nombre")!!
            iv_pelicula_img.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("nombre"))
            tv_descrip.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats available")
            id = bundle.getInt("pos")

        }

        if(ns==0){
            btn_buyTickets.isActivated=false
        }else{
            btn_buyTickets.setOnClickListener{
                val intent: Intent = Intent(this,SeatSeleccion::class.java)

                intent.putExtra("id",id)
                intent.putExtra("name",title)

                this.startActivity(intent)
            }
        }

    }
}