package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        adapter = HouseTypesActivityViewAdapter(baseContext)
        binding.recyclerView.adapter=this.adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        inputStream = resources.openRawResource(R.raw.house_data)
        reader = InputStreamReader(inputStream)
        houses = gson.fromJson(reader, object : TypeToken<List<HouseItem>>() {}.type)
        adapter.updateList(houses)
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
                typeAux = "Apartment"
            }
            R.id.detached_home -> {
                typeAux = "Detached Home"
            }
            R.id.semi_detached_home -> {
                typeAux = "Semi Detached Home"
            }
            R.id.condominium_apartment -> {
                typeAux = "Condo"
            }
            R.id.town_house -> {
                typeAux = "Townhouse"
            }
        }
        return if (typeAux.isNullOrBlank()){
            super.onOptionsItemSelected(item)
        }else{
            filterByType(typeAux)
            true
        }

    }

    private fun filterByType(type:String){
        adapter.updateList(houses.filter { it.type.equals(type, ignoreCase = true) })
    }


}