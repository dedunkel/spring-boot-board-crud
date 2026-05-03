# 📌 Spring Boot Board CRUD (Entity Version)

Spring Boot와 JPA를 활용한 게시판 CRUD 프로젝트입니다.
본 버전은 **Entity를 직접 사용하는 구조**로, JPA 연관관계 학습을 목표로 합니다.

---

## 🚀 주요 특징

* Entity 기반 CRUD 구현
* JPA 연관관계 매핑 학습
* 다양한 관계 구조 적용

  * 1:1
  * 1:N
  * N:M → 중간 테이블로 분리

---

## 🧩 Entity 구성

### 🔹 Board (게시글)

* id (PK)
* title
* content
* writer
* password

---

### 🔹 BoardDetail (게시글 상세)

* id (PK)
* viewCount
* likeCount
* board_id (FK)

👉 Board와 **1:1 관계**

---

### 🔹 Comment (댓글)

* id (PK)
* content
* writer
* board_id (FK)

👉 Board와 **1:N 관계**

---

### 🔹 Tag (태그)

* id (PK)
* name

---

### 🔹 BoardTag (중간 테이블)

* id (PK)
* board_id (FK)
* tag_id (FK)

👉 Board와 Tag의 관계를 연결하는 **중간 엔티티**

---

## 🔗 관계 구조

* Board ↔ BoardDetail → **1:1**
* Board ↔ Comment → **1:N**
* Board ↔ BoardTag → **1:N**
* Tag ↔ BoardTag → **1:N**

👉 Board ↔ Tag는 직접적인 N:M 관계가 아니라
**BoardTag를 통해 1:N + 1:N 구조로 분리하여 구현**

---

## 💡 핵심 설계 포인트

### ✅ 1. 연관관계 매핑

* `@OneToOne`
* `@OneToMany`
* `@ManyToOne`

---

### ✅ 2. N:M 관계 해결

기존:

```text id="a1xk2p"
Board ↔ Tag (N:M)
```

변경:

```text id="p9qk2z"
Board → BoardTag → Tag
```

👉 중간 엔티티를 사용하여
**확장성과 유지보수성 향상**

---

### ✅ 3. 계층 구조

```text id="qv0e8l"
Controller → Service → Repository → Entity
```

---

## 📂 API 구조

### 📌 Board

| 기능    | Method | URL                |
| ----- | ------ | ------------------ |
| 생성    | POST   | `/api/boards`      |
| 전체 조회 | GET    | `/api/boards`      |
| 단건 조회 | GET    | `/api/boards/{id}` |
| 수정    | PUT    | `/api/boards/{id}` |
| 삭제    | DELETE | `/api/boards/{id}` |

---

### 📌 Comment

| 기능 | Method | URL                       |
| -- | ------ | ------------------------- |
| 생성 | POST   | `/api/comments/{boardId}` |
| 조회 | GET    | `/api/comments/{boardId}` |

---

### 📌 Tag

| 기능         | Method | URL                            |
| ---------- | ------ | ------------------------------ |
| 태그 추가      | POST   | `/api/tags/{boardId}?name=태그명` |
| 전체 태그 조회   | GET    | `/api/tags`                    |
| 게시글별 태그 조회 | GET    | `/api/tags/{boardId}`          |

---

## 📥 Example Request

### 🔹 게시글 생성

```json id="b8l2kq"
{
  "title": "게시글 제목",
  "content": "게시글 내용",
  "writer": "홍길동",
  "password": "1234"
}
```

---

## ▶️ 실행 방법

```bash id="k7v3mz"
./gradlew bootRun
```

---

## 🌱 학습 포인트

* JPA 연관관계 설계 이해
* 중간 테이블을 활용한 N:M 관계 처리
* Entity 기반 데이터 흐름 이해
* RESTful API 설계 경험

---

## 🔀 브랜치

* `entity-version` : Entity 직접 사용 버전
* `main` : DTO 적용 버전

---

## ✨ Author

* GitHub: https://github.com/dedunkel
