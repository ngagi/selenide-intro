package com.taotas.selenideintro.lessons;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completesTask() {
        open("https://todomvc.com/examples/emberjs/");
        Configuration.timeout = 10000;
        element("#new-todo").shouldBe(visible).setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        element(byId("new-todo")).setValue("c").pressEnter();

        elements("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));

        elements("#todo-list>li").findBy(exactText("b"))
                .find(".toggle").click();

        elements("#todo-list>li").filterBy(cssClass("completed"))
                .shouldHave(exactTexts("b"));

        elements("#todo-list>li").filterBy(not(cssClass("completed")))
                .shouldHave(exactTexts("a", "c"));
    }
}
