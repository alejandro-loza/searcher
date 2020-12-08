package mx.finerio.searcher.dtos

import mx.finerio.searcher.model.UserCategorizer

class UserCategorizerDto {
    Long id
    Long userId
    String description
    Long categoryId
    Date dateCreated
    Date lastUpdated

    UserCategorizerDto(UserCategorizer userCategorizer) {
        this.id = userCategorizer.id
        this.userId = userCategorizer.userId
        this.description = userCategorizer.description
        this.categoryId = userCategorizer.categoryId
        this.dateCreated = userCategorizer.dateCreated
        this.lastUpdated = userCategorizer.lastUpdated
    }

}
