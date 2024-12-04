package study.plan.dto.response

data class PlanResponse(
        val id: Long,
        val memberId: Long,
        val title: String,
        val content: String
)
