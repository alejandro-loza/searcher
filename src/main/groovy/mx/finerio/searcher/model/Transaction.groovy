package mx.finerio.searcher.model

import groovy.transform.ToString
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@ToString(includeNames = true, includePackage = false,
    includes = 'id, date, charge, description, amount')
class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    Account account
    Date date
    boolean charge
    String description
    float  amount
    Date dateCreated
    Date lastUpdated
    Date dateDeleted
    Category category
    SystemCategory systemCategory

}
