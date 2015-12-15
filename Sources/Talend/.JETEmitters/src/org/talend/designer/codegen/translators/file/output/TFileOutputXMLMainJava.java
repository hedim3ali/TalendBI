package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.core.utils.TalendQuoteUtils;

public class TFileOutputXMLMainJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLMainJava result = new TFileOutputXMLMainJava();
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
  protected final String TEXT_34 = NL + "String tempSt_";
  protected final String TEXT_35 = " = null;" + NL + "" + NL + "boolean flag_";
  protected final String TEXT_36 = " = true;" + NL + " " + NL + "groupby_new_";
  protected final String TEXT_37 = " = 0;" + NL;
  protected final String TEXT_38 = "tempSt_";
  protected final String TEXT_39 = " = \"<\"+";
  protected final String TEXT_40 = "+\" \"+";
  protected final String TEXT_41 = "+\"=\\\"\"+";
  protected final String TEXT_42 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_43 = "), ";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ")";
  protected final String TEXT_46 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "), ";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ")";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "((";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = " == null)?\"\":(";
  protected final String TEXT_55 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_56 = "FormatterUtils.format_Date(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ")";
  protected final String TEXT_60 = ")";
  protected final String TEXT_61 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ")).toString())";
  protected final String TEXT_64 = "TalendString.replaceSpecialCharForXML(String.valueOf(";
  protected final String TEXT_65 = "))";
  protected final String TEXT_66 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ")";
  protected final String TEXT_69 = "))";
  protected final String TEXT_70 = "+\"\\\">\";" + NL + "" + NL + "if(!groupby_";
  protected final String TEXT_71 = "[";
  protected final String TEXT_72 = "][0].equals(tempSt_";
  protected final String TEXT_73 = ")){" + NL + "\t" + NL + "\tif(flag_";
  protected final String TEXT_74 = "){" + NL + "\t" + NL + "\t\tgroupby_new_";
  protected final String TEXT_75 = " = ";
  protected final String TEXT_76 = ";" + NL + "" + NL + "\t\tflag_";
  protected final String TEXT_77 = " = false;" + NL + "\t\t" + NL + "\t\tfor(int i_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = "; i_";
  protected final String TEXT_80 = " >= groupby_new_";
  protected final String TEXT_81 = " && start_";
  protected final String TEXT_82 = "; i_";
  protected final String TEXT_83 = "--){" + NL + "" + NL + "\t\t\tout_";
  protected final String TEXT_84 = ".write(groupby_";
  protected final String TEXT_85 = "[i_";
  protected final String TEXT_86 = "][1]);" + NL + "\t" + NL + "\t\t\tout_";
  protected final String TEXT_87 = ".newLine();" + NL + "\t" + NL + "\t\t}\t" + NL + "\t}" + NL + "" + NL + "\tgroupby_";
  protected final String TEXT_88 = "[";
  protected final String TEXT_89 = "][0] = tempSt_";
  protected final String TEXT_90 = ";" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_91 = ".write(tempSt_";
  protected final String TEXT_92 = ");" + NL + "" + NL + "\tout_";
  protected final String TEXT_93 = ".newLine();" + NL + "\t" + NL + "\tif(!start_";
  protected final String TEXT_94 = "){" + NL + "\t\t\t" + NL + "\t\tstart_";
  protected final String TEXT_95 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t\t" + NL + "}else if(!flag_";
  protected final String TEXT_96 = "){" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_97 = ".write(tempSt_";
  protected final String TEXT_98 = ");" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_99 = ".newLine();" + NL + "\t" + NL + "\tif(!start_";
  protected final String TEXT_100 = "){" + NL + "\t\t\t" + NL + "\t\tstart_";
  protected final String TEXT_101 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t" + NL + "}" + NL;
  protected final String TEXT_102 = "StringBuilder tempRes_";
  protected final String TEXT_103 = " = new StringBuilder(\"<\"+";
  protected final String TEXT_104 = ");" + NL;
  protected final String TEXT_105 = "tempRes_";
  protected final String TEXT_106 = ".append(\" \"+";
  protected final String TEXT_107 = "+\"=\\\"\"+";
  protected final String TEXT_108 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_109 = "), ";
  protected final String TEXT_110 = ", ";
  protected final String TEXT_111 = ")";
  protected final String TEXT_112 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = "), ";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ")";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = "((";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " == null)?\"\":(";
  protected final String TEXT_121 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_122 = "FormatterUtils.format_Date(";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ", ";
  protected final String TEXT_125 = ")";
  protected final String TEXT_126 = ")";
  protected final String TEXT_127 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = ")).toString())";
  protected final String TEXT_130 = "TalendString.replaceSpecialCharForXML(String.valueOf(";
  protected final String TEXT_131 = "))";
  protected final String TEXT_132 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = ")";
  protected final String TEXT_135 = "))";
  protected final String TEXT_136 = "+\"\\\"\");" + NL;
  protected final String TEXT_137 = "tempRes_";
  protected final String TEXT_138 = ".append(\">\");" + NL;
  protected final String TEXT_139 = "tempRes_";
  protected final String TEXT_140 = ".append(\"/>\");" + NL;
  protected final String TEXT_141 = "out_";
  protected final String TEXT_142 = ".write(tempRes_";
  protected final String TEXT_143 = ".toString());" + NL + "" + NL + "out_";
  protected final String TEXT_144 = ".newLine();";
  protected final String TEXT_145 = NL + "\tlog4jSb_";
  protected final String TEXT_146 = ".append(tempRes_";
  protected final String TEXT_147 = ".toString() + \"\\r\\n\");";
  protected final String TEXT_148 = NL;
  protected final String TEXT_149 = "out_";
  protected final String TEXT_150 = ".write(\"<\"+";
  protected final String TEXT_151 = "+\">\"+";
  protected final String TEXT_152 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_153 = "), ";
  protected final String TEXT_154 = ", ";
  protected final String TEXT_155 = ")";
  protected final String TEXT_156 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = "), ";
  protected final String TEXT_159 = ", ";
  protected final String TEXT_160 = ")";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = "((";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = " == null)?\"\":(";
  protected final String TEXT_165 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_166 = "FormatterUtils.format_Date(";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = ", ";
  protected final String TEXT_169 = ")";
  protected final String TEXT_170 = ")";
  protected final String TEXT_171 = "TalendString.checkCDATAForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = ")).toString())";
  protected final String TEXT_174 = "TalendString.checkCDATAForXML(String.valueOf(";
  protected final String TEXT_175 = "))";
  protected final String TEXT_176 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_177 = ".";
  protected final String TEXT_178 = ")";
  protected final String TEXT_179 = ".getDocument().getRootElement().asXML()";
  protected final String TEXT_180 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = ")";
  protected final String TEXT_183 = "))";
  protected final String TEXT_184 = "+\"</\"+";
  protected final String TEXT_185 = "+\">\");" + NL + "" + NL + "out_";
  protected final String TEXT_186 = ".newLine();";
  protected final String TEXT_187 = NL + "\tlog4jSb_";
  protected final String TEXT_188 = ".append(\"<\"+";
  protected final String TEXT_189 = "+\">\"+";
  protected final String TEXT_190 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_191 = "), ";
  protected final String TEXT_192 = ", ";
  protected final String TEXT_193 = ")";
  protected final String TEXT_194 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = "), ";
  protected final String TEXT_197 = ", ";
  protected final String TEXT_198 = ")";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = "((";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = " == null)?\"\":(";
  protected final String TEXT_203 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_204 = "FormatterUtils.format_Date(";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = ", ";
  protected final String TEXT_207 = ")";
  protected final String TEXT_208 = ")";
  protected final String TEXT_209 = "TalendString.checkCDATAForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = ")).toString())";
  protected final String TEXT_212 = "TalendString.checkCDATAForXML(String.valueOf(";
  protected final String TEXT_213 = "))";
  protected final String TEXT_214 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = ")";
  protected final String TEXT_217 = ".getDocument().getRootElement().asXML()";
  protected final String TEXT_218 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = ")";
  protected final String TEXT_221 = "))";
  protected final String TEXT_222 = "+\"</\"+";
  protected final String TEXT_223 = "+\">\" + \"\\r\\n\");";
  protected final String TEXT_224 = NL;
  protected final String TEXT_225 = "out_";
  protected final String TEXT_226 = ".write(\"</\"+";
  protected final String TEXT_227 = "+\">\");" + NL + "" + NL + "out_";
  protected final String TEXT_228 = ".newLine();" + NL;
  protected final String TEXT_229 = NL + "\tlog4jSb_";
  protected final String TEXT_230 = ".append(\"</\"+";
  protected final String TEXT_231 = "+\">\" + \"\\r\\n\");";
  protected final String TEXT_232 = NL;
  protected final String TEXT_233 = NL + "    if(nb_line_";
  protected final String TEXT_234 = "%";
  protected final String TEXT_235 = " == 0) {" + NL + "    out_";
  protected final String TEXT_236 = ".flush();" + NL + "    }";
  protected final String TEXT_237 = NL + "nb_line_";
  protected final String TEXT_238 = "++;";
  protected final String TEXT_239 = NL + "currentRowCount_";
  protected final String TEXT_240 = "++;" + NL + "if(currentRowCount_";
  protected final String TEXT_241 = " == ";
  protected final String TEXT_242 = "){";
  protected final String TEXT_243 = NL + "out_";
  protected final String TEXT_244 = ".write(groupby_";
  protected final String TEXT_245 = "[";
  protected final String TEXT_246 = "][1]);" + NL + "out_";
  protected final String TEXT_247 = ".newLine();\t\t";
  protected final String TEXT_248 = NL + "out_";
  protected final String TEXT_249 = ".write(footers_";
  protected final String TEXT_250 = "[";
  protected final String TEXT_251 = "]);" + NL + "out_";
  protected final String TEXT_252 = ".newLine();";
  protected final String TEXT_253 = "\t" + NL + "\tout_";
  protected final String TEXT_254 = ".close();" + NL + "\tcurrentFileCount_";
  protected final String TEXT_255 = "++;\t" + NL + "" + NL + "    sb_";
  protected final String TEXT_256 = " = new StringBuffer(canonicalPath_";
  protected final String TEXT_257 = ");" + NL + "    lastIndexOf_";
  protected final String TEXT_258 = " = canonicalPath_";
  protected final String TEXT_259 = ".lastIndexOf('.');" + NL + "    position_";
  protected final String TEXT_260 = " = lastIndexOf_";
  protected final String TEXT_261 = " > -1 ? lastIndexOf_";
  protected final String TEXT_262 = " : canonicalPath_";
  protected final String TEXT_263 = ".length();" + NL + "    sb_";
  protected final String TEXT_264 = ".insert(position_";
  protected final String TEXT_265 = ", currentFileCount_";
  protected final String TEXT_266 = ");" + NL + "    " + NL + "    fileName_";
  protected final String TEXT_267 = " = sb_";
  protected final String TEXT_268 = ".toString();" + NL + "    file_";
  protected final String TEXT_269 = " = new java.io.File(fileName_";
  protected final String TEXT_270 = ");" + NL + "    " + NL + "\tout_";
  protected final String TEXT_271 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_272 = "), ";
  protected final String TEXT_273 = "));    " + NL;
  protected final String TEXT_274 = NL + "\tstart_";
  protected final String TEXT_275 = " = false;  ";
  protected final String TEXT_276 = "\t" + NL + "\tout_";
  protected final String TEXT_277 = ".write(headers_";
  protected final String TEXT_278 = "[";
  protected final String TEXT_279 = "]);" + NL + "\tout_";
  protected final String TEXT_280 = ".newLine();";
  protected final String TEXT_281 = "\t" + NL + "\tgroupby_";
  protected final String TEXT_282 = "[";
  protected final String TEXT_283 = "][0] = \"\";";
  protected final String TEXT_284 = "\t" + NL + "    currentRowCount_";
  protected final String TEXT_285 = " = 0;" + NL + "}";
  protected final String TEXT_286 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_287 = "++;" + NL + "\t\t\t\t\twriter_";
  protected final String TEXT_288 = ".write(";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = ".getDocument());" + NL + "\t\t\t\t\t";
  protected final String TEXT_291 = NL + "\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_292 = ".append(";
  protected final String TEXT_293 = ".";
  protected final String TEXT_294 = ".getDocument().asXML());" + NL + "\t\t\t\t\t";
  protected final String TEXT_295 = NL + "\t\t\t\t\t";
  protected final String TEXT_296 = NL;

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

boolean inputIsDocument = "true".equals(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"));
String colDoc = ElementParameterParser.getValue(node, "__DOCUMENT_COL__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

if(!inputIsDocument) {
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__")); 
    String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");       
    String split = ElementParameterParser.getValue(node, "__SPLIT__");
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	List rootTags = (List)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
    int footers = rootTags.size();
    List<Map<String, String>> columnMapping = 
    		(List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__MAPPING__"
            );
    String useDynamicGrouping = ElementParameterParser.getValue(
            node,
            "__USE_DYNAMIC_GROUPING__"
        );
    List<Map<String, String>> groupBys =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__GROUP_BY__"
            );
            
    String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
	boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
	String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
	String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
	
    if (("false").equals(useDynamicGrouping)) {
        groupBys.clear();
    }
    if (encoding!=null) {
        if (("").equals(encoding)) {
                encoding = "ISO-8859-15";
        }
    }
    String groupby[][] = new String[groupBys.size()][3];
    for(int i = 0; i < groupBys.size(); i++){
    	groupby[i][0] = groupBys.get(i).get("COLUMN");
    	groupby[i][1] = groupBys.get(i).get("LABEL");
    }
    int atts = 0;
    int tags = 0;
    outter1:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    				groupby[j][2] = col;
    				groupby[j][2] = TalendQuoteUtils.addQuotes(groupby[j][2]);
    			}else{
    				groupby[j][2] = map.get("LABEL");
    			}
    			continue outter1;
    		}
    	}
    	if(("true").equals(map.get("AS_ATTRIBUTE"))){
    		atts ++;
    	}else{
    		tags ++;
    	}
    }
    String[][] attribute = new String[atts][2];
    String[][] tag = new String[tags][2];
    int ia=0;
    int it=0;
    outter2:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			continue outter2;
    		}
    	}
    	if(("true").equals(map.get("AS_ATTRIBUTE"))){
    		if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    			attribute[ia][1] = col;
    			attribute[ia][1] = TalendQuoteUtils.addQuotes(attribute[ia][1]);
    		}else{
    			attribute[ia][1] = map.get("LABEL");
    		}
    		attribute[ia++][0] = col;
    	}else{
    		if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    			tag[it][1] = col;
    			tag[it][1] = TalendQuoteUtils.addQuotes(tag[it][1]);
    		}else{
    			tag[it][1] = map.get("LABEL");
    		}
    	    tag[it++][0] = col;
    	}
    }
	if(groupby.length>0){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
	}

    
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		for(int i = 0; i < groupby.length; i++){
			boolean needReplace = false;
			boolean isDate = false;
			boolean isByteArray = false;
			String pattern = null;
			boolean isPrimitive = false;
			boolean isBigDecimal = false;
			boolean isAdvancedSeparator = false;
			Integer precision = null;
			for(IMetadataColumn column:metadata.getListColumns()) {
				if(column.getLabel().equals(groupby[i][0])){
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
						needReplace = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
						pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
							needReplace = true;
						}
						isDate = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
						isByteArray = true;
					}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
						isBigDecimal = true;
					}
					isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
					
					isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
					
					precision = column.getPrecision();
					break;
				}
			}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(groupby[i][1] );
    stringBuffer.append(TEXT_41);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_42);
    stringBuffer.append(precision == null? conn.getName() + "." + groupby[i][0] : conn.getName() + "." + groupby[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_45);
    
								}else {
								
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_48);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_50);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(groupby[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_54);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_59);
    if(needReplace){
    stringBuffer.append(TEXT_60);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_61);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_63);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_64);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_65);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(groupby[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_68);
    }
    
									}
    stringBuffer.append(TEXT_69);
    
							}
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(groupby.length-1 );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
		}

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_104);
    
