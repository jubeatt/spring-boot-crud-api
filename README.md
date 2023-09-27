# Spring Boot - CRUD Rest API

**置頂：因為 GitHub 只支援 Static Site，所以這個專案是沒辦法直接用的，你必須自己抓到本機中跑起來才行。**

- [Spring Boot - CRUD Rest API](#spring-boot---crud-rest-api)
  - [這是什麼？](#這是什麼)
  - [怎麼把這個專案跑起來？](#怎麼把這個專案跑起來)

## 這是什麼？

用 Spring Boot 建立的 Rest API，包含 CRUD 功能。

Resource 的內容如下：

| Path                    | Method | Body | Description  |
| ----------------------- | ------ | ---- | ------------ |
| `/api/v1/students`      | GET    | x    | 取得學生列表 |
| `/api/v1/students`      | POST   | o    | 新增學生     |
| `/api/v1/students`      | PUT    | o    | 修改學生     |
| `/api/v1/students/{id}` | DELETE | x    | 刪除學生     |

Response 範例（取得學生列表）：

```json
[
  {
    "id": 1,
    "name": "PeaNu",
    "age": 20,
    "email": "peanu@peanu.dev",
    "birthday": "1998-06-29"
  }
]
```

Request 範例（新增學生）：

```json
{
  "name": "PeaNu",
  "age": 20,
  "email": "PeaNu@peanu.dev",
  "birthday": "1998-06-29"
}
```

## 怎麼把這個專案跑起來？

1\. 請先 clone 此專案

```bash
git clone https://github.com/jubeatt/spring-boot-crud-api.git
```

2\. 到 `application.properties` 中設定好資料庫相關的設定

```text
spring.datasource.url=jdbc:mysql://localhost:3306/{database}
spring.datasource.username={username}
spring.datasource.password={password}
```

註：此專案有開啟 `ddl-auto` 功能，所以只需要建立好 database 就可以直接用了。

3\. 請用 IntelliJ 打開此專案，並透過 Maven 安裝好相關的依賴項目後，就可以用 Run 來跑起來了。
