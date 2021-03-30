package com.example.readersroom.controller;

import com.example.readersroom.entity.Books;
import com.example.readersroom.entity.Member;
import com.example.readersroom.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping({"/list", "/"})
    public String listBooks(Model model){
        model.addAttribute("members", memberService.listAll());
        return "members/list";
    }

    @RequestMapping("/show/{id}")
    public String getBook(@PathVariable Long id, Model model){
        model.addAttribute("members", memberService.getById(id));
        return "members/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("members", memberService.getById(id));
        return "members/memberform";
    }

    @RequestMapping("/new")
    public String createBook(Model model){
        model.addAttribute("members", new Member());
        return "redirect:/members/memberform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Member member){
        Member savedMember = memberService.saveOrUpdate(member);
        return "redirect:/members/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        memberService.delete(id);
        return "redirect:/members/list";
    }

}
