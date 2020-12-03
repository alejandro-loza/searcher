package mx.finerio.searcher.model

import groovy.transform.ToString
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@ToString(includeNames = true, includePackage = false,
    includes = [ 'username' ])
class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String username
    String password
    boolean enabled = true
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false
    Date dateCreated
    Date lastUpdated
    Date dateDeleted

}
