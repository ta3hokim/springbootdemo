package com.personal.personaldemo.PostController;

import java.util.List;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

import com.personal.personaldemo.model.Post;
import com.personal.personaldemo.service.PostService;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    // RequiredArgsConstructor : lombok을 이용한 방법1
    private final PostService postService;
    /* 방법2
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }
    */
    /* 방법3
    @Autowired
    Postservice postService;
    */

    @GetMapping("/list")
    public List<Post> postList(@RequestParam String title){
        if (title != null) {
            return postService.findPostList(title);
        } else {
            return postService.postList();
        }
    }
    //Post의 리스트형식으로 리턴하는데 이게 Json형태로 데이터를 전송한다.
    //형태가 제이슨

    //@PathVariable 사용하기, 변수명 이름 통일시키기
    @GetMapping("/{postId}")
    public Post aPost(@PathVariable String postId){

        return new Post(UUID.randomUUID(), "title100", "content100", "", LocalDateTime.now());
    }
    
    // 글 쓰기 버튼 누르면 글쓰기페이지로 전이
    @GetMapping("/create")
    public String postCreatePage(){
        return "postcreate"; // postcreate.html 미구현
    }

    @PostMapping("upload")
    public String postWrite(){
        return "";
    }
    /*
    //쿼리, get은 바디사용못함 그래서 쿼리가 대체 하지만 유저한테보임
    @GetMapping("/update")
    public String postUpdate(@RequestParam String PostId){

        return postId + "번 수정테스트";
    }
    */
}
