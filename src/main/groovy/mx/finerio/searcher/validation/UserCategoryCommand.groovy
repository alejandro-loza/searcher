package mx.finerio.searcher.validation

import groovy.transform.ToString

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@ToString(includeNames = true, includePackage = false)
class UserCategoryCommand extends ValidationCommand {

    @NotNull(message= 'categorizer.user.null')
    @NotBlank(message= 'categorizer.null.blank')
    Long userId
    @NotNull(message= 'categorizer.description.null')
    @NotBlank(message= 'categorizer.description.blank')
    String description
    @NotNull(message= 'categorizer.categoryId.null')
    @NotBlank(message= 'categorizer.categoruId.blank')
    Long categoryId

}
