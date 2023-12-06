package com.productservice.productservice;

//import com.productservice.productservice.inheritancerelations.mappedsuperclass.Mentor;

import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.OrderRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;
//    private final PriceRepository priceRepository;
//    private final OrderRepository orderRepository;
//
//    public ProductServiceApplication(CategoryRepository categoryRepository,
//                                     ProductRepository productRepository,
//                                     PriceRepository priceRepository,
//                                     OrderRepository orderRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//        this.priceRepository = priceRepository;
//        this.orderRepository = orderRepository;
//    }
//    private MentorRepository mentorRepository;
//    private UserRepository userRepository;
//    private StudentRepository studentRepository;
//
//    ProductServiceApplication(@Qualifier("st_mentorrepo") MentorRepository mentorRepository,
//                              @Qualifier("st_userrepo") UserRepository userRepository,
//                              @Qualifier("st_studentrepo") StudentRepository studentRepository){
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//        this.studentRepository = studentRepository;
//    }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//    ProductServiceApplication(@Qualifier("tpc_mentorrepository")
//                              MentorRepository mentorRepository,
//                              StudentRepository studentRepository,
//                              UserRepository userRepository){
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
//    @Transactional
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Sankhadip");
//        mentor.setEmail("sankhadip10.das@gmaiol.com");
//        mentor.setAvgRating(4.8);
//
//        mentorRepository.save(mentor);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Ricky");
//        mentor.setEmail("ricky.das25@gmail.com");
//        mentor.setAvgRating(4.5);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Ram");
//        student.setEmail("ram.das25@gmail.com");
//        student.setPsp(80.0);
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setEmail("archi@gmail.com");
//        user.setName("Archii");
//        userRepository.save(user);
//
//
//        //Get all the Users
//        List<User> users = userRepository.findAll();
//        for(User user1 :users){
//            System.out.println(user1.toString());
//        }
//        User user =new User();
//        user.setName("Arshi");
//        user.setEmail("arshi@gmail.com");
//        userRepository.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("sankhad@gmail.com");
//        mentor.setAvgRating(4.8);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Sankha");
//        student.setEmail("ricky.das25@gmail.com");
//        student.setPsp(99.0);
//        studentRepository.save(student);


//        Category category = new Category();
//        category.setName("Apple Devices");
////
//        Category savedCategory = categoryRepository.save(category);

//        Optional<Category> optionalcategory = categoryRepository.findById(UUID.fromString("377c924b-df67-4596-8637-5e8f3c860171"));
//
//        if (optionalcategory.isEmpty()){
//            throw new Exception("Category was null");
//        }
//        Category category = optionalcategory.get();
//        Product product = new Product();
//        product.setTitle("iPhone 15 pro");
//        product.setDescription("Best iPhone ever");
////        product.setCategory(savedCategory);
//        product.setCategory(category.get());
//
//       Product savedProduct =   productRepository.save(product);

        //Find all the products with category category = Apple Devices
//        List<Product> products = category.getProducts();
//        for(Product product:products){
//            System.out.println(product.getTitle());
//        }

//        Price price  = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);
//
////        Price savedPrice = priceRepository.save(price);
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory =categoryRepository.save(category);
//
//        Product product = new
//                Product();
//        product.setTitle("Iphone 15 Pro");
//        product.setDescription("Best Iphone ever");
//        product.setCategory(savedCategory);
////        product.setPrice(savedPrice);
//        product.setPrice(price);
////
//       Product savedProduct =  productRepository.save(product);
        //delete a particular product
//        productRepository.deleteById(UUID.fromString("c39efaa0-441a-4e5b-8460-e04715b6cb1b"));
//        Optional<Price> optionalPrice = priceRepository.findById(UUID.fromString("1569b755-ece2-476b-b8ee-deae0943f308"));
//
//        if (optionalPrice.isEmpty()){
//            throw new Exception("Price is empty");
//        }
//        Price price = optionalPrice.get();
//        priceRepository.deleteById(UUID.fromString("1569b755-ece2-476b-b8ee-deae0943f308"));

//        Category category = new Category();
//        category.setName("Apple Device");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setValue(100000);
//        price.setCurrency("INR");

//        Optional<Price> optionalPrice = priceRepository.findById(UUID.fromString("dc769868-3b1d-43c6-a90d-11b938ce38c3"));
//
//        if(optionalPrice.isEmpty()){
//            throw new Exception("Price object is NULL");
//        }
//        Price price = optionalPrice.get();
//
//
//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("8883ca4b-5a71-46fd-bd32-ac5b19f4e4ea"));
//        if(optionalCategory.isEmpty()){
//            throw new Exception("Category Object is NULL");
//        }
//        Category category = optionalCategory.get();

//        Product product1 = new Product();
//        product1.setPrice(price);
//        product1.setTitle("Iphone 15 pro");
//        product1.setDescription("Best Iphone ever");
//        product1.setImage("IMG");
//        product1.setCategory(category);
//        Product savedProduct = productRepository.save(product1);
//
//        Price price1 = new Price();
//        price1.setValue(100000);
//        price1.setCurrency("INR");
//
//        Product product2 = new Product();
//        product2.setPrice(price1);
//        product2.setTitle("Iphone 15 pro");
//        product2.setDescription("Best Iphone ever");
//        product2.setImage("IMG");
//        product2.setCategory(category);
//        Product savedProduct1 = productRepository.save(product2);
//
//        Price price2 = new Price();
//        price2.setValue(100000);
//        price2.setCurrency("INR");
//
//        Product product3 = new Product();
//        product3.setPrice(price2);
//        product3.setTitle("Iphone 15 pro");
//        product3.setDescription("Best Iphone ever");
//        product3.setImage("IMG");
//        product3.setCategory(category);
//        Product savedProduct2 = productRepository.save(product3);

        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("94048e1e-a59f-4ece-a1e9-58f818192f1d"));

        Category category = optionalCategory.get();

        List<Product> products = category.getProducts();
        for (Product product:products){
            System.out.println(product.getTitle());
        }
    }
}
