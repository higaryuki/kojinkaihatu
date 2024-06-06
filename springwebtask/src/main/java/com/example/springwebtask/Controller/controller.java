package com.example.springwebtask.Controller;

import com.example.springwebtask.Entity.form.DeleteForm;
import com.example.springwebtask.Entity.form.ProductForm;
import com.example.springwebtask.Entity.form.UserForm;
import com.example.springwebtask.Entity.record.CategoryRecord;
import com.example.springwebtask.Entity.record.InsertRecord;
import com.example.springwebtask.Entity.record.ProductsRecord;
import com.example.springwebtask.Entity.record.UserRecord;
import com.example.springwebtask.dao.product.ProductDao;
import com.example.springwebtask.dao.user.UserDao;
import com.example.springwebtask.service.delete.DeleteServis;
import com.example.springwebtask.service.insert.InsertService;
import com.example.springwebtask.service.product.ProductService;
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

        InsertRecord proId = insertService.findById(productForm.getProduct_id());

        if (proId==null) {
            var insert = new InsertRecord(productForm.getProduct_id(), productForm.getName(), productForm.getPrice(), productForm.getCategories_id(), productForm.getDescription());
            insertService.insert(insert);
            return "success";
        }else {
            model.addAttribute("errormeg","商品IDが重複しています");
            return "insert";
        }
    }

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

    @GetMapping("updateInput/{id}")
    public String update(@PathVariable("id")int id,Model model){
        var prolist = productService.findProId(id);
        var catelist = insertService.findCategory();
        //System.out.println(list);
        model.addAttribute("product",prolist);
        model.addAttribute("select",catelist);
        return "updateInput";
    }
}

