package dev.patika.kutuphane.api;

import dev.patika.kutuphane.business.abstracts.IBookService;
import dev.patika.kutuphane.core.config.modelMapper.IModelMapperService;
import dev.patika.kutuphane.core.result.Result;
import dev.patika.kutuphane.core.result.ResultData;
import dev.patika.kutuphane.core.utilies.ResultHelper;
import dev.patika.kutuphane.dto.request.book.BookSaveRequest;
import dev.patika.kutuphane.dto.request.book.BookUpdateRequest;
import dev.patika.kutuphane.dto.response.CursorResponse;
import dev.patika.kutuphane.dto.response.book.BookResponse;
import dev.patika.kutuphane.entities.Book;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService bookService;
    private final IModelMapperService modelMapper;

    public BookController(IBookService bookService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest,Book.class);
        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBook,BookResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id") int id){
        Book book = this.bookService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(book,BookResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookResponse>> cursor(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    ){
        Page<Book> bookPage = this.bookService.cursor(page,pageSize);

        Page<BookResponse> bookResponsePage = bookPage
                .map(book -> this.modelMapper.forResponse().map(book,BookResponse.class));


        return ResultHelper.cursor(bookResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest){
        Book updateBook= this.modelMapper.forRequest().map(bookUpdateRequest,Book.class);
        this.bookService.save(updateBook);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBook,BookResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
}
