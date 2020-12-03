package mx.finerio.searcher.model

import groovy.transform.ToString
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@ToString(includeNames = true, includePackage = false,
    includes = 'id, name')
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    Client client
    Date dateCreated
    Date dateDeleted
}
