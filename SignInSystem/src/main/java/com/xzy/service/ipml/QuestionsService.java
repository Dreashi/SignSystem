package com.xzy.service.ipml;

import com.xzy.dao.IQuestionsDao;
import com.xzy.model.Questions;
import com.xzy.service.IQuestionsService;
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
