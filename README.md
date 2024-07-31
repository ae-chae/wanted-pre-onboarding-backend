# wanted pre onboarding backend



## 브랜치 규칙
- master: 전체 버전을 관리하는 메인 브랜치 <br/>
  master / v버전 형태 <br/> <br/>
  
- feature: 새로운 기능을 개발하는 브랜치 <br/>
  feature / 구현 문항 번호 / 이슈 번호 형태 <br/>
  feature에서 이슈(기능) 구현이 완료 되면 master 브랜치로 merge <br/> <br/> <br/>



- PR, issue 규칙
기능 태그_feature_작업 버전 - 구현하는 페이지명 - 페이지의 기능 설명
feature는 자신의 작업기능을 설명할 수 있는 대문자 단어로 넣으세요!

PR, issue 태그	설명
F	프론트 작업
B	백엔드 작업
S	기초 작업
‼️ 예시) F_ADJUSTMENT_01 - 정산 페이지 - 검색 기능 구현

📌 우리의 Commit Prefix
커밋 메세지 : [commit태그] 추가한 코드에 대해 간략히 설명

기본 Rule

commit 태그	설명
Feat
기능 추가
X
코드 삭제
Fix
버그 수정
Add
기초세팅 및 코드수정
Refactor
코드의 구조를 재조정
Design
Front추가 및 변경
Test
테스트 코드 관련
Docs
리드미 수정
Chore
위에 모든 태그에 해당하지 않을 시
‼️ 예시) [Feat] 정산의 총 합계 기능 추가
