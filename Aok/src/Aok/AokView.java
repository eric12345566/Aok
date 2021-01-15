package Aok;

import java.io.*;
import java.util.*;

import freemarker.template.*;

/**
 * AokView 負責處理網頁模版，也就是動態網頁的工作。使用的是 Freemarker Template Engine。
 */
public abstract class AokView implements Observer{
    protected static Configuration cfg;
    protected Map<String, Object> input = new HashMap<String, Object>();
    protected String templateFileName;
    protected Object dataObj;

    /**
     * AokView 建構子，可以直接帶入 template 檔案名稱
     * @param templateFileName template 檔案名稱，儲存在 templates 資料夾裡
     */
    public AokView(String templateFileName){

        // Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.

        this.cfg = new Configuration();

        this.templateFileName = templateFileName;

        // Where do we load the templates from:
        this.cfg.setClassForTemplateLoading(AokView.class, "/templates");

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.TAIWAN);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    /**
     * 生成已經綁定資料到模板的字串輸出
     * @return 已綁定資料的頁面
     */
    public String getTemplate(){
        Template template = null;

        // Get the template
        try {
            template = cfg.getTemplate(this.templateFileName);
        }catch (IOException ie){
            System.out.println("Template Engine IO Error: \n" + ie);
        }

        // Write output to the console
        // Writer consoleWriter = new OutputStreamWriter(System.out);
        StringWriter sw = new StringWriter();

        try{
            template.process(input, sw);
        }catch (TemplateException | IOException te){
            System.out.println("Template Engine Process Error: \n" + te);
        }

        /*

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

        */

        return sw.toString();
    }

    /**
     * Observer 收到通知後的處理函式
     * @param o 互叫的 Observable 物件
     * @param arg 傳送的物件
     */
    @Override
    public void update(Observable o, Object arg) {
        this.dataObj = arg;
    }

    /**
     * 使用者可自行定義的資料綁定方法
     * @return 通常會配合getTemplate()使用，直接傳出已綁定好資料的 template
     */
    public abstract String outPutHTML();

}
