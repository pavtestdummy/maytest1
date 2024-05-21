package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class PostRestController {
	
	@GetMapping("/mypost/{id}")
	public Post getPostInfo(@PathVariable("id")String id) {
		System.out.println("in my post");
		String url="https://jsonplaceholder.typicode.com/posts/"+id;
		RestClient rc=RestClient.create();
		
		Post result=rc.get()
		.uri(url)
		.retrieve()
		.body(Post.class);
		
		System.out.println(result.getTitle());
		return result;
	
	}

}
