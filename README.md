# 📌 Spring Boot Board CRUD

Spring Boot를 사용한 게시판 CRUD 프로젝트입니다.  
기본적인 CRUD부터 DTO 패턴, Validation, Global Exception Handling까지 단계적으로 구성되어 있습니다.

---

## 🚀 Versions

### 🔹 entity-version

* Entity를 직접 사용한 CRUD 구현
* 빠르게 구조를 이해하기 위한 기본 버전

### 🔹 main

* DTO(Request / Response) 패턴 적용
* 계층 간 역할 분리 (Controller / Service / Repository)
* Validation 적용
* Custom Exception 적용
* Global Exception Handling 적용
* 비밀번호 변경 API 분리
* Entity 외부 노출 제거

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Spring Validation
* H2 Database
* Gradle

---

## 📂 API 구조

| 기능 | Method | URL |
|---|---|---|
| 생성 | POST | /api/boards |
| 전체 조회 | GET | /api/boards |
| 단건 조회 | GET | /api/boards/{id} |
| 작성자 조회 | GET | /api/boards/writer/{writer} |
| 검색 | GET | /api/boards/search?search=keyword |
| 수정 | PUT | /api/boards/{id} |
| 삭제 | DELETE | /api/boards/{id} |
| 비밀번호 변경 | PATCH | /api/boards/{id}/password |

---

## 📥 Example Request

### 🔹 게시글 생성 (POST)

```json
{
  "title": "게시글 제목",
  "content": "게시글 내용입니다.",
  "writer": "홍길동",
  "password": "1234"
}
