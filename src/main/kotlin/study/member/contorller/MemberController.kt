package study.member.contorller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.member.dto.response.MemberListResponse
import study.member.dto.response.MemberReponse
import study.member.dto.resquest.MemberRequest
import study.member.service.MemberService

@RestController
@RequestMapping("/members")
class MemberController(val memberService: MemberService) {
    @PostMapping
    fun save(@RequestBody memberRequest: MemberRequest): MemberReponse =
            memberService.save(memberRequest)

    @GetMapping
    fun findAll(): MemberListResponse =
            memberService.findAll()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(name = "id") id: Long) :ResponseEntity<String> {
        memberService.delete(id)

        return ResponseEntity.ok("memberId: $id 는 삭제 되었습니다.")
    }
}