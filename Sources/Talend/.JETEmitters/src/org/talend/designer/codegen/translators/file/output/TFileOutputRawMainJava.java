package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileOutputRawMainJava
{
  protected static String nl;
  public static synchronized TFileOutputRawMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputRawMainJava result = new TFileOutputRawMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tObject content_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";" + NL + "\t\t\t\t\tif(content_";
  protected final String TEXT_6 = " != null) {" + NL + "\t\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_7 = "=new java.io.File(fileName_";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t\t\tjava.io.File parentFile_";
  protected final String TEXT_9 = "=file_";
  protected final String TEXT_10 = ".getParentFile();" + NL + "\t\t\t\t\t\tif(parentFile_";
  protected final String TEXT_11 = "!=null && !parentFile_";
  protected final String TEXT_12 = ".exists()){" + NL + "\t\t\t\t\t\t\tparentFile_";
  protected final String TEXT_13 = ".mkdirs();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(content_";
  protected final String TEXT_14 = " instanceof String) {" + NL + "\t\t\t\t\t\t\torg.apache.commons.io.FileUtils.writeStringToFile(file_";
  protected final String TEXT_15 = ", content_";
  protected final String TEXT_16 = ".toString(), ";
  protected final String TEXT_17 = ");" + NL + "\t\t\t\t\t\t} else if(content_";
  protected final String TEXT_18 = " instanceof byte[]) {" + NL + "\t\t\t\t\t\t\torg.apache.commons.io.FileUtils.writeByteArrayToFile(file_";
  protected final String TEXT_19 = ", (byte[])content_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\t\t\t} else if(content_";
  protected final String TEXT_21 = " instanceof java.io.FileInputStream) {" + NL + "\t\t\t\t\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_22 = " = (java.io.FileInputStream)content_";
  protected final String TEXT_23 = ";" + NL + "\t\t\t\t\t\t\tjava.io.FileOutputStream fos_";
  protected final String TEXT_24 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_25 = ");" + NL + "\t\t\t\t\t\t\tint c_";
  protected final String TEXT_26 = ";" + NL + "\t\t\t\t\t\t\twhile((c_";
  protected final String TEXT_27 = " = fis_";
  protected final String TEXT_28 = ".read())!=-1) {" + NL + "\t\t\t\t\t\t\t\tfos_";
  protected final String TEXT_29 = ".write(c_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tfis_";
  protected final String TEXT_31 = ".close();" + NL + "\t\t\t\t\t\t\tfos_";
  protected final String TEXT_32 = ".close();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch (java.lang.Exception e_";
  protected final String TEXT_33 = ") {";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\tthrow e_";
  protected final String TEXT_35 = ";";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\t\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
		
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	
	java.util.List<IMetadataColumn> columnList = null;
	java.util.List<IMetadataTable> metadatas = node.getMetadataList();
	if(metadatas != null && metadatas.size() > 0) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null) {
		    columnList = metadata.getListColumns();
		}
	}
	java.util.List< ? extends IConnection> incomingConns = node.getIncomingConnections();
	if(columnList!=null && incomingConns!=null && incomingConns.size()>0) {
		for(IConnection incomingConn : incomingConns) {
			if(incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(incomingConn.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(columnList.get(0).getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
					if(dieOnError) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
					} else {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
					}

    stringBuffer.append(TEXT_38);
    
			}
		}
	}

    return stringBuffer.toString();
  }
}
