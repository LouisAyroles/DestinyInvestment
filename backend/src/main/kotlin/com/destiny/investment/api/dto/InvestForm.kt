package com.destiny.investment.api.dto

import com.destiny.investment.api.dto.mails.IMailContent
import com.destiny.investment.api.dto.mails.InvestMailContent

data class InvestForm(
    val email: String,
    val name: String,
    val investmentAreas: List<String>,
    val companyStage: CompanyStage,
    val portfolioSize: PortfolioSize
)

fun InvestForm.toMailContent(): IMailContent = InvestMailContent(this)

enum class CompanyStage(val readable: String) {
    EarlierWithHigherReturn(readable = "Earlier stage with higher return potential"),
    LaterWithMarketTraction(readable = "Later stage growth companies with market traction")
}

enum class PortfolioSize {
    GradeA,
    GradeB,
    GradeC,
    GradeD
}