package Aok;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import DataModel.ValueExampleObject;
import freemarker.template.*;

public class AokView {
    protected static Configuration cfg;
    protected Map<String, Object> input = new HashMap<String, Object>();
    protected String templateFileName;

    public AokView(String templateFileName){
        // Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.

        this.cfg = new Configuration();

        this.templateFileName = templateFileName;

        // Where do we load the templates from:
        this.cfg.setClassForTemplateLoading(AokView.class, "templates");

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public String getTemplate(){
        Template template = null;

        // Get the template
        try {
            template = cfg.getTemplate(this.templateFileName);
        }catch (IOException ie){
            System.out.println("Get Template Engine Error: " + ie);
        }

        // Write output to the console
        // Writer consoleWriter = new OutputStreamWriter(System.out);
        StringWriter sw = new StringWriter();

        try{
            template.process(input, sw);
        }catch (TemplateException | IOException te){
            System.out.println("Template Engine Process Error: " + te);
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

    public String outPutHTML(){
        // 讓使用者可以 override 的地方
        input.put("title", "Vogella example");

        input.put("exampleObject", new ValueExampleObject("Java object", "me"));

        List<ValueExampleObject> systems = new ArrayList<ValueExampleObject>();
        systems.add(new ValueExampleObject("Android", "Google"));
        systems.add(new ValueExampleObject("iOS States", "Apple"));
        systems.add(new ValueExampleObject("Ubuntu", "Canonical"));
        systems.add(new ValueExampleObject("Windows7", "Microsoft"));
        input.put("systems", systems);

        // 最後記得呼叫 getTemplate()
        String html = getTemplate();

        return html;
    }
}
