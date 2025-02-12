package com.MegaDeals.controller;

import com.MegaDeals.entity.Seller;
import com.MegaDeals.model.ProductDto;
import com.MegaDeals.repository.SellerRepository;
import com.MegaDeals.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final SellerRepository sellerRepository;
    @Autowired
    public ProductController(SellerRepository sellerRepository,ProductService productService) {
        this.sellerRepository = sellerRepository;
        this.productService = productService;
    }

    @GetMapping("/home")
    public String goToHomePage(@RequestParam(value = "pageNo",defaultValue ="1") int pageNo, Model model, HttpServletRequest request) {
        Page<ProductDto> page = productService.getAllProduct(pageNo);

        // For testing Cart page this code will be removed in the following
        List<ProductDto> cartItemsList = page.getContent();
        request.getSession().setAttribute("cartItemsList", cartItemsList);
        /////////////////////////////////////////////////////////////////////
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
    @GetMapping("/home/search")
    public String getSearchResult(@RequestParam(value = "pageNo",defaultValue ="1") int pageNo, @RequestParam(value = "query") String name, Model model) {
        Page<ProductDto> page = productService.getAllProductByName(name,pageNo);
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
    @GetMapping("/ShowAddProduct")
    public String addProduct(Model model){
        model.addAttribute("productModel",new ProductDto());
        return "ProjectManagement/addProduct";
    }

    @PostMapping("/AddProduct")
    public String processAddProduct(@Valid @ModelAttribute("productModel") ProductDto theProduct , BindingResult result, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "ProjectManagement/addProduct";
        }
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","File is empty");
            return "ProjectManagement/addProduct";
        }
        Optional<Seller> theSeller = sellerRepository.findById(1);
        theProduct.setSellerID(theSeller.get());
        theProduct.setCreationTime(LocalDateTime.now());
        theProduct.setLastUpdateTime(LocalDateTime.now());
        productService.addProduct(theProduct,file);
        return "redirect:/home";
    }
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
