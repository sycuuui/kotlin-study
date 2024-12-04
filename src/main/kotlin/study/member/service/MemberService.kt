package study.member.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import study.member.dto.response.MemberReponse
import study.member.dto.resquest.MemberRequest
import study.member.entity.Member
import study.member.repository.MemberRepository

@Service
class MemberService(
        private val memberRepository: MemberRepository
) {
    @Transactional
    fun save(memberRequest: MemberRequest): MemberReponse {
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

    fun delete(memberId: Long) {
        val member = memberRepository.findById(memberId)
                .orElseThrow { IllegalArgumentException("memberId: $memberId not found") }

        memberRepository.delete(member)
    }
}