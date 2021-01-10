package com.sierraclass.mvnNewProject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsController {

	List<String> friends = new ArrayList<String>();
	
	@RequestMapping(value="/friends", method=RequestMethod.POST )
	public String addFriend(@RequestBody String friend) {
		friends.add(friend);
		return "Successfully added: " + friend;
	}
	
	@RequestMapping("/friends")
	public List<String> getFriends(){
		return friends;
	}
}
