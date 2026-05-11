package com.example.crudtest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank; // null, 빈 문자열, 공백 모두 불가능
import jakarta.validation.constraints.Size; // 문자열 길이 제한

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    @Size(min = 5, message = "내용은 최소 5자 이상입니다.")
    private String content;

    @NotBlank(message = "작성자는 필수입니다.")
    private String writer;

    private String password;
}