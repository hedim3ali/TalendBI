package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TJDBCSPBeginJava
{
  protected static String nl;
  public static synchronized TJDBCSPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCSPBeginJava result = new TJDBCSPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = " " + NL + "\t\tif (null == connection_";
  protected final String TEXT_6 = ") {" + NL + "\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_7 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES); " + NL + "\t\t\tconnection_";
  protected final String TEXT_8 = " = dataSources_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ").getConnection();" + NL + "\t\t}";
  protected final String TEXT_11 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_12 = " = null;" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_14 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\tif (null != dataSources_";
  protected final String TEXT_15 = ") {" + NL + "\t\t\tconnection_";
  protected final String TEXT_16 = " = dataSources_";
  protected final String TEXT_17 = ".get(";
  protected final String TEXT_18 = ").getConnection();" + NL + "\t\t} else {" + NL + "\t";
  protected final String TEXT_19 = NL + "\t\t\tjava.lang.Class.forName(";
  protected final String TEXT_20 = ");" + NL + "\t\t\tString connectionString_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "\t\t\tconnection_";
  protected final String TEXT_23 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\t}";
  protected final String TEXT_28 = NL + NL + "java.sql.CallableStatement statement_";
  protected final String TEXT_29 = " = connection_";
  protected final String TEXT_30 = ".prepareCall(\"{";
  protected final String TEXT_31 = "call \" + ";
  protected final String TEXT_32 = " + \"(";
  protected final String TEXT_33 = "?";
  protected final String TEXT_34 = ",?";
  protected final String TEXT_35 = ")}\");" + NL + "" + NL + "java.sql.Date tmpDate_";
  protected final String TEXT_36 = ";" + NL + "String tmpString_";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String driverJar = ElementParameterParser.getValue(node, "__DRIVER_JAR__");
String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
String jdbcUrl = ElementParameterParser.getValue(node, "__URL__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd  = ElementParameterParser.getValue(node, "__PASS__");
String spName = ElementParameterParser.getValue(node, "__SP_NAME__");
boolean isFunction = ("true").equals(ElementParameterParser.getValue(node, "__IS_FUNCTION__"));
List<Map<String, String>> spArgs = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SP_ARGS__");


    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("true").equals(useExistingConn)){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_4);
    	
	INode connectionNode = null;
	for (INode processNode : node.getProcess().getGeneratingNodes()) {
		if(connection.equals(processNode.getUniqueName())) {
			connectionNode = processNode;
			break; 
		} 
	} 
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__"); 

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_10);
    
	}
}else{

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_18);
    
	}
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(jdbcUrl );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbuser );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbpwd );
    stringBuffer.append(TEXT_26);
    
	if(specify_alias){
	
    stringBuffer.append(TEXT_27);
    
	}
}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(isFunction ? "? = " : "");
    stringBuffer.append(TEXT_31);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_32);
    
boolean isFirstArg = true;
for (int i = 0; i < spArgs.size(); i++) {
	if(!("RECORDSET").equals(spArgs.get(i).get("TYPE"))){
		if(isFirstArg){
			
    stringBuffer.append(TEXT_33);
    
			isFirstArg=false;
		}else{
			
    stringBuffer.append(TEXT_34);
    
		}
	}
}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
