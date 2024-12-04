package study.plan.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.member.entity.Member
import study.plan.entity.Plan

interface PlanRepository: JpaRepository<Plan, Long> {
    fun findPlanByIdAndMember(id: Long, member: Member): Plan?
}