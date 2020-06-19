package com.taotas.selenideintro.homework.task3;

import common.xpathutils.X;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//*[@id='todo-list']/li"))
                .shouldHave(exactTexts("a", "b", "c"));

        element(byXpath("//*[@id='todo-list']/li[.//text()='b']//*" +
                "[" + X.hasCssClass("toggle") + "]")).click();

        elements(byXpath("//*[@id='todo-list']/li" +
                "[" + X.hasCssClass("completed") + "]"))
                .shouldHave(exactTexts("b"));
        elements(byXpath("//*[@id='todo-list']/li" +
                "[not(" + X.hasCssClass("completed") + ")]"))
                .shouldHave(exactTexts("a", "c"));
    }
}