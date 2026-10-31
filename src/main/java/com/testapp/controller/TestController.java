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
import com.monframework.model.Session;
import com.monframework.annotation.Auth;

@Annotation
public class TestController {

    @Auth
    @Controller(value = "/profil")
    public String testSession() {
       return "hello.jsp";
    }

    @Controller(value = "/login", method = "GET")  
    public String loginForm() {
        return "login.jsp";
    }
    
    // Sprint 9 
    @Controller(value = "/login",  method = "POST")
    public String login(Session session , Employe user) {
        session.put("user", user);
        // Sprint 10 bis : le poste sert de rôle
        session.put("role", user.getPoste());
        return "hello.jsp";
    }

    // Sprint 10 bis : réservé au rôle admin
    @Auth("admin")
    @Controller(value = "/admin")
    public String admin() {
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