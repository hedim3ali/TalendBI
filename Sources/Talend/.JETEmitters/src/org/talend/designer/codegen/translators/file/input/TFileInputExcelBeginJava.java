package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work\");" + NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Done.\");";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieving records from the datasource.\");";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_14 = " + \" .\");";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_16 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_17 = ") + \".\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_18 = " - Content of the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \": \" + log4jSb_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_21 = ".delete(0,log4jSb_";
  protected final String TEXT_22 = ".length());";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Writing the record \" + nb_line_";
  protected final String TEXT_25 = " + \" to the file.\");" + NL + "\t\t\t\tlog.trace(\"";
  protected final String TEXT_26 = " - Content of the record \" + nb_line_";
  protected final String TEXT_27 = " + \": \" + log4jSb_";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_29 = ".delete(0,log4jSb_";
  protected final String TEXT_30 = ".length());";
  protected final String TEXT_31 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Written records count: \" + nb_line_";
  protected final String TEXT_33 = " + \" .\");";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = NL + "\t\t\tString log4jFileInputExcelParamters_";
  protected final String TEXT_36 = " = \"\";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_37 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_38 = " + \"FILENAME = \" + ";
  protected final String TEXT_39 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_40 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_41 = " + \"VERSION_2007 = \" + ";
  protected final String TEXT_42 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_43 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_44 = " + \"ALL_SHEETS = \" + ";
  protected final String TEXT_45 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_46 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_47 = " + \"HEADER = \" + ";
  protected final String TEXT_48 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_49 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_50 = " + \"FOOTER = \" + ";
  protected final String TEXT_51 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_52 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_53 = " + \"AFFECT_EACH_SHEET = \" + ";
  protected final String TEXT_54 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_55 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_56 = " + \"LIMIT = \" + ";
  protected final String TEXT_57 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_58 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_59 = " + \"FIRST_COLUMN = \" + ";
  protected final String TEXT_60 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_61 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_62 = " + \"LAST_COLUMN = \" + ";
  protected final String TEXT_63 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_65 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_66 = " + \"THOUSANDS_SEPARATOR = \" + ";
  protected final String TEXT_67 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_68 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_69 = " + \"DECIMAL_SEPARATOR = \" + ";
  protected final String TEXT_70 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_72 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_73 = " + \"TRIMALL = \" + ";
  protected final String TEXT_74 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_76 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_77 = " + \"READ_REAL_VALUE = \" + ";
  protected final String TEXT_78 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_79 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_80 = " + \"NOVALIDATE_ON_CELL = \" + ";
  protected final String TEXT_81 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_82 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_83 = " + \"SUPPRESS_WARN = \" + ";
  protected final String TEXT_84 = " + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_86 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_87 = " + \"GENERATION_MODE = \" + \"";
  protected final String TEXT_88 = "\" + \" | \";" + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_90 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_91 = " + \"ENCODING_TYPE = \" + \"";
  protected final String TEXT_92 = "\" + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_93 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_94 = " + \"DIE_ON_ERROR = \" + ";
  protected final String TEXT_95 = " + \" | \";" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_96 = " = log4jFileInputExcelParamters_";
  protected final String TEXT_97 = " + \"STOPREAD_ON_EMPTYROW = \" + ";
  protected final String TEXT_98 = " + \" | \";" + NL + "\t\t\t" + NL + "\t\t\tlog4jFileInputExcelParamters_";
  protected final String TEXT_99 = " = \"";
  protected final String TEXT_100 = " - Parameters:\" + log4jFileInputExcelParamters_";
  protected final String TEXT_101 = ";" + NL + "\t\t\tlog.debug(log4jFileInputExcelParamters_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_104 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\tRegexUtil_";
  protected final String TEXT_105 = " regexUtil_";
  protected final String TEXT_106 = " = new RegexUtil_";
  protected final String TEXT_107 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_108 = " = new jxl.WorkbookSettings();" + NL + "\t\tworkbookSettings_";
  protected final String TEXT_109 = ".setDrawingsDisabled(true);";
  protected final String TEXT_110 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_111 = ".setCellValidationDisabled(true);";
  protected final String TEXT_112 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_113 = ".setSuppressWarnings(true);";
  protected final String TEXT_114 = "\t\t" + NL + "        workbookSettings_";
  protected final String TEXT_115 = ".setEncoding(";
  protected final String TEXT_116 = ");" + NL + "        " + NL + "        Object source_";
  protected final String TEXT_117 = " =";
  protected final String TEXT_118 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_119 = ";" + NL + "        " + NL + "        java.io.InputStream toClose_";
  protected final String TEXT_120 = " = null;" + NL + "        try {" + NL + "            if(source_";
  protected final String TEXT_121 = " instanceof java.io.InputStream){" + NL + "        \t\ttoClose_";
  protected final String TEXT_122 = " = (java.io.InputStream)source_";
  protected final String TEXT_123 = ";" + NL + "        \t\tworkbook_";
  protected final String TEXT_124 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_125 = "), workbookSettings_";
  protected final String TEXT_126 = ");" + NL + "            }else if(source_";
  protected final String TEXT_127 = " instanceof String){" + NL + "        \t\ttoClose_";
  protected final String TEXT_128 = " = new java.io.FileInputStream(source_";
  protected final String TEXT_129 = ".toString());" + NL + "        \t\tworkbook_";
  protected final String TEXT_130 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_131 = "), workbookSettings_";
  protected final String TEXT_132 = ");" + NL + "            }else{" + NL + "            \tworkbook_";
  protected final String TEXT_133 = " = null;" + NL + "            \t";
  protected final String TEXT_134 = NL + "            \t\tlog.fatal(\"";
  protected final String TEXT_135 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "            \t";
  protected final String TEXT_136 = NL + "            \tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "            } " + NL + "        } finally {" + NL + "\t\t\tif(toClose_";
  protected final String TEXT_137 = "!=null) {" + NL + "\t\t\t\ttoClose_";
  protected final String TEXT_138 = ".close();" + NL + "    \t\t}" + NL + "        }" + NL + "        try {";
  protected final String TEXT_139 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_140 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_141 = ".getSheets());";
  protected final String TEXT_142 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_143 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_144 = NL + "        sheetList_";
  protected final String TEXT_145 = ".addAll(regexUtil_";
  protected final String TEXT_146 = ".getSheets(workbook_";
  protected final String TEXT_147 = ", ";
  protected final String TEXT_148 = ", ";
  protected final String TEXT_149 = "));";
  protected final String TEXT_150 = NL + "        if(sheetList_";
  protected final String TEXT_151 = ".size() <= 0){" + NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_153 = " - Special sheets not exist!\");" + NL + "\t\t\t";
  protected final String TEXT_154 = NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "        " + NL + "        java.util.List<jxl.Sheet> sheet_FilterNullList_";
  protected final String TEXT_155 = " = new java.util.ArrayList<jxl.Sheet>();" + NL + "        for(jxl.Sheet sheet_FilterNull_";
  protected final String TEXT_156 = " : sheetList_";
  protected final String TEXT_157 = "){" + NL + "        \tif(sheet_FilterNull_";
  protected final String TEXT_158 = ".getRows()>0){" + NL + "        \t\tsheet_FilterNullList_";
  protected final String TEXT_159 = ".add(sheet_FilterNull_";
  protected final String TEXT_160 = ");" + NL + "        \t}" + NL + "        }" + NL + "\t\tsheetList_";
  protected final String TEXT_161 = " = sheet_FilterNullList_";
  protected final String TEXT_162 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_163 = ".size()>0){" + NL + "        int nb_line_";
  protected final String TEXT_164 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_165 = " = ";
  protected final String TEXT_166 = "0";
  protected final String TEXT_167 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_168 = " = ";
  protected final String TEXT_169 = "0";
  protected final String TEXT_170 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_171 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_172 = ":sheetList_";
  protected final String TEXT_173 = "){" + NL + "        \tend_line_";
  protected final String TEXT_174 = "+=sheet_";
  protected final String TEXT_175 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_176 = " -= footer_input_";
  protected final String TEXT_177 = ";" + NL + "        int limit_";
  protected final String TEXT_178 = " = ";
  protected final String TEXT_179 = "-1";
  protected final String TEXT_180 = ";" + NL + "        int start_column_";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = "0";
  protected final String TEXT_183 = "-1";
  protected final String TEXT_184 = ";" + NL + "        int end_column_";
  protected final String TEXT_185 = " = sheetList_";
  protected final String TEXT_186 = ".get(0).getColumns();";
  protected final String TEXT_187 = NL + "        Integer lastColumn_";
  protected final String TEXT_188 = " = ";
  protected final String TEXT_189 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_190 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_191 = " = lastColumn_";
  protected final String TEXT_192 = ".intValue();" + NL + "        }";
  protected final String TEXT_193 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_194 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_195 = " = sheetList_";
  protected final String TEXT_196 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_197 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_198 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_199 = " = sheetList_";
  protected final String TEXT_200 = ".get(0).getRows();" + NL + "        " + NL + "        //for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_201 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\tchar separatorChar_";
  protected final String TEXT_202 = " = df_";
  protected final String TEXT_203 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_204 = NL + "        for(int i_";
  protected final String TEXT_205 = " = begin_line_";
  protected final String TEXT_206 = "; i_";
  protected final String TEXT_207 = " < end_line_";
  protected final String TEXT_208 = "; i_";
  protected final String TEXT_209 = "++){" + NL + "        " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_210 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_211 = " != -1 && nb_line_";
  protected final String TEXT_212 = " >= limit_";
  protected final String TEXT_213 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_214 = " >= rowCount_";
  protected final String TEXT_215 = " + currentRows_";
  protected final String TEXT_216 = ") {" + NL + "                rowCount_";
  protected final String TEXT_217 = " += currentRows_";
  protected final String TEXT_218 = ";" + NL + "                sheet_";
  protected final String TEXT_219 = " = sheetList_";
  protected final String TEXT_220 = ".get(++sheetIndex_";
  protected final String TEXT_221 = ");" + NL + "                currentRows_";
  protected final String TEXT_222 = " = sheet_";
  protected final String TEXT_223 = ".getRows();" + NL + "            }";
  protected final String TEXT_224 = NL + "            if (rowCount_";
  protected final String TEXT_225 = " <= i_";
  protected final String TEXT_226 = ") {" + NL + "                row_";
  protected final String TEXT_227 = " = sheet_";
  protected final String TEXT_228 = ".getRow(i_";
  protected final String TEXT_229 = " - rowCount_";
  protected final String TEXT_230 = ");" + NL + "            }";
  protected final String TEXT_231 = NL + "            if (rowCount_";
  protected final String TEXT_232 = " <= i_";
  protected final String TEXT_233 = " && i_";
  protected final String TEXT_234 = " - rowCount_";
  protected final String TEXT_235 = " >= begin_line_";
  protected final String TEXT_236 = " && currentRows_";
  protected final String TEXT_237 = " - footer_input_";
  protected final String TEXT_238 = " > i_";
  protected final String TEXT_239 = " - rowCount_";
  protected final String TEXT_240 = ") {" + NL + "                row_";
  protected final String TEXT_241 = " = sheet_";
  protected final String TEXT_242 = ".getRow(i_";
  protected final String TEXT_243 = " - rowCount_";
  protected final String TEXT_244 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_245 = "               " + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_246 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_247 = ".getName());";
  protected final String TEXT_248 = NL + "    \t\t";
  protected final String TEXT_249 = " = null;\t\t\t";
  protected final String TEXT_250 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_251 = " = new String[";
  protected final String TEXT_252 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_253 = " = end_column_";
  protected final String TEXT_254 = " >\trow_";
  protected final String TEXT_255 = ".length ? row_";
  protected final String TEXT_256 = ".length : end_column_";
  protected final String TEXT_257 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_258 = ";i++){" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_259 = " < actual_end_column_";
  protected final String TEXT_260 = "){" + NL + "\t\t\t\t" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_261 = " = row_";
  protected final String TEXT_262 = "[i + start_column_";
  protected final String TEXT_263 = "];";
  protected final String TEXT_264 = " " + NL + "                        if (jxl.CellType.NUMBER == cell_";
  protected final String TEXT_265 = ".getType()){" + NL + "                            double doubleCell_";
  protected final String TEXT_266 = " = ((jxl.NumberCell)cell_";
  protected final String TEXT_267 = ").getValue();" + NL + "                            temp_row_";
  protected final String TEXT_268 = "[i] = String.valueOf(doubleCell_";
  protected final String TEXT_269 = ");" + NL + "                            if(temp_row_";
  protected final String TEXT_270 = "[i]!=null) {" + NL + "                                temp_row_";
  protected final String TEXT_271 = "[i] = df_";
  protected final String TEXT_272 = ".format(doubleCell_";
  protected final String TEXT_273 = ");" + NL + "                            }" + NL + "                        } else{" + NL + "                            temp_row_";
  protected final String TEXT_274 = "[i] = cell_";
  protected final String TEXT_275 = ".getContents();" + NL + "                        }";
  protected final String TEXT_276 = NL + "                        temp_row_";
  protected final String TEXT_277 = "[i] = cell_";
  protected final String TEXT_278 = ".getContents();";
  protected final String TEXT_279 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_280 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_281 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_282 = " = new ";
  protected final String TEXT_283 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_284 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_285 = " = \"\";" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_286 = "\t\t\t\t\t" + NL + "\t\t\tif(temp_row_";
  protected final String TEXT_287 = "[";
  protected final String TEXT_288 = "]";
  protected final String TEXT_289 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_290 = "=";
  protected final String TEXT_291 = " + start_column_";
  protected final String TEXT_292 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_293 = " = \"";
  protected final String TEXT_294 = "\";";
  protected final String TEXT_295 = NL + "\t\t\t";
  protected final String TEXT_296 = ".";
  protected final String TEXT_297 = " = temp_row_";
  protected final String TEXT_298 = "[";
  protected final String TEXT_299 = "]";
  protected final String TEXT_300 = ";";
  protected final String TEXT_301 = "\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_302 = "<actual_end_column_";
  protected final String TEXT_303 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_304 = " = ((jxl.DateCell)row_";
  protected final String TEXT_305 = "[";
  protected final String TEXT_306 = " + start_column_";
  protected final String TEXT_307 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_308 = ".";
  protected final String TEXT_309 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_310 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_311 = ".getTime()));" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_314 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_315 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_316 = " + \" )\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_317 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_318 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_319 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_320 = NL + "\t\t";
  protected final String TEXT_321 = ".";
  protected final String TEXT_322 = " = ParserUtils.parseTo_";
  protected final String TEXT_323 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_324 = "[";
  protected final String TEXT_325 = "]";
  protected final String TEXT_326 = ", ";
  protected final String TEXT_327 = ", ";
  protected final String TEXT_328 = "));";
  protected final String TEXT_329 = "\t\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_330 = ".";
  protected final String TEXT_331 = " = temp_row_";
  protected final String TEXT_332 = "[";
  protected final String TEXT_333 = "]";
  protected final String TEXT_334 = ".getBytes(";
  protected final String TEXT_335 = ");" + NL + "\t";
  protected final String TEXT_336 = NL + "\t\t\t";
  protected final String TEXT_337 = ".";
  protected final String TEXT_338 = " = ParserUtils.parseTo_";
  protected final String TEXT_339 = "(temp_row_";
  protected final String TEXT_340 = "[";
  protected final String TEXT_341 = "]";
  protected final String TEXT_342 = ");";
  protected final String TEXT_343 = "\t\t\t\t\t" + NL + "\t\t\t}else {";
  protected final String TEXT_344 = NL + "\t\t\t\t\t";
  protected final String TEXT_345 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_346 = " - Value is empty for column : '";
  protected final String TEXT_347 = "' in '";
  protected final String TEXT_348 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_350 = "' in '";
  protected final String TEXT_351 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_352 = NL + "\t\t\t\t";
  protected final String TEXT_353 = ".";
  protected final String TEXT_354 = " = ";
  protected final String TEXT_355 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_356 = "++;";
  protected final String TEXT_357 = NL + "\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_358 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_359 = ".append(";
  protected final String TEXT_360 = ".";
  protected final String TEXT_361 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_362 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_363 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_364 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_365 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_366 = " ";
  protected final String TEXT_367 = " = null; ";
  protected final String TEXT_368 = NL;
  protected final String TEXT_369 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_370 = " == ";
  protected final String TEXT_371 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_372 = "  " + NL + "\t\t\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_373 = " = true;";
  protected final String TEXT_374 = NL + "\t        ";
  protected final String TEXT_375 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_376 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_377 = NL + "            throw(e);";
  protected final String TEXT_378 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_379 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_380 = NL + "                    ";
  protected final String TEXT_381 = " = new ";
  protected final String TEXT_382 = "Struct();";
  protected final String TEXT_383 = NL + "                    ";
  protected final String TEXT_384 = ".";
  protected final String TEXT_385 = " = ";
  protected final String TEXT_386 = ".";
  protected final String TEXT_387 = ";";
  protected final String TEXT_388 = NL + "                ";
  protected final String TEXT_389 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_390 = "+ \" column: \" + curColName_";
  protected final String TEXT_391 = " + \" (No. \" + curColNum_";
  protected final String TEXT_392 = " + \")\";";
  protected final String TEXT_393 = NL + "                ";
  protected final String TEXT_394 = " = null;";
  protected final String TEXT_395 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_396 = NL + "                ";
  protected final String TEXT_397 = " = null;";
  protected final String TEXT_398 = NL + "            \t";
  protected final String TEXT_399 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_400 = "+ \" column: \" + curColName_";
  protected final String TEXT_401 = " + \" (No. \" + curColNum_";
  protected final String TEXT_402 = " + \")\";";
  protected final String TEXT_403 = NL + "    }\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_404 = NL + "\t\t";
  protected final String TEXT_405 = "if(!whetherReject_";
  protected final String TEXT_406 = ") { ";
  protected final String TEXT_407 = "      " + NL + "             if(";
  protected final String TEXT_408 = " == null){ " + NL + "            \t ";
  protected final String TEXT_409 = " = new ";
  protected final String TEXT_410 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_411 = NL + "\t    \t ";
  protected final String TEXT_412 = ".";
  protected final String TEXT_413 = " = ";
  protected final String TEXT_414 = ".";
  protected final String TEXT_415 = ";    \t\t\t\t";
  protected final String TEXT_416 = NL + "\t\t";
  protected final String TEXT_417 = " } ";
  protected final String TEXT_418 = "\t";
  protected final String TEXT_419 = NL + "\t\t\torg.apache.log4j.Logger logger_";
  protected final String TEXT_420 = " = org.apache.log4j.Logger.getLogger(\"org.openxml4j.opc\");" + NL + "\t        logger_";
  protected final String TEXT_421 = ".setLevel(org.apache.log4j.Level.WARN);" + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_422 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.xssf.usermodel.XSSFSheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_423 = " regexUtil_";
  protected final String TEXT_424 = " = new RegexUtil_";
  protected final String TEXT_425 = "();" + NL + "\t\t" + NL + "\t\tObject source_";
  protected final String TEXT_426 = " = ";
  protected final String TEXT_427 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_428 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_429 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_430 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((String)source_";
  protected final String TEXT_431 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_432 = " instanceof java.io.InputStream) {" + NL + "     \t\tworkbook_";
  protected final String TEXT_433 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((java.io.InputStream)source_";
  protected final String TEXT_434 = ");" + NL + "\t\t} else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_435 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_436 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_437 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t\t";
  protected final String TEXT_438 = NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t";
  protected final String TEXT_439 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_440 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_441 = ":workbook_";
  protected final String TEXT_442 = "){" + NL + "   \t\t\tsheetList_";
  protected final String TEXT_443 = ".add(sheet_";
  protected final String TEXT_444 = ");" + NL + "    \t}";
  protected final String TEXT_445 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_446 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_447 = NL + "        sheetList_";
  protected final String TEXT_448 = ".addAll(regexUtil_";
  protected final String TEXT_449 = ".getSheets(workbook_";
  protected final String TEXT_450 = ", ";
  protected final String TEXT_451 = ", ";
  protected final String TEXT_452 = "));";
  protected final String TEXT_453 = NL + "    \tif(sheetList_";
  protected final String TEXT_454 = ".size() <= 0){" + NL + "\t\t\t";
  protected final String TEXT_455 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_456 = " - Special sheets not exist!\");" + NL + "\t\t\t";
  protected final String TEXT_457 = NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "\t\t" + NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_";
  protected final String TEXT_458 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\tfor (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_";
  protected final String TEXT_459 = " : sheetList_";
  protected final String TEXT_460 = ") {" + NL + "\t\t\tif(sheet_FilterNull_";
  protected final String TEXT_461 = "!=null && sheetList_FilterNull_";
  protected final String TEXT_462 = ".iterator()!=null && sheet_FilterNull_";
  protected final String TEXT_463 = ".iterator().hasNext()){" + NL + "\t\t\t\tsheetList_FilterNull_";
  protected final String TEXT_464 = ".add(sheet_FilterNull_";
  protected final String TEXT_465 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsheetList_";
  protected final String TEXT_466 = " = sheetList_FilterNull_";
  protected final String TEXT_467 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_468 = ".size()>0){" + NL + "\t\tint nb_line_";
  protected final String TEXT_469 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_470 = " = ";
  protected final String TEXT_471 = "0";
  protected final String TEXT_472 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_473 = " = ";
  protected final String TEXT_474 = "0";
  protected final String TEXT_475 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_476 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_477 = ":sheetList_";
  protected final String TEXT_478 = "){" + NL + "\t\t\tend_line_";
  protected final String TEXT_479 = "+=(sheet_";
  protected final String TEXT_480 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_481 = " -= footer_input_";
  protected final String TEXT_482 = ";" + NL + "        int limit_";
  protected final String TEXT_483 = " = ";
  protected final String TEXT_484 = "-1";
  protected final String TEXT_485 = ";" + NL + "        int start_column_";
  protected final String TEXT_486 = " = ";
  protected final String TEXT_487 = "0";
  protected final String TEXT_488 = "-1";
  protected final String TEXT_489 = ";" + NL + "        int end_column_";
  protected final String TEXT_490 = " = -1;";
  protected final String TEXT_491 = "       " + NL + "        Integer lastColumn_";
  protected final String TEXT_492 = " = ";
  protected final String TEXT_493 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_494 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_495 = " = lastColumn_";
  protected final String TEXT_496 = ".intValue();" + NL + "        }        ";
  protected final String TEXT_497 = NL + "        " + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_498 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_499 = " = sheetList_";
  protected final String TEXT_500 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_501 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_502 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_503 = " = (sheetList_";
  protected final String TEXT_504 = ".get(0).getLastRowNum()+1);" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_505 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_506 = " = df_";
  protected final String TEXT_507 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_508 = NL + "        for(int i_";
  protected final String TEXT_509 = " = begin_line_";
  protected final String TEXT_510 = "; i_";
  protected final String TEXT_511 = " < end_line_";
  protected final String TEXT_512 = "; i_";
  protected final String TEXT_513 = "++){" + NL + "       " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_514 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_515 = " != -1 && nb_line_";
  protected final String TEXT_516 = " >= limit_";
  protected final String TEXT_517 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_518 = " >= rowCount_";
  protected final String TEXT_519 = " + currentRows_";
  protected final String TEXT_520 = ") {" + NL + "                rowCount_";
  protected final String TEXT_521 = " += currentRows_";
  protected final String TEXT_522 = ";" + NL + "                sheet_";
  protected final String TEXT_523 = " = sheetList_";
  protected final String TEXT_524 = ".get(++sheetIndex_";
  protected final String TEXT_525 = ");" + NL + "                currentRows_";
  protected final String TEXT_526 = " = (sheet_";
  protected final String TEXT_527 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_528 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_529 = ".getSheetName());";
  protected final String TEXT_530 = NL + "            if (rowCount_";
  protected final String TEXT_531 = " <= i_";
  protected final String TEXT_532 = ") {" + NL + "                row_";
  protected final String TEXT_533 = " = sheet_";
  protected final String TEXT_534 = ".getRow(i_";
  protected final String TEXT_535 = " - rowCount_";
  protected final String TEXT_536 = ");" + NL + "            }";
  protected final String TEXT_537 = NL + "            if (rowCount_";
  protected final String TEXT_538 = " <= i_";
  protected final String TEXT_539 = " && i_";
  protected final String TEXT_540 = " - rowCount_";
  protected final String TEXT_541 = " >= begin_line_";
  protected final String TEXT_542 = " && currentRows_";
  protected final String TEXT_543 = " - footer_input_";
  protected final String TEXT_544 = " > i_";
  protected final String TEXT_545 = " - rowCount_";
  protected final String TEXT_546 = ") {" + NL + "                row_";
  protected final String TEXT_547 = " = sheet_";
  protected final String TEXT_548 = ".getRow(i_";
  protected final String TEXT_549 = " - rowCount_";
  protected final String TEXT_550 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_551 = "          ";
  protected final String TEXT_552 = NL + "\t\t    ";
  protected final String TEXT_553 = " = null;\t\t\t";
  protected final String TEXT_554 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_555 = " = new String[";
  protected final String TEXT_556 = "];";
  protected final String TEXT_557 = "\t\t\t\t" + NL + "\t\t\t\tList<Boolean> datelist_";
  protected final String TEXT_558 = " = new java.util.ArrayList<Boolean>();" + NL + "\t\t\t\tList<String> patternlist_";
  protected final String TEXT_559 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_560 = NL + "\t\t\t\t\t\t\tdatelist_";
  protected final String TEXT_561 = ".add(";
  protected final String TEXT_562 = ");" + NL + "\t\t\t\t\t\t\tpatternlist_";
  protected final String TEXT_563 = ".add(";
  protected final String TEXT_564 = ");";
  protected final String TEXT_565 = NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_566 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_567 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_568 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_569 = "=row_";
  protected final String TEXT_570 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_571 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_572 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_573 = " = excel_end_column_";
  protected final String TEXT_574 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_575 = " = end_column_";
  protected final String TEXT_576 = " >\texcel_end_column_";
  protected final String TEXT_577 = " ? excel_end_column_";
  protected final String TEXT_578 = " : end_column_";
  protected final String TEXT_579 = ";" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.poi.ss.formula.eval.NumberEval ne_";
  protected final String TEXT_580 = " = null;" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_581 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_582 = " < actual_end_column_";
  protected final String TEXT_583 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_584 = " = row_";
  protected final String TEXT_585 = ".getCell(i + start_column_";
  protected final String TEXT_586 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_587 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_588 = ".getCellType()) {" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                            temp_row_";
  protected final String TEXT_589 = "[i] = cell_";
  protected final String TEXT_590 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_591 = ")) {";
  protected final String TEXT_592 = NL + "                    \t        \tif(datelist_";
  protected final String TEXT_593 = ".get(i)){" + NL + "                        \t        \ttemp_row_";
  protected final String TEXT_594 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_595 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_596 = ".get(i));" + NL + "                            \t   \t} else{" + NL + "                                \t\ttemp_row_";
  protected final String TEXT_597 = "[i] = cell_";
  protected final String TEXT_598 = ".getDateCellValue().toString();" + NL + "                                \t}";
  protected final String TEXT_599 = NL + "\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_600 = "[i] =cell_";
  protected final String TEXT_601 = ".getDateCellValue().toString();";
  protected final String TEXT_602 = NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_603 = "[i] = df_";
  protected final String TEXT_604 = ".format(cell_";
  protected final String TEXT_605 = ".getNumericCellValue());" + NL + "                            }" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_606 = "[i] =String.valueOf(cell_";
  protected final String TEXT_607 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_608 = ".getCachedFormulaResultType()) {" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_609 = "[i] = cell_";
  protected final String TEXT_610 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_611 = ")) {";
  protected final String TEXT_612 = NL + "                    \t        \t\t\tif(datelist_";
  protected final String TEXT_613 = ".get(i)){" + NL + "                        \t        \t\t\ttemp_row_";
  protected final String TEXT_614 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_615 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_616 = ".get(i));" + NL + "                            \t   \t\t\t} else{" + NL + "                                \t\t\t\ttemp_row_";
  protected final String TEXT_617 = "[i] =cell_";
  protected final String TEXT_618 = ".getDateCellValue().toString();" + NL + "                                \t\t\t}";
  protected final String TEXT_619 = NL + "\t\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_620 = "[i] =cell_";
  protected final String TEXT_621 = ".getDateCellValue().toString();";
  protected final String TEXT_622 = NL + "                                    } else {" + NL + "\t                                    ne_";
  protected final String TEXT_623 = " = new org.apache.poi.ss.formula.eval.NumberEval(cell_";
  protected final String TEXT_624 = ".getNumericCellValue());" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_625 = "[i] = ne_";
  protected final String TEXT_626 = ".getStringValue();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_627 = "[i] =String.valueOf(cell_";
  protected final String TEXT_628 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_629 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_630 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_631 = "[i]=\"\";" + NL + "                \t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_632 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_633 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_634 = " = new ";
  protected final String TEXT_635 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_636 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_637 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_638 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_639 = "[";
  protected final String TEXT_640 = "]";
  protected final String TEXT_641 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_642 = "=";
  protected final String TEXT_643 = " + start_column_";
  protected final String TEXT_644 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_645 = " = \"";
  protected final String TEXT_646 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_647 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_648 = ".";
  protected final String TEXT_649 = " = temp_row_";
  protected final String TEXT_650 = "[";
  protected final String TEXT_651 = "]";
  protected final String TEXT_652 = ";";
  protected final String TEXT_653 = "\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_654 = "<actual_end_column_";
  protected final String TEXT_655 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_656 = ".getCell(";
  protected final String TEXT_657 = "+ start_column_";
  protected final String TEXT_658 = ").getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_659 = ".getCell(";
  protected final String TEXT_660 = "+ start_column_";
  protected final String TEXT_661 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_662 = ".";
  protected final String TEXT_663 = " = row_";
  protected final String TEXT_664 = ".getCell(";
  protected final String TEXT_665 = "+ start_column_";
  protected final String TEXT_666 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "                            java.util.Date tempDate_";
  protected final String TEXT_667 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_668 = "[";
  protected final String TEXT_669 = "]";
  protected final String TEXT_670 = ", ";
  protected final String TEXT_671 = ");" + NL + "                            if(tempDate_";
  protected final String TEXT_672 = ".after((new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss.SSS\")).parse(\"9999/12/31 23:59:59.999\"))||tempDate_";
  protected final String TEXT_673 = ".before((new SimpleDateFormat(\"yyyy/MM/dd\")).parse(\"1900/01/01\"))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_674 = NL + "\t\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_675 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_676 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_677 = " + \" )\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_678 = NL + "                                throw new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_679 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_680 = " + \" )\");" + NL + "                            }else{";
  protected final String TEXT_681 = NL + "                                ";
  protected final String TEXT_682 = ".";
  protected final String TEXT_683 = " = tempDate_";
  protected final String TEXT_684 = ";" + NL + "                            }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_685 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_686 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_687 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_688 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_689 = " + \" )\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_690 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_691 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_692 = " + \" )\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_693 = NL + "\t\t\t\t";
  protected final String TEXT_694 = ".";
  protected final String TEXT_695 = " = ParserUtils.parseTo_";
  protected final String TEXT_696 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_697 = "[";
  protected final String TEXT_698 = "]";
  protected final String TEXT_699 = ", ";
  protected final String TEXT_700 = ", ";
  protected final String TEXT_701 = "));";
  protected final String TEXT_702 = NL + "\t\t\t\t";
  protected final String TEXT_703 = ".";
  protected final String TEXT_704 = " = ParserUtils.parseTo_";
  protected final String TEXT_705 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_706 = "[";
  protected final String TEXT_707 = "]";
  protected final String TEXT_708 = ", null, '.'==decimalChar_";
  protected final String TEXT_709 = " ? null : decimalChar_";
  protected final String TEXT_710 = "));";
  protected final String TEXT_711 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_712 = ".";
  protected final String TEXT_713 = " = temp_row_";
  protected final String TEXT_714 = "[";
  protected final String TEXT_715 = "]";
  protected final String TEXT_716 = ".getBytes(";
  protected final String TEXT_717 = ");";
  protected final String TEXT_718 = NL + "\t\t\t\t";
  protected final String TEXT_719 = ".";
  protected final String TEXT_720 = " = ParserUtils.parseTo_";
  protected final String TEXT_721 = "(temp_row_";
  protected final String TEXT_722 = "[";
  protected final String TEXT_723 = "]";
  protected final String TEXT_724 = ");";
  protected final String TEXT_725 = NL + "\t\t\t}else{";
  protected final String TEXT_726 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_727 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_728 = " - Value is empty for column : '";
  protected final String TEXT_729 = "' in '";
  protected final String TEXT_730 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_731 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_732 = "' in '";
  protected final String TEXT_733 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_734 = NL + "\t\t\t\t";
  protected final String TEXT_735 = ".";
  protected final String TEXT_736 = " = ";
  protected final String TEXT_737 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_738 = "++;";
  protected final String TEXT_739 = NL + "\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_740 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_741 = ".append(";
  protected final String TEXT_742 = ".";
  protected final String TEXT_743 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_744 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_745 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_746 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_747 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_748 = "\t";
  protected final String TEXT_749 = " ";
  protected final String TEXT_750 = " = null; ";
  protected final String TEXT_751 = NL;
  protected final String TEXT_752 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_753 = " == ";
  protected final String TEXT_754 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_755 = "  " + NL + "\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_756 = " = true;";
  protected final String TEXT_757 = NL + "\t\t\t\t";
  protected final String TEXT_758 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_759 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_760 = NL + "\t            throw(e);";
  protected final String TEXT_761 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_762 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_763 = NL + "\t\t\t\t\t";
  protected final String TEXT_764 = " = new ";
  protected final String TEXT_765 = "Struct();";
  protected final String TEXT_766 = NL + "\t\t\t\t\t";
  protected final String TEXT_767 = ".";
  protected final String TEXT_768 = " = ";
  protected final String TEXT_769 = ".";
  protected final String TEXT_770 = ";";
  protected final String TEXT_771 = NL + "\t\t\t\t\t";
  protected final String TEXT_772 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_773 = "+ \" column: \" + curColName_";
  protected final String TEXT_774 = " + \" (No. \" + curColNum_";
  protected final String TEXT_775 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_776 = " = null;";
  protected final String TEXT_777 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_778 = " = null;";
  protected final String TEXT_779 = NL + "\t\t\t\t\t";
  protected final String TEXT_780 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_781 = "+ \" column: \" + curColName_";
  protected final String TEXT_782 = " + \" (No. \" + curColNum_";
  protected final String TEXT_783 = " + \")\";";
  protected final String TEXT_784 = NL + "\t\t\t}\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_785 = NL + "\t\t";
  protected final String TEXT_786 = "if(!whetherReject_";
  protected final String TEXT_787 = ") { ";
  protected final String TEXT_788 = "      " + NL + "             if(";
  protected final String TEXT_789 = " == null){ " + NL + "            \t ";
  protected final String TEXT_790 = " = new ";
  protected final String TEXT_791 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_792 = NL + "\t    \t ";
  protected final String TEXT_793 = ".";
  protected final String TEXT_794 = " = ";
  protected final String TEXT_795 = ".";
  protected final String TEXT_796 = ";    \t\t\t\t";
  protected final String TEXT_797 = NL + "\t\t";
  protected final String TEXT_798 = " } ";
  protected final String TEXT_799 = "\t";
  protected final String TEXT_800 = NL + "\t\tObject source_";
  protected final String TEXT_801 = " = ";
  protected final String TEXT_802 = ";" + NL + "\t\tcom.talend.excel.xssf.event.ExcelReader excelReader_";
  protected final String TEXT_803 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_804 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_805 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_806 = " = new com.talend.excel.xssf.event.ExcelReader();" + NL + "\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_807 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_808 = " - The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t\t";
  protected final String TEXT_809 = NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttry {";
  protected final String TEXT_810 = NL + "\t\texcelReader_";
  protected final String TEXT_811 = ".addSheetName(\".*\",true);";
  protected final String TEXT_812 = NL + "\t\texcelReader_";
  protected final String TEXT_813 = ".addSheetName(";
  protected final String TEXT_814 = ", ";
  protected final String TEXT_815 = ");";
  protected final String TEXT_816 = NL + "\t\tint start_column_";
  protected final String TEXT_817 = " = ";
  protected final String TEXT_818 = "0";
  protected final String TEXT_819 = "-1";
  protected final String TEXT_820 = ";" + NL + "\t\tint end_column_";
  protected final String TEXT_821 = " = ";
  protected final String TEXT_822 = "-1";
  protected final String TEXT_823 = "-1";
  protected final String TEXT_824 = ";" + NL + "\t\tif(start_column_";
  protected final String TEXT_825 = " >=0) {//follow start column" + NL + "\t\t\tend_column_";
  protected final String TEXT_826 = " = start_column_";
  protected final String TEXT_827 = " + ";
  protected final String TEXT_828 = " - 1;" + NL + "\t\t} else if(end_column_";
  protected final String TEXT_829 = " >= 0) {//follow end column" + NL + "\t\t\tstart_column_";
  protected final String TEXT_830 = " = end_column_";
  protected final String TEXT_831 = " - ";
  protected final String TEXT_832 = " + 1;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(end_column_";
  protected final String TEXT_833 = "<0 || start_column_";
  protected final String TEXT_834 = "<0) {" + NL + "\t\t\t";
  protected final String TEXT_835 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_836 = " - Error start column and end column.\");" + NL + "\t\t\t";
  protected final String TEXT_837 = NL + "\t\t\tthrow new RuntimeException(\"Error start column and end column.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tint header_";
  protected final String TEXT_838 = " = ";
  protected final String TEXT_839 = "0";
  protected final String TEXT_840 = ";" + NL + "\t\tint limit_";
  protected final String TEXT_841 = " = ";
  protected final String TEXT_842 = "-1";
  protected final String TEXT_843 = ";" + NL + "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_844 = " = 0;" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_845 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_846 = " = df_";
  protected final String TEXT_847 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_848 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_849 = ".parse((String)source_";
  protected final String TEXT_850 = ",";
  protected final String TEXT_851 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_852 = " instanceof java.io.InputStream) {" + NL + "\t\t\texcelReader_";
  protected final String TEXT_853 = ".parse((java.io.InputStream)source_";
  protected final String TEXT_854 = ",";
  protected final String TEXT_855 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\twhile((header_";
  protected final String TEXT_856 = "--)>0 && excelReader_";
  protected final String TEXT_857 = ".hasNext()) {//skip the header" + NL + "\t\t\texcelReader_";
  protected final String TEXT_858 = ".next();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_859 = NL + "\t\twhile(excelReader_";
  protected final String TEXT_860 = ".hasNext()) {" + NL + "\t\t\tint emptyColumnCount_";
  protected final String TEXT_861 = " = 0;" + NL + "\t\t" + NL + "\t\t\tif (limit_";
  protected final String TEXT_862 = " != -1 && nb_line_";
  protected final String TEXT_863 = " >= limit_";
  protected final String TEXT_864 = ") {" + NL + "\t\t\t\texcelReader_";
  protected final String TEXT_865 = ".stopRead();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "        \tjava.util.List<String> row_";
  protected final String TEXT_866 = " = excelReader_";
  protected final String TEXT_867 = ".next();";
  protected final String TEXT_868 = NL + "\t\t";
  protected final String TEXT_869 = " = null;\t\t\t";
  protected final String TEXT_870 = NL + "\t\tString[] temp_row_";
  protected final String TEXT_871 = " = new String[";
  protected final String TEXT_872 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_873 = "=0;i_";
  protected final String TEXT_874 = " < ";
  protected final String TEXT_875 = ";i_";
  protected final String TEXT_876 = "++){" + NL + "\t\t\tint current_";
  protected final String TEXT_877 = " = i_";
  protected final String TEXT_878 = " + start_column_";
  protected final String TEXT_879 = ";" + NL + "\t\t\tif(current_";
  protected final String TEXT_880 = " <= end_column_";
  protected final String TEXT_881 = "){" + NL + "\t\t\t\tif(current_";
  protected final String TEXT_882 = " < row_";
  protected final String TEXT_883 = ".size()){" + NL + "\t\t\t\t\tString column_";
  protected final String TEXT_884 = " = row_";
  protected final String TEXT_885 = ".get(current_";
  protected final String TEXT_886 = ");" + NL + "\t\t\t\t\tif(column_";
  protected final String TEXT_887 = "!=null) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_888 = "[i_";
  protected final String TEXT_889 = "] = column_";
  protected final String TEXT_890 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_891 = "[i_";
  protected final String TEXT_892 = "]=\"\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_893 = "[i_";
  protected final String TEXT_894 = "]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttemp_row_";
  protected final String TEXT_895 = "[i_";
  protected final String TEXT_896 = "]=\"\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tboolean whetherReject_";
  protected final String TEXT_897 = " = false;" + NL + "\t\t";
  protected final String TEXT_898 = " = new ";
  protected final String TEXT_899 = "Struct();" + NL + "\t\tint curColNum_";
  protected final String TEXT_900 = " = -1;" + NL + "\t\tString curColName_";
  protected final String TEXT_901 = " = \"\";" + NL + "\t\t" + NL + "\t\ttry{";
  protected final String TEXT_902 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_903 = "[";
  protected final String TEXT_904 = "]";
  protected final String TEXT_905 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_906 = "=";
  protected final String TEXT_907 = " + start_column_";
  protected final String TEXT_908 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_909 = " = \"";
  protected final String TEXT_910 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_911 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_912 = ".";
  protected final String TEXT_913 = " = temp_row_";
  protected final String TEXT_914 = "[";
  protected final String TEXT_915 = "]";
  protected final String TEXT_916 = ";";
  protected final String TEXT_917 = "\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_918 = ".";
  protected final String TEXT_919 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_920 = "[";
  protected final String TEXT_921 = "]";
  protected final String TEXT_922 = ", ";
  protected final String TEXT_923 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_924 = NL + "\t\t\t\t\t";
  protected final String TEXT_925 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_926 = " - The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_927 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_928 = " + \" )\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_929 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_930 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_931 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_932 = NL + "\t\t\t\t";
  protected final String TEXT_933 = ".";
  protected final String TEXT_934 = " = ParserUtils.parseTo_";
  protected final String TEXT_935 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_936 = "[";
  protected final String TEXT_937 = "]";
  protected final String TEXT_938 = ", ";
  protected final String TEXT_939 = ", ";
  protected final String TEXT_940 = "));";
  protected final String TEXT_941 = NL + "\t\t\t\t";
  protected final String TEXT_942 = ".";
  protected final String TEXT_943 = " = ParserUtils.parseTo_";
  protected final String TEXT_944 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_945 = "[";
  protected final String TEXT_946 = "]";
  protected final String TEXT_947 = ", null, '.'==decimalChar_";
  protected final String TEXT_948 = " ? null : decimalChar_";
  protected final String TEXT_949 = "));";
  protected final String TEXT_950 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_951 = ".";
  protected final String TEXT_952 = " = temp_row_";
  protected final String TEXT_953 = "[";
  protected final String TEXT_954 = "]";
  protected final String TEXT_955 = ".getBytes(";
  protected final String TEXT_956 = ");";
  protected final String TEXT_957 = NL + "\t\t\t\t";
  protected final String TEXT_958 = ".";
  protected final String TEXT_959 = " = ParserUtils.parseTo_";
  protected final String TEXT_960 = "(temp_row_";
  protected final String TEXT_961 = "[";
  protected final String TEXT_962 = "]";
  protected final String TEXT_963 = ");";
  protected final String TEXT_964 = NL + "\t\t\t}else{";
  protected final String TEXT_965 = NL + "\t\t\t\t\t";
  protected final String TEXT_966 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_967 = " - Value is empty for column : '";
  protected final String TEXT_968 = "' in '";
  protected final String TEXT_969 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_970 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_971 = "' in '";
  protected final String TEXT_972 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_973 = NL + "\t\t\t\t";
  protected final String TEXT_974 = ".";
  protected final String TEXT_975 = " = ";
  protected final String TEXT_976 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_977 = "++;";
  protected final String TEXT_978 = NL + "\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_979 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_980 = ".append(";
  protected final String TEXT_981 = ".";
  protected final String TEXT_982 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_983 = NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_984 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_985 = NL;
  protected final String TEXT_986 = " ";
  protected final String TEXT_987 = " = null; ";
  protected final String TEXT_988 = NL;
  protected final String TEXT_989 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_990 = " == ";
  protected final String TEXT_991 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_992 = NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_993 = " = true;";
  protected final String TEXT_994 = NL + "\t\t\t\t";
  protected final String TEXT_995 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_996 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_997 = NL + "\t            throw(e);";
  protected final String TEXT_998 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_999 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_1000 = NL + "\t\t\t\t\t";
  protected final String TEXT_1001 = " = new ";
  protected final String TEXT_1002 = "Struct();";
  protected final String TEXT_1003 = NL + "\t\t\t\t\t";
  protected final String TEXT_1004 = ".";
  protected final String TEXT_1005 = " = ";
  protected final String TEXT_1006 = ".";
  protected final String TEXT_1007 = ";";
  protected final String TEXT_1008 = NL + "\t\t\t\t\t";
  protected final String TEXT_1009 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1010 = "+ \" column: \" + curColName_";
  protected final String TEXT_1011 = " + \" (No. \" + curColNum_";
  protected final String TEXT_1012 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_1013 = " = null;";
  protected final String TEXT_1014 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_1015 = " = null;";
  protected final String TEXT_1016 = NL + "\t\t\t\t\t";
  protected final String TEXT_1017 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1018 = "+ \" column: \" + curColName_";
  protected final String TEXT_1019 = " + \" (No. \" + curColNum_";
  protected final String TEXT_1020 = " + \")\";";
  protected final String TEXT_1021 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_1022 = NL + "        \t\t";
  protected final String TEXT_1023 = "if(!whetherReject_";
  protected final String TEXT_1024 = ") { ";
  protected final String TEXT_1025 = "      " + NL + "                     if(";
  protected final String TEXT_1026 = " == null){ " + NL + "                    \t ";
  protected final String TEXT_1027 = " = new ";
  protected final String TEXT_1028 = "Struct();" + NL + "                     }\t\t\t\t";
  protected final String TEXT_1029 = NL + "        \t    \t ";
  protected final String TEXT_1030 = ".";
  protected final String TEXT_1031 = " = ";
  protected final String TEXT_1032 = ".";
  protected final String TEXT_1033 = ";    \t\t\t\t";
  protected final String TEXT_1034 = NL + "        \t\t";
  protected final String TEXT_1035 = " } ";
  protected final String TEXT_1036 = "\t";
  protected final String TEXT_1037 = NL;
  protected final String TEXT_1038 = NL;
  protected final String TEXT_1039 = NL;
  protected final String TEXT_1040 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		//for all tFileinput* components		
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    		
			}
		}
		
		//for all tFileOutput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
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
    		
			}
		}
		
		//for all tFileOutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_34);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
		String fileName = ElementParameterParser.getValue(node,"__FILENAME__");
	
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String allSheets = ElementParameterParser.getValue(node, "__ALL_SHEETS__");
		boolean isAllSheets = (allSheets!=null&&!("").equals(allSheets))?("true").equals(allSheets):false;
		List<Map<String, String>> sheetNameList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SHEETLIST__");
		
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		boolean affect = ("true").equals(ElementParameterParser.getValue(node,"__AFFECT_EACH_SHEET__"));
		boolean stopOnEmptyRow = ("true").equals(ElementParameterParser.getValue(node,"__STOPREAD_ON_EMPTYROW__"));
		
		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
		
		String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
		boolean eventMode = "EVENT_MODE".equals(mode);
		
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			
		/* Build the Log4J message for the different parameters */
	
		if(isLog4jEnabled) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILENAME__"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getValue(node, "__VERSION_2007__"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ALL_SHEETS__"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HEADER__"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FOOTER__"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getValue(node, "__AFFECT_EACH_SHEET__"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append("".equals(ElementParameterParser.getValue(node, "__LIMIT__"))?"\"\"":ElementParameterParser.getValue(node, "__LIMIT__"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIRST_COLUMN__"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append("".equals(ElementParameterParser.getValue(node, "__LAST_COLUMN__"))?"\"\"":ElementParameterParser.getValue(node, "__LAST_COLUMN__"));
    stringBuffer.append(TEXT_63);
     if("true".equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"))) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getValue(node, "__THOUSANDS_SEPARATOR__"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DECIMAL_SEPARATOR__"));
    stringBuffer.append(TEXT_70);
     } 
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TRIMALL__"));
    stringBuffer.append(TEXT_74);
     if("false".equals(ElementParameterParser.getValue(node, "__VERSION_2007__"))) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getValue(node, "__NOVALIDATE_ON_CELL__"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SUPPRESS_WARN__"));
    stringBuffer.append(TEXT_84);
     } else { 
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GENERATION_MODE__"));
    stringBuffer.append(TEXT_88);
     } 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ENCODING_TYPE__"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STOPREAD_ON_EMPTYROW__"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
		}
		
		/* -------------------------- */
		log4jFileUtil.componentStartInfo(node);
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_112);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_113);
    
		}

    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
          
		if(isAllSheets){

    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    
		}else{

    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_143);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_144);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_149);
    
			}
		}

    stringBuffer.append(TEXT_150);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_151);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_165);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_166);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_168);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_169);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_170);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_178);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_179);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_182);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_204);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_223);
    
	if(!affect){

    stringBuffer.append(TEXT_224);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_230);
    
	}else{

    stringBuffer.append(TEXT_231);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_244);
    
    }

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    
//begin
//
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
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

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_249);
    
    				}
    			}
    		}
    	}
    	
		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
