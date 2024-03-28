package kr.swu.spring_mvc.chap01;

import kr.swu.spring_mvc.chap01.domain.Human;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// 클래스 위에 해당 애너테이션을 붙이면, 전체 메서드에 앞서서 붙을 접두주소를 지정함
@RequestMapping("reqres")
public class RequestController2 {

    @RequestMapping("login-form")
    public String goLoginForm(){
        // localhost:8080/reqres/login-form
        // /WEB-INF/views/reqres/loginform.jsp로 연결
        // 폴더를 앞에 reqres로 생성하고 거기에 loginform.jsp를 생성해야 함
        return "reqres/loginform";
    }

    // @RequestMapping 애너테이션의 value(기본지정)은 주소, method는 허용 메서드
    //@RequestMapping(value="login", method= RequestMethod.POST)
    @PostMapping("login")
    public String checkLoginReq( // id, pw 변수에 담겨오는 값 처리
                                 @RequestParam(value = "id", defaultValue = "아이디없음") String id,
                                 @RequestParam(value = "pw", defaultValue = "비번없음") String pw,
                                 Model model){
        System.out.println("로그인 요청 아이디 : " + id);
        System.out.println("로그인 요청 비번 : " + pw);
        // 자바 내부에 들어온 데이터를 화면(loginresult.jsp)으로 보내기 위해서는
        // addAttribute("보낼이름", 자료)가 필요함
        model.addAttribute("uid", id); //id 변수에 든 값을 "uid"라는 이름으로 전달
        model.addAttribute("upw", pw);
        return "reqres/loginresult";
    }

    // /reqres/human
    @GetMapping("human") // get 방식만 허용하는 컨트롤러
    public String showHuman(Human human, Model model){// 화면으로 자료 보내줌
        System.out.println(human);
        // 커맨드 객체의 경우는 객체 째로 보냄
        model.addAttribute("human", human);
        return "reqres/human-result";
    }

    // human-form 주소로 접속했을 때 human에 해당하는 데이터들을
    // 화면에 보여줄 수 있는 .jsp파일 작성하기
    // 해당 주소로 접속하면 form 페이지가 나오고 여기서 제출 버튼을 누르면
    // 커맨드 객체 human이 해당 페이지에서 보낸 자료를 받음
    @GetMapping("human-form")
    public String goHumanForm(){
        return "reqres/human-form";
    }

    @GetMapping("book/{page}")
    public String digitalBook(@PathVariable int page, Model model){
        model.addAttribute("page", page);
        return "digital-book";
    }

}
