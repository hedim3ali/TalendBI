package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IProcess;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TMysqlOutputMainJava {
  protected static String nl;
  public static synchronized TMysqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputMainJava result = new TMysqlOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");";
  protected final String TEXT_3 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_6 = " - Driver ClassName: ";
  protected final String TEXT_7 = ".\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_11 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_15 = " = log4jDebugParamters_";
  protected final String TEXT_16 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_17 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_22 = " = log4jDebugParamters_";
  protected final String TEXT_23 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_24 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_29 = " = log4jDebugParamters_";
  protected final String TEXT_30 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_31 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_36 = " = log4jDebugParamters_";
  protected final String TEXT_37 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_38 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_43 = " = log4jDebugParamters_";
  protected final String TEXT_44 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_45 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_48 = " = log4jDebugParamters_";
  protected final String TEXT_49 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_50 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_53 = " = log4jDebugParamters_";
  protected final String TEXT_54 = " + \"DBVERSION = ";
  protected final String TEXT_55 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_60 = " = log4jDebugParamters_";
  protected final String TEXT_61 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_62 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t";
  protected final String TEXT_64 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_65 = " = log4jDebugParamters_";
  protected final String TEXT_66 = " + \"USE_CURSOR = ";
  protected final String TEXT_67 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_70 = " = log4jDebugParamters_";
  protected final String TEXT_71 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_72 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_75 = " = log4jDebugParamters_";
  protected final String TEXT_76 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_77 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_82 = " = log4jDebugParamters_";
  protected final String TEXT_83 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_84 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_89 = " = log4jDebugParamters_";
  protected final String TEXT_90 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_91 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_93 = " = \"";
  protected final String TEXT_94 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_95 = ";";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = "        ";
  protected final String TEXT_98 = NL + "            ";
  protected final String TEXT_99 = " = null;            ";
  protected final String TEXT_100 = NL + "\t\tif(nb_line_";
  protected final String TEXT_101 = "==0) {" + NL + "\t";
  protected final String TEXT_102 = NL + "    \t";
  protected final String TEXT_103 = "            " + NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_104 = " = conn_";
  protected final String TEXT_105 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_106 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_107 = " - Droping table '\" + tableName_";
  protected final String TEXT_108 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_109 = NL + "            stmtDrop_";
  protected final String TEXT_110 = ".execute(\"";
  protected final String TEXT_111 = "\");" + NL + "        \t";
  protected final String TEXT_112 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_113 = " - Drop table '\" + tableName_";
  protected final String TEXT_114 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_115 = NL + "            stmtDrop_";
  protected final String TEXT_116 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_117 = " = conn_";
  protected final String TEXT_118 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_119 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_120 = " - Creating table '\" + tableName_";
  protected final String TEXT_121 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_123 = ".execute((\"";
  protected final String TEXT_124 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ", \"";
  protected final String TEXT_127 = "\"))+\")";
  protected final String TEXT_128 = "\");";
  protected final String TEXT_129 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_130 = ".execute(\"";
  protected final String TEXT_131 = ")\");";
  protected final String TEXT_132 = NL + "        \t";
  protected final String TEXT_133 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_134 = " - Create table '\" + tableName_";
  protected final String TEXT_135 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_137 = ".close();";
  protected final String TEXT_138 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_139 = " = conn_";
  protected final String TEXT_140 = ".createStatement();" + NL + "        \t";
  protected final String TEXT_141 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_142 = " - Creating table '\" + tableName_";
  protected final String TEXT_143 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_145 = ".execute((\"";
  protected final String TEXT_146 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = ", \"";
  protected final String TEXT_149 = "\"))+\")";
  protected final String TEXT_150 = "\");";
  protected final String TEXT_151 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_152 = ".execute(\"";
  protected final String TEXT_153 = ")\");";
  protected final String TEXT_154 = NL + "        \t";
  protected final String TEXT_155 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_156 = " - Create table '\" + tableName_";
  protected final String TEXT_157 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_158 = NL + "            stmtCreate_";
  protected final String TEXT_159 = ".close();";
  protected final String TEXT_160 = "\t         " + NL + "\t\t    " + NL + "\t\t    ";
  protected final String TEXT_161 = NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_162 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_163 = "+\"][\"+";
  protected final String TEXT_164 = "+\"][\"+";
  protected final String TEXT_165 = "+\"][\"+";
  protected final String TEXT_166 = "+\"][\"+";
  protected final String TEXT_167 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_168 = " + \"]\";" + NL + "\t\t    ";
  protected final String TEXT_169 = NL + "\t\t    // [%connection%][checktable][tableName]" + NL + "\t\t    String keyCheckTable_";
  protected final String TEXT_170 = " = conn_";
  protected final String TEXT_171 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_172 = " + \"]\";" + NL + "\t\t    ";
  protected final String TEXT_173 = NL + "\t\t    " + NL + "\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_174 = ")== null){" + NL + "\t\t\t" + NL + "\t\t\t\tsynchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_175 = ")) {" + NL + "\t\t\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_176 = ")== null){";
  protected final String TEXT_177 = "              ";
  protected final String TEXT_178 = NL + "\t\t\t\tjava.sql.Statement isExistStmt_";
  protected final String TEXT_179 = " = conn_";
  protected final String TEXT_180 = ".createStatement();" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_181 = " = false;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tisExistStmt_";
  protected final String TEXT_182 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_183 = " + \"]\" );" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_184 = " = true;" + NL + "\t\t\t\t} catch (java.lang.Exception e){" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_185 = " = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tisExistStmt_";
  protected final String TEXT_186 = ".close();";
  protected final String TEXT_187 = "   " + NL + "\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_189 = " = conn_";
  protected final String TEXT_190 = ".getMetaData();" + NL + "\t            if(tableNameForSearch_";
  protected final String TEXT_191 = ".indexOf(\"\\\"\")==-1){" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_192 = " = tableNameForSearch_";
  protected final String TEXT_193 = ".toUpperCase();" + NL + "            \t}else{" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_194 = " = tableNameForSearch_";
  protected final String TEXT_195 = ".replaceAll(\"\\\"\",\"\");" + NL + "            \t}" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_196 = " = dbMetaData_";
  protected final String TEXT_197 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_198 = ", tableNameForSearch_";
  protected final String TEXT_199 = ", new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_200 = " = false;" + NL + "\t            if(rsTable_";
  protected final String TEXT_201 = ".next()) {" + NL + "\t            \twhetherExist_";
  protected final String TEXT_202 = " = true;" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_203 = ".close();" + NL + "\t            ";
  protected final String TEXT_204 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_205 = " = conn_";
  protected final String TEXT_206 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_207 = " = dbMetaData_";
  protected final String TEXT_208 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_209 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_210 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_211 = " = rsTable_";
  protected final String TEXT_212 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_213 = " = rsTable_";
  protected final String TEXT_214 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_215 = ".equals";
  protected final String TEXT_216 = "IgnoreCase";
  protected final String TEXT_217 = "(";
  protected final String TEXT_218 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_219 = ".equals";
  protected final String TEXT_220 = "IgnoreCase";
  protected final String TEXT_221 = "(dbschema_";
  protected final String TEXT_222 = ") || dbschema_";
  protected final String TEXT_223 = ".trim().length() ==0)) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_224 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_225 = ".close();";
  protected final String TEXT_226 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_227 = " = conn_";
  protected final String TEXT_228 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_229 = " = dbMetaData_";
  protected final String TEXT_230 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_231 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_232 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_233 = " = rsTable_";
  protected final String TEXT_234 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_235 = " = rsTable_";
  protected final String TEXT_236 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_237 = ".equals";
  protected final String TEXT_238 = "IgnoreCase";
  protected final String TEXT_239 = "(";
  protected final String TEXT_240 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_241 = ".equals";
  protected final String TEXT_242 = "IgnoreCase";
  protected final String TEXT_243 = "(dbschema_";
  protected final String TEXT_244 = ") || (dbschema_";
  protected final String TEXT_245 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_246 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_247 = ")))) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_248 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_249 = ".close();";
  protected final String TEXT_250 = "  \t            " + NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_251 = " = conn_";
  protected final String TEXT_252 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_253 = " = dbMetaData_";
  protected final String TEXT_254 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_255 = " = false;" + NL + "\t            String defaultSchema_";
  protected final String TEXT_256 = " = \"public\";" + NL + "\t            if(dbschema_";
  protected final String TEXT_257 = " == null || dbschema_";
  protected final String TEXT_258 = ".trim().length() == 0) {" + NL + "\t            \tjava.sql.Statement stmtSchema_";
  protected final String TEXT_259 = " = conn_";
  protected final String TEXT_260 = ".createStatement();" + NL + "\t            \tjava.sql.ResultSet rsSchema_";
  protected final String TEXT_261 = " = stmtSchema_";
  protected final String TEXT_262 = ".executeQuery(\"select current_schema() \");" + NL + "\t            \twhile(rsSchema_";
  protected final String TEXT_263 = ".next()){" + NL + "\t            \t\tdefaultSchema_";
  protected final String TEXT_264 = " = rsSchema_";
  protected final String TEXT_265 = ".getString(\"current_schema\");" + NL + "\t            \t}" + NL + "\t            \trsSchema_";
  protected final String TEXT_266 = ".close();" + NL + "\t            \tstmtSchema_";
  protected final String TEXT_267 = ".close();" + NL + "\t            }" + NL + "\t            while(rsTable_";
  protected final String TEXT_268 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_269 = " = rsTable_";
  protected final String TEXT_270 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_271 = " = rsTable_";
  protected final String TEXT_272 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_273 = ".equals";
  protected final String TEXT_274 = "IgnoreCase";
  protected final String TEXT_275 = "(";
  protected final String TEXT_276 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_277 = ".equals";
  protected final String TEXT_278 = "IgnoreCase";
  protected final String TEXT_279 = "(dbschema_";
  protected final String TEXT_280 = ") || ((dbschema_";
  protected final String TEXT_281 = " ==null || dbschema_";
  protected final String TEXT_282 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_283 = ".equals";
  protected final String TEXT_284 = "IgnoreCase";
  protected final String TEXT_285 = "(schema_";
  protected final String TEXT_286 = ")))) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_287 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_288 = ".close();";
  protected final String TEXT_289 = "      " + NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_290 = " = conn_";
  protected final String TEXT_291 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_292 = " = dbMetaData_";
  protected final String TEXT_293 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            boolean whetherExist_";
  protected final String TEXT_294 = " = false;" + NL + "\t            while(rsTable_";
  protected final String TEXT_295 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_296 = " = rsTable_";
  protected final String TEXT_297 = ".getString(\"TABLE_NAME\");" + NL + "\t                if(table_";
  protected final String TEXT_298 = ".equalsIgnoreCase(";
  protected final String TEXT_299 = ")) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_300 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + "\t            rsTable_";
  protected final String TEXT_301 = ".close();";
  protected final String TEXT_302 = NL + "                if(!whetherExist_";
  protected final String TEXT_303 = ") {" + NL + "                    java.sql.Statement stmtCreate_";
  protected final String TEXT_304 = " = conn_";
  protected final String TEXT_305 = ".createStatement();" + NL + "        \t\t\t";
  protected final String TEXT_306 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_307 = " - Creating table '\" + tableName_";
  protected final String TEXT_308 = " + \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_309 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_310 = ".execute((\"";
  protected final String TEXT_311 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_312 = ".";
  protected final String TEXT_313 = ", \"";
  protected final String TEXT_314 = "\"))+\")";
  protected final String TEXT_315 = "\");";
  protected final String TEXT_316 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_317 = ".execute(\"";
  protected final String TEXT_318 = ")\");";
  protected final String TEXT_319 = NL + "    \t\t   \t";
  protected final String TEXT_320 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_321 = " - Create table '\" + tableName_";
  protected final String TEXT_322 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_323 = NL + "                    stmtCreate_";
  protected final String TEXT_324 = ".close();            " + NL + "                }                ";
  protected final String TEXT_325 = NL + "                if(whetherExist_";
  protected final String TEXT_326 = ") {" + NL + "                    java.sql.Statement stmtDrop_";
  protected final String TEXT_327 = " = conn_";
  protected final String TEXT_328 = ".createStatement();" + NL + "\t    \t    \t";
  protected final String TEXT_329 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_330 = " - Droping table '\" + tableName_";
  protected final String TEXT_331 = " + \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_332 = NL + "                    stmtDrop_";
  protected final String TEXT_333 = ".execute(\"";
  protected final String TEXT_334 = "\");" + NL + "\t    \t    \t";
  protected final String TEXT_335 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_336 = " - Drop table '\" + tableName_";
  protected final String TEXT_337 = "+ \"' has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_338 = NL + "                    stmtDrop_";
  protected final String TEXT_339 = ".close();" + NL + "                }" + NL + "                java.sql.Statement stmtCreate_";
  protected final String TEXT_340 = " = conn_";
  protected final String TEXT_341 = ".createStatement();" + NL + "\t    \t    \t";
  protected final String TEXT_342 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_343 = " - Creating table '\" + tableName_";
  protected final String TEXT_344 = " + \"'.\" );" + NL + "\t\t\t\t\t";
  protected final String TEXT_345 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_346 = ".execute((\"";
  protected final String TEXT_347 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_348 = ".";
  protected final String TEXT_349 = ", \"";
  protected final String TEXT_350 = "\"))+\")";
  protected final String TEXT_351 = "\");";
  protected final String TEXT_352 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_353 = ".execute(\"";
  protected final String TEXT_354 = ")\");";
  protected final String TEXT_355 = NL + "\t    \t    \t";
  protected final String TEXT_356 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_357 = " - Create table '\" + tableName_";
  protected final String TEXT_358 = " + \"' has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_359 = NL + "                stmtCreate_";
  protected final String TEXT_360 = ".close();";
  protected final String TEXT_361 = NL + "\t\t\t\tGlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_362 = ", true);" + NL + "" + NL + "\t\t\t\t\t} // end of if" + NL + "\t\t\t\t} // end synchronized" + NL + "\t\t\t}";
  protected final String TEXT_363 = "            ";
  protected final String TEXT_364 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_365 = " = conn_";
  protected final String TEXT_366 = ".createStatement();" + NL + "    \t   ";
  protected final String TEXT_367 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_368 = " - Clearing table '\" + tableName_";
  protected final String TEXT_369 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_370 = NL + "            stmtClear_";
  protected final String TEXT_371 = ".executeUpdate(\"";
  protected final String TEXT_372 = "\");" + NL + "   \t    \t";
  protected final String TEXT_373 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_374 = "- Clear table '\" + tableName_";
  protected final String TEXT_375 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_376 = NL + "            stmtClear_";
  protected final String TEXT_377 = ".close();";
  protected final String TEXT_378 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_379 = " = conn_";
  protected final String TEXT_380 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_381 = " = stmtTruncCount_";
  protected final String TEXT_382 = ".executeQuery(\"";
  protected final String TEXT_383 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_384 = " = conn_";
  protected final String TEXT_385 = ".createStatement();" + NL + "  \t    \t";
  protected final String TEXT_386 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_387 = " - Trancating table '\" + tableName_";
  protected final String TEXT_388 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_389 = NL + "\t\t\t";
  protected final String TEXT_390 = NL + "\t\t\tconn_";
  protected final String TEXT_391 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_392 = NL + "            stmtTrunc_";
  protected final String TEXT_393 = ".executeUpdate(\"";
  protected final String TEXT_394 = "\");" + NL + "   \t    \t";
  protected final String TEXT_395 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_396 = " - Truncate table '\" + tableName_";
  protected final String TEXT_397 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_398 = NL + "            while(rsTruncCount_";
  protected final String TEXT_399 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_400 = " += rsTruncCount_";
  protected final String TEXT_401 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_402 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_403 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_404 = ".close();            ";
  protected final String TEXT_405 = NL + "\t\t \tjava.sql.Statement stmtTruncCount_";
  protected final String TEXT_406 = " = conn_";
  protected final String TEXT_407 = ".createStatement();" + NL + "\t\t \tjava.sql.ResultSet rsTruncCount_";
  protected final String TEXT_408 = " = stmtTruncCount_";
  protected final String TEXT_409 = ".executeQuery(\"";
  protected final String TEXT_410 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_411 = " = conn_";
  protected final String TEXT_412 = ".createStatement();" + NL + "  \t    \t";
  protected final String TEXT_413 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_414 = " - Truncating reuse stroage table '\" + tableName_";
  protected final String TEXT_415 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_416 = NL + "\t\t\t";
  protected final String TEXT_417 = NL + "\t\t\tconn_";
  protected final String TEXT_418 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_419 = NL + "            stmtTrunc_";
  protected final String TEXT_420 = ".executeUpdate(\"";
  protected final String TEXT_421 = "\");" + NL + "   \t    \t";
  protected final String TEXT_422 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_423 = " - Truncate reuse stroage table '\" + tableName_";
  protected final String TEXT_424 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_425 = NL + "             while(rsTruncCount_";
  protected final String TEXT_426 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_427 = " += rsTruncCount_";
  protected final String TEXT_428 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_429 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_430 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_431 = ".close();";
  protected final String TEXT_432 = NL + "\t\t\tStringBuffer duplidateClause_";
  protected final String TEXT_433 = " = new StringBuffer(\" ON DUPLICATE KEY UPDATE \");\t" + NL + "\t\t\t\t";
  protected final String TEXT_434 = NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_435 = ".append(\",\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_436 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_437 = ".append (\"`\" +  ";
  protected final String TEXT_438 = " + \"`\");" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_439 = ".append (\"=\");" + NL + "\t\t\t\t\t\tduplidateClause_";
  protected final String TEXT_440 = ".append (";
  protected final String TEXT_441 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_442 = NL + "\t\t\t\t       ";
  protected final String TEXT_443 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_444 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_445 = " + \"` (";
  protected final String TEXT_446 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_447 = ".";
  protected final String TEXT_448 = ", \"";
  protected final String TEXT_449 = "\")+\") VALUES (";
  protected final String TEXT_450 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_451 = ".";
  protected final String TEXT_452 = ")+\")\";";
  protected final String TEXT_453 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_454 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_455 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_456 = ".";
  protected final String TEXT_457 = ", \"";
  protected final String TEXT_458 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = ")+\")\";";
  protected final String TEXT_461 = "            " + NL + "\t\t\t\tinsert_";
  protected final String TEXT_462 = " += \tduplidateClause_";
  protected final String TEXT_463 = ".toString();";
  protected final String TEXT_464 = NL + "\t\t\t\t";
  protected final String TEXT_465 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_466 = " = new StringBuffer(insert_";
  protected final String TEXT_467 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_468 = ".insert(insert_";
  protected final String TEXT_469 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_470 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_471 = " =insertStringBuffer_";
  protected final String TEXT_472 = ".toString(); ";
  protected final String TEXT_473 = "    " + NL;
  protected final String TEXT_474 = NL + "                        pstmt_";
  protected final String TEXT_475 = " = conn_";
  protected final String TEXT_476 = ".prepareStatement(insert_";
  protected final String TEXT_477 = ");";
  protected final String TEXT_478 = NL + "                        ";
  protected final String TEXT_479 = NL + "                \t\tpstmt_";
  protected final String TEXT_480 = " = null;         " + NL + "                        // [%connection%][psmt][tableName]" + NL + "                        String keyPsmt_";
  protected final String TEXT_481 = " = conn_";
  protected final String TEXT_482 = " + \"[psmt]\" + \"[\" + ";
  protected final String TEXT_483 = " + \"]\";" + NL + "                \t\tif(GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_484 = ")== null){" + NL + "                \t\t\tpstmt_";
  protected final String TEXT_485 = " = conn_";
  protected final String TEXT_486 = ".prepareStatement(insert_";
  protected final String TEXT_487 = ");\t\t" + NL + "                \t\t\tGlobalResource.resourceMap.put(keyPsmt_";
  protected final String TEXT_488 = ", pstmt_";
  protected final String TEXT_489 = ");" + NL + "                \t\t}else{" + NL + "                \t\t\tpstmt_";
  protected final String TEXT_490 = " = (java.sql.PreparedStatement)GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_491 = ");\t\t\t\t" + NL + "                \t\t}";
  protected final String TEXT_492 = NL + "\t        \t        ";
  protected final String TEXT_493 = "\t            " + NL + "\t            ////////////////////////////////////////////////////////////////////////////////////////////" + NL + "\t            " + NL + "\t            " + NL + "\t            StringBuilder extendInsertValueStmt_";
  protected final String TEXT_494 = " = new StringBuilder();" + NL + "                for(int i=0;i < ";
  protected final String TEXT_495 = ";i++){";
  protected final String TEXT_496 = NL + "                    extendInsertValueStmt_";
  protected final String TEXT_497 = ".append(\"(";
  protected final String TEXT_498 = ",\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_499 = ".";
  protected final String TEXT_500 = ")+\")\");";
  protected final String TEXT_501 = NL + "\t\t\t\t    extendInsertValueStmt_";
  protected final String TEXT_502 = ".append(\"(";
  protected final String TEXT_503 = ")\");";
  protected final String TEXT_504 = NL + "                if (i!=";
  protected final String TEXT_505 = "-1) extendInsertValueStmt_";
  protected final String TEXT_506 = ".append(\",\");" + NL + "                }";
  protected final String TEXT_507 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_508 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_509 = " + \"` (";
  protected final String TEXT_510 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_511 = ".";
  protected final String TEXT_512 = ", \"";
  protected final String TEXT_513 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_514 = ".toString();";
  protected final String TEXT_515 = NL + "\t\t\t\t\t\tinsert_";
  protected final String TEXT_516 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_517 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_518 = ".";
  protected final String TEXT_519 = ", \"";
  protected final String TEXT_520 = "\")+\") VALUES \" + extendInsertValueStmt_";
  protected final String TEXT_521 = ".toString();";
  protected final String TEXT_522 = "            " + NL + "\t\t\t\t    insert_";
  protected final String TEXT_523 = " += \tduplidateClause_";
  protected final String TEXT_524 = ".toString();";
  protected final String TEXT_525 = NL + "\t\t\t\t\t";
  protected final String TEXT_526 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_527 = " = new StringBuffer(insert_";
  protected final String TEXT_528 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_529 = ".insert(insert_";
  protected final String TEXT_530 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_531 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_532 = " =insertStringBuffer_";
  protected final String TEXT_533 = ".toString(); ";
  protected final String TEXT_534 = "    " + NL + "\t\t\t\t    pstmt_";
  protected final String TEXT_535 = " =  conn_";
  protected final String TEXT_536 = ".prepareStatement(insert_";
  protected final String TEXT_537 = ");";
  protected final String TEXT_538 = NL + "\t\t    " + NL + "\t\t\t\t    insertColName";
  protected final String TEXT_539 = " = \"";
  protected final String TEXT_540 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_541 = ".";
  protected final String TEXT_542 = ", \"";
  protected final String TEXT_543 = "\");" + NL + "\t\t\t\t    insertColValue";
  protected final String TEXT_544 = " =  \"";
  protected final String TEXT_545 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_546 = ".";
  protected final String TEXT_547 = "); ";
  protected final String TEXT_548 = NL + "\t      \t\t\tinsertColName";
  protected final String TEXT_549 = " = DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_550 = ".";
  protected final String TEXT_551 = ", \"";
  protected final String TEXT_552 = "\");" + NL + "\t\t\t\t    insertColValue";
  protected final String TEXT_553 = " =  DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_554 = ".";
  protected final String TEXT_555 = "); ";
  protected final String TEXT_556 = NL + "\t\t\t    rowCount";
  protected final String TEXT_557 = " = 0;";
  protected final String TEXT_558 = NL + "\t            int rowCount";
  protected final String TEXT_559 = " = 0;\t ";
  protected final String TEXT_560 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_561 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_562 = " + \"` (";
  protected final String TEXT_563 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_564 = ".";
  protected final String TEXT_565 = ", \"";
  protected final String TEXT_566 = "\")+\") VALUES (";
  protected final String TEXT_567 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_568 = ".";
  protected final String TEXT_569 = ")+\")\";";
  protected final String TEXT_570 = NL + "\t\t\t\t\t\tString insert_";
  protected final String TEXT_571 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_572 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = ", \"";
  protected final String TEXT_575 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_576 = ".";
  protected final String TEXT_577 = ")+\")\";";
  protected final String TEXT_578 = "            " + NL + "\t\t\t\t\t    insert_";
  protected final String TEXT_579 = " += \tduplidateClause_";
  protected final String TEXT_580 = ".toString();";
  protected final String TEXT_581 = NL + "\t\t\t\t\t    batchSize_";
  protected final String TEXT_582 = " = ";
  protected final String TEXT_583 = ";" + NL + "\t\t   \t\t\t    batchSizeCounter_";
  protected final String TEXT_584 = "=0;";
  protected final String TEXT_585 = NL + "\t\t\t\t\t    int batchSize_";
  protected final String TEXT_586 = " = ";
  protected final String TEXT_587 = ";" + NL + "\t\t   \t\t\t    int batchSizeCounter_";
  protected final String TEXT_588 = "=0;";
  protected final String TEXT_589 = NL + "\t\t        ";
  protected final String TEXT_590 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_591 = " = new StringBuffer(insert_";
  protected final String TEXT_592 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_593 = ".insert(insert_";
  protected final String TEXT_594 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_595 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_596 = " =insertStringBuffer_";
  protected final String TEXT_597 = ".toString(); ";
  protected final String TEXT_598 = "    " + NL + "\t\t        pstmt_";
  protected final String TEXT_599 = " = conn_";
  protected final String TEXT_600 = ".prepareStatement(insert_";
  protected final String TEXT_601 = ");" + NL + "\t\t        " + NL + "\t\t\t\t";
  protected final String TEXT_602 = NL + "\t\t\t\tString update_";
  protected final String TEXT_603 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_604 = " + \"` SET ";
  protected final String TEXT_605 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_606 = ".";
  protected final String TEXT_607 = ", \"";
  protected final String TEXT_608 = "\")+\" WHERE ";
  protected final String TEXT_609 = "\";";
  protected final String TEXT_610 = NL + "\t\t\t\tString update_";
  protected final String TEXT_611 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_612 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_613 = ".";
  protected final String TEXT_614 = ", \"";
  protected final String TEXT_615 = "\")+\" WHERE ";
  protected final String TEXT_616 = "\";";
  protected final String TEXT_617 = NL + "\t    ";
  protected final String TEXT_618 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_619 = " = new StringBuffer(update_";
  protected final String TEXT_620 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_621 = ".insert(update_";
  protected final String TEXT_622 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_623 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_624 = " =updateStringBuffer_";
  protected final String TEXT_625 = ".toString(); ";
  protected final String TEXT_626 = NL + "\t    pstmt_";
  protected final String TEXT_627 = " = conn_";
  protected final String TEXT_628 = ".prepareStatement(update_";
  protected final String TEXT_629 = ");" + NL + "\t    ";
  protected final String TEXT_630 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_631 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_632 = " + \"` (";
  protected final String TEXT_633 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_634 = ".";
  protected final String TEXT_635 = ", \"";
  protected final String TEXT_636 = "\")+\") VALUES (";
  protected final String TEXT_637 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_638 = ".";
  protected final String TEXT_639 = ")+\")\";";
  protected final String TEXT_640 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_641 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_642 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_643 = ".";
  protected final String TEXT_644 = ", \"";
  protected final String TEXT_645 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_646 = ".";
  protected final String TEXT_647 = ")+\")\";";
  protected final String TEXT_648 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_649 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_650 = " + \"` SET ";
  protected final String TEXT_651 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_652 = ".";
  protected final String TEXT_653 = ", \"";
  protected final String TEXT_654 = "\")+\" WHERE ";
  protected final String TEXT_655 = "\";";
  protected final String TEXT_656 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_657 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_658 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_659 = ".";
  protected final String TEXT_660 = ", \"";
  protected final String TEXT_661 = "\")+\" WHERE ";
  protected final String TEXT_662 = "\";";
  protected final String TEXT_663 = NL + "\t    pstmt_";
  protected final String TEXT_664 = " = conn_";
  protected final String TEXT_665 = ".prepareStatement(\"SELECT COUNT(1) FROM `\" + ";
  protected final String TEXT_666 = " + \"` WHERE ";
  protected final String TEXT_667 = "\");//String insert_";
  protected final String TEXT_668 = " = \"INSERT INTO `\" + ";
  protected final String TEXT_669 = " + \"` (";
  protected final String TEXT_670 = ") VALUES (";
  protected final String TEXT_671 = ")\";" + NL + "\t    ";
  protected final String TEXT_672 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_673 = " = new StringBuffer(insert_";
  protected final String TEXT_674 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_675 = ".insert(insert_";
  protected final String TEXT_676 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_677 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_678 = " =insertStringBuffer_";
  protected final String TEXT_679 = ".toString(); ";
  protected final String TEXT_680 = "    " + NL + "\t    pstmtInsert_";
  protected final String TEXT_681 = " = conn_";
  protected final String TEXT_682 = ".prepareStatement(insert_";
  protected final String TEXT_683 = ");" + NL + "\t    ";
  protected final String TEXT_684 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_685 = " = new StringBuffer(update_";
  protected final String TEXT_686 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_687 = ".insert(update_";
  protected final String TEXT_688 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_689 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_690 = " =updateStringBuffer_";
  protected final String TEXT_691 = ".toString(); ";
  protected final String TEXT_692 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_693 = " = conn_";
  protected final String TEXT_694 = ".prepareStatement(update_";
  protected final String TEXT_695 = ");\t\t" + NL + "\t    ";
  protected final String TEXT_696 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_697 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_698 = " + \"` (";
  protected final String TEXT_699 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_700 = ".";
  protected final String TEXT_701 = ", \"";
  protected final String TEXT_702 = "\")+\") VALUES (";
  protected final String TEXT_703 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_704 = ".";
  protected final String TEXT_705 = ")+\")\";";
  protected final String TEXT_706 = NL + "\t\t\t\t\tString insert_";
  protected final String TEXT_707 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_708 = " + \"` (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_709 = ".";
  protected final String TEXT_710 = ", \"";
  protected final String TEXT_711 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_712 = ".";
  protected final String TEXT_713 = ")+\")\";";
  protected final String TEXT_714 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_715 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_716 = " + \"` SET ";
  protected final String TEXT_717 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_718 = ".";
  protected final String TEXT_719 = ", \"";
  protected final String TEXT_720 = "\")+\" WHERE ";
  protected final String TEXT_721 = "\";";
  protected final String TEXT_722 = NL + "\t\t\t\t\tString update_";
  protected final String TEXT_723 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_724 = " + \"` SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_725 = ".";
  protected final String TEXT_726 = ", \"";
  protected final String TEXT_727 = "\")+\" WHERE ";
  protected final String TEXT_728 = "\";";
  protected final String TEXT_729 = NL + "\t    ";
  protected final String TEXT_730 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_731 = " = new StringBuffer(update_";
  protected final String TEXT_732 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_733 = ".insert(update_";
  protected final String TEXT_734 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_735 = "  + \" \");" + NL + "\t    update_";
  protected final String TEXT_736 = " =updateStringBuffer_";
  protected final String TEXT_737 = ".toString(); ";
  protected final String TEXT_738 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_739 = " = conn_";
  protected final String TEXT_740 = ".prepareStatement(update_";
  protected final String TEXT_741 = ");" + NL + "\t    ";
  protected final String TEXT_742 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_743 = " = new StringBuffer(insert_";
  protected final String TEXT_744 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_745 = ".insert(insert_";
  protected final String TEXT_746 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_747 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_748 = " =insertStringBuffer_";
  protected final String TEXT_749 = ".toString(); ";
  protected final String TEXT_750 = "    " + NL + "\t    pstmtInsert_";
  protected final String TEXT_751 = " = conn_";
  protected final String TEXT_752 = ".prepareStatement(insert_";
  protected final String TEXT_753 = ");\t\t\t\t" + NL + "\t    ";
  protected final String TEXT_754 = NL + "\t    String delete_";
  protected final String TEXT_755 = " = \"DELETE  FROM `\" + ";
  protected final String TEXT_756 = " + \"` WHERE ";
  protected final String TEXT_757 = "\";" + NL + "\t    ";
  protected final String TEXT_758 = NL + "    StringBuffer deleteStringBuffer_";
  protected final String TEXT_759 = " = new StringBuffer(delete_";
  protected final String TEXT_760 = ");" + NL + "    deleteStringBuffer_";
  protected final String TEXT_761 = ".insert(delete_";
  protected final String TEXT_762 = ".indexOf(\"DELETE\")+ \"DELETE\".length()+1 , ";
  protected final String TEXT_763 = "  + \" \" );" + NL + "    delete_";
  protected final String TEXT_764 = " =deleteStringBuffer_";
  protected final String TEXT_765 = ".toString();  ";
  protected final String TEXT_766 = NL + "\t    pstmt_";
  protected final String TEXT_767 = " = conn_";
  protected final String TEXT_768 = ".prepareStatement(delete_";
  protected final String TEXT_769 = ");" + NL + "\t    ";
  protected final String TEXT_770 = NL + "\t    String replace_";
  protected final String TEXT_771 = " = \"REPLACE INTO `\" + ";
  protected final String TEXT_772 = " + \"` (";
  protected final String TEXT_773 = ") VALUES (";
  protected final String TEXT_774 = ")\";" + NL + "\t    pstmt_";
  protected final String TEXT_775 = " = conn_";
  protected final String TEXT_776 = ".prepareStatement(replace_";
  protected final String TEXT_777 = ");" + NL + "\t    ";
  protected final String TEXT_778 = NL + "\t    String insertIgnore_";
  protected final String TEXT_779 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_780 = " + \"` (";
  protected final String TEXT_781 = ") VALUES (";
  protected final String TEXT_782 = ") ON DUPLICATE KEY UPDATE ";
  protected final String TEXT_783 = "\";" + NL + "\t    pstmt_";
  protected final String TEXT_784 = " = conn_";
  protected final String TEXT_785 = ".prepareStatement(insertIgnore_";
  protected final String TEXT_786 = ");" + NL + "\t    ";
  protected final String TEXT_787 = NL + "\t    String insert_";
  protected final String TEXT_788 = " = \"INSERT IGNORE INTO `\" + ";
  protected final String TEXT_789 = " + \"` (";
  protected final String TEXT_790 = ") VALUES (";
  protected final String TEXT_791 = ")\";" + NL + "\t    ";
  protected final String TEXT_792 = "\t" + NL + "    StringBuffer insertStringBuffer_";
  protected final String TEXT_793 = " = new StringBuffer(insert_";
  protected final String TEXT_794 = ");" + NL + "    insertStringBuffer_";
  protected final String TEXT_795 = ".insert(insert_";
  protected final String TEXT_796 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_797 = " + \" \");" + NL + "    insert_";
  protected final String TEXT_798 = " =insertStringBuffer_";
  protected final String TEXT_799 = ".toString(); ";
  protected final String TEXT_800 = "    " + NL + "\t    pstmt_";
  protected final String TEXT_801 = " = conn_";
  protected final String TEXT_802 = ".prepareStatement(insert_";
  protected final String TEXT_803 = ");" + NL + "\t    ";
  protected final String TEXT_804 = NL + "        StringBuffer query_";
  protected final String TEXT_805 = " = null;" + NL + "       \t";
  protected final String TEXT_806 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_807 = " = insert_";
  protected final String TEXT_808 = ".split(\"\\\\?\");";
  protected final String TEXT_809 = NL + "\t\t\tupdate_";
  protected final String TEXT_810 = " += \" \";" + NL + "\t    \tString[] updateSQLSplits_";
  protected final String TEXT_811 = " = update_";
  protected final String TEXT_812 = ".split(\"\\\\?\");";
  protected final String TEXT_813 = NL + "\t\t\tupdate_";
  protected final String TEXT_814 = " += \" \";" + NL + "\t\t\tString[] updateSQLSplits_";
  protected final String TEXT_815 = " = update_";
  protected final String TEXT_816 = ".split(\"\\\\?\");" + NL + "\t\t\tString[] insertSQLSplits_";
  protected final String TEXT_817 = " = insert_";
  protected final String TEXT_818 = ".split(\"\\\\?\");";
  protected final String TEXT_819 = NL + "\t\t\tdelete_";
  protected final String TEXT_820 = " += \" \";" + NL + "\t\t   \tString[] deleteSQLSplits_";
  protected final String TEXT_821 = " = delete_";
  protected final String TEXT_822 = ".split(\"\\\\?\");";
  protected final String TEXT_823 = NL + "\t\t\treplace_";
  protected final String TEXT_824 = " += \" \";" + NL + "\t\t\tString[] replaceSQLSplits_";
  protected final String TEXT_825 = " = replace_";
  protected final String TEXT_826 = ".split(\"\\\\?\");";
  protected final String TEXT_827 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_828 = " += \" \";" + NL + "\t\t\tString[] insertIgnoreSQLSplits_";
  protected final String TEXT_829 = " = insertIgnore_";
  protected final String TEXT_830 = ".split(\"\\\\?\");";
  protected final String TEXT_831 = NL + "\t\t \tString[] insertSQLSplits_";
  protected final String TEXT_832 = " = insert_";
  protected final String TEXT_833 = ".split(\"\\\\?\");";
  protected final String TEXT_834 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_835 = NL + "    ";
  protected final String TEXT_836 = NL + "                if(";
  protected final String TEXT_837 = ".";
  protected final String TEXT_838 = "==null){";
  protected final String TEXT_839 = NL + "                    ";
  protected final String TEXT_840 = ".setNull(counter";
  protected final String TEXT_841 = ",java.sql.Types.CHAR);";
  protected final String TEXT_842 = NL + "                if(";
  protected final String TEXT_843 = ".";
  protected final String TEXT_844 = "==null){";
  protected final String TEXT_845 = NL + "                    ";
  protected final String TEXT_846 = ".setNull(counter";
  protected final String TEXT_847 = ",java.sql.Types.DATE);";
  protected final String TEXT_848 = NL + "                if(";
  protected final String TEXT_849 = ".";
  protected final String TEXT_850 = "==null){";
  protected final String TEXT_851 = NL + "                    ";
  protected final String TEXT_852 = ".setNull(counter";
  protected final String TEXT_853 = ",java.sql.Types.ARRAY);         ";
  protected final String TEXT_854 = NL + "                if(";
  protected final String TEXT_855 = ".";
  protected final String TEXT_856 = "==null){";
  protected final String TEXT_857 = NL + "                    ";
  protected final String TEXT_858 = ".setNull(counter";
  protected final String TEXT_859 = ",java.sql.Types.INTEGER);";
  protected final String TEXT_860 = NL + "                if(";
  protected final String TEXT_861 = ".";
  protected final String TEXT_862 = "==null){";
  protected final String TEXT_863 = NL + "                    ";
  protected final String TEXT_864 = ".setNull(counter";
  protected final String TEXT_865 = ",java.sql.Types.VARCHAR);";
  protected final String TEXT_866 = NL + "                if(";
  protected final String TEXT_867 = ".";
  protected final String TEXT_868 = "==null){";
  protected final String TEXT_869 = NL + "                    ";
  protected final String TEXT_870 = ".setNull(counter";
  protected final String TEXT_871 = ",java.sql.Types.OTHER);";
  protected final String TEXT_872 = NL + "                if(";
  protected final String TEXT_873 = ".";
  protected final String TEXT_874 = "==null){";
  protected final String TEXT_875 = NL + "                    ";
  protected final String TEXT_876 = ".setNull(counter";
  protected final String TEXT_877 = ",java.sql.Types.BOOLEAN);   ";
  protected final String TEXT_878 = NL + "                if(";
  protected final String TEXT_879 = ".";
  protected final String TEXT_880 = "==null){";
  protected final String TEXT_881 = NL + "                    ";
  protected final String TEXT_882 = ".setNull(counter";
  protected final String TEXT_883 = ",java.sql.Types.DOUBLE);    ";
  protected final String TEXT_884 = NL + "                if(";
  protected final String TEXT_885 = ".";
  protected final String TEXT_886 = "==null){";
  protected final String TEXT_887 = NL + "                    ";
  protected final String TEXT_888 = ".setNull(counter";
  protected final String TEXT_889 = ",java.sql.Types.FLOAT); ";
  protected final String TEXT_890 = NL + "                }else{";
  protected final String TEXT_891 = NL + "                    if(";
  protected final String TEXT_892 = ".";
  protected final String TEXT_893 = "==null){";
  protected final String TEXT_894 = NL + "                    if((\"null\").equals(String.valueOf(";
  protected final String TEXT_895 = ".";
  protected final String TEXT_896 = ").toLowerCase())){";
  protected final String TEXT_897 = NL + "                ";
  protected final String TEXT_898 = ".setNull(counter";
  protected final String TEXT_899 = ",java.sql.Types.CHAR);" + NL + "            " + NL + "                }else if(";
  protected final String TEXT_900 = ".";
  protected final String TEXT_901 = " == '\\0'){" + NL + "        ";
  protected final String TEXT_902 = NL + "                    ";
  protected final String TEXT_903 = ".setString(counter";
  protected final String TEXT_904 = ",\"\");" + NL + "            " + NL + "                }else{" + NL + "            ";
  protected final String TEXT_905 = NL + "                    ";
  protected final String TEXT_906 = ".setString(counter";
  protected final String TEXT_907 = ",String.valueOf(";
  protected final String TEXT_908 = ".";
  protected final String TEXT_909 = "));" + NL + "                }";
  protected final String TEXT_910 = NL + "                if(";
  protected final String TEXT_911 = ".";
  protected final String TEXT_912 = "!=null){" + NL + "                    // timestamp < min java date value (year 1) || timestamp > max mysql value (year 10000) => set 0000-00-00 as date in MySQL" + NL + "                    date_";
  protected final String TEXT_913 = " = ";
  protected final String TEXT_914 = ".";
  protected final String TEXT_915 = ".getTime();" + NL + "                    if (date_";
  protected final String TEXT_916 = " < year1_";
  protected final String TEXT_917 = " || date_";
  protected final String TEXT_918 = " >= year10000_";
  protected final String TEXT_919 = ") {";
  protected final String TEXT_920 = NL + "                        ";
  protected final String TEXT_921 = ".setString(counter";
  protected final String TEXT_922 = ", \"0000-00-00 00:00:00\");" + NL + "                    } else {";
  protected final String TEXT_923 = NL + "                        ";
  protected final String TEXT_924 = ".setTimestamp(counter";
  protected final String TEXT_925 = ", new java.sql.Timestamp(date_";
  protected final String TEXT_926 = "));" + NL + "                    }" + NL + "                }else{" + NL + "        ";
  protected final String TEXT_927 = NL + "                    ";
  protected final String TEXT_928 = ".setNull(counter";
  protected final String TEXT_929 = ",java.sql.Types.DATE);" + NL + "            " + NL + "                }";
  protected final String TEXT_930 = NL + "                ";
  protected final String TEXT_931 = ".set";
  protected final String TEXT_932 = "(counter";
  protected final String TEXT_933 = ",";
  protected final String TEXT_934 = ".";
  protected final String TEXT_935 = ");";
  protected final String TEXT_936 = NL + "            " + NL + "                }" + NL + "        ";
  protected final String TEXT_937 = NL + "\t\tquery_";
  protected final String TEXT_938 = " = new StringBuffer(\"\");";
  protected final String TEXT_939 = NL + "\t\t\t\tcommitEvery_";
  protected final String TEXT_940 = " = buffersSize_";
  protected final String TEXT_941 = ";";
  protected final String TEXT_942 = NL + "\t\t\t\t\tbatchSize_";
  protected final String TEXT_943 = " = buffersSize_";
  protected final String TEXT_944 = ";";
  protected final String TEXT_945 = NL + "\t\t";
  protected final String TEXT_946 = NL + "        whetherReject_";
  protected final String TEXT_947 = " = false;";
  protected final String TEXT_948 = "                " + NL + "\t                \tint counter";
  protected final String TEXT_949 = " = rowCount";
  protected final String TEXT_950 = " * ";
  protected final String TEXT_951 = " + 1;" + NL + "\t                ";
  protected final String TEXT_952 = NL + "\t                        counter";
  protected final String TEXT_953 = "++;" + NL + "\t                        ";
  protected final String TEXT_954 = NL + "\t\t\t\t\t\t\tint count_dyn_";
  protected final String TEXT_955 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_956 = ".";
  protected final String TEXT_957 = ", pstmt_";
  protected final String TEXT_958 = ", counter";
  protected final String TEXT_959 = "-1, \"";
  protected final String TEXT_960 = "\");" + NL + "\t\t\t\t\t\t\tcounter";
  protected final String TEXT_961 = "+=count_dyn_";
  protected final String TEXT_962 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_963 = NL + "\t             " + NL + "\t                exInsertColValue";
  protected final String TEXT_964 = " = new BufferLine_";
  protected final String TEXT_965 = "(" + NL + "\t                ";
  protected final String TEXT_966 = NL + "\t                            ," + NL + "\t                            ";
  protected final String TEXT_967 = NL + "\t                        ";
  protected final String TEXT_968 = ".";
  protected final String TEXT_969 = "              " + NL + "\t                        ";
  protected final String TEXT_970 = NL + "\t\t\t\t\t, ";
  protected final String TEXT_971 = ".";
  protected final String TEXT_972 = NL + "\t\t\t\t";
  protected final String TEXT_973 = "  " + NL + "\t                ); " + NL + "\t               " + NL + "\t                exInsertColValueList";
  protected final String TEXT_974 = ".add(exInsertColValue";
  protected final String TEXT_975 = ");" + NL + "\t    " + NL + "\t                rowCount";
  protected final String TEXT_976 = "++;";
  protected final String TEXT_977 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_978 = "++;";
  protected final String TEXT_979 = "\t         " + NL + "\t                if(rowCount";
  protected final String TEXT_980 = " == ";
  protected final String TEXT_981 = "){ " + NL + "\t                    insertedCount_";
  protected final String TEXT_982 = " = insertedCount_";
  protected final String TEXT_983 = " + pstmt_";
  protected final String TEXT_984 = ".executeUpdate();" + NL + "\t                    exInsertColValueList";
  protected final String TEXT_985 = ".clear();" + NL + "\t                    rowCount";
  protected final String TEXT_986 = " = 0;" + NL + "\t\t\t    counter";
  protected final String TEXT_987 = "=1;" + NL + "\t                }    ";
  protected final String TEXT_988 = NL + "\t                        ";
  protected final String TEXT_989 = NL + "\t                        ";
  protected final String TEXT_990 = NL + "\t                            query_";
  protected final String TEXT_991 = " = ";
  protected final String TEXT_992 = ";" + NL + "\t                            ";
  protected final String TEXT_993 = NL + "\t\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_994 = ".";
  protected final String TEXT_995 = ", pstmt_";
  protected final String TEXT_996 = ", ";
  protected final String TEXT_997 = ", \"";
  protected final String TEXT_998 = "\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_999 = NL + "\t                    globalMap.put(\"";
  protected final String TEXT_1000 = "_QUERY\", query_";
  protected final String TEXT_1001 = ".toString().trim());" + NL + "\t                    ";
  protected final String TEXT_1002 = NL + "\t\t\t\t\t";
  protected final String TEXT_1003 = NL + "\t\t    \t\tpstmt_";
  protected final String TEXT_1004 = ".addBatch();" + NL + "\t\t    \t\tnb_line_";
  protected final String TEXT_1005 = "++;    \t\t " + NL + "\t\t\t\t\t" + NL + "\t\t    \t\t  ";
  protected final String TEXT_1006 = NL + "\t\t    \t\t  batchSizeCounter_";
  protected final String TEXT_1007 = "++;" + NL + "\t\t    \t\t  ";
  protected final String TEXT_1008 = "    \t\t" + NL + "\t\t    \t\t";
  protected final String TEXT_1009 = NL + "\t                try {" + NL + "\t                    nb_line_";
  protected final String TEXT_1010 = "++;" + NL + "\t                    insertedCount_";
  protected final String TEXT_1011 = " = insertedCount_";
  protected final String TEXT_1012 = " + pstmt_";
  protected final String TEXT_1013 = ".executeUpdate();" + NL + "\t                } catch(java.lang.Exception e) {" + NL + "\t                    whetherReject_";
  protected final String TEXT_1014 = " = true;" + NL + "\t                    ";
  protected final String TEXT_1015 = NL + "\t                        ";
  protected final String TEXT_1016 = NL + "\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1017 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1018 = NL + "\t                        throw(e);" + NL + "\t                        ";
  protected final String TEXT_1019 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1020 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1021 = NL + "\t                            ";
  protected final String TEXT_1022 = " = new ";
  protected final String TEXT_1023 = "Struct();" + NL + "\t                            ";
  protected final String TEXT_1024 = NL + "\t                                ";
  protected final String TEXT_1025 = ".";
  protected final String TEXT_1026 = " = ";
  protected final String TEXT_1027 = ".";
  protected final String TEXT_1028 = ";" + NL + "\t                            ";
  protected final String TEXT_1029 = NL + "\t                            rejectedCount_";
  protected final String TEXT_1030 = " =  rejectedCount_";
  protected final String TEXT_1031 = "+ 1;" + NL + "\t                            ";
  protected final String TEXT_1032 = ".errorCode = ((java.sql.SQLException)e).getSQLState();" + NL + "\t                            ";
  protected final String TEXT_1033 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1034 = ";" + NL + "\t                            ";
  protected final String TEXT_1035 = NL + "\t                            System.err.print(e.getMessage());" + NL + "\t                            ";
  protected final String TEXT_1036 = NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_1037 = NL + "                        ";
  protected final String TEXT_1038 = NL + "                            query_";
  protected final String TEXT_1039 = " = ";
  protected final String TEXT_1040 = ";";
  protected final String TEXT_1041 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1042 = ".";
  protected final String TEXT_1043 = ", pstmt_";
  protected final String TEXT_1044 = ", ";
  protected final String TEXT_1045 = ", \"";
  protected final String TEXT_1046 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1047 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1048 = "_QUERY\", query_";
  protected final String TEXT_1049 = ".toString().trim());";
  protected final String TEXT_1050 = NL + "                try {" + NL + "                    nb_line_";
  protected final String TEXT_1051 = "++;" + NL + "                    insertedCount_";
  protected final String TEXT_1052 = " = insertedCount_";
  protected final String TEXT_1053 = " + pstmt_";
  protected final String TEXT_1054 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1055 = " = true;";
  protected final String TEXT_1056 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1057 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1058 = NL + "                        throw(e);";
  protected final String TEXT_1059 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1060 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1061 = NL + "                            ";
  protected final String TEXT_1062 = " = new ";
  protected final String TEXT_1063 = "Struct();";
  protected final String TEXT_1064 = NL + "                                ";
  protected final String TEXT_1065 = ".";
  protected final String TEXT_1066 = " = ";
  protected final String TEXT_1067 = ".";
  protected final String TEXT_1068 = ";";
  protected final String TEXT_1069 = NL + "                            rejectedCount_";
  protected final String TEXT_1070 = " =  rejectedCount_";
  protected final String TEXT_1071 = "+ 1;";
  protected final String TEXT_1072 = NL + "                            ";
  protected final String TEXT_1073 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1074 = NL + "                            ";
  protected final String TEXT_1075 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1076 = ";";
  protected final String TEXT_1077 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1078 = NL + "                }";
  protected final String TEXT_1079 = NL + "    \t\t\t    ";
  protected final String TEXT_1080 = NL + "    \t\t\t    ";
  protected final String TEXT_1081 = NL + "                        query_";
  protected final String TEXT_1082 = " = ";
  protected final String TEXT_1083 = ";";
  protected final String TEXT_1084 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_1085 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1086 = ".";
  protected final String TEXT_1087 = ", pstmt_";
  protected final String TEXT_1088 = ", ";
  protected final String TEXT_1089 = ", \"";
  protected final String TEXT_1090 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_1091 = NL + "                    " + NL + "\t\t\t\t\t";
  protected final String TEXT_1092 = NL + "                    \t";
  protected final String TEXT_1093 = NL + "                        query_";
  protected final String TEXT_1094 = " = ";
  protected final String TEXT_1095 = ";";
  protected final String TEXT_1096 = "  " + NL + "    \t\t\t    ";
  protected final String TEXT_1097 = NL + "    \t\t\t    ";
  protected final String TEXT_1098 = NL + "                       query_";
  protected final String TEXT_1099 = " = ";
  protected final String TEXT_1100 = ";";
  protected final String TEXT_1101 = NL + "                globalMap.put(\"";
  protected final String TEXT_1102 = "_QUERY\", query_";
  protected final String TEXT_1103 = ".toString().trim());";
  protected final String TEXT_1104 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1105 = NL + "    \t\tpstmt_";
  protected final String TEXT_1106 = ".addBatch();" + NL + "    \t\tnb_line_";
  protected final String TEXT_1107 = "++;    \t\t " + NL + "\t\t\t" + NL + "    \t\t  ";
  protected final String TEXT_1108 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_1109 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_1110 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1111 = NL + "            try {" + NL + "                nb_line_";
  protected final String TEXT_1112 = "++;" + NL + "                updatedCount_";
  protected final String TEXT_1113 = " = updatedCount_";
  protected final String TEXT_1114 = " + pstmt_";
  protected final String TEXT_1115 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1116 = " = true;";
  protected final String TEXT_1117 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1118 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1119 = NL + "                    throw(e);";
  protected final String TEXT_1120 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1121 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1122 = NL + "                        ";
  protected final String TEXT_1123 = " = new ";
  protected final String TEXT_1124 = "Struct();";
  protected final String TEXT_1125 = NL + "                            ";
  protected final String TEXT_1126 = ".";
  protected final String TEXT_1127 = " = ";
  protected final String TEXT_1128 = ".";
  protected final String TEXT_1129 = ";";
  protected final String TEXT_1130 = NL + "                        rejectedCount_";
  protected final String TEXT_1131 = " =  rejectedCount_";
  protected final String TEXT_1132 = "+ 1;";
  protected final String TEXT_1133 = NL + "                        ";
  protected final String TEXT_1134 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1135 = NL + "                        ";
  protected final String TEXT_1136 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1137 = ";";
  protected final String TEXT_1138 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1139 = NL + "            }";
  protected final String TEXT_1140 = NL + "\t\t\t\t\t";
  protected final String TEXT_1141 = NL + "                    \t";
  protected final String TEXT_1142 = NL + "    \t\t\t    ";
  protected final String TEXT_1143 = NL + "    \t\t\t    ";
  protected final String TEXT_1144 = NL + "    " + NL + "    \t\tjava.sql.ResultSet rs_";
  protected final String TEXT_1145 = " = pstmt_";
  protected final String TEXT_1146 = ".executeQuery();" + NL + "    \t\tint checkCount_";
  protected final String TEXT_1147 = " = -1;" + NL + "    \t\twhile(rs_";
  protected final String TEXT_1148 = ".next()) {" + NL + "    \t\t\tcheckCount_";
  protected final String TEXT_1149 = " = rs_";
  protected final String TEXT_1150 = ".getInt(1);" + NL + "    \t\t}" + NL + "    \t\tif(checkCount_";
  protected final String TEXT_1151 = " > 0) {" + NL + "    \t\t\t";
  protected final String TEXT_1152 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1153 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1154 = NL + "                            query_";
  protected final String TEXT_1155 = " = ";
  protected final String TEXT_1156 = ";";
  protected final String TEXT_1157 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tint count_";
  protected final String TEXT_1158 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1159 = ".";
  protected final String TEXT_1160 = ", pstmtUpdate_";
  protected final String TEXT_1161 = ", ";
  protected final String TEXT_1162 = ", \"";
  protected final String TEXT_1163 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1164 = NL + "\t                    \t";
  protected final String TEXT_1165 = NL + "\t                    ";
  protected final String TEXT_1166 = NL + "\t                        query_";
  protected final String TEXT_1167 = " = ";
  protected final String TEXT_1168 = ";" + NL + "\t                        ";
  protected final String TEXT_1169 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1170 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1171 = NL + "                            query_";
  protected final String TEXT_1172 = " = ";
  protected final String TEXT_1173 = ";";
  protected final String TEXT_1174 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1175 = "_QUERY\", query_";
  protected final String TEXT_1176 = ".toString().trim());";
  protected final String TEXT_1177 = NL + "                try {" + NL + "                    updatedCount_";
  protected final String TEXT_1178 = " = updatedCount_";
  protected final String TEXT_1179 = " + pstmtUpdate_";
  protected final String TEXT_1180 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1181 = " = true;";
  protected final String TEXT_1182 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1183 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1184 = NL + "                        throw(e);";
  protected final String TEXT_1185 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1186 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1187 = NL + "                        ";
  protected final String TEXT_1188 = " = new ";
  protected final String TEXT_1189 = "Struct();";
  protected final String TEXT_1190 = NL + "                                ";
  protected final String TEXT_1191 = ".";
  protected final String TEXT_1192 = " = ";
  protected final String TEXT_1193 = ".";
  protected final String TEXT_1194 = ";";
  protected final String TEXT_1195 = NL + "                            rejectedCount_";
  protected final String TEXT_1196 = " =  rejectedCount_";
  protected final String TEXT_1197 = "+ 1;";
  protected final String TEXT_1198 = NL + "                            ";
  protected final String TEXT_1199 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1200 = NL + "                            ";
  protected final String TEXT_1201 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1202 = ";";
  protected final String TEXT_1203 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1204 = NL + "                }" + NL + "    \t\t} else {" + NL + "    \t\t\t";
  protected final String TEXT_1205 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1206 = NL + "    \t\t\t\t    ";
  protected final String TEXT_1207 = NL + "                            query_";
  protected final String TEXT_1208 = " = ";
  protected final String TEXT_1209 = ";";
  protected final String TEXT_1210 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1211 = ".";
  protected final String TEXT_1212 = ", pstmtInsert_";
  protected final String TEXT_1213 = ", ";
  protected final String TEXT_1214 = ", \"";
  protected final String TEXT_1215 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1216 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1217 = "_QUERY\", query_";
  protected final String TEXT_1218 = ".toString().trim());";
  protected final String TEXT_1219 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_1220 = " = insertedCount_";
  protected final String TEXT_1221 = " + pstmtInsert_";
  protected final String TEXT_1222 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1223 = " = true;";
  protected final String TEXT_1224 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1225 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1226 = NL + "                        throw(e);";
  protected final String TEXT_1227 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1228 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1229 = NL + "                        ";
  protected final String TEXT_1230 = " = new ";
  protected final String TEXT_1231 = "Struct();";
  protected final String TEXT_1232 = NL + "                                ";
  protected final String TEXT_1233 = ".";
  protected final String TEXT_1234 = " = ";
  protected final String TEXT_1235 = ".";
  protected final String TEXT_1236 = ";";
  protected final String TEXT_1237 = NL + "                            rejectedCount_";
  protected final String TEXT_1238 = " =  rejectedCount_";
  protected final String TEXT_1239 = "+ 1;";
  protected final String TEXT_1240 = NL + "                            ";
  protected final String TEXT_1241 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1242 = NL + "                            ";
  protected final String TEXT_1243 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1244 = ";";
  protected final String TEXT_1245 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1246 = NL + "                }" + NL + "    \t\t}" + NL + "    \t\tnb_line_";
  protected final String TEXT_1247 = "++;" + NL + "    \t\t";
  protected final String TEXT_1248 = NL + "    \t    int updateFlag_";
  protected final String TEXT_1249 = "=0;" + NL + "    \t    ";
  protected final String TEXT_1250 = NL + "    \t\t\t    ";
  protected final String TEXT_1251 = NL + "    \t\t\t    ";
  protected final String TEXT_1252 = NL + "                        query_";
  protected final String TEXT_1253 = " = ";
  protected final String TEXT_1254 = ";";
  protected final String TEXT_1255 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_1256 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1257 = ".";
  protected final String TEXT_1258 = ", pstmtUpdate_";
  protected final String TEXT_1259 = ", ";
  protected final String TEXT_1260 = ", \"";
  protected final String TEXT_1261 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_1262 = NL + "\t\t\t\t\t";
  protected final String TEXT_1263 = NL + "                    \t";
  protected final String TEXT_1264 = NL + "\t                        query_";
  protected final String TEXT_1265 = " = ";
  protected final String TEXT_1266 = ";" + NL + "\t                        ";
  protected final String TEXT_1267 = NL + "                    " + NL + "    \t\t\t    ";
  protected final String TEXT_1268 = NL + "    \t\t\t    ";
  protected final String TEXT_1269 = NL + "                        query_";
  protected final String TEXT_1270 = " = ";
  protected final String TEXT_1271 = ";";
  protected final String TEXT_1272 = NL + "                globalMap.put(\"";
  protected final String TEXT_1273 = "_QUERY\", query_";
  protected final String TEXT_1274 = ".toString().trim());";
  protected final String TEXT_1275 = NL + "    \t" + NL + "            try {" + NL + "                updateFlag_";
  protected final String TEXT_1276 = "=pstmtUpdate_";
  protected final String TEXT_1277 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_1278 = " = updatedCount_";
  protected final String TEXT_1279 = "+updateFlag_";
  protected final String TEXT_1280 = ";" + NL + "                " + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1281 = " = true;";
  protected final String TEXT_1282 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1283 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1284 = NL + "                    throw(e);";
  protected final String TEXT_1285 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1286 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1287 = NL + "                        ";
  protected final String TEXT_1288 = " = new ";
  protected final String TEXT_1289 = "Struct();";
  protected final String TEXT_1290 = NL + "                            ";
  protected final String TEXT_1291 = ".";
  protected final String TEXT_1292 = " = ";
  protected final String TEXT_1293 = ".";
  protected final String TEXT_1294 = ";";
  protected final String TEXT_1295 = NL + "                        rejectedCount_";
  protected final String TEXT_1296 = " =  rejectedCount_";
  protected final String TEXT_1297 = "+ 1;";
  protected final String TEXT_1298 = NL + "                        ";
  protected final String TEXT_1299 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1300 = NL + "                        ";
  protected final String TEXT_1301 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1302 = ";";
  protected final String TEXT_1303 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1304 = NL + "            }" + NL + "            if(updateFlag_";
  protected final String TEXT_1305 = " == 0) {" + NL + "            " + NL + "            \t";
  protected final String TEXT_1306 = NL + "\t\t\t\tquery_";
  protected final String TEXT_1307 = " = new StringBuffer(\"\");" + NL + "        \t\t";
  protected final String TEXT_1308 = NL + "        \t\t\t    ";
  protected final String TEXT_1309 = NL + "        \t\t\t    ";
  protected final String TEXT_1310 = NL + "                            query_";
  protected final String TEXT_1311 = " = ";
  protected final String TEXT_1312 = ";";
  protected final String TEXT_1313 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_1314 = ".";
  protected final String TEXT_1315 = ", pstmtInsert_";
  protected final String TEXT_1316 = ", ";
  protected final String TEXT_1317 = ", \"";
  protected final String TEXT_1318 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1319 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1320 = "_QUERY\", query_";
  protected final String TEXT_1321 = ".toString().trim());";
  protected final String TEXT_1322 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_1323 = " = insertedCount_";
  protected final String TEXT_1324 = " + pstmtInsert_";
  protected final String TEXT_1325 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1326 = " = true;";
  protected final String TEXT_1327 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1328 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1329 = NL + "                        throw(e);";
  protected final String TEXT_1330 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1331 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1332 = NL + "                        ";
  protected final String TEXT_1333 = " = new ";
  protected final String TEXT_1334 = "Struct();";
  protected final String TEXT_1335 = NL + "                                ";
  protected final String TEXT_1336 = ".";
  protected final String TEXT_1337 = " = ";
  protected final String TEXT_1338 = ".";
  protected final String TEXT_1339 = ";";
  protected final String TEXT_1340 = NL + "                            rejectedCount_";
  protected final String TEXT_1341 = " =  rejectedCount_";
  protected final String TEXT_1342 = "+ 1;";
  protected final String TEXT_1343 = NL + "                            ";
  protected final String TEXT_1344 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1345 = NL + "                            ";
  protected final String TEXT_1346 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1347 = ";";
  protected final String TEXT_1348 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1349 = NL + "                }" + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_1350 = "++;";
  protected final String TEXT_1351 = NL + "\t\t\t\t\t";
  protected final String TEXT_1352 = NL + "                    \t";
  protected final String TEXT_1353 = NL + "\t                        query_";
  protected final String TEXT_1354 = " = ";
  protected final String TEXT_1355 = ";" + NL + "\t                        ";
  protected final String TEXT_1356 = NL + "    \t\t\t    ";
  protected final String TEXT_1357 = NL + "    \t\t\t    ";
  protected final String TEXT_1358 = NL + "                        query_";
  protected final String TEXT_1359 = " = ";
  protected final String TEXT_1360 = ";";
  protected final String TEXT_1361 = NL + "                globalMap.put(\"";
  protected final String TEXT_1362 = "_QUERY\", query_";
  protected final String TEXT_1363 = ".toString().trim());";
  protected final String TEXT_1364 = NL + "        \t";
  protected final String TEXT_1365 = NL + "    \t\tpstmt_";
  protected final String TEXT_1366 = ".addBatch();" + NL + "\t\t\t" + NL + "    \t\t  ";
  protected final String TEXT_1367 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_1368 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_1369 = "    \t\t" + NL + "    \t\t";
  protected final String TEXT_1370 = NL + "            try {" + NL + "        \t    deletedCount_";
  protected final String TEXT_1371 = " = deletedCount_";
  protected final String TEXT_1372 = " + pstmt_";
  protected final String TEXT_1373 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1374 = " = true;";
  protected final String TEXT_1375 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1376 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1377 = NL + "                    throw(e);";
  protected final String TEXT_1378 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1379 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1380 = NL + "                        ";
  protected final String TEXT_1381 = " = new ";
  protected final String TEXT_1382 = "Struct();";
  protected final String TEXT_1383 = NL + "                            ";
  protected final String TEXT_1384 = ".";
  protected final String TEXT_1385 = " = ";
  protected final String TEXT_1386 = ".";
  protected final String TEXT_1387 = ";" + NL + "                            ";
  protected final String TEXT_1388 = NL + "                        rejectedCount_";
  protected final String TEXT_1389 = " =  rejectedCount_";
  protected final String TEXT_1390 = "+ 1;";
  protected final String TEXT_1391 = NL + "                        ";
  protected final String TEXT_1392 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1393 = NL + "                        ";
  protected final String TEXT_1394 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1395 = ";" + NL + "                       ";
  protected final String TEXT_1396 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1397 = NL + "            }";
  protected final String TEXT_1398 = NL + "            nb_line_";
  protected final String TEXT_1399 = "++;" + NL + "        \t";
  protected final String TEXT_1400 = NL + "                    ";
  protected final String TEXT_1401 = NL + "                        query_";
  protected final String TEXT_1402 = " = ";
  protected final String TEXT_1403 = ";";
  protected final String TEXT_1404 = NL + "                globalMap.put(\"";
  protected final String TEXT_1405 = "_QUERY\", query_";
  protected final String TEXT_1406 = ".toString().trim());";
  protected final String TEXT_1407 = NL + "            int replaceCount_";
  protected final String TEXT_1408 = " = 0;" + NL + "            try {" + NL + "                replaceCount_";
  protected final String TEXT_1409 = " = pstmt_";
  protected final String TEXT_1410 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1411 = " = true;";
  protected final String TEXT_1412 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1413 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1414 = NL + "                    throw(e);";
  protected final String TEXT_1415 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1416 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1417 = NL + "                        ";
  protected final String TEXT_1418 = " = new ";
  protected final String TEXT_1419 = "Struct();";
  protected final String TEXT_1420 = NL + "                            ";
  protected final String TEXT_1421 = ".";
  protected final String TEXT_1422 = " = ";
  protected final String TEXT_1423 = ".";
  protected final String TEXT_1424 = ";";
  protected final String TEXT_1425 = NL + "                        rejectedCount_";
  protected final String TEXT_1426 = " =  rejectedCount_";
  protected final String TEXT_1427 = "+ 1;";
  protected final String TEXT_1428 = NL + "                        ";
  protected final String TEXT_1429 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1430 = NL + "                        ";
  protected final String TEXT_1431 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1432 = ";";
  protected final String TEXT_1433 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1434 = "                " + NL + "            }" + NL + "            if(replaceCount_";
  protected final String TEXT_1435 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1436 = " += replaceCount_";
  protected final String TEXT_1437 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1438 = " += 1;" + NL + "                deletedCount_";
  protected final String TEXT_1439 = " += replaceCount_";
  protected final String TEXT_1440 = " - 1;" + NL + "            }";
  protected final String TEXT_1441 = NL + "                    ";
  protected final String TEXT_1442 = NL + "                        query_";
  protected final String TEXT_1443 = " = ";
  protected final String TEXT_1444 = ";";
  protected final String TEXT_1445 = NL + "                    ";
  protected final String TEXT_1446 = NL + "                        query_";
  protected final String TEXT_1447 = " = ";
  protected final String TEXT_1448 = ";";
  protected final String TEXT_1449 = NL + "                globalMap.put(\"";
  protected final String TEXT_1450 = "_QUERY\", query_";
  protected final String TEXT_1451 = ".toString().trim());";
  protected final String TEXT_1452 = NL + "            int count_on_duplicate_key_";
  protected final String TEXT_1453 = " = 0;" + NL + "            try {" + NL + "                count_on_duplicate_key_";
  protected final String TEXT_1454 = " = pstmt_";
  protected final String TEXT_1455 = ".executeUpdate();" + NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1456 = " = true;";
  protected final String TEXT_1457 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1458 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1459 = NL + "                    throw(e);";
  protected final String TEXT_1460 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1461 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1462 = NL + "                        ";
  protected final String TEXT_1463 = " = new ";
  protected final String TEXT_1464 = "Struct();";
  protected final String TEXT_1465 = NL + "                            ";
  protected final String TEXT_1466 = ".";
  protected final String TEXT_1467 = " = ";
  protected final String TEXT_1468 = ".";
  protected final String TEXT_1469 = ";";
  protected final String TEXT_1470 = NL + "                        rejectedCount_";
  protected final String TEXT_1471 = " =  rejectedCount_";
  protected final String TEXT_1472 = "+ 1;";
  protected final String TEXT_1473 = NL + "                        ";
  protected final String TEXT_1474 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1475 = NL + "                        ";
  protected final String TEXT_1476 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1477 = ";";
  protected final String TEXT_1478 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1479 = "                " + NL + "            }" + NL + "            if(count_on_duplicate_key_";
  protected final String TEXT_1480 = " == 1) {" + NL + "                insertedCount_";
  protected final String TEXT_1481 = " += count_on_duplicate_key_";
  protected final String TEXT_1482 = ";" + NL + "            } else {" + NL + "                insertedCount_";
  protected final String TEXT_1483 = " += 1;" + NL + "                updatedCount_";
  protected final String TEXT_1484 = " += count_on_duplicate_key_";
  protected final String TEXT_1485 = " - 1;" + NL + "            }";
  protected final String TEXT_1486 = NL + "                        ";
  protected final String TEXT_1487 = NL + "                            query_";
  protected final String TEXT_1488 = " = ";
  protected final String TEXT_1489 = ";";
  protected final String TEXT_1490 = NL + "                    globalMap.put(\"";
  protected final String TEXT_1491 = "_QUERY\", query_";
  protected final String TEXT_1492 = ".toString().trim());";
  protected final String TEXT_1493 = NL + "                try {" + NL + "                    nb_line_";
  protected final String TEXT_1494 = "++;" + NL + "                    insertedCount_";
  protected final String TEXT_1495 = " = insertedCount_";
  protected final String TEXT_1496 = " + pstmt_";
  protected final String TEXT_1497 = ".executeUpdate();" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_1498 = " = true;";
  protected final String TEXT_1499 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1500 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1501 = NL + "                        throw(e);";
  protected final String TEXT_1502 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1503 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1504 = NL + "                            ";
  protected final String TEXT_1505 = " = new ";
  protected final String TEXT_1506 = "Struct();";
  protected final String TEXT_1507 = NL + "                                ";
  protected final String TEXT_1508 = ".";
  protected final String TEXT_1509 = " = ";
  protected final String TEXT_1510 = ".";
  protected final String TEXT_1511 = ";";
  protected final String TEXT_1512 = NL + "                            rejectedCount_";
  protected final String TEXT_1513 = " =  rejectedCount_";
  protected final String TEXT_1514 = "+ 1;";
  protected final String TEXT_1515 = NL + "                            ";
  protected final String TEXT_1516 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1517 = NL + "                            ";
  protected final String TEXT_1518 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1519 = ";";
  protected final String TEXT_1520 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_1521 = NL + "                }";
  protected final String TEXT_1522 = NL + "                log4jSb_";
  protected final String TEXT_1523 = ".append(";
  protected final String TEXT_1524 = ".";
  protected final String TEXT_1525 = ");";
  protected final String TEXT_1526 = NL + "                \tlog4jSb_";
  protected final String TEXT_1527 = ".append(\"|\");";
  protected final String TEXT_1528 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_1529 = " - Writing the record \" + nb_line_";
  protected final String TEXT_1530 = " + \" \" + log4jSb_";
  protected final String TEXT_1531 = ");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_1532 = ".delete(0,log4jSb_";
  protected final String TEXT_1533 = ".length());" + NL + "\t\t";
  protected final String TEXT_1534 = NL + "            if(!whetherReject_";
  protected final String TEXT_1535 = ") {";
  protected final String TEXT_1536 = NL + "                            ";
  protected final String TEXT_1537 = " = new ";
  protected final String TEXT_1538 = "Struct();";
  protected final String TEXT_1539 = NL + "                                ";
  protected final String TEXT_1540 = ".";
  protected final String TEXT_1541 = " = ";
  protected final String TEXT_1542 = ".";
  protected final String TEXT_1543 = ";";
  protected final String TEXT_1544 = NL + "            }";
  protected final String TEXT_1545 = NL + "    \t\t\tif ( batchSize_";
  protected final String TEXT_1546 = " <= batchSizeCounter_";
  protected final String TEXT_1547 = ") {                ";
  protected final String TEXT_1548 = "                                                " + NL + "                try {" + NL + "\t\t\t\t\t\tint countSum_";
  protected final String TEXT_1549 = " = 0;" + NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1550 = ": pstmt_";
  protected final String TEXT_1551 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1552 = " += (countEach_";
  protected final String TEXT_1553 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1554 = ");" + NL + "\t\t\t\t\t\t}                  \t" + NL + "            \t    \t";
  protected final String TEXT_1555 = NL + "            \t    \tinsertedCount_";
  protected final String TEXT_1556 = " += countSum_";
  protected final String TEXT_1557 = ";" + NL + "            \t    \t";
  protected final String TEXT_1558 = "                         \t    \t" + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1559 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1560 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1561 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1562 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1563 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1564 = NL + "                \tint countSum_";
  protected final String TEXT_1565 = " = 0;" + NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1566 = ": e.getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1567 = " += (countEach_";
  protected final String TEXT_1568 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1569 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1570 = NL + "            \t    insertedCount_";
  protected final String TEXT_1571 = " += countSum_";
  protected final String TEXT_1572 = ";" + NL + "\t    \t    \t";
  protected final String TEXT_1573 = "  " + NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1574 = NL + "                }";
  protected final String TEXT_1575 = "    " + NL + "                \t\t\t" + NL + "    \t\t\tbatchSizeCounter_";
  protected final String TEXT_1576 = " = 0;" + NL + "    \t\t}" + NL + "    \t\t";
  protected final String TEXT_1577 = NL + "    \t\t\tif ( batchSize_";
  protected final String TEXT_1578 = " <= batchSizeCounter_";
  protected final String TEXT_1579 = ") {                ";
  protected final String TEXT_1580 = "                                                " + NL + "                try {" + NL + "\t\t\t\t\t\tint countSum_";
  protected final String TEXT_1581 = " = 0;" + NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1582 = ": pstmt_";
  protected final String TEXT_1583 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1584 = " += (countEach_";
  protected final String TEXT_1585 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1586 = ");" + NL + "\t\t\t\t\t\t}              \t" + NL + "            \t    \t";
  protected final String TEXT_1587 = NL + "            \t    \tupdatedCount_";
  protected final String TEXT_1588 = " += countSum_";
  protected final String TEXT_1589 = ";" + NL + "            \t    \t";
  protected final String TEXT_1590 = NL + "            \t    \tdeletedCount_";
  protected final String TEXT_1591 = " += countSum_";
  protected final String TEXT_1592 = ";" + NL + "            \t    \t";
  protected final String TEXT_1593 = "                         \t    \t" + NL + "            \t    \tbatchSizeCounter_";
  protected final String TEXT_1594 = " = 0;             \t                \t                \t" + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1595 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1596 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1597 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1598 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1599 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1600 = NL + "                \tint countSum_";
  protected final String TEXT_1601 = " = 0;" + NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1602 = ": e.getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1603 = " += (countEach_";
  protected final String TEXT_1604 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1605 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1606 = NL + "            \t    updatedCount_";
  protected final String TEXT_1607 = " += countSum_";
  protected final String TEXT_1608 = ";" + NL + "            \t    ";
  protected final String TEXT_1609 = NL + "            \t    deletedCount_";
  protected final String TEXT_1610 = " += countSum_";
  protected final String TEXT_1611 = ";" + NL + "            \t    ";
  protected final String TEXT_1612 = NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1613 = NL + "                }";
  protected final String TEXT_1614 = "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_1615 = NL + "        \t    commitCounter_";
  protected final String TEXT_1616 = "++;" + NL + "       " + NL + "                if(commitEvery_";
  protected final String TEXT_1617 = " <= commitCounter_";
  protected final String TEXT_1618 = ") {" + NL + "                ";
  protected final String TEXT_1619 = NL + "                try {" + NL + "                \t\tint countSum_";
  protected final String TEXT_1620 = " = 0;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1621 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1622 = " - Executing the ";
  protected final String TEXT_1623 = " batch.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1624 = NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1625 = ": pstmt_";
  protected final String TEXT_1626 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1627 = " += (countEach_";
  protected final String TEXT_1628 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1629 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1630 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1631 = " - The ";
  protected final String TEXT_1632 = " batch execution has succeeded.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1633 = NL + "            \t    \t";
  protected final String TEXT_1634 = NL + "            \t    \tinsertedCount_";
  protected final String TEXT_1635 = " += countSum_";
  protected final String TEXT_1636 = ";" + NL + "            \t    \t";
  protected final String TEXT_1637 = "            \t    \t\t" + NL + "            \t    \tupdatedCount_";
  protected final String TEXT_1638 = " += countSum_";
  protected final String TEXT_1639 = ";" + NL + "            \t    \t";
  protected final String TEXT_1640 = NL + "            \t    \tdeletedCount_";
  protected final String TEXT_1641 = " += countSum_";
  protected final String TEXT_1642 = ";" + NL + "            \t    \t";
  protected final String TEXT_1643 = "            \t    " + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_1644 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_1645 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1646 = NL + "\t\t\t\t\t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_1647 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_1648 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1649 = NL + "                \tint countSum_";
  protected final String TEXT_1650 = " = 0;" + NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_1651 = ": e.getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_1652 = " += (countEach_";
  protected final String TEXT_1653 = " < 0 ? 0 : countEach_";
  protected final String TEXT_1654 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1655 = NL + "        \t    \tinsertedCount_";
  protected final String TEXT_1656 = " += countSum_";
  protected final String TEXT_1657 = ";" + NL + "        \t    \t";
  protected final String TEXT_1658 = "            \t    \t\t" + NL + "        \t    \tupdatedCount_";
  protected final String TEXT_1659 = " += countSum_";
  protected final String TEXT_1660 = ";" + NL + "        \t    \t";
  protected final String TEXT_1661 = NL + "        \t    \tdeletedCount_";
  protected final String TEXT_1662 = " += countSum_";
  protected final String TEXT_1663 = ";" + NL + "        \t    \t";
  protected final String TEXT_1664 = NL + "                    System.out.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_1665 = NL + "                " + NL + "                }            \t                              ";
  protected final String TEXT_1666 = NL + "\t\t\t\t\t";
  protected final String TEXT_1667 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1668 = " - Starting to commit \" + commitCounter_";
  protected final String TEXT_1669 = " + \" records.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1670 = NL + "\t\t        \tconn_";
  protected final String TEXT_1671 = ".commit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_1672 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_1673 = " - Commit has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_1674 = NL + "                \t" + NL + "                \tcommitCounter_";
  protected final String TEXT_1675 = "=0;" + NL + "                " + NL + "                }\t" + NL + "    ";
  protected final String TEXT_1676 = NL;

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
	public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
			if(this.getColumn()!=null) {
				if (this.getColumn().getTalendType().equals("id_Geometry")) {
				    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
	    			    return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
					return this.sqlStmt;
				}
			} else {
				return this.sqlStmt;
			}
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient

        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
    	  return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
    	  return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        protected int dynamicColumnLocation = -1;

        private int getDynamicColumnOriginalLocation() {
            if(node == null) return -1;
            List<IMetadataTable> metadatas = node.getMetadataList();
            if(metadatas != null && metadatas.size() > 0) {
                IMetadataTable metadata = metadatas.get(0);
                if(metadata != null) {
                    List<IMetadataColumn> columnList = metadata.getListColumns();
                    if(columnList == null ||!metadata.isDynamicSchema()) {
                        return -1;
                    }
                    
                    int result = -1;
                    for(IMetadataColumn column : columnList){
                        result++;
                        if("id_Dynamic".equals(column.getTalendType())){
                            return result;
                        }
                    }
                }
            }
            return -1;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {//columnList that contain all columns except dynamic column
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            String dynamicEnding = ending;
            if(dynamicColumnLocation == 0) {//dynamic is first
                createSQL.append(" {TALEND_DYNAMIC_COLUMN} ");
                if(columnList.size() > 0) {
                    createSQL.append(ending);
                }
            }
            
            for (Column column : columnList) {
                
                if(dynamicColumnLocation > 0 && count == dynamicColumnLocation) {//dynamic is in middle
                    createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                }
                
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if("oracle_id".equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                        	// move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                    		if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                    			String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                        		int index = pkList.indexOf(columnStr);
                        		if(index !=-1){
                    				for (int i=index;i>0;i--) {
                    					pkList.set(i, pkList.get(i-1));
                    				}
                    				pkList.set(0, columnStr);
                        		}
                    		}
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if(dynamicColumnLocation > 0 && dynamicColumnLocation == columnList.size()) {//dynamic is last and not first
                createSQL.append(dynamicEnding).append(" {TALEND_DYNAMIC_COLUMN} ");
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        protected String getAutoIncrement(int startValue, int step) {
        	if("sybase_id".equalsIgnoreCase(getDBMSId())){
        		return " IDENTITY NOT NULL";
        	} else if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
        		return " AUTO_INCREMENT";
        	} else if("ibmdb2_id".equalsIgnoreCase(getDBMSId())){
        		return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
        	} else {
        		return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
        	}
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        //the method is called only by tOracleBulkExec,tSybaseBulkExec,tIngreBulkExec end part and no use for them,so we should delete it
        public List<Column> createColumnList(List<IMetadataColumn> columnList, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();
            for(IMetadataColumn column : columnList) {
                Column skeletonColumn = getColumn(column);
                skeletonColumn.setOperator("=");
                stmtStructure.add(skeletonColumn);
            }
            for(IMetadataColumn column : columnList) {
                if(addCols != null && addCols.size() > 0) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;      
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacedCol.replace(replacementCol);
                            }
                        }                        
                    }
                }
            }
            return stmtStructure;
        }
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.getColumnName().equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
				Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
				skeletonColumn.setOperator("=");
				skeletonColumn.setDataType(column.getType());
				stmtStructure.add(skeletonColumn);
				
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnLocation = -1;
            //TODO public getColumnList and public createColumnList should merge to one public method
            //reset the dynamic cloumn to original location in the columns.
            int dynamicColumnOriginalLocation = getDynamicColumnOriginalLocation();
            if(dynamicColumnOriginalLocation!=-1) {//dynamic exist
                int currentDynamicColumnLocation = -1;
                for(int i=0;i<stmtStructure.size();i++) {
                    Column column = stmtStructure.get(i);
                    if(column.isDynamic()) {
                        currentDynamicColumnLocation = i;
                        break;
                    }
                }
                
                Column dynamicColumn = stmtStructure.remove(currentDynamicColumnLocation);
                stmtStructure.add(dynamicColumnOriginalLocation,dynamicColumn);
            }
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                            }                            
                        }
                    }
                }
            }
            
            //get the dynamic column location after add columns
            for(int i=0;i<stmtStructure.size();i++) {
                Column column = stmtStructure.get(i);
                if(column.isDynamic()) {
                    dynamicColumnLocation = i;
                    break;
                }
            }
            //remove the single dynamic column from the result
            if(dynamicColumnLocation > -1) {
                stmtStructure.remove(dynamicColumnLocation);
            }
            
            return stmtStructure;
        }
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
            	actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
            	actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
            	actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
            	actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
            	actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
            	actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
            	actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
            	actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
            	actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
	            for(Column column : stmtStructure) {
	            	if(column.isReplaced()) {
	                    List<Column> replacedColumns = column.getReplacement();
	                    for(Column replacedColumn : replacedColumns) {
	                        actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
	                    }
	                } else {
	                    actionSQLMap = processSQLClause(column, actionSQLMap);        
	                }
	            }
            }
            return actionSQLMap;
        }
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            if(column.isInsertable()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
		
		public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
			return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null);	
		}
		
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
			} else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
        		} else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
		
		public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
			return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null);	
		}
		
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
            	}
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
            	}               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
            		if (index == 1) {
            			return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            		} else {
            			return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            		}
            }else {
            	if (index == 1) {
            		return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            	} else {
            		return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
            	}
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
        	if (index == 1) {
        		return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
        	} else {
        		return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+index+"])";
        	}
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            System.out.println(column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable());
            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        }     
        
		public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
				String fieldDelimiter, 
				String newLineChar,
				String nullIndicator) {
		return null;
			
		}
		
		public String generateCode4TabelExist() {
		    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
		    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		    StringBuilder code = new StringBuilder();  
		    code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
		    if (hasSchema()) {
    		    code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
    		    code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
    		    code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
    		    code.append("} else {\r\n");
    		    code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
    		    code.append("}\r\n");
		    }
		    return code.toString();
		}
		
		protected String getTableName4Search(boolean useExistingConnection, String connection) {
		    return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
		}
		
	    protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
	    }

	    /*
	     * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
	     * this because of some db default add getLProtectedChar() and getRProtectedChar() to schaem when create table. e.g:db2
	     * 
	     * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
	    */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }	
        
        protected boolean hasSchema() {
            return false;
        }
	    
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
            	if (typeToGenerate.equals("Long")) {
            		setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
            	} else {
            		setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            	}
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
        	return "1";
        }
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName()
                    + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            String dynamicEnding = ending;
            if(dynamicColumnLocation == 0) {//dynamic is first
                createSQL.append(" {TALEND_DYNAMIC_COLUMN} ");
                if(columnList.size() > 0) {
                    createSQL.append(ending);
                }
            }
            
            for (Column column : columnList) {
            
                if(dynamicColumnLocation > 0 && count == dynamicColumnLocation) {//dynamic is in middle
                    createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                }
                
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if(dynamicColumnLocation > 0 && dynamicColumnLocation == columnList.size()) {//dynamic is last and not first
                createSQL.append(dynamicEnding).append(" {TALEND_DYNAMIC_COLUMN} ");
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
            	createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
    	String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isHSQLDBKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isHSQLDBKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
    }
	
	public class HiveManager extends Manager {
    	String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isHiveKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isHiveKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
    	boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
        	this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
    	public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
				String recordDelimiter, String nullIndicator) {		
    		StringBuilder copyBulkSQL = new StringBuilder();
			copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
			copyBulkSQL.append(" (\"+");	            
			int counter = 0;
			for(IMetadataColumn column : columnList) {
				counter++;
				// add each table field and separator
				copyBulkSQL.append( 
				"\n\"\\n" +
				  column.getOriginalDbColumnName() 
				+ "="
				+ (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
			
				// add these only if not last entry
				if (counter < columnList.size()){
					copyBulkSQL.append(
					//convertDelim(fieldDelimiter)
					fieldDelimiter
					+ (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
					+ " ,"
					+ "\""
					+ "+"
					);
				} else {
					copyBulkSQL.append(
					recordDelimiter
					+ (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
					);
					copyBulkSQL.append(")");
				}     	
			} 
			return copyBulkSQL.toString();
		} 

    	public String getTruncateTableSQL() {
    		StringBuilder truncateTableSQL = new StringBuilder();
    		truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
    		+ cid + " + \"\\\" TO TRUNCATED");
    		return truncateTableSQL.toString();
		}				        
    }
    
    public class VectorWiseManager extends IngresManager {
		public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
	}	
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
        	return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + index + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
			
			if(dynamic==null) {
				dynamic="";
			} else {
				dynamic+=cid;
			}
			
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
            	}
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                	setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
            	}               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                	MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
					dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){
                	String pattern = column.getColumn().getPattern();
                	setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                	if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                	   setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                	}
                	setStmt.append("}else{\r\n");
					setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
					if("DATETIMEOFFSET".equals(dbType)) {
						setStmt.append(",calendar_datetimeoffset_").append(cid);
					}
					setStmt.append(");\r\n");
                	setStmt.append("}\r\n");
                }else{
                	setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                	if("DATETIMEOFFSET".equals(dbType)) {
						setStmt.append(",calendar_datetimeoffset_").append(cid);
					}
                	setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            String dynamicEnding = ending;
            if(dynamicColumnLocation == 0) {//dynamic is first
                createSQL.append(" {TALEND_DYNAMIC_COLUMN} ");
                if(columnList.size() > 0) {
                    createSQL.append(ending);
                }
            }
            
            for (Column column : columnList) {

                if(dynamicColumnLocation > 0 && count == dynamicColumnLocation) {//dynamic is in middle
                    createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                }
                
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if(dynamicColumnLocation > 0 && dynamicColumnLocation == columnList.size()) {//dynamic is last and not first
                createSQL.append(dynamicEnding).append(" {TALEND_DYNAMIC_COLUMN} ");
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                setStmt.append("} else {");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
    	  private String[] oracleKeyWords= {
    		    	"ACCESS" ,"AUDIT","COMPRESS","DESC" , 
    		    	"ADD","CONNECT","DISTINCT" ,
    		    	"ALL","BY","CREATE","DROP",
    		    	"ALTER","CHAR","CURRENT","ELSE",
    		    	"AND","CHECK","DATE","EXCLUSIVE",
    		    	"ANY","CLUSTER","DECIMAL","	EXISTS",
    		    	"AS","COLUMN","DEFAULT","FILE",
    		    	"ASC","COMMENT","DELETE","FLOAT",
    		    	"FOR","LONG","PCTFREE","SUCCESSFUL",
    		    	"FROM","MAXEXTENTS","PRIOR","SYNONYM",
    		    	"GRANT","MINUS","PRIVILEGES","SYSDATE",
    		    	"GROUP","MODE","PUBLIC","TABLE",
    		    	"HAVING","MODIFY","RAW","THEN",
    		    	"IDENTIFIED","NETWORK","RENAME","TO",
    				"IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
    				"IN","NOCOMPRESS","REVOKE","UID",
    				"INCREMENT","NOT","ROW","UNION",
    				"INDEX","NOWAIT","ROWID","UNIQUE",
    				"INITIAL","NULL","ROWNUM","UPDATE",
    				"INSERT","NUMBER","ROWS","USER",
    				"INTEGER","OF","SELECT","VALIDATE",
    				"INTERSECT","OFFLINE","SESSION","VALUES",
    				"INTO","ON","SET","VARCHAR",
    				"IS","ONLINE","SHARE","VARCHAR2",
    				"LEVEL","OPTION","SIZE","VIEW",
    				"LIKE","OR","SMALLINT","WHENEVER",
    				"LOCK","ORDER","START","WHERE","WITH"
    		    	};
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
        		} else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__").equals("true")) {
                        setStmt.append(prefix + cid + ".setDate(" + index + ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                	   setStmt.append(prefix + cid + ".setObject(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("XMLTYPE"))) {
                setStmt.append("if (" + incomingConnName + "." + column.getName() + " instanceof String) {\r\n");
                setStmt.append(prefix + cid + ".setObject(" + index + ",  xmlTypeUtil_" + cid + ".getCLOB((String)" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                setStmt.append("}\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
			boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
			if(convertToUppercase){
				return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
			}else{
				return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
			}
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
			String columnName = column.getColumnName();
			String dataType = column.getDataType();
			if(dataType!=null)
			{
			boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
			if(trimChar && "char".equals(dataType.toLowerCase()))
			{
				columnName = "trim("+columnName+")";
			}
			}
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class GreenplumManager extends PostgrePlusManager {
    	 public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
    	 private String[] sybaseKeyWords= {
    			 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
 		    	"ADD","CONNECT","COUNT","DISTINCT" ,
 		    	"ALL","BY","CREATE","DROP",
 		    	"ALTER","CHAR","CURRENT","ELSE",
 		    	"AND","CHECK","DATE","EXCLUSIVE",
 		    	"ANY","CLUSTER","DECIMAL","	EXISTS",
 		    	"AS","COLUMN","DEFAULT","FILE",
 		    	"ASC","COMMENT","DELETE","FLOAT",
 		    	"FOR","LONG","PCTFREE","SUCCESSFUL",
 		    	"FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
 		    	"GRANT","MINUS","PRIVILEGES","SYSDATE",
 		    	"GROUP","MODE","PUBLIC","TABLE",
 		    	"HAVING","MODIFY","RAW","THEN",
 		    	"IDENTIFIED","NETWORK","RENAME","TO",
 				"IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
 				"IN","NOCOMPRESS","REVOKE","UID",
 				"INCREMENT","NOT","ROW","UNION",
 				"INDEX","NOWAIT","ROWID","UNIQUE",
 				"INITIAL","NULL","ROWNUM","UPDATE",
 				"INSERT","NUMBER","ROWS","USER",
 				"INTEGER","OF","SELECT","VALIDATE",
 				"INTERSECT","OFFLINE","SESSION","VALUES",
 				"INTO","ON","SET","VARCHAR",
 				"IS","ONLINE","SHARE",
 				"LEVEL","OPTION","SIZE","VIEW",
 				"LIKE","OR","SMALLINT","WHENEVER",
 				"LOCK","ORDER","START","WHERE","WITH"
    			 
    	 };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                	return true;
                }
            }
        	return false;
        }
        protected String getLProtectedChar(String keyword) {
        	if (isSybaseKeyword(keyword)){
        		return "\\\"";
        	}
        	return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
        	if (isSybaseKeyword(keyword)){
        		return "\\\"";
        	}
        	return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal") && column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
			} else if(typeToGenerate.equals("Geometry")) {
            	setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
				setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            String dynamicEnding = ending;
            if(dynamicColumnLocation == 0) {//dynamic is first
                createSQL.append(" {TALEND_DYNAMIC_COLUMN} ");
                if(columnList.size() > 0) {
                    createSQL.append(ending);
                }
            }
            
            for (Column column : columnList) {

                if(dynamicColumnLocation > 0 && count == dynamicColumnLocation) {//dynamic is in middle
                    createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                }
                
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if(dynamicColumnLocation > 0 && dynamicColumnLocation == columnList.size()) {//dynamic is last and not first
                createSQL.append(dynamicEnding).append(" {TALEND_DYNAMIC_COLUMN} ");
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getLabel() + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            String dynamicEnding = ending;
            if(dynamicColumnLocation == 0) {//dynamic is first
                createSQL.append(" {TALEND_DYNAMIC_COLUMN} ");
                if(columnList.size() > 0) {
                    createSQL.append(ending);
                }
            }
            
            for (Column column : columnList) {
            
                if(dynamicColumnLocation > 0 && count == dynamicColumnLocation) {//dynamic is in middle
                    createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                }
                
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (column.isAddCol()) {
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        if (count == columnList.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if(dynamicColumnLocation > 0 && dynamicColumnLocation == columnList.size()) {//dynamic is last and not first
                createSQL.append(dynamicEnding).append(" {TALEND_DYNAMIC_COLUMN} ");
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
   	 	public ExasolManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }  
   }
    public class UnDefinedManager extends Manager{
    	
    	private String dbmsId = "";
    	
    	public UnDefinedManager(String cid) {
            super(cid);
        }
    	public void setDBMSId(String dbmsId){
    		this.dbmsId = dbmsId;
    	}
    	protected String getDBMSId() {
            return this.dbmsId;
        }
    	protected String getLProtectedChar() {
    		return "";
    	}
    	protected String getRProtectedChar() {
    		return "";
    	}
    }
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                List<IMetadataColumn> columnList2 = metadata.getListColumns();
                if( columnList2 == null || columnList2.size()<2 ||!metadata.isDynamicSchema() || "id_Dynamic".equals(columnList2.get(columnList2.size()-1).getTalendType())){
                    return columnList2;
                }else{
                    columnList = new java.util.ArrayList<IMetadataColumn>();
                    IMetadataColumn dyncolumn = null;
                    for(IMetadataColumn column:columnList2){
                        if(column.getTalendType().equals("id_Dynamic")){
                            dyncolumn = column;
                        }else{
                            columnList.add(column);
                        }
                    }
                    columnList.add(dyncolumn);
                }
            }
        }
        return columnList;
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
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

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_96);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	IProcess process = node.getProcess();
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");
	List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");
	
    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
    
    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");
    
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    
    boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));
        
        //to fixed: bug8422
        if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))||(!("INSERT").equals(dataAction))){
        	extendedInsert = false;
        }    
    
    String numPerInsert = ElementParameterParser.getValue(node, "__NB_ROWS_PER_INSERT__");
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
	
	//feature:2880
    getManager(dbmsId, cid, node);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
	
	boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	String batchSize=ElementParameterParser.getValue(node,"__BATCH_SIZE__");
	
	String incomingConnName = null;
	List<IMetadataColumn> columnList = getColumnList(node);
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
		
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    IConnection rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumnList = metadataTable.getListColumns();	    
	}
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
          
        }
    }
	
	List<Column> stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
	
	Manager manager = null;
	boolean isDynamic = false;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		isDynamic = metadata.isDynamicSchema(); 
	}
	
	if(isDynamic) {
	
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
		///// hint options/////
boolean useHintOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_HINT_OPTIONS__"));
Map<String, String> hintsValues = null; 
if (useHintOptions) {
	List<Map<String, String>> hintOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HINT_OPTIONS__");
	hintsValues = new HashMap<String, String>();
	String hintValue = null;
	boolean firstInsert = true;
	boolean firstUpdate = true;
	boolean firstDelete = true;
	boolean firstTableName = true;
	for(java.util.Map<String, String> option : hintOptions) {
		//get
		hintValue = option.get("HINT");	
		//set
		if ("INSERT".equalsIgnoreCase(option.get("SQL_STMT"))){
			if(firstInsert){
				hintsValues.put("INSERT", hintValue) ;
				firstInsert = false;
			}else {
				hintsValues.put("INSERT", hintsValues.get("INSERT") + "+" + hintValue) ;
			}									
		}else if ("UPDATE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if(firstUpdate){
				hintsValues.put("UPDATE", hintValue) ;
				firstUpdate = false;
			}else {
				hintsValues.put("UPDATE", hintsValues.get("UPDATE") + "+" + hintValue) ;
			}
		}else if ("DELETE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if (firstDelete){
				hintsValues.put("DELETE", hintValue) ;
				firstDelete =false;
			}else {
				hintsValues.put("DELETE", hintsValues.get("DELETE") + "+" + hintValue) ;
			}		
		}
	}
} 
//// hint options end ////

