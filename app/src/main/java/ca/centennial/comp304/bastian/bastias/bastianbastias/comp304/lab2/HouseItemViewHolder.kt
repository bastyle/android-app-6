package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.content.Context
import android.util.Log
import android.widget.CompoundButton
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
        //binding.mainImage.setImageResource()
        //val uri = Uri.parse("content://drawable/".plus(item.image)) // Replace with your actual URI
        val imageId = ctx.resources.getIdentifier(item.image,"drawable",ctx.packageName)
        binding.mainImage.setImageResource(imageId)
        //val drawable = getDrawable(R.drawable.your_drawable_resource, null)
        //Log.e("checked: ", item.id.toString(). plus(" checked? ").plus(item.isChecked))
        //binding.appointment.isChecked=item.isChecked
        if(showingList.contains(item.id)){
            Log.e("hOLDER>>","id: ".plus(item.id).plus(" is in showing list"))
            //item.isChecked=true
            //binding.appointment.isChecked=true
        }else{
            Log.e("hOLDER>>","id: ".plus(item.id).plus(" is not in showing list"))
            //binding.appointment.isChecked=false
        }

        /*binding.appointment.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            // handle your logic
            if(!binding.appointment.isPressed && !showingList.contains(item.id)) {
            //if(!binding.appointment.isPressed) {
                Log.e("hOLDER>>",item.id.toString().plus(" no pressed"))
                return@OnCheckedChangeListener
            }else if(!binding.appointment.isPressed && showingList.contains(item.id)){
                Log.e("hOLDER>>",item.id.toString().plus(" no pressed but in list"))
                binding.appointment.isChecked=true
                buttonView.isChecked=true
                return@OnCheckedChangeListener
            }
            if(isChecked){
                Log.e("hOLDER>>","id: "+item.id+" isCHec:::: "+isChecked)
                showingList.add(item.id)
            } else {
                Log.e("hOLDER>>","id: "+item.id+" removed")
                showingList.remove(item.id)
            }
        })*/

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