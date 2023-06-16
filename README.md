# minidooray_taskapi


## user

### POST /api/task/users
- Description: 새로운 사용자를 추가합니다.

JSON 형식 요청 파라미터
|파라미터|타입|필수 여부|설명|
|---|---|-|-----|
|userUUID|string|Y||
|userId|string|Y||
|userNickName|string|Y||
|userEmail|string|Y||

응답 코드: 200 ok
- body: empty
</br>

### GET /api/task/users/{userUUID}
- Description: 사용자 UUID로 조회한 사용자 정보를 반환합니다.
- Path Variables: 
    - userUUID: 사용자 UUID

응답 코드: 200 ok
- body: JSON 형식 응답

|파라미터|타입|필수 여부|설명|
|---|---|-|-----|
|userUUID|string|Y||
|userId|string|Y||
|userNickName|string|Y||
|userEmail|string|Y||
</br>

### GET /api/task/users
- Description: 모든 사용자 정보리스트를 반환합니다.

응답 코드: 200 ok
- body: JSON 형식 응답

|파라미터|타입|필수 여부|설명|
|---|---|-|-----|
|userUUID|string|Y||
|userId|string|Y||
|userNickName|string|Y||
|userEmail|string|Y||
</br>

### PUT /api/task/users/{userUUID}
- Description: 사용자 UUID로 조회하여 사용자 정보를 수정합니다.
- Path Variables: 
    - userUUID: 사용자 UUID

JSON 형식 요청 파라미터
|파라미터|타입|필수 여부|설명|
|---|---|-|-----|
|userUUID|string|Y||
|userId|string|Y||
|userNickName|string|Y||
|userEmail|string|Y||

응답 코드: 200 ok
- body: empty
</br>

### DELETE /api/task/users/{userUUID}
- Description: 사용자 UUID로 대상 사용자 정보를 삭제합니다.
- Path Variables: 
    - userUUID: 사용자 UUID

응답 코드: 200 ok
- body: empty
</br>

## project


## task


## tag


## comment


## milestone






## POST /api/projects/{projectId}/users/{userUUID}
- Description: 특정 프로젝트에 사용자 추가
- Path Variables: 
    - projectId: 프로젝트 ID
    - userUUID: 사용자 UUID
- Request Body: None
- Response Body: None

## GET /api/projects/{projectId}/users
- Description: 특정 프로젝트에 속한 모든 사용자 가져오기
- Path Variables: 
    - projectId: 프로젝트 ID
- Request Body: None
- Response Body: 
    - List of UserGetDto

## GET /api/users/{userUUID}/projects
- Description: 특정 사용자가 속한 모든 프로젝트 가져오기
- Path Variables: 
    - userUUID: 사용자 UUID
- Request Body: None
- Response Body: 
    - List of ProjectDto

## DELETE /api/projects/{projectId}/users/{userUUID}
- Description: 특정 프로젝트에서 사용자 제거
- Path Variables: 
    - projectId: 프로젝트 ID
    - userUUID: 사용자 UUID
- Request Body: None
- Response Body: None

## DELETE /api/projects/{projectId}
- Description: 프로젝트 ID로 프로젝트 삭제
- Path Variables: 
    - projectId: 프로젝트 ID
- Request Body: None
- Response Body: None
