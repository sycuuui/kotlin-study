package study.plan.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.plan.entity.Plan

interface PlanRepository: JpaRepository<Plan, Long> {
}