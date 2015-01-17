package org.sandcastle.saumilp;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(value = "hello", description = "Swagger First Specification example")
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation(value = "Hello World Functionality")
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(@ApiParam(name="model", value = "Model Map used for the View", required = true) ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
}