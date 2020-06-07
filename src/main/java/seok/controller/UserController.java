package seok.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seok.model.User;
import seok.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value="msnodeve")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/user")
    @ApiOperation(value = "모든 유저의 정보를 반환한다.", response = List.class)
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = null;
        try {
            users = service.findAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "유저의 정보를 반환한다.", response = Object.class)
    public ResponseEntity<User> findByUserId(@PathVariable String id) {
        User user = null;
        try {
            user = service.findByUserId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/user")
    @ApiOperation(value = "유저의 정보를 입력한다.", response = String.class)
    public ResponseEntity<String> registryUser(@RequestBody User user) {
        try {
            if (service.registry(user) != 0)
                return new ResponseEntity<>("성공적으로 등록되었습니다.", HttpStatus.CREATED);
            else
                return new ResponseEntity<>("등록 실패했습니다.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("등록 실패했습니다.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/user")
    @ApiOperation(value = "유저의 정보를 수정한다.", response = String.class)
    public ResponseEntity<String> modifyUser(@RequestBody User user) {
        try {
            if (service.modify(user) != 0)
                return new ResponseEntity<>("성공적으로 수정되었습니다.", HttpStatus.OK);
            else
                return new ResponseEntity<>("수정 실패했습니다.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("수정 실패했습니다.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "유저의 정보를 삭제한다.", response = String.class)
    public ResponseEntity<String> removeUser(@PathVariable String id) {
        try {
            if (service.remove(id) != 0)
                return new ResponseEntity<>("성공적으로 삭제되었습니다.", HttpStatus.OK);
            else
                return new ResponseEntity<>("삭제 실패했습니다.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("삭제 실패했습니다.", HttpStatus.BAD_REQUEST);
    }
}
