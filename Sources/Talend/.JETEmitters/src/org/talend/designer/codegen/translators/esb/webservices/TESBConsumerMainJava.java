package org.talend.designer.codegen.translators.esb.webservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeConnectionsHelper;
import org.talend.designer.codegen.config.NodeParamsHelper;

public class TESBConsumerMainJava
{
  protected static String nl;
  public static synchronized TESBConsumerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBConsumerMainJava result = new TESBConsumerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    final javax.xml.namespace.QName serviceName_";
  protected final String TEXT_4 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_5 = "\", \"";
  protected final String TEXT_6 = "\");" + NL + "    final javax.xml.namespace.QName portName_";
  protected final String TEXT_7 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_8 = "\", \"";
  protected final String TEXT_9 = "\");" + NL + "" + NL + "    try {" + NL + "        routines.system.Document requestTalendDoc_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".payload;" + NL + "" + NL + "        try {" + NL + "            org.dom4j.Document responseDoc_";
  protected final String TEXT_12 = " = null;" + NL;
  protected final String TEXT_13 = NL + "                final java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_14 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_15 = "slCustomProps_";
  protected final String TEXT_16 = ".put(";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + NL + "            java.util.Map<String, String> customProps_";
  protected final String TEXT_20 = " = null;";
  protected final String TEXT_21 = NL + "                    customProps_";
  protected final String TEXT_22 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_23 = NL + "                    customProps_";
  protected final String TEXT_24 = ".put(";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "                class EsbJobCorrelationCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "                    private String correlationId;" + NL + "                    public EsbJobCorrelationCallbackHandler(final String correlationId) {" + NL + "                        if (null != correlationId && correlationId.length() > 0) {" + NL + "                            this.correlationId = correlationId;" + NL + "                        }" + NL + "                    }" + NL + "                    public String getCorrelationId() {" + NL + "                        return correlationId;" + NL + "                    };" + NL + "                }" + NL + "                final Object correlationIDCallbackHandler = new EsbJobCorrelationCallbackHandler(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + NL + "            final List<org.apache.cxf.headers.Header> soapHeaders_";
  protected final String TEXT_30 = " = new java.util.ArrayList<org.apache.cxf.headers.Header>();";
  protected final String TEXT_31 = NL + "                final Object securityToken_";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "                    securityToken_";
  protected final String TEXT_34 = " = globalMap.get(\"";
  protected final String TEXT_35 = "_SECURITY_TOKEN\");";
  protected final String TEXT_36 = NL + "                final routines.system.Document headersTalendDoc_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ".headers;" + NL + "                if (null != headersTalendDoc_";
  protected final String TEXT_39 = " && null != headersTalendDoc_";
  protected final String TEXT_40 = ".getDocument()) {" + NL + "                    javax.xml.transform.dom.DOMResult result = new javax.xml.transform.dom.DOMResult();" + NL + "                    javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(new org.dom4j.io.DocumentSource(headersTalendDoc_";
  protected final String TEXT_41 = ".getDocument()), result);" + NL + "                    for (org.w3c.dom.Node node = ((org.w3c.dom.Document) result.getNode()).getDocumentElement().getFirstChild();" + NL + "                            node != null;" + NL + "                            node = node.getNextSibling()) {" + NL + "                        if (org.w3c.dom.Node.ELEMENT_NODE == node.getNodeType()) {" + NL + "                            soapHeaders_";
  protected final String TEXT_42 = ".add(new org.apache.cxf.headers.Header(new javax.xml.namespace.QName(node.getNamespaceURI(), node.getLocalName()), node));" + NL + "                        }" + NL + "                    }" + NL + "                }";
  protected final String TEXT_43 = NL + NL + "            if (null == this.registry) {" + NL + "                GenericConsumer genericConsumer_";
  protected final String TEXT_44 = " = new GenericConsumer();" + NL + "                genericConsumer_";
  protected final String TEXT_45 = ".setServiceQName(serviceName_";
  protected final String TEXT_46 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_47 = ".setPortQName(portName_";
  protected final String TEXT_48 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_49 = ".setOperationQName(new javax.xml.namespace.QName(\"";
  protected final String TEXT_50 = "\", \"";
  protected final String TEXT_51 = "\"));" + NL + "                genericConsumer_";
  protected final String TEXT_52 = ".setIsRequestResponse(";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "                        genericConsumer_";
  protected final String TEXT_55 = ".setSoapAction(\"";
  protected final String TEXT_56 = "\");";
  protected final String TEXT_57 = NL + NL + "                genericConsumer_";
  protected final String TEXT_58 = ".setAddress(";
  protected final String TEXT_59 = ");" + NL + "                if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_60 = ".wsdl\")) {" + NL + "                    genericConsumer_";
  protected final String TEXT_61 = ".setWsdlURL(\"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_62 = ".wsdl\");" + NL + "                }" + NL + "" + NL + "                java.util.Collection<org.apache.cxf.feature.Feature> esbFeatures_";
  protected final String TEXT_63 = " =" + NL + "                        new java.util.ArrayList<org.apache.cxf.feature.Feature>();" + NL;
  protected final String TEXT_64 = NL + "                    genericConsumer_";
  protected final String TEXT_65 = ".setAddress(\"locator://\");" + NL + "" + NL + "                    // if (!inOSGi) {" + NL + "                    genericConsumer_";
  protected final String TEXT_66 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "                    // }" + NL + "                    org.talend.esb.servicelocator.cxf.LocatorFeature featureSL_";
  protected final String TEXT_67 = " = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "                    if (null != slCustomProps_";
  protected final String TEXT_68 = " && !slCustomProps_";
  protected final String TEXT_69 = ".isEmpty()) {" + NL + "                        featureSL_";
  protected final String TEXT_70 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_71 = ");" + NL + "                    }" + NL + "                    esbFeatures_";
  protected final String TEXT_72 = ".add(featureSL_";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "                    // if (null == eventFeature) {" + NL + "                    org.springframework.context.support.ClassPathXmlApplicationContext classpathXmlApplicationContext =" + NL + "                            new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\");" + NL + "                    org.talend.esb.sam.agent.feature.EventFeature featureSAM_";
  protected final String TEXT_75 = " = classpathXmlApplicationContext.getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "                    // }" + NL + "                    if (null != customProps_";
  protected final String TEXT_76 = " && !customProps_";
  protected final String TEXT_77 = ".isEmpty()) {" + NL + "                        org.talend.esb.sam.common.handler.impl.CustomInfoHandler ciHandler = new org.talend.esb.sam.common.handler.impl.CustomInfoHandler();" + NL + "                        ciHandler.setCustomInfo(customProps_";
  protected final String TEXT_78 = ");" + NL + "                        featureSAM_";
  protected final String TEXT_79 = ".setHandler(ciHandler);" + NL + "                    }" + NL + "                    esbFeatures_";
  protected final String TEXT_80 = ".add(featureSAM_";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "                    esbFeatures_";
  protected final String TEXT_83 = ".add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_84 = NL + "                    genericConsumer_";
  protected final String TEXT_85 = ".setCorrelationIDCallbackHandler(correlationIDCallbackHandler);";
  protected final String TEXT_86 = NL + "                genericConsumer_";
  protected final String TEXT_87 = ".setEsbFeatures(esbFeatures_";
  protected final String TEXT_88 = ");" + NL;
  protected final String TEXT_89 = NL + "                    genericConsumer_";
  protected final String TEXT_90 = ".setAuthType(\"";
  protected final String TEXT_91 = "\");" + NL + "                    genericConsumer_";
  protected final String TEXT_92 = ".setUsername(";
  protected final String TEXT_93 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_94 = ".setPassword(";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "                    genericConsumer_";
  protected final String TEXT_97 = ".setProxyServer(";
  protected final String TEXT_98 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_99 = ".setProxyPort(";
  protected final String TEXT_100 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_101 = ".setProxyUsername(";
  protected final String TEXT_102 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_103 = ".setProxyPassword(";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "                genericConsumer_";
  protected final String TEXT_106 = ".setConnectionTimeout((long)(";
  protected final String TEXT_107 = " * 1000L));" + NL + "                genericConsumer_";
  protected final String TEXT_108 = ".setReceiveTimeout((long)(";
  protected final String TEXT_109 = " * 1000L));" + NL + "" + NL + "                genericConsumer_";
  protected final String TEXT_110 = ".setLogMessages(";
  protected final String TEXT_111 = ");" + NL;
  protected final String TEXT_112 = NL + "                    System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "                    System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_113 = ");" + NL + "                    System.setProperty(\"javax.net.ssl.trustStorePassword\", ";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + NL + "                if (!soapHeaders_";
  protected final String TEXT_116 = ".isEmpty()) {" + NL + "                    genericConsumer_";
  protected final String TEXT_117 = ".setSoapHeaders(soapHeaders_";
  protected final String TEXT_118 = ");" + NL + "                }" + NL + "" + NL + "                responseDoc_";
  protected final String TEXT_119 = " = genericConsumer_";
  protected final String TEXT_120 = ".invoke(requestTalendDoc_";
  protected final String TEXT_121 = ".getDocument());";
  protected final String TEXT_122 = NL + "                    globalMap.put(\"";
  protected final String TEXT_123 = "_CORRELATION_ID\", genericConsumer_";
  protected final String TEXT_124 = ".getCorrelationID());";
  protected final String TEXT_125 = NL + "            } else {" + NL + "                ESBConsumer consumer_";
  protected final String TEXT_126 = " = this.registry.createConsumer(" + NL + "                    new ESBEndpointInfo() {" + NL + "" + NL + "                        @SuppressWarnings(\"serial\")" + NL + "                        private java.util.Map<String, Object> props = new java.util.HashMap<String, Object>() {{" + NL + "                            put(\"dataFormat\", \"PAYLOAD\");" + NL + "                            put(\"portName\", portName_";
  protected final String TEXT_127 = ".toString());" + NL + "                            put(\"serviceName\", serviceName_";
  protected final String TEXT_128 = ".toString());" + NL + "                            put(\"defaultOperationName\", \"";
  protected final String TEXT_129 = "\");" + NL + "                            put(\"defaultOperationNameSpace\", \"\");" + NL + "                            put(\"soapAction\", \"";
  protected final String TEXT_130 = "\");" + NL + "                            if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_131 = ".wsdl\")) {" + NL + "                                put(\"wsdlURL\", \"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_132 = ".wsdl\");" + NL + "                            }" + NL + "                            put(\"publishedEndpointUrl\", ";
  protected final String TEXT_133 = ");" + NL + "                            put(\"COMMUNICATION_STYLE\", \"";
  protected final String TEXT_134 = "\");" + NL + "" + NL + "                            put(\"logMessages\", ";
  protected final String TEXT_135 = ");" + NL + "" + NL + "                            // use Service Locator" + NL + "                            put(\"useServiceLocator\", ";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "                                put(\"LocatorSelectionStrategy\", \"";
  protected final String TEXT_138 = "\");" + NL + "                                put(\"SL-PROPS\", slCustomProps_";
  protected final String TEXT_139 = ");";
  protected final String TEXT_140 = NL + "                            // use Service Activity Monitor" + NL + "                            put(\"useServiceActivityMonitor\", ";
  protected final String TEXT_141 = ");" + NL;
  protected final String TEXT_142 = NL + "                                put(\"useServiceRegistry\", ";
  protected final String TEXT_143 = ");" + NL + "                                put(\"username\", ";
  protected final String TEXT_144 = ");" + NL + "                                put(\"password\", ";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "                                    put(\"role\", ";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "                                    put(\"useCrypto\", ";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "                                        put(\"role\", ";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "                                        put(\"useCrypto\", ";
  protected final String TEXT_153 = ");";
  protected final String TEXT_154 = NL + "                                put(\"esbSecurity\", \"";
  protected final String TEXT_155 = "\");" + NL + "                                put(\"username\", ";
  protected final String TEXT_156 = ");" + NL + "                                put(\"password\", ";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + NL + "                            if (!soapHeaders_";
  protected final String TEXT_159 = ".isEmpty()) {" + NL + "                                put(\"soapHeaders\", soapHeaders_";
  protected final String TEXT_160 = ");" + NL + "                            }";
  protected final String TEXT_161 = NL + "                                put(\"securityToken\", securityToken_";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "                                String alias_";
  protected final String TEXT_164 = " = ";
  protected final String TEXT_165 = ";" + NL + "                                if (null != alias_";
  protected final String TEXT_166 = " && !\"\".equals(alias_";
  protected final String TEXT_167 = ".trim())) {" + NL + "                                    put(\"alias\", alias_";
  protected final String TEXT_168 = ");" + NL + "                                }";
  protected final String TEXT_169 = NL + "                                put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, correlationIDCallbackHandler);" + NL + "                                put(\"enhancedResponse\", true);";
  protected final String TEXT_170 = NL + "                        }};" + NL + "" + NL + "                        public String getEndpointUri() {" + NL + "                            // projectName + \"_\" + processName + \"_\" + componentName" + NL + "                            return \"";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = "_";
  protected final String TEXT_173 = "\";" + NL + "                        }" + NL + "" + NL + "                        public java.util.Map<String, Object> getEndpointProperties() {" + NL + "                            return props;" + NL + "                        }" + NL + "" + NL + "                        public String getEndpointKey() {" + NL + "                            return \"cxf\";" + NL + "                        }" + NL + "                    }" + NL + "                );" + NL + "" + NL + "                Object request_";
  protected final String TEXT_174 = " = wrapPayload(requestTalendDoc_";
  protected final String TEXT_175 = ".getDocument(), customProps_";
  protected final String TEXT_176 = ");" + NL + "                Object consumerResponse_";
  protected final String TEXT_177 = " = consumer_";
  protected final String TEXT_178 = ".invoke(request_";
  protected final String TEXT_179 = ");" + NL + "                if (null == consumerResponse_";
  protected final String TEXT_180 = ") {" + NL + "                    // one way call" + NL + "                } else {" + NL + "                    if(consumerResponse_";
  protected final String TEXT_181 = " instanceof java.util.Map) {" + NL + "                        java.util.Map<?,?> responseMap_";
  protected final String TEXT_182 = " = (java.util.Map<?,?>)consumerResponse_";
  protected final String TEXT_183 = ";" + NL + "                        responseDoc_";
  protected final String TEXT_184 = " = (org.dom4j.Document) responseMap_";
  protected final String TEXT_185 = ".get(\"payload\");";
  protected final String TEXT_186 = NL + "                            globalMap.put(\"";
  protected final String TEXT_187 = "_CORRELATION_ID\", responseMap_";
  protected final String TEXT_188 = ".get(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.MESSAGE_CORRELATION_ID));";
  protected final String TEXT_189 = NL + "                    } else if (consumerResponse_";
  protected final String TEXT_190 = " instanceof org.dom4j.Document) {" + NL + "                        responseDoc_";
  protected final String TEXT_191 = " = (org.dom4j.Document) consumerResponse_";
  protected final String TEXT_192 = ";" + NL + "                    } else {" + NL + "                        throw new RuntimeException(\"Incompatible consumer response: \" + consumerResponse_";
  protected final String TEXT_193 = ".getClass().getName());" + NL + "                    }" + NL + "                }" + NL + "            }";
  protected final String TEXT_194 = NL + "                if (";
  protected final String TEXT_195 = " == null) {";
  protected final String TEXT_196 = NL + "                    ";
  protected final String TEXT_197 = " = new ";
  protected final String TEXT_198 = "Struct();" + NL + "                }" + NL + "                routines.system.Document responseTalendDoc_";
  protected final String TEXT_199 = " = null;" + NL + "                if (null != responseDoc_";
  protected final String TEXT_200 = ") {" + NL + "                    responseTalendDoc_";
  protected final String TEXT_201 = " = new routines.system.Document();" + NL + "                    responseTalendDoc_";
  protected final String TEXT_202 = ".setDocument(responseDoc_";
  protected final String TEXT_203 = ");" + NL + "                }";
  protected final String TEXT_204 = NL + "                ";
  protected final String TEXT_205 = ".payload = responseTalendDoc_";
  protected final String TEXT_206 = ";";
  protected final String TEXT_207 = NL + "        } catch (Exception e_";
  protected final String TEXT_208 = ") {" + NL + "            java.util.Map<String, Object> faultInfo_";
  protected final String TEXT_209 = " = collectFaultInfo(e_";
  protected final String TEXT_210 = ");" + NL + "            if (null == faultInfo_";
  protected final String TEXT_211 = ") {" + NL + "                throw e_";
  protected final String TEXT_212 = "; // non fault exception" + NL + "            }";
  protected final String TEXT_213 = NL + "                if (";
  protected final String TEXT_214 = " == null) {";
  protected final String TEXT_215 = NL + "                    ";
  protected final String TEXT_216 = " = new ";
  protected final String TEXT_217 = "Struct();" + NL + "                }" + NL;
  protected final String TEXT_218 = NL + "                ";
  protected final String TEXT_219 = ".faultCode = (String) faultInfo_";
  protected final String TEXT_220 = ".get(\"faultCode\");";
  protected final String TEXT_221 = NL + "                ";
  protected final String TEXT_222 = ".faultString = (String) faultInfo_";
  protected final String TEXT_223 = ".get(\"faultString\");";
  protected final String TEXT_224 = NL + "                ";
  protected final String TEXT_225 = ".faultActor = (String) faultInfo_";
  protected final String TEXT_226 = ".get(\"faultActor\");";
  protected final String TEXT_227 = NL + "                ";
  protected final String TEXT_228 = ".faultNode = (String) faultInfo_";
  protected final String TEXT_229 = ".get(\"faultNode\");";
  protected final String TEXT_230 = NL + "                ";
  protected final String TEXT_231 = ".faultRole = (String) faultInfo_";
  protected final String TEXT_232 = ".get(\"faultRole\");" + NL + "" + NL + "                if (null != faultInfo_";
  protected final String TEXT_233 = ".get(\"faultDetail\")) {";
  protected final String TEXT_234 = NL + "                    ";
  protected final String TEXT_235 = ".faultDetail = new routines.system.Document();";
  protected final String TEXT_236 = NL + "                    ";
  protected final String TEXT_237 = ".faultDetail.setDocument((org.dom4j.Document) faultInfo_";
  protected final String TEXT_238 = ".get(\"faultDetail\"));" + NL + "                }" + NL;
  protected final String TEXT_239 = NL + "                printFaultInfo(faultInfo_";
  protected final String TEXT_240 = ");" + NL + "                e_";
  protected final String TEXT_241 = ".printStackTrace(System.err);";
  protected final String TEXT_242 = NL + "        }" + NL + "    } catch (Exception e_";
  protected final String TEXT_243 = "){";
  protected final String TEXT_244 = NL + "            throw(e_";
  protected final String TEXT_245 = ");";
  protected final String TEXT_246 = NL + "            new TalendException(e_";
  protected final String TEXT_247 = ",currentComponent,globalMap).printStackTrace();";
  protected final String TEXT_248 = NL + "    }" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
/*INIT PARAMETERS AND INDICATORS.*/
NodeConnectionsHelper connsHelper=new NodeConnectionsHelper(node, true);
IConnection inputConn = connsHelper.getInputConn();
if(inputConn == null) {
	return "";//not generate any code if no input connection.
}
IConnection connResponse = connsHelper.getOutputConnResponse();
IConnection connFault = connsHelper.getOutputConnFault();
List<IConnection> dataOutputs = connsHelper.getDataOutputs();

String projectName = codeGenArgument.getCurrentProjectName();
String cid = node.getUniqueName();
String processName = node.getProcess().getName();

NodeParamsHelper paramsHelper = new NodeParamsHelper(node);
String serviceNS = paramsHelper.getStringParam("__SERVICE_NS__");
String serviceName = paramsHelper.getStringParam("__SERVICE_NAME__");
String portNS = paramsHelper.getStringParam("__PORT_NS__");
String portName = paramsHelper.getStringParam("__PORT_NAME__");

String methodNS = paramsHelper.getStringParam("__METHOD_NS__");
if (methodNS == null || "".equals(methodNS)) {
    methodNS = serviceNS;
}
String methodTemp = paramsHelper.getStringParam("__METHOD__");
String method = methodTemp.indexOf("(") != -1 ? methodTemp.substring(0, methodTemp.indexOf("(")) : methodTemp;

String authType = paramsHelper.getStringParam("__AUTH_TYPE__");
String alias = paramsHelper.getStringParam("__AUTH_ALIAS__");
String username = paramsHelper.getStringParam("__AUTH_USERNAME__");
String password = paramsHelper.getStringParam("__AUTH_PASSWORD__");
String authorizationRole = paramsHelper.getStringParam("__ROLE__");
String correlationValue = paramsHelper.getStringParam("__CORRELATION_VALUE__");

boolean logMessages = paramsHelper.getBoolParam("__LOG_MESSAGES__");
String connTimeout = paramsHelper.getStringParam("__CONNECTION_TIMEOUT__");
String receiveTimeout = paramsHelper.getStringParam("__RECEIVE_TIMEOUT__");

//use paramsHelper.getVisibleBoolParam to return false if the controller of this parameter is not visible.
boolean useSR = paramsHelper.getVisibleBoolParam("__USE_SR__");

boolean useSl = paramsHelper.getVisibleBoolParam("__SERVICE_LOCATOR__");
boolean useSAM = paramsHelper.getVisibleBoolParam("__SERVICE_ACTIVITY_MONITOR__");
boolean useAuth = paramsHelper.getVisibleBoolParam("__NEED_AUTH__");
boolean useBusinessCorrelation = paramsHelper.getVisibleBoolParam("__USE_BUSINESS_CORRELATION__");

//saml features
boolean useSAML = useAuth && authType.equals("SAML");
boolean useAuthorization = paramsHelper.getVisibleBoolParam("__NEED_AUTHORIZATION__");

boolean authPropagateUP = false;
boolean authPropagateCertificate = false;
if (useSR) {
    if (paramsHelper.getVisibleBoolParam("__AUTH_PROPAGATE__")) {
        authPropagateUP = true;
        if (alias != null && !"".equals(alias.trim())) {
            authPropagateCertificate = true;
        }
    }
} else {
    String authPropatateType = paramsHelper.getVisibleStringParam("__PROPAGATE_TYPE__");
    authPropagateUP = authPropatateType.equals("U_P");
    authPropagateCertificate = authPropatateType.equals("CERT");
}

boolean useCrypto = paramsHelper.getVisibleBoolParam("__NEED_ENCRYPTION__");

//init headers
boolean hasHeaders = false;
if(inputConn != null) {
    for (IMetadataColumn connColumn : inputConn.getMetadataTable().getListColumns()) {
        if ("headers".equals(connColumn.getLabel())) {
            hasHeaders = true;
            break;
        }
    }
}

/*GENERATE CODE*/
if (inputConn != null) {
    for (IConnection conn : dataOutputs) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
    }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
     if (useSl) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
                for(Entry<String, String> prop : paramsHelper.getPropertiesPram("__SERVICE_LOCATOR_CUSTOM_PROPERTIES__")) {
                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_18);
    
                }
            } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
     if (useSAM) {
                List<Entry<String, String>> customProperties = paramsHelper.getPropertiesPram("__SERVICE_ACTIVITY_CUSTOM_PROPERTIES__");
                if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
     for (Entry<String, String> prop : customProperties) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_26);
     } 
     } 
     } 
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(correlationValue);
    stringBuffer.append(TEXT_28);
     } 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     if (authPropagateUP || authPropagateCertificate) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
     List<? extends INode> nodesProviderRequest = node.getProcess().getNodesOfType("tESBProviderRequest");
                if (!nodesProviderRequest.isEmpty()) { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(nodesProviderRequest.iterator().next().getUniqueName());
    stringBuffer.append(TEXT_35);
     }
            } if (hasHeaders) { 
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
     } 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(methodNS);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append("request-response".equals(paramsHelper.getStringParam("__COMMUNICATION_STYLE__")));
    stringBuffer.append(TEXT_53);
     String soapAction=paramsHelper.getStringParam("__SOAP_ACTION__");
                    if(soapAction != null && (!soapAction.matches("\\s*"))) { 
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(soapAction);
    stringBuffer.append(TEXT_56);
      } 
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(paramsHelper.getStringParam("__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
     if (useSl) { 
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
     } 
     if (useSAM) { 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
     } 
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
     } 
     if(useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
     } 
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
     if (useAuth) { 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_95);
     } 
     if (paramsHelper.getBoolParam("__USE_PROXY__")) { 
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_HOST__"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_PORT__"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_PASSWORD__"));
    stringBuffer.append(TEXT_104);
     } 
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(connTimeout);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_111);
     if (paramsHelper.getBoolParam("__NEED_SSL_TO_TRUSTSERVER__")) { 
    stringBuffer.append(TEXT_112);
    stringBuffer.append(paramsHelper.getStringParam("__SSL_TRUSTSERVER_TRUSTSTORE__"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(paramsHelper.getStringParam("__SSL_TRUSTSERVER_PASSWORD__"));
    stringBuffer.append(TEXT_114);
     } 
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
     } 
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(paramsHelper.getStringParam("__SOAP_ACTION__"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(paramsHelper.getStringParam("__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(paramsHelper.getStringParam("__COMMUNICATION_STYLE__"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(useSl);
    stringBuffer.append(TEXT_136);
     if (useSl) { 
    stringBuffer.append(TEXT_137);
    stringBuffer.append(paramsHelper.getStringParam("__SERVICE_LOCATOR_STRATEGY__"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
     } 
    stringBuffer.append(TEXT_140);
    stringBuffer.append(useSAM);
    stringBuffer.append(TEXT_141);
     if (useSR) { 
    stringBuffer.append(TEXT_142);
    stringBuffer.append(useSR);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_145);
     if (!authorizationRole.isEmpty() && !"\"\"".equals(authorizationRole)) { 
    stringBuffer.append(TEXT_146);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_147);
     } 
     if (useCrypto) { 
    stringBuffer.append(TEXT_148);
    stringBuffer.append(useCrypto);
    stringBuffer.append(TEXT_149);
     } 
     } else if (useAuth) { 
     if (useSAML) { 
     if (useAuthorization) { 
    stringBuffer.append(TEXT_150);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_151);
     }if (useCrypto) { 
    stringBuffer.append(TEXT_152);
    stringBuffer.append(useCrypto);
    stringBuffer.append(TEXT_153);
     } 
     } 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_157);
     } 
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
     if (authPropagateUP || authPropagateCertificate) { 
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
     }
                            if (authPropagateCertificate) { 
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
     }
                            if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_169);
     } 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(processName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
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
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
     } 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
     if (null != connResponse) {
                String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_194);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(connResponseName);
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
    stringBuffer.append(TEXT_204);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
     } 
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
     if (null != connFault) {
                String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_213);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
     } else { 
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
     } 
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
     if (paramsHelper.getBoolParam("__DIE_ON_ERROR__")) { 
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
     } else { 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
     } 
    stringBuffer.append(TEXT_248);
     } 
    return stringBuffer.toString();
  }
}
