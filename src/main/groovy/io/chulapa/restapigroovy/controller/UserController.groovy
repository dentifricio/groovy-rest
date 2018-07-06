package io.chulapa.restapigroovy.controller

import io.chulapa.restapigroovy.model.User
import io.chulapa.restapigroovy.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/users')
class UserController {


    @GetMapping
    List<User> listUsers() {
        UserRepository.USERS
    }

    @GetMapping('/tostring')
    String tostring() {
        UserRepository.USERS.inject('') { acc, user -> acc + "${user.name}, ${user.age}\n"
        }
    }

    @GetMapping('/oddage')
    List<User> oddage(){
        UserRepository.USERS
                            .findAll() {it.age % 2 != 0}

    }

    @GetMapping('/evenage')
    List<User> evenage(){
        UserRepository.USERS
                            .findAll() {it.age % 2 == 0}

    }

    @GetMapping(value = '/agebiggerthan/{age}' )
    //@RequestMapping(value = "/agebiggerthan/{age}", method = RequestMethod.GET)
    List<User> agebiggerthan(@PathVariable String age){
        Integer z = age.toInteger()
        UserRepository.USERS
                            .findAll() {it.age > z}
    }

    @GetMapping('/age')
    List<Integer> age(){
        UserRepository.USERS.age
                             //   .findAll()
    }

    @GetMapping('/name')
    List<String> name(){
        UserRepository.USERS.name
                           //      .findAll()
    }

    @GetMapping('/agesum')
    Integer agesum(){
        UserRepository.USERS.age.sum()
    }

    @GetMapping('/ageavg')
    def ageavg(){
        UserRepository.USERS.age.sum()/UserRepository.USERS.size()
    }




/*
GET /users
GET /users/tostring
GET /users/oddage -> Lista com usuários idade ímpar
GET /users/evenage -> Lista com usuários idade par
GET /users/agebiggerthan?age=10 -> Lista com usuários idade > 10
GET /users/age -> Lista com idades
GET /users/name -> Lista com nomes
GET /users/agesum -> soma das idades
GET /users/ageavg -> média das idades
*/

}