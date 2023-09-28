package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.ActivityHomeTypesBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.ActivityMainBinding

class HomeTypesActivity:AppCompatActivity() {
    private lateinit var binding: ActivityHomeTypesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options,menu)
        //return super.onCreateOptionsMenu(menu)
        return true
    }
}