package com.MegaDeals.controller;

import com.MegaDeals.model.ProductDto;
import com.MegaDeals.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/home")
    public String goToHomePage(@RequestParam(value = "pageNo",defaultValue ="1") int pageNo, Model model) {
        Page<ProductDto> page = productService.getAllProduct(pageNo);

        List<ProductDto> productsList = page.getContent();
        model.addAttribute("productsList",productsList);
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());

        //temprory code
        boolean loggedIn=true;
        model.addAttribute("loggedIn",loggedIn);

    return "ProjectManagement/HomePage";
    }
//    @PostMapping("/showProductDetails")
//    public String showProductDetails(@RequestParam int id,Model model){
//       ProductDetails theProduct = productService.getProductDetails(id);
//       model.addAttribute("productModel",theProduct);
//        return "ProjectManagement/viewDetails";
//    }
//    @PostMapping("/processForm")
//    public String processForm(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result,@RequestParam int id){
//        if(result.hasErrors()){
//            return "ProjectManagement/viewDetails";
//        }
//        ProductDetails updatedProduct = productService.getProductDetails(id);
//        updatedProduct.setName(theProduct.getName());
//        updatedProduct.setExpirationDate(theProduct.getExpirationDate());
//        productService.updateProduct(updatedProduct);
//         return "redirect:/home";
//    }
//    @PostMapping("/addProduct")
//    public String addProduct(Model model){
//        model.addAttribute("productModel",new ProductDetails());
//        return "ProjectManagement/addProduct";
//    }
//
//    @PostMapping("/processAddProduct")
//    public String processAddProduct(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result){
//        if(result.hasErrors()){
//            return "ProjectManagement/addProduct";
//        }
//        productService.addProduct(theProduct);
//        return "redirect:/home";
//    }
//
//    @PostMapping("/updateProduct")
//    public String updateProduct(Model model){
//        model.addAttribute("productModel",new ProductDetails());
//        return "ProjectManagement/updateDetails";
//    }
//
//    @PostMapping("/processUpdateProductForm")
//    public String processUpdateProductForm(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result){
//        if(result.hasErrors()){
//            return "ProjectManagement/updateDetails";
//        }
//        productService.updateProduct(theProduct);
//        return "redirect:/home";
//    }
//    @PostMapping("/deleteProduct")
//    public String deleteProduct(@RequestParam int id){
//        productService.deleteProduct(id);
//        return "redirect:/home";
//    }
}
