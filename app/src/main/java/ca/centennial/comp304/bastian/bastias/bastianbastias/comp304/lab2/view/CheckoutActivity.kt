package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.R
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.ActivityCheckoutBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader


class CheckoutActivity:AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutBinding
    private lateinit var adapter: CheckoutActivityViewAdapter
    private val gson = Gson()
    private lateinit var reader:InputStreamReader
    private lateinit var inputStream: InputStream
    private lateinit var houses: List<HouseItem>
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        radioGroup = binding.radioGroup
        adapter=CheckoutActivityViewAdapter(baseContext, radioGroup)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        inputStream = resources.openRawResource(R.raw.house_data)
        reader = InputStreamReader(inputStream)
        houses = gson.fromJson(reader, object : TypeToken<List<HouseItem>>() {}.type)

        val showedIds = intent.getIntegerArrayListExtra("showedIds")
        showedIds?.forEach {
            Log.e("CheckoutActivity", it.toString())
        }
        if (showedIds != null) {
            adapter.updateList(houses.filter { it.id in showedIds.toList() })
        }else{
            adapter.updateList(houses)
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.e("HouseCheckoutViewHolder", "checkedId:: " + checkedId)
            Toast.makeText(this,"checkedId:: " + checkedId,Toast.LENGTH_SHORT).show()
        }

    }
}