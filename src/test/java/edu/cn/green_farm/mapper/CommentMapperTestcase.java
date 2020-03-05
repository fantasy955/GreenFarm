package edu.cn.green_farm.mapper;

import edu.cn.green_farm.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTestcase {
    @Resource
    private CommentMapper commentMapper;

    @Test
    public void add() {
        Comment comment = new Comment();
        comment.setProductId(2);
        comment.setUsername("TEST_2");
        comment.setUserAvatar("照片_3");
        comment.setContent("评论测试！-----------");
        comment.setCreatedTime(new Date());
        Integer rows = commentMapper.add(comment);
        System.err.println(rows);
    }

    @Test
    public void findById() {
        System.err.println(commentMapper.findById(2));
    }

    @Test
    public void findByProductId() {
        List<Comment> commentList = commentMapper.findByProductId(2);
        for (Comment comment : commentList) {
            System.err.println(comment);
        }
    }

    @Test
    public void deleteById() {
        Integer rows = commentMapper.deleteById(2);
        System.err.println(rows);
    }

    @Test
    public void deleteByProductId() {
        Integer rows = commentMapper.deleteByProductId(2);
        System.err.println(rows);
    }
}
