package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.ActivityHomeTypesBinding


class HomeTypesActivity:AppCompatActivity() {
    private lateinit var binding: ActivityHomeTypesBinding
    private lateinit var adapter: HouseTypesActivityViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        adapter = HouseTypesActivityViewAdapter()
        binding.recyclerView.adapter=this.adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        adapter.updateList(listOf("1","2","3","1","2","3","1","2","3"))
        /*adapter.updateList(
            listOf(
                RecyclerViewItemModel("Ontario", RecyclerViewHolderViewType.TEXT_TYPE),
                RecyclerViewItemModel(R.drawable.phone_image.toString(), RecyclerViewHolderViewType.IMAGE_TYPE),
                RecyclerViewItemModel("British Columbia", RecyclerViewHolderViewType.TEXT_TYPE),
                RecyclerViewItemModel(R.drawable.bluetooth_image.toString(), RecyclerViewHolderViewType.IMAGE_TYPE),
                RecyclerViewItemModel("PEI", RecyclerViewHolderViewType.TEXT_TYPE),
                RecyclerViewItemModel(R.drawable.settings_image.toString(), RecyclerViewHolderViewType.IMAGE_TYPE),
                RecyclerViewItemModel("Quebec", RecyclerViewHolderViewType.TEXT_TYPE),
                RecyclerViewItemModel(R.drawable.science_image.toString(), RecyclerViewHolderViewType.IMAGE_TYPE),
            )
        )*/
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