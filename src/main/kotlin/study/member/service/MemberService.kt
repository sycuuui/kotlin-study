package study.member.service

import org.springframework.stereotype.Service
import study.member.dto.response.MemberReponse
import study.member.dto.resquest.MemberRequest
import study.member.entity.Member
import study.member.repository.MemberRepository

@Service
class MemberService(
        private val memberRepository: MemberRepository
) {
    fun saveMember(memberRequest: MemberRequest): MemberReponse {
        val member = Member(
                name = memberRequest.name,
                email = memberRequest.email
        )

        val savedMember = memberRepository.save(member)

        return MemberReponse(
                id = savedMember.id,
                name = savedMember.name,
                email = savedMember.email
        )
    }
}