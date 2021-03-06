package org.talend.designer.codegen.translators.business.sap;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSAPOutputFinallyJava
{
  protected static String nl;
  public static synchronized TSAPOutputFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPOutputFinallyJava result = new TSAPOutputFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_5 = "\") == null){" + NL + "\t\t\tif(resourceMap.get(\"conn_";
  protected final String TEXT_6 = "\") != null){" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\tcom.sap.mw.jco.JCO.releaseClient((com.sap.mw.jco.JCO.Client)resourceMap.get(\"conn_";
  protected final String TEXT_8 = "\"));" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\tcom.sap.conn.jco.JCoContext.end((com.sap.conn.jco.JCoDestination)resourceMap.get(\"conn_";
  protected final String TEXT_10 = "\"));" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_12 = NL + NL + "\t";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String version = "sapjco.jar";
	if(useExistingConn){
	    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
	    for(INode targetNode : nodes){
	    	if (targetNode.getUniqueName().equals(connection)) {
		      version = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
		    }
	    }
	}else{
		version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	}

    stringBuffer.append(TEXT_2);
    	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getIncomingConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ( metadatas != null && metadatas.size() > 0 ) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn == null || firstColumnList == null)
	{
		return "";
	}

    stringBuffer.append(TEXT_3);
    if(close){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
