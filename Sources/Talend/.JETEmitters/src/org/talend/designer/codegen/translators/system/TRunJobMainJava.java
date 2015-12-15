package org.talend.designer.codegen.translators.system;

import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IConnectionCategory;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TRunJobMainJava
{
  protected static String nl;
  public static synchronized TRunJobMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobMainJava result = new TRunJobMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "java.util.List<String> paraList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_3 = NL + "\tif(childJob_commandLine_Mapper_";
  protected final String TEXT_4 = ".get(";
  protected final String TEXT_5 = ")==null){" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_7 = " - The child job named \" + ";
  protected final String TEXT_8 = " + \" is not in the job list.\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\tthrow new RuntimeException(\"The child job named \"+";
  protected final String TEXT_10 = "+\" is not in the job list.\");" + NL + "\t}" + NL + "\tparaList_";
  protected final String TEXT_11 = ".addAll(childJob_commandLine_Mapper_";
  protected final String TEXT_12 = ".get(";
  protected final String TEXT_13 = "));" + NL + "\t";
  protected final String TEXT_14 = NL + "\t        paraList_";
  protected final String TEXT_15 = ".add(";
  protected final String TEXT_16 = ");" + NL + "\t      ";
  protected final String TEXT_17 = NL + "\t        paraList_";
  protected final String TEXT_18 = ".add(\"";
  protected final String TEXT_19 = "\");" + NL + "\t      ";
  protected final String TEXT_20 = NL + "\t  String osName_";
  protected final String TEXT_21 = " = System.getProperty(\"os.name\");" + NL + "\t  if (osName_";
  protected final String TEXT_22 = " != null && osName_";
  protected final String TEXT_23 = ".toLowerCase().startsWith(\"win\")){" + NL + "\t      ";
  protected final String TEXT_24 = NL + "\t\t      paraList_";
  protected final String TEXT_25 = ".add(\"";
  protected final String TEXT_26 = "\");" + NL + "\t\t      ";
  protected final String TEXT_27 = NL + "\t\t        \tparaList_";
  protected final String TEXT_28 = ".add(dealChildJobLibrary_";
  protected final String TEXT_29 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_30 = "));" + NL + "\t\t      ";
  protected final String TEXT_31 = NL + "\t\t      \t\tparaList_";
  protected final String TEXT_32 = ".add(";
  protected final String TEXT_33 = ");" + NL + "\t\t      ";
  protected final String TEXT_34 = NL + "\t\t        \tparaList_";
  protected final String TEXT_35 = ".add(dealChildJobLibrary_";
  protected final String TEXT_36 = ".replaceJarPathsFromCrcMap(\"";
  protected final String TEXT_37 = "\"));" + NL + "\t\t      ";
  protected final String TEXT_38 = NL + "\t\t      \t\tparaList_";
  protected final String TEXT_39 = ".add(\"";
  protected final String TEXT_40 = "\");" + NL + "\t\t      ";
  protected final String TEXT_41 = NL + "\t  } else {" + NL + "\t      ";
  protected final String TEXT_42 = NL + "\t\t      paraList_";
  protected final String TEXT_43 = ".add(\"";
  protected final String TEXT_44 = "\");" + NL + "\t\t      ";
  protected final String TEXT_45 = NL + "\t\t        paraList_";
  protected final String TEXT_46 = ".add(dealChildJobLibrary_";
  protected final String TEXT_47 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_48 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t      ";
  protected final String TEXT_49 = NL + "\t\t        paraList_";
  protected final String TEXT_50 = ".add(";
  protected final String TEXT_51 = ".replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t      ";
  protected final String TEXT_52 = NL + "\t\t        paraList_";
  protected final String TEXT_53 = ".add(dealChildJobLibrary_";
  protected final String TEXT_54 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_55 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t      ";
  protected final String TEXT_56 = NL + "\t\t        paraList_";
  protected final String TEXT_57 = ".add(";
  protected final String TEXT_58 = ");" + NL + "\t\t      ";
  protected final String TEXT_59 = NL + "\t  }    " + NL + "\t  ";
  protected final String TEXT_60 = NL + "\t\t\tif(!\"\".equals(log4jLevel)){" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_61 = ".add(\"--log4jLevel=\"+log4jLevel);" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_62 = NL + "//for feature:10589";
  protected final String TEXT_63 = NL + "paraList_";
  protected final String TEXT_64 = ".add(\"--stat_port=\" + null);";
  protected final String TEXT_65 = NL + "paraList_";
  protected final String TEXT_66 = ".add(\"--stat_port=\" + portStats);";
  protected final String TEXT_67 = NL + NL + "if(resuming_logs_dir_path != null){" + NL + "  paraList_";
  protected final String TEXT_68 = ".add(\"--resuming_logs_dir_path=\" + resuming_logs_dir_path);" + NL + "}" + NL + "String childResumePath_";
  protected final String TEXT_69 = " = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);" + NL + "String tRunJobName_";
  protected final String TEXT_70 = " = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);" + NL + "if(\"";
  protected final String TEXT_71 = "\".equals(tRunJobName_";
  protected final String TEXT_72 = ") && childResumePath_";
  protected final String TEXT_73 = " != null){" + NL + "  paraList_";
  protected final String TEXT_74 = ".add(\"--resuming_checkpoint_path=\" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));" + NL + "}" + NL + "paraList_";
  protected final String TEXT_75 = ".add(\"--parent_part_launcher=JOB:\" + jobName + \"/NODE:";
  protected final String TEXT_76 = "\");" + NL + "" + NL + "java.util.Map<String, Object> parentContextMap_";
  protected final String TEXT_77 = " = new java.util.HashMap<String, Object>();" + NL;
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = NL + "  ";
  protected final String TEXT_80 = ".synchronizeContext();" + NL + "  java.util.Enumeration<?> propertyNames_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ".propertyNames();" + NL + "  while (propertyNames_";
  protected final String TEXT_83 = ".hasMoreElements()) {" + NL + "    String key_";
  protected final String TEXT_84 = " = (String) propertyNames_";
  protected final String TEXT_85 = ".nextElement();" + NL + "    Object value_";
  protected final String TEXT_86 = " = (Object) ";
  protected final String TEXT_87 = ".get(key_";
  protected final String TEXT_88 = ");       " + NL + "    paraList_";
  protected final String TEXT_89 = ".add(\"--context_param \" + key_";
  protected final String TEXT_90 = " + \"=\" + value_";
  protected final String TEXT_91 = ");" + NL + "  }" + NL + "  ";
  protected final String TEXT_92 = "  " + NL + "\t\t    parentContextMap_";
  protected final String TEXT_93 = ".put(\"";
  protected final String TEXT_94 = "\", ";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + NL + "Object obj_";
  protected final String TEXT_98 = " = null;" + NL;
  protected final String TEXT_99 = NL + "  obj_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ";" + NL + "  paraList_";
  protected final String TEXT_102 = ".add(\"--context_param ";
  protected final String TEXT_103 = "=\" + RuntimeUtils.tRunJobConvertContext(obj_";
  protected final String TEXT_104 = "));" + NL + "  parentContextMap_";
  protected final String TEXT_105 = ".put(\"";
  protected final String TEXT_106 = "\", obj_";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "  System.out.println(\"";
  protected final String TEXT_109 = " in ";
  protected final String TEXT_110 = " call ";
  protected final String TEXT_111 = "\"+";
  protected final String TEXT_112 = "+\"";
  protected final String TEXT_113 = " with:\\n\\n\" + paraList_";
  protected final String TEXT_114 = " + \"\\n\");";
  protected final String TEXT_115 = NL + "  ";
  protected final String TEXT_116 = " childJob_";
  protected final String TEXT_117 = " = new ";
  protected final String TEXT_118 = "();" + NL + "    // pass DataSources" + NL + "    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_";
  protected final String TEXT_119 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap" + NL + "            .get(KEY_DB_DATASOURCES);" + NL + "    if (null != talendDataSources_";
  protected final String TEXT_120 = ") {" + NL + "        java.util.Map<String, javax.sql.DataSource> dataSources_";
  protected final String TEXT_121 = " = new java.util.HashMap<String, javax.sql.DataSource>();" + NL + "        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_";
  protected final String TEXT_122 = " : talendDataSources_";
  protected final String TEXT_123 = NL + "                .entrySet()) {" + NL + "            dataSources_";
  protected final String TEXT_124 = ".put(talendDataSourceEntry_";
  protected final String TEXT_125 = ".getKey()," + NL + "                    talendDataSourceEntry_";
  protected final String TEXT_126 = ".getValue().getRawDataSource());" + NL + "        }" + NL + "        childJob_";
  protected final String TEXT_127 = ".setDataSources(dataSources_";
  protected final String TEXT_128 = ");" + NL + "    }";
  protected final String TEXT_129 = "  " + NL + "  childJob_";
  protected final String TEXT_130 = ".parentContextMap = parentContextMap_";
  protected final String TEXT_131 = ";";
  protected final String TEXT_132 = "  " + NL + "\t";
  protected final String TEXT_133 = NL + "\t\tlog.info(\"";
  protected final String TEXT_134 = " - The child job '";
  protected final String TEXT_135 = "\"+";
  protected final String TEXT_136 = "+\"";
  protected final String TEXT_137 = "' starts on the version '";
  protected final String TEXT_138 = "' with the context '";
  protected final String TEXT_139 = "'.\");" + NL + "\t";
  protected final String TEXT_140 = NL + "  String[][] childReturn_";
  protected final String TEXT_141 = " = childJob_";
  protected final String TEXT_142 = ".runJob((String[]) paraList_";
  protected final String TEXT_143 = ".toArray(new String[paraList_";
  protected final String TEXT_144 = ".size()]));" + NL + "\t";
  protected final String TEXT_145 = NL + "\t\tlog.info(\"";
  protected final String TEXT_146 = " - The child job '";
  protected final String TEXT_147 = "\"+";
  protected final String TEXT_148 = "+\"";
  protected final String TEXT_149 = "' is done.\");" + NL + "\t";
  protected final String TEXT_150 = NL + "      ((java.util.Map)threadLocal.get()).put(\"errorCode\", childJob_";
  protected final String TEXT_151 = ".getErrorCode());";
  protected final String TEXT_152 = NL + "      errorCode = childJob_";
  protected final String TEXT_153 = ".getErrorCode();";
  protected final String TEXT_154 = NL + "            " + NL + "    if(childJob_";
  protected final String TEXT_155 = ".getErrorCode() == null){" + NL + "      globalMap.put(\"";
  protected final String TEXT_156 = "_CHILD_RETURN_CODE\", childJob_";
  protected final String TEXT_157 = ".getStatus() != null && (\"failure\").equals(childJob_";
  protected final String TEXT_158 = ".getStatus()) ? 1 : 0);" + NL + "    }else{" + NL + "      globalMap.put(\"";
  protected final String TEXT_159 = "_CHILD_RETURN_CODE\", childJob_";
  protected final String TEXT_160 = ".getErrorCode());" + NL + "    }" + NL + "    if (childJob_";
  protected final String TEXT_161 = ".getExceptionStackTrace() != null) { " + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_162 = "_CHILD_EXCEPTION_STACKTRACE\", childJob_";
  protected final String TEXT_163 = ".getExceptionStackTrace());" + NL + "    }" + NL + "  ";
  protected final String TEXT_164 = " " + NL + "      if (childJob_";
  protected final String TEXT_165 = ".getErrorCode() != null || (\"failure\").equals(childJob_";
  protected final String TEXT_166 = ".getStatus())) {" + NL + "\t\t";
  protected final String TEXT_167 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_168 = " - The child job '";
  protected final String TEXT_169 = "\"+";
  protected final String TEXT_170 = "+\"";
  protected final String TEXT_171 = "' has failed.\");" + NL + "\t\t";
  protected final String TEXT_172 = NL + "        throw new RuntimeException(\"Child job running failed\");" + NL + "      }";
  protected final String TEXT_173 = NL + "      for (String[] item_";
  protected final String TEXT_174 = " : childReturn_";
  protected final String TEXT_175 = ") { ";
  protected final String TEXT_176 = "\t\t" + NL + "        if(";
  protected final String TEXT_177 = " < item_";
  protected final String TEXT_178 = ".length){\t\t\t\t";
  protected final String TEXT_179 = NL + "             ";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = item_";
  protected final String TEXT_182 = "[";
  protected final String TEXT_183 = "];";
  protected final String TEXT_184 = NL + "             ";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = ParserUtils.parseTo_Date(item_";
  protected final String TEXT_187 = "[";
  protected final String TEXT_188 = "], ";
  protected final String TEXT_189 = ");";
  protected final String TEXT_190 = "\t\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "             ";
  protected final String TEXT_192 = ".";
  protected final String TEXT_193 = " = item_";
  protected final String TEXT_194 = "[";
  protected final String TEXT_195 = "].getBytes();";
  protected final String TEXT_196 = NL + "           \t ";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " = ParserUtils.parseTo_";
  protected final String TEXT_199 = "(item_";
  protected final String TEXT_200 = "[";
  protected final String TEXT_201 = "], \",\");";
  protected final String TEXT_202 = NL + "             ";
  protected final String TEXT_203 = ".";
  protected final String TEXT_204 = " = ParserUtils.parseTo_";
  protected final String TEXT_205 = "(item_";
  protected final String TEXT_206 = "[";
  protected final String TEXT_207 = "]);";
  protected final String TEXT_208 = NL + "        }else{" + NL + "  \t      ";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ";" + NL + "        }";
  protected final String TEXT_212 = NL + "      {";
  protected final String TEXT_213 = NL + "  Runtime runtime_";
  protected final String TEXT_214 = " = Runtime.getRuntime();" + NL + "  final Process ps_";
  protected final String TEXT_215 = ";" + NL + "  ps_";
  protected final String TEXT_216 = " = runtime_";
  protected final String TEXT_217 = ".exec((String[])paraList_";
  protected final String TEXT_218 = ".toArray(new String[paraList_";
  protected final String TEXT_219 = ".size()]));" + NL + "" + NL + "  Thread normal_";
  protected final String TEXT_220 = " = new Thread() {" + NL + "    public void run() {" + NL + "      try {" + NL + "        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_221 = ".getInputStream()));" + NL + "        String line = \"\";" + NL + "        try {" + NL + "          while((line = reader.readLine()) != null) {" + NL + "            System.out.println(line);" + NL + "          }" + NL + "        } finally {" + NL + "          reader.close();" + NL + "        }" + NL + "      } catch(java.io.IOException ioe) {" + NL + "\t\t";
  protected final String TEXT_222 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_223 = " - \" + ioe.getMessage());" + NL + "\t\t";
  protected final String TEXT_224 = NL + "        ioe.printStackTrace();" + NL + "      }" + NL + "    }" + NL + "  };";
  protected final String TEXT_225 = NL + "\tlog.info(\"";
  protected final String TEXT_226 = " - The child job '";
  protected final String TEXT_227 = "\"+";
  protected final String TEXT_228 = "+\"";
  protected final String TEXT_229 = "' starts on the version '";
  protected final String TEXT_230 = "' with the context '";
  protected final String TEXT_231 = "'.\");";
  protected final String TEXT_232 = NL + "  normal_";
  protected final String TEXT_233 = ".start();";
  protected final String TEXT_234 = NL + "\tlog.info(\"";
  protected final String TEXT_235 = " - The child job '";
  protected final String TEXT_236 = "\"+";
  protected final String TEXT_237 = "+\"";
  protected final String TEXT_238 = "' is done.\");";
  protected final String TEXT_239 = NL + NL + "  final StringBuffer errorMsg_";
  protected final String TEXT_240 = " = new StringBuffer();" + NL + "  Thread error_";
  protected final String TEXT_241 = " = new Thread() {" + NL + "    public void run() {" + NL + "      try {" + NL + "        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_242 = ".getErrorStream()));" + NL + "        String line = \"\";" + NL + "        try {" + NL + "          while((line = reader.readLine()) != null) {" + NL + "            errorMsg_";
  protected final String TEXT_243 = ".append(line).append(\"\\n\");" + NL + "          }" + NL + "        } finally {" + NL + "          reader.close();" + NL + "        }" + NL + "      } catch(java.io.IOException ioe) {" + NL + "\t\t";
  protected final String TEXT_244 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_245 = " - \" + ioe.getMessage());" + NL + "\t\t";
  protected final String TEXT_246 = NL + "        ioe.printStackTrace();" + NL + "      }" + NL + "    }" + NL + "  };" + NL + "  error_";
  protected final String TEXT_247 = ".start();" + NL + "" + NL + "  //0 indicates normal termination\t" + NL + "  int result_";
  protected final String TEXT_248 = " = ps_";
  protected final String TEXT_249 = ".waitFor();" + NL + "  normal_";
  protected final String TEXT_250 = ".join(10000);" + NL + "  error_";
  protected final String TEXT_251 = ".join(10000);" + NL + "  " + NL + "  globalMap.put(\"";
  protected final String TEXT_252 = "_CHILD_RETURN_CODE\",result_";
  protected final String TEXT_253 = ");" + NL + "  if(result_";
  protected final String TEXT_254 = " != 0){" + NL + "   \t\tglobalMap.put(\"";
  protected final String TEXT_255 = "_CHILD_EXCEPTION_STACKTRACE\",errorMsg_";
  protected final String TEXT_256 = ".toString());" + NL + "\t";
  protected final String TEXT_257 = "  " + NL + "\t\t";
  protected final String TEXT_258 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_259 = " - Child job returns \" + result_";
  protected final String TEXT_260 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_261 = ".toString());" + NL + "\t\t";
  protected final String TEXT_262 = NL + "\t    throw new RuntimeException(\"Child job returns \" + result_";
  protected final String TEXT_263 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_264 = ".toString());" + NL + "\t";
  protected final String TEXT_265 = NL + "\t\t";
  protected final String TEXT_266 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_267 = " - Child job returns \" + result_";
  protected final String TEXT_268 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_269 = ".toString());" + NL + "\t\t";
  protected final String TEXT_270 = NL + "\t\tSystem.err.println(\"Child job returns \" + result_";
  protected final String TEXT_271 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_272 = ".toString());" + NL + "\t";
  protected final String TEXT_273 = NL + "  }" + NL + " " + NL + NL;
  protected final String TEXT_274 = NL + "      {" + NL + "\t\t";
  protected final String TEXT_275 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_276 = " - Child job returns \" + result_";
  protected final String TEXT_277 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_278 = ".toString());" + NL + "\t\t";
  protected final String TEXT_279 = NL + "      \tSystem.err.println(\"when tRunJob runs in an independent process, it can't extract datas from tBufferOutput of child job.\"); ";
  protected final String TEXT_280 = NL + "      {";
  protected final String TEXT_281 = NL + "  ";
  protected final String TEXT_282 = NL + "\tlog.info(\"";
  protected final String TEXT_283 = " - Done.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
        columns = metadata.getListColumns();
    }
}
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
  
//if tRunJob is the first node, it can get the return values of the child job.
//if tRunJob is middle node of the FLOW link, it will be data_auto_propagate=true 
List< ? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
boolean useIndependentProcess = "true".equals(ElementParameterParser.getValue(node, "__USE_INDEPENDENT_PROCESS__"));
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_CHILD_ERROR__"));  
boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();  
boolean transmitWholeContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_WHOLE_CONTEXT__"));  
boolean printParameter = ("true").equals(ElementParameterParser.getValue(node, "__PRINT_PARAMETER__")); 

boolean originalContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_ORIGINAL_CONTEXT__")); 

IProcess currentProcess = node.getProcess();
List<Map<String, String>> contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
String version = ElementParameterParser.getValue(node,"__PROCESS_TYPE_VERSION__");
String[] codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\""};
String[] commandLineWindows = new String[] {"<command>"};
String[] commandLineUnix = new String[] {"<command>"};
String[] commandLine = new String[] {"<command>"};
String childJob = ElementParameterParser.getValue(node,"__PROCESS__");

boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));
String dynamicJobName = ElementParameterParser.getValue(node,"__CONTEXT_JOB__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
if(useDynamicJob){
	useIndependentProcess = true;
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_13);
    
}else{
	try {
	  if(useIndependentProcess){
	    commandLineWindows = ProcessorUtilities.getCommandLine("win32",true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
	    // remove the 2 fist lines
	    if (commandLineWindows.length > 0 && ProcessorUtilities.isExportConfig()){
	      int tmpSize = commandLineWindows.length - 2;
	      String[] tmp = new String[tmpSize];
	      System.arraycopy(commandLineWindows, 2, tmp, 0, tmpSize);
	      commandLineWindows = tmp;
	    }
	    commandLineUnix = ProcessorUtilities.getCommandLine("linux",true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
	    // remove the 2 first lines
	    if (commandLineUnix.length > 0 && ProcessorUtilities.isExportConfig()){
	      int tmpSize = commandLineUnix.length - 2;
	      String[] tmp = new String[tmpSize];
	      System.arraycopy(commandLineUnix, 2, tmp, 0, tmpSize);
	      commandLineUnix = tmp;
	    }
	  }else{
	    commandLine = ProcessorUtilities.getMainCommand(process,version, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);  
	  }
	} catch (ProcessorException e) {
	}


	if (!useIndependentProcess) {
	  for (int i = 0; i < commandLine.length; i++) {
		if (i == 0){
	      childJob = commandLine[0];
	    } else if (i > 0){
	      if (commandLine[i].indexOf("\"") >= 0){
	      
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_16);
    }else{
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_19);
    }
	    }
	  }
	} else {
	  
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
		  for (int i = 0; i < commandLineWindows.length; i++) {
		    if (i == 0){
		      
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(commandLineWindows[i]);
    stringBuffer.append(TEXT_26);
    
		    } else if (i > 0){
		      if (commandLineWindows[i].indexOf("\"") >= 0){
		          if(commandLineWindows[i].indexOf(".jar")>=0){
		      
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_30);
    
		          }else{
		      
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_33);
    
		          }
		      }else{
		          if(commandLineWindows[i].indexOf(".jar")>=0){
              
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_37);
    
		          }else{
              
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_40);
    
		          }
		      }
		    }
		  }
		  
    stringBuffer.append(TEXT_41);
    
		  for (int i = 0; i < commandLineUnix.length; i++) {
		    if (i == 0){
		      
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(commandLineUnix[i]);
    stringBuffer.append(TEXT_44);
    
		    } else if (i > 0){
		      String param;
		      if (commandLineUnix[i].indexOf("\"") >= 0){
		        param = commandLineUnix[i];
		      } else {
		      	param = "\""+commandLineUnix[i]+"\"";
		      }
		      if (param.contains("$ROOT_PATH")) {
		      	if(param.indexOf(".jar") >= 0){
		      
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_48);
    }else{
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_51);
    
		      	}
		      }else{
		     	if(param.indexOf(".jar") >= 0){
		      
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_55);
    }else{
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_58);
    }
		      }
		    }
		  }
		  
    stringBuffer.append(TEXT_59);
    
	}
		if(isLog4jEnabled){//For TDI-27659
		
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    }
}

    stringBuffer.append(TEXT_62);
    if(useIndependentProcess){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    }else{
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
List<? extends IConnection> iterateConns = node.getIncomingConnections(EConnectionType.ITERATE);
if(iterateConns != null)  { 
	iterateConnSet.addAll(iterateConns);
}
boolean parallelIterate = false;
for (IConnection iterateConn : iterateConnSet) {
	parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
}
if(transmitWholeContext){//111111

     
	//bug21906
	String localContext = "context";
	if(parallelIterate) {
		localContext = "localContext";
	}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
 List<IContextParameter> params = currentProcess.getContextManager().getDefaultContext().getContextParameterList();
    for (IContextParameter ctxParam :params){
    	String ctxParamName = ctxParam.getName();
 
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_96);
    }

}//111111

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
for (int i=0; i<contextParams.size(); i++) {
  Map<String, String> contextParam = contextParams.get(i);
  String name = contextParam.get("PARAM_NAME_COLUMN");
  String value = contextParam.get("PARAM_VALUE_COLUMN");
  //bug22181
  if(parallelIterate && value!=null && value.contains("context.")) {
  	value = value.replace("context.","localContext.");
  }

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    }
    if(printParameter){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_110);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_111);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
if (!useIndependentProcess){//AAAAAAAAAAAA

    stringBuffer.append(TEXT_115);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    if(originalContext){
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_147);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    }
    
  if (childJob != null) {
    if (isRunInMultiThread ){
    
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    }else {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    if (dieOnError) { 
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_169);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    }
    stringBuffer.append(TEXT_172);
    }
  }
    
  String firstConnName = null; 
  if(outConns != null && outConns.size() > 0) {
    for (IConnection conn : outConns) {
      if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
      	firstConnName = conn.getName(); //get the first available flow link
      	break;
      }
    }
  }
  if(firstConnName != null) {//b
    if(inConns == null || inConns.size() == 0){//c
    
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    
      int columnSize = columns.size();
      for (int i = 0; i < columnSize; i++) {//a
        IMetadataColumn column = columns.get(i);
        String label = column.getLabel();
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        
    stringBuffer.append(TEXT_176);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    stringBuffer.append(TEXT_179);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_183);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_189);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_195);
    }else if(javaType == JavaTypesManager.LIST) {
    stringBuffer.append(TEXT_196);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_201);
    } else {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_204);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_211);
    
      }//a
    }else{//c
    //in order to match the "}" about IS_MULTIPLYING_OUTPUTS="true"
    
    stringBuffer.append(TEXT_212);
    
    }
    
  }//b  
  
} else { //AAAAAAAAAAAA

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  // use independent process to run subjob

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_227);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_236);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_237);
    }
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    }
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    if (dieOnError) { 
    stringBuffer.append(TEXT_257);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    }
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    }else{
    stringBuffer.append(TEXT_265);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    }
    stringBuffer.append(TEXT_273);
    
  String firstConnName = null; 
  if(outConns != null && outConns.size() > 0) {
    for (IConnection conn : outConns) {
      if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
      	firstConnName = conn.getName(); //get the first available flow link
      	break;
      }
    }
  }
  if(firstConnName != null) {//b
    if(inConns == null || inConns.size() == 0){//c
    
    stringBuffer.append(TEXT_274);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    }
    stringBuffer.append(TEXT_279);
    }else{//c
    //in order to match the "}" about IS_MULTIPLYING_OUTPUTS="true"
    
    stringBuffer.append(TEXT_280);
    
    }//c
  }//b  

    stringBuffer.append(TEXT_281);
    
}//AAAAAAAAAAAA

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    }
    return stringBuffer.toString();
  }
}
