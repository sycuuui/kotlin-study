package study.plan.contorller

import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.*
import study.plan.dto.response.PlanResponse
import study.plan.dto.response.PlansResponse
import study.plan.dto.resquest.PlanRequest
import study.plan.dto.resquest.UpdatePlanRequest
import study.plan.service.PlanService

@RestController
@RequestMapping("plans")
class PlanController(
        val planService: PlanService
) {
    @PostMapping
    fun save(@PathVariable(name = "member_id") memberId: Long,
             @RequestBody planRequest: PlanRequest): PlanResponse = planService.save(memberId, planRequest)

    @GetMapping
    fun findAll(): PlansResponse = planService.findAll()

    @GetMapping("/{plan_id}")
    fun findPlanById(@PathVariable(name = "plan_id") id: Long): PlanResponse = planService.findPlanById(id)

    @PatchMapping("/{member_id}/{plan_id}")
    fun updatePlan(@PathVariable(name = "member_id") memberId: Long,
                   @PathVariable(name = "plan_id") planId: Long,
                   @RequestBody updatePlanRequest: UpdatePlanRequest): PlanResponse = planService.updatePlan(memberId, planId, updatePlanRequest)

}