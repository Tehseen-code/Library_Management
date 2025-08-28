package org.example.classes

//abstract base class for all library items
abstract class LibraryItem(
    val id: String,
    val title: String,
    var isAvailable: Boolean=true
){

    //this is for item type
    abstract fun getItemType(): String

    abstract fun calculateFee(daysLate: Int): Double

    open fun displayInfo(): String
    {
        return "ID: $id, Title: $title, Available: $isAvailable"
    }
}