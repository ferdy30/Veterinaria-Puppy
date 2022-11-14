package sv.edu.udb.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnIngresar : Button = findViewById(R.id.btnIngresar)
        var txtemail: TextView = findViewById(R.id.txtEmail)
        var txtpass: TextView = findViewById(R.id.txtContraseña)
        firebaseAuth = Firebase.auth

        btnIngresar.setOnClickListener(){
            signing(txtemail.text.toString(),txtpass.text.toString())
        }
    }
    private fun signing(email: String, password:String){

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                task ->
                if (task.isSuccessful){
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext,"Ingresado exitosamente", Toast.LENGTH_SHORT).show()
                    val i = Intent( this, Principal::class.java)
                    startActivity(i)

                }else{
                    Toast.makeText(baseContext,"Error, Email o contraseña invalido", Toast.LENGTH_SHORT).show()
                }
            }
    }
}