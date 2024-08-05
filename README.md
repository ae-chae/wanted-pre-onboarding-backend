# wanted pre onboarding backend


# 과제 수행 내용
### 1. 채용공고를 등록합니다.
```
POST /recruit/upload
```

Request (Body)
```
{
  "companyId": "id1",
  "position": "Developer",
  "reward": 1000000,
  "detail": "Full stack developer needed.",
  "tech": "Java, Spring Boot, React",
  "district": "서울"
}
```

Response (200)
```
{
    "num": 5,
    "companyId": "id1",
    "position": "Developer",
    "reward": 1000000,
    "detail": "Full stack developer needed.",
    "tech": "Java, Spring Boot, React",
    "district": "서울"
}
```

<br/>

### 2. 채용공고를 수정합니다.

```
PATCH /recruit/modify/{ 공고 id }
```


Request (body)
```
{
	"detail" : "수정 완료"
}
```

Response (200)
```
{
    "num": 4,
    "companyId": "id1",
    "position": "Designer",
    "reward": 2000000,
    "detail": "수정 완료",
    "tech": "Figma, photoshop",
    "district": "부산"
}
```

<br/>

ERROR (404 Not Found)
```
{ 공고 id } 번 공고는 존재하지 않습니다.
```
<br/>

#### 3. 채용공고를 삭제합니다.
```
DELETE /recruit/remove/{ 공고 id }
```

Response (200)
```
2 번 공고가 삭제되었습니다.
```

<br/>

ERROR (404 Not Found)
```
{ 공고 id } 번 공고는 존재하지 않습니다.
```

<br/>


#### 4. 채용공고 목록을 가져옵니다.
```
GET /recruit
```


Response (200)
```
[
    {
        "num": 1,
        "companyId": "id1",
        "position": "Developer",
        "reward": 1000000,
        "tech": "Java, Spring Boot, React",
        "district": "서울"
    },
    {
        "num": 5,
        "companyId": "id1",
        "position": "Developer",
        "reward": 1000000,
        "tech": "Java, Spring Boot, React",
        "district": "서울"
    },
    {
        "num": 6,
        "companyId": "id1",
        "position": "Designer",
        "reward": 2000000,
        "tech": "Figma, photoshop",
        "district": "부산"
    },
    {
        "num": 7,
        "companyId": "id2",
        "position": "Developer",
        "reward": 500000,
        "tech": "Python, NodeJS",
        "district": "성남"
    },
    {
        "num": 8,
        "companyId": "id2",
        "position": "Developer",
        "reward": 1000000,
        "tech": "React, iOS",
        "district": "성남"
    }
]
```

<br/>

#### 4-2. 채용공고 검색 기능 구현(선택사항 및 가산점요소).

```
GET /recruit/search?search=designer
```

Response (200)
```
[
    {
        "num": 6,
        "companyId": "id1",
        "position": "Designer",
        "reward": 2000000,
        "tech": "Figma, photoshop",
        "district": "부산"
    },
    {
        "num": 9,
        "companyId": "id2",
        "position": "Designer",
        "reward": 2000000,
        "tech": "Figma, Illustrator",
        "district": "성남"
    }
]
```
<br/>

#### 5. 채용 상세 페이지를 가져옵니다.


#### 해당 회사가 올린 다른 채용공고 가 추가적으로 포함됩니다(선택사항 및 가산점요소).


```
GET /recruit/detail/{ 공고 id }
```

Response (200)
```
{
    "id": 6,
    "companyName": "원티드",
    "position": "Designer",
    "reward": 2000000,
    "details": "UI/UX designer",
    "tech": "Figma, photoshop",
    "district": "부산",
    "otherJobPostings": [
        1,
        5
    ]
}
```

<br/>

#### 6. 사용자는 채용공고에 지원합니다(선택사항 및 가산점요소).

```
POST /apply
```

Request (Body)
```
{
    "recruitNum": 5,
    "userId": "user1"
}
```


Response (200)
```
{
    "userId": "user1",
    "recruitNum": 5
}
```
