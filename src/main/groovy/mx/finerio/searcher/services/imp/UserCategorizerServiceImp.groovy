package mx.finerio.searcher.services.imp

import mx.finerio.searcher.dtos.UserCategorizerDto
import mx.finerio.searcher.model.UserCategorizer
import mx.finerio.searcher.repository.UserCategorizerRepository
import mx.finerio.searcher.services.UserCategorySearchService
import mx.finerio.searcher.validation.UserCategoryCommand
import org.hibernate.search.jpa.FullTextEntityManager
import org.hibernate.search.jpa.Search
import org.hibernate.search.query.dsl.QueryBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.apache.lucene.search.Query

import javax.transaction.Transactional

@Service
@Transactional

class UserCategorizerServiceImp implements UserCategorySearchService {

    @PersistenceContext
    EntityManager entityManager

    @Autowired
    UserCategorizerRepository userCategorizerRepository

    @Override
    UserCategorizerDto create(UserCategoryCommand cmd) {
        UserCategorizer userCategorizer = new UserCategorizer()
        userCategorizer.with {
            userId = cmd.userId
            categoryId = cmd.categoryId
            description = cmd.description
        }
        new UserCategorizerDto(userCategorizerRepository.save(userCategorizer))
    }

    @Override
    UserCategorizerDto findById(long id) {
        new UserCategorizerDto(userCategorizerRepository.findById(id))
    }

    @Override
    List findByDescription(long userId, String description ) throws Exception {

        if ( !description || !userId ) {
            return []
        }

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager( entityManager )
        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity( UserCategorizer ).get()


        Query userCategories = queryBuilder
                .keyword()
                .onField("userId").matching(userId)
                .createQuery()

        Query fuzzy = queryBuilder
                .keyword()
                .fuzzy()
                .onField( 'description' )
                .matching( description )
                .createQuery()

        Query full = queryBuilder.bool()
                .must(userCategories)
                .must(fuzzy)
                .createQuery()

        fullTextEntityManager.createFullTextQuery( full, UserCategorizer ).getResultList()

    }
}
