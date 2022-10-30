package com.example.quizv8;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.ICategoryService;
import com.example.quizv8.service.IQuizListService;
import com.example.quizv8.service.IStateService;
import com.example.quizv8.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuizV8ApplicationTests {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IStateService iStateService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IQuizListService iQuizListService;
    @Test
    void testGetAllUser() {
        Assert.assertNotEquals("20", iUserService.getAllUser().size() + "");
    }
    @Test
    void testSaveUser(){
        QuizUser user = new QuizUser();
        user.setEmail("testUnit@abc.com");
        user.setPassword("123456");
        user.setRole("student");
        user.setStatus(true);
        Assert.assertEquals(true, iUserService.saveUser(user));
    }
    @Test
    void testGetUserbyEmail(){

        
        Assert.assertEquals("truong998hiro@gmail.com", iUserService.getUserbyEmail("truong998hiro@gmail.com").get().getEmail());
    }
    @Test
    void testGetQuizByUserID(){
        Assert.assertEquals(1, iQuizListService.getQuizByUserID(1).size());
    }
    @Test
    void testGetQuizListById(){
        Assert.assertEquals(19, iQuizListService.getQuizListById(19).getId());

    }
    @Test
    void testGetQuizPublic(){
        Assert.assertEquals(1, iQuizListService.getQuizPublic(2).size());
    }
    @Test
    void testGetQuizByCategory(){
        Assert.assertEquals(1,iQuizListService.getQuizByCategory("chemistry").size());

    }
    @Test
    void testGetAllQuestion(){
        Assert.assertNotEquals(1, iQuizListService.getAllQuestion(19).size());
    }
    @Test
    void testGetAllExam(){
        int size = iQuizListService.getAllExam(2).size();
        Assert.assertEquals(5, size);
    }
    @Test
    void testGetAllCategory(){
        Assert.assertEquals(2, iCategoryService.getAllCategory().size());
    }
    @Test
    void testGetAllState(){
        Assert.assertEquals(3, iStateService.getAllState().size());
    }
    @Test
    void testGetState(){
        Assert.assertEquals(true, iStateService.getState(3).isPresent());
    }
}
