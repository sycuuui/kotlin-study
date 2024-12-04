package study.member.contorller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.member.dto.response.MemberReponse
import study.member.dto.resquest.MemberRequest
import study.member.service.MemberService

@RestController
@RequestMapping("/members")
class MemberController(val memberService: MemberService) {
    @PostMapping
    fun save(@RequestBody memberRequest: MemberRequest): MemberReponse =
            memberService.saveMember(memberRequest)
}