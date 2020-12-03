package mx.finerio.searcher.repository

import mx.finerio.searcher.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@DataJpaTest
@ActiveProfiles('test')
class CategoryRepositorySpec extends Specification {

    @Autowired
    CategoryRepository categoryRepository

    def "Should save and find a category"() {

        given:'a saved category'

        Category category = new Category()
        category.with {
            id = 1

        }

        categoryRepository.save(category)

        when:
        def result =  categoryRepository.findById(1L)

        then:
        assert result
    }

}
