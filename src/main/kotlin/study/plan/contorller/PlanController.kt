package study.plan.contorller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.plan.dto.response.PlanResponse
import study.plan.dto.response.PlansResponse
import study.plan.dto.resquest.PlanRequest
import study.plan.service.PlanService

@RestController
@RequestMapping("plans")
class PlanController(
        val planService: PlanService
) {
    @PostMapping
    fun save(@RequestBody planRequest: PlanRequest): PlanResponse = planService.save(planRequest)

    @GetMapping
    fun findAll(): PlansResponse = planService.findAll()
}