/**
 * 
 */
package org.test.hellobeer.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author esloho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class BeerControllerTest {

    private MockMvc mvc;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new BeerController()).build();
    }

    /**
     * Test method for
     * {@link org.test.hellobeer.controller.BeerController#menu(org.springframework.ui.Model)}
     * .
     * 
     * @throws Exception
     */
    @Test
    public void testMenu() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hellobeer"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("menu"));
    }

    /**
     * Test method for
     * {@link org.test.hellobeer.controller.BeerController#listBeers(org.springframework.ui.Model)}
     * .
     */
    @Test
    public void testListBeers() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link org.test.hellobeer.controller.BeerController#newBeerForm(org.test.hellobeer.model.Beer, org.test.hellobeer.model.Brewery, org.springframework.ui.Model)}
     * .
     */
    @Test
    public void testNewBeerForm() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link org.test.hellobeer.controller.BeerController#addBeer(org.test.hellobeer.model.Beer, org.springframework.validation.BindingResult, org.springframework.ui.Model)}
     * .
     */
    @Test
    public void testAddBeer() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link org.test.hellobeer.controller.BeerController#deleteBeer(long, org.springframework.ui.Model)}
     * .
     */
    @Test
    public void testDeleteBeer() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link org.test.hellobeer.controller.BeerController#detailBeer(long, org.springframework.ui.Model)}
     * .
     */
    @Test
    public void testDetailBeer() {
        fail("Not yet implemented"); // TODO
    }

}
