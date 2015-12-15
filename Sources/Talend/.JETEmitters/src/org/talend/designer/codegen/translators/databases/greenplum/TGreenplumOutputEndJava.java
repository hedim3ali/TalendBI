package org.talend.designer.codegen.translators.databases.greenplum;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TGreenplumOutputEndJava
{
  protected static String nl;
  public static synchronized TGreenplumOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGreenplumOutputEndJava result = new TGreenplumOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_3 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_4 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_5 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_6 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_7 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_8 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_9 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_10 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_11 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_12 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_13 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_14 = NL + "        if(pstmt_";
  protected final String TEXT_15 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_16 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Starting to commit \" + commitCounter_";
  protected final String TEXT_21 = " + \" records.\");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tconn_";
  protected final String TEXT_23 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_25 = " - Commit has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = "\t" + NL + "\t \t";
  protected final String TEXT_27 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_29 = NL + "    \tconn_";
  protected final String TEXT_30 = " .close();" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_33 = NL + "    \t";
  protected final String TEXT_34 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_35 = "=nb_line_deleted_";
  protected final String TEXT_36 = "+ deletedCount_";
  protected final String TEXT_37 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_38 = "=nb_line_update_";
  protected final String TEXT_39 = " + updatedCount_";
  protected final String TEXT_40 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_41 = "=nb_line_inserted_";
  protected final String TEXT_42 = " + insertedCount_";
  protected final String TEXT_43 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_44 = "=nb_line_rejected_";
  protected final String TEXT_45 = " + rejectedCount_";
  protected final String TEXT_46 = ";" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_47 = "_NB_LINE\",nb_line_";
  protected final String TEXT_48 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_49 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_50 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_51 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_52 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_53 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_54 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_55 = "_NB_LINE_REJECTED\",nb_line_deleted_";
  protected final String TEXT_56 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_57 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_58 = " - Has inserted \"+nb_line_inserted_";
  protected final String TEXT_59 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_60 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_61 = " - Has updated \"+nb_line_update_";
  protected final String TEXT_62 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_63 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_64 = " - Has deleted \"+nb_line_deleted_";
  protected final String TEXT_65 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_66 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_67 = " - Has updated \"+nb_line_update_";
  protected final String TEXT_68 = " + \" records.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_69 = " - Has inserted \"+nb_line_inserted_";
  protected final String TEXT_70 = " + \" records.\");";
  protected final String TEXT_71 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_72 = " - Has inserted \"+nb_line_inserted_";
  protected final String TEXT_73 = " + \" records.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_74 = " - Has updated \"+nb_line_update_";
  protected final String TEXT_75 = " + \" records.\");" + NL + "    ";
  protected final String TEXT_76 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_77 = " - Has rejected \"+nb_line_rejected_";
  protected final String TEXT_78 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_79 = NL + "\t\tlog.info(\"";
  protected final String TEXT_80 = " - Done.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }

    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
    } else {
        
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
    }   
    
    stringBuffer.append(TEXT_17);
    
	if(!("true").equals(useExistingConn))
	{
		if(!("").equals(commitEvery) && !("0").equals(commitEvery))
		{
			
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    
		}
		
    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    
	}
    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
	if(isLog4jEnabled){
		if(("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) {
    		if (("INSERT").equals(dataAction)) {
	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
    		}else if (("UPDATE").equals(dataAction)) {
	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
    		}else if (("DELETE").equals(dataAction)) {
	
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
    		}
    	}else if("UPDATE_OR_INSERT".equals(dataAction)){
	
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
    	}else if("INSERT_OR_UPDATE".equals(dataAction)){
    
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
    	}
    	if(rejectConnName != null) {
	
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
		}
	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
	}
	
    return stringBuffer.toString();
  }
}
