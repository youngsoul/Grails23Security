import com.bluelobsterstudios.Role
import com.bluelobsterstudios.User
import com.bluelobsterstudios.UserRole

class BootStrap {

    def init = { servletContext ->

      def userRole = Role.findOrCreateWhere(authority: 'ROLE_USER').save(flush:true, failOnError: true)
      def adminRole = Role.findOrCreateWhere(authority: 'ROLE_ADMIN').save(flush:true, failOnError: true)


      def testUser = User.findOrSaveWhere(username: 'me', enabled: true, password: 'password', firstName: "Bob", lastName: "Builder").save(flush:true, failOnError: true)

      def adminUser = User.findOrSaveWhere(username: 'admin', enabled: true, password: 'admin', firstName: "Admin", lastName: "Admin").save(flush:true, failOnError: true)


      UserRole.findOrSaveWhere(user: testUser, role: userRole).save(flush:true, failOnError: true)
      UserRole.findOrSaveWhere(user: adminUser, role: adminRole).save(flush:true, failOnError: true)

      assert User.count() == 2
      assert Role.count() == 2
      assert UserRole.count() == 2

    }
    def destroy = {
    }
}
