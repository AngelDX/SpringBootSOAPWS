package com.angeldx.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.angeldx.api.users.GetUserRequest;
import com.angeldx.api.users.GetUserResponse;
import com.angeldx.service.UserService;


@Endpoint
public class UserEndpoint {
	
	@Autowired
    private UserService userService;


    @PayloadRoot(namespace = "http://angeldx.com/api/users",
            localPart = "getUserRequest")
    
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
	
	
}
