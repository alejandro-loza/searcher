package mx.finerio.searcher.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SystemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    String color
    Date dateCreated
    Date lastUpdated
    Date dateDeleted
    SystemCategory parent
    String finerioConnectId
}
