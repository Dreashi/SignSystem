package com.xzy.controller;


import com.xzy.model.Questions;
import com.xzy.service.IQuestionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Resource
    private IQuestionsService questionsService;

    @ResponseBody
    @RequestMapping("/selectRandomQuestion.do")
    public Questions selectRandomQuestion(HttpServletRequest request , HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Questions question = this.questionsService.selectRandomQuestion();

        question.setQuestionOptions(question.getQuestionOption().split(","));

        return question;
    }
}
