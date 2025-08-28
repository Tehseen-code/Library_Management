package org.example

import org.example.classes.Book
import org.example.classes.Magazine
import org.example.classes.Member

fun main(){
    val book1 = Book("B001", "Kotlin for Beginners", "Tehssen ul hassan ", "978-1234567890", 250)
    val book2 = Book("B002","Advanced Kotlin", "Hassan ", "978-1234567", 300)
    val mag1 = Magazine("M001", "Tech Monthly", 45, "TechPress")

    val member = Member("M001", "Alice Johnson", "alice@email.com")

    println("Member Info: ${member.displayInfo()}")

    println("Borrowing Items...")

    // Borrow book1 and mag1
    member.borrowItem(book1)
    member.borrowItem(mag1)


    println("Member Info After Borrowing: ${member.displayInfo()}")

    // Try borrowing book1 again (should fail, already borrowed)
    member.borrowItem(book1)

    // Return magazine
    member.returnItem(mag1)

    println("Member Info After Returning: ${member.displayInfo()}")

    // Calculate late fees for 5 days
    val lateFees = member.calculateTotalLateFees(5)
    println("Total Late Fees for 5 days: $$lateFees")


}