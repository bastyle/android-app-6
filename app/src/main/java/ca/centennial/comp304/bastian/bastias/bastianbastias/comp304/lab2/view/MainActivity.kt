package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            //Toast.makeText(this,"Click",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeTypesActivity::class.java)
            intent.putExtra("extra_data","Lab 2")
            startActivity(intent)
        }
    }
}