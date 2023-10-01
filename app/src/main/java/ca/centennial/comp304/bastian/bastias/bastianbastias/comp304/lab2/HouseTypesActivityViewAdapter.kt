package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseItemViewHolderBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem

class HouseTypesActivityViewAdapter(private val context: Context) : RecyclerView.Adapter<HouseItemViewHolder>(){

    private val stringList = ArrayList<HouseItem>()
    private lateinit var holder:HouseItemViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseItemViewHolder {
        // with the type it's possible create different view holders.
        val binding = HouseItemViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        holder = HouseItemViewHolder(binding)
        //return HouseItemViewHolder(binding)
        return holder
    }

    override fun onBindViewHolder(holder: HouseItemViewHolder, position: Int) {
        holder.bind(stringList[position],context)
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun updateList(houses:List<HouseItem>){
        val size=stringList.size
        stringList.clear()
        notifyItemRangeRemoved(0,size)
        stringList.addAll(houses)
        //notifyItemInserted(0)
        notifyItemRangeInserted(0, houses.size)
    }
}