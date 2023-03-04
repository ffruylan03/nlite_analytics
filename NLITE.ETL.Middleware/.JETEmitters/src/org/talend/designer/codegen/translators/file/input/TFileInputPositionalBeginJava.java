package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class TFileInputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileInputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputPositionalBeginJava result = new TFileInputPositionalBeginJava();
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
  protected final String TEXT_21 = NL + "    \t\tboolean useStar_";
  protected final String TEXT_22 = " = false;" + NL + "    \t\t";
  protected final String TEXT_23 = NL + "            \tString pattern_";
  protected final String TEXT_24 = " = \"";
  protected final String TEXT_25 = "\";" + NL + "            \t";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ";" + NL + "            \t";
  protected final String TEXT_28 = NL + "                final String[] positions_";
  protected final String TEXT_29 = " = pattern_";
  protected final String TEXT_30 = ".trim().split(\",\");" + NL + "                for(int i_";
  protected final String TEXT_31 = "=0;i_";
  protected final String TEXT_32 = "<positions_";
  protected final String TEXT_33 = ".length;i_";
  protected final String TEXT_34 = "++){" + NL + "                \tif(\"\".equals(positions_";
  protected final String TEXT_35 = "[i_";
  protected final String TEXT_36 = "])){" + NL + "                   \t \tpositions_";
  protected final String TEXT_37 = "]=\"0\";" + NL + "                \t}" + NL + "                \tif(\"*\".equals(positions_";
  protected final String TEXT_38 = "])){" + NL + "                \t\tuseStar_";
  protected final String TEXT_39 = " = true;" + NL + "                \t}" + NL + "                }";
  protected final String TEXT_40 = NL + "\t\t\tif (";
  protected final String TEXT_41 = ") {" + NL + "\t\t\t\tthrow new RuntimeException(\"tFileInputPositional doesn't support to work with tSetDynamicSchema when 'Guess schema from file' option is activated\");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tuseStar_";
  protected final String TEXT_43 = " = true;" + NL + "\t\t\t\t" + NL + "\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_44 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_45 = "\");" + NL + "\t\t\t\tint maxColumnCount_";
  protected final String TEXT_46 = " = dynamic_";
  protected final String TEXT_47 = ".getColumnCount();" + NL + "\t\t\t\tdynamic_";
  protected final String TEXT_48 = ".clearColumnValues();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "            int nb_line_";
  protected final String TEXT_50 = " = 0;" + NL + "            int footer_";
  protected final String TEXT_51 = "  = ";
  protected final String TEXT_52 = ";" + NL + "            int nb_limit_";
  protected final String TEXT_53 = ";" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "                class Arrays_";
  protected final String TEXT_55 = "{" + NL + "                    public byte[] copyOfRange(byte[] original, int from, int to) {" + NL + "                        int newLength = to - from;" + NL + "                        if (newLength < 0)" + NL + "                            throw new IllegalArgumentException(from + \" > \" + to);" + NL + "                        byte[] copy = new byte[newLength];" + NL + "                        System.arraycopy(original, from, copy, 0," + NL + "                                         Math.min(original.length - from, newLength));" + NL + "                        return copy;" + NL + "                    }" + NL + "                }" + NL + "                Arrays_";
  protected final String TEXT_56 = " arrays_";
  protected final String TEXT_57 = " = new Arrays_";
  protected final String TEXT_58 = "();" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + NL + "\t\t\tclass PositionalUtil_";
  protected final String TEXT_60 = "{" + NL + "\t\t\t\tprivate boolean useStar = false;" + NL + "                \t\t\t\t" + NL + "\t\t\t\tpublic void setUseStar(boolean useStar) {" + NL + "\t\t\t\t\tthis.useStar = useStar;" + NL + "\t\t\t\t}";
  protected final String TEXT_61 = NL + "                \t\t\t\tprivate final int sizeListColumns = ";
  protected final String TEXT_62 = ";" + NL + "                \t\t\t\tprivate int currentRow = 0;" + NL + "                \t\t\t\t";
  protected final String TEXT_63 = NL + "                  \t\t\t\t\t\tvoid setValue_";
  protected final String TEXT_64 = "(";
  protected final String TEXT_65 = "Struct ";
  protected final String TEXT_66 = ",int[] begins_";
  protected final String TEXT_67 = ",int[] ends_";
  protected final String TEXT_68 = ",int rowLen_";
  protected final String TEXT_69 = "," + NL + "                  \t\t\t\t\t\t";
  protected final String TEXT_70 = "byte[] byteArray_";
  protected final String TEXT_71 = ",Arrays_";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = "String column_";
  protected final String TEXT_74 = ",String row_";
  protected final String TEXT_75 = ")throws java.lang.Exception {  " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tcurrentRow = ";
  protected final String TEXT_77 = ";" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tif((currentRow == (sizeListColumns-1)) && useStar) {" + NL + "    \t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_78 = "[";
  protected final String TEXT_79 = "] < rowLen_";
  protected final String TEXT_80 = "){" + NL + "        \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_81 = NL + "                                            \tbyteArray_";
  protected final String TEXT_82 = "=arrays_";
  protected final String TEXT_83 = ".copyOfRange(row_";
  protected final String TEXT_84 = ".getBytes(";
  protected final String TEXT_85 = "),begins_";
  protected final String TEXT_86 = "],rowLen_";
  protected final String TEXT_87 = ");" + NL + "                                            \tcolumn_";
  protected final String TEXT_88 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_89 = "), ";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_93 = " = TalendString.talendTrim(row_";
  protected final String TEXT_94 = ".substring(begins_";
  protected final String TEXT_95 = "]), ";
  protected final String TEXT_96 = NL + "                                        }else{" + NL + "                                        \tcolumn_";
  protected final String TEXT_97 = " = \"\";" + NL + "                                        }" + NL + "                                    } else {" + NL + "                                    \t";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_99 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\tif(ends_";
  protected final String TEXT_100 = "] <= rowLen_";
  protected final String TEXT_101 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_102 = " = arrays_";
  protected final String TEXT_103 = "],ends_";
  protected final String TEXT_104 = "]);" + NL + "        \t\t\t\t\t\t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_106 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_107 = " = \"\";" + NL + "    \t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_108 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_109 = "], ends_";
  protected final String TEXT_110 = ");" + NL + "        \t\t\t\t\t\t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_111 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_112 = " = \"\";" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "                                    }" + NL + "                                        " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_115 = " = column_";
  protected final String TEXT_116 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "                \t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_121 = "\");" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_122 = ".copyMetadata();" + NL + "\t\t\t\t\t\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_123 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\t\t\tint substringBegin";
  protected final String TEXT_124 = " = begins_";
  protected final String TEXT_125 = "]; int substringEnd";
  protected final String TEXT_126 = " =0;" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor (int i";
  protected final String TEXT_127 = "=0;i";
  protected final String TEXT_128 = "<maxColumnCount_";
  protected final String TEXT_129 = ";i";
  protected final String TEXT_130 = "++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_131 = ".getColumnMetadata(i";
  protected final String TEXT_132 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_133 = " = dynamicMetadataColumn_";
  protected final String TEXT_134 = ".getLength();";
  protected final String TEXT_135 = NL + "                                                    substringEnd";
  protected final String TEXT_136 = " = substringBegin";
  protected final String TEXT_137 = "+currentFieldLength_";
  protected final String TEXT_138 = ";" + NL + "                                                    if(substringEnd";
  protected final String TEXT_139 = " > rowLen_";
  protected final String TEXT_140 = "){" + NL + "                                                        substringEnd";
  protected final String TEXT_141 = " = rowLen_";
  protected final String TEXT_142 = ";" + NL + "                                                    }";
  protected final String TEXT_143 = NL + "                                                    int codePointCount = currentFieldLength_";
  protected final String TEXT_144 = ";" + NL + "                                                    int codePointCountLeft = row_";
  protected final String TEXT_145 = ".codePointCount(substringBegin";
  protected final String TEXT_146 = ", rowLen_";
  protected final String TEXT_147 = ");" + NL + "                                                    if(codePointCountLeft < codePointCount){" + NL + "                                                        codePointCount = codePointCountLeft;" + NL + "                                                    }" + NL + "                                                    substringEnd";
  protected final String TEXT_148 = " = row_";
  protected final String TEXT_149 = ".offsetByCodePoints(substringBegin";
  protected final String TEXT_150 = ", codePointCount);";
  protected final String TEXT_151 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_152 = "),substringBegin";
  protected final String TEXT_153 = ", substringEnd";
  protected final String TEXT_154 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_155 = " = new String(temp_byteArray_";
  protected final String TEXT_156 = ");\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_157 = NL + "                \t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_158 = ".substring(substringBegin";
  protected final String TEXT_159 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_161 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_162 = " = currentColumnValue_";
  protected final String TEXT_163 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tString type_";
  protected final String TEXT_165 = ".getType();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_166 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_167 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_168 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_169 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_170 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_171 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_172 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_173 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_175 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_176 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_177 = " = substringEnd";
  protected final String TEXT_178 = "; " + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\t\t\t\tif(column_";
  protected final String TEXT_180 = ".length() > 0) {" + NL + "        \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_183 = ",false);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_184 = " = ParserUtils.parseTo_";
  protected final String TEXT_185 = "(ParserUtils.parseTo_Number(column_";
  protected final String TEXT_186 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = "(column_";
  protected final String TEXT_188 = NL + "    \t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_189 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_190 = NL + "            \t\t\t\t\t\t\t}" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "                \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "                        \t\t    \tint parseValue_";
  protected final String TEXT_193 = "(String row_";
  protected final String TEXT_194 = ", int substringBegin";
  protected final String TEXT_195 = ", int substringEnd";
  protected final String TEXT_196 = ", int rowLen_";
  protected final String TEXT_197 = ", String[] columnValue";
  protected final String TEXT_198 = " ";
  protected final String TEXT_199 = ", Arrays_";
  protected final String TEXT_200 = ", byte[][] byteArray_";
  protected final String TEXT_201 = ", routines.system.Dynamic dynamicLocal_";
  protected final String TEXT_202 = ")throws java.lang.Exception{" + NL + "                        \t\t    ";
  protected final String TEXT_203 = " \t" + NL + "" + NL + "                        \t\t\t\tint maxColumnCount_";
  protected final String TEXT_204 = " = dynamicLocal_";
  protected final String TEXT_205 = ".getColumnCount();" + NL + "                        \t\t\t\tfor (int i";
  protected final String TEXT_206 = "++) {" + NL + "                        \t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_207 = ");" + NL + "                        \t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_208 = NL + "                                                substringEnd";
  protected final String TEXT_209 = ";" + NL + "                                                if(substringEnd";
  protected final String TEXT_210 = "){" + NL + "                                                    substringEnd";
  protected final String TEXT_211 = ";" + NL + "                                                }";
  protected final String TEXT_212 = NL + "                                                int codePointCount = currentFieldLength_";
  protected final String TEXT_213 = ";" + NL + "                                                int codePointCountLeft = row_";
  protected final String TEXT_214 = ");" + NL + "                                                if(codePointCountLeft < codePointCount){" + NL + "                                                    codePointCount = codePointCountLeft;" + NL + "                                                }" + NL + "                                                substringEnd";
  protected final String TEXT_215 = NL + "                    \t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_216 = "= arrays_";
  protected final String TEXT_217 = ");" + NL + "\t                    \t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_218 = ");\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_220 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_221 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = " " + NL + "\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_223 = NL + "                        \t\t\t\t\t\tString type_";
  protected final String TEXT_224 = ".getType();" + NL + "                        \t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_225 = ")){" + NL + "                        \t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_226 = ");" + NL + "\t                    \t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_227 = NL + "                        \t\t\t\t\tdynamicLocal_";
  protected final String TEXT_228 = ");" + NL + "                        \t\t\t\t\tsubstringBegin";
  protected final String TEXT_229 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "                    \t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\t\tif(positions_";
  protected final String TEXT_231 = ".length <= ";
  protected final String TEXT_232 = ") {" + NL + "\t\t\t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_233 = "]=\"\";" + NL + "\t\t\t\t\t\t\t\t\t\t} else if(substringBegin";
  protected final String TEXT_234 = " >= rowLen_";
  protected final String TEXT_235 = "){" + NL + "                            \t\t    \tcolumnValue";
  protected final String TEXT_236 = "]= \"\";" + NL + "                                \t\t}else{" + NL + "                                \t\t\tif(\"*\".equals(positions_";
  protected final String TEXT_237 = "])){" + NL + "        \t\t\t \t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_238 = "=rowLen_";
  protected final String TEXT_239 = ";" + NL + "            \t\t\t\t\t\t\t\t} else {";
  protected final String TEXT_240 = " + Integer.parseInt(positions_";
  protected final String TEXT_241 = "]);" + NL + "                                                    if(substringEnd";
  protected final String TEXT_242 = NL + "                                                    int codePointCount = Integer.parseInt(positions_";
  protected final String TEXT_243 = "]);" + NL + "                                                    int codePointCountLeft = row_";
  protected final String TEXT_244 = NL + "                        \t\t\t\t    }" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "                            \t\t\t\t\tbyteArray_";
  protected final String TEXT_246 = "] = arrays_";
  protected final String TEXT_247 = ");" + NL + "                            \t\t\t\t\tcolumnValue";
  protected final String TEXT_248 = "] = new String(byteArray_";
  protected final String TEXT_249 = "],";
  protected final String TEXT_250 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_251 = NL + "            \t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_252 = "] = row_";
  protected final String TEXT_253 = NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_254 = "] = columnValue";
  protected final String TEXT_255 = "].trim();" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_256 = "    \t" + NL + "            \t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_257 = ";" + NL + "    \t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_258 = NL + "                        \t\t    \t\treturn substringBegin";
  protected final String TEXT_259 = ";" + NL + "                        \t\t    \t}" + NL + "                    \t\t    \t";
  protected final String TEXT_260 = NL + "\t\t\t\t\t\t\t\t\t\treturn substringBegin";
  protected final String TEXT_261 = ";" + NL + "                     \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_262 = NL + "                                    \tvoid setValue_";
  protected final String TEXT_263 = ",String[] columnValue";
  protected final String TEXT_264 = ")throws java.lang.Exception{" + NL + "                \t\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_266 = NL + "\t                    \t\t\t\t";
  protected final String TEXT_267 = " = columnValue";
  protected final String TEXT_268 = "];" + NL + "\t\t\t\t\t                ";
  protected final String TEXT_269 = NL + "\t                    \t\t\t\tif(columnValue";
  protected final String TEXT_270 = "].length() > 0) {" + NL + "\t\t\t\t\t\t                \t";
  protected final String TEXT_271 = "\t" + NL + "\t\t                            \t\t\t\t";
  protected final String TEXT_272 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_273 = "], ";
  protected final String TEXT_274 = NL + "\t\t                            \t\t\t\t";
  protected final String TEXT_275 = ");\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_276 = NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_277 = "(ParserUtils.parseTo_Number(columnValue";
  protected final String TEXT_278 = "\t" + NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_279 = "].getBytes(";
  protected final String TEXT_280 = "(columnValue";
  protected final String TEXT_281 = "].trim());" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_282 = NL + "                        \t\t\t\t}else{" + NL + "        \t                \t\t\t\t";
  protected final String TEXT_283 = ";" + NL + "                        \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_284 = NL + "\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_285 = NL + "                     \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_286 = NL + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_287 = NL + "                     \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_288 = NL + "\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_289 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\tPositionalUtil_";
  protected final String TEXT_290 = " positionalUtil_";
  protected final String TEXT_291 = "=new PositionalUtil_";
  protected final String TEXT_292 = "();" + NL + "\t\t\tpositionalUtil_";
  protected final String TEXT_293 = ".setUseStar(useStar_";
  protected final String TEXT_294 = ");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_295 = NL + NL + "                int[] sizes_";
  protected final String TEXT_296 = " = new int[";
  protected final String TEXT_297 = "];" + NL + "                int[] begins_";
  protected final String TEXT_298 = "];" + NL + "                int[] ends_";
  protected final String TEXT_299 = "];";
  protected final String TEXT_300 = NL + "                    int[] surrogateBegins_";
  protected final String TEXT_301 = " = new int[begins_";
  protected final String TEXT_302 = ".length];" + NL + "                    int[] surrogateEnds_";
  protected final String TEXT_303 = " = new int[ends_";
  protected final String TEXT_304 = ".length];";
  protected final String TEXT_305 = NL + "    \t\t\t\t\tuseStar_";
  protected final String TEXT_306 = " = true;" + NL + "    \t\t\t\t\tpositionalUtil_";
  protected final String TEXT_307 = ");" + NL + "    \t\t\t\t\tsizes_";
  protected final String TEXT_308 = "] = -1;" + NL + "    \t\t\t\t\t";
  protected final String TEXT_309 = NL + "    \t\t\t\t\tsizes_";
  protected final String TEXT_310 = "] = ";
  protected final String TEXT_311 = ";" + NL + "    \t\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\t\tsizes_";
  protected final String TEXT_313 = ";\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_314 = NL + "\t\t\t\t\t\tbegins_";
  protected final String TEXT_315 = "] = 0;" + NL + "\t\t\t\t\t\tends_";
  protected final String TEXT_316 = "] = sizes_";
  protected final String TEXT_317 = "];" + NL + "\t\t\t\t\t";
  protected final String TEXT_318 = NL + "\t\t\t\t\t\tif(useStar_";
  protected final String TEXT_319 = ") {" + NL + "\t\t\t\t\t\t\tbegins_";
  protected final String TEXT_320 = "] = begins_";
  protected final String TEXT_321 = "] + sizes_";
  protected final String TEXT_322 = "];" + NL + "\t\t\t\t\t\t\tends_";
  protected final String TEXT_323 = "] = -1;" + NL + "\t\t\t\t\t\t} else {" + NL + "    \t\t\t\t\t\tbegins_";
  protected final String TEXT_324 = "];" + NL + "                            ends_";
  protected final String TEXT_325 = "] = ends_";
  protected final String TEXT_326 = "];" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_327 = NL + "                        begins_";
  protected final String TEXT_328 = "];" + NL + "                        ends_";
  protected final String TEXT_329 = NL + "            Object filename_";
  protected final String TEXT_330 = ";" + NL + "            java.io.BufferedReader in_";
  protected final String TEXT_331 = " = null;" + NL + "" + NL + "            org.talend.fileprocess.delimited.RowParser reader_";
  protected final String TEXT_332 = " = null; " + NL + "            org.talend.fileprocess.delimited.RowParserByByte byteReader_";
  protected final String TEXT_333 = " = null; " + NL + "" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_334 = NL + NL + "\t\t\t";
  protected final String TEXT_335 = NL + "                java.util.zip.ZipInputStream zis_";
  protected final String TEXT_336 = " = null;" + NL + "                try {" + NL + "                \tif(filename_";
  protected final String TEXT_337 = " instanceof java.io.InputStream){" + NL + "                \t\tzis_";
  protected final String TEXT_338 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_339 = "));" + NL + "                \t}else{" + NL + "                \t\tzis_";
  protected final String TEXT_340 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_341 = "))));" + NL + "                \t}" + NL + "                } catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_342 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "                \t";
  protected final String TEXT_343 = NL + "                \t\tthrow e;" + NL + "                \t";
  protected final String TEXT_344 = NL + "                \t\t";
  protected final String TEXT_345 = NL + "                \t\t\tlog.error(\"";
  protected final String TEXT_346 = " - \" +e.getMessage());" + NL + "                \t\t";
  protected final String TEXT_347 = NL + "                \t\t\tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_348 = NL + "                }" + NL + "                java.util.zip.ZipEntry entry_";
  protected final String TEXT_349 = " = null;" + NL + "                while (true) {" + NL + "                \ttry {" + NL + "                \t\tentry_";
  protected final String TEXT_350 = " = zis_";
  protected final String TEXT_351 = ".getNextEntry();" + NL + "                \t} catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_352 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "                \t\t";
  protected final String TEXT_353 = NL + "                \t\t\tthrow e;" + NL + "                \t\t";
  protected final String TEXT_354 = NL + "                \t\t\t";
  protected final String TEXT_355 = NL + "                \t\t\t\tlog.error(\"";
  protected final String TEXT_356 = " - \" +e.getMessage());" + NL + "                \t\t\t";
  protected final String TEXT_357 = NL + "                    \t\tSystem.err.println(e.getMessage());" + NL + "                    \t\tbreak;" + NL + "                \t\t";
  protected final String TEXT_358 = NL + "                \t}" + NL + "                \tif(entry_";
  protected final String TEXT_359 = " == null) {" + NL + "                \t\tbreak;" + NL + "                \t}" + NL + "                \tif(entry_";
  protected final String TEXT_360 = ".isDirectory()){ //directory" + NL + "                \t\tcontinue;" + NL + "                \t}" + NL + "                \tString row_";
  protected final String TEXT_361 = " = null;" + NL + "                \tint rowLen_";
  protected final String TEXT_362 = " = 0;" + NL + "                \t";
  protected final String TEXT_363 = NL + "                \t\t\tbyte[] byteArray_";
  protected final String TEXT_364 = " = new byte[0];" + NL + "                    \t";
  protected final String TEXT_365 = NL + "                \t\tString column_";
  protected final String TEXT_366 = " = null;" + NL + "                \t";
  protected final String TEXT_367 = NL + "                \t\t\tbyte[][] byteArray_";
  protected final String TEXT_368 = " = new byte[";
  protected final String TEXT_369 = "][];" + NL + "                \t\t";
  protected final String TEXT_370 = NL + "                \t\tString[] columnValue";
  protected final String TEXT_371 = "=new String[";
  protected final String TEXT_372 = "];" + NL + "                \t";
  protected final String TEXT_373 = NL + "                \ttry {//TD110 begin" + NL + "                \t\tin_";
  protected final String TEXT_374 = " = new java.io.BufferedReader(new java.io.InputStreamReader(zis_";
  protected final String TEXT_375 = "));" + NL + "    \t\t";
  protected final String TEXT_376 = NL + "                String row_";
  protected final String TEXT_377 = " = null;" + NL + "                int rowLen_";
  protected final String TEXT_378 = " = 0;";
  protected final String TEXT_379 = NL + "            \t\t\tbyte[] byteArray_";
  protected final String TEXT_380 = " = new byte[0];";
  protected final String TEXT_381 = NL + "\t\t\t\t\tString column_";
  protected final String TEXT_382 = " = null;";
  protected final String TEXT_383 = NL + "\t\t                byte[][] byteArray_";
  protected final String TEXT_384 = "][];" + NL + "        \t        ";
  protected final String TEXT_385 = NL + "                \tString[] columnValue";
  protected final String TEXT_386 = " " + NL + "                try {//TD110 begin" + NL + "                \tif(filename_";
  protected final String TEXT_387 = " instanceof java.io.InputStream){" + NL + "                \t\tin_";
  protected final String TEXT_388 = " = " + NL + "                \t\t\t\tnew java.io.BufferedReader(new routines.system.UnicodeReader((java.io.InputStream)filename_";
  protected final String TEXT_389 = "));" + NL + "                \t}else{" + NL + "                \t\tin_";
  protected final String TEXT_390 = " = " + NL + "                \t\t\tnew java.io.BufferedReader(new routines.system.UnicodeReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_391 = ")), ";
  protected final String TEXT_392 = "));" + NL + "                \t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_393 = NL + "\t\t\t\tint rowLength_";
  protected final String TEXT_394 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t\t\t\t\trowLength_";
  protected final String TEXT_396 = " += sizes_";
  protected final String TEXT_397 = NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_398 = "++){" + NL + "\t\t\t\t\t\trowLength_";
  protected final String TEXT_399 = " += Integer.parseInt(positions_";
  protected final String TEXT_400 = "]);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_401 = NL + "                              byteReader_";
  protected final String TEXT_402 = " = new org.talend.fileprocess.delimited.RowParserByByte(zis_";
  protected final String TEXT_403 = ", rowLength_";
  protected final String TEXT_404 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_405 = NL + "\t\t\t\t" + NL + "                              byteReader_";
  protected final String TEXT_406 = " = new org.talend.fileprocess.delimited.RowParserByByte(String.valueOf(filename_";
  protected final String TEXT_407 = "), rowLength_";
  protected final String TEXT_408 = NL + "\t\t\t\treader_";
  protected final String TEXT_409 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_410 = ");" + NL + "\t\t\t";
  protected final String TEXT_411 = NL + "\t\t\t\t";
  protected final String TEXT_412 = NL + "                    byteReader_";
  protected final String TEXT_413 = ".setSafetySwitch(";
  protected final String TEXT_414 = ");" + NL + "                    byteReader_";
  protected final String TEXT_415 = ".skipHeaders(";
  protected final String TEXT_416 = NL + "            \t\treader_";
  protected final String TEXT_417 = ");" + NL + "            \t\treader_";
  protected final String TEXT_418 = ");" + NL + "            \t";
  protected final String TEXT_419 = NL + "            if(footer_";
  protected final String TEXT_420 = " > 0){" + NL + "            \t";
  protected final String TEXT_421 = NL + "            \tint available_";
  protected final String TEXT_422 = " = (int)byteReader_";
  protected final String TEXT_423 = ".getAvailableRowCount(footer_";
  protected final String TEXT_424 = ");" + NL + "            \tbyteReader_";
  protected final String TEXT_425 = ".close();" + NL + "            \t";
  protected final String TEXT_426 = " = (int)reader_";
  protected final String TEXT_427 = ");" + NL + "            \treader_";
  protected final String TEXT_428 = NL + "            \tif(filename_";
  protected final String TEXT_429 = " instanceof java.io.InputStream){" + NL + "            \t\tthrow new java.lang.RuntimeException(\"When the input source is a stream,footer shouldn't be bigger than 0.\");" + NL + "            \t}else{" + NL + "            \t\tin_";
  protected final String TEXT_430 = " = new java.io.BufferedReader(new routines.system.UnicodeReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_431 = "));" + NL + "            \t}" + NL + "\t\t\t\t";
  protected final String TEXT_432 = NL + "                               byteReader_";
  protected final String TEXT_433 = NL + "\t\t\t\t\treader_";
  protected final String TEXT_434 = NL + "                      byteReader_";
  protected final String TEXT_435 = NL + "                \treader_";
  protected final String TEXT_436 = NL + "\t" + NL + "            \tif ( nb_limit_";
  protected final String TEXT_437 = " >= 0 ){" + NL + "            \t\tnb_limit_";
  protected final String TEXT_438 = " = ( nb_limit_";
  protected final String TEXT_439 = " > available_";
  protected final String TEXT_440 = ") ? available_";
  protected final String TEXT_441 = " : nb_limit_";
  protected final String TEXT_442 = ";" + NL + "            \t}else{" + NL + "            \t\tnb_limit_";
  protected final String TEXT_443 = " = available_";
  protected final String TEXT_444 = ";" + NL + "            \t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t} catch(java.lang.Exception e) {//TD110 end" + NL + "globalMap.put(\"";
  protected final String TEXT_445 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "        \t";
  protected final String TEXT_446 = NL + "        \t\tthrow e;" + NL + "        \t";
  protected final String TEXT_447 = NL + "        \t\t";
  protected final String TEXT_448 = NL + "        \t\t\tlog.error(\"";
  protected final String TEXT_449 = " - \" +e.getMessage());" + NL + "        \t\t";
  protected final String TEXT_450 = NL + "    \t\t\tSystem.err.println(e.getMessage());" + NL + "        \t";
  protected final String TEXT_451 = NL + "        }";
  protected final String TEXT_452 = NL + "                    while (nb_limit_";
  protected final String TEXT_453 = " != 0 && byteReader_";
  protected final String TEXT_454 = "!=null && byteReader_";
  protected final String TEXT_455 = ".readRecord()) {" + NL + "        \t            row_";
  protected final String TEXT_456 = " = new String(byteReader_";
  protected final String TEXT_457 = ".getBuffer(),";
  protected final String TEXT_458 = " != 0 && reader_";
  protected final String TEXT_459 = "!=null && reader_";
  protected final String TEXT_460 = " = reader_";
  protected final String TEXT_461 = ".getRowRecord();" + NL + "            \t";
  protected final String TEXT_462 = NL + "\t\t\t\trowLen_";
  protected final String TEXT_463 = ").length;" + NL + "\t\t\t";
  protected final String TEXT_464 = ".length();" + NL + "\t\t\t";
  protected final String TEXT_465 = NL + "\t\t\t";
  protected final String TEXT_466 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_467 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_468 = NL + "        \t\t\t" + NL + "            \t\t\tboolean whetherReject_";
  protected final String TEXT_469 = " = false;" + NL + "            \t\t\t";
  protected final String TEXT_470 = " = new ";
  protected final String TEXT_471 = "Struct();" + NL + "            \t\t\ttry {" + NL + "    \t\t\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_472 = NL + "                                            int surrogateRowLen_";
  protected final String TEXT_473 = ".codePointCount(0, rowLen_";
  protected final String TEXT_474 = ");" + NL + "                                            for (int index = 0; index < begins_";
  protected final String TEXT_475 = ".length; index++){" + NL + "                                                if (index > 0){" + NL + "                                                    surrogateBegins_";
  protected final String TEXT_476 = "[index] = surrogateEnds_";
  protected final String TEXT_477 = "[index-1];" + NL + "                                                }else{" + NL + "                                                    surrogateBegins_";
  protected final String TEXT_478 = "[index] = begins_";
  protected final String TEXT_479 = "[index];" + NL + "                                                }" + NL + "                                                if (ends_";
  protected final String TEXT_480 = "[index] > 0 && ends_";
  protected final String TEXT_481 = "[index] <= surrogateRowLen_";
  protected final String TEXT_482 = "){" + NL + "                                                    int codePoints = ends_";
  protected final String TEXT_483 = "[index] - begins_";
  protected final String TEXT_484 = "[index];" + NL + "                                                    surrogateEnds_";
  protected final String TEXT_485 = "[index] = row_";
  protected final String TEXT_486 = ".offsetByCodePoints(surrogateBegins_";
  protected final String TEXT_487 = "[index], codePoints);" + NL + "                                                }else{" + NL + "                                                    surrogateEnds_";
  protected final String TEXT_488 = "[index] = rowLen_";
  protected final String TEXT_489 = ";" + NL + "                                                }" + NL + "                                            }" + NL + "                                            positionalUtil_";
  protected final String TEXT_490 = ".setValue_";
  protected final String TEXT_491 = ",surrogateBegins_";
  protected final String TEXT_492 = ",surrogateEnds_";
  protected final String TEXT_493 = ",rowLen_";
  protected final String TEXT_494 = ",column_";
  protected final String TEXT_495 = ",row_";
  protected final String TEXT_496 = NL + "                                            positionalUtil_";
  protected final String TEXT_497 = ",begins_";
  protected final String TEXT_498 = ",ends_";
  protected final String TEXT_499 = "byteArray_";
  protected final String TEXT_500 = ",arrays_";
  protected final String TEXT_501 = "column_";
  protected final String TEXT_502 = NL + "                            \tint substringBegin";
  protected final String TEXT_503 = "=0,substringEnd";
  protected final String TEXT_504 = "=0;" + NL + "                            \tint[]begin_end_";
  protected final String TEXT_505 = "=new int[2];" + NL + "                            \t" + NL + "        \t\t\t\t\t\t";
  protected final String TEXT_506 = NL + "\t\t                            ";
  protected final String TEXT_507 = NL + "                   \t\t\t\t           ";
  protected final String TEXT_508 = ".copyMetadata();" + NL + "                        \t\t\t\t   substringBegin";
  protected final String TEXT_509 = " = positionalUtil_";
  protected final String TEXT_510 = ".parseValue_";
  protected final String TEXT_511 = "(row_";
  protected final String TEXT_512 = ", substringBegin";
  protected final String TEXT_513 = ", columnValue";
  protected final String TEXT_514 = ", arrays_";
  protected final String TEXT_515 = ", byteArray_";
  protected final String TEXT_516 = NL + "                   \t\t\t\t           substringBegin";
  protected final String TEXT_517 = ");" + NL + "                   \t\t\t\t    ";
  protected final String TEXT_518 = "                        \t\t\t\t" + NL + "                   \t\t\t\t    substringEnd";
  protected final String TEXT_519 = ";" + NL + "                    \t\t\t\t";
  protected final String TEXT_520 = NL + "      \t \t\t\t\t\t\t\t\tpositionalUtil_";
  protected final String TEXT_521 = ",columnValue";
  protected final String TEXT_522 = ");" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_523 = NL + "    \t\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_524 = " = null; ";
  protected final String TEXT_525 = "        \t\t\t" + NL + "            \t\t\t" + NL + "    \t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_526 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "        \t\t\t\t\twhetherReject_";
  protected final String TEXT_527 = " = true;";
  protected final String TEXT_528 = NL + "                                throw(e);";
  protected final String TEXT_529 = NL + "                                    ";
  protected final String TEXT_530 = "Struct();";
  protected final String TEXT_531 = NL + "                                        ";
  protected final String TEXT_532 = ";";
  protected final String TEXT_533 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_534 = NL + "                    \t\t\t\t\tlog.error(\"";
  protected final String TEXT_535 = " - \" +e.getMessage());" + NL + "                    \t\t\t\t";
  protected final String TEXT_536 = NL + "                                    System.err.println(e.getMessage());";
  protected final String TEXT_537 = NL + "                                \t";
  protected final String TEXT_538 = NL + "                        }" + NL + "        \t\t\t" + NL + "        \t\t\t";
  protected final String TEXT_539 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_540 = "if(!whetherReject_";
  protected final String TEXT_541 = ") { ";
  protected final String TEXT_542 = "      " + NL + "         \t\t\t\t\t\tif(";
  protected final String TEXT_543 = " == null){ " + NL + "            \t \t\t\t\t\t";
  protected final String TEXT_544 = "Struct();" + NL + "         \t\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_545 = NL + "\t    \t \t\t\t\t\t\t";
  protected final String TEXT_546 = ";    \t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_547 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_548 = " } ";
  protected final String TEXT_549 = "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_550 = NL;

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
	
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<? extends IConnection> connsFlow = node.getOutgoingConnections("FLOW");

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
			
			List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
            
            List<Map<String, String>> trimSelects =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__TRIMSELECT__"
            );
            
            String pattern1 = ElementParameterParser.getValue(node, "__PATTERN__");
            
            String patternUnits = ElementParameterParser.getValue(node, "__PATTERN_UNITS__");
            boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
            
			String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
			
			String trimAll = ElementParameterParser.getValue(node,"__TRIMALL__");
			boolean isTrimAll = true;
			if(trimAll != null && ("false").equals(trimAll)){
				isTrimAll = false;
			}
			
   			String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
   			
    		String header = ElementParameterParser.getValue(node, "__HEADER__");
    		
    		String limit = ElementParameterParser.getValue(node, "__LIMIT__");    		
    		if ("".equals(limit.trim())) limit = "-1";
    		
    		String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    		
        	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    		
    		//need to process rows longger than 100 000 characters, the property SafetySwitch(in talend_file_enhanced-1.1.jar) should be sent to false.(the default is true)
    		//that means if check the option(true), the logic value of bSafetySwitch should be changed to false (XOR with 'true')
    		boolean bSafetySwitch = (("true").equals(ElementParameterParser.getValue(node, "__PROCESS_LONG_ROW__")) ^ true);    		
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);    		  
			
			String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
			boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
			
			boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
			String footer = uncompress?"0":ElementParameterParser.getValue(node, "__FOOTER__");
			
			final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			log4jFileUtil.componentStartInfo(node);
			
    		if(("").equals(header)){
    			header = "0";
    		}
    			
    		if(("").equals(footer)){
    			footer = "0";
    		}
    		
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
    		//now we have to support the three kinds of setting, but it's not good:
    		//"1,2,*"
    		//1,2,*
    		//context.var
            if(!advanced) {
            	if(java.util.regex.Pattern.compile("[0-9,*].*").matcher(pattern1).matches()) {
            	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(pattern1);
    stringBuffer.append(TEXT_25);
    
            	} else {
            	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(pattern1);
    stringBuffer.append(TEXT_27);
    
            	}
            	
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
            }
			IProcess process = node.getProcess();
			String dynamic = ElementParameterParser.getValue(node, "__DYNAMIC__");
			List<? extends INode> dynamicSchemaNodes = process.getNodesOfType("tSetDynamicSchema");
			boolean guessSchemaFromFile = false;
			for (INode currentNode : dynamicSchemaNodes){
				if (currentNode.getUniqueName().equals(dynamic)){
					guessSchemaFromFile = ("true").equals(ElementParameterParser.getValue(currentNode, "__GUESS_SCHEMA_FROM_FILE__"));
				}
			}
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(guessSchemaFromFile);
    stringBuffer.append(TEXT_41);
    
			boolean hasDynamic = metadata.isDynamicSchema();
			boolean useExistingDynamic = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_DYNAMIC__"));
            String dyn = dynamic+"_DYNAMIC";
			if(useExistingDynamic){
				
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
			}
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(footer);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_53);
    
			if("BYTES".equals(patternUnits)){
			
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
			}
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
                String firstConnName = "";
                if (conns!=null) {
            		if (conns.size()>0) {
            			IConnection conn = conns.get(0);
            			firstConnName = conn.getName();
            			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            List<IMetadataColumn> listColumns = metadata.getListColumns();
            				int sizeListColumns = listColumns.size();
                			if(advanced){// custom part start
                				
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sizeListColumns);
    stringBuffer.append(TEXT_62);
    
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {
                					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
                					String align = formats.get(valueN).get("ALIGN");
                					if(("'L'").equals(align)){
                						align = "-1";
                					}else if(("'C'").equals(align)){
                						align = "0";
                					}else{
                						align = "1";
                					}
                					if(valueN%100==0){
    						        
    stringBuffer.append(TEXT_63);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
     if("BYTES".equals(patternUnits)){ 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
     } 
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
									}
									
    stringBuffer.append(TEXT_76);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
        									if("BYTES".equals(patternUnits)){
											
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_91);
    
											}else{
											
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_91);
    
											}
											
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
                                    	if("BYTES".equals(patternUnits)){
										
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
										}else{
										
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    
										}
                                    	
    stringBuffer.append(TEXT_113);
    
									if(isTrimAll || ("true").equals(trimSelects.get(valueN).get("TRIM"))){
									
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
									}
									IMetadataColumn column = listColumns.get(valueN);
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
									String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
									if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_117);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
									} else if("id_Dynamic".equals(column.getTalendType())){
										if(useExistingDynamic){
										
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
                                                if(!"RARE_SYMBOLS".equals(patternUnits)){
                                                
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
                                                } else {
                                                
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
                                                }
        										if("BYTES".equals(patternUnits)){
												
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_156);
    
                								}else{
                								
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    
												}
												if(advanced){
												
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_159);
    
												}
												if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){
												
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
												}
												if(advancedSeparator) { 
												
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_173);
    
												}
												
    stringBuffer.append(TEXT_174);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    
                						}
                					} else {
									
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    
        									if(javaType == JavaTypesManager.DATE) {
												if(checkDate) {
												
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_183);
    
												} else {
												
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_159);
    
												}
											}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
											
    stringBuffer.append(TEXT_174);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_186);
    
											}else if(javaType == JavaTypesManager.BYTE_ARRAY) {
											
    stringBuffer.append(TEXT_174);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_91);
    
											} else {
											
    stringBuffer.append(TEXT_174);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
											}
											
    stringBuffer.append(TEXT_188);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_189);
    					
									}
									if((valueN+1)%100==0){
									
    stringBuffer.append(TEXT_190);
    
        							}
        						}//end for_
        						if(sizeListColumns>0&&(sizeListColumns%100)>0){
        						
    stringBuffer.append(TEXT_191);
    
								}
							}//custom end
							else{//custom not check
								List<IMetadataColumn> columnList = metadata.getListColumns();
								for(int i=0;i <	columnList.size();i++){
									if(i % 100 == 0){
                        		    
    stringBuffer.append(TEXT_192);
    stringBuffer.append(i);
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
    if("BYTES".equals(patternUnits)){
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    }
    if(useExistingDynamic){
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_202);
    
                        		    }
                        		    IMetadataColumn column = columnList.get(i);
									boolean isDynamic = "id_Dynamic".equals(column.getTalendType()) && useExistingDynamic;
                        		    if(isDynamic){
                        				String paddingChar = formats.get(i).get("PADDING_CHAR");
                        				String align = formats.get(i).get("ALIGN");
										
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
                                            if(!"RARE_SYMBOLS".equals(patternUnits)){
                                            
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    
                                            } else {
                                            
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
                                            }
											if("BYTES".equals(patternUnits)){
											
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_218);
    
											}else{
											
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
                        					}
                        					if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){
											
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
											}
											if(advanced){
											
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_91);
    
											}
											if(advancedSeparator) { 
											
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_226);
    
											}
											
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    
                    				} else {
									
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    
                                                if(!"RARE_SYMBOLS".equals(patternUnits)){
                                                
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
                                                } else {
                                                
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
                                                }
                                                
    stringBuffer.append(TEXT_244);
    
                        					if("BYTES".equals(patternUnits)){
    										
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_250);
    
    										}else{
    										
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
     
    										}
           									if(isTrimAll || ("true").equals(trimSelects.get(i).get("TRIM"))){
    										
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_255);
    
    										}
    										
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    
									}
									if((i+1) % 100 == 0){
                        		    
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
                        		    }
								}//for(...)
            					if(columnList.size()>0&&(columnList.size()%100)>0){
								
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
         						}
         						
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {	
                				    if(valueN%100==0){
                					
    stringBuffer.append(TEXT_262);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    
                                    }	
                					
    stringBuffer.append(TEXT_265);
    
                                    IMetadataColumn column = listColumns.get(valueN);
                					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_266);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_268);
    
                					}else if("id_Dynamic".equals(column.getTalendType())){
                					
                					} else {
                					
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_270);
    
                					        if(javaType == JavaTypesManager.DATE) {
                								if(checkDate) {
                								
    stringBuffer.append(TEXT_271);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_273);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_183);
    
												} else {
												
    stringBuffer.append(TEXT_274);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_273);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_275);
    
												}
											}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
											
    stringBuffer.append(TEXT_276);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_273);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_186);
    
					        				}else if(javaType == JavaTypesManager.BYTE_ARRAY) {
											
    stringBuffer.append(TEXT_278);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_91);
    
											} else {
											
    stringBuffer.append(TEXT_278);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_281);
    
											}
											
    stringBuffer.append(TEXT_282);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_283);
    
        							}
									
    stringBuffer.append(TEXT_284);
    
             						if((valueN+1)%100==0){
									
    stringBuffer.append(TEXT_285);
    
             						}
 								}
								
    stringBuffer.append(TEXT_286);
    
            					if(sizeListColumns>0&&(sizeListColumns%100)>0){
								
    stringBuffer.append(TEXT_287);
    
         						}
								
    stringBuffer.append(TEXT_288);
    
        					}//custom not check
                		}
                	}
                }
                
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
    
			if(advanced){
			
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_299);
    
                if("RARE_SYMBOLS".equals(patternUnits)){
                
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    
                }
				for(int i = 0; i < formats.size(); i++){ 
    				if(i == formats.size() - 1 && !(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
    					//now we have to treat the empty string as star, please check the tujs. It's not good.
    					if("*".equals(formats.get(i).get("SIZE")) || "".equals(formats.get(i).get("SIZE"))){
    					
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_308);
    
    					} else {
    					
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(formats.get(i).get("SIZE"));
    stringBuffer.append(TEXT_311);
    
    					}
					}else{
					
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_313);
    
    				}
    			}
				for(int i = 0; i < formats.size(); i++){ 
					if(i == 0){
					
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_317);
    
					}else if(i == formats.size() - 1){
					
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_326);
    
					}else{
					
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_317);
    
    				}
    			}
			}//end if(advanced)
			
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_334);
    
			if(uncompress){
			
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
     if(dieOnError) {
    stringBuffer.append(TEXT_343);
     } else { 
    stringBuffer.append(TEXT_344);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    }
    stringBuffer.append(TEXT_347);
     } 
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
     if(dieOnError) {
    stringBuffer.append(TEXT_353);
     } else { 
    stringBuffer.append(TEXT_354);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    }
    stringBuffer.append(TEXT_357);
     } 
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    
                	if(advanced){
                		if("BYTES".equals(patternUnits)){
                		
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    
                    	}
                    	
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    
                	}else{
                		if("BYTES".equals(patternUnits)){
                		
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_369);
    
                		}
                		
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_372);
    
                	}
                	
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_375);
    
    		}else{
    		
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    
                if(advanced){
                	if("BYTES".equals(patternUnits)){
               		
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    
                    }
                    
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    
                }else{
                	if("BYTES".equals(patternUnits)){
                    
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_384);
    
                	}
            	    
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_299);
    
                }
                
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_392);
    
			}
			if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){
			
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    
				if(advanced){ 
					for(int i = 0; i < formats.size(); i++){ 
					
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_317);
    
					}
				}else{
					
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    
				}
				if("BYTES".equals(patternUnits)){
						if(uncompress){
				
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    
                        }else{
				
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    
                        }
                }else{	
				
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    
				}
			}else{
			
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_410);
    
			}
			
    stringBuffer.append(TEXT_411);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
                
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(bSafetySwitch);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_19);
    
            	}else{
            	
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(bSafetySwitch);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_418);
    
            	}
            	
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_420);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
            	
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    
            	}else{
            	
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    
            	}
            	
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_431);
    
				if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
						if(uncompress){
				
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    
                        }else{
				
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    
                        }
				}else{
				
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_404);
    
				}
				
    stringBuffer.append(TEXT_1);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator)) ){
                
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_19);
    
            	}else{
            	
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_418);
    
            	}
            	
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
     if(dieOnError) {
    stringBuffer.append(TEXT_446);
     } else { 
    stringBuffer.append(TEXT_447);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    }
    stringBuffer.append(TEXT_450);
     } 
    stringBuffer.append(TEXT_451);
    
            	if("BYTES".equals(patternUnits)&&(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
                
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_404);
    
            	}else{
            	
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    
            	}
            	
    stringBuffer.append(TEXT_334);
    
			if("BYTES".equals(patternUnits)){
			
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_463);
    	
			}else{
			
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    
			}
			
    stringBuffer.append(TEXT_465);
    
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
						
    stringBuffer.append(TEXT_466);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_467);
    
        				}
        			}
        		}
        	}
    	
        	if (conns!=null) {
        		if (conns.size()>0) {
        			IConnection conn = conns.get(0);
        			firstConnName = conn.getName();
        			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_471);
    
    						List<IMetadataColumn> listColumns = metadata.getListColumns();
           				    int sizeListColumns = listColumns.size();
                			if(advanced){
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {
                					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
                					String align = formats.get(valueN).get("ALIGN");
                					if(("'L'").equals(align)){
                						align = "-1";
                					}else if(("'C'").equals(align)){
                						align = "0";
                					}else{
                						align = "1";
                					}
                       				if(valueN%100==0){
                                        if("RARE_SYMBOLS".equals(patternUnits)){
                                        
    stringBuffer.append(TEXT_472);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstConnName );
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
    stringBuffer.append(TEXT_19);
    
                                        } else {
                                        
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
     if("BYTES".equals(patternUnits)){ 
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
     } 
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
                                        }
                      				}
        						}
        					}else{// end if(advance)
    						
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    
                        	    List<IMetadataColumn> columnList = metadata.getListColumns();
                        		for(int i=0; i < columnList.size(); i++){
                        			IMetadataColumn column = columnList.get(i);
                    				if(i % 100 == 0){
                    				
    stringBuffer.append(TEXT_506);
     if (useExistingDynamic) { 
    stringBuffer.append(TEXT_507);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(metadata.getDynamicColumn().getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if("BYTES".equals(patternUnits)){
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(metadata.getDynamicColumn().getLabel());
    stringBuffer.append(TEXT_19);
     } else { 
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if("BYTES".equals(patternUnits)){
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_517);
     } 
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    
                        			}
                        		}
                            	
                            	for (int valueN=0; valueN<sizeListColumns; valueN++) {	
                            		if(valueN%100==0){
    								
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    
                            	    }
                               	}
                            }
        
        					log4jFileUtil.debugRetriveData(node,false);
    						
    stringBuffer.append(TEXT_523);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_524);
    }
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    
                            if (dieOnError) {
                            
    stringBuffer.append(TEXT_528);
    
                            } else {
                                if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
                                
    stringBuffer.append(TEXT_529);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_530);
    
                                    for(IMetadataColumn column : metadata.getListColumns()) {
                                    
    stringBuffer.append(TEXT_531);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_532);
    
                                    }
                                    
    stringBuffer.append(TEXT_529);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_382);
    
                                } else if(("").equals(rejectConnName)){
                    	        	if(isLog4jEnabled){
                    	        	
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    
                    				}
                                    
    stringBuffer.append(TEXT_536);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_382);
    
                                } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_537);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_532);
    
                                }
                            } 
                            
    stringBuffer.append(TEXT_538);
            			
    				}
            		if (conns.size()>0) {	
            			boolean isFirstEnter = true;
            			for (int i=0;i<conns.size();i++) {
            				conn = conns.get(i);
            				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
							
    stringBuffer.append(TEXT_539);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_542);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_544);
    
		    	 				for (IMetadataColumn column: metadata.getListColumns()) {
								
    stringBuffer.append(TEXT_545);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_546);
    
            				 	}
            				}
            			}
						
    stringBuffer.append(TEXT_547);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_548);
     } 
    stringBuffer.append(TEXT_549);
    
					}
            	}
    		}
    	}
    }
	
    stringBuffer.append(TEXT_550);
    return stringBuffer.toString();
  }
}
