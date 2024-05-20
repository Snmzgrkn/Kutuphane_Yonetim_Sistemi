package dev.patika.kutuphane.api;

import dev.patika.kutuphane.business.abstracts.IAuthorService;
import dev.patika.kutuphane.business.abstracts.IBookBorrowingService;
import dev.patika.kutuphane.core.config.modelMapper.IModelMapperService;
import dev.patika.kutuphane.core.result.Result;
import dev.patika.kutuphane.core.result.ResultData;
import dev.patika.kutuphane.core.utilies.ResultHelper;
import dev.patika.kutuphane.dao.BookBorrowingRepo;
import dev.patika.kutuphane.dto.request.author.AuthorSaveRequest;
import dev.patika.kutuphane.dto.request.author.AuthorUpdateRequest;
import dev.patika.kutuphane.dto.request.book.BookUpdateRequest;
import dev.patika.kutuphane.dto.request.bookborrowing.BookBorrowingSaveRequest;
import dev.patika.kutuphane.dto.response.CursorResponse;
import dev.patika.kutuphane.dto.response.author.AuthorResponse;
import dev.patika.kutuphane.dto.response.bookborrowing.BookBorrowingResponse;
import dev.patika.kutuphane.entities.Author;
import dev.patika.kutuphane.entities.Book;
import dev.patika.kutuphane.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookborrowings")
public class BookBorrowingController {
    private final IBookBorrowingService bookBorrowingService;
    private final IModelMapperService modelMapper;

    public BookBorrowingController(IBookBorrowingService bookBorrowingService, IModelMapperService modelMapper) {
        this.bookBorrowingService = bookBorrowingService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save(@Valid @RequestBody BookBorrowingSaveRequest bookBorrowingSaveRequest){
        BookBorrowing saveBookBorrowing = this.modelMapper.forRequest().map(bookBorrowingSaveRequest,BookBorrowing.class);
        this.bookBorrowingService.save(saveBookBorrowing);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBookBorrowing,BookBorrowingResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> get(@PathVariable("id") int id){
        BookBorrowing bookBorrowing = this.bookBorrowingService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(bookBorrowing,BookBorrowingResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    ){
        Page<BookBorrowing> bookBorrowingPage = this.bookBorrowingService.cursor(page,pageSize);

        Page<BookBorrowingResponse> bookBorrowingResponsePage = bookBorrowingPage
                .map(bookBorrowing -> this.modelMapper.forResponse().map(bookBorrowing,BookBorrowingResponse.class));


        return ResultHelper.cursor(bookBorrowingResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest){
        BookBorrowing updateBookBorrowing= this.modelMapper.forRequest().map(bookUpdateRequest,BookBorrowing.class);
        this.bookBorrowingService.save(updateBookBorrowing);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBookBorrowing,BookBorrowingResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.bookBorrowingService.delete(id);
        return ResultHelper.ok();
    }
}
