package ru.itmo.navigator_for_parents_app.data_files

object InfoReg {
    private var role = Role.GUEST
    private var email: String = ""

    fun setRole(newRole: Role){
        role = newRole
    }

    fun getRole(): Role {
        return role
    }

    fun setEmail(newEmail: String){
        email = newEmail
    }

    fun getEmail(): String{
        return email
    }
}

enum class Role {
    GUEST, USER
}