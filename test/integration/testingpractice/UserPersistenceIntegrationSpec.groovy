package testingpractice

import grails.test.spock.IntegrationSpec

class UserPersistenceIntegrationSpec extends IntegrationSpec {

    UserController userController

    void "count grades for an specific user"() {

        setup:
        def user = new User(code: "1022356024", name: "Alejandro Arias", mail: "huaariasza@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 5))
        user.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4) )
        user.subjects.add( new Subject(code : "2015734", name:"Programación de computadores", grade: 4.1) )
        user.subjects.add( new Subject(code : "2016749", name:"Introduccion a la ingenieria de sistemas", grade: 4) )
        user.subjects.add( new Subject(code : "2016698", name:"Elementos de computadores", grade: 4) )
        user.subjects.add( new Subject(code : "2016375", name:"Programacion orientada a objetos", grade: 4.3) )
        user.subjects.add( new Subject(code : "2016697", name:"Arquitectura de computadores", grade: 4.3) )
        user.subjects.add( new Subject(code : "2016353", name:"Bases de datos", grade: 4.3) )
        user.subjects.add( new Subject(code : "2016699", name:"Estructuras de datos", grade: 3.1) )
        user.subjects.add( new Subject(code : "2016707", name:"Sistemas operativos", grade: 4.2) )

        when:
        userController = new UserController()
        def count = userController.getGradesCount(user)
        then:
        count == 10
    }

    void "get grades average for an specific user"() {

        setup:
        def user = new User(code: "1022356024", name: "Alejandro Arias", mail: "huaariasza@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 5))
        user.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4) )
        user.subjects.add( new Subject(code : "2015734", name:"Programación de computadores", grade: 4.1) )
        user.subjects.add( new Subject(code : "2016749", name:"Introduccion a la ingenieria de sistemas", grade: 4) )
        user.subjects.add( new Subject(code : "2016698", name:"Elementos de computadores", grade: 4) )
        user.subjects.add( new Subject(code : "2016375", name:"Programacion orientada a objetos", grade: 4.3) )
        user.subjects.add( new Subject(code : "2016697", name:"Arquitectura de computadores", grade: 4.3) )
        user.subjects.add( new Subject(code : "2016353", name:"Bases de datos", grade: 4.3) )
        user.subjects.add( new Subject(code : "2016699", name:"Estructuras de datos", grade: 3.1) )
        user.subjects.add( new Subject(code : "2016707", name:"Sistemas operativos", grade: 4.2) )

        when:
        userController = new UserController()
        def average = userController.getGradesAverages(user)
        then:
        average == 4
    }
}
