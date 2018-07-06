package io.chulapa.restapigroovy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping('/')
    Map index() {
        [message: 'Ode to Joy']
    }

    @PostMapping('/')
    Map post(@RequestBody Map map) {
        map
    }

}
