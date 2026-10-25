package com.testapp.controller;

import com.monframework.controller.Annotation;
import com.monframework.annotation.Controller;
import com.monframework.annotation.Rest;
import com.testapp.model.Employe;
import com.testapp.model.Fichier;
import java.util.List;
import java.util.UUID;
import java.nio.file.Files;
import java.nio.file.Paths;

@Annotation
public class TestController {


    // Sprint 9 
    @Controller(value = "/login",  method = "GET")
    public String login(Session session , User user) {
        session.put("user", user);
        return "hello.jsp";
    }

    // Sprint 8 
    @Rest
    @Controller(value = "/upload", method = "POST")
    public String upload(Fichier f) throws Exception {
       String nomGenere = UUID.randomUUID() + "." + f.getExtension();
       Files.write(Paths.get("/tmp/uploads/" + nomGenere),f.getContenu());
       return nomGenere;
    }

    // Sprint 7 
    @Rest
    @Controller(value = "/save-olona", method = "POST") 
    public String save(Employe e) {
        return e.nom + " " + e.poste;
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

    // Page Sprint 8
    @Controller(value="/sprint8")
    public String sprint8() {
        return "sprint8.jsp";
    }

    // Page Sprint 7
    @Controller(value="/sprint7")
    public String sprint7() {
        return "sprint7.jsp";
    }
}