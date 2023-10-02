package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model

data class HouseItem(
    val id: Int,
    val type: String,
    val image: String,
    val address: String,
    val price: String,
    val description: String,
    var isChecked: Boolean = false
)