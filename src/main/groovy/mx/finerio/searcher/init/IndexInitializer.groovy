package mx.finerio.searcher.init

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

import org.hibernate.search.jpa.Search

import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class IndexInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @PersistenceContext
    EntityManager entityManager

    void onApplicationEvent( ContextRefreshedEvent event ) {
        Search.getFullTextEntityManager(
                entityManager ).createIndexer().startAndWait()
    }

}
