package mx.finerio.searcher.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import mx.finerio.searcher.model.Category

@Repository
interface CategoryRepository extends JpaRepository<Category, Long>  {
    Category findById(long id)
}