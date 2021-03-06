package org.talend.designer.codegen.translators.databases.hsqldb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THSQLDbInputEndJava
{
  protected static String nl;
  public static synchronized THSQLDbInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THSQLDbInputEndJava result = new THSQLDbInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t}" + NL + "}finally{" + NL + "\tstmt_";
  protected final String TEXT_3 = ".close();" + NL + "\tif(conn_";
  protected final String TEXT_4 = "!=null){" + NL + "\t\tconn_";
  protected final String TEXT_5 = " .close();" + NL + "\t}" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_6 = "_NB_LINE\",nb_line_";
  protected final String TEXT_7 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
