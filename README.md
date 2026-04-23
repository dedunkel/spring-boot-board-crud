# 📌 Spring Boot Board CRUD (Entity Version)

Spring Boot를 사용한 게시판 CRUD 프로젝트입니다.
Entity를 직접 사용하여 기본적인 CRUD 흐름을 구현한 버전입니다.

---

## 🚀 특징

* Entity를 그대로 Request/Response에 사용
* Spring Data JPA 기반 CRUD 구현
* RESTful API 설계 기초 학습

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* H2 Database
* Gradle

---

## 📂 API 구조

| 기능     | Method | URL                                 |
| ------ | ------ | ----------------------------------- |
| 생성     | POST   | `/api/boards`                       |
| 전체 조회  | GET    | `/api/boards`                       |
| 단건 조회  | GET    | `/api/boards/{id}`                  |
| 작성자 조회 | GET    | `/api/boards/writer/{writer}`       |
| 검색     | GET    | `/api/boards/search?search=keyword` |
| 수정     | PUT    | `/api/boards/{id}`                  |
| 삭제     | DELETE | `/api/boards/{id}`                  |

---

## 📥 Example Request (POST)

```json
{
  "title": "게시글 제목",
  "content": "게시글 내용",
  "writer": "홍길동",
  "password": "1234"
}
```

---

## ▶️ 실행 방법

```bash
./gradlew bootRun
```

---

## 💡 학습 포인트

* Spring Boot 기본 구조 이해
* Controller → Service → Repository 흐름
* JPA를 활용한 데이터 처리

---

## ⚠️ 한계

* Entity가 그대로 외부에 노출됨
* 요청/응답 구조 분리가 없음
* 유지보수 및 확장성에 한계 존재

👉 이러한 문제를 개선한 버전은 `main` 브랜치(DTO 적용)에서 확인할 수 있습니다.

---

## 📎 브랜치 이동

```bash
git checkout entity-version
```

---

## ✨ Author

* GitHub: https://github.com/dedunkel
