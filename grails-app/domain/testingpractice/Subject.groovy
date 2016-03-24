package testingpractice

class Subject {

    String code
    String name
    Integer grade

    static constraints = {
        code nullable: false
        name nullable: false
        grade nullable: true, min: 0, max: 5
    }
}
