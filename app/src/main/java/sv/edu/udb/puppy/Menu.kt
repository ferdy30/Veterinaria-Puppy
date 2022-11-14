package sv.edu.udb.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnIngresar : Button = findViewById(R.id.btnSe)
        var btnRegistrar : Button = findViewById(R.id.btnRe)

        btnIngresar.setOnClickListener(){

            val i = Intent( this, Login::class.java)
            startActivity(i)
        }
        btnRegistrar.setOnClickListener(){

            val i = Intent( this, Registro::class.java)
            startActivity(i)
        }
    }



}