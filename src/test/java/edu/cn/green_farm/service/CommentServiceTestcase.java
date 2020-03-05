package edu.cn.green_farm.service;

import edu.cn.green_farm.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTestcase {
    @Autowired
    private ICommentService commentService;

    @Test
    public void add() {
        Comment comment = new Comment();
        comment.setProductId(10000006);
        comment.setUsername("TEST_2");
        comment.setUserAvatar("照片_3");
        comment.setContent("评论测试！-----------");
        comment.setCreatedTime(new Date());
        Integer rows = commentService.add(comment);
        System.err.println(rows);
    }

    @Test
    public void findById() {
        System.err.println(commentService.findById(4));
    }

    @Test
    public void findByProductId() {
        List<Comment> commentList = commentService.findByProductId(10000006);
        for (Comment comment : commentList) {
            System.err.println(comment);
        }
    }

    @Test
    public void deleteById() {
        Integer rows = commentService.deleteById(4);
        System.err.println(rows);
    }

    @Test
    public void deleteByProductId() {
        Integer rows = commentService.deleteByProductId(10000006);
        System.err.println(rows);
    }
}
