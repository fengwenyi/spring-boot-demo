package com.fengwenyi.springbootdemo.demopdf.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-29
 */
public class PdfUtils {

    /**
     * @param fields
     * @param data
     * @throws IOException
     * @throws DocumentException
     */
    private static void fillData(AcroFields fields, Map<String, String> data) throws IOException, DocumentException {
        List<String> keys = new ArrayList<String>();
        Map<String, AcroFields.Item> formFields = fields.getFields();
        for (String key : data.keySet()) {
            if(formFields.containsKey(key)){
                String value = data.get(key);
                fields.setField(key, value); // 为字段赋值,注意字段名称是区分大小写的
                keys.add(key);
            }
        }
        Iterator<String> itemsKey = formFields.keySet().iterator();
        while(itemsKey.hasNext()){
            String itemKey = itemsKey.next();
            if(!keys.contains(itemKey)){
                fields.setField(itemKey, " ");
            }
        }
    }

    /**
     * @param templatePdfName
     *            模板pdf名称
     * @param generatePdfPath
     *            生成pdf路径
     * @param data
     *            数据
     */
    public static String generatePDF(String templatePdfName, String generatePdfPath, Map<String, String> data) {
        OutputStream fos = null;
        ByteArrayOutputStream bos = null;
        try {
            byte[] bytes =generatePDF(templatePdfName,data);
            fos = new FileOutputStream(generatePdfPath);
            fos.write(bytes);
            fos.flush();
            return generatePdfPath;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param templatePdfName
     *            模板pdf名称
     * @param data
     *            数据
     */
    public static byte[] generatePDF(String templatePdfName,  Map<String, String> data) {
        ByteArrayOutputStream bos = null;
        try {
            InputStream istemplate =PdfUtils.class.getClassLoader().getResourceAsStream(templatePdfName);
            PdfReader reader = new PdfReader(istemplate);
            bos = new ByteArrayOutputStream();
            /* 将要生成的目标PDF文件名称 */
            PdfStamper ps = new PdfStamper(reader, bos);
            /* 使用中文字体 */
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
            fontList.add(bf);
            /* 取出报表模板中的所有字段 */
            AcroFields fields = ps.getAcroFields();
            fields.setSubstitutionFonts(fontList);
            fillData(fields, data);
            /* 必须要调用这个，否则文档不会生成的  如果为false那么生成的PDF文件还能编辑，一定要设为true*/
            ps.setFormFlattening(true);
            ps.close();

            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
