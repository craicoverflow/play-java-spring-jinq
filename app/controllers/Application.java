package controllers;


import models.Bar;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.BarService;
import views.html.index;

@org.springframework.stereotype.Controller
public class Application {

//    @Autowired
    private final BarService barService;

    @Autowired
    public Application(BarService barService) {
        this.barService = barService;
    }

    public Result index() {
        return play.mvc.Controller.ok(index.render(Form.form(Bar.class)));
    }

    public Result addBar() {
        Form<Bar> form = Form.form(Bar.class).bindFromRequest();
        Bar bar = form.get();
        barService.addBar(bar);
        return index();
    }

    public Result listBars() {
        return play.mvc.Controller.ok(Json.toJson(barService.getAllBars()));
    }
    
}