package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileCompareMainJava
{
  protected static String nl;
  public static synchronized TFileCompareMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileCompareMainJava result = new TFileCompareMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
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
  protected final String TEXT_21 = NL + " " + NL;
  protected final String TEXT_22 = NL + NL + "boolean result_";
  protected final String TEXT_23 = " = true;" + NL + "\t";
  protected final String TEXT_24 = NL + "java.nio.channels.FileChannel fileChannel_";
  protected final String TEXT_25 = " = new java.io.FileInputStream(";
  protected final String TEXT_26 = ").getChannel();" + NL + "long fileLength_";
  protected final String TEXT_27 = " = fileChannel_";
  protected final String TEXT_28 = ".size();" + NL + "fileChannel_";
  protected final String TEXT_29 = ".close();" + NL + "java.nio.channels.FileChannel fileChannelRef_";
  protected final String TEXT_30 = ").getChannel();" + NL + "long fileRefLength_";
  protected final String TEXT_31 = " = fileChannelRef_";
  protected final String TEXT_32 = ".size();" + NL + "fileChannelRef_";
  protected final String TEXT_33 = ".close();" + NL + "if(fileLength_";
  protected final String TEXT_34 = " != fileRefLength_";
  protected final String TEXT_35 = ")" + NL + "{" + NL + "\tresult_";
  protected final String TEXT_36 = " = false;" + NL + "}";
  protected final String TEXT_37 = NL + "if (result_";
  protected final String TEXT_38 = ")" + NL + "{" + NL + "\t";
  protected final String TEXT_39 = NL + "\t\tjava.io.BufferedReader file_";
  protected final String TEXT_40 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(";
  protected final String TEXT_41 = "),";
  protected final String TEXT_42 = "));" + NL + "\t\tjava.io.BufferedReader fileRef_";
  protected final String TEXT_43 = "));" + NL + "\t\tString content_";
  protected final String TEXT_44 = " = null,contentRef_";
  protected final String TEXT_45 = " = null;" + NL + "\t\twhile((content_";
  protected final String TEXT_46 = " = file_";
  protected final String TEXT_47 = ".readLine()) != null && (contentRef_";
  protected final String TEXT_48 = " = fileRef_";
  protected final String TEXT_49 = ".readLine()) != null)" + NL + "\t\t{" + NL + "\t\t\tif(content_";
  protected final String TEXT_50 = ".compareTo(contentRef_";
  protected final String TEXT_51 = ") != 0)" + NL + "\t\t\t{" + NL + "\t\t\t\tresult_";
  protected final String TEXT_52 = " = false;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t// Check if files has a different number of lines:" + NL + "\t\tif(content_";
  protected final String TEXT_53 = " == null){" + NL + "\t\t    // This step is done in case of the while upper ignore second part:" + NL + "\t\t    contentRef_";
  protected final String TEXT_54 = ".readLine();" + NL + "\t\t}" + NL + "\t\tif(content_";
  protected final String TEXT_55 = " != null || contentRef_";
  protected final String TEXT_56 = " != null){" + NL + "\t\t    result_";
  protected final String TEXT_57 = " = false;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tfile_";
  protected final String TEXT_58 = ".close();" + NL + "\t\tfileRef_";
  protected final String TEXT_59 = ".close();" + NL + "\t\t";
  protected final String TEXT_60 = NL + "    \tjava.io.BufferedInputStream file_";
  protected final String TEXT_61 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(";
  protected final String TEXT_62 = "));" + NL + "    \tjava.io.BufferedInputStream fileRef_";
  protected final String TEXT_63 = "));" + NL + "    \tint content_";
  protected final String TEXT_64 = " = -1,contentRef_";
  protected final String TEXT_65 = " = -1;" + NL + "    \twhile((content_";
  protected final String TEXT_66 = ".read()) != -1 && (contentRef_";
  protected final String TEXT_67 = ".read()) != -1)" + NL + "    \t{" + NL + "    \t\tif(content_";
  protected final String TEXT_68 = " != contentRef_";
  protected final String TEXT_69 = ")" + NL + "    \t\t{" + NL + "    \t\t\tresult_";
  protected final String TEXT_70 = " = false;" + NL + "    \t\t\tbreak;" + NL + "    \t\t}" + NL + "    \t}" + NL + "    \tfile_";
  protected final String TEXT_71 = ".close();" + NL + "    \tfileRef_";
  protected final String TEXT_72 = ".close();\t\t\t" + NL + "\t\t";
  protected final String TEXT_73 = NL + "}" + NL + "" + NL + "String message";
  protected final String TEXT_74 = " = \"\";" + NL + "if (result_";
  protected final String TEXT_75 = ") {" + NL + "\tmessage";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL + "\t" + NL + "} else {" + NL + "\tmessage";
  protected final String TEXT_78 = ";" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_79 = "_DIFFERENCE\",result_";
  protected final String TEXT_80 = ");" + NL;
  protected final String TEXT_81 = NL + "    System.out.println(message";
  protected final String TEXT_82 = NL + "\tlog.info(\"";
  protected final String TEXT_83 = " - Compare result : \" + message";
  protected final String TEXT_84 = " + \".\");";
  protected final String TEXT_85 = NL + "\t\t";
  protected final String TEXT_86 = ".file = ";
  protected final String TEXT_87 = ";" + NL + "\t\t";
  protected final String TEXT_88 = ".file_ref = ";
  protected final String TEXT_89 = ";\t" + NL + "    \t";
  protected final String TEXT_90 = ".moment = java.util.Calendar.getInstance().getTime();" + NL + "    \t";
  protected final String TEXT_91 = ".job = jobName;" + NL + "\t\t";
  protected final String TEXT_92 = ".component = currentComponent;" + NL + "\t\t";
  protected final String TEXT_93 = ".differ = (result_";
  protected final String TEXT_94 = ")?0:1;" + NL + "\t\t";
  protected final String TEXT_95 = ".message = message";
  protected final String TEXT_96 = ";";
  protected final String TEXT_97 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_98 = " - Compare date : \" + routines.system.FormatterUtils.format_Date(";
  protected final String TEXT_99 = ".moment,\"dd-MM-yyyy HH:mm:ss\") + \".\");";

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
	
    stringBuffer.append(TEXT_21);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String file = ElementParameterParser.getValue(node, "__FILE__");
Boolean print = new Boolean(ElementParameterParser.getValue(node, "__PRINT__"));
String differMessage = ElementParameterParser.getValue(node, "__DIFFER_MESSAGE__");
String noDifferMessage = ElementParameterParser.getValue(node, "__NO_DIFFER_MESSAGE__");
String fileRef = ElementParameterParser.getValue(node, "__FILE_REF__");
String cmpMode = ElementParameterParser.getValue(node, "__COMPARISON_MODE__");
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
	if(!("TEXT_CMP").equals(cmpMode))
	{
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(fileRef);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	if(("TEXT_CMP").equals(cmpMode))
	{
		
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(fileRef);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(encoding );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
	}
	else
	{
		
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(fileRef);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
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
    
	}
	
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(noDifferMessage);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(differMessage);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
if (print) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
}

if(isLog4jEnabled) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
}

for (IConnection conn : node.getOutgoingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(file );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(fileRef );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
		if(isLog4jEnabled) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    
		}
	}
}


    return stringBuffer.toString();
  }
}
