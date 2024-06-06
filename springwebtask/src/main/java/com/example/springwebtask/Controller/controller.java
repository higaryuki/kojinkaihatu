package com.example.springwebtask.Controller;

import com.example.springwebtask.Entity.form.ProductForm;
import com.example.springwebtask.Entity.form.UserForm;
import com.example.springwebtask.Entity.record.CategoryRecord;
import com.example.springwebtask.Entity.record.InsUpdRecord;
import com.example.springwebtask.Entity.record.ProductsRecord;
import com.example.springwebtask.Entity.record.UserRecord;
import com.example.springwebtask.service.delete.DeleteServis;
import com.example.springwebtask.service.insert.InsertService;
import com.example.springwebtask.service.product.ProductService;
import com.example.springwebtask.service.update.UpdateService;
import com.example.springwebtask.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class controller {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    InsertService insertService;
    @Autowired
    DeleteServis deleteServis;
    @Autowired
    UpdateService updateService;

    @Autowired
    private HttpSession session;


    //ログイン
    @GetMapping("/index")
    public String index(@ModelAttribute("userForm") UserForm userForm){
        return "index";
    }

    @PostMapping("/index")
    public String login(@Validated @ModelAttribute("userForm") UserForm userForm,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "index";
        }

        var user = userService.findloginId(userForm.getLoginId());

       if (user==null){
           model.addAttribute("errormeg","IDまたはパスワードが不正です");
           return "index";
       }else if (!Objects.equals(userForm.getPassword(), user.password())){
           return "index";
       }

       var loginuser = new UserRecord(user.id(),user.login_id(), user.password(), user.name(), user.role(),user.created_at(),user.updated_at());
       session.setAttribute("loginuser",loginuser);
       return "redirect:/menu";
    }


    //検索
    @GetMapping({"/menu","/menu/{order}&{keyword}"})
    public String menu(@RequestParam(name = "order",defaultValue = "")String order, @RequestParam(name = "keyword",defaultValue = "") String keyword, Model model){

        List<ProductsRecord> list;
        System.out.println(keyword);

        if (keyword.isEmpty()) {
            list = productService.findAll();
        }else {
            list = productService.findName(keyword);
        }
        //System.out.println("接続確認" + list);
        
        model.addAttribute("menu", list);
        var count = list.size();
        //System.out.println("接続確認"+count);
        model.addAttribute("count",count);
        return "menu";
    }

    //新規登録
    @GetMapping("/insert")
    public String insert(@ModelAttribute("ProductForm") ProductForm productForm, Model model){
        List<CategoryRecord> list = insertService.findCategory();
        model.addAttribute("select",list);
        //System.out.println(list);
        return "insert";
    }

    @PostMapping("/insert")
    public String insert(@Validated @ModelAttribute("ProductForm") ProductForm productForm, BindingResult bindingResult, Model model){
        List<CategoryRecord> list = insertService.findCategory();
        model.addAttribute("select",list);
        //System.out.println(list);
        if(bindingResult.hasErrors()){
            return "insert";
        }

        InsUpdRecord proId = insertService.findById(productForm.getProduct_id());

        if (proId==null) {
            var insert = new InsUpdRecord(productForm.getProduct_id(), productForm.getName(), productForm.getPrice(), productForm.getCategories_id(), productForm.getDescription());
            insertService.insert(insert);
            return "success";
        }else {
            model.addAttribute("errormeg","商品IDが重複しています");
            return "insert";
        }
    }

    //詳細画面
    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id")int id,Model model){
        var list = productService.findProId(id);
        //System.out.println(list);
        model.addAttribute("product",list);
        return "detail";
    }

    @PostMapping("detail/{id}")
    public String detaildel(@PathVariable("id")int id,Model model){
        System.out.println(id);

        /*var product = productService.findProId(id);
        if(product==null){
            model.addAttribute("errormeg","IDまたはパスワードが不正です");
        }*/
        deleteServis.delete(id);
        return "/success";
    }

    //更新
//    @GetMapping("/updateInput/{id}")
//    public String update(@PathVariable("id")int id, @ModelAttribute("ProductForm") ProductForm productForm,Model model){
//        var prolist = productService.findProId(id);
//        var catelist = insertService.findCategory();
//        //System.out.println(list);
//        model.addAttribute("product",prolist);
//        model.addAttribute("select",catelist);
//        return "updateInput";
//    }

    @GetMapping("/updateInput/{id}")
    public String update(@PathVariable("id")int id, @ModelAttribute("ProductForm") ProductForm productForm,Model model){
        var prolist = productService.findProId(id);
        var catelist = insertService.findCategory();
        //System.out.println(list);
        model.addAttribute("ProductForm",prolist);
        model.addAttribute("select",catelist);
        return "updateInput";
    }

    @PostMapping("/updateInput/{id}")
    public String update(@PathVariable("id") int beforeid,@Validated @ModelAttribute("ProductForm") ProductForm productForm, BindingResult bindingResult, @PathVariable("id")int id,Model model){
//        System.out.println("--------------------------------------------------------");
//        System.out.println(productForm.getProduct_id());
//        System.out.println(productForm.getName());
//        System.out.println(productForm.getPrice());
//        System.out.println(productForm.getCategories_id());
//        System.out.println(productForm.getDescription());

        if(bindingResult.hasErrors()){

            return "redirect:/updateInput/{id}";
        }

        //InsUpdRecord proId = insertService.findById(productForm.getProduct_id());
        var update = new InsUpdRecord(productForm.getProduct_id(),productForm.getName(),productForm.getPrice(),productForm.getCategories_id(),productForm.getDescription());
        updateService.update(update,beforeid);
        return "/success";

        /*if(proId==null){
        }else {
            model.addAttribute("errormeg","商品IDが重複しています");
            return "redirect:/updateInput/{id}"; }*/
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute("UserForm")UserForm userForm){
        session.invalidate();
        return "logout";
    }

}

