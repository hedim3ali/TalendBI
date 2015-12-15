package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMysqlInputEndJava
{
  protected static String nl;
  public static synchronized TMysqlInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlInputEndJava result = new TMysqlInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t}" + NL + "}finally{" + NL + "\trs_";
  protected final String TEXT_3 = ".close();" + NL + "\tstmt_";
  protected final String TEXT_4 = ".close();";
  protected final String TEXT_5 = NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tif(conn_";
  protected final String TEXT_9 = " != null && !conn_";
  protected final String TEXT_10 = ".isClosed()) {" + NL + "\t\t\tconn_";
  protected final String TEXT_11 = ".close();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_16 = "_NB_LINE\",nb_line_";
  protected final String TEXT_17 = ");" + NL;
  protected final String TEXT_18 = NL + "\tlog.info(\"";
  protected final String TEXT_19 = " - Retrieved records count: \"+nb_line_";
  protected final String TEXT_20 = " + \" .\");" + NL + "\tlog.info(\"";
  protected final String TEXT_21 = " - Done.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	if(!("true").equals(useExistingConn))
	{
		
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    return stringBuffer.toString();
  }
}
