package eu.swdev.spring.webclienttest.server;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/handshake")
@ResponseBody
public class Controller {

    @PostMapping(path = "step1")
    public String step1(@RequestBody byte[] body) {
        System.out.println("bytes - length: " + body.length);
        return "ok";
    }
}
