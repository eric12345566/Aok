package App.Curriculum;

import Aok.AokView;

public class CurriculumView extends AokView {
    public CurriculumView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML() {
        input.put("courseObj", this.dataObj);
        return getTemplate();
    }
}
