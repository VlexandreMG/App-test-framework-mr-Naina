package com.testapp.controller;

import com.monframework.controller.Annotation;
import com.monframework.annotation.Controller;
import com.monframework.annotation.Rest;
import com.testapp.model.Employe;
import java.util.List;

@Annotation
public class TestController {

    // Sprint 7
    @Controller(value = "/save-olona", method = "POST") 
    public String save(String nom , String prenom) {
        return "hello.jsp";
    }

    // Test 1 : Route HTML / JSP classique
    @Controller(value = "/hello")
    public String sayHello() {
        return "hello.jsp";
    }

    // Test 2 : Route API JSON (Sprint 6)
    @Rest
    @Controller(value = "/api/employes")
    public List<Employe> getEmployes() {
        return List.of(
            new Employe("Alice", "Développeuse"),
            new Employe("Bob", "Architecte")
        );
    }

    @Controller(value="/sprint7")
    public String sprint7() {
        return "sprint7.jsp";
    }
}