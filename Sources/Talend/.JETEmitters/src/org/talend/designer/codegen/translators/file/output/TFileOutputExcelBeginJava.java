package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TFileOutputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelBeginJava result = new TFileOutputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");" + NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Done.\");";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieving records from the datasource.\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_10 = " + \" .\");";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_13 = " + \" .\");";
  protected final String TEXT_14 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_15 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_16 = ") + \".\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_17 = " - Content of the record \" + (nb_line_";
  protected final String TEXT_18 = ") + \": \" + log4jSb_";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_20 = ".delete(0,log4jSb_";
  protected final String TEXT_21 = ".length());";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_23 = " - Writing the record \" + nb_line_";
  protected final String TEXT_24 = " + \" to the file.\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_25 = " - Content of the record \" + nb_line_";
  protected final String TEXT_26 = " + \": \" + log4jSb_";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_28 = ".delete(0,log4jSb_";
  protected final String TEXT_29 = ".length());";
  protected final String TEXT_30 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_31 = " - Written records count: \" + nb_line_";
  protected final String TEXT_32 = " + \" .\");";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = NL + "\t\t\tString log4jFileInputExcelParamters_";
  protected final String TEXT_35 = " = \"\";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_36 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_37 = " + \"FILENAME = \" + ";
  protected final String TEXT_38 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_39 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_40 = " + \"USESTREAM = \" + ";
  protected final String TEXT_41 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_42 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_43 = " + \"VERSION_2007 = \" + ";
  protected final String TEXT_44 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_45 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_46 = " + \"SHEETNAME = \" + ";
  protected final String TEXT_47 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_48 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_49 = " + \"INCLUDEHEADER = \" + ";
  protected final String TEXT_50 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_51 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_52 = " + \"APPEND_FILE = \" + ";
  protected final String TEXT_53 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_55 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_56 = " + \"APPEND_SHEET = \" + ";
  protected final String TEXT_57 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_59 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_60 = " + \"FIRST_CELL_Y_ABSOLUTE = \" + ";
  protected final String TEXT_61 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_63 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_64 = " + \"FIRST_CELL_X = \" + ";
  protected final String TEXT_65 = " + \" | \";" + NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_66 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_67 = " + \"FIRST_CELL_Y = \" + ";
  protected final String TEXT_68 = " + \" | \";" + NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_69 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_70 = " + \"KEEP_CELL_FORMATING = \" + ";
  protected final String TEXT_71 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_73 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_74 = " + \"FONT = \" + \"";
  protected final String TEXT_75 = "\" + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_76 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_77 = " + \"IS_ALL_AUTO_SIZE = \" + ";
  protected final String TEXT_78 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_80 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_81 = " + \"FLUSHONROW = \" + ";
  protected final String TEXT_82 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_84 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_85 = " + \"FLUSHONROW_NUM = \" + ";
  protected final String TEXT_86 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_90 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_91 = " + \"THOUSANDS_SEPARATOR = \" + ";
  protected final String TEXT_92 = " + \" | \";" + NL + "\t\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_93 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_94 = " + \"DECIMAL_SEPARATOR = \" + ";
  protected final String TEXT_95 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_97 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_98 = " + \"ENCODING_TYPE = \" + \"";
  protected final String TEXT_99 = "\" + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_100 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_101 = " + \"DELETE_EMPTYFILE = \" + ";
  protected final String TEXT_102 = " + \" | \";" + NL + "\t\t\t" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_103 = " = \"";
  protected final String TEXT_104 = " - Parameters:\" + log4jFileInputExcelParamters_";
  protected final String TEXT_105 = ";" + NL + "\t\t\tlog.debug(log4jFileInputExcelParamters_";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\tint nb_line_";
  protected final String TEXT_108 = " = 0;" + NL;
  protected final String TEXT_109 = "\t\t" + NL + "\t\tString fileName_";
  protected final String TEXT_110 = "=";
  protected final String TEXT_111 = ";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_112 = " = new java.io.File(fileName_";
  protected final String TEXT_113 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_114 = " = true;";
  protected final String TEXT_115 = NL + "\t\tif(file_";
  protected final String TEXT_116 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_117 = " = false;" + NL + "\t\t}";
  protected final String TEXT_118 = NL + "//create directory only if not exists\t\t  " + NL + "          java.io.File parentFile_";
  protected final String TEXT_119 = " = file_";
  protected final String TEXT_120 = ".getParentFile();" + NL + "          if (parentFile_";
  protected final String TEXT_121 = " != null && !parentFile_";
  protected final String TEXT_122 = ".exists()) {" + NL + "        \t";
  protected final String TEXT_123 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_124 = " - Creating directory '\" +parentFile_";
  protected final String TEXT_125 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "             parentFile_";
  protected final String TEXT_127 = ".mkdirs();" + NL + "        \t";
  protected final String TEXT_128 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_129 = " - Create directory '\"+parentFile_";
  protected final String TEXT_130 = ".getCanonicalPath()+\"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_131 = NL + "          }";
  protected final String TEXT_132 = "\t\t" + NL + "\t\t" + NL + "\t\tjxl.write.WritableWorkbook writeableWorkbook_";
  protected final String TEXT_133 = " = null;" + NL + "\t\tjxl.write.WritableSheet writableSheet_";
  protected final String TEXT_134 = " = null;" + NL + "\t\t" + NL + "\t\tjxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_135 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_136 = ".setEncoding(";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_139 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_140 = "), " + NL + "            \t\tfalse, workbookSettings_";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = "  " + NL + "        if (file_";
  protected final String TEXT_143 = ".exists()) {" + NL + "        jxl.Workbook workbook_";
  protected final String TEXT_144 = " = jxl.Workbook.getWorkbook(file_";
  protected final String TEXT_145 = ",workbookSettings_";
  protected final String TEXT_146 = ");" + NL + "        workbookSettings_";
  protected final String TEXT_147 = ".setWriteAccess(null);" + NL + "        writeableWorkbook_";
  protected final String TEXT_148 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "                \tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(file_";
  protected final String TEXT_149 = ", false)), " + NL + "                \tworkbook_";
  protected final String TEXT_150 = ", " + NL + "                \ttrue," + NL + "                    workbookSettings_";
  protected final String TEXT_151 = ");" + NL + "        }else{        " + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_152 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_153 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_154 = ");        " + NL + "        }     ";
  protected final String TEXT_155 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_156 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_157 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_158 = ");";
  protected final String TEXT_159 = "       " + NL + "" + NL + "        writableSheet_";
  protected final String TEXT_160 = " = writeableWorkbook_";
  protected final String TEXT_161 = ".getSheet(";
  protected final String TEXT_162 = ");" + NL + "        if(writableSheet_";
  protected final String TEXT_163 = " == null){" + NL + "        \twritableSheet_";
  protected final String TEXT_164 = " = writeableWorkbook_";
  protected final String TEXT_165 = ".createSheet(";
  protected final String TEXT_166 = ", writeableWorkbook_";
  protected final String TEXT_167 = ".getNumberOfSheets());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_168 = NL + "        else {" + NL + "" + NL + "            String[] sheetNames_";
  protected final String TEXT_169 = " = writeableWorkbook_";
  protected final String TEXT_170 = ".getSheetNames();" + NL + "            for (int i = 0; i < sheetNames_";
  protected final String TEXT_171 = ".length; i++) {" + NL + "                if (sheetNames_";
  protected final String TEXT_172 = "[i].equals(";
  protected final String TEXT_173 = ")) {" + NL + "                    writeableWorkbook_";
  protected final String TEXT_174 = ".removeSheet(i);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "" + NL + "\t\t\twritableSheet_";
  protected final String TEXT_175 = " = writeableWorkbook_";
  protected final String TEXT_176 = ".createSheet(";
  protected final String TEXT_177 = ", writeableWorkbook_";
  protected final String TEXT_178 = ".getNumberOfSheets());" + NL + "        }";
  protected final String TEXT_179 = NL + NL + "        //modif start";
  protected final String TEXT_180 = NL + "\t\tint startRowNum_";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = ";";
  protected final String TEXT_183 = NL + "        int startRowNum_";
  protected final String TEXT_184 = " = writableSheet_";
  protected final String TEXT_185 = ".getRows();";
  protected final String TEXT_186 = NL + "\t\t//modif end" + NL + "\t\t" + NL + "\t\tint[] fitWidth_";
  protected final String TEXT_187 = " = new int[";
  protected final String TEXT_188 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_189 = "=0;i_";
  protected final String TEXT_190 = "<";
  protected final String TEXT_191 = ";i_";
  protected final String TEXT_192 = "++){" + NL + "\t\t    int fitCellViewSize_";
  protected final String TEXT_193 = "=writableSheet_";
  protected final String TEXT_194 = ".getColumnView(i_";
  protected final String TEXT_195 = "+";
  protected final String TEXT_196 = ").getSize();" + NL + "\t\t\tfitWidth_";
  protected final String TEXT_197 = "[i_";
  protected final String TEXT_198 = "]=fitCellViewSize_";
  protected final String TEXT_199 = "/256;" + NL + "\t\t\tif(fitCellViewSize_";
  protected final String TEXT_200 = "%256!=0){" + NL + "\t\t\t\tfitWidth_";
  protected final String TEXT_201 = "[i_";
  protected final String TEXT_202 = "]+=1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_203 = NL + "\t\t" + NL + "\t\tjxl.write.WritableFont wf_";
  protected final String TEXT_204 = " = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_205 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "        jxl.write.WritableCellFormat format_";
  protected final String TEXT_206 = "  = new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_207 = "); ";
  protected final String TEXT_208 = NL;
  protected final String TEXT_209 = NL + "    \t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_210 = "_";
  protected final String TEXT_211 = "=new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_212 = " ,new jxl.write.DateFormat(";
  protected final String TEXT_213 = "));";
  protected final String TEXT_214 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_215 = "_";
  protected final String TEXT_216 = "=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_217 = "));";
  protected final String TEXT_218 = NL + "\t\tif(true){" + NL + "\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_220 = " - Date pattern must be set for column ";
  protected final String TEXT_221 = " in the schema of component ";
  protected final String TEXT_222 = "!\");" + NL + "\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\tthrow new RuntimeException(\"Date pattern must be set for column ";
  protected final String TEXT_224 = " in the schema of component ";
  protected final String TEXT_225 = "!\");" + NL + "\t\t}";
  protected final String TEXT_226 = "\t\t" + NL;
  protected final String TEXT_227 = NL + "\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_228 = "{";
  protected final String TEXT_229 = NL + "\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_230 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_231 = ",final int rowNum_";
  protected final String TEXT_232 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_233 = ",final int[] fitWidth_";
  protected final String TEXT_234 = ") throws java.lang.Exception {";
  protected final String TEXT_235 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_236 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_237 = " + ";
  protected final String TEXT_238 = ", rowNum_";
  protected final String TEXT_239 = ", \"";
  protected final String TEXT_240 = "\"";
  protected final String TEXT_241 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_242 = NL + "\t\t\t));\t\t";
  protected final String TEXT_243 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_244 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_245 = ", rowNum_";
  protected final String TEXT_246 = ", \"";
  protected final String TEXT_247 = "\"";
  protected final String TEXT_248 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_249 = NL + "\t\t\t));";
  protected final String TEXT_250 = NL + "        \t\t//modif end" + NL + "    \t\tfitWidth_";
  protected final String TEXT_251 = "[";
  protected final String TEXT_252 = "]=fitWidth_";
  protected final String TEXT_253 = "[";
  protected final String TEXT_254 = "]>";
  protected final String TEXT_255 = "?fitWidth_";
  protected final String TEXT_256 = "[";
  protected final String TEXT_257 = "]:";
  protected final String TEXT_258 = ";";
  protected final String TEXT_259 = NL + "\t\t\t}";
  protected final String TEXT_260 = NL + "\t\t\t}";
  protected final String TEXT_261 = NL + "\t\t\tpublic void setColumnView_";
  protected final String TEXT_262 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_263 = "," + NL + "\t\t\t\tfinal int[] fitWidth_";
  protected final String TEXT_264 = ") throws java.lang.Exception {";
  protected final String TEXT_265 = NL + "    \t\t\t//modif start" + NL + "        \t\t";
  protected final String TEXT_266 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_267 = ".setColumnView(";
  protected final String TEXT_268 = " + ";
  protected final String TEXT_269 = ", fitWidth_";
  protected final String TEXT_270 = "[";
  protected final String TEXT_271 = "]);" + NL + "        \t\t";
  protected final String TEXT_272 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_273 = ".setColumnView(";
  protected final String TEXT_274 = ", fitWidth_";
  protected final String TEXT_275 = "[";
  protected final String TEXT_276 = "]);" + NL + "        \t\t";
  protected final String TEXT_277 = NL + "    \t\t\t//modif end";
  protected final String TEXT_278 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_279 = ".setColumnView(";
  protected final String TEXT_280 = ", fitWidth_";
  protected final String TEXT_281 = "[";
  protected final String TEXT_282 = "]);";
  protected final String TEXT_283 = NL + "\t\t\t}";
  protected final String TEXT_284 = NL + "\t\t\t}";
  protected final String TEXT_285 = NL + "\t\t\tpublic void putValue_";
  protected final String TEXT_286 = "(final ";
  protected final String TEXT_287 = "Struct ";
  protected final String TEXT_288 = "," + NL + "\t\t\t\tfinal jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_289 = ",final int startRowNum_";
  protected final String TEXT_290 = ",final int nb_line_";
  protected final String TEXT_291 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_292 = ",int[] fitWidth_";
  protected final String TEXT_293 = ") throws java.lang.Exception {";
  protected final String TEXT_294 = NL + "\t\t\t";
  protected final String TEXT_295 = "\t\t\t\t";
  protected final String TEXT_296 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_297 = ".";
  protected final String TEXT_298 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_299 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_300 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_301 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_302 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_303 = "_";
  protected final String TEXT_304 = " = writableSheet_";
  protected final String TEXT_305 = ".getWritableCell(";
  protected final String TEXT_306 = " + ";
  protected final String TEXT_307 = ", startRowNum_";
  protected final String TEXT_308 = " + nb_line_";
  protected final String TEXT_309 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_310 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_311 = "_";
  protected final String TEXT_312 = " = new jxl.write.";
  protected final String TEXT_313 = "(";
  protected final String TEXT_314 = " + ";
  protected final String TEXT_315 = ", startRowNum_";
  protected final String TEXT_316 = " + nb_line_";
  protected final String TEXT_317 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_318 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_319 = "_";
  protected final String TEXT_320 = " = new jxl.write.";
  protected final String TEXT_321 = "(";
  protected final String TEXT_322 = ", startRowNum_";
  protected final String TEXT_323 = " + nb_line_";
  protected final String TEXT_324 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_325 = NL + "//modif end";
  protected final String TEXT_326 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_327 = ".";
  protected final String TEXT_328 = ", cell_format_";
  protected final String TEXT_329 = "_";
  protected final String TEXT_330 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = ")";
  protected final String TEXT_333 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_334 = ".";
  protected final String TEXT_335 = ".toString()";
  protected final String TEXT_336 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_337 = ".";
  protected final String TEXT_338 = ")).toString()";
  protected final String TEXT_339 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_340 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_341 = "), ";
  protected final String TEXT_342 = ", ";
  protected final String TEXT_343 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_344 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_345 = ".";
  protected final String TEXT_346 = "), ";
  protected final String TEXT_347 = ", ";
  protected final String TEXT_348 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_349 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_350 = ").doubleValue()";
  protected final String TEXT_351 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_352 = ".";
  protected final String TEXT_353 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_354 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_355 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_356 = "_";
  protected final String TEXT_357 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_358 = "_";
  protected final String TEXT_359 = ".setCellFormat( existingCell_";
  protected final String TEXT_360 = "_";
  protected final String TEXT_361 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_362 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_363 = ".addCell(cell_";
  protected final String TEXT_364 = "_";
  protected final String TEXT_365 = ");";
  protected final String TEXT_366 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_367 = "_";
  protected final String TEXT_368 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_369 = "_";
  protected final String TEXT_370 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_371 = "_";
  protected final String TEXT_372 = "=currentWith_";
  protected final String TEXT_373 = "_";
  protected final String TEXT_374 = ">10?10:currentWith_";
  protected final String TEXT_375 = "_";
  protected final String TEXT_376 = ";";
  protected final String TEXT_377 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_378 = "_";
  protected final String TEXT_379 = " = cell_";
  protected final String TEXT_380 = "_";
  protected final String TEXT_381 = ".getContents().trim().length();";
  protected final String TEXT_382 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_383 = "[";
  protected final String TEXT_384 = "]=fitWidth_";
  protected final String TEXT_385 = "[";
  protected final String TEXT_386 = "]>currentWith_";
  protected final String TEXT_387 = "_";
  protected final String TEXT_388 = "?fitWidth_";
  protected final String TEXT_389 = "[";
  protected final String TEXT_390 = "]:currentWith_";
  protected final String TEXT_391 = "_";
  protected final String TEXT_392 = "+2;";
  protected final String TEXT_393 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_394 = "_";
  protected final String TEXT_395 = "=";
  protected final String TEXT_396 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_397 = "[";
  protected final String TEXT_398 = "]=fitWidth_";
  protected final String TEXT_399 = "[";
  protected final String TEXT_400 = "]>currentWith_";
  protected final String TEXT_401 = "_";
  protected final String TEXT_402 = "?fitWidth_";
  protected final String TEXT_403 = "[";
  protected final String TEXT_404 = "]:currentWith_";
  protected final String TEXT_405 = "_";
  protected final String TEXT_406 = "+2;";
  protected final String TEXT_407 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_408 = NL + "\t\t\t}";
  protected final String TEXT_409 = NL + "\t\t\t}";
  protected final String TEXT_410 = NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFileOutputExcelUtil_";
  protected final String TEXT_411 = " fileOutputExcelUtil_";
  protected final String TEXT_412 = "=new FileOutputExcelUtil_";
  protected final String TEXT_413 = "();";
  protected final String TEXT_414 = NL;
  protected final String TEXT_415 = NL + "\tboolean needDel_";
  protected final String TEXT_416 = " = false;";
  protected final String TEXT_417 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_418 = " == ";
  protected final String TEXT_419 = "){";
  protected final String TEXT_420 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_421 = " == 0){";
  protected final String TEXT_422 = NL + "\t//modif end";
  protected final String TEXT_423 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_424 = ".putHeaderValue_";
  protected final String TEXT_425 = "(writableSheet_";
  protected final String TEXT_426 = ",startRowNum_";
  protected final String TEXT_427 = ",";
  protected final String TEXT_428 = "format_";
  protected final String TEXT_429 = "null";
  protected final String TEXT_430 = ",fitWidth_";
  protected final String TEXT_431 = ");";
  protected final String TEXT_432 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_433 = ".putHeaderValue_";
  protected final String TEXT_434 = "(writableSheet_";
  protected final String TEXT_435 = ",nb_line_";
  protected final String TEXT_436 = ",";
  protected final String TEXT_437 = "format_";
  protected final String TEXT_438 = "null";
  protected final String TEXT_439 = ",fitWidth_";
  protected final String TEXT_440 = ");";
  protected final String TEXT_441 = NL + "\t\t//modif start";
  protected final String TEXT_442 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_443 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_444 = " + ";
  protected final String TEXT_445 = ", startRowNum_";
  protected final String TEXT_446 = ", \"";
  protected final String TEXT_447 = "\"";
  protected final String TEXT_448 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_449 = NL + "\t\t\t));\t\t";
  protected final String TEXT_450 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_451 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_452 = ", nb_line_";
  protected final String TEXT_453 = ", \"";
  protected final String TEXT_454 = "\"";
  protected final String TEXT_455 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_456 = NL + "\t\t\t));";
  protected final String TEXT_457 = NL + "\t\t//modif end" + NL + "\t\tfitWidth_";
  protected final String TEXT_458 = "[";
  protected final String TEXT_459 = "]=fitWidth_";
  protected final String TEXT_460 = "[";
  protected final String TEXT_461 = "]>";
  protected final String TEXT_462 = "?fitWidth_";
  protected final String TEXT_463 = "[";
  protected final String TEXT_464 = "]:";
  protected final String TEXT_465 = ";";
  protected final String TEXT_466 = NL + "\t\tneedDel_";
  protected final String TEXT_467 = " = true;";
  protected final String TEXT_468 = NL + "\t\tnb_line_";
  protected final String TEXT_469 = "++;" + NL + "\t}";
  protected final String TEXT_470 = NL + "\t\t";
  protected final String TEXT_471 = NL + "\t\tString fileName_";
  protected final String TEXT_472 = "=";
  protected final String TEXT_473 = ";";
  protected final String TEXT_474 = "\t" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_475 = " = new java.io.File(fileName_";
  protected final String TEXT_476 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_477 = " = true;";
  protected final String TEXT_478 = NL + "\t\tif(file_";
  protected final String TEXT_479 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_480 = " = false;" + NL + "\t\t}";
  protected final String TEXT_481 = NL + "\t\tint nb_line_";
  protected final String TEXT_482 = " = 0;" + NL + "\t\torg.talend.ExcelTool xlsxTool_";
  protected final String TEXT_483 = " = new org.talend.ExcelTool();";
  protected final String TEXT_484 = NL + "\t\t\tint\tflushRowNum_";
  protected final String TEXT_485 = "=";
  protected final String TEXT_486 = ";" + NL + "\t\t\tint bufferCount_";
  protected final String TEXT_487 = "=0;" + NL + "\t\t\txlsxTool_";
  protected final String TEXT_488 = ".setRowAccessWindowSize(-1);" + NL + "\t\t\t//turn-off auto flush";
  protected final String TEXT_489 = NL + "\t\txlsxTool_";
  protected final String TEXT_490 = ".setSheet(";
  protected final String TEXT_491 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_492 = ".setAppend(";
  protected final String TEXT_493 = ",";
  protected final String TEXT_494 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_495 = ".setXY(";
  protected final String TEXT_496 = ",";
  protected final String TEXT_497 = ",";
  protected final String TEXT_498 = ",";
  protected final String TEXT_499 = ");" + NL + "\t\t";
  protected final String TEXT_500 = NL + "\t\txlsxTool_";
  protected final String TEXT_501 = ".prepareXlsxFile(fileName_";
  protected final String TEXT_502 = ");" + NL + "\t\t";
  protected final String TEXT_503 = NL + "\t\txlsxTool_";
  protected final String TEXT_504 = ".prepareStream();" + NL + "\t\t";
  protected final String TEXT_505 = NL + "\t\txlsxTool_";
  protected final String TEXT_506 = ".setFont(\"";
  protected final String TEXT_507 = "\");" + NL + "\t\t";
  protected final String TEXT_508 = NL + "\t\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_509 = "{";
  protected final String TEXT_510 = NL + "\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_511 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_512 = ") throws java.lang.Exception {";
  protected final String TEXT_513 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_514 = ".addCellValue(\"";
  protected final String TEXT_515 = "\");";
  protected final String TEXT_516 = NL + "\t\t\t\t}";
  protected final String TEXT_517 = NL + "\t\t\t\t}";
  protected final String TEXT_518 = NL + "\t\t\t\tpublic void setColAutoSize_";
  protected final String TEXT_519 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_520 = ") throws java.lang.Exception {";
  protected final String TEXT_521 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_522 = ".setColAutoSize(";
  protected final String TEXT_523 = ");";
  protected final String TEXT_524 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_525 = ".setColAutoSize(";
  protected final String TEXT_526 = ");";
  protected final String TEXT_527 = NL + "\t\t\t\t}";
  protected final String TEXT_528 = NL + "\t\t\t\t}";
  protected final String TEXT_529 = NL + "    \t\t\tpublic void putValue_";
  protected final String TEXT_530 = "(final ";
  protected final String TEXT_531 = "Struct ";
  protected final String TEXT_532 = "," + NL + "    \t\t\t\tfinal org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_533 = ") throws java.lang.Exception {";
  protected final String TEXT_534 = NL + "\t\t\t\t";
  protected final String TEXT_535 = "\t\t\t\t\t";
  protected final String TEXT_536 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_537 = ".";
  protected final String TEXT_538 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_539 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_540 = ".addCellValue(";
  protected final String TEXT_541 = ".";
  protected final String TEXT_542 = ", ";
  protected final String TEXT_543 = ");";
  protected final String TEXT_544 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_545 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_546 = ".";
  protected final String TEXT_547 = ")).toString());";
  protected final String TEXT_548 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_549 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_550 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_551 = "), ";
  protected final String TEXT_552 = ", ";
  protected final String TEXT_553 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_554 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_555 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_556 = ".";
  protected final String TEXT_557 = "), ";
  protected final String TEXT_558 = ", ";
  protected final String TEXT_559 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_560 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_561 = ".addCellValue((";
  protected final String TEXT_562 = ").doubleValue());";
  protected final String TEXT_563 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_564 = ".addCellValue(";
  protected final String TEXT_565 = ".";
  protected final String TEXT_566 = ");";
  protected final String TEXT_567 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_568 = ".addCellValue(";
  protected final String TEXT_569 = ".";
  protected final String TEXT_570 = ");";
  protected final String TEXT_571 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_572 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = ")));";
  protected final String TEXT_575 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_576 = ".addCellValue(String.valueOf(";
  protected final String TEXT_577 = ".";
  protected final String TEXT_578 = "));";
  protected final String TEXT_579 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_580 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_581 = NL + "\t\t\t\t}";
  protected final String TEXT_582 = NL + "\t\t\t\t}";
  protected final String TEXT_583 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tFileOutputExcelUtil_";
  protected final String TEXT_584 = " fileOutputExcelUtil_";
  protected final String TEXT_585 = "=new FileOutputExcelUtil_";
  protected final String TEXT_586 = "();";
  protected final String TEXT_587 = NL + "\t\tboolean needDel_";
  protected final String TEXT_588 = " = false;" + NL + "\t\t";
  protected final String TEXT_589 = NL + "\t\tif (xlsxTool_";
  protected final String TEXT_590 = ".getStartRow() == 0){" + NL + "\t\t";
  protected final String TEXT_591 = NL + "\t\txlsxTool_";
  protected final String TEXT_592 = ".addRow();" + NL + "\t\t";
  protected final String TEXT_593 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_594 = ".putHeaderValue_";
  protected final String TEXT_595 = "(xlsxTool_";
  protected final String TEXT_596 = ");";
  protected final String TEXT_597 = NL + "\t\txlsxTool_";
  protected final String TEXT_598 = ".addCellValue(\"";
  protected final String TEXT_599 = "\");" + NL + "\t\t";
  protected final String TEXT_600 = NL + "\t\tneedDel_";
  protected final String TEXT_601 = " = true;" + NL + "\t\t";
  protected final String TEXT_602 = NL + "\t\tnb_line_";
  protected final String TEXT_603 = "++;" + NL + "\t\t";
  protected final String TEXT_604 = NL + "\t}" + NL + "\t\t";
  protected final String TEXT_605 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void componentStartInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
			}
		}
		
		//for all tFileinput* components		
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    		
			}
		}
		
		//for all tFileOutput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
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
    		
			}
		}
		
		//for all tFileOutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_33);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String sheetname = ElementParameterParser.getValue(node, "__SHEETNAME__");
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
boolean keepCellFormating = ("true").equals(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
String font = ElementParameterParser.getValue(node, "__FONT__");
boolean isDeleteEmptyFile = ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__").equals("true");
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
boolean isAppendSheet = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_SHEET__" ));

boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
String flushRowNum=ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__" );

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 

List< ? extends IConnection> conns = node.getIncomingConnections();
IConnection conn = null;
if((conns == null) || (conns.size() < 1) || ((conn = conns.get(0)) == null)) {
	return "";
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		/* Build the Log4J message for the different parameters */
	
		if(isLog4jEnabled) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILENAME__"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USESTREAM__"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ElementParameterParser.getValue(node, "__VERSION_2007__"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SHEETNAME__"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(node, "__APPEND_FILE__"));
    stringBuffer.append(TEXT_53);
     if("true".equals(ElementParameterParser.getValue(node, "__APPEND_FILE__"))) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getValue(node, "__APPEND_SHEET__"));
    stringBuffer.append(TEXT_57);
     } 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
    stringBuffer.append(TEXT_61);
     if("true".equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"))) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_CELL_X__"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_CELL_Y__"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
    stringBuffer.append(TEXT_71);
     } 
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FONT__"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__"));
    stringBuffer.append(TEXT_78);
     if("true".equals(ElementParameterParser.getValue(node, "__VERSION_2007__"))) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
    stringBuffer.append(TEXT_82);
     if("true".equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"))) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__"));
    stringBuffer.append(TEXT_86);
     } 
    stringBuffer.append(TEXT_87);
     } 
    stringBuffer.append(TEXT_88);
     if("true".equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"))) {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(node, "__THOUSANDS_SEPARATOR__"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DECIMAL_SEPARATOR__"));
    stringBuffer.append(TEXT_95);
     } 
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ENCODING_TYPE__"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
		}
		
		/* -------------------------- */
		log4jFileUtil.componentStartInfo(node);
    	if(!version07){//version judgement

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
		if(!useStream){ // the part of the file path

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
			if(isAppendFile){

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    
			}
		}

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_137);
    
		if(useStream){ // the part of the output stream support

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
		}else{
			if(isAppendFile){

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    
			} else {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_158);
    
			}
		}

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    if(!useStream && isAppendFile && !isAppendSheet){
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_182);
    }else{
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_195);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    if(font !=null && font.length()!=0){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    
    	for (int i = 0; i < columns.size(); i++) {
    		IMetadataColumn column = columns.get(i);
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		if (javaType == JavaTypesManager.DATE){
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(pattern != null && pattern.trim().length() != 0){
    				if(font !=null && font.length()!=0){

    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_213);
    
					}else{

    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_217);
    	
					}
				}else{

    stringBuffer.append(TEXT_218);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    				}
			}
		
	    }

    stringBuffer.append(TEXT_226);
    
	int sizeColumns = columns.size();
	if(sizeColumns> schemaOptNum){//TD64

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
		for (int i = 0; i < sizeColumns; i++) {//TD128
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){//TD256

    stringBuffer.append(TEXT_229);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
			}//TD256
			
			if(firstCellYAbsolute){

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_242);
    
			}else{

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_247);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_249);
    
			}

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_258);
    
			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_259);
    
			}
		}//TD128
		
		if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){//TD512

    stringBuffer.append(TEXT_260);
    
		}//TD512
		
		boolean emptyMethod = true;
		
		for(int i=0;i<sizeColumns;i++){//TD1024
			IMetadataColumn column = columns.get(i);
			
			if(i%schemaOptNum==0){
				if(!isAllColumnAutoSize) {
					if(autoSizeList.size() == columns.size()){
						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
    						Map<String,String> tmp= autoSizeList.get(i+j);
    						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
    							emptyMethod = false;
    							break;
    						}
						}
					}
				} else {
					emptyMethod = false;
				}
				
				if(!emptyMethod) {

    stringBuffer.append(TEXT_261);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    
				}
			}
			
			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_265);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_271);
    }else{
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_276);
    }
    stringBuffer.append(TEXT_277);
    
     		} else {
     			if(autoSizeList.size() == columns.size()){
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_282);
    
            		}
        		}
     		}
     		
     		if(!emptyMethod && ((i+1)%schemaOptNum==0)){
     			emptyMethod = true;

    stringBuffer.append(TEXT_283);
    
     		}
     	}//TD1024
     	
     	if(!emptyMethod && (sizeColumns>0&&(sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_284);
    
     	}
     	
     	for(int i=0;i<sizeColumns;i++){//TD2048
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_285);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
			}

    stringBuffer.append(TEXT_294);
    stringBuffer.append(TEXT_295);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_296);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_298);
    
    				} 
    				
    stringBuffer.append(TEXT_299);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
   				
    stringBuffer.append(TEXT_300);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_301);
    if(keepCellFormating){
    stringBuffer.append(TEXT_302);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    }
    stringBuffer.append(TEXT_310);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    }else{
    stringBuffer.append(TEXT_318);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    }
    stringBuffer.append(TEXT_325);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_326);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_329);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_330);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_332);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_333);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_335);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_336);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_338);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_339);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_340);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_341);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_342);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_343);
     } else { 
    stringBuffer.append(TEXT_344);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_347);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_348);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_349);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_350);
    
					}else {

    stringBuffer.append(TEXT_351);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_354);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    
							}
							
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    
					if(isNumber){

    stringBuffer.append(TEXT_366);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
					}else{

    stringBuffer.append(TEXT_377);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    
					}else{

    stringBuffer.append(TEXT_393);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_407);
    
    				} 
    			
    
     		if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_408);
    
     		}
		}//TD2048
		
     	if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_409);
    
     	}

    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    
	}//TD64

    stringBuffer.append(TEXT_414);
    
