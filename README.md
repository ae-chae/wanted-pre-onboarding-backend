# wanted pre onboarding backend



## 브랜치 규칙
- master: 전체 버전을 관리하는 메인 브랜치 <br/>
  master / { 버전 } 형태 <br/> <br/>
  
- feature: 새로운 기능을 개발하는 브랜치 <br/>
  feature / { 구현 문항 번호 } / { 이슈 번호 } 형태  <br/>
  feature에서 이슈(기능) 구현이 완료 되면 master 브랜치로 merge <br/> <br/> <br/>




### - PR, issue 규칙

기능 태그_feature_작업 버전 - 기능 설명
> feature는 작업 기능을 설명할 수 있는 대문자 단어

| PR, issue 태그 | 설명 |
|--------|------|
| B | 백엔드 작업 |
| S | 기초 작업 |


‼️ 예시) F_ADJUSTMENT_01 - 검색 기능 구현

## 📌 <strong>Commit Prefix</strong>
커밋 메세지 : [commit 태그] 추가한 코드에 대해 간략히 설명

기본 Rule
|commit 태그|설명|
|---|---|
`Feat`<br>|기능 추가
`X`<br>| 코드 삭제
`Fix`<br>|버그 수정
`Add`<br>|기초 세팅 및 코드 수정
`Refactor`<br> |코드의 구조를 재조정
`Test`<br>|테스트 코드 관련
`Docs`<br>|리드미 수정
`Chore`<br>|위에 모든 태그에 해당하지 않을 시



‼️ 예시) [Feat] 검색 기능 추가
