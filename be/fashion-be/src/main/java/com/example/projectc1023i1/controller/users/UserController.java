package com.example.projectc1023i1.controller.users;


import com.example.projectc1023i1.Exception.UserExepion;
import com.example.projectc1023i1.model.Users;
import com.example.projectc1023i1.request.UpdateUserRequest;
import com.example.projectc1023i1.respone.ApiRespone;
import com.example.projectc1023i1.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController("/api/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<Users> getUserProfileHandler (@AuthenticationPrincipal Users user) throws UserExepion {
        Users users = userService.findUserById(user.getUserId());
        return new ResponseEntity<Users>(users, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{value}")
    public ResponseEntity<List<Users>> getUserHandler (@PathVariable String value) throws UserExepion {
        List<Users> users = userService.searchUsers(value);
        return  new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

    @PostMapping("/update-profile")
    public ResponseEntity<ApiRespone> updateProfile (@RequestBody UpdateUserRequest user,
                                                     @AuthenticationPrincipal Users users) throws UserExepion {

        Users userUpdate = userService.updateUser(users.getUserId(),user);
        ApiRespone apiRespone = new ApiRespone("Update Profile User Succes",true);
        return new ResponseEntity<ApiRespone>(apiRespone, HttpStatus.ACCEPTED);
    }

}
