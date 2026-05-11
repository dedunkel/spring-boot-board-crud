# 📌 Spring Boot Board CRUD

Spring Boot를 사용한 게시판 CRUD 프로젝트입니다.
기본적인 CRUD부터 DTO 패턴 적용, 비밀번호 변경 기능까지 단계적으로 구성되어 있습니다.

---

## 🚀 Versions

### 🔹 entity-version

* Entity를 직접 사용한 CRUD 구현
* 빠르게 구조를 이해하기 위한 기본 버전

### 🔹 main

* DTO(Request / Response) 패턴 적용
* 계층 간 역할 분리 (Controller / Service / Repository)
* 비밀번호 변경 API 분리
* Entity 외부 노출 제거

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* H2 Database
* Gradle

---

## 📂 API 구조

| 기능      | Method | URL                               |
| ------- | ------ | --------------------------------- |
| 생성      | POST   | /api/boards                       |
| 전체 조회   | GET    | /api/boards                       |
| 단건 조회   | GET    | /api/boards/{id}                  |
| 작성자 조회  | GET    | /api/boards/writer/{writer}       |
| 검색      | GET    | /api/boards/search?search=keyword |
| 수정      | PUT    | /api/boards/{id}                  |
| 삭제      | DELETE | /api/boards/{id}                  |
| 비밀번호 변경 | PATCH  | /api/boards/{id}/password         |

---

## 📥 Example Request

### 🔹 게시글 생성 (POST)

```json
{
  "title": "게시글 제목",
  "content": "게시글 내용",
  "writer": "홍길동",
  "password": "1234"
}
```

---

### 🔹 비밀번호 변경 (PATCH)

```json
{
  "currentPassword": "1234",
  "newPassword": "5678"
}
```

---

## 💡 프로젝트 목적

* Spring Boot 기반 CRUD 흐름 이해
* Entity 직접 사용 방식과 DTO 패턴 비교
* RESTful API 설계 경험
* 계층 분리 구조 이해

---

## 🧠 개선 포인트 (DTO 적용 이유)

* Entity 직접 노출 문제 해결
* 민감 정보(password) 응답에서 제거
* Request / Response 역할 분리
* 유지보수성 및 확장성 향상

---

## 🏗️ 구조

Controller → Service → Repository → DB
    ↓
    DTO

---

## ▶️ 실행 방법

```bash
./gradlew bootRun
```

---

## 📎 브랜치 이동

```bash
git checkout entity-version
```

---

## ✨ Author

* GitHub: https://github.com/dedunkel
