/**
 * Base class for DAO layer testing.  Assumes the database is loaded
 * with valid data.
 */
package verii.movie_assistant.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("/testingContext.xml")
public abstract class AbstractDaoForTesting extends AbstractTransactionalJUnit4SpringContextTests {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired(required = true)
    protected CastTypeDao castTypeDao;

}