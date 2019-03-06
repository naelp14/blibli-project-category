package com.category.category;

import com.category.category.Service.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryServiceImplTest {
    private CategoryServiceImpl categories;

    @Before
    public void setUp() throws Exception {
        categories = new CategoryServiceImpl();
    }

    @Test
    public void testCreate(){
        Category product = new Category("123","asdf");
        categories.create(product);

        Assert.assertTrue("Total harus ada 1", categories.findAll().size()==1);

        Category temp = categories.findById("123");
        Assert.assertTrue("Product harus ada", product.getIdCategory().equals(temp.getIdCategory()));
    }

    @Test
    public void testFindId(){

        Category product = categories.findById("kosong");
        Assert.assertTrue("Product harus null", product == null);

        categories.create(new Category("234","ababab"));
        Assert.assertTrue("ID harus ketemu", categories.findById("234").getNameCategory().equals("ababab"));
    }

    @Test
    public void testFindAll(){
        categories.create(new Category("234","ababab"));
        Category category = new Category("123","asdf");
        categories.create(category);

        Assert.assertTrue("Size harus 2", categories.findAll().size()==2);
    }

    @Test
    public void testUpdate(){
        categories.create(new Category("234","ababab"));
        categories.update(new Category("234","hahaahh"));

        Assert.assertTrue("Nama harus terupdate", categories.findById("234").getNameCategory().compareTo("hahaahh")==0);

        Category product = categories.update(new Category("534","ababab"));

        //Assert.assertTrue(category==null);
    }

    @Test
    public void testDelete(){
        Category product = categories.delete("534");

        Assert.assertTrue(product==null);

        categories.create(new Category("234","ababab"));
        categories.create(new Category("534","hahaahh"));

        Assert.assertTrue("Size harus 2", categories.findAll().size()==2);

        categories.delete("234");
        Assert.assertTrue("Harus di delete", categories.findById("234")==null);

        categories.delete("534");
        Assert.assertTrue("Size harus 0", categories.findAll().size()==0);
    }
}
