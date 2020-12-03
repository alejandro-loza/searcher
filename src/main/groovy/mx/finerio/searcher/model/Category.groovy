package mx.finerio.searcher.model

import org.apache.lucene.analysis.core.LowerCaseFilterFactory
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory
import org.apache.lucene.analysis.standard.StandardTokenizerFactory
import org.hibernate.search.annotations.*

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Indexed
@AnalyzerDefs([
        @AnalyzerDef(
                name = 'b_es',
                tokenizer = @TokenizerDef(factory = StandardTokenizerFactory),
                filters = [
                        @TokenFilterDef(factory = LowerCaseFilterFactory),
                        @TokenFilterDef(factory = SnowballPorterFilterFactory, params = [
                                @Parameter(name = 'language', value = 'Spanish')
                        ])
                ]
        ),
        @AnalyzerDef(
                name = 'b_en',
                tokenizer = @TokenizerDef(factory = StandardTokenizerFactory),
                filters = [
                        @TokenFilterDef(factory = LowerCaseFilterFactory),
                        @TokenFilterDef(factory = SnowballPorterFilterFactory, params = [
                                @Parameter(name = 'language', value = 'English')
                        ])
                ]
        )
])
class Category  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @Field
    String name
    String color
    Date dateCreated
    Date lastUpdated
    User user
    Client client
    Date dateDeleted
    Category parent

}
