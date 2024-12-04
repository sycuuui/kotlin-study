package study.plan.service

import org.springframework.stereotype.Service
import study.member.repository.MemberRepository
import study.plan.dto.response.PlanResponse
import study.plan.dto.resquest.PlanRequest
import study.plan.entity.Plan

@Service
class PlanService(
        val memberRepository: MemberRepository,
        val planRepository: MemberRepository
) {
    fun save(planRequest: PlanRequest): PlanResponse {
        val member = memberRepository.findById(planRequest.memberId)
                .orElseThrow{
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
}