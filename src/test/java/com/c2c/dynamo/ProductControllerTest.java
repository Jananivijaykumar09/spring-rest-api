package com.c2c.dynamo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.c2c.dynamo.ProductController;
import com.c2c.dynamo.model.Products;
import com.c2c.dynamo.repositories.ProductRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void checkProductCreation() throws Exception {
        Products product = new Products();
        product.setId(1);
        product.setName("sample");
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
        mvc.perform(post("/products")
                .content("{\n" +
                        "  \"id\":1,\n" +
                        "  \"name\": \"sample\",\n" +
                        "  \"description\":\"description\"\n" +
                        '}')
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
    }
}
