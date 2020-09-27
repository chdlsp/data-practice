# data, transaction demo
### 2020-09-26
    - ORM (Object-Relational Mapping)
      - 객체와 릴레이션을 매핑할 때 발생하는 개념적 불일치를 해결하는 프레임워크
      - JPA: ORM을 위한 Java EE 표준
      - Table 에선 PK가 같으면 같은 identity 인데 Object 에서는 어떻게? (ex: hashcode)
      
    - Fetch 전략
      - EAGAR : 바로 연관된 정보를 들고 옴 => 영속성 종료 시점이 Service
      - LAZY : proxy 를 만들어 필요할 때 호출할 수 있게 함 => 영속성 종료 시점이 Controller 로 늘어남
        - proxy 를 건들게 되면 실제 정보로 변경이 된다.
        - 영속성 컨텍스트가 Controller 에 살아 있는 것이 장점
          - Controller 에는 트랜잭션이 종료된 상태
          - Insert, Update, Delete 가 먹지 않는다. (트랜잭션이 종료 되었다!)
          - Open-in-View 전략의 기본 세팅은 true
      
      
### 2020-09-23
    - transactional(readOnly=true) 테스트를 해보려고 했는데 원하는대로 동작하지 않았다.
    찾다 보니 H2 디비에서는 옵션이 제대로 동작하지 않는다고 한다. (벤더사 마다 다르게 동작하는 것 같다.)
    다음 번에는 MySQL로 테스트를 해봐야겠다.
      => 2020-09-26 MySQL 로 확인 시 readOnly=true 에서 insert 불가 확인
      java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
      	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129) ~[mysql-connector-java-8.0.21.jar:8.0.21]
    
```
    protected void prepareTransactionalConnection(Connection con, TransactionDefinition definition)
            throws SQLException {
    
        if (isEnforceReadOnly() && definition.isReadOnly()) {
            Statement stmt = con.createStatement();
            try {
                stmt.executeUpdate("SET TRANSACTION READ ONLY");
            }
            finally {
                stmt.close();
            }
        }
    }
```