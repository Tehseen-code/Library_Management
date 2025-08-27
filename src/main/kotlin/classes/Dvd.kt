package org.example.classes

abstract class Dvd(
    id: String,
    title: String,
    val director: String,
    val duration: Int, // in minutes
    val genre: String
):LibraryItem(id,title){
    override fun getItemType(): String="DVD"

    override fun calculateFee(daysLate: Int): Double{
        return daysLate*0.5
    }

    override fun displayInfo(): String{
        return "${super.displayInfo()}, Director: $director, Duration: ${duration}min, Genre: $genre, Type: ${getItemType()}"
    }
}