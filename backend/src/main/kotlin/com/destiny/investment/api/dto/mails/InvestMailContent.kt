package com.destiny.investment.api.dto.mails

import com.destiny.investment.api.dto.InvestForm
import org.springframework.web.multipart.MultipartFile

class InvestMailContent(investForm: InvestForm): IMailContent {

    override val content: String =
        """
        | Email: ${investForm.email}
        | Name: ${investForm.name}
        | Investment areas: ${investForm.investmentAreas}
        | Company stage: ${investForm.companyStage.readable}
        | Portfolio size: ${investForm.portfolioSize}
    """.trimMargin()

    override val subject: String = "${investForm.name} wants to invest"

    override val files: List<MultipartFile> = emptyList()

}