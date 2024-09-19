package br.com.fiap.locaweb.models

data class Email(
    val id: Long,
    val sender: String,
    val receiver: String,
    val subject: String,
    val content: String,
    val read: Boolean,
    val starred: Boolean,
    val trashed: Boolean,
    val hasEvent: Boolean = false,
    val eventTitle: String? = null,
    val eventDate: String? = null,
    val eventStartHour: String? = null,
    val eventEndHour: String? = null,
    val description: String? = null
)
