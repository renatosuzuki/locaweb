package br.com.fiap.locaweb.models

import java.sql.Time
import java.util.Date

data class Email(
    val id: Long,
    val sender: String,
    val receiver: String,
    val subject: String,
    val content: String,
    val read: Boolean,
    val starred: Boolean,
    val trashed: Boolean,
    val imageRes: Int,
    val hasEvent: Boolean = false,
    val eventTitle: String? = null,
    val eventDate: Date? = null,
    val eventStartHour: Time? = null,
    val eventEndHour: Time? = null,
    val description: String? = null
)
