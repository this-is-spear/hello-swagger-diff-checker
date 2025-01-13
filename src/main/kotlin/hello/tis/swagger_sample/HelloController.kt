package hello.tis.swagger_sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, World!"
    }

    @GetMapping("/hello2")
    fun hello2(): String {
        return "Hello, World! 2"
    }

    @PostMapping("/bye")
    fun bye(): String {
        return "Bye, World!"
    }
}
