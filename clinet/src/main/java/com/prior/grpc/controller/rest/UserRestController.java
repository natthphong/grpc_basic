package com.prior.grpc.controller.rest;


import com.prior.grpc.Service.UserService;
import com.prior.grpc.models.ResponseModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/get")
    public ResponseModel<String> getHello(@RequestBody Map<String,String> body){
        return userService.getHello(body);
    }


    @PostMapping("/upload/file")
    public ResponseModel<String> uploadFile(@RequestParam("file")MultipartFile file){
        return userService.uploadFile(file);

    }

    @GetMapping("/get/file")
    public ResponseModel<String> getFile(){
        return  userService.getFile();
    }

    @GetMapping("/get/teachers")
    public ResponseModel<String> getTeacher(){
        return  userService.getTeacher();
    }
}
