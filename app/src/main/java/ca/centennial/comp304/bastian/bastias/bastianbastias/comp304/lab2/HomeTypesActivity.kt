package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.ActivityHomeTypesBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader



class HomeTypesActivity:AppCompatActivity() {
    private lateinit var binding: ActivityHomeTypesBinding
    private lateinit var adapter: HouseTypesActivityViewAdapter
    private val gson = Gson()
    private lateinit var reader:InputStreamReader
    private lateinit var inputStream: InputStream
    private lateinit var houses: List<HouseItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        adapter = HouseTypesActivityViewAdapter(baseContext)
        binding.recyclerView.adapter=this.adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        inputStream = resources.openRawResource(R.raw.house_data)
        reader = InputStreamReader(inputStream)

        houses = gson.fromJson(reader, object : TypeToken<List<HouseItem>>() {}.type)
        //adapter.updateList(houses)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options,menu)
        //return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var typeAux=String()
        when (item.itemId) {
            R.id.apartment -> {
                //showApartments()
                typeAux = "Apartment"
                //findByType("Apartment")
                //return true
            }
            R.id.detached_home -> {
                //showDetachedHomes()
                typeAux = "Detached Home"
                //findByType("Detached Home")
                //return true
            }
            R.id.semi_detached_home -> {
                typeAux = "Semi Detached Home"
                //showSemiDetachedHomes()
                //return true
            }
            R.id.condominium_apartment -> {
                typeAux = "Condo"
                //showCondoApartments()
                //return true
            }
            R.id.town_house -> {
                typeAux = "Townhouse"
                //showTownhouses()
                //return true
            }
        }
        if (typeAux.isNullOrBlank()){
            return super.onOptionsItemSelected(item)
        }else{
            findByType(typeAux)
            //return (if (typeAux==null|| typeAux == "") { super.onOptionsItemSelected(item)} else true)
            return true
        }

    }

    private fun findByType(type:String){
        adapter.updateList(houses.filter { it.type.equals(type, ignoreCase = true) })
    }

    private fun showApartments() {
        // Display available apartments and checkboxes
        Toast.makeText(this, "Displaying available apartments", Toast.LENGTH_SHORT).show()
        // Implement your UI and logic here
        //val housesAux= List<HouseItem>()
        adapter.updateList(houses.filter { it.type.equals("Apartment", ignoreCase = true) })
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