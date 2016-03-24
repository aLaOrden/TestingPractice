package testingpractice

import grails.test.spock.IntegrationSpec

class UserPersistenceIntegrationSpec extends IntegrationSpec {

    UserController userController

    void "count grades for an specific user"() {

        setup:
        def user = new User(code: "1022356024", name: "Alejandro Arias", mail: "huaariasza@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 5))
        user.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4) )

        when:
        userController = new UserController()
        def count = userController.getGradesCount(user)

        then:
        count == 2

    }

    void "get grades average for an specific user"() {

        setup:
        def user = new User(code: "1022356024", name: "Alejandro Arias", mail: "huaariasza@unal.edu.co", subjects: new Subject(code : "232454", name:"Ingeniería de software II", grade: 5))
        user.subjects.add( new Subject(code : "232452", name:"Lenguajes de programación", grade: 4) )

        when:
        userController = new UserController()
        def average = userController.getGradesAverages(user)

        then:
        average == 4.5

    }
}
