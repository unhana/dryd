package com.lyf.dryd;

import com.lyf.dryd.dao.dataobject.User;
import com.lyf.dryd.web.dataobject.UserReq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/login")
@SpringBootApplication
public class DrydApplication {



	@ResponseBody
	@PostMapping(path = "account2")
	public String tst(@RequestBody UserReq user){
		return user.getPassword() + user.getUserName();
	}

	public static void main(String[] args) {
		SpringApplication.run(DrydApplication.class, args);
	}

}
