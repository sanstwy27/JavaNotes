package com.sanstwy27.designpattern.command._jdk;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Example {
    public static void main(String[] args) {
        //JdbcTemplate
        /**
         * 1. execute -> [invoker]
         * public class JdbcTemplate extends JdbcAccessor implements JdbcOperations {
         *     ...
         *     @Nullable
         *     public <T> T execute(StatementCallback<T> action) throws DataAccessException {
         *         ...
         *     }
         *     ...
         *     public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
         *         return (List)result(this.query((String)sql, (ResultSetExtractor)(new RowMapperResultSetExtractor(rowMapper))));
         *     }
         *     ...
         *
         * 2. QueryStatementCallback (Nested Classes) -> [receiver]
         *     @Nullable
         *     public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
         *         ...
         *         class QueryStatementCallback implements StatementCallback<T>, SqlProvider {
         *             QueryStatementCallback() {
         *             }
         *
         *             @Nullable
         *             public T doInStatement(Statement stmt) throws SQLException {
         *                 ResultSet rs = null;
         *
         *                 Object var3;
         *                 try {
         *                     rs = stmt.executeQuery(sql);
         *                     var3 = rse.extractData(rs);
         *                 } finally {
         *                     JdbcUtils.closeResultSet(rs);
         *                 }
         *
         *                 return var3;
         *             }
         *
         *             public String getSql() {
         *                 return sql;
         *             }
         *         }
         *
         * 3. StatementCallback -> [command]
         * @FunctionalInterface
         * public interface StatementCallback<T> {
         *     @Nullable
         *     T doInStatement(Statement var1) throws SQLException, DataAccessException;
         * }
         *
         *
         */
    }
}
