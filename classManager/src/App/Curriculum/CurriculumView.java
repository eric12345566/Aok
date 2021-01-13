package App.Curriculum;

import Aok.AokView;
import App.Data.CurriculumViewData;

public class CurriculumView extends AokView {
    public CurriculumView(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String outPutHTML() {
        input.put("data", this.dataObj);
        return getTemplate();
    }
}