if(isIncludeHeader){
	if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    
	}
	if(firstCellYAbsolute){

    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_419);
    
	}else{

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    
	}

    stringBuffer.append(TEXT_422);
    
	for (int i = 0; i < columns.size(); i++) {
		IMetadataColumn column = columns.get(i);
		if(sizeColumns > schemaOptNum){
        	if(i%schemaOptNum==0){
        		if(firstCellYAbsolute) {

    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_429);
    }
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    
        		} else {

    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_438);
    }
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    
        		}

        	}
        	
        	continue;
        }

    stringBuffer.append(TEXT_441);
    
		if(firstCellYAbsolute){

    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_447);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_449);
    
		}else{

    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_454);
    
				if (font !=null && font.length()!=0) {

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_456);
    
		}

    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_465);
    
	}
		if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    		}
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    
}

    stringBuffer.append(TEXT_470);
    	
		}else{ //version judgement /***excel 2007 xlsx*****/
			if(!useStream){

    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_473);
    
				if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    
					if(isAppendFile){

    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    
					}
				}
			}

    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    	 
		if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(flushRowNum);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    		
		} 

    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(sheetname);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(isAppendFile);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(isAppendSheet);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(firstCellYAbsolute);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(keepCellFormating);
    stringBuffer.append(TEXT_499);
    if(!useStream){
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    }else{
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    }
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_507);
    
		int sizeColumns = columns.size();
		if(sizeColumns> schemaOptNum){//TD1

    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    
    		for (int i = 0; isIncludeHeader && (i < sizeColumns); i++) {
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_510);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    
    			}

    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_515);
    
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_516);
    
    			}
    		}
    		
    		if(isIncludeHeader && sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_517);
    
    		}
    		
    		boolean emptyMethod = true;
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){
    				if(!isAllColumnAutoSize) {
    					if(autoSizeList.size() == columns.size()){
    						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
        						Map<String,String> tmp= autoSizeList.get(i+j);
        						if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
        							emptyMethod = false;
        							break;
        						}
    						}
    					}
    				} else {
    					emptyMethod = false;
    				}
    				
    				if(!emptyMethod) {

    stringBuffer.append(TEXT_518);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
        			
					}
    			}
    			
    			if(isAllColumnAutoSize){

    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_523);
    
    			} else if(autoSizeList.size() == columns.size()) {
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){

    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_526);
    
            		}
    			}
    			
    			if(!emptyMethod && ((i+1)%schemaOptNum==0)){
    				emptyMethod = true;

    stringBuffer.append(TEXT_527);
        			
    			}
    		}
    		if(!emptyMethod && (sizeColumns>0 && (sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_528);
        		
    		}
    		
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_529);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
        			
    			}

    stringBuffer.append(TEXT_534);
    stringBuffer.append(TEXT_535);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_536);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_538);
    
    				} 
    				
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_543);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_547);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_548);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_551);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_552);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_553);
     } else { 
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_557);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_558);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_559);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_562);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_566);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_570);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_574);
    
					}else{	

    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_578);
    				
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    
    				} 
    				
        			
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_581);
        			
    			}
    		}
    		
    		if(sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_582);
        		
    		}

    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
		}//TD1
		
		if(isIncludeHeader){
			if(isDeleteEmptyFile){
		
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    
			}
			
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    
			}
		
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    
			for (int i = 0; i < columns.size(); i++) {
				IMetadataColumn column = columns.get(i);
				if(sizeColumns > schemaOptNum){
        			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    
        			}
        			continue;
        		}
		
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_599);
    
			}
			if(isDeleteEmptyFile){
		
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_601);
    		
			}
		
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_604);
    
			}
		}	
		
    
		}
    }
}

    stringBuffer.append(TEXT_605);
    return stringBuffer.toString();
  }
}
