package org.example.collection

import org.example.classes.LibraryItem
import org.example.classes.Member

class Library {
    private val itemsById = HashMap<String, LibraryItem>()
    private val itemsByCategory = HashMap<String, MutableList<LibraryItem>>()
    private val members = HashMap<String, Member>()
    private val borrowedItems = HashMap<String, MutableList<String>>() // memberId -> list of item IDs

    // Add item to inventory
    fun addItem(item: LibraryItem) {
        itemsById[item.id] = item
        itemsByCategory.computeIfAbsent(item.category) { mutableListOf() }.add(item)
    }

    // Register member
    fun registerMember(member: Member) {
        members[member.memberId] = member
    }

    // Borrow item
    fun borrowItem(memberId: String, itemId: String): Boolean {
        val member = members[memberId]
        val item = itemsById[itemId]

        return if (member != null && item != null && item.isAvailable) {
            item.isAvailable = false
            borrowedItems.computeIfAbsent(memberId) { mutableListOf() }.add(itemId)
            println("${member.name} borrowed ${item.title}")
            true
        } else {
            println("Borrow failed: invalid member or item not available.")
            false
        }
    }

    // Return item
    fun returnItem(memberId: String, itemId: String): Boolean {
        val borrowed = borrowedItems[memberId]
        val item = itemsById[itemId]

        return if (borrowed != null && borrowed.contains(itemId) && item != null) {
            borrowed.remove(itemId)
            item.isAvailable = true
            println("Item '${item.title}' returned successfully.")
            true
        } else {
            println("Return failed: item not found in borrowed list.")
            false
        }
    }

    // Search item by ID
    fun searchById(itemId: String): LibraryItem? {
        return itemsById[itemId]
    }

    // Search items by category
    fun searchByCategory(category: String): List<LibraryItem> {
        return itemsByCategory[category] ?: emptyList()
    }

    // Show borrowed items of a member
    fun showBorrowedItems(memberId: String): List<LibraryItem> {
        val borrowedIds = borrowedItems[memberId] ?: return emptyList()
        return borrowedIds.mapNotNull { itemsById[it] }
    }
}