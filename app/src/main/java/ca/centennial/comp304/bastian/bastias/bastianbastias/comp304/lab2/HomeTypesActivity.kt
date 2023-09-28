package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.ActivityHomeTypesBinding


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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.apartment -> {
                showApartments()
                return true
            }
            R.id.detached_home -> {
                showDetachedHomes()
                return true
            }
            R.id.semi_detached_home -> {
                showSemiDetachedHomes()
                return true
            }
            R.id.condominium_apartment -> {
                showCondoApartments()
                return true
            }
            R.id.town_house -> {
                showTownhouses()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showApartments() {
        // Display available apartments and checkboxes
        Toast.makeText(this, "Displaying available apartments", Toast.LENGTH_SHORT).show()
        // Implement your UI and logic here
    }

    private fun showDetachedHomes() {
        // Display available detached homes and checkboxes
        Toast.makeText(this, "Displaying available detached homes", Toast.LENGTH_SHORT).show()
        // Implement your UI and logic here
    }

    private fun showSemiDetachedHomes() {
        // Display available semi-detached homes and checkboxes
        Toast.makeText(this, "Displaying available semi-detached homes", Toast.LENGTH_SHORT).show()
        // Implement your UI and logic here
    }

    private fun showCondoApartments() {
        // Display available condominium apartments and checkboxes
        Toast.makeText(this, "Displaying available condo apartments", Toast.LENGTH_SHORT).show()
        // Implement your UI and logic here
    }

    private fun showTownhouses() {
        // Display available townhouses and checkboxes
        Toast.makeText(this, "Displaying available townhouses", Toast.LENGTH_SHORT).show()
        // Implement your UI and logic here
    }
}