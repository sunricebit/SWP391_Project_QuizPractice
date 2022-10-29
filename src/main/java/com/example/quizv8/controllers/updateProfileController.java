package com.example.quizv8.controllers;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/updateProfile")
public class updateProfileController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("change")
    public String updateProfile(){
        return "updateProfile";
    }
    @RequestMapping("update")
    public String changePassword(HttpServletRequest request, HttpSession session, Model model){
        Optional<QuizUser> currentUser =(Optional<QuizUser>) session.getAttribute("currentUser");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        System.out.println(""+currentUser.get().getPassword());
        if(!oldPass.equals(currentUser.get().getPassword())){
            model.addAttribute("notification", true);
            return "forward:/updateProfile/change/";
        }
        else {
            currentUser.get().setPassword(newPass);
            iUserService.saveUser(currentUser.get());
        }
        return "redirect:/home";
    }
}
