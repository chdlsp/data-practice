# data, transaction demo

### 2020-09-23
    - transactional(readOnly=true) 테스트를 해보려고 했는데 원하는대로 동작하지 않았다.
    찾다 보니 H2 디비에서는 옵션이 제대로 동작하지 않는다고 한다. (벤더사 마다 다르게 동작하는 것 같다.)
    다음 번에는 MySQL로 테스트를 해봐야겠다.
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