for(int i = 0; i < attribute.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	boolean isBigDecimal = false;
	boolean isAdvancedSeparator = false;
	Integer precision = null;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(attribute[i][0])){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
				isBigDecimal = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			
			isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
			
			precision = column.getPrecision();
			break;
		}
	}

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(attribute[i][1] );
    stringBuffer.append(TEXT_107);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_108);
    stringBuffer.append(precision == null? conn.getName() + "." + attribute[i][0] : conn.getName() + "." + attribute[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_111);
    
								}else {
								
    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_116);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(attribute[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_120);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_125);
    if(needReplace){
    stringBuffer.append(TEXT_126);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_127);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_129);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_130);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_131);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(attribute[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_134);
    }
    
									}
    stringBuffer.append(TEXT_135);
    
							}
    stringBuffer.append(TEXT_136);
    
}

    
if(tags > 0){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    
}else{

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
}

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    
for(int i = 0; i < tag.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	boolean isBigDecimal = false;
	boolean isAdvancedSeparator = false;
	boolean isDocument = false;
	Integer precision = null;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(tag[i][0])){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
				isBigDecimal = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
						
			precision = column.getPrecision();

			isDocument = "id_Document".equals(column.getTalendType());
			break;
		}
	}

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_151);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_152);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_155);
    
								}else {
								
    stringBuffer.append(TEXT_156);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_159);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_160);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(tag[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_162);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_164);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_169);
    if(needReplace){
    stringBuffer.append(TEXT_170);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_171);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_173);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_174);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_175);
    
									}else if(isDocument){
									
    if(needReplace){
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_182);
    }
    
									}
    stringBuffer.append(TEXT_183);
    
							}
    stringBuffer.append(TEXT_184);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_189);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_190);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_192);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_193);
    
								}else {
								
    stringBuffer.append(TEXT_194);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_198);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(tag[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_200);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_202);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_207);
    if(needReplace){
    stringBuffer.append(TEXT_208);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_209);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_211);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_212);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_213);
    
									}else if(isDocument){
									
    if(needReplace){
    stringBuffer.append(TEXT_214);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_220);
    }
    
									}
    stringBuffer.append(TEXT_221);
    
							}
    stringBuffer.append(TEXT_222);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    
	if(i == tag.length -1){

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_231);
    }
    
	}
}

    stringBuffer.append(TEXT_232);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    
	}

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    log4jFileUtil.debugWriteData(node);
    
    if(("true").equals(split)){

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SPLIT_EVERY__") );
    stringBuffer.append(TEXT_242);
    
		for(int i = groupby.length - 1; i >=0; i--){

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
		}
		for(int i = footers - 1; i >= 0 ;i--){

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
		}

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_273);
    
	if(groupby.length > 0){

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    
	}
	for(int i = 0; i <= footers;i++){

    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    
	}
	for(int i = 0; i < groupby.length; i++){

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_283);
    
	}

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    
	}
		}
	}
}
} else {
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns = node.getIncomingConnections();
			if(conns!=null && conns.size()>0){
				IConnection conn = conns.get(0);

    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(colDoc);
    stringBuffer.append(TEXT_290);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(colDoc);
    stringBuffer.append(TEXT_294);
    }
    stringBuffer.append(TEXT_295);
    log4jFileUtil.debugWriteData(node);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_296);
    return stringBuffer.toString();
  }
}
