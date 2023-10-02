package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseItemViewHolderBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem


class HouseItemViewHolder(private val binding: HouseItemViewHolderBinding):RecyclerView.ViewHolder(binding.root) {

    //var showingList = ArrayList<Int>()
    fun bind(item: HouseItem, ctx:Context, showingList:ArrayList<Int>) {
        binding.type.text = item.type.plus(" #AF10-0").plus(item.id)
        binding.address.text = item.address
        binding.description.text = item.description
        binding.price.text=item.price
        val imageId = ctx.resources.getIdentifier(item.image,"drawable",ctx.packageName)
        binding.mainImage.setImageResource(imageId)

        Log.e("hOLDER>>","id: ".plus(item.id).plus(" is ".plus(if(showingList.contains(item.id))"in" else "not in").plus(" showing list")))

        /*if(showingList.contains(item.id)){
            Log.e("hOLDER>>","id: ".plus(item.id).plus(" is in showing list"))
        }else{
            Log.e("hOLDER>>","id: ".plus(item.id).plus(" is not in showing list"))
        }*/

        binding.appointment.setOnCheckedChangeListener{_, isChecked ->
            //Log.e("hOLDER>>","id: "+item.id+" isCHec:::: "+isChecked+" itemCheck?:"+item.isChecked)
            Log.e("hOLDER>>","id: "+item.id+" isCHec:::: "+isChecked)
            //Log.e("hOLDER>>","id: "+item.id)
            //item.isChecked=isChecked
            //if(isChecked && !showingList.contains(item.id)){
            if(!binding.appointment.isPressed) {
                Log.e("hOLDER>>",item.id.toString().plus(" no pressed"))
                return@setOnCheckedChangeListener;
            }
            if(isChecked){
                showingList.add(item.id)
                Log.e("hOLDER>>","id: "+item.id+" added ")
            } else {
                showingList.remove(item.id)
                Log.e("hOLDER>>","id: "+item.id+" removed")
            }
        }
        binding.appointment.isChecked=item.isChecked
    }
}