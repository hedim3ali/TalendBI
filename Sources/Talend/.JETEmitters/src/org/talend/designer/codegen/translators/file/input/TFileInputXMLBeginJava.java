package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileInputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputXMLBeginJava result = new TFileInputXMLBeginJava();
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
  protected final String TEXT_34 = NL + "\tString log4jFileInputXMLParameters_";
  protected final String TEXT_35 = " = \"\";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_36 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_37 = " + \"FILENAME = \" + ";
  protected final String TEXT_38 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_39 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_40 = " + \"LOOP_QUERY = \" + ";
  protected final String TEXT_41 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_42 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_43 = " + \"LIMIT = \" + ";
  protected final String TEXT_44 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_45 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_46 = " + \"IGNORE_DTD = \" + ";
  protected final String TEXT_47 = " + \" | \";" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_49 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_50 = " + \"THOUSANDS_SEPARATOR = \" + ";
  protected final String TEXT_51 = " + \" | \";" + NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_52 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_53 = " + \"DECIMAL_SEPARATOR = \" + ";
  protected final String TEXT_54 = " + \" | \";" + NL + "\t";
  protected final String TEXT_55 = NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_56 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_57 = " + \"GENERATION_MODE = \" + \"";
  protected final String TEXT_58 = "\" + \" | \";" + NL + "\t";
  protected final String TEXT_59 = NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_60 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_61 = " + \"IGNORE_NS = \" + ";
  protected final String TEXT_62 = " + \" | \";" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_64 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_65 = " + \"TMP_FILENAME = \" + ";
  protected final String TEXT_66 = " + \" | \";" + NL + "\t\t";
  protected final String TEXT_67 = NL + "\t";
  protected final String TEXT_68 = NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_69 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_70 = " + \"USE_SEPARATOR_FOR_XERCES = \" + ";
  protected final String TEXT_71 = " + \" | \";" + NL + "\t";
  protected final String TEXT_72 = NL + "\t\tlog4jFileInputXMLParameters_";
  protected final String TEXT_73 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_74 = " + \"FIELD_SEPARATOR = \" + ";
  protected final String TEXT_75 = " + \" | \";" + NL + "\t";
  protected final String TEXT_76 = NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_77 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_78 = " + \"ENCODING_TYPE = \" + \"";
  protected final String TEXT_79 = "\" + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_80 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_81 = " + \"CHECK_DATE = \" + ";
  protected final String TEXT_82 = " + \" | \";" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_83 = " = log4jFileInputXMLParameters_";
  protected final String TEXT_84 = " + \"DIE_ON_ERROR = \" + ";
  protected final String TEXT_85 = " + \" | \";" + NL + "" + NL + "\t" + NL + "\tlog4jFileInputXMLParameters_";
  protected final String TEXT_86 = " = \"";
  protected final String TEXT_87 = " - Parameters:\" + log4jFileInputXMLParameters_";
  protected final String TEXT_88 = ";" + NL + "\tlog.debug(log4jFileInputXMLParameters_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "int nb_line_";
  protected final String TEXT_91 = " = 0;" + NL;
  protected final String TEXT_92 = NL + "class IgnoreDTDEntityResolver_";
  protected final String TEXT_93 = " implements org.xml.sax.EntityResolver {" + NL + "" + NL + " public org.xml.sax.InputSource resolveEntity(String publicId, String systemId)" + NL + "   throws org.xml.sax.SAXException, java.io.IOException {" + NL + "        return new org.xml.sax.InputSource(new java.io.ByteArrayInputStream(\"<?xml version='1.0' encoding='UTF-8'?>\".getBytes()));" + NL + " }" + NL + "" + NL + "}";
  protected final String TEXT_94 = NL + "\tString os_";
  protected final String TEXT_95 = " = System.getProperty(\"os.name\").toLowerCase();" + NL + "\tboolean isWindows_";
  protected final String TEXT_96 = "=false;" + NL + "\tif(os_";
  protected final String TEXT_97 = ".indexOf(\"windows\") > -1 || os_";
  protected final String TEXT_98 = ".indexOf(\"nt\") > -1){" + NL + "\t\tisWindows_";
  protected final String TEXT_99 = "=true;" + NL + "\t}";
  protected final String TEXT_100 = NL + "class TalendPrefixResolver_";
  protected final String TEXT_101 = " implements org.apache.xml.utils.PrefixResolver {" + NL + "" + NL + "    private java.util.Map<String, String> map = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "\t" + NL + "    public String getBaseIdentifier() {" + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix) {" + NL + "        if ((\"xml\").equals(prefix)) {" + NL + "            return org.apache.xml.utils.Constants.S_XMLNAMESPACEURI;" + NL + "        } else {" + NL + "            return map.get(prefix);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix, org.w3c.dom.Node context) {" + NL + "        return getNamespaceForPrefix(prefix);" + NL + "    }" + NL + "" + NL + "    public boolean handlesNullPrefixes() {" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean countNSMap(org.w3c.dom.Node el) {" + NL + "    \tboolean hasDefaultPrefix = false;" + NL + "        if (el.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            org.w3c.dom.NamedNodeMap attris = el.getAttributes();" + NL + "            for (int i = 0; i < attris.getLength(); i++) {" + NL + "                org.w3c.dom.Node attr = attris.item(i);" + NL + "                String aname = attr.getNodeName();" + NL + "                if (aname.startsWith(\"xmlns\")) {" + NL + "                    int index = aname.indexOf(\":\");" + NL + "                    if(index > 0){" + NL + "                    \taname = aname.substring(index + 1);" + NL + "                    }else{" + NL + "                    \taname = \"pre\"+defualtNSPath.size();" + NL + "                    \thasDefaultPrefix = true;" + NL + "                    \tString path = \"\";" + NL + "                    \torg.w3c.dom.Node elTmp = el;" + NL + "                    \twhile(elTmp!=null && !(elTmp instanceof org.w3c.dom.Document)){" + NL + "\t\t\t\t\t\t\tpath = \"/\"+elTmp.getNodeName()+path;" + NL + "                    \t\telTmp = elTmp.getParentNode();" + NL + "                    \t}" + NL + "                        defualtNSPath.add(path);" + NL + "                    }" + NL + "                    map.put(aname, attr.getNodeValue());" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        org.w3c.dom.NodeList nodeList = el.getChildNodes();" + NL + "        for (int i = 0; i < nodeList.getLength(); i++) {" + NL + "            hasDefaultPrefix = hasDefaultPrefix | countNSMap(nodeList.item(i));" + NL + "        }" + NL + "        return hasDefaultPrefix;" + NL + "    }" + NL + "    " + NL + "    public int[] getDefaulNSIndex(String path, String loopPath){" + NL + "\t\tString fullPath = loopPath;" + NL + "    \tif(!path.equals(fullPath)){" + NL + "        \tfor (String tmp : path.split(\"/\")) {" + NL + "        \t\tif ((\"..\").equals(tmp)) {" + NL + "                    fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                } else {" + NL + "                    fullPath += \"/\" + tmp;" + NL + "                }" + NL + "        \t}" + NL + "        }" + NL + "    \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "        java.util.Arrays.fill(indexs, -1);" + NL + "        int length = 0;" + NL + "        for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "            if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                length = defualtNSPath.get(i).length();" + NL + "            }" + NL + "        }" + NL + "    \treturn indexs;" + NL + "    }" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_102 = "{" + NL + "" + NL + "\tString loopPath = null;" + NL + "\tboolean hasDefaultNS = false;" + NL + "\tTalendPrefixResolver_";
  protected final String TEXT_103 = " pr = null;" + NL + "\t" + NL + "\tpublic boolean isDefNull(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            return ((org.apache.xerces.xs.ElementPSVI) node).getNil();" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getTextContent().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "\tpublic void initXPath(org.w3c.dom.Node root){" + NL + "\t\tpr= new TalendPrefixResolver_";
  protected final String TEXT_104 = "();" + NL + "    \thasDefaultNS = pr.countNSMap(root);" + NL + "\t}" + NL + "" + NL + "//==============add for feature 10753 start================================" + NL + "\torg.apache.xpath.objects.XObject obj = null;" + NL + "\t" + NL + "\tpublic int getNodeType(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\treturn obj.getType();" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getNodeString(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tif(obj==null){" + NL + "\t\t\tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\t}" + NL + "\t\treturn obj.str();" + NL + "\t}" + NL + "" + NL + "    public org.w3c.dom.Node getSingleNode(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "    \tif(obj==null){" + NL + "        \tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        }" + NL + "        return obj.nodelist().item(0);" + NL + "    }" + NL + "//=====================end=================================================" + NL + "" + NL + "    public org.w3c.dom.NodeList getNodeList(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "        org.apache.xpath.objects.XObject obj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        return obj.nodelist();" + NL + "    }" + NL + "    " + NL + "    private String addDefaultNSPrefix(String path) {" + NL + "        if (hasDefaultNS) {" + NL + "            StringBuffer newPath = new StringBuffer();" + NL + "            int[] indexs= pr.getDefaulNSIndex(path,loopPath);" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL;
  protected final String TEXT_105 = NL + "class ContentTool_";
  protected final String TEXT_106 = "{" + NL + "\tpublic String field_separator=\",\";//default value" + NL + "\t" + NL + "\tpublic String getNodeContent(org.w3c.dom.Node node){" + NL + "\t\tString result=getSubNodeContent(node);" + NL + "\t\tif(result.equals(\"\")) return \"\";" + NL + "\t\telse return result.substring(1);" + NL + "\t}" + NL + "\t" + NL + "\tprivate String getSubNodeContent(org.w3c.dom.Node node){" + NL + "\t\tif(node==null) return \"\";" + NL + "\t\t" + NL + "\t\tString tmp=node.getNodeValue();" + NL + "\t\t" + NL + "\t\tif(tmp==null){" + NL + "\t\t\ttmp=\"\";" + NL + "\t\t}else{" + NL + "\t\t\ttmp=field_separator+tmp;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(node.hasChildNodes()){" + NL + "\t\t\torg.w3c.dom.NodeList nodeList = node.getChildNodes();" + NL + "\t\t\tfor(int i=0;i<nodeList.getLength();i++){" + NL + "\t\t\t\torg.w3c.dom.Node tmpNode= nodeList.item(i);\t" + NL + "\t\t\t\ttmp=tmp+getSubNodeContent(tmpNode);" + NL + "" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn tmp;" + NL + "\t}" + NL + "}" + NL + "ContentTool_";
  protected final String TEXT_107 = " contentTool_";
  protected final String TEXT_108 = " = new ContentTool_";
  protected final String TEXT_109 = "();" + NL + "contentTool_";
  protected final String TEXT_110 = ".field_separator=";
  protected final String TEXT_111 = ";";
  protected final String TEXT_112 = NL + NL + "XML_API_";
  protected final String TEXT_113 = " xml_api_";
  protected final String TEXT_114 = " = new XML_API_";
  protected final String TEXT_115 = "();" + NL + "xml_api_";
  protected final String TEXT_116 = ".loopPath=";
  protected final String TEXT_117 = ";" + NL + "org.apache.xerces.parsers.DOMParser parser_";
  protected final String TEXT_118 = " = new org.apache.xerces.parsers.DOMParser();";
  protected final String TEXT_119 = NL + "parser_";
  protected final String TEXT_120 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_121 = "());";
  protected final String TEXT_122 = NL + "parser_";
  protected final String TEXT_123 = ".setProperty(\"http://apache.org/xml/properties/dom/document-class-name\"," + NL + "        \"org.apache.xerces.dom.PSVIDocumentImpl\");" + NL + "parser_";
  protected final String TEXT_124 = ".setFeature(\"http://xml.org/sax/features/validation\", true);" + NL + "parser_";
  protected final String TEXT_125 = ".setFeature(\"http://apache.org/xml/features/validation/schema\", true);" + NL + "parser_";
  protected final String TEXT_126 = ".setFeature(\"http://apache.org/xml/features/validation/schema-full-checking\", true);" + NL + "parser_";
  protected final String TEXT_127 = ".setFeature(\"http://xml.org/sax/features/namespaces\", true);" + NL + "parser_";
  protected final String TEXT_128 = ".setErrorHandler(null);" + NL + "Object filename_";
  protected final String TEXT_129 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_132 = NL + "\t";
  protected final String TEXT_133 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_134 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_135 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_136 = NL + "\t";
  protected final String TEXT_137 = NL + "\t\tlog.error(\"";
  protected final String TEXT_138 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_139 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_140 = NL + "}" + NL + "" + NL + "boolean isValidFile_";
  protected final String TEXT_141 = " = true;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_142 = " = null;" + NL + "try{" + NL + "    if(filename_";
  protected final String TEXT_143 = " != null && filename_";
  protected final String TEXT_144 = " instanceof String && filename_";
  protected final String TEXT_145 = ".toString().startsWith(\"//\")){" + NL + "\t\tif (!isWindows_";
  protected final String TEXT_146 = "){" + NL + "\t\t\tfilename_";
  protected final String TEXT_147 = " = filename_";
  protected final String TEXT_148 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t\t}" + NL + "    }" + NL + "    if(filename_";
  protected final String TEXT_149 = " instanceof java.io.InputStream){" + NL + "    \tjava.io.InputStream inputStream_";
  protected final String TEXT_150 = " = (java.io.InputStream)filename_";
  protected final String TEXT_151 = ";" + NL + "    \ttoClose_";
  protected final String TEXT_152 = " = inputStream_";
  protected final String TEXT_153 = ";" + NL + "    \tparser_";
  protected final String TEXT_154 = ".parse(new org.xml.sax.InputSource(inputStream_";
  protected final String TEXT_155 = "));" + NL + "    }else{" + NL + "    \tjava.io.InputStream in_";
  protected final String TEXT_156 = "= new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_157 = "));" + NL + "    \tjava.io.Reader unicodeReader_";
  protected final String TEXT_158 = " = new UnicodeReader(in_";
  protected final String TEXT_159 = ",";
  protected final String TEXT_160 = ");" + NL + "    \ttoClose_";
  protected final String TEXT_161 = " = unicodeReader_";
  protected final String TEXT_162 = ";" + NL + "    \torg.xml.sax.InputSource xmlInputSource_";
  protected final String TEXT_163 = " = new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_164 = ");" + NL + "    \tparser_";
  protected final String TEXT_165 = ".parse(xmlInputSource_";
  protected final String TEXT_166 = ");" + NL + "    }" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_167 = NL + "\t";
  protected final String TEXT_168 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_169 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_170 = NL + "\tthrow(e);";
  protected final String TEXT_171 = NL + "\t";
  protected final String TEXT_172 = NL + "\t\tlog.error(\"";
  protected final String TEXT_173 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_174 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_175 = " = false;";
  protected final String TEXT_176 = NL + "}finally {" + NL + "\tif(toClose_";
  protected final String TEXT_177 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_178 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_179 = "){" + NL + "org.w3c.dom.Document doc_";
  protected final String TEXT_180 = " = parser_";
  protected final String TEXT_181 = ".getDocument();" + NL + "" + NL + "xml_api_";
  protected final String TEXT_182 = ".initXPath(doc_";
  protected final String TEXT_183 = ");" + NL + "org.w3c.dom.NodeList nodelist_";
  protected final String TEXT_184 = " = xml_api_";
  protected final String TEXT_185 = ".getNodeList(doc_";
  protected final String TEXT_186 = ",";
  protected final String TEXT_187 = ");" + NL + "" + NL + "org.w3c.dom.Node node_";
  protected final String TEXT_188 = "  = null;" + NL + "String str_";
  protected final String TEXT_189 = " = null;";
  protected final String TEXT_190 = NL + "for (int i_";
  protected final String TEXT_191 = " = 0; i_";
  protected final String TEXT_192 = " < nodelist_";
  protected final String TEXT_193 = ".getLength(); i_";
  protected final String TEXT_194 = "++) {" + NL + "\torg.w3c.dom.Node tmp_";
  protected final String TEXT_195 = " = nodelist_";
  protected final String TEXT_196 = ".item(i_";
  protected final String TEXT_197 = ");";
  protected final String TEXT_198 = NL + "class NameSpaceTool_";
  protected final String TEXT_199 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    public String addDefaultNSPrefix(String path, String loopPath) {" + NL + "        if (defualtNSPath.size() > 0) {" + NL + "        \tString fullPath = loopPath;" + NL + "        \tif(!path.equals(fullPath)){" + NL + "            \tfor (String tmp : path.split(\"/\")) {" + NL + "            \t\tif ((\"..\").equals(tmp)) {" + NL + "                        fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                    } else {" + NL + "                        fullPath += \"/\" + tmp;" + NL + "                    }" + NL + "            \t}" + NL + "            }" + NL + "            int size = fullPath.split(\"/\").length - 1;" + NL + "            if(size<0) {" + NL + "            \treturn fullPath;" + NL + "            }" + NL + "        \tint[] indexs = new int[size];" + NL + "            java.util.Arrays.fill(indexs, -1);" + NL + "            int length = 0;" + NL + "            for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "                if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                    java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                    length = defualtNSPath.get(i).length();" + NL + "                }" + NL + "            }" + NL + "" + NL + "            StringBuilder newPath = new StringBuilder();" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_200 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_201 = NL + "\tclass XML_NS_RMV_";
  protected final String TEXT_202 = "{\t" + NL + "" + NL + "\t\tpublic void removeNamespace(org.dom4j.Document reader," + NL + "\t\t\t\torg.dom4j.Document writer) {" + NL + "\t\t\torg.dom4j.Element elemReader = reader.getRootElement();" + NL + "\t\t\torg.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "\t\t\t\t\t.getName());" + NL + "\t\t\tif(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "\t\t\t\telemTo.setText(elemReader.getText());" + NL + "\t\t\t}" + NL + "\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) elemReader" + NL + "\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\telemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t}" + NL + "\t\t\tremoveSubNamespace(elemReader, elemTo);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "\t\t\t\torg.dom4j.Element elemTo) {" + NL + "\t\t\tfor (org.dom4j.Element subFrom : (List<org.dom4j.Element>) elemFrom" + NL + "\t\t\t\t\t.elements()) {" + NL + "\t\t\t\torg.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "\t\t\t\t\t\t.getName());" + NL + "\t\t\t\tif(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "\t\t\t\t\ttmpElemTo.setText(subFrom.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) subFrom" + NL + "\t\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\t\ttmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tremoveSubNamespace(subFrom, tmpElemTo);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_203 = NL + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_204 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_205 = NL + "reader_";
  protected final String TEXT_206 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_207 = "());";
  protected final String TEXT_208 = NL + "Object filename_";
  protected final String TEXT_209 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_212 = NL + "\t";
  protected final String TEXT_213 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_214 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_215 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_216 = NL + "\t";
  protected final String TEXT_217 = NL + "\t\tlog.error(\"";
  protected final String TEXT_218 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_219 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_220 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_221 = " != null && filename_";
  protected final String TEXT_222 = " instanceof String && filename_";
  protected final String TEXT_223 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_224 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_225 = " = filename_";
  protected final String TEXT_226 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_227 = NL + "org.dom4j.Document doc_reader_";
  protected final String TEXT_228 = " = null;" + NL + "org.dom4j.Document doc_tmp_";
  protected final String TEXT_229 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_230 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "try {" + NL + "\tif(filename_";
  protected final String TEXT_231 = " instanceof java.io.InputStream){" + NL + "\t\tdoc_reader_";
  protected final String TEXT_232 = " = reader_";
  protected final String TEXT_233 = ".read((java.io.InputStream)filename_";
  protected final String TEXT_234 = ");" + NL + "\t}else{" + NL + "\t\tdoc_reader_";
  protected final String TEXT_235 = " = reader_";
  protected final String TEXT_236 = ".read(new java.io.File(String.valueOf(filename_";
  protected final String TEXT_237 = ")).toURI().toString());" + NL + "\t}" + NL + "\tformat_";
  protected final String TEXT_238 = ".setTrimText(false);" + NL + "\tformat_";
  protected final String TEXT_239 = ".setEncoding(";
  protected final String TEXT_240 = ");" + NL + "\tnew XML_NS_RMV_";
  protected final String TEXT_241 = "().removeNamespace(doc_reader_";
  protected final String TEXT_242 = ",doc_tmp_";
  protected final String TEXT_243 = ");" + NL + "\tdoc_reader_";
  protected final String TEXT_244 = ".clearContent();" + NL + "\tdoc_reader_";
  protected final String TEXT_245 = " = null;" + NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_246 = " = new java.io.FileOutputStream(";
  protected final String TEXT_247 = ");" + NL + "\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_248 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_249 = ", format_";
  protected final String TEXT_250 = ");" + NL + "\toutput_";
  protected final String TEXT_251 = ".write(doc_tmp_";
  protected final String TEXT_252 = ");" + NL + "\toutput_";
  protected final String TEXT_253 = ".close();" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_254 = NL + "\t";
  protected final String TEXT_255 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_256 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_257 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_258 = NL + "\t";
  protected final String TEXT_259 = NL + "\t\tlog.error(\"";
  protected final String TEXT_260 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_261 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_262 = NL + "} finally {" + NL + "\tif(filename_";
  protected final String TEXT_263 = " instanceof java.io.InputStream && filename_";
  protected final String TEXT_264 = "!=null){" + NL + "\t\t((java.io.InputStream)filename_";
  protected final String TEXT_265 = ").close();" + NL + "\t}" + NL + "}" + NL + "filename_";
  protected final String TEXT_266 = " = ";
  protected final String TEXT_267 = ";";
  protected final String TEXT_268 = NL + "boolean isValidFile_";
  protected final String TEXT_269 = " = true;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_270 = " = null;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_271 = " = null;" + NL + "try{" + NL + "\tif(filename_";
  protected final String TEXT_272 = " instanceof java.io.InputStream){" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_273 = " = (java.io.InputStream)filename_";
  protected final String TEXT_274 = ";" + NL + "\t\ttoClose_";
  protected final String TEXT_275 = " = inputStream_";
  protected final String TEXT_276 = ";" + NL + "\t\tdoc_";
  protected final String TEXT_277 = " = reader_";
  protected final String TEXT_278 = ".read(inputStream_";
  protected final String TEXT_279 = ");" + NL + "\t}else{" + NL + "\t\tjava.io.Reader unicodeReader_";
  protected final String TEXT_280 = " = new UnicodeReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_281 = ")),";
  protected final String TEXT_282 = ");" + NL + "\t\ttoClose_";
  protected final String TEXT_283 = " = unicodeReader_";
  protected final String TEXT_284 = ";" + NL + "\t\torg.xml.sax.InputSource in_";
  protected final String TEXT_285 = "= new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_286 = ");" + NL + "\t\tdoc_";
  protected final String TEXT_287 = " = reader_";
  protected final String TEXT_288 = ".read(in_";
  protected final String TEXT_289 = ");" + NL + "\t}" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_290 = NL + "\t";
  protected final String TEXT_291 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_292 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_293 = NL + "\tthrow(e);";
  protected final String TEXT_294 = NL + "\t";
  protected final String TEXT_295 = NL + "\t\tlog.error(\"";
  protected final String TEXT_296 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_297 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_298 = " = false;";
  protected final String TEXT_299 = NL + "} finally {" + NL + "\tif(toClose_";
  protected final String TEXT_300 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_301 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_302 = "){" + NL + "NameSpaceTool_";
  protected final String TEXT_303 = " nsTool_";
  protected final String TEXT_304 = " = new NameSpaceTool_";
  protected final String TEXT_305 = "();" + NL + "nsTool_";
  protected final String TEXT_306 = ".countNSMap(doc_";
  protected final String TEXT_307 = ".getRootElement());" + NL + "java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_308 = " = nsTool_";
  protected final String TEXT_309 = ".xmlNameSpaceMap;  " + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_310 = " = doc_";
  protected final String TEXT_311 = ".createXPath(nsTool_";
  protected final String TEXT_312 = ".addDefaultNSPrefix(";
  protected final String TEXT_313 = ",";
  protected final String TEXT_314 = "));  " + NL + "x_";
  protected final String TEXT_315 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_316 = "); ";
  protected final String TEXT_317 = NL + "org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_318 = " = new org.jaxen.NamespaceContext() {" + NL + "" + NL + "\tpublic String translateNamespacePrefixToUri(String prefix) { " + NL + "\t\treturn \"\";//ignore prefix in xpath when evaluate" + NL + "\t}" + NL + "\t" + NL + "};" + NL + "x_";
  protected final String TEXT_319 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_320 = ");";
  protected final String TEXT_321 = NL + NL + "java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_322 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_323 = ".selectNodes(doc_";
  protected final String TEXT_324 = ");\t" + NL + "XML_API_";
  protected final String TEXT_325 = " xml_api_";
  protected final String TEXT_326 = " = new XML_API_";
  protected final String TEXT_327 = "();" + NL + "String str_";
  protected final String TEXT_328 = " = \"\";" + NL + "org.dom4j.Node node_";
  protected final String TEXT_329 = " = null;" + NL + "" + NL + "//init all mapping xpaths";
  protected final String TEXT_330 = NL + "org.dom4j.XPath xTmp";
  protected final String TEXT_331 = "_";
  protected final String TEXT_332 = " = org.dom4j.DocumentHelper.createXPath(nsTool_";
  protected final String TEXT_333 = ".addDefaultNSPrefix(";
  protected final String TEXT_334 = ",";
  protected final String TEXT_335 = "));" + NL + "xTmp";
  protected final String TEXT_336 = "_";
  protected final String TEXT_337 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_338 = ");";
  protected final String TEXT_339 = NL + "xTmp";
  protected final String TEXT_340 = "_";
  protected final String TEXT_341 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_342 = ");";
  protected final String TEXT_343 = NL + "for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_344 = ": nodeList_";
  protected final String TEXT_345 = ") {";
  protected final String TEXT_346 = NL + "class XML_API_";
  protected final String TEXT_347 = "{" + NL + "\tpublic boolean isDefNull(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0] != null && node[1]!=null && (\"true\").equals(node[1])){" + NL + "        \treturn true;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        return node[0] == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0]!=null ){" + NL + "        \treturn node[0].length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL + "XML_API_";
  protected final String TEXT_348 = " xml_api_";
  protected final String TEXT_349 = " = new XML_API_";
  protected final String TEXT_350 = "();" + NL + "" + NL + "String[] queryPaths_";
  protected final String TEXT_351 = " = new String[]{";
  protected final String TEXT_352 = "\t" + NL + "\t";
  protected final String TEXT_353 = "\t\t" + NL + "\t,";
  protected final String TEXT_354 = "+\"/@xsi:nil\"";
  protected final String TEXT_355 = NL + "};" + NL + "" + NL + "boolean[] asXMLs_";
  protected final String TEXT_356 = " = new boolean[]{";
  protected final String TEXT_357 = "\t" + NL + "\t";
  protected final String TEXT_358 = "\t\t" + NL + "\t,false";
  protected final String TEXT_359 = NL + "};" + NL + "" + NL + "String str_";
  protected final String TEXT_360 = " = \"\";" + NL + "String[] node_";
  protected final String TEXT_361 = " = null;" + NL + "org.talend.xml.sax.SAXLooper looper_";
  protected final String TEXT_362 = " = new org.talend.xml.sax.SAXLooper(";
  protected final String TEXT_363 = ",queryPaths_";
  protected final String TEXT_364 = ",asXMLs_";
  protected final String TEXT_365 = ");";
  protected final String TEXT_366 = NL + "looper_";
  protected final String TEXT_367 = ".setIgnoreDTD(true);";
  protected final String TEXT_368 = NL + "looper_";
  protected final String TEXT_369 = ".setEncoding(";
  protected final String TEXT_370 = ");" + NL + "Object filename_";
  protected final String TEXT_371 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_372 = " = ";
  protected final String TEXT_373 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_374 = NL + "\t";
  protected final String TEXT_375 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_376 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_377 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_378 = NL + "\t\tlog.error(\"";
  protected final String TEXT_379 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_380 = NL + "\t";
  protected final String TEXT_381 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_382 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_383 = " != null && filename_";
  protected final String TEXT_384 = " instanceof String && filename_";
  protected final String TEXT_385 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_386 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_387 = " = filename_";
  protected final String TEXT_388 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL + "if(filename_";
  protected final String TEXT_389 = " instanceof java.io.InputStream){" + NL + "\tlooper_";
  protected final String TEXT_390 = ".parse((java.io.InputStream)filename_";
  protected final String TEXT_391 = ");" + NL + "}else{" + NL + "\tlooper_";
  protected final String TEXT_392 = ".parse(String.valueOf(filename_";
  protected final String TEXT_393 = "));" + NL + "}" + NL + "java.util.Iterator<java.util.Map<String, String>> it_";
  protected final String TEXT_394 = "  = looper_";
  protected final String TEXT_395 = ".iterator();";
  protected final String TEXT_396 = NL + "while (it_";
  protected final String TEXT_397 = ".hasNext()) {" + NL + "\tjava.util.Map<String, String> row_";
  protected final String TEXT_398 = " = it_";
  protected final String TEXT_399 = ".next();";
  protected final String TEXT_400 = NL + "\tnb_line_";
  protected final String TEXT_401 = "++;";
  protected final String TEXT_402 = NL + "\t";
  protected final String TEXT_403 = " = null;\t\t\t";
  protected final String TEXT_404 = NL + "\tboolean whetherReject_";
  protected final String TEXT_405 = " = false;" + NL + "\t";
  protected final String TEXT_406 = " = new ";
  protected final String TEXT_407 = "Struct();" + NL + "\ttry{";
  protected final String TEXT_408 = NL + "\tif(xml_api_";
  protected final String TEXT_409 = ".getNodeType(tmp_";
  protected final String TEXT_410 = ",";
  protected final String TEXT_411 = ")==org.apache.xpath.objects.XObject.CLASS_NODESET){" + NL + "\t\tnode_";
  protected final String TEXT_412 = " = xml_api_";
  protected final String TEXT_413 = ".getSingleNode(tmp_";
  protected final String TEXT_414 = ",";
  protected final String TEXT_415 = ");";
  protected final String TEXT_416 = NL + "    \tif(node_";
  protected final String TEXT_417 = "!=null && node_";
  protected final String TEXT_418 = ".getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && node_";
  protected final String TEXT_419 = ".hasChildNodes()){" + NL + "    \t\tstr_";
  protected final String TEXT_420 = " = contentTool_";
  protected final String TEXT_421 = ".getNodeContent(node_";
  protected final String TEXT_422 = ");" + NL + "    \t}else{" + NL + "    \t\tstr_";
  protected final String TEXT_423 = " = node_";
  protected final String TEXT_424 = "!=null?node_";
  protected final String TEXT_425 = ".getTextContent():\"\";" + NL + "    \t}";
  protected final String TEXT_426 = NL + "\t\tstr_";
  protected final String TEXT_427 = " = node_";
  protected final String TEXT_428 = "!=null?node_";
  protected final String TEXT_429 = ".getTextContent():\"\";";
  protected final String TEXT_430 = NL + "\t}else{" + NL + "\t\tnode_";
  protected final String TEXT_431 = " = tmp_";
  protected final String TEXT_432 = ";" + NL + "\t\tstr_";
  protected final String TEXT_433 = " = xml_api_";
  protected final String TEXT_434 = ".getNodeString(tmp_";
  protected final String TEXT_435 = ",";
  protected final String TEXT_436 = ");" + NL + "\t}";
  protected final String TEXT_437 = NL + "\tif(true) {" + NL + "\t\t";
  protected final String TEXT_438 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_439 = " - Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t\t";
  protected final String TEXT_440 = NL + "\t\tthrow new RuntimeException(\"Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t}";
  protected final String TEXT_441 = NL + "    Object obj";
  protected final String TEXT_442 = "_";
  protected final String TEXT_443 = " = xTmp";
  protected final String TEXT_444 = "_";
  protected final String TEXT_445 = ".evaluate(temp_";
  protected final String TEXT_446 = ");" + NL + "    if(obj";
  protected final String TEXT_447 = "_";
  protected final String TEXT_448 = " == null) {" + NL + "    \tnode_";
  protected final String TEXT_449 = " = null;";
  protected final String TEXT_450 = NL + "\t\tstr_";
  protected final String TEXT_451 = " = null;";
  protected final String TEXT_452 = NL + "    \tstr_";
  protected final String TEXT_453 = " = \"\";";
  protected final String TEXT_454 = NL + "    \t" + NL + "    } else if(obj";
  protected final String TEXT_455 = "_";
  protected final String TEXT_456 = " instanceof org.dom4j.Node) {" + NL + "    \tnode_";
  protected final String TEXT_457 = " = (org.dom4j.Node)obj";
  protected final String TEXT_458 = "_";
  protected final String TEXT_459 = ";";
  protected final String TEXT_460 = NL + "\t\tstr_";
  protected final String TEXT_461 = " = node_";
  protected final String TEXT_462 = ".asXML();";
  protected final String TEXT_463 = NL + "    \tstr_";
  protected final String TEXT_464 = " = org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_465 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_466 = NL + "    } else if(obj";
  protected final String TEXT_467 = "_";
  protected final String TEXT_468 = " instanceof String || obj";
  protected final String TEXT_469 = "_";
  protected final String TEXT_470 = " instanceof Number){" + NL + "    \tnode_";
  protected final String TEXT_471 = " = temp_";
  protected final String TEXT_472 = ";" + NL + "    \tstr_";
  protected final String TEXT_473 = " = String.valueOf(obj";
  protected final String TEXT_474 = "_";
  protected final String TEXT_475 = ");" + NL + "    } else if(obj";
  protected final String TEXT_476 = "_";
  protected final String TEXT_477 = " instanceof java.util.List){" + NL + "    \tjava.util.List<org.dom4j.Node> nodes_";
  protected final String TEXT_478 = " = (java.util.List<org.dom4j.Node>)obj";
  protected final String TEXT_479 = "_";
  protected final String TEXT_480 = ";" + NL + "    \tnode_";
  protected final String TEXT_481 = " = nodes_";
  protected final String TEXT_482 = ".size()>0 ? nodes_";
  protected final String TEXT_483 = ".get(0) : null;";
  protected final String TEXT_484 = NL + "\t\tstr_";
  protected final String TEXT_485 = " = node_";
  protected final String TEXT_486 = "==null?null:node_";
  protected final String TEXT_487 = ".asXML();";
  protected final String TEXT_488 = NL + "    \tstr_";
  protected final String TEXT_489 = " = node_";
  protected final String TEXT_490 = "==null?\"\":org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_491 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_492 = NL + "\t}";
  protected final String TEXT_493 = NL + "\tstr_";
  protected final String TEXT_494 = " = row_";
  protected final String TEXT_495 = ".get(";
  protected final String TEXT_496 = ");";
  protected final String TEXT_497 = NL + "\tnode_";
  protected final String TEXT_498 = " = new String[]{str_";
  protected final String TEXT_499 = ",row_";
  protected final String TEXT_500 = ".get(";
  protected final String TEXT_501 = "+\"/@xsi:nil\")};";
  protected final String TEXT_502 = NL + "\tnode_";
  protected final String TEXT_503 = " = new String[]{str_";
  protected final String TEXT_504 = ",null};";
  protected final String TEXT_505 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_506 = ".";
  protected final String TEXT_507 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_508 = ",";
  protected final String TEXT_509 = ",";
  protected final String TEXT_510 = ");";
  protected final String TEXT_511 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_512 = ".";
  protected final String TEXT_513 = " = str_";
  protected final String TEXT_514 = ";";
  protected final String TEXT_515 = NL + "\t\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_516 = ".append(";
  protected final String TEXT_517 = ".";
  protected final String TEXT_518 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_519 = NL + "\t\t\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_520 = ".append(\"|\");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_521 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_522 = ".isDefNull(node_";
  protected final String TEXT_523 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_524 = ".";
  protected final String TEXT_525 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_526 = ".isEmpty(node_";
  protected final String TEXT_527 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_528 = ".";
  protected final String TEXT_529 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_530 = ".isMissing(node_";
  protected final String TEXT_531 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_532 = ".";
  protected final String TEXT_533 = " =";
  protected final String TEXT_534 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_535 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_536 = ".isEmpty(node_";
  protected final String TEXT_537 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_538 = ".";
  protected final String TEXT_539 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_540 = ".isMissing(node_";
  protected final String TEXT_541 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_542 = ".";
  protected final String TEXT_543 = " =";
  protected final String TEXT_544 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_545 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_546 = ".isDefNull(node_";
  protected final String TEXT_547 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_548 = ".";
  protected final String TEXT_549 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_550 = ".isEmpty(node_";
  protected final String TEXT_551 = ") || xml_api_";
  protected final String TEXT_552 = ".isMissing(node_";
  protected final String TEXT_553 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_554 = ".";
  protected final String TEXT_555 = "=";
  protected final String TEXT_556 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_557 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_558 = ".isMissing(node_";
  protected final String TEXT_559 = ") || xml_api_";
  protected final String TEXT_560 = ".isEmpty(node_";
  protected final String TEXT_561 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_562 = ".";
  protected final String TEXT_563 = " =";
  protected final String TEXT_564 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_565 = NL + "\t\t";
  protected final String TEXT_566 = ".";
  protected final String TEXT_567 = " = str_";
  protected final String TEXT_568 = ";";
  protected final String TEXT_569 = NL + "\t\t";
  protected final String TEXT_570 = ".";
  protected final String TEXT_571 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_572 = ", ";
  protected final String TEXT_573 = ",false);";
  protected final String TEXT_574 = NL + "\t\t";
  protected final String TEXT_575 = ".";
  protected final String TEXT_576 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_577 = ", ";
  protected final String TEXT_578 = ");";
  protected final String TEXT_579 = "\t\t\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_580 = ".";
  protected final String TEXT_581 = " = str_";
  protected final String TEXT_582 = ".getBytes(";
  protected final String TEXT_583 = ");";
  protected final String TEXT_584 = NL + "\t\t";
  protected final String TEXT_585 = ".";
  protected final String TEXT_586 = " = ParserUtils.parseTo_";
  protected final String TEXT_587 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_588 = ", ";
  protected final String TEXT_589 = ", ";
  protected final String TEXT_590 = "));";
  protected final String TEXT_591 = NL + "\t\t";
  protected final String TEXT_592 = ".";
  protected final String TEXT_593 = " = ParserUtils.parseTo_";
  protected final String TEXT_594 = "(str_";
  protected final String TEXT_595 = ");";
  protected final String TEXT_596 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_597 = ".append(";
  protected final String TEXT_598 = ".";
  protected final String TEXT_599 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_600 = NL + "\t\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_601 = ".append(\"|\");" + NL + "\t\t\t\t\t\t\t       ";
  protected final String TEXT_602 = NL + "\t}";
  protected final String TEXT_603 = " ";
  protected final String TEXT_604 = " = null; ";
  protected final String TEXT_605 = NL + "\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_606 = " = true;";
  protected final String TEXT_607 = NL + "\t\t\t";
  protected final String TEXT_608 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_609 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_610 = NL + "            throw(e);";
  protected final String TEXT_611 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_612 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_613 = NL + "                    ";
  protected final String TEXT_614 = " = new ";
  protected final String TEXT_615 = "Struct();";
  protected final String TEXT_616 = NL + "                    ";
  protected final String TEXT_617 = ".";
  protected final String TEXT_618 = " = ";
  protected final String TEXT_619 = ".";
  protected final String TEXT_620 = ";";
  protected final String TEXT_621 = NL + "                ";
  protected final String TEXT_622 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_623 = ";";
  protected final String TEXT_624 = NL + "                ";
  protected final String TEXT_625 = " = null;";
  protected final String TEXT_626 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_627 = NL + "                ";
  protected final String TEXT_628 = " = null;";
  protected final String TEXT_629 = NL + "            \t";
  protected final String TEXT_630 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_631 = ";";
  protected final String TEXT_632 = NL + "    }";
  protected final String TEXT_633 = NL + "\t\t";
  protected final String TEXT_634 = "if(!whetherReject_";
  protected final String TEXT_635 = ") { ";
  protected final String TEXT_636 = "      " + NL + "             if(";
  protected final String TEXT_637 = " == null){ " + NL + "            \t ";
  protected final String TEXT_638 = " = new ";
  protected final String TEXT_639 = "Struct();" + NL + "             }";
  protected final String TEXT_640 = NL + "\t    \t ";
  protected final String TEXT_641 = ".";
  protected final String TEXT_642 = " = ";
  protected final String TEXT_643 = ".";
  protected final String TEXT_644 = ";    \t\t\t\t";
  protected final String TEXT_645 = NL + "\t\t";
  protected final String TEXT_646 = " } ";
  protected final String TEXT_647 = "\t";
  protected final String TEXT_648 = NL + "\t" + NL + "\tif (nb_line_";
  protected final String TEXT_649 = ">";
  protected final String TEXT_650 = ") {" + NL + "\t";
  protected final String TEXT_651 = NL + "\t\t\tlooper_";
  protected final String TEXT_652 = ".stopRead();" + NL + "\t";
  protected final String TEXT_653 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_654 = NL;
  protected final String TEXT_655 = NL;

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
        
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String filename = ElementParameterParser.getValue(node, "__FILENAME__");

String ignore_NS_Str = ElementParameterParser.getValue(node, "__IGNORE_NS__");
String tmp_filename = ElementParameterParser.getValue(node, "__TMP_FILENAME__");

String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");

String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (("").equals(limit)) {
	limit = "-1";
}

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
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
    stringBuffer.append(ElementParameterParser.getValue(node, "__LOOP_QUERY__"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append("".equals(ElementParameterParser.getValue(node, "__LIMIT__"))?"\"\"":ElementParameterParser.getValue(node, "__LIMIT__"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));
    stringBuffer.append(TEXT_47);
     if("true".equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"))) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getValue(node, "__THOUSANDS_SEPARATOR__"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DECIMAL_SEPARATOR__"));
    stringBuffer.append(TEXT_54);
     } 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GENERATION_MODE__"));
    stringBuffer.append(TEXT_58);
     if("DOM4J".equalsIgnoreCase(ElementParameterParser.getValue(node, "__GENERATION_MODE__"))) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IGNORE_NS__"));
    stringBuffer.append(TEXT_62);
     if("true".equals(ElementParameterParser.getValue(node, "__IGNORE_NS__"))) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TMP_FILENAME__"));
    stringBuffer.append(TEXT_66);
     } 
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USE_SEPARATOR__"));
    stringBuffer.append(TEXT_71);
     if("true".equals(ElementParameterParser.getValue(node, "__USE_SEPARATOR__"))) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__"));
    stringBuffer.append(TEXT_75);
     } 
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ENCODING_TYPE__"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CHECK_DATE__"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
}
		
/* -------------------------- */

log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
	}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
// *** Xerces *** //
if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    if("true".equals(useSeparator)){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
      }

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_131);
    if (dieOnError) {
    stringBuffer.append(TEXT_132);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    }else{
    stringBuffer.append(TEXT_136);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    if (dieOnError) {
    stringBuffer.append(TEXT_167);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    }else{
    stringBuffer.append(TEXT_171);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    
// *** Dom4j *** //
}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    
	}

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
      }

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_211);
    if (dieOnError) {
    stringBuffer.append(TEXT_212);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    }
    stringBuffer.append(TEXT_215);
    }else{
    stringBuffer.append(TEXT_216);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(tmp_filename );
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
    if (dieOnError) {
    stringBuffer.append(TEXT_254);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    }else{
    stringBuffer.append(TEXT_258);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    }
    stringBuffer.append(TEXT_261);
    }
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_267);
    
	}

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    if (dieOnError) {
    stringBuffer.append(TEXT_290);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    }
    stringBuffer.append(TEXT_293);
    }else{
    stringBuffer.append(TEXT_294);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    }
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    }
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    if(("true").equals(ignore_NS_Str)){
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
	for (int i=0;i<mapping.size();i++) {
		String query = mapping.get(i).get("QUERY");

    stringBuffer.append(TEXT_330);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
		if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_339);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
		}
	}

    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
// *** SAX *** //
}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
	boolean first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_352);
    stringBuffer.append(first?"":",");
    stringBuffer.append(path.get("QUERY"));
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_353);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_354);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
	first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_357);
    stringBuffer.append(first?"":",");
    stringBuffer.append("true".equals(path.get("NODECHECK"))? "true":"false" );
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_358);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    if(ignoreDTD){
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    }
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_373);
    if (dieOnError) {
    stringBuffer.append(TEXT_374);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    }
    stringBuffer.append(TEXT_377);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    }
    stringBuffer.append(TEXT_380);
    }else{
    stringBuffer.append(TEXT_381);
    }
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    
}

    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
		if (conns!=null) {
//************ add for reject start*****************
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
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_402);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_403);
    
				}
    		}
