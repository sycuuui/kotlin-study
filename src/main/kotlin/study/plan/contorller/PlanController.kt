package study.plan.contorller

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
    @PostMapping("/{member_id}")
    fun save(@PathVariable(name = "member_id") memberId: Long,
             @RequestBody planRequest: PlanRequest): PlanResponse = planService.save(memberId, planRequest)

    @GetMapping
    fun findAll(): PlansResponse = planService.findAll()

    @GetMapping("/{plan_id}")
    fun findPlanById(@PathVariable(name = "plan_id") id: Long): PlanResponse = planService.findPlanById(id)

    @PatchMapping("/{member_id}/{plan_id}")
    fun update(@PathVariable(name = "member_id") memberId: Long,
               @PathVariable(name = "plan_id") planId: Long,
               @RequestBody updatePlanRequest: UpdatePlanRequest): PlanResponse = planService.update(memberId, planId, updatePlanRequest)

    @DeleteMapping("/{member_id}/{plan_id}")
    fun delete(@PathVariable(name = "member_id") memberId: Long,
               @PathVariable(name = "plan_id") planId: Long) = planService.delete(memberId, planId)

}