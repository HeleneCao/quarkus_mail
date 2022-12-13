package fr.rootar.dto;

import lombok.Data;

import javax.enterprise.context.ApplicationScoped;

@Data
@ApplicationScoped
public class MailDto {
    private String to;
    private String subject;
    private String text;
}