package application.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.UserInfo;
import application.service.UserInfoService;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")

@RequiredArgsConstructor

public class UserInfoController {
	@Autowired
	UserInfoService userService;

	@GetMapping("/getall")
	public List<UserInfo> getAllUserInfo() {
		return userService.getAllUserInfo();
	}

	@GetMapping("/get/{id}")
	public UserInfo getUser(@PathVariable("id)") Long userid) {
		return userService.getUserById(userid);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") Long userid) {
		userService.deleteUser(userid);
	}

	@PostMapping("/add")
	public void addUser(@RequestBody UserInfo user) {
		userService.addUser(user);
	}

}