//***************************end********************
			if (conns.size()>0) { // S_if_a_0_0		
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_407);
    
				
				for (int i=0;i<mapping.size();i++) { // S_for_a_1_0
					String query = mapping.get(i).get("QUERY");
					String nodeCheck = mapping.get(i).get("NODECHECK");
					if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_415);
    
						if("true".equals(useSeparator)){

    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
						}else{

    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
						}

    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_436);
    
					}else if(("Dom4j").equals(mode)){
						//TDI-18498
						boolean isWrongConfig = false;
						
						for(IMetadataColumn column:columns) {
							if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
								if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
									if("id_Document".equals(column.getTalendType()) && "false".equals(nodeCheck)) {
										isWrongConfig = true;
										break;
									}
								}
							}
						}
						
						if(isWrongConfig) {

    stringBuffer.append(TEXT_437);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    }
    stringBuffer.append(TEXT_440);
    
						}

    stringBuffer.append(TEXT_441);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    
						if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    
							
						}else{

    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    
						}

    stringBuffer.append(TEXT_454);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    
						if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    
							
						}else{

    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    
						}

    stringBuffer.append(TEXT_466);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    
						if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    
							
						}else{

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    
						}

    stringBuffer.append(TEXT_492);
    
					}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_496);
    
						if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_501);
    
						}else{

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    
						}
					}
					for(IMetadataColumn column:columns) {  // S_for_0_1
						if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // S_if_0_2
							if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { // S_if_0_3
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								
								boolean isNotSetDefault = false;
								String defaultValue=column.getDefault();
								if(defaultValue!=null){
									isNotSetDefault = defaultValue.length()==0;
								}else{
									isNotSetDefault=true;
								}
								

								if(("Dom4j").equals(mode) && ("true").equals(nodeCheck)){
									if("id_Document".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_505);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(ignoreDTD);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_510);
    
									} else {

    stringBuffer.append(TEXT_511);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    
									}
									if(isLog4jEnabled){
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_518);
    if(i < mapping.size()-1){
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    }
									}
									continue;
								}
								if(javaType == JavaTypesManager.STRING){
									if(column.isNullable()){

    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_534);
    
									}else{ // column.isNullable()

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_544);
    
									}
								}else{ // other type
									if(column.isNullable()){

    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_556);
    
								  	}else{ // column.isNullable()

    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_564);
    
									}
								}
								
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_565);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    
								} else if (javaType == JavaTypesManager.DATE) {
									if(checkDate) {

    stringBuffer.append(TEXT_569);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_573);
      
									} else {

    stringBuffer.append(TEXT_574);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_578);
    										
									}
								} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_579);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_583);
    
								} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_584);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_586);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_589);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_590);
    
								} else {

    stringBuffer.append(TEXT_591);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_593);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    
								}
								if(isLog4jEnabled){
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_599);
    if(i < mapping.size()-1){
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    }
								}

    stringBuffer.append(TEXT_602);
    
							} //S_if_1_2
						} // S_if_1_1
					} // S_for_1_0
				} // S_for_a_0_1

     log4jFileUtil.debugRetriveData(node); 
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_603);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_604);
    }
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_607);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    }
    stringBuffer.append(TEXT_610);
    
        } else {
			if(isLog4jEnabled){
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_613);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_615);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_616);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_618);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_620);
    
                }
                
    stringBuffer.append(TEXT_621);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_625);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_626);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_628);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_629);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_631);
    }
		}
        
    stringBuffer.append(TEXT_632);
    
				} //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			} // S_if_a_1_1

//***********************************
			if (conns.size()>0) {	
				boolean isFirstEnter = true;
				for (int i=0;i<conns.size();i++) {
					IConnection tmpconn = conns.get(i);
					if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_633);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_636);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_639);
    
			    	 	for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_640);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_644);
    
				 		}
					}
				}

    stringBuffer.append(TEXT_645);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_646);
     } 
    stringBuffer.append(TEXT_647);
    
			}
//***********************************

		} // if(conn!=null)
		
		// limit
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_650);
    if(("SAX").equals(mode)) {
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    }
    stringBuffer.append(TEXT_653);
     
		}
	}// if (metadata!=null)
} //if ((metadatas!=null)&&(metadatas.size()>0))

    stringBuffer.append(TEXT_654);
    stringBuffer.append(TEXT_655);
    return stringBuffer.toString();
  }
}
