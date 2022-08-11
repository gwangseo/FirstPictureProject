package jpapicture.picture.controller;

import jpapicture.picture.domain.Member;
import jpapicture.picture.MemberForm;
import jpapicture.picture.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String joinUs(Model model) {
        model.addAttribute("memberFrom", new MemberForm());
        return "join";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "join";
        }
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
