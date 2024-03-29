package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class); // permite generar mensajes de erro

    // atributos
    private BookRepository bookRepository;

    // contructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll() {

        return bookRepository.findAll();
    }

    // Buscar un solo libro en base de datos según su id
    @GetMapping("/api/books/{id}")
    @ApiOperation("Buscar un libro por clave primaria id Long")
    public ResponseEntity<Book> findOneByID(@ApiParam("Clave primaria tipo Long") @PathVariable Long id) {

        Optional<Book> bookOpt = bookRepository.findById(id);

        // option 1

//        if (bookOpt.isPresent()){
//            return ResponseEntity.ok(bookOpt.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }

        // este código es equivalente al de arriba. Lo dejo comentado para saberlo porque aún me cuesta de entender
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo libro en base de datos

    /**
     * Método POST, no colisiona con findAll porque son diferentes métodos HTTP: GET vs. POST
     *
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers) {

        System.out.println(headers.get("User-Agent"));

        // guardar libro recibido por parámetro en la base de datos

        if (book.getId() != null) { // quiere decir que existe el id y por tanto no es una creación
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }

        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }

    /**
     * actualizar un libro existente en base de datos
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book) {

        if (book.getId() == null) { //si no tiene id quiere decir que es una creación (por lo tanto no actualización)

            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }

        if (!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        // proceso de actualización
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // Actualizar libro existente en base de datos

    // Borrar libro en base de datos

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if (!bookRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build(); // normalmente se devuelve noContent cuando se borra algo
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){

        log.info("REST Request for deleting all books");
        bookRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
