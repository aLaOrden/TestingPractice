package testingpractice

import grails.test.spock.IntegrationSpec
import sun.nio.cs.US_ASCII

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

    void "get grades average for an users collection"() {

        setup:
        def users = new ArrayList<User>()
        def user1 = new User(code: "1022356024", name: "Alejandro Arias", mail: "huaariasza@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 5))
        user1.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4) )
        user1.subjects.add( new Subject(code : "2015734", name:"Programación de computadores", grade: 4.1) )
        user1.subjects.add( new Subject(code : "2016749", name:"Introduccion a la ingenieria de sistemas", grade: 4) )
        user1.subjects.add( new Subject(code : "2016698", name:"Elementos de computadores", grade: 4))
        users.add(user1)
        def user2 = new User(code: "2879673", name: "Gabriel Gonzalez", mail: "gggonzalezg@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 4))
        user2.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4.2) )
        user2.subjects.add( new Subject(code : "2015734", name:"Programación de computadores", grade: 3.1) )
        user2.subjects.add( new Subject(code : "2016749", name:"Introduccion a la ingenieria de sistemas", grade: 3,3) )
        user2.subjects.add( new Subject(code : "2016698", name:"Elementos de computadores", grade: 3.9))
        users.add(user2)
        def user3 = new User(code: "2879000", name: "Miguel Asencio", mail: "maasencioh@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 3))
        user3.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4.4) )
        user3.subjects.add( new Subject(code : "2015734", name:"Programación de computadores", grade: 2.1) )
        user3.subjects.add( new Subject(code : "2016749", name:"Introduccion a la ingenieria de sistemas", grade: 4,3) )
        user3.subjects.add( new Subject(code : "2016698", name:"Elementos de computadores", grade: 3.6))
        users.add(user3)
        def user4 = new User(code: "2879700", name: "Juan Olarte", mail: "jpolartet@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 2))
        user4.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4.6) )
        user4.subjects.add( new Subject(code : "2015734", name:"Programación de computadores", grade: 1.1) )
        user4.subjects.add( new Subject(code : "2016749", name:"Introduccion a la ingenieria de sistemas", grade: 3,7) )
        user4.subjects.add( new Subject(code : "2016698", name:"Elementos de computadores", grade: 3.3))
        users.add(user4)
        def user5 = new User(code: "2879800", name: "Santiago Moerno", mail: "sagonzalezmo@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 1))
        user5.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4.8) )
        user5.subjects.add( new Subject(code : "2015734", name:"Programación de computadores", grade: 5) )
        user5.subjects.add( new Subject(code : "2016749", name:"Introduccion a la ingenieria de sistemas", grade: 4,7) )
        user5.subjects.add( new Subject(code : "2016698", name:"Elementos de computadores", grade: 3))
        users.add(user5)

        when:
        userController = new UserController()
        def averages = userController.GetGradesAveragesUsersCollection(users)
        then:
        averages == [4,4,4,4,4]
    }
}

