package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileInputRawBeginJava
{
  protected static String nl;
  public static synchronized TFileInputRawBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputRawBeginJava result = new TFileInputRawBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + "\t\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_22 = " = null;";
  protected final String TEXT_23 = NL + NL + "\t\t\t\ttry {";
  protected final String TEXT_24 = "\t\t\t\t\t" + NL + "\t\t\t\t\tString content_";
  protected final String TEXT_25 = " = org.apache.commons.io.FileUtils.readFileToString(new java.io.File(";
  protected final String TEXT_26 = "), ";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = content_";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "\t\t\t\t\tfis_";
  protected final String TEXT_32 = " = org.apache.commons.io.FileUtils.openInputStream(new java.io.File(";
  protected final String TEXT_33 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = " = fis_";
  protected final String TEXT_35 = NL + "\t\t\t\t\tbyte[] content_";
  protected final String TEXT_36 = " = org.apache.commons.io.FileUtils.readFileToByteArray(new java.io.File(";
  protected final String TEXT_37 = "\t\t\t\t\t" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_FILENAME_PATH\", ";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t} catch (java.io.IOException e_";
  protected final String TEXT_40 = ") {" + NL + "globalMap.put(\"";
  protected final String TEXT_41 = "_ERROR_MESSAGE\",e_";
  protected final String TEXT_42 = ".getMessage());";
  protected final String TEXT_43 = NL + "\t\t\t\t\tthrow e_";
  protected final String TEXT_44 = NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_46 = " - \" +e_";
  protected final String TEXT_47 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_49 = NL + "\t\t\t\t}";
  protected final String TEXT_50 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String filename = ElementParameterParser.getValue(node, "__FILENAME__");
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	
	boolean asString = "true".equals(ElementParameterParser.getValue(node, "__AS_STRING__"));
	boolean asBytearray = "true".equals(ElementParameterParser.getValue(node, "__AS_BYTEARRAY__"));
	boolean asInputstream = "true".equals(ElementParameterParser.getValue(node, "__AS_INPUTSTREAM__"));
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	
	java.util.List<IMetadataColumn> columnList = null;
	java.util.List<IMetadataTable> metadatas = node.getMetadataList();
	if(metadatas != null && metadatas.size() > 0) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null) {
		    columnList = metadata.getListColumns();
		}
	}
	java.util.List< ? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	if(columnList!=null && outgoingConns!=null && outgoingConns.size()>0) {
		IConnection outgoingConn = outgoingConns.get(0);// only have one flow output
		if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		
			final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			log4jFileUtil.componentStartInfo(node);
			
			if(asInputstream) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
			}

    stringBuffer.append(TEXT_23);
    
			if(asString) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnList.get(0).getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
			} else if(asInputstream) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnList.get(0).getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
			} else if(asBytearray) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnList.get(0).getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
			}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
			if(dieOnError) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
			} else {

    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			}

    stringBuffer.append(TEXT_49);
    
		}
	}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}
