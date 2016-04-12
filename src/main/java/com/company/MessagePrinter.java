package com.company;

import com.company.annotation.ActionAnnotation;
import com.company.annotation.MessageAnnotation;

/**
 * Created by szl on 2016/4/12.
 */
public interface MessagePrinter {

    @MessageAnnotation("This is from Message Annotation")
    void printMessage();

    @ActionAnnotation("This is from Action Annotation")
    void printAction();

}