if(columnList != null && columnList.size() > 0) {
    
    stringBuffer.append(TEXT_102);
      
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean isLog4jEnabled_tableAction = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	manager = getManager(dbmsId, cid);
	String ending="";
	
	if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
		ending="WITH STRUCTURE = VECTORWISE";
	}

	if(!("NONE").equals(tableAction)) {

        if(("DROP_CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_128);
    
				}
			} else {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_131);
    
			}

    stringBuffer.append(TEXT_132);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    				

        } else if(("CREATE").equals(tableAction)) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_150);
    
				}
			} else {

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_153);
    
			}

    stringBuffer.append(TEXT_154);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
        	boolean tableNameCaseSensitive=false;
    		if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
    			tableNameCaseSensitive=true;
    		}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_160);
    //bug22719: informix use independent connection, should remove this code after use shared connection
		    if(INFORMIX.equalsIgnoreCase(dbmsId)){
			    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
	    		String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
			    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
				String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
				String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
		    
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_168);
    }else{
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    
			}

    stringBuffer.append(TEXT_177);
     
			/*
				case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
				so in mssql use "Select" checked the table whether exist.
			*/
			//TODO we will use like "select" sql intead of use system table to checked table?
			if(MSSQL.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
			} else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {

    stringBuffer.append(TEXT_187);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
			} else if ( SYBASE.equalsIgnoreCase(dbmsId)
						|| INFORMIX.equalsIgnoreCase(dbmsId) ) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    			
			} else if( DB2.equalsIgnoreCase(dbmsId) ){

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
			} else if ( GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId)) {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
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
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_274);
    }
    stringBuffer.append(TEXT_275);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_278);
    }
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_284);
    }
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    			
			} else {

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
			}

    
            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {

    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_312);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_315);
    
				}
			} else {

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_318);
    
			}

    stringBuffer.append(TEXT_319);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    }
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
            } else {

    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    }
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_334);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    }
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    }
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					String query=manager.getCreateTableSQL(stmtStructure);

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_348);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_350);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_351);
    
				}
			} else {

    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_354);
    
			}

    stringBuffer.append(TEXT_355);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    }
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
			}

    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    
			}

    stringBuffer.append(TEXT_363);
    
        } else if(("CLEAR").equals(tableAction)) {

    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    }
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_372);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    }
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    
        }else if(("TRUNCATE").equals(tableAction)) {

    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    }
    stringBuffer.append(TEXT_389);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    }
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_394);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    }
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    
		} else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {

    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    }
    stringBuffer.append(TEXT_416);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    }
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_421);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    }
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
	}
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
    Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
    StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);   
    StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);    
    StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);    
    StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
    StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
    
    boolean supportDuplicateUpdate = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__ON_DUPLICATE_KEY_UPDATE__"));
    
	if(("INSERT").equals(dataAction)) {
	
		if (supportDuplicateUpdate) {
			List<Map<String, String>> duplicateKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue( node,"__DUPLICATED_KEYS__" );
			          			
			if (duplicateKeys.size() > 0) {
			
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    
				for (int i=0; i< duplicateKeys.size() ; i++) {
					if (i >0) {
					
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    
					}
					
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_KEY"));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(duplicateKeys.get(i).get("DUPLICATED_VALUE"));
    stringBuffer.append(TEXT_441);
    
				}
			}
		}

    stringBuffer.append(TEXT_442);
    				       
		    if(!extendedInsert) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);

					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_446);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_447);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_450);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_451);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_452);
    					} else {

    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_456);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_459);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_460);
    
					}
				}
			
		        
    	
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    	
				}

    stringBuffer.append(TEXT_464);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    }
    stringBuffer.append(TEXT_473);
    
                //to fixed: bug8422
                if(!(cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    }
    stringBuffer.append(TEXT_478);
    
                //to fixed: bug8422
                if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){ 
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    }
    stringBuffer.append(TEXT_492);
    
	    } else {//extended-insert mode(begin)
	    	if ("MYSQL_4".equals(dbVersion)) {

    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_495);
    
			if(isDynamic) {
			     List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			     if(conns_dynamic!=null && conns_dynamic.size()>0){
			     	IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_498);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_499);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_500);
    
				}			
			} else {

    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_503);
    
			}

    stringBuffer.append(TEXT_504);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_510);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    					} else {

    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
					}	
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    	
				}

    stringBuffer.append(TEXT_525);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    }
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_541);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_545);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_546);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_547);
    
					} else {

    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_554);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_555);
    
					}
				}
		    if(isDynamic) {

    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    
		    } else {

    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    
		    }
		} else if ("MYSQL_5".equals(dbVersion)) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					IConnection conn = conns_dynamic.get(0);
					if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_563);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_564);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_567);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_568);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_569);
    					} else {

    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_573);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_576);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_577);
    
					}
				}
				if (supportDuplicateUpdate) {

    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    	
				}
				if(isDynamic) {

    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    
				} else {

    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    
				}

    stringBuffer.append(TEXT_589);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    }
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    
	       	} 
	    }//extended-insert mode(end)
	} else if (("UPDATE").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);
			if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_605);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_606);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_609);
    			} else {

    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_613);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_616);
    
			}
		}		
	    
    stringBuffer.append(TEXT_617);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    }
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    		
	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);

				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_633);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_634);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_637);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_638);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_639);
    					} else {

    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_643);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_646);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_647);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_651);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_652);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_655);
    				} else {

    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_659);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_661);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_662);
    
				}
			}
	    
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_670);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_671);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    }
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    }
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    
	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
			List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
			if(conns_dynamic!=null && conns_dynamic.size()>0){
				IConnection conn = conns_dynamic.get(0);

				if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_699);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_700);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_703);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_704);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_705);
    					} else {

    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_709);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_711);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_712);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_713);
    
				}
				if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_717);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_718);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_720);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_721);
    				} else {

    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_725);
    stringBuffer.append(columnList.get(columnList.size()-1));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_727);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_728);
    
				}
			}	
	    
    stringBuffer.append(TEXT_729);
    if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    }
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    }
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_753);
    			
	} else if (("DELETE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_756);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_757);
    if(useHintOptions && hintsValues.get("DELETE") != null) {
  
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(hintsValues.get("DELETE"));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    
  }
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_769);
    		
	} else if(("REPLACE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_773);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_777);
    
	} else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_781);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_782);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    
	} else if(("INSERT_IGNORE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_790);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_791);
    	   
if (useHintOptions && hintsValues.get("INSERT") != null){ 

    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    }
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    
	}
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_808);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_812);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_818);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_826);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_830);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_833);
    
		}

    
    }
}
	
    stringBuffer.append(TEXT_834);
    
	}
	
	
    ////////////////////////////////////////////////////////////
    List<Column> colStruct =  new ArrayList();
    for(Column colStmt : stmtStructure){
    	if(!colStmt.isReplaced() && !colStmt.isAddCol()){
    		colStruct.add(colStmt);
    	}
    }

	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	if(("true").equals(useExistingConn)) {
		List<? extends INode> nodes =  process.getNodesOfType("tMysqlConnection");
		for (INode ne:nodes) {
			if (connection.equals(ne.getUniqueName())) {
				dbVersion = ElementParameterParser.getValue(ne, "__DB_VERSION__");
			}
		}
	} else {
		dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	}

    class ExtendInsertOperation{
        public String generateType(String typeToGenerate){
            if(("byte[]").equals(typeToGenerate)){
                typeToGenerate = "Bytes";
            }else if(("java.util.Date").equals(typeToGenerate)){
                typeToGenerate = "Date";
            }else if(("Integer").equals(typeToGenerate)){
                typeToGenerate = "Int";
            }else if(("List").equals(typeToGenerate)){  
                typeToGenerate = "Object";                 
            }else{
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public void generateSetStmt(String typeToGenerate, Column column, String incomingConnName, String cid){
            boolean isObject = false;                               
            String prefix = "pstmt_";                             
            
    stringBuffer.append(TEXT_835);
    
            if(("Character").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_836);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_838);
    stringBuffer.append(TEXT_839);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_841);
    
            }else if(("Date").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_842);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_844);
    stringBuffer.append(TEXT_845);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_847);
    
            }else if(("byte[]").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_848);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_850);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    
            }else if(("Long").equals(typeToGenerate)||("Byte").equals(typeToGenerate)||("Integer").equals(typeToGenerate)||("Short").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_854);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_856);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_859);
    
            }else if(("String").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_860);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_861);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_862);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_865);
    
            }else if(("Object").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_866);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_868);
    stringBuffer.append(TEXT_869);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_871);
    
            }else if(("Boolean").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_872);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_874);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_877);
    
            }else if(("Double").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_878);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_880);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_883);
    
            }else if(("Float").equals(typeToGenerate)){
                isObject = true;
                
    stringBuffer.append(TEXT_884);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_886);
    stringBuffer.append(TEXT_887);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_889);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_890);
    
            }
            typeToGenerate = generateType(typeToGenerate);
        
            if(("Char").equals(typeToGenerate)||("Character").equals(typeToGenerate)){
                
    
                if(isObject) {
                    
    stringBuffer.append(TEXT_891);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_892);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_893);
    
                } else {
                    
    stringBuffer.append(TEXT_894);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_896);
    
                }
                
    stringBuffer.append(TEXT_897);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_898);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_899);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_901);
    stringBuffer.append(TEXT_902);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(TEXT_905);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_908);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_909);
    
            }else if(("Date").equals(typeToGenerate)){
                
    stringBuffer.append(TEXT_910);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_911);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_913);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_919);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_926);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_928);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_929);
    
            }else{
                
    stringBuffer.append(TEXT_930);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_931);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_935);
    
            }
            if(isObject){
                
    stringBuffer.append(TEXT_936);
    
            }
        }
    }
    
	if(isEnableDebug) {

    stringBuffer.append(TEXT_937);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_938);
    
	}

	boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	
	if (isParallelize) { // bug0014422
		String tAsyncIn_cid = "";
		if(conns!=null && conns.size() > 0) {
			tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
		}
		if(!"true".equals(useExistingConn)) {
	    	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)) {

    stringBuffer.append(TEXT_939);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_940);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_941);
    
	    	}
	    }
	    if ("MYSQL_5".equals(dbVersion)) {
	    	if ((extendedInsert&&"INSERT".equals(dataAction)) || (useBatchSize&&("UPDATE".equals(dataAction)||"DELETE".equals(dataAction)))) {
			    if((!("").equals(numPerInsert)&&!("0").equals(numPerInsert))
			    	||(!("").equals(batchSize)&&!("0").equals(batchSize))) {

    stringBuffer.append(TEXT_942);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_944);
    
			    }
	    	}
    	}

    stringBuffer.append(TEXT_945);
    
	}

    if(incomingConnName != null && columnList != null){
        
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_947);
    	
        if(("INSERT").equals(dataAction)) {
            if(extendedInsert) {//extended-insert mode(begin)
            	if ("MYSQL_4".equals(dbVersion)) {
	                ExtendInsertOperation eiOperation = new ExtendInsertOperation(); 
	                int insertableCount = 0;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        insertableCount++;
	                    }
	                }
			if(!isDynamic) {
	                
    stringBuffer.append(TEXT_948);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_950);
    stringBuffer.append(insertableCount);
    stringBuffer.append(TEXT_951);
    
			}   
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
	                        eiOperation.generateSetStmt(typeToGenerate,column,incomingConnName,cid);
	                        
    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_953);
    
	                    }
	                }
					if(isDynamic) {
						Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
						if("Dynamic".equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_955);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_957);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_958);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_959);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_960);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_961);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_962);
    
						}
					}
	                
    stringBuffer.append(TEXT_963);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_964);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_965);
     
	                int count =0;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        if(count != 0) {
	                            
    stringBuffer.append(TEXT_966);
    
	                        }                        
	                        
    stringBuffer.append(TEXT_967);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_969);
                            
	                        count++;                    
	                    }   
	                }
			if(isDynamic) {
			    	Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_970);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_971);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_972);
    
				}
			    }
	                
    stringBuffer.append(TEXT_973);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_974);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_976);
    
			if(isDynamic) {

    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    
			}

    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(numPerInsert);
    stringBuffer.append(TEXT_981);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_982);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_984);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_985);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_987);
     
				} else if ("MYSQL_5".equals(dbVersion)) {
	 				int counter = 1;
	                for(Column column : colStruct) {
	                    if(column.isInsertable()) {
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
	                        
    stringBuffer.append(TEXT_988);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_989);
    
	                        if(isEnableDebug) {
	                            
    stringBuffer.append(TEXT_990);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_992);
    
	                        }                        
	                        counter++;                        
	                    }		
	
	                }
					if(isDynamic) {
						Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
						if("Dynamic".equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_993);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_994);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_995);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_996);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_997);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_998);
    
						}
					}
					
	                if(isEnableDebug) {
	                    
    stringBuffer.append(TEXT_999);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1001);
    
	                }                
	                
    stringBuffer.append(TEXT_1002);
    if (rejectConnName == null) { // modification one
		    		
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1005);
    if (!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
		    		  
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1007);
    
		    		  }
    stringBuffer.append(TEXT_1008);
    
		    		}else {    		
		    		
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1014);
    
	                    if (("true").equals(dieOnError)) {
	                        
    stringBuffer.append(TEXT_1015);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1017);
    }
    stringBuffer.append(TEXT_1018);
    
	                    } else {
	                        if(isLog4jEnabled){
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1020);
    }
	                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1023);
    
	                            for(IMetadataColumn column : columnList) {
	                             
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1028);
    
	                            }
	                            
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1034);
    
	                        } else {
	                            
    stringBuffer.append(TEXT_1035);
    
	                        }
	                    } 
	                    
    stringBuffer.append(TEXT_1036);
    
    			}
    			
    
				}
            } else {//extended-insert mode(end)
                int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1040);
    
                        }                        
                        counter++;                        
                    }		

                }
				
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1046);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1049);
    
                }                
                
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1055);
    
                    if (("true").equals(dieOnError)) {
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1057);
    }
    stringBuffer.append(TEXT_1058);
    
                    } else {
                        if(isLog4jEnabled){
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1060);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1063);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1068);
    
                            }
                            
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1076);
    
                        } else {
                            
    stringBuffer.append(TEXT_1077);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1078);
    
            }
    	} else if(("UPDATE").equals(dataAction)) {
    	    int counterCol = 1;    		
    		for(Column column : colStruct) {
    			if(column.isUpdatable()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_1080);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1083);
    
                    }    	
                    counterCol++;
    			}
    		}
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1090);
    
				}
			}
    
    		for(Column column:colStruct){
    			if(column.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1091);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
      
					if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1095);
    
                    }
                    	counterCol++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    stringBuffer.append(TEXT_1097);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1100);
    
                    }    			    
    			    counterCol++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1103);
    
            }    
    		
    stringBuffer.append(TEXT_1104);
    if (rejectConnName == null && useBatchSize && "MYSQL_5".equals(dbVersion)) { // whether use batch
    		
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1107);
    if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1109);
    
    		  }
    stringBuffer.append(TEXT_1110);
    
    		}else {    		
    		
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1116);
    
                if (("true").equals(dieOnError)) {
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1118);
    }
    stringBuffer.append(TEXT_1119);
    
                } else {
                    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1124);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1129);
    
                        }
                        
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1137);
    
                    } else {
                        
    stringBuffer.append(TEXT_1138);
    
                    }
                } 
                
    stringBuffer.append(TEXT_1139);
    
            } // end whether use batch
            
    
    	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
    		int columnIndex = 1;
    		for(Column column : colStruct) {
    			if(column.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1140);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
      
                    	columnIndex++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_1143);
    
    			    columnIndex++;
    			}
    		}
    		
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1151);
    
    			int counterCol = 1;
    			for(Column column : colStruct) {
    				if(column.isUpdatable()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    				    
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1153);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1156);
    
                        }    				    
    				    counterCol++;
    				}
    			}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1163);
    
					}
				}
    			for(Column column : colStruct) {
    				if(column.isUpdateKey()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    				    String dbType = column.getColumn().getType();
                        
     
	                    //#############for feature:2880
	                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1165);
      
		                     if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1168);
    
	                    	} 
	                    	counterCol++;
	                       }
	                     //#############                      
	                    
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    stringBuffer.append(TEXT_1170);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1173);
    
                        }    				    
    				    counterCol++;				    
    				}
    			}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1176);
    
                }    			
    			
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1181);
    
                    if (("true").equals(dieOnError)) {
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1183);
    }
    stringBuffer.append(TEXT_1184);
    
                    } else {
                        if(isLog4jEnabled){
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1186);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1189);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1194);
    
                            }
                            
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1202);
    
                        } else {
                            
    stringBuffer.append(TEXT_1203);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1204);
    
    			int counterInsert = 1;
    			for(Column columnInsert : colStruct)
    			{
    				if(columnInsert.isInsertable()) {
    				    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
    				    
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    stringBuffer.append(TEXT_1206);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1209);
    
                        }    				    
    				    counterInsert++;
    				}
    			}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1215);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1218);
    
                }    			
    			
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1223);
    
                    if (("true").equals(dieOnError)) {
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1225);
    }
    stringBuffer.append(TEXT_1226);
    
                    } else {
	                    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1228);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1231);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1236);
    
                            }
                            
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1244);
    
                        } else {
                            
    stringBuffer.append(TEXT_1245);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1247);
    
    	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
    	    
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1249);
    
    		int counterColUpdate = 1;
    		for(Column columnUpdate : colStruct) {
    			if(columnUpdate.isUpdatable()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
    			    
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_1251);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1254);
    
                    }    			    
    			    counterColUpdate++;
    			}
    		}
			if(isDynamic) {
				Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1261);
    
				}
			}
    
    		for(Column columnUpdate : colStruct) {
    			if(columnUpdate.isUpdateKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
    			    String dbType = columnUpdate.getColumn().getType();
                    
    stringBuffer.append(TEXT_1262);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && columnUpdate.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1266);
    
	                    	}
                    	counterColUpdate++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    stringBuffer.append(TEXT_1268);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_1271);
    
                    }    			    
    			    counterColUpdate++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1274);
    
            }    		
    		
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1281);
    
                if (("true").equals(dieOnError)) {
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1283);
    }
    stringBuffer.append(TEXT_1284);
    
                } else {
                    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1286);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1289);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1294);
    
                        }
                        
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1302);
    
                    } else {
                        
    stringBuffer.append(TEXT_1303);
    
                    }
                } 
                
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1305);
    
            	if(isEnableDebug) {
            	
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1307);
    
        		}
        		int counter = 1;
        		
        		for(Column column : colStruct) {
        			if(column.isInsertable()) {
        			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
        			    
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, INSERT_TYPE));
    stringBuffer.append(TEXT_1309);
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1312);
    
                        }        			    
        			    counter++;
        			}
        		}
				if(isDynamic) {
					Column dynamicColumn = getColumn(columnList.get(columnList.size()-1));
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_1318);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1321);
    
                }        		
        		
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1326);
    
                    if (("true").equals(dieOnError)) {
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1328);
    }
    stringBuffer.append(TEXT_1329);
    
                    } else {
                        if(isLog4jEnabled){
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1331);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1334);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1339);
    
                            }
                            
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1347);
    
                        } else {
                            
    stringBuffer.append(TEXT_1348);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1350);
    
    	
    	} else if (("DELETE").equals(dataAction)) {
    	    int keyCounter = 1;
    		for(Column column : colStruct) {
    			if(column.isDeleteKey()) {
    			    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_1351);
     
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
      
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_1355);
    
	                    	}
                    	 keyCounter++;
                       }
                     //#############                      
                    
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_1357);
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_1360);
    
                    }    			    
    			    keyCounter++;
    			}
    		}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1363);
    
            }    		
        	
    stringBuffer.append(TEXT_1364);
    if (rejectConnName == null && useBatchSize && "MYSQL_5".equals(dbVersion)) { // whether use batch
    		
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1366);
    if (useBatchSize && !("").equals(batchSize) && !("0").equals(batchSize)) {
    		  
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1368);
    
    		  }
    stringBuffer.append(TEXT_1369);
    
    		}else {    		
    		
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1374);
    
                if (("true").equals(dieOnError)) {
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1376);
    }
    stringBuffer.append(TEXT_1377);
    
                } else {
                    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1379);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1382);
    
                        for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1387);
    
                        }
                        
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1395);
    
                    } else {
                        
    stringBuffer.append(TEXT_1396);
    
                    }
                }
                
    stringBuffer.append(TEXT_1397);
    
            } // end whether use batch
            
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1399);
    
    	} else if(("REPLACE").equals(dataAction)) {
    	    int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "replaceSQLSplits_"));
    stringBuffer.append(TEXT_1403);
    
                    }                    
                    counter++;                        
                }       

            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1406);
    
            }            
            
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1411);
    
                if (("true").equals(dieOnError)) {
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1413);
    }
    stringBuffer.append(TEXT_1414);
    
                } else {
                    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1416);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1419);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1424);
    
                        }
                        
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1432);
    
                    } else {
                        
    stringBuffer.append(TEXT_1433);
    
                    }
                }
                
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1440);
    
    	} else if(("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {
    	    int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1444);
    
                    }                    
                    counter++;                        
                }       

            }
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" ,  counter, "insertIgnoreSQLSplits_"));
    stringBuffer.append(TEXT_1448);
    
                    }                    
                    counter++;                   
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1451);
    
            }            
            
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1456);
    
                if (("true").equals(dieOnError)) {
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1458);
    }
    stringBuffer.append(TEXT_1459);
    
                } else {
                    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1461);
    }
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1464);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1469);
    
                        }
                        
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1477);
    
                    } else {
                        
    stringBuffer.append(TEXT_1478);
    
                    }
                }
                
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1485);
    
    	}else if(("INSERT_IGNORE").equals(dataAction)) {
    	int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_1489);
    
                        }                        
                        counter++;                        
                    }		

                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1492);
    
                }                
                
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1498);
    
                    if (("true").equals(dieOnError)) {
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1500);
    }
    stringBuffer.append(TEXT_1501);
    
                    } else {
                        if(isLog4jEnabled){
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1503);
    }
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1506);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1511);
    
                            }
                            
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1519);
    
                        } else {
                            
    stringBuffer.append(TEXT_1520);
    
                        }
                    } 
                    
    stringBuffer.append(TEXT_1521);
    
    	}
    	
    	if(isLog4jEnabled){
			int count = 0;
			for(IMetadataColumn column : columnList) {
				count++;
		
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1525);
    if(count < columnList.size()){
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1527);
    }
            }
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1533);
    }
		
        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1535);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            
                            
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1538);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1543);
                      
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_1544);
    
        }	
        	//////////batch execute by batch size///////
    	if (extendedInsert && "MYSQL_5".equals(dbVersion) && ("INSERT").equals(dataAction)) {
    		if(!("").equals(numPerInsert ) && !("0").equals(numPerInsert )) {
    		
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1547);
    if ( (rejectConnName==null)) {
                
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1554);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1557);
    
            	    	}
            	    	
    stringBuffer.append(TEXT_1558);
    if(("true").equals(dieOnError)) {
                	
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1560);
    }
    stringBuffer.append(TEXT_1561);
    
                	}else {
                	
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1563);
    }
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1569);
    if (("INSERT").equals(dataAction)) {
            	    
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1572);
    
	    	    	}
	    	    	
    stringBuffer.append(TEXT_1573);
    
                	}
    stringBuffer.append(TEXT_1574);
    
                }
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1576);
    	
    		}
    	
    	}
    	if (useBatchSize && "MYSQL_5".equals(dbVersion) &&(rejectConnName==null)&& (("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
    		if(!("").equals(batchSize) && !("0").equals(batchSize)) {
    		
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1579);
    if (rejectConnName==null) {
                
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1586);
    
            	    	 if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1589);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1592);
    
            	    	}
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1594);
    if(("true").equals(dieOnError)) {
                	
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1596);
    }
    stringBuffer.append(TEXT_1597);
    
                	}else {
                	
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1599);
    }
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1605);
    if (("UPDATE").equals(dataAction)) {
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1608);
     }else if (("DELETE").equals(dataAction)) {
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1611);
    }
    stringBuffer.append(TEXT_1612);
    
                	}
    stringBuffer.append(TEXT_1613);
    
                }
    stringBuffer.append(TEXT_1614);
    	
    		}
    	
    	}	
    	////////////commit every////////////
    	if(!("true").equals(useExistingConn)) {
    		if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
    		    
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1618);
    if ((rejectConnName==null && useBatchSize && "MYSQL_5".equals(dbVersion)) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) ) {
                
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1620);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_1623);
    }
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1629);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_1632);
    }
    stringBuffer.append(TEXT_1633);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1636);
    
            	    	}else if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1639);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1642);
    
            	    	}
    stringBuffer.append(TEXT_1643);
    if(("true").equals(dieOnError)) {
                	
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1645);
    }
    stringBuffer.append(TEXT_1646);
    
                	}else {
                	
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1648);
    }
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1654);
    if (("INSERT").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1657);
    
        	    	}else if (("UPDATE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1660);
    
        	    	}else if (("DELETE").equals(dataAction)) {
        	    	
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1663);
    
        	    	}
    stringBuffer.append(TEXT_1664);
    
                	}
    stringBuffer.append(TEXT_1665);
    
                }
    stringBuffer.append(TEXT_1666);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1669);
    }
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1671);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1673);
    }
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1675);
    
    		}
    	}
    }

    stringBuffer.append(TEXT_1676);
    return stringBuffer.toString();
  }
}
