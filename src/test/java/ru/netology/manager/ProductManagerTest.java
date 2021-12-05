package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "book1", 1000, "автор1");
    Product book2 = new Book(2, "book2", 2000, "автор2");
    Product smartphone1 = new Smartphone(11, "iPhone", 5000, "USA");
    Product smartphone2 = new Smartphone(22, "Honor", 2000, "China");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("book2");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("автор1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("автор3");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Honor");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacture() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindManufacture() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Canada");
        assertArrayEquals(expected, actual);
    }

}

