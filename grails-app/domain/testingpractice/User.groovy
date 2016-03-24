package testingpractice

class User {

    Integer code
    String name
    String mail
    static hasMany = [subjects: Subject]
    static constraints = {
        code nullable: false
        mail nullable: false
        name nullable: false
        subjects nullable: true
    }
}
