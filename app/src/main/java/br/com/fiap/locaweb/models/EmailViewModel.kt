package br.com.fiap.locaweb.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.locaweb.repository.EmailRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class EmailViewModel : ViewModel() {
    private val emailRepository = EmailRepository()

    var emails by mutableStateOf(listOf<Email>())
        private set

    private var originalEmails = listOf<Email>()

    val favoriteEmails: List<Email>
        get() = emails.filter { it.starred }

    init {
        this.loadEmails()
    }

    private fun loadEmails() {
        viewModelScope.launch {
            try {
                val response = emailRepository.getEmails()

                if (response.isSuccessful) {
                    response.body()?.let { fetchedEmails ->
                        emails = fetchedEmails
                        originalEmails = fetchedEmails
                        checkAndMoveToSpam()
                    }
                } else {
                    println("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun toggleFavorite(email: Email) {
        emails = emails.map { if (it.id == email.id) email.copy(starred = !email.starred) else it }
    }

    fun searchEmails(query: String) {
        emails = if (query.isEmpty()) {
            originalEmails
        } else {
            originalEmails.filter {
                it.subject.contains(query, ignoreCase = true) ||
                        it.sender.contains(query, ignoreCase = true)
            }
        }
        checkAndMoveToSpam()
    }
    private fun isSpam(email: Email, spamKeywords: List<String>): Boolean {
        val textToCheck = listOf(
            email.subject,
            email.content,
            email.eventTitle ?: "",
            email.description ?: ""
        ).joinToString(" ").toLowerCase()

        return spamKeywords.any { textToCheck.contains(it.toLowerCase()) }
    }

    var spamEmails by mutableStateOf(listOf<Email>())
        private set

    fun moveToSpam(email: Email) {
        spamEmails = spamEmails + email
        emails = emails - email
        originalEmails = originalEmails - email
    }

    private fun checkAndMoveToSpam() {
        val emailsToMove = emails.filter { isSpam(it, spamKeywords) }
        emailsToMove.forEach { moveToSpam(it) }
    }

    private val spamKeywords = listOf(
        "promoção", "grátis", "dinheiro", "urgente", "ganhe", "oferta", "presente", "ganhar",
        "desconto", "dinheiro fácil", "imediato", "100% grátis", "você ganhou", "carta de recompensa",
        "receba dinheiro", "compra agora", "prêmio", "lucro rápido", "trabalhe de casa", "investimento seguro",
        "empréstimo", "ajuda financeira", "seguro", "pague só o frete", "baixe grátis", "seminário grátis",
        "não perca", "cancele qualquer momento", "empréstimo garantido", "compra direta", "resultados garantidos",
        "extra renda", "só hoje", "oferta limitada", "não é brincadeira", "melhor preço", "sem custo",
        "milhões", "ganho rápido", "realize seus sonhos", "sorteio", "super desconto", "esquema",
        "sem compromisso", "você é um vencedor", "mude sua vida", "nova oportunidade", "oferta especial",
        "ganhe dinheiro rápido", "bônus", "lucro garantido", "promoção especial", "veja como",
        "aceite cartão de crédito", "inscreva-se agora", "venda direta", "transação segura", "oferta exclusiva",
        "pagamento rápido", "acesso imediato", "não é spam", "nunca antes visto", "email confidencial",
        "recompensa", "dinheiro extra", "exclusivo", "benefícios gratuitos", "melhor oferta", "solução rápida",
        "sucesso garantido", "dinheiro instantâneo", "oportunidade única", "super oferta", "fique rico",
        "encontre o melhor preço", "financeiramente seguro", "sua chance", "ganhe hoje", "abrir agora",
        "parabéns", "oferta imperdível", "está esperando o que?", "aumente sua renda", "plano de enriquecimento",
        "clique aqui", "verifique seu email", "ganhe sem investir", "não perca esta oportunidade",
        "você pode ganhar", "renda extra", "melhor negócio", "você foi selecionado", "sem taxas", "comprovação gratuita",
        "resultados rápidos", "prêmios", "compra com desconto", "oferta disponível", "aberto 24 horas",
        "empréstimo rápido", "resposta imediata", "oferta com desconto", "clique e ganhe", "ganho rápido e fácil",
        "não espere mais", "oferta nova", "confirmação imediata", "sucesso financeiro", "ganhos garantidos"
    )


}
