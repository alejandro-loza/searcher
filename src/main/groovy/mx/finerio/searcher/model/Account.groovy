package mx.finerio.searcher.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Account   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    User user
    FinancialEntity financialEntity
    String nature
    String name
    String number
    float balance
    Date dateCreated
    Date lastUpdated
    Date dateDeleted

}
