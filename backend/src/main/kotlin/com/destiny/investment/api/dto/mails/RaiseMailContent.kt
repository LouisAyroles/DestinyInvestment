package com.destiny.investment.api.dto.mails

import com.destiny.investment.api.dto.CompleteRaiseForm

class RaiseMailContent(raiseForm: CompleteRaiseForm): IMailContent {

    override val content: String = """
        | Email: ${raiseForm.email}
        | Name: ${raiseForm.name}
        | Company name: ${raiseForm.companyName}
    """.trimMargin()

    override val subject = "${raiseForm.name} wants to raise"

    override val files = listOf(raiseForm.pitchDeck)

}