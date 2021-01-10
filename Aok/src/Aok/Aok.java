package Aok;

public class Aok {
    public static void main(String[] args) throws Exception {
        AokView av = new AokView("helloworld.ftl");
        System.out.println(av.outPutHTML());
    }
}
