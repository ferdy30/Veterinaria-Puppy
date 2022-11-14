package sv.edu.udb.puppy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val txtnombre : TextView = findViewById(R.id.textNombreUR)
        val txtemail2 : TextView = findViewById(R.id.edtCorreoR)
        val txtpassword1: TextView =findViewById(R.id.edtContraseñaR)
        val txtpassword2: TextView = findViewById(R.id.edtContraseña2)
        val btnCrear: Button = findViewById(R.id.btnRegistrarR)
        firebaseAuth = Firebase.auth

        btnCrear.setOnClickListener(){

            var pass1 = txtpassword1.text.toString()
            var pass2 = txtpassword2.text.toString()

            if (pass1.equals(pass2)){

                 createAccount(txtemail2.text.toString(),txtpassword1.text.toString())



            }else{
                Toast.makeText(baseContext,"Las contraseñas ingresadas son diferentes",Toast.LENGTH_SHORT).show()
                txtpassword1.requestFocus()
            }
        }




    }
    private fun createAccount(email: String, password:String)
    {
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                task ->

                if (task.isSuccessful)
                {
                    Toast.makeText(baseContext,"Usuario registrado correctamente",Toast.LENGTH_SHORT).show()
                    val i = Intent( this, Login::class.java)
                    startActivity(i)
                } else
                {
                    Toast.makeText(baseContext,"Campos incorrectos",Toast.LENGTH_SHORT).show()
                }
            }
    }
}