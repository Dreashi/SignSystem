package com.xyz.service.ipml;

import com.xyz.dao.IQuestionsDao;
import com.xyz.model.Questions;
import com.xyz.service.IQuestionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("questionsService")
public class QuestionsService implements IQuestionsService {
    @Resource
    private IQuestionsDao questionsDao;

    @Override
    public Questions selectRandomQuestion() {
        return this.questionsDao.selectRandomQuestion();
    }
}
