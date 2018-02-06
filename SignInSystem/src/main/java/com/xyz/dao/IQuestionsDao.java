package com.xyz.dao;

import com.xyz.model.Questions;

public interface IQuestionsDao {
    /* 返回一条随机题目 */
    Questions selectRandomQuestion();

//    /* 预留 */
//    int updateQuestionAnswer();
//    int insertQuestion(Questions questions);
}
