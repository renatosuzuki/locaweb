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
    val imageRes: Int
)
