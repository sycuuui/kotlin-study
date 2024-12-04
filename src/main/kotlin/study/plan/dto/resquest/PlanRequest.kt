package study.plan.dto.resquest

data class PlanRequest(
        val memberId: Long,
        val title: String,
        val content: String
)
