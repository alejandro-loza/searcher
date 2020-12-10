package mx.finerio.searcher

import io.restassured.module.mockmvc.RestAssuredMockMvc
import mx.finerio.searcher.controllers.CategoryController
import spock.lang.Specification

abstract class BaseRestContract extends Specification {

    CategoryController controller = new CategoryController()

    def setup() {
        RestAssuredMockMvc.standaloneSetup(controller)
    }

}
