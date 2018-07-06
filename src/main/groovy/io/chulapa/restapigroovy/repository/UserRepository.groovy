package io.chulapa.restapigroovy.repository

import io.chulapa.restapigroovy.model.User

class UserRepository {
    final static USERS = [
            new User(name: 'Filipe', age: 37),
            new User(name: 'Vicente', age: 27),
            new User(name: 'Duquesne', age: 28),
            new User(name: 'La Hire', age: 12),
            new User(name: 'Pigmaleao', age: 23)

    ]
}
