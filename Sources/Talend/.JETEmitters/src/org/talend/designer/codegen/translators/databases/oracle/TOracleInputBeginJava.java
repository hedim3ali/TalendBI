package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Map;
import java.util.List;

public class TOracleInputBeginJava
{
  protected static String nl;
  public static synchronized TOracleInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleInputBeginJava result = new TOracleInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");";
  protected final String TEXT_4 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_5 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_6 = ") {";
  protected final String TEXT_7 = NL + "                conn_";
  protected final String TEXT_8 = " = dataSources_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ").getConnection();" + NL + "            } else {";
  protected final String TEXT_11 = NL + "\t\t\t    java.lang.Class.forName(\"";
  protected final String TEXT_12 = "\");" + NL + "\t\t\t   \tString dbUser_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Start to work\");";
  protected final String TEXT_20 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_21 = " = new StringBuffer();";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_23 = " - Driver ClassName: ";
  protected final String TEXT_24 = ".\");";
  protected final String TEXT_25 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_28 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_32 = " = log4jDebugParamters_";
  protected final String TEXT_33 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_34 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_39 = " = log4jDebugParamters_";
  protected final String TEXT_40 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_41 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_46 = " = log4jDebugParamters_";
  protected final String TEXT_47 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_48 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_53 = " = log4jDebugParamters_";
  protected final String TEXT_54 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_55 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_60 = " = log4jDebugParamters_";
  protected final String TEXT_61 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_62 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_65 = " = log4jDebugParamters_";
  protected final String TEXT_66 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_67 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_70 = " = log4jDebugParamters_";
  protected final String TEXT_71 = " + \"DBVERSION = ";
  protected final String TEXT_72 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_75 = " = ";
  protected final String TEXT_76 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_77 = " = log4jDebugParamters_";
  protected final String TEXT_78 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_79 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t";
  protected final String TEXT_81 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_82 = " = log4jDebugParamters_";
  protected final String TEXT_83 = " + \"USE_CURSOR = ";
  protected final String TEXT_84 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_87 = " = log4jDebugParamters_";
  protected final String TEXT_88 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_89 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_92 = " = log4jDebugParamters_";
  protected final String TEXT_93 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_94 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_99 = " = log4jDebugParamters_";
  protected final String TEXT_100 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_101 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_106 = " = log4jDebugParamters_";
  protected final String TEXT_107 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_108 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_110 = " = \"";
  protected final String TEXT_111 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_112 = ";";
  protected final String TEXT_113 = NL + "\t\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_116 = " - Connection attempt to '\" + url_";
  protected final String TEXT_117 = " + \"' with the username '\"+ dbUser_";
  protected final String TEXT_118 = " +\"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\tconn_";
  protected final String TEXT_120 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_121 = ",dbUser_";
  protected final String TEXT_122 = ",dbPwd_";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\t\t\t\tconn_";
  protected final String TEXT_125 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_129 = " - Connection to '\" + url_";
  protected final String TEXT_130 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t        ";
  protected final String TEXT_132 = NL + "\t\t    }";
  protected final String TEXT_133 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_134 = " = conn_";
  protected final String TEXT_135 = ".createStatement();";
  protected final String TEXT_136 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_137 = " = conn_";
  protected final String TEXT_138 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_140 = " = rs_";
  protected final String TEXT_141 = ".getString(column_index_";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "                        if(tmpContent_";
  protected final String TEXT_144 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_145 = " = tmpContent_";
  protected final String TEXT_146 = ";" + NL + "                        }";
  protected final String TEXT_147 = NL + "                    if(tmpContent_";
  protected final String TEXT_148 = " != null && tmpContent_";
  protected final String TEXT_149 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_150 = NL + "                        ";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " = tmpContent_";
  protected final String TEXT_153 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_154 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_155 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_156 = NL + "                                ";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_159 = NL + "                                ";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_162 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_163 = ")) {\t\t\t  \t\t";
  protected final String TEXT_164 = NL + "                                ";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_168 = " - Value is empty for column : '";
  protected final String TEXT_169 = "' in '";
  protected final String TEXT_170 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_172 = "' in '";
  protected final String TEXT_173 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_174 = NL + "                    }";
  protected final String TEXT_175 = NL + "\t\t\tif(rs_";
  protected final String TEXT_176 = ".getTimestamp(column_index_";
  protected final String TEXT_177 = ") != null) {" + NL + "\t\t\t    ";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = " = new java.util.Date(rs_";
  protected final String TEXT_180 = ".getTimestamp(column_index_";
  protected final String TEXT_181 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = " =  null;" + NL + "\t\t\t}\t\t\t ";
  protected final String TEXT_184 = NL + "            tmpContent_";
  protected final String TEXT_185 = " = rs_";
  protected final String TEXT_186 = ".getString(column_index_";
  protected final String TEXT_187 = ");" + NL + "            if(tmpContent_";
  protected final String TEXT_188 = " != null) {";
  protected final String TEXT_189 = NL + "                ";
  protected final String TEXT_190 = ".";
  protected final String TEXT_191 = " = tmpContent_";
  protected final String TEXT_192 = ";" + NL + "            } else {";
  protected final String TEXT_193 = NL + "                ";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = " = null;" + NL + "            }";
  protected final String TEXT_196 = NL + "            if(rs_";
  protected final String TEXT_197 = ".getObject(column_index_";
  protected final String TEXT_198 = ") != null) {";
  protected final String TEXT_199 = NL + "                ";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = rs_";
  protected final String TEXT_202 = ".get";
  protected final String TEXT_203 = "(column_index_";
  protected final String TEXT_204 = ");" + NL + "            } else {";
  protected final String TEXT_205 = NL + "                    ";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " = null;";
  protected final String TEXT_208 = NL + "\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_210 = " - Null value in non-Nullable column\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_211 = "    " + NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_212 = NL + "            }";
  protected final String TEXT_213 = NL + "\t\t\tString url_";
  protected final String TEXT_214 = " = null;";
  protected final String TEXT_215 = NL + "\t\t\t\turl_";
  protected final String TEXT_216 = " = ";
  protected final String TEXT_217 = ";";
  protected final String TEXT_218 = NL + "\t\t\t\turl_";
  protected final String TEXT_219 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_220 = " + \":\" + ";
  protected final String TEXT_221 = " + \":\" + ";
  protected final String TEXT_222 = ";";
  protected final String TEXT_223 = NL + "\t\t\t\turl_";
  protected final String TEXT_224 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_225 = " + \")(port=\" + ";
  protected final String TEXT_226 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_227 = " + \")))\";";
  protected final String TEXT_228 = NL + "\t\t\t\turl_";
  protected final String TEXT_229 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_230 = ";";
  protected final String TEXT_231 = NL + "\t    \t\t\turl_";
  protected final String TEXT_232 = " = ";
  protected final String TEXT_233 = ";";
  protected final String TEXT_234 = NL;
  protected final String TEXT_235 = NL + "\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_236 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\tif (null != dataSources_";
  protected final String TEXT_237 = ") {" + NL + "\t\t\t\t\tconn_";
  protected final String TEXT_238 = " = dataSources_";
  protected final String TEXT_239 = ".get(";
  protected final String TEXT_240 = ").getConnection();" + NL + "\t\t\t\t} else {";
  protected final String TEXT_241 = NL + "\t\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_242 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\tString dbUser_";
  protected final String TEXT_244 = " = ";
  protected final String TEXT_245 = ";" + NL + "\t\t\t\tString dbPwd_";
  protected final String TEXT_246 = " = ";
  protected final String TEXT_247 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_248 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_249 = " - Start to work\");";
  protected final String TEXT_250 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_251 = " = new StringBuffer();";
  protected final String TEXT_252 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_253 = " - Driver ClassName: ";
  protected final String TEXT_254 = ".\");";
  protected final String TEXT_255 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_256 = ");";
  protected final String TEXT_257 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_258 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_260 = " = ";
  protected final String TEXT_261 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_262 = " = log4jDebugParamters_";
  protected final String TEXT_263 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_264 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\t";
  protected final String TEXT_266 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_267 = " = ";
  protected final String TEXT_268 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_269 = " = log4jDebugParamters_";
  protected final String TEXT_270 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_271 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_272 = NL + "\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_274 = " = ";
  protected final String TEXT_275 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_276 = " = log4jDebugParamters_";
  protected final String TEXT_277 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_278 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_279 = NL + "\t\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_281 = " = ";
  protected final String TEXT_282 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_283 = " = log4jDebugParamters_";
  protected final String TEXT_284 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_285 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\t";
  protected final String TEXT_287 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_288 = " = ";
  protected final String TEXT_289 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_290 = " = log4jDebugParamters_";
  protected final String TEXT_291 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_292 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_293 = NL + "\t\t\t\t";
  protected final String TEXT_294 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_295 = " = log4jDebugParamters_";
  protected final String TEXT_296 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_297 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_298 = NL + "\t\t\t\t";
  protected final String TEXT_299 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_300 = " = log4jDebugParamters_";
  protected final String TEXT_301 = " + \"DBVERSION = ";
  protected final String TEXT_302 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\t\t";
  protected final String TEXT_304 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_305 = " = ";
  protected final String TEXT_306 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_307 = " = log4jDebugParamters_";
  protected final String TEXT_308 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_309 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_310 = NL + "\t\t\t\t";
  protected final String TEXT_311 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_312 = " = log4jDebugParamters_";
  protected final String TEXT_313 = " + \"USE_CURSOR = ";
  protected final String TEXT_314 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_315 = NL + "\t\t\t\t";
  protected final String TEXT_316 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_317 = " = log4jDebugParamters_";
  protected final String TEXT_318 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_319 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_320 = NL + "\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_322 = " = log4jDebugParamters_";
  protected final String TEXT_323 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_324 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_325 = NL + "\t\t\t\t";
  protected final String TEXT_326 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_327 = " = ";
  protected final String TEXT_328 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_329 = " = log4jDebugParamters_";
  protected final String TEXT_330 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_331 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_332 = NL + "\t\t\t\t";
  protected final String TEXT_333 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_334 = " = ";
  protected final String TEXT_335 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_336 = " = log4jDebugParamters_";
  protected final String TEXT_337 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_338 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_339 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_340 = " = \"";
  protected final String TEXT_341 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_342 = ";";
  protected final String TEXT_343 = NL + "\t\t\t\t";
  protected final String TEXT_344 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_345 = " - Connection attempt to '\" + url_";
  protected final String TEXT_346 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_347 = " + \"'.\");";
  protected final String TEXT_348 = NL + "\t\t\t\t\tconn_";
  protected final String TEXT_349 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_350 = ");";
  protected final String TEXT_351 = NL + "\t\t\t\t\tconn_";
  protected final String TEXT_352 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_353 = ",dbUser_";
  protected final String TEXT_354 = ",dbPwd_";
  protected final String TEXT_355 = ");";
  protected final String TEXT_356 = NL + "\t\t\t\t\tString atnParams_";
  protected final String TEXT_357 = " = ";
  protected final String TEXT_358 = ";" + NL + "\t\t\t\t\tatnParams_";
  protected final String TEXT_359 = " = atnParams_";
  protected final String TEXT_360 = ".replaceAll(\"&\", \"\\n\");" + NL + "\t\t\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_361 = " = new java.util.Properties();" + NL + "\t\t\t\t\tatnParamsPrope_";
  protected final String TEXT_362 = ".put(\"user\",dbUser_";
  protected final String TEXT_363 = ");" + NL + "\t\t\t\t\tatnParamsPrope_";
  protected final String TEXT_364 = ".put(\"password\",dbPwd_";
  protected final String TEXT_365 = ");" + NL + "\t\t\t\t\tatnParamsPrope_";
  protected final String TEXT_366 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_367 = ".getBytes()));" + NL + "\t\t\t\t\tconn_";
  protected final String TEXT_368 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_369 = ", atnParamsPrope_";
  protected final String TEXT_370 = ");";
  protected final String TEXT_371 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_372 = " - Connection to '\" + url_";
  protected final String TEXT_373 = " + \"' has succeeded.\");";
  protected final String TEXT_374 = NL + "\t\t\t\t}";
  protected final String TEXT_375 = NL + "\t\t\t\tjava.sql.Statement stmtGetTZ_";
  protected final String TEXT_376 = " = conn_";
  protected final String TEXT_377 = ".createStatement();" + NL + "\t\t\t\tjava.sql.ResultSet rsGetTZ_";
  protected final String TEXT_378 = " = stmtGetTZ_";
  protected final String TEXT_379 = ".executeQuery(\"select sessiontimezone from dual\");" + NL + "\t\t\t\tString sessionTimezone_";
  protected final String TEXT_380 = " = java.util.TimeZone.getDefault().getID();" + NL + "\t\t\t\twhile (rsGetTZ_";
  protected final String TEXT_381 = ".next()) {" + NL + "\t\t\t\t\tsessionTimezone_";
  protected final String TEXT_382 = " = rsGetTZ_";
  protected final String TEXT_383 = ".getString(1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_384 = ").setSessionTimeZone(sessionTimezone_";
  protected final String TEXT_385 = ");";
  protected final String TEXT_386 = NL + "\t\t\t\tif(((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_387 = ").getSessionTimeZone() == null){" + NL + "\t\t\t\t\tjava.sql.Statement stmtGetTZ_";
  protected final String TEXT_388 = " = conn_";
  protected final String TEXT_389 = ".createStatement();" + NL + "\t\t\t\t\tjava.sql.ResultSet rsGetTZ_";
  protected final String TEXT_390 = " = stmtGetTZ_";
  protected final String TEXT_391 = ".executeQuery(\"select sessiontimezone from dual\");" + NL + "\t\t\t\t\tString sessionTimezone_";
  protected final String TEXT_392 = " = java.util.TimeZone.getDefault().getID();" + NL + "\t\t\t\t\twhile (rsGetTZ_";
  protected final String TEXT_393 = ".next()) {" + NL + "\t\t\t\t\t\tsessionTimezone_";
  protected final String TEXT_394 = " = rsGetTZ_";
  protected final String TEXT_395 = ".getString(1);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_396 = ").setSessionTimeZone(sessionTimezone_";
  protected final String TEXT_397 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_398 = NL + "                stmt_";
  protected final String TEXT_399 = ".setFetchSize(";
  protected final String TEXT_400 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_401 = NL + "\t\t\t\tjava.io.Reader reader_";
  protected final String TEXT_402 = " = rs_";
  protected final String TEXT_403 = ".getCharacterStream(column_index_";
  protected final String TEXT_404 = ");" + NL + "\t\t\t\tjava.io.BufferedReader br_";
  protected final String TEXT_405 = " = null;" + NL + "\t\t\t\tif(reader_";
  protected final String TEXT_406 = " != null) {" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_407 = " = new java.io.BufferedReader(reader_";
  protected final String TEXT_408 = ");                 \t                        " + NL + " \t                StringBuffer content_";
  protected final String TEXT_409 = " = new StringBuffer();" + NL + " \t                int c_";
  protected final String TEXT_410 = " =0;" + NL + " \t                while( (c_";
  protected final String TEXT_411 = " = br_";
  protected final String TEXT_412 = ".read()) != -1) {" + NL + " \t                \tcontent_";
  protected final String TEXT_413 = ".append((char)c_";
  protected final String TEXT_414 = ");" + NL + "\t\t\t\t\t}" + NL + " \t                br_";
  protected final String TEXT_415 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_416 = ".";
  protected final String TEXT_417 = " = content_";
  protected final String TEXT_418 = ".toString();" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_419 = ".";
  protected final String TEXT_420 = " = null;" + NL + "\t\t\t\t}                 \t                    ";
  protected final String TEXT_421 = NL + "\t\t\t \t    tmpContent_";
  protected final String TEXT_422 = " = rs_";
  protected final String TEXT_423 = ".getString(column_index_";
  protected final String TEXT_424 = ");" + NL + "\t\t\t        if(tmpContent_";
  protected final String TEXT_425 = " != null) {" + NL + "\t\t\t            ";
  protected final String TEXT_426 = ".";
  protected final String TEXT_427 = " = tmpContent_";
  protected final String TEXT_428 = ";" + NL + "\t\t\t        } else {" + NL + "\t\t\t            ";
  protected final String TEXT_429 = ".";
  protected final String TEXT_430 = " = null;" + NL + "\t\t\t        }                 \t                    ";
  protected final String TEXT_431 = NL + "\t\t\tbyte [] tmpBytes_";
  protected final String TEXT_432 = " = rs_";
  protected final String TEXT_433 = ".getBytes(column_index_";
  protected final String TEXT_434 = ");" + NL + "\t\t\tif(tmpBytes_";
  protected final String TEXT_435 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_436 = ".";
  protected final String TEXT_437 = " = tmpBytes_";
  protected final String TEXT_438 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_439 = ".";
  protected final String TEXT_440 = " = null;" + NL + "\t\t\t}\t\t";
  protected final String TEXT_441 = NL + "    \t\t\tTalendTimestampWithTZ talendTimestampWithTZ = null;" + NL + "    \t\t\tif(((oracle.jdbc.OracleResultSet) rs_";
  protected final String TEXT_442 = ").getTIMESTAMPTZ(column_index_";
  protected final String TEXT_443 = ") != null){" + NL + "    \t\t\t\ttalendTimestampWithTZ = org.talend.oracle.OracleTSTZUtil.toTalendTSTZ(((oracle.jdbc.OracleResultSet) rs_";
  protected final String TEXT_444 = ").getTIMESTAMPTZ(column_index_";
  protected final String TEXT_445 = ").toBytes());" + NL + "                }" + NL + "                if(talendTimestampWithTZ != null){" + NL + "                \t";
  protected final String TEXT_446 = ".";
  protected final String TEXT_447 = " = talendTimestampWithTZ;" + NL + "                }else{" + NL + "                \t";
  protected final String TEXT_448 = ".";
  protected final String TEXT_449 = " = null;" + NL + "                }" + NL + "    \t\t";
  protected final String TEXT_450 = NL + "\t\t\t\t\tjava.sql.Timestamp timestamp = rs_";
  protected final String TEXT_451 = ".getTimestamp(column_index_";
  protected final String TEXT_452 = ");" + NL + "\t\t\t\t\tif(timestamp != null) {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_453 = ".";
  protected final String TEXT_454 = " = new java.util.Date(timestamp.getTime());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_455 = ".";
  protected final String TEXT_456 = " = null;" + NL + "\t\t\t\t\t}\t\t\t " + NL + "\t\t\t\t";
  protected final String TEXT_457 = NL + "\t\t\t\t\tif(rs_";
  protected final String TEXT_458 = ".getTimestamp(column_index_";
  protected final String TEXT_459 = ") != null) {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_460 = ".";
  protected final String TEXT_461 = " = new java.util.Date(rs_";
  protected final String TEXT_462 = ".getTimestamp(column_index_";
  protected final String TEXT_463 = ").getTime());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_464 = ".";
  protected final String TEXT_465 = " =  null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_466 = NL + "\t\t\t\tObject tmpObj_";
  protected final String TEXT_467 = "_";
  protected final String TEXT_468 = " = rs_";
  protected final String TEXT_469 = ".getObject(column_index_";
  protected final String TEXT_470 = ");" + NL + "\t\t\t\tif(tmpObj_";
  protected final String TEXT_471 = "_";
  protected final String TEXT_472 = " != null) {";
  protected final String TEXT_473 = NL + "\t\t\t\t\t";
  protected final String TEXT_474 = ".";
  protected final String TEXT_475 = " = oracle.xdb.XMLType.createXML((oracle.sql.OPAQUE) tmpObj_";
  protected final String TEXT_476 = "_";
  protected final String TEXT_477 = ").getStringVal();";
  protected final String TEXT_478 = NL + "\t\t\t\t\t";
  protected final String TEXT_479 = ".";
  protected final String TEXT_480 = " = tmpObj_";
  protected final String TEXT_481 = "_";
  protected final String TEXT_482 = ";";
  protected final String TEXT_483 = NL + "\t\t\t\t} else {";
  protected final String TEXT_484 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_485 = ".";
  protected final String TEXT_486 = " = null;";
  protected final String TEXT_487 = "    " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_488 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_489 = " - Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_490 = NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_491 = NL + "\t\t\t\t}";
  protected final String TEXT_492 = NL + "\t\t\t\t\t";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = " = rs_";
  protected final String TEXT_495 = ".get";
  protected final String TEXT_496 = "(column_index_";
  protected final String TEXT_497 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_498 = NL + "\t\t\t\t\t\tif(!";
  protected final String TEXT_499 = ".";
  protected final String TEXT_500 = " && rs_";
  protected final String TEXT_501 = ".getObject(column_index_";
  protected final String TEXT_502 = ") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_503 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_504 = ".";
  protected final String TEXT_505 = " == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_506 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_507 = ".";
  protected final String TEXT_508 = " == 0 && rs_";
  protected final String TEXT_509 = ".getObject(column_index_";
  protected final String TEXT_510 = ") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_511 = NL + "\t\t\t\t\t\tif(rs_";
  protected final String TEXT_512 = ".getObject(column_index_";
  protected final String TEXT_513 = ") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_514 = NL + "\t\t\t\t";
  protected final String TEXT_515 = NL + "\t\t\t\t\tif(rs_";
  protected final String TEXT_516 = ".getObject(column_index_";
  protected final String TEXT_517 = ") != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_518 = ".";
  protected final String TEXT_519 = " = rs_";
  protected final String TEXT_520 = ".get";
  protected final String TEXT_521 = "(column_index_";
  protected final String TEXT_522 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_523 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_524 = ".";
  protected final String TEXT_525 = " = null;";
  protected final String TEXT_526 = "    " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_527 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_528 = " - Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_529 = NL + " \t                \tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_530 = NL + "\t\t\t\t\t}";
  protected final String TEXT_531 = NL + NL + "    " + NL + "\t";
  protected final String TEXT_532 = NL + "\t\t    int nb_line_";
  protected final String TEXT_533 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_534 = " = null;";
  protected final String TEXT_535 = NL + "\t\t        conn_";
  protected final String TEXT_536 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_537 = "\");";
  protected final String TEXT_538 = NL + "\t\t        \tif (null == conn_";
  protected final String TEXT_539 = ") {" + NL + "\t\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_540 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\t\tconn_";
  protected final String TEXT_541 = " = dataSources_";
  protected final String TEXT_542 = ".get(";
  protected final String TEXT_543 = ").getConnection();" + NL + "\t\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_544 = "\", conn_";
  protected final String TEXT_545 = ");" + NL + "\t\t        \t}" + NL + "\t\t        ";
  protected final String TEXT_546 = NL + "\t\t\t\t";
  protected final String TEXT_547 = NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_548 = " != null) {" + NL + "\t\t\t\t\t\tif(conn_";
  protected final String TEXT_549 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_550 = " - Uses an existing connection as \" + conn_";
  protected final String TEXT_551 = ".getMetaData().getUserName() + \". Connection URL: \" + conn_";
  protected final String TEXT_552 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_553 = NL + NL + "\t\t    ";
  protected final String TEXT_554 = NL + "\t\t    " + NL + "\t\t    String dbquery_";
  protected final String TEXT_555 = " = ";
  protected final String TEXT_556 = ";";
  protected final String TEXT_557 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_558 = " - Executing the query: '\" + dbquery_";
  protected final String TEXT_559 = " + \"'.\");";
  protected final String TEXT_560 = NL + "\t\t    " + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_561 = "_QUERY\",dbquery_";
  protected final String TEXT_562 = ");" + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_563 = " = null;" + NL + "\t\ttry{" + NL + "\t\t    rs_";
  protected final String TEXT_564 = " = stmt_";
  protected final String TEXT_565 = ".executeQuery(dbquery_";
  protected final String TEXT_566 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_567 = " = rs_";
  protected final String TEXT_568 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_569 = " = rsmd_";
  protected final String TEXT_570 = ".getColumnCount();" + NL;
  protected final String TEXT_571 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_572 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_573 = ".setDbmsId(\"";
  protected final String TEXT_574 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_575 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_576 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_577 = ".add(\"";
  protected final String TEXT_578 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_579 = NL + "\t\t\t" + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_580 = " = ";
  protected final String TEXT_581 = ";" + NL + "\t\t\t" + NL + "            for (int i = ";
  protected final String TEXT_582 = "; i <= rsmd_";
  protected final String TEXT_583 = ".getColumnCount()-";
  protected final String TEXT_584 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_585 = ".contains(rsmd_";
  protected final String TEXT_586 = ".getColumnName(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_587 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_588 = ".setName(rsmd_";
  protected final String TEXT_589 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_590 = ".setDbName(rsmd_";
  protected final String TEXT_591 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_592 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_593 = "\", rsmd_";
  protected final String TEXT_594 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_595 = ".getPrecision(i), rsmd_";
  protected final String TEXT_596 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_597 = ".setDbType(rsmd_";
  protected final String TEXT_598 = ".getColumnTypeName(i));";
  protected final String TEXT_599 = NL + "                \tdcm_";
  protected final String TEXT_600 = ".setFormat(";
  protected final String TEXT_601 = ");";
  protected final String TEXT_602 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_603 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_604 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_605 = ".setLength(rsmd_";
  protected final String TEXT_606 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_607 = ".setLength(rsmd_";
  protected final String TEXT_608 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_609 = NL + "\t\t\tdcm_";
  protected final String TEXT_610 = ".setLength(rsmd_";
  protected final String TEXT_611 = ".getPrecision(i));";
  protected final String TEXT_612 = NL + "                \tdcm_";
  protected final String TEXT_613 = ".setPrecision(rsmd_";
  protected final String TEXT_614 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_615 = ".setNullable(rsmd_";
  protected final String TEXT_616 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_617 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_618 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_619 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_620 = ".metadatas.add(dcm_";
  protected final String TEXT_621 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_622 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_623 = " = null;" + NL + "\t\t    int column_index_";
  protected final String TEXT_624 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_625 = NL + "\t\t\t    StringBuffer log4jSb_";
  protected final String TEXT_626 = " = new StringBuffer();" + NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_627 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_628 = NL + "\t\t    while (rs_";
  protected final String TEXT_629 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_630 = "++;" + NL + "\t\t        ";
  protected final String TEXT_631 = NL + "\t\t                        column_index_";
  protected final String TEXT_632 = " = ";
  protected final String TEXT_633 = " + dcg_";
  protected final String TEXT_634 = ".getColumnCount(); " + NL + "\t\t                    ";
  protected final String TEXT_635 = NL + "\t\t                        column_index_";
  protected final String TEXT_636 = " = ";
  protected final String TEXT_637 = ";" + NL + "\t\t                    ";
  protected final String TEXT_638 = NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_639 = " < column_index_";
  protected final String TEXT_640 = ") {" + NL + "\t\t                        ";
  protected final String TEXT_641 = ".";
  protected final String TEXT_642 = " = ";
  protected final String TEXT_643 = "; \t\t\t" + NL + "\t\t                    } else {";
  protected final String TEXT_644 = NL + "\t\t                 \t\t\t";
  protected final String TEXT_645 = "\t\t\t";
  protected final String TEXT_646 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_647 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_648 = NL + "\t\t                            ";
  protected final String TEXT_649 = ".";
  protected final String TEXT_650 = " = (List)rs_";
  protected final String TEXT_651 = ".getObject(column_index_";
  protected final String TEXT_652 = ");";
  protected final String TEXT_653 = NL + "\t\t                         ";
  protected final String TEXT_654 = NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load((oracle.sql.STRUCT) rs_";
  protected final String TEXT_655 = ".getObject(column_index_";
  protected final String TEXT_656 = "));" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_657 = NL + "                                    ";
  protected final String TEXT_658 = ".";
  protected final String TEXT_659 = " = new Geometry(wktValue);";
  protected final String TEXT_660 = NL + "                                        ";
  protected final String TEXT_661 = ".";
  protected final String TEXT_662 = ".setEPSG(";
  protected final String TEXT_663 = ");";
  protected final String TEXT_664 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_665 = NL + "                                  ";
  protected final String TEXT_666 = ".";
  protected final String TEXT_667 = "=dcg_";
  protected final String TEXT_668 = ";";
  protected final String TEXT_669 = NL + "\t\t\t\t\t\t\t\t\t\tList<Object> list_";
  protected final String TEXT_670 = " = new java.util.ArrayList<Object>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_671 = " = ";
  protected final String TEXT_672 = "; i_";
  protected final String TEXT_673 = "  <= rsmd_";
  protected final String TEXT_674 = ".getColumnCount(); i_";
  protected final String TEXT_675 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_676 = ".getColumnTypeName(i_";
  protected final String TEXT_677 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_678 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_679 = ".getClob(i_";
  protected final String TEXT_680 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_681 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_682 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_683 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_684 = ".add(tNTextImpl_";
  protected final String TEXT_685 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_686 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_687 = ".";
  protected final String TEXT_688 = ", rs_";
  protected final String TEXT_689 = ", fixedColumnCount_";
  protected final String TEXT_690 = ",list_";
  protected final String TEXT_691 = ");";
  protected final String TEXT_692 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_693 = ".";
  protected final String TEXT_694 = ", rs_";
  protected final String TEXT_695 = ", fixedColumnCount_";
  protected final String TEXT_696 = ");";
  protected final String TEXT_697 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_698 = ".";
  protected final String TEXT_699 = ", rs_";
  protected final String TEXT_700 = ", fixedColumnCount_";
  protected final String TEXT_701 = ");";
  protected final String TEXT_702 = NL + "                                \torg.postgis.Geometry o = org.postgis.PGgeometry.geomFromString(rs_";
  protected final String TEXT_703 = ".getObject(column_index_";
  protected final String TEXT_704 = ").toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_705 = ".";
  protected final String TEXT_706 = " = new Geometry(sb.toString());";
  protected final String TEXT_707 = NL + "\t\t                          ";
  protected final String TEXT_708 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_709 = NL + "\t\t                    }" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_710 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_711 = ".append(";
  protected final String TEXT_712 = ".";
  protected final String TEXT_713 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_714 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_715 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_716 = NL + "\t\t\t\t\t";
  protected final String TEXT_717 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_718 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_719 = " + \".\");" + NL + "\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_720 = " - Content of the record \" + nb_line_";
  protected final String TEXT_721 = " + \": \" + log4jSb_";
  protected final String TEXT_722 = ");" + NL + "\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_723 = ".delete(0,log4jSb_";
  protected final String TEXT_724 = ".length());" + NL + "\t\t\t\t\t";
  protected final String TEXT_725 = NL + "\t\t                            ";
  protected final String TEXT_726 = ".";
  protected final String TEXT_727 = " = ";
  protected final String TEXT_728 = ".";
  protected final String TEXT_729 = ";" + NL + "\t\t                            ";
  protected final String TEXT_730 = NL + NL + "\t" + NL + "\t" + NL;
  protected final String TEXT_731 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    	cid = node.getUniqueName();
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	    	if(isLog4jEnabled){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    			}
	    }
	    
	    public void afterUseExistConnection(INode node) {
	    }
	    
	    public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");
	 		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
 		if(specify_alias){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_10);
    
		}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_16);
    this.setURL(node);
    stringBuffer.append(TEXT_17);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jCodeGenerateUtil {
	
		INode node = null;
	    String cid = null;
		String dbproperties = null;
		String dbhost = null;
    	String dbport = null;
    	String dbname = null;
    	String dbuser = null;
 		String dbpwd = null;
		String connectionType = null;
 		String dbVersion =  null; 
 		String dbSchema = null;
 		String useCursor = null;
 		String trimAllColumn = null;
 		String noNullValues = null;
 		String dbquery= null;
 		String table = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");
			connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	 		dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
	 		dbSchema = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
	 		useCursor = ElementParameterParser.getValue(node,"__USE_CURSOR__");
	 		trimAllColumn = ElementParameterParser.getValue(node,"__TRIM_ALL_COLUMN__");
	 		noNullValues = ElementParameterParser.getValue(node,"__NO_NULL_VALUES__");
	 		dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			table= ElementParameterParser.getValue(node, "__TABLE__");
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void infoComponentStart(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_24);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
			}
		}
	
		public void dbConnectionParamsForELT(INode previousNode){
			cid = previousNode.getUniqueName();
			dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	    	dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
		}
		
		public void additionalParameter(INode node) {
			String needtoConvet2Upper= ElementParameterParser.getValue(node, "__Convert_to_UPPer__");
		}
		
		public void generateAdditionalParameters(INode node) {
			additionalParameter(node);
		}
		
		public void generateConnectionParams() {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_113);
    log4jCodeGenerateUtil.debugConnectionParams(node,this.getDirverClassName(node));
    stringBuffer.append(TEXT_114);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    }
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
			} else {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
			}

    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    this.afterUseNewConnection(node);
    
			if(specify_alias){

    stringBuffer.append(TEXT_132);
    
			}
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_146);
    
                    }

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_161);
    
                        } else {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_173);
    
                        }

    stringBuffer.append(TEXT_174);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_183);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_207);
    
                } else {
                    
    stringBuffer.append(TEXT_208);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
        
                }
                
    stringBuffer.append(TEXT_212);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterGenertorType(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    
	class DBInputBeginUtil extends DefaultDBInputUtil{
	
		private INode node = null;
		
		public void beforeComponentProcess(INode node){
			super.beforeComponentProcess(node);
			this.node = node;
		}
	
		public void setURL(INode node) {
			
			String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
			String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");
			String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
			if("ORACLE_RAC".equals(connectionType)) {

    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_217);
    
			} else if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_222);
    
			} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_227);
    
			} else if(("ORACLE_OCI").equals(connectionType)) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_230);
    
			}else if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_233);
    
			}

    stringBuffer.append(TEXT_234);
    
		}
		
		public String getDirverClassName(INode node){
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
			if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) ){
			    return "oracle.jdbc.OracleDriver";	
			}else {
				return "oracle.jdbc.driver.OracleDriver";	
			}
		}
		
		public void createConnection(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
			dbport = ElementParameterParser.getValue(node, "__PORT__");
			dbname = ElementParameterParser.getValue(node, "__DBNAME__");
			dbuser = ElementParameterParser.getValue(node, "__USER__");
			dbpwd = ElementParameterParser.getValue(node, "__PASS__");
			String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
			boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
			if(specify_alias){
				String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_240);
    
			}

    stringBuffer.append(TEXT_241);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_242);
    this.setURL(node);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_247);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jCodeGenerateUtil {
	
		INode node = null;
	    String cid = null;
		String dbproperties = null;
		String dbhost = null;
    	String dbport = null;
    	String dbname = null;
    	String dbuser = null;
 		String dbpwd = null;
		String connectionType = null;
 		String dbVersion =  null; 
 		String dbSchema = null;
 		String useCursor = null;
 		String trimAllColumn = null;
 		String noNullValues = null;
 		String dbquery= null;
 		String table = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");
			connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	 		dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
	 		dbSchema = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
	 		useCursor = ElementParameterParser.getValue(node,"__USE_CURSOR__");
	 		trimAllColumn = ElementParameterParser.getValue(node,"__TRIM_ALL_COLUMN__");
	 		noNullValues = ElementParameterParser.getValue(node,"__NO_NULL_VALUES__");
	 		dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			table= ElementParameterParser.getValue(node, "__TABLE__");
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void infoComponentStart(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_254);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
			}
		}
	
		public void dbConnectionParamsForELT(INode previousNode){
			cid = previousNode.getUniqueName();
			dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	    	dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
		}
		
		public void additionalParameter(INode node) {
			String needtoConvet2Upper= ElementParameterParser.getValue(node, "__Convert_to_UPPer__");
		}
		
		public void generateAdditionalParameters(INode node) {
			additionalParameter(node);
		}
		
		public void generateConnectionParams() {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    }
    stringBuffer.append(TEXT_279);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    }
    stringBuffer.append(TEXT_286);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    }
    stringBuffer.append(TEXT_293);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_297);
    }
    stringBuffer.append(TEXT_298);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    }
    stringBuffer.append(TEXT_310);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_314);
    }
    stringBuffer.append(TEXT_315);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_319);
    }
    stringBuffer.append(TEXT_320);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_324);
    }
    stringBuffer.append(TEXT_325);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    }
    stringBuffer.append(TEXT_332);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    }
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_343);
    
					log4jCodeGenerateUtil.debugConnectionParams(node,this.getDirverClassName(node));	
				
    
				if(isLog4jEnabled){

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    
				}
				if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    
				}else if (dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    
				} else {

    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    
				}
				if(isLog4jEnabled){

    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    
				}
			if(specify_alias){

    stringBuffer.append(TEXT_374);
    
			}
			if(!"ORACLE_8".equals(dbVersion)){

    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    
			}
		}
		
		public void afterUseExistConnection(INode node) {
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
			if(!"ORACLE_8".equals(dbVersion)){
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
			}
	    }
		
		public void createStatement(INode node) {
			
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
			if(!("true").equals(useCursor)) {
				 super.createStatement(node);
			}else {
            	super.createMinValueStatement(node);

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_400);
    
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {
			String columnType = column.getType();
			if(columnType != null && ("CLOB").equals(columnType)) {

    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_420);
    
			} else {

    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_430);
    
			}
	    }
	    
	   	public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_440);
    
	    }
	    
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	boolean noNullValues = ("true").equals(ElementParameterParser.getValue(node, "__NO_NULL_VALUES__"));

	    	String dbType = column.getType();
	    	if(dbType==null){
                super.generateTimestampResultSet(firstConnName,column,currentColNo);
                return;
            }
	    	boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
	    	
	    	String dbVersion = "";
			String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
				String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
			    for(INode targetNode : nodes){
			    	if (targetNode.getUniqueName().equals(connection)) {
				      dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
				    }
			    }
			}else{
				dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
			}
	    	boolean supportTSTZ = false;
	    	if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_10".equals(dbVersion)){
	    		supportTSTZ = true;
	    	}
	    	if(isTSWithTZ && supportTSTZ){
	    	
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_447);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_449);
    
    		}else{
	    		if(noNullValues){
				
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_454);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_456);
    
				}else{
				//super.generateTimestampResultSet(firstConnName,column,currentColNo);
				
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_465);
    
				}
			}
	    }

	   	public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {
		   	boolean noNullValues = ("true").equals(ElementParameterParser.getValue(node, "__NO_NULL_VALUES__"));
	   		boolean isConvert = ("true").equals(ElementParameterParser.getValue(node, "__IS_CONVERT_XMLTYPE__"));    
			List<Map<String, String>> convertColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONVERT_XMLTYPE__");  
	   		
			if(("Object").equals(typeToGenerate)){
			
				boolean needConvert = false;
	   			String convertToJavaType = "";
				if (isConvert && convertColumns.size() > 0) {
					for(java.util.Map<String, String> convertcolumn : convertColumns) {
						if (convertcolumn.get("REFCOL").equals(column.getLabel()) ) {
							needConvert = true;
							convertToJavaType = convertcolumn.get("CONVETTYPE");
						}
					}
				} 
				

    stringBuffer.append(TEXT_466);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    
				if (needConvert && "String".equals(convertToJavaType)) {

    stringBuffer.append(TEXT_473);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_475);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    
				} else {

    stringBuffer.append(TEXT_478);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_480);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    
				}

    stringBuffer.append(TEXT_483);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_484);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_486);
    
					} else {

    stringBuffer.append(TEXT_487);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    }
    stringBuffer.append(TEXT_490);
        
					}

    stringBuffer.append(TEXT_491);
    
			} else {
				if(noNullValues){

    stringBuffer.append(TEXT_492);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    
					if(("Boolean").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_498);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    
					}else if(("Bytes").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_503);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_505);
    
					}else if(("Byte").equals(typeToGenerate) || ("Double").equals(typeToGenerate) || ("Float").equals(typeToGenerate) || ("Int").equals(typeToGenerate) || ("Long").equals(typeToGenerate) || ("Short").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_506);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    
					}else{
					
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    
					}
					
    stringBuffer.append(TEXT_514);
    
				}else{
				
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    
				}
				
    		
				if(column.isNullable()) {

    stringBuffer.append(TEXT_523);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_525);
    
				} else {

    stringBuffer.append(TEXT_526);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    }
    stringBuffer.append(TEXT_529);
        
				}

    stringBuffer.append(TEXT_530);
    
			}
	    }	    
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_531);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	        
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    
    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_537);
    
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

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_543);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    
		        }
		        
    stringBuffer.append(TEXT_546);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
     } 
    
				dbInputBeginUtil.afterUseExistConnection(node);
		
		    } else {
				dbInputBeginUtil.createConnection(node);
		    }

    stringBuffer.append(TEXT_553);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_556);
    
			if(isLog4jEnabled && ("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    
			}

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    
		    
		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_578);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_601);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    
		} else {

    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    
		}

    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    
		    }
		    
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    }
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();
		                 
		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate); 	
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		                    if(!("Dynamic").equals(typeToGenerate) && isDynamic && dynamic_index < currentColNo) {
		                    
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    }else{
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_637);
    }
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_642);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_643);
    
		                        typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);
		  
		                        if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_644);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    stringBuffer.append(TEXT_645);
    
		                        } else if(("Timestamp").equals(typeToGenerate)) {
		                        	if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_646);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_647);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_648);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_653);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_659);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_660);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_662);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_663);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_664);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_665);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
     //for bug TDI-20886
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_671);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_691);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_692);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    
									}else{

    stringBuffer.append(TEXT_697);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_706);
    
                 	            } else {

    stringBuffer.append(TEXT_707);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_708);
    dbInputBeginUtil.afterGenertorType( firstConnName, column,  currentColNo);
    stringBuffer.append(TEXT_709);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_713);
    if(columnList.size() > currentColNo){
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    }
							}
      
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_716);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_725);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_726);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_727);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_729);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_730);
    stringBuffer.append(TEXT_731);
    return stringBuffer.toString();
  }
}
