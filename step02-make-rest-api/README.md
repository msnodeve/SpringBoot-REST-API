# Step02 Make REST API

<br><br>

## Branch Name
step02-make-rest-api

<br><br>

## REST의 특성
- `클라이언트/서버` 클라이언트와 서버가 서로 독립적으로 구분 되어야 한다. 또한 서버 또는 클라이언트 증설 시 서로간의 의존성 때문에 확장에 문제가 되서는 안된다.
- `상태 없음` 서버는 클라이언트의 상태를 기억할 필요가 없다.
- `레이어드 아키텍처` 다계층 형태로 레이어를 추가하거나 수정, 제거 할 수 있고 확장성이 있어야한다.
- `캐시` 클라이언트가 캐시를 통해서 응답을 재사용 하여 이를 통해 서버의 부하를 낮춰 서버의 성능이 향상 될 수 있다.
- `코드 온 디멘드` 요청이 오면 코드를 준다.

<br>

## REST 인터페이스 규칙
- `리소스 식별` 웹 안에서 URI와 같은 고유 식별자를 통해 표현한다.
- `표현을 통한 리소스 처리` JSON, XML, HTML 페이지와 같이 다양한 유형으로 표현 할 수 있다.
- `자기 묘사 메세지` HTTP 통신 할 때 Http header에 메타 데이터 정보를 추가해서 실제 데이터와는 관련 없지만 데이터에 대한 설명을 나타내는 정보를 담을 수 있다.
- `애플리케이션 상태 하이퍼미디어(HATEOAS)` REST API를 개발할 때도 단순히 데이터만 전달하는 것이 아닌 링크 정보까지 포함한다.

<br><br>

## REST API 만들기

### 모델 클래스 만들기

데이터를 담을 수 있는 클래스를 만듭니다.

> src/main/java/seok/model 경로를 만들고, 그 밑에 Todo.java 를 생성

<br>

<br>



Todo.java 내용은 다음과 같습니다.

```java
package seok.model;

public class Todo {
    private int id;
    private String title;

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

```



<br><br>



### 컨트롤러 클래스 만들기

URL을 요청하면 Todo 클래스의 인스턴스를 생성해 JSON으로 보여줄 수 있는 컨트롤러를 만듭니다.



> src/main/java/seok/controller 경로 밑에 TodoController.java 를 생성

TodoController.java 내용은 다음과 같습니다.

```java
package seok.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seok.model.Todo;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/todo")
    public Todo todo(){
        return new Todo(counter.incrementAndGet(), "코딩하기");
    }
}

```



`AtomicInteger`는 Atomic(더 이상 쪼개질 수 없는 성질)을 의미하며, 단순히 Integer 타입으로 선언한다면 서로 다른 Thread 에서 하나의 변수에 대해 값을 쓰거나 읽기 때문에 문제가 발생할 수 있지만, `AtomicInteger`를 쓰므로 `Thread-safe` 하게 처리가 가능합니다.


<br><br>


### 실행해보기

localhost:8080/todo/todo 를 계속 호출해보면 호출 할 때마다 숫자가 정상적으로 증가하는 것을 확인 할 수 있습니다.


<div style="text-align: center">
    <img src="./img/step02-1.png" width="50%">
</div>


<div style="text-align: center">
    <img src="./img/step02-2.png" width="50%">    
</div>


<br><br>