package com.xzy.controller;

import com.xzy.model.Message;
import com.xzy.model.MessageOperate;
import com.xzy.service.IMessageOperateService;
import com.xzy.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @Autowired
    private IMessageOperateService messageOperateService;

    @ResponseBody
    @RequestMapping("/messageShow.do")
    public List<Message> showMessage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int userId =Integer.parseInt( request.getParameter("userId"));//获取Id
        List<MessageOperate> listMO = messageOperateService.loadAllMessageOperate(userId);
        List<Message> listM = messageService.loadByUserId(userId);//当前用户显示的所有消息
        for(Message message:listM){//处理消息状态
            for(MessageOperate messageOperate:listMO){
                if(messageOperate.getUserId()==userId && messageOperate.getMessageId()==message.getMessageId()) {
                    message.setMessageStatus(1);
                    //System.out.println("改变状态");
                }
            }
        }
        System.out.println(listM);
        return listM;
    }

    @ResponseBody
    @RequestMapping("/saveMessage.do")
    public boolean saveMessage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Message message = new Message();
        String messageTitle = request.getParameter("messageTitle");
        String messageContent = request.getParameter("messageContent");
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userImage = request.getParameter("userImage");
        message.setUserId(userId);
        message.setUserImage(userImage);
        message.setMessageTitle(messageTitle);
        message.setMessageContent(messageContent);

        boolean bool = messageService.saveMessage(message);//保存消息
        if(bool) {//默认当前人对自己的消息已读
            List<Message> list = messageService.loadOnlyMyMessage(userId);//加载当前用户的所有消息
            Message m = list.get(list.size()-1);//取最晚的一条
            MessageOperate messageOperate = new MessageOperate();
            messageOperate.setMessageId(m.getMessageId());
            messageOperate.setUserId(userId);
            messageOperateService.saveMessageOperate(messageOperate);
        }
        return bool;
    }

    @RequestMapping("/saveMessageOperate.do")
    public boolean saveMessageOperate(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int messageId = Integer.parseInt(request.getParameter("messageId"));
        MessageOperate messageOperate = new MessageOperate();
        messageOperate.setMessageId(messageId);
        messageOperate.setUserId(userId);
        boolean bool =  messageOperateService.saveMessageOperate(messageOperate);
        return bool;
    }
}
