package org.example.classes

class Magazine(
    id: String,
    title: String,
    val issueNumber: Int,
    val publisher: String
  // all variables
):LibraryItem(id , title){

    // Implement the abstract function to return the item type.
    override fun getItemType(): String = "Magazine"
    override fun calculateFee(daysLate: Int): Double {

        return daysLate * 0.1
    }


    // Override the `displayInfo` function to include magazine-specific details.
    override fun displayInfo(): String {
        return "${super.displayInfo()}, Issue: $issueNumber, Publisher: $publisher, Type: ${getItemType()}"
    }
}