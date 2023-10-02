package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseItemViewHolderBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem

class HouseTypesActivityViewAdapter(private val context: Context) : RecyclerView.Adapter<HouseItemViewHolder>(){

    private val houseList = ArrayList<HouseItem>()
    private lateinit var holder:HouseItemViewHolder
    private var showingList = ArrayList<Int>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseItemViewHolder {
        // with the type it's possible create different view holders.
        val binding = HouseItemViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        holder = HouseItemViewHolder(binding)
        //return HouseItemViewHolder(binding)
        return holder
    }

    override fun onBindViewHolder(holder: HouseItemViewHolder, position: Int) {
        holder.bind(houseList[position],context,showingList)

    }

    override fun getItemCount(): Int {
        return houseList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun updateList(houses:List<HouseItem>){
        val size=houseList.size
        houseList.clear()
        notifyItemRangeRemoved(0,size)
        houses.forEach{
            if(showingList.contains(it.id)){
                Log.e("adapter","id:".plus(it.id).plus(" checked."))
                it.isChecked=true
            }else{
                it.isChecked=false
            }
        }
        //notifyItemInserted(0)
        houseList.addAll(houses)

        notifyItemRangeInserted(0, houses.size)

    }
}