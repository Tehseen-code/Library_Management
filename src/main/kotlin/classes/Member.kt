package org.example.classes

class Member(
    val memberId: String,
    var name: String,
    private var email: String
) {
    //A list of items currently borrowed by member

    private val borrowedItems=mutableListOf<LibraryItem>()

    fun getMemberId(): String=memberId

    fun getName():String=name

    fun setName(newName: String) {
        if (newName.isNotBlank()) {
            name = newName
        } else {
            println("Name cannot be empty.")
        }
    }

    fun getEmail():String=email

    fun setEmail(newEmail: String) {
        if(newEmail.contains("@")){
            email=newEmail
        }
        else{
            println("Email cannot be empty or wrong format.")
        }
    }

    //Add library item to borrowed item to library list if item is available

    fun borrowItem(item: LibraryItem){
        if(item.isAvailable){
            borrowedItems.add(item)
            item.isAvailable = false // false after that item to borrow because no one can borrow before return
            println("${item.title} borrowed successfully by $name")
        }else{
            println("${item.title} is not available for borrowing.")
        }
    }

    fun returnItem(item: LibraryItem){
        if(borrowedItems.contains(item)){
            borrowedItems.remove(item)
            item.isAvailable=true
            println("${item.title} returned successfully by $name")
        }else{
            println("${item.title} was not borrowed by $name.")
        }
    }

    fun calculateTotalLateFees(daysLate: Int): Double{
        var totalFee=0.0

        for (item in borrowedItems){
            totalFee+=item.calculateFee(daysLate)
        }
        return totalFee
    }


    fun displayInfo(): String{
        return "MemberID: $memberId, Name: $name, Email: $email, Borrowed: ${borrowedItems.size} items"
    }
}