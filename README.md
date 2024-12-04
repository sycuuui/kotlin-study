# kotlin 언어 springboot 프로젝트 

## kotlin 언어로 springboot 프로젝트 경험해보기 위해 간단한 CURD API 중심 프로젝트 진행해보았습니다.

- language: kotlin
- framework: springboot
- DB: H2

<hr>


`Member`<br><br>
GET: 모든 회원 정보

POST: 회원 정보 저장

DELETE: 회원 삭제
<br><br><br>
`Plan`<br><br>
GET: 모든 일정들 정보<br>
GET("/{plan_id}"): 특정 일정 정보

POST("/{member_id}"): 해당 회원의 일정 정보 저장

PATCH("/{member_id}/{plan_id}"): 해당 회원의 일정 정보 수정

DELETE("/{member_id}/{plan_id}"): 해당 회원의 일정 삭제