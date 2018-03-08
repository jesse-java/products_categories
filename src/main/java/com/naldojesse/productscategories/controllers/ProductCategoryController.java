package com.naldojesse.productscategories.controllers;

import com.naldojesse.productscategories.models.Category;
import com.naldojesse.productscategories.models.Product;
import com.naldojesse.productscategories.services.CategoryService;
import com.naldojesse.productscategories.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductCategoryController {

    private final ProductService productService;
    private final CategoryService categoryService;
    public ProductCategoryController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "new_product.jsp";
    }

    @PostMapping("/products/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "new_product.jsp";
        } else {
            productService.addProduct(product);
            return "redirect:/products/new";
        }
    }

    @RequestMapping("/products/{index}")
    public String viewProduct(Model model, @PathVariable("index") Long index) {
        Optional<Product> product = productService.findProductById(index);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("categories", categoryService.allCategories());
            return "view_product.jsp";
        } else {
            return "redirect:/products/new";
        }
    }


    @PostMapping("/products/{id}/add_category/")
    public String addCategoryToProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "view_product.jsp";
        } else {
            Optional<Product> old_product = productService.findProductById(id);
            if (old_product.isPresent()) {
                Product retrieved_product = old_product.get();
                Category category = product.getCategories().get(0);
                System.out.println("Getting category " + category);
                retrieved_product.getCategories().add(category);
                productService.updateProduct(retrieved_product);
            } else {
                System.out.println("product does not exist!");
            }
            return "redirect:/products/" + id;
        }
    }



//    ----------------------------------------- CATEGORY -----------------------------

    @RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "new_category.jsp";
    }

    @PostMapping("/categories/create")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "new_category.jsp";
        } else {
            categoryService.addCategory(category);
            return "redirect:/categories/new";
        }
    }

    @RequestMapping("/categories/{index}")
    public String viewCategory(Model model, @PathVariable("index") Long index) {
        Optional<Category> category = categoryService.findCategoryById(index);
        if (category.isPresent()) {
            model.addAttribute("product", new Product());
            model.addAttribute("products", productService.findAll());
            model.addAttribute("category", category.get());
            return "view_category.jsp";
        } else {
            return "redirect:/categories/new";
        }
    }


    @PostMapping("/categories/{id}/add_product")
    public String addProductToCategory(@PathVariable("id") Long category_id, @RequestParam("product") Long product_id) {
        System.out.println(product_id);
        System.out.println(category_id);

        Optional<Category> category = categoryService.findCategoryById(category_id);
        if(category.isPresent()) {
            Optional<Product> product = productService.findProductById(product_id);
            if(product.isPresent()) {
                Category retrieved_category = category.get();
                Product retrieved_product = product.get();
                retrieved_category.getProducts().add(retrieved_product);
                categoryService.updateCategory(retrieved_category);
            }
        }


        return "redirect:/categories/" + category_id;
    }
//    public String addProducToCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, @PathVariable("id") Long id) {
//        if (result.hasErrors()) {
//            return "view_category.jsp";
//        } else {
//            Optional<Category> old_category = categoryService.findCategoryById(id);
//            if (old_category.isPresent()) {
//                Category retrieved_category = old_category.get());
//                Product product = category
//            }
//        }
//    }



}
