package com.pettory.pettory.board.query.controller;

import com.pettory.pettory.board.query.dto.BoardCommentResponse;
import com.pettory.pettory.board.query.service.BoardCommentListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "댓글 조회", description = "댓글 조회")
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardCommentController {

    private final BoardCommentListService boardCommentListService;


    // 댓글 조회
    @Operation(summary = "댓글 조회", description = "회원이 댓글을 조회한다.")
    @ApiResponse(responseCode = "200", description = "댓글 조회 성공")
    @GetMapping("/comments/{postNum}")
    public ResponseEntity<BoardCommentResponse> getComments(
            @PathVariable int postNum
    ) {

        BoardCommentResponse response = boardCommentListService.getCommentList(postNum);

        return ResponseEntity.ok(response);
    }
}
