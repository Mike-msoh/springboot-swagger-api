package com.example.demo;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by annakim on 7/26/17.
 */

@RestController
public class RestExController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "excontroller", nickname = "excontroller")
    @RequestMapping(method = RequestMethod.GET, path="/first", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="annie")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RestExModel.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public RestExModel restExModel(@RequestParam(value="name", defaultValue="World") String name) {
        return new RestExModel(counter.incrementAndGet(),
                String.format(template, name));
    }

}
