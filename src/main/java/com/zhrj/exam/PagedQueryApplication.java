package com.zhrj.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author zhrj
 */
@SpringBootApplication
@MapperScan("com.zhrj.exam.mapper")
public class PagedQueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PagedQueryApplication.class, args);
    }
}
