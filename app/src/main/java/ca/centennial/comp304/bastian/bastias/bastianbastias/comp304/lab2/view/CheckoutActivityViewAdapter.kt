package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseCheckoutViewHolderBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem

class CheckoutActivityViewAdapter(private val context: Context): RecyclerView.Adapter<HouseCheckoutViewHolder>() {
    private val showedHouseList = ArrayList<HouseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseCheckoutViewHolder {
        val binding = HouseCheckoutViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return HouseCheckoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HouseCheckoutViewHolder, position: Int) {
        holder.bind(showedHouseList[position],context)
    }

    override fun getItemCount(): Int {
        return showedHouseList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun updateList(houses:List<HouseItem>){
        val size=showedHouseList.size
        showedHouseList.clear()
        notifyItemRangeRemoved(0,size)
        //notifyItemInserted(0)
        showedHouseList.addAll(houses)
        notifyItemRangeInserted(0, houses.size)
    }
}