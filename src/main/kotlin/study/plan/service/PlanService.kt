package study.plan.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import study.member.repository.MemberRepository
import study.plan.dto.response.PlanResponse
import study.plan.dto.response.PlansResponse
import study.plan.dto.resquest.PlanRequest
import study.plan.entity.Plan
import study.plan.repository.PlanRepository

@Service
class PlanService(
        val memberRepository: MemberRepository,
        val planRepository: PlanRepository
) {
    @Transactional
    fun save(planRequest: PlanRequest): PlanResponse {
        val member = memberRepository.findById(planRequest.memberId)
                .orElseThrow {
                    IllegalArgumentException("member: ${planRequest.memberId}는 존재하지 않습니다.")
                }
        val plan = Plan(
                title = planRequest.title,
                content = planRequest.content,
                member = member
        )

        return PlanResponse(
                id = plan.id,
                title = plan.title,
                memberId = plan.member.id,
                content = plan.content
        )
    }

    fun findAll(): PlansResponse {
        val findPlans: List<PlanResponse> = planRepository.findAll()
                .map { plan ->
                    PlanResponse(
                            id = plan.id,
                            memberId = plan.member.id,
                            title = plan.title,
                            content = plan.content
                    )
                }

        return PlansResponse(findPlans)
    }

    fun findPlanById(id: Long): PlanResponse {
        val plan = planRepository.findById(id)
                .orElseThrow{
                    IllegalArgumentException("plan: ${id}는 존재하지 않습니다.")
                }

        return PlanResponse(
                id = plan.id,
                memberId = plan.member.id,
                title = plan.title,
                content = plan.content
        )
    }
}