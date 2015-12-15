package org.talend.designer.codegen.translators.databases.amazonrds.oracle;

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

public class TAmazonOracleInputBeginJava
{
  protected static String nl;
  public static synchronized TAmazonOracleInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonOracleInputBeginJava result = new TAmazonOracleInputBeginJava();
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
  protected final String TEXT_213 = NL + "            \tString url_";
  protected final String TEXT_214 = " = null;";
  protected final String TEXT_215 = NL + "            \t\turl_";
  protected final String TEXT_216 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_217 = " + \":\" + ";
  protected final String TEXT_218 = " + \":\" + ";
  protected final String TEXT_219 = ";";
  protected final String TEXT_220 = NL + "            \t\turl_";
  protected final String TEXT_221 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_222 = " + \")(port=\" + ";
  protected final String TEXT_223 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_224 = " + \")))\";";
  protected final String TEXT_225 = NL + "            \t    url_";
  protected final String TEXT_226 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_227 = ";";
  protected final String TEXT_228 = NL + "\t    \t\t\turl_";
  protected final String TEXT_229 = " = ";
  protected final String TEXT_230 = ";";
  protected final String TEXT_231 = NL;
  protected final String TEXT_232 = NL + "\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_233 = "\");" + NL + "\t\t\t";
  protected final String TEXT_234 = NL + "\t        String dbUser_";
  protected final String TEXT_235 = " = ";
  protected final String TEXT_236 = ";" + NL + "\t        String dbPwd_";
  protected final String TEXT_237 = " = ";
  protected final String TEXT_238 = ";";
  protected final String TEXT_239 = NL + "\t\t\tconn_";
  protected final String TEXT_240 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "\t\t\tconn_";
  protected final String TEXT_243 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_244 = ",dbUser_";
  protected final String TEXT_245 = ",dbPwd_";
  protected final String TEXT_246 = ");";
  protected final String TEXT_247 = NL + "\t\t\tString atnParams_";
  protected final String TEXT_248 = " = ";
  protected final String TEXT_249 = ";" + NL + "\t\t\tatnParams_";
  protected final String TEXT_250 = " = atnParams_";
  protected final String TEXT_251 = ".replaceAll(\"&\", \"\\n\");" + NL + "\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_252 = " = new java.util.Properties();" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_253 = ".put(\"user\",dbUser_";
  protected final String TEXT_254 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_255 = ".put(\"password\",dbPwd_";
  protected final String TEXT_256 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_257 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_258 = ".getBytes()));" + NL + "\t\t\tconn_";
  protected final String TEXT_259 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_260 = ", atnParamsPrope_";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = NL + "                stmt_";
  protected final String TEXT_263 = ".setFetchSize(";
  protected final String TEXT_264 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\tjava.io.Reader reader_";
  protected final String TEXT_266 = " = rs_";
  protected final String TEXT_267 = ".getCharacterStream(column_index_";
  protected final String TEXT_268 = ");" + NL + "\t\t\t\tjava.io.BufferedReader br_";
  protected final String TEXT_269 = " = null;" + NL + "\t\t\t\tif(reader_";
  protected final String TEXT_270 = " != null) {" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_271 = " = new java.io.BufferedReader(reader_";
  protected final String TEXT_272 = ");                 \t                        " + NL + " \t                StringBuffer content_";
  protected final String TEXT_273 = " = new StringBuffer();" + NL + " \t                int c_";
  protected final String TEXT_274 = " =0;" + NL + " \t                while( (c_";
  protected final String TEXT_275 = " = br_";
  protected final String TEXT_276 = ".read()) != -1) {" + NL + " \t                \tcontent_";
  protected final String TEXT_277 = ".append((char)c_";
  protected final String TEXT_278 = ");" + NL + "\t\t\t\t\t}" + NL + " \t                br_";
  protected final String TEXT_279 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_280 = ".";
  protected final String TEXT_281 = " = content_";
  protected final String TEXT_282 = ".toString();" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = " = null;" + NL + "\t\t\t\t}                 \t                    ";
  protected final String TEXT_285 = NL + "\t\t\t \t    tmpContent_";
  protected final String TEXT_286 = " = rs_";
  protected final String TEXT_287 = ".getString(column_index_";
  protected final String TEXT_288 = ");" + NL + "\t\t\t        if(tmpContent_";
  protected final String TEXT_289 = " != null) {" + NL + "\t\t\t            ";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = " = tmpContent_";
  protected final String TEXT_292 = ";" + NL + "\t\t\t        } else {" + NL + "\t\t\t            ";
  protected final String TEXT_293 = ".";
  protected final String TEXT_294 = " = null;" + NL + "\t\t\t        }                 \t                    ";
  protected final String TEXT_295 = NL + "\t\t\tbyte [] tmpBytes_";
  protected final String TEXT_296 = " = rs_";
  protected final String TEXT_297 = ".getBytes(column_index_";
  protected final String TEXT_298 = ");" + NL + "\t\t\tif(tmpBytes_";
  protected final String TEXT_299 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_300 = ".";
  protected final String TEXT_301 = " = tmpBytes_";
  protected final String TEXT_302 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_303 = ".";
  protected final String TEXT_304 = " = null;" + NL + "\t\t\t}\t\t";
  protected final String TEXT_305 = NL + "\t\t\t\tObject tmpObj_";
  protected final String TEXT_306 = "_";
  protected final String TEXT_307 = " = rs_";
  protected final String TEXT_308 = ".getObject(column_index_";
  protected final String TEXT_309 = ");" + NL + "\t\t\t\tif(tmpObj_";
  protected final String TEXT_310 = "_";
  protected final String TEXT_311 = " != null) {";
  protected final String TEXT_312 = NL + "\t\t\t\t\t";
  protected final String TEXT_313 = ".";
  protected final String TEXT_314 = " = oracle.xdb.XMLType.createXML((oracle.sql.OPAQUE) tmpObj_";
  protected final String TEXT_315 = "_";
  protected final String TEXT_316 = ").getStringVal();";
  protected final String TEXT_317 = NL + "\t\t\t\t\t";
  protected final String TEXT_318 = ".";
  protected final String TEXT_319 = " = tmpObj_";
  protected final String TEXT_320 = "_";
  protected final String TEXT_321 = ";";
  protected final String TEXT_322 = NL + "\t\t\t\t} else {";
  protected final String TEXT_323 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_324 = ".";
  protected final String TEXT_325 = " = null;";
  protected final String TEXT_326 = "    " + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_327 = NL + "\t\t\t\t}";
  protected final String TEXT_328 = NL + "\t\t\t\tif(rs_";
  protected final String TEXT_329 = ".getObject(column_index_";
  protected final String TEXT_330 = ") != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = " = rs_";
  protected final String TEXT_333 = ".get";
  protected final String TEXT_334 = "(column_index_";
  protected final String TEXT_335 = ");" + NL + "\t\t\t\t} else {";
  protected final String TEXT_336 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_337 = ".";
  protected final String TEXT_338 = " = null;";
  protected final String TEXT_339 = "    " + NL + " \t                        throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_340 = NL + "\t\t\t\t}";
  protected final String TEXT_341 = NL + NL + "    " + NL + "\t";
  protected final String TEXT_342 = NL + "\t\t    int nb_line_";
  protected final String TEXT_343 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_344 = " = null;";
  protected final String TEXT_345 = NL + "\t\t        conn_";
  protected final String TEXT_346 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_347 = "\");";
  protected final String TEXT_348 = NL + "\t\t        \tif (null == conn_";
  protected final String TEXT_349 = ") {" + NL + "\t\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_350 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\t\tconn_";
  protected final String TEXT_351 = " = dataSources_";
  protected final String TEXT_352 = ".get(";
  protected final String TEXT_353 = ").getConnection();" + NL + "\t\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_354 = "\", conn_";
  protected final String TEXT_355 = ");" + NL + "\t\t        \t}" + NL + "\t\t        ";
  protected final String TEXT_356 = NL + "\t\t\t\t";
  protected final String TEXT_357 = NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_358 = " != null) {" + NL + "\t\t\t\t\t\tif(conn_";
  protected final String TEXT_359 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_360 = " - Uses an existing connection as \" + conn_";
  protected final String TEXT_361 = ".getMetaData().getUserName() + \". Connection URL: \" + conn_";
  protected final String TEXT_362 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_363 = NL + NL + "\t\t    ";
  protected final String TEXT_364 = NL + "\t\t    " + NL + "\t\t    String dbquery_";
  protected final String TEXT_365 = " = ";
  protected final String TEXT_366 = ";";
  protected final String TEXT_367 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_368 = " - Executing the query: '\" + dbquery_";
  protected final String TEXT_369 = " + \"'.\");";
  protected final String TEXT_370 = NL + "\t\t    " + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_371 = "_QUERY\",dbquery_";
  protected final String TEXT_372 = ");" + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_373 = " = null;" + NL + "\t\ttry{" + NL + "\t\t    rs_";
  protected final String TEXT_374 = " = stmt_";
  protected final String TEXT_375 = ".executeQuery(dbquery_";
  protected final String TEXT_376 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_377 = " = rs_";
  protected final String TEXT_378 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_379 = " = rsmd_";
  protected final String TEXT_380 = ".getColumnCount();" + NL;
  protected final String TEXT_381 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_382 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_383 = ".setDbmsId(\"";
  protected final String TEXT_384 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_385 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_386 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_387 = ".add(\"";
  protected final String TEXT_388 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_389 = NL + "\t\t\t" + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_390 = " = ";
  protected final String TEXT_391 = ";" + NL + "\t\t\t" + NL + "            for (int i = ";
  protected final String TEXT_392 = "; i <= rsmd_";
  protected final String TEXT_393 = ".getColumnCount()-";
  protected final String TEXT_394 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_395 = ".contains(rsmd_";
  protected final String TEXT_396 = ".getColumnName(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_397 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_398 = ".setName(rsmd_";
  protected final String TEXT_399 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_400 = ".setDbName(rsmd_";
  protected final String TEXT_401 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_402 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_403 = "\", rsmd_";
  protected final String TEXT_404 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_405 = ".getPrecision(i), rsmd_";
  protected final String TEXT_406 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_407 = ".setDbType(rsmd_";
  protected final String TEXT_408 = ".getColumnTypeName(i));";
  protected final String TEXT_409 = NL + "                \tdcm_";
  protected final String TEXT_410 = ".setFormat(";
  protected final String TEXT_411 = ");";
  protected final String TEXT_412 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_413 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_414 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_415 = ".setLength(rsmd_";
  protected final String TEXT_416 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_417 = ".setLength(rsmd_";
  protected final String TEXT_418 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_419 = NL + "\t\t\tdcm_";
  protected final String TEXT_420 = ".setLength(rsmd_";
  protected final String TEXT_421 = ".getPrecision(i));";
  protected final String TEXT_422 = NL + "                \tdcm_";
  protected final String TEXT_423 = ".setPrecision(rsmd_";
  protected final String TEXT_424 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_425 = ".setNullable(rsmd_";
  protected final String TEXT_426 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_427 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_428 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_429 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_430 = ".metadatas.add(dcm_";
  protected final String TEXT_431 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_432 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_433 = " = null;" + NL + "\t\t    int column_index_";
  protected final String TEXT_434 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_435 = NL + "\t\t\t    StringBuffer log4jSb_";
  protected final String TEXT_436 = " = new StringBuffer();" + NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_437 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_438 = NL + "\t\t    while (rs_";
  protected final String TEXT_439 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_440 = "++;" + NL + "\t\t        ";
  protected final String TEXT_441 = NL + "\t\t                        column_index_";
  protected final String TEXT_442 = " = ";
  protected final String TEXT_443 = " + dcg_";
  protected final String TEXT_444 = ".getColumnCount(); " + NL + "\t\t                    ";
  protected final String TEXT_445 = NL + "\t\t                        column_index_";
  protected final String TEXT_446 = " = ";
  protected final String TEXT_447 = ";" + NL + "\t\t                    ";
  protected final String TEXT_448 = NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_449 = " < column_index_";
  protected final String TEXT_450 = ") {" + NL + "\t\t                        ";
  protected final String TEXT_451 = ".";
  protected final String TEXT_452 = " = ";
  protected final String TEXT_453 = "; \t\t\t" + NL + "\t\t                    } else {";
  protected final String TEXT_454 = NL + "\t\t                 \t\t\t";
  protected final String TEXT_455 = "\t\t\t";
  protected final String TEXT_456 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_457 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_458 = NL + "\t\t                            ";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = " = (List)rs_";
  protected final String TEXT_461 = ".getObject(column_index_";
  protected final String TEXT_462 = ");";
  protected final String TEXT_463 = NL + "\t\t                         ";
  protected final String TEXT_464 = NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load((oracle.sql.STRUCT) rs_";
  protected final String TEXT_465 = ".getObject(column_index_";
  protected final String TEXT_466 = "));" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_467 = NL + "                                    ";
  protected final String TEXT_468 = ".";
  protected final String TEXT_469 = " = new Geometry(wktValue);";
  protected final String TEXT_470 = NL + "                                        ";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = ".setEPSG(";
  protected final String TEXT_473 = ");";
  protected final String TEXT_474 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_475 = NL + "                                  ";
  protected final String TEXT_476 = ".";
  protected final String TEXT_477 = "=dcg_";
  protected final String TEXT_478 = ";";
  protected final String TEXT_479 = NL + "\t\t\t\t\t\t\t\t\t\tList<Object> list_";
  protected final String TEXT_480 = " = new java.util.ArrayList<Object>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_481 = " = ";
  protected final String TEXT_482 = "; i_";
  protected final String TEXT_483 = "  <= rsmd_";
  protected final String TEXT_484 = ".getColumnCount(); i_";
  protected final String TEXT_485 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_486 = ".getColumnTypeName(i_";
  protected final String TEXT_487 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_488 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_489 = ".getClob(i_";
  protected final String TEXT_490 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_491 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_492 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_493 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_494 = ".add(tNTextImpl_";
  protected final String TEXT_495 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_496 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_497 = ".";
  protected final String TEXT_498 = ", rs_";
  protected final String TEXT_499 = ", fixedColumnCount_";
  protected final String TEXT_500 = ",list_";
  protected final String TEXT_501 = ");";
  protected final String TEXT_502 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_503 = ".";
  protected final String TEXT_504 = ", rs_";
  protected final String TEXT_505 = ", fixedColumnCount_";
  protected final String TEXT_506 = ");";
  protected final String TEXT_507 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_508 = ".";
  protected final String TEXT_509 = ", rs_";
  protected final String TEXT_510 = ", fixedColumnCount_";
  protected final String TEXT_511 = ");";
  protected final String TEXT_512 = NL + "                                \torg.postgis.Geometry o = org.postgis.PGgeometry.geomFromString(rs_";
  protected final String TEXT_513 = ".getObject(column_index_";
  protected final String TEXT_514 = ").toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_515 = ".";
  protected final String TEXT_516 = " = new Geometry(sb.toString());";
  protected final String TEXT_517 = NL + "\t\t                          ";
  protected final String TEXT_518 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_519 = NL + "\t\t                    }" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_520 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_521 = ".append(";
  protected final String TEXT_522 = ".";
  protected final String TEXT_523 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_524 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_525 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_526 = NL + "\t\t\t\t\t";
  protected final String TEXT_527 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_528 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_529 = " + \".\");" + NL + "\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_530 = " - Content of the record \" + nb_line_";
  protected final String TEXT_531 = " + \": \" + log4jSb_";
  protected final String TEXT_532 = ");" + NL + "\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_533 = ".delete(0,log4jSb_";
  protected final String TEXT_534 = ".length());" + NL + "\t\t\t\t\t";
  protected final String TEXT_535 = NL + "\t\t                            ";
  protected final String TEXT_536 = ".";
  protected final String TEXT_537 = " = ";
  protected final String TEXT_538 = ".";
  protected final String TEXT_539 = ";" + NL + "\t\t                            ";
  protected final String TEXT_540 = NL + NL + "\t" + NL + "\t" + NL;
  protected final String TEXT_541 = NL;

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

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
            	if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_219);
    
            	} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_224);
    
            	} else if(("ORACLE_OCI").equals(connectionType)) {
            	    
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_227);
    
            	}else if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_230);
    
				}

    stringBuffer.append(TEXT_231);
    
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

    stringBuffer.append(TEXT_232);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_233);
    this.setURL(node);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_238);
    
			if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    
			}else if (dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
			} else {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
			}
		}
		
		public void createStatement(INode node) {
			
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
			if(!("true").equals(useCursor)) {
				 super.createStatement(node);
			}else {
            	super.createMinValueStatement(node);

    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_264);
    
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {
			String columnType = column.getType();
			if(columnType != null && ("CLOB").equals(columnType)) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    
			} else {

    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_294);
    
			}
	    }
	    
	   	public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_304);
    
	    }

	   	public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {
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
				

    stringBuffer.append(TEXT_305);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    
				if (needConvert && "String".equals(convertToJavaType)) {

    stringBuffer.append(TEXT_312);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    
				} else {

    stringBuffer.append(TEXT_317);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_319);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    
				}

    stringBuffer.append(TEXT_322);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_323);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_325);
    
					} else {

    stringBuffer.append(TEXT_326);
        
					}

    stringBuffer.append(TEXT_327);
    
			} else {

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_336);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_338);
    
					} else {

    stringBuffer.append(TEXT_339);
        
					}

    stringBuffer.append(TEXT_340);
    
			}
	    }	    
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_341);
    
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

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_347);
    
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

    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_353);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    
		        }
		        
    stringBuffer.append(TEXT_356);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
     } 
    
				dbInputBeginUtil.afterUseExistConnection(node);
		
		    } else {
				dbInputBeginUtil.createConnection(node);
		    }

    stringBuffer.append(TEXT_363);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_366);
    
			if(isLog4jEnabled && ("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    
			}

    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    
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
		    
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    
		    
		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_388);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(dbms );
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
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_411);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    
		} else {

    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    
		}

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    
		    }
		    
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    }
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    
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
		                    
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    }else{
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_447);
    }
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_452);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_453);
    
		                        typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);
		  
		                        if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_454);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    stringBuffer.append(TEXT_455);
    
		                        } else if(("Timestamp").equals(typeToGenerate)) {
		                        	if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_456);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_457);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_458);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_463);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_469);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_470);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_472);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_473);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_474);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_475);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
     //for bug TDI-20886
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_502);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    
									}else{

    stringBuffer.append(TEXT_507);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_516);
    
                 	            } else {

    stringBuffer.append(TEXT_517);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_518);
    dbInputBeginUtil.afterGenertorType( firstConnName, column,  currentColNo);
    stringBuffer.append(TEXT_519);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_523);
    if(columnList.size() > currentColNo){
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    }
							}
      
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_526);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_535);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_536);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_537);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_539);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_540);
    stringBuffer.append(TEXT_541);
    return stringBuffer.toString();
  }
}