//
//end
    stringBuffer.append(TEXT_250);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_252);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_258);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_263);
    
                    if(bReadRealValue){

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
                    }else{

    stringBuffer.append(TEXT_276);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
                    }

    stringBuffer.append(TEXT_279);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
//
//end
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_288);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_291);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_294);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_295);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_299);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_300);
    		
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_301);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_302);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_306);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_312);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    }
    stringBuffer.append(TEXT_317);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    
//start			
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_322);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_325);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_326);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_327);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_328);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
	
    stringBuffer.append(TEXT_329);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_333);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_335);
    
			} else {
//
//end
    stringBuffer.append(TEXT_336);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_338);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_341);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_342);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_343);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_344);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_348);
    }
    stringBuffer.append(TEXT_349);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_351);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_352);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_355);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_356);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_357);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_361);
    if(i < size-1){
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    }
						}
    
//start
//
					}
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    log4jFileUtil.debugRetriveData(node);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_366);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_367);
    }
    stringBuffer.append(TEXT_368);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_369);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_371);
    
	}

    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_374);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    }
    stringBuffer.append(TEXT_377);
    
        } else {
	        if(isLog4jEnabled){
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_380);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_382);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_383);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_385);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_387);
    
                }
                
    stringBuffer.append(TEXT_388);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_394);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_395);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_397);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_398);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    }
        } 
        
    stringBuffer.append(TEXT_403);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_404);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_407);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_410);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_411);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_415);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_416);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_417);
     } 
    stringBuffer.append(TEXT_418);
    
		}
		}

    	
		} else if(!eventMode) {//version judgement /***excel 2007 xlsx and usermodel mode*****/

    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    }
    stringBuffer.append(TEXT_438);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_439);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    
		}else{

    stringBuffer.append(TEXT_445);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_446);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_447);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_451);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_452);
    
			}
		}

    stringBuffer.append(TEXT_453);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_454);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    }
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_470);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_471);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_472);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_473);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_474);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_475);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_483);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_484);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_485);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_486);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_487);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_488);
    }
    stringBuffer.append(TEXT_489);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_490);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    }
    stringBuffer.append(TEXT_497);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_508);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    
	if(!affect){

    stringBuffer.append(TEXT_530);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_535);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_536);
    
	}else{

    stringBuffer.append(TEXT_537);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_540);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_550);
    
    }

    stringBuffer.append(TEXT_551);
    
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String rejectConnName = "";
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
		if (conns!=null) {
			if (conns.size()>0) {
		    	for (int i=0;i<conns.size();i++) {
		    		IConnection connTemp = conns.get(i);
		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_552);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_553);
    
		    		}
		    	}
		    }
		}
		List<Map<String, String>> dateSelect = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DATESELECT__");
		boolean converDatetoString = ("true").equals(ElementParameterParser.getValue(node, "__CONVERTDATETOSTRING__"));
		String firstConnName = "";
		if (conns!=null) {//3	 
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5

    stringBuffer.append(TEXT_554);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_556);
    
			if(converDatetoString){

    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    	
				for(IMetadataColumn column:listColumns){
					for(Map<String, String> line:dateSelect){// search in the date table
						String columnName = line.get("SCHEMA_COLUMN");				
						if(column.getLabel().equals(columnName)){

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(line.get("CONVERTDATE"));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(line.get("PATTERN"));
    stringBuffer.append(TEXT_564);
    
						}
					}
				}	
			}

    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_575);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_581);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_585);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    
								if(converDatetoString){

    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    
								}else{

    stringBuffer.append(TEXT_599);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    
								}

    stringBuffer.append(TEXT_602);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    
										if(converDatetoString){

    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    
										}else{

    stringBuffer.append(TEXT_619);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    
										}

    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_640);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_643);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_646);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_647);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_651);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_652);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_653);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_654);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_655);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_657);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_658);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_660);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_662);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_663);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_665);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_669);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_670);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    }
    stringBuffer.append(TEXT_678);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_685);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_689);
    }
    stringBuffer.append(TEXT_690);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_692);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_693);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_695);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_697);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_698);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_699);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_700);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_701);
    
							} else {

    stringBuffer.append(TEXT_702);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_704);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_707);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_711);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_712);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_715);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_716);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_717);
    
						} else {

    stringBuffer.append(TEXT_718);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_719);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_720);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_723);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_724);
    
						}

    stringBuffer.append(TEXT_725);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_726);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_729);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_730);
    }
    stringBuffer.append(TEXT_731);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_732);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_733);
    
						} else {

    stringBuffer.append(TEXT_734);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_735);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_736);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_737);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_738);
    
						}

    stringBuffer.append(TEXT_739);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_742);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_743);
    if(i < size-1){
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    }
						}
    
					}

    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    log4jFileUtil.debugRetriveData(node);
    stringBuffer.append(TEXT_748);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_749);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_750);
    }
    stringBuffer.append(TEXT_751);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_752);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_753);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_754);
    
	}

    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_757);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    }
    stringBuffer.append(TEXT_760);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_763);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_765);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_766);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_767);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_768);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_769);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_770);
    
					    }//16

    stringBuffer.append(TEXT_771);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_776);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_777);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_778);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_779);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_783);
    
					}//15
				}

    stringBuffer.append(TEXT_784);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_785);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_788);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_789);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_790);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_791);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_792);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_793);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_794);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_795);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_796);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_797);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_798);
     } 
    stringBuffer.append(TEXT_799);
    
		}
		}

    
		} else {//version judgement /***excel 2007 xlsx and event mode*****/

    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_806);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_808);
    }
    stringBuffer.append(TEXT_809);
    
			if(isAllSheets){

    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    
			} else {
				for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_814);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_815);
    
				}
			}

    stringBuffer.append(TEXT_816);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_817);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_818);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_819);
    }
    stringBuffer.append(TEXT_820);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_821);
    if(("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_822);
    }else{
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_823);
    }
    stringBuffer.append(TEXT_824);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_825);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_826);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_827);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_828);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_829);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_830);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_831);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_832);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_833);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_834);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_835);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_836);
    }
    stringBuffer.append(TEXT_837);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_838);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_839);
    }else{
    stringBuffer.append(header);
    }
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_841);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_842);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_843);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_844);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_847);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_850);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_854);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_856);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_861);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_862);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_863);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_865);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_867);
    
			List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			
			String rejectConnName = "";
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
    		
    		if (conns!=null) {
    			if (conns.size()>0) {
    		    	for (int i=0;i<conns.size();i++) {
    		    		IConnection connTemp = conns.get(i);
    		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_868);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_869);
    
    		    		}
    		    	}
    		    }
			}
			
			String firstConnName = "";
			if (conns!=null) {//TD1024
				if (conns.size()>0) {//TD528
					IConnection conn = conns.get(0);
    				firstConnName = conn.getName();
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int size = listColumns.size();
    				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//TD256

    stringBuffer.append(TEXT_870);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_871);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_880);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_889);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_890);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_892);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_895);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_897);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_898);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_899);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_900);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_901);
    
                		for (int i=0; i<size; i++) {//TD128
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_903);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_904);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_905);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_906);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_907);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_909);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_910);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_911);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_912);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_914);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_915);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_916);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_917);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_918);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_919);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_920);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_921);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_922);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_923);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_924);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_926);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_927);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_928);
    }
    stringBuffer.append(TEXT_929);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_930);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_931);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_932);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_933);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_934);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_935);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_936);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_937);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_938);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_939);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_940);
    
							} else {

    stringBuffer.append(TEXT_941);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_942);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_943);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_945);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_946);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_947);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_948);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_949);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_950);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_951);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_953);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_954);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_955);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_956);
    
						} else {

    stringBuffer.append(TEXT_957);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_958);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_959);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_960);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_961);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_962);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_963);
    
						}

    stringBuffer.append(TEXT_964);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_965);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_966);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_967);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_968);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_969);
    }
    stringBuffer.append(TEXT_970);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_971);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_972);
    
						} else {

    stringBuffer.append(TEXT_973);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_974);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_975);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_976);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_977);
    
						}

    stringBuffer.append(TEXT_978);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_981);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_982);
    if(i < size-1){
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    }
						}
    
					}//TD128

    stringBuffer.append(TEXT_985);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_986);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_987);
    }
    stringBuffer.append(TEXT_988);
    
	if(stopOnEmptyRow && false){

    stringBuffer.append(TEXT_989);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_990);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_991);
    
	}

    stringBuffer.append(TEXT_992);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_993);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_994);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_995);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_996);
    }
    stringBuffer.append(TEXT_997);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_998);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_999);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_1000);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1002);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_1003);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1007);
    
					    }//16

    stringBuffer.append(TEXT_1008);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1013);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_1014);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1015);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_1016);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1020);
    
					}//15
				}

    stringBuffer.append(TEXT_1021);
    
    				}//TD256
				}//TD528
				
        		if (conns.size()>0) {//TD64
        			boolean isFirstEnter = true;
        			for (int i=0;i<conns.size();i++) {
        				IConnection conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_1022);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1024);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1028);
    
        			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_1029);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1033);
    
        				 	}
        				}
        			}

    stringBuffer.append(TEXT_1034);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_1035);
     } 
    stringBuffer.append(TEXT_1036);
    
        		}//TD64

			}//TD1024

    stringBuffer.append(TEXT_1037);
    
		}//end version judgement

    stringBuffer.append(TEXT_1038);
    
	}
}
//
//end
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(TEXT_1040);
    return stringBuffer.toString();
  }
}
