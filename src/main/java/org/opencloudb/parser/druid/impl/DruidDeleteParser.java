package org.opencloudb.parser.druid.impl;

import java.sql.SQLNonTransientException;

import org.opencloudb.config.model.SchemaConfig;
import org.opencloudb.route.RouteResultset;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlDeleteStatement;

public class DruidDeleteParser extends DefaultDruidParser {
	@Override
	public void statementParse(SchemaConfig schema, RouteResultset rrs, SQLStatement stmt) throws SQLNonTransientException {
		MySqlDeleteStatement delete = (MySqlDeleteStatement)stmt;
		String tableName = removeBackquote(delete.getTableName().getSimpleName().toUpperCase());
		ctx.addTable(tableName);
		ctx.setSql(stmt.toString());
	}
}

