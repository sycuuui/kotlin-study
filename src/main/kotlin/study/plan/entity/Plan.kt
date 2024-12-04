package study.plan.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import study.member.entity.Member

@Entity
data class Plan (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long =0,
        var title: String,
        var content: String,

        @ManyToOne
        @JoinColumn(name = "member_id")
        val member: Member
)