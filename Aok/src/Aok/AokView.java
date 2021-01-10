package Aok;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.*;

public abstract class AokView {
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
        this.cfg.setClassForTemplateLoading(AokView.class, "/templates");

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.TAIWAN);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

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

    public abstract String outPutHTML(Object obj);

}
