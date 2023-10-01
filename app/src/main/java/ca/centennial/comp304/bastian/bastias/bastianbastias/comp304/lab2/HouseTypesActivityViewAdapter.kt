package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseItemViewHolderBinding

class HouseTypesActivityViewAdapter : RecyclerView.Adapter<HouseItemViewHolder>(){

    private val stringList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseItemViewHolder {
        // with the type it's possible create different view holders.
        val binding = HouseItemViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return HouseItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HouseItemViewHolder, position: Int) {
        holder.bind(stringList[position])
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun updateList(textList:List<String>){
        stringList.clear()
        stringList.addAll(textList)
        notifyItemInserted(0)
    }
}