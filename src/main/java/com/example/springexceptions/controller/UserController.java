package com.example.springexceptions.controller;

import com.example.springexceptions.exception.WrongLoginException;
import com.example.springexceptions.exception.WrongPasswordException;
import com.example.springexceptions.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String Hello() {

        return "input user's data";
    }
    @GetMapping("/input")
    public String input(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password, @RequestParam(name = "confirmPassword") String confirmPassword) {
        boolean result = false;
        try {
            result = UserService.checkData(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return e.getMessage();
        } catch (WrongPasswordException e){
            return e.getMessage();
        } catch (Exception e){
            return "Ooops... Shit happens. Try again";
        }
        return (result ? "Successful" : "Unsuccessful");
    }
}
