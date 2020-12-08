package mx.finerio.searcher.repository

import mx.finerio.searcher.model.UserCategorizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@DataJpaTest
@ActiveProfiles('test')
class CategoryRepositorySpec extends Specification {

    @Autowired
    UserCategorizerRepository userCategorizerRepository

    def "Should save and find an user categorized"() {
        given:
        UserCategorizer userCategorizer = new UserCategorizer()
        userCategorizer.with {
            userId = 1
            categoryId = 1
            description = 'UBER EATS'
        }
        userCategorizerRepository.save(userCategorizer)

        when:
        def response = userCategorizerRepository.findById(userCategorizer.id)

        then:
        response.with {
            assert dateCreated
            assert lastUpdated
            assert id
            assert description == userCategorizer.description
        }
    }

}
