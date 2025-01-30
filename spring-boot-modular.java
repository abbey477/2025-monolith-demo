└── ecommerce-monolith/
    ├── pom.xml
    ├── common/
    │   ├── pom.xml
    │   └── src/
    │       └── main/java/com/example/common/
    │           ├── dto/
    │           ├── exception/
    │           └── utils/
    ├── product-domain/
    │   ├── pom.xml
    │   └── src/
    │       └── main/java/com/example/product/
    │           ├── api/
    │           │   └── ProductController.java
    │           ├── domain/
    │           │   ├── Product.java
    │           │   └── Category.java
    │           ├── repository/
    │           │   └── ProductRepository.java
    │           └── service/
    │               └── ProductService.java
    ├── order-domain/
    │   ├── pom.xml
    │   └── src/
    │       └── main/java/com/example/order/
    │           ├── api/
    │           │   └── OrderController.java
    │           ├── domain/
    │           │   ├── Order.java
    │           │   └── OrderItem.java
    │           ├── repository/
    │           │   └── OrderRepository.java
    │           └── service/
    │               └── OrderService.java
    └── application/
        ├── pom.xml
        └── src/
            └── main/
                ├── java/com/example/application/
                │   └── EcommerceApplication.java
                └── resources/
                    └── application.yml

// Parent pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.2</version>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>ecommerce-monolith</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>
        <module>common</module>
        <module>product-domain</module>
        <module>order-domain</module>
        <module>application</module>
    </modules>

    <properties>
        <java.version>17</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
        <spring-cloud.version>2023.0.0</spring-cloud.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>

// Common module pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.example</groupId>
        <artifactId>ecommerce-monolith</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>common</artifactId>
</project>

// Product domain module pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.example</groupId>
        <artifactId>ecommerce-monolith</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>product-domain</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>common</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
</project>

// Order domain module pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.example</groupId>
        <artifactId>ecommerce-monolith</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>order-domain</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>common</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>product-domain</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
</project>

// Application module pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.example</groupId>
        <artifactId>ecommerce-monolith</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>application</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>product-domain</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>order-domain</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// Sample domain classes
// Product.java
package com.example.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double price;
    
    @ManyToOne
    private Category category;
}

// ProductService.java
package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}

// ProductController.java
package com.example.product.api;

import com.example.product.domain.Product;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }
}

// Main Application class
package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan("com.example")
@EnableJpaRepositories("com.example")
public class EcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
}

// application.yml
spring:
  datasource:
    url: jdbc:h2:mem:ecommercedb
    username: sa
    password: password
    driver-class-name: org.h2.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
