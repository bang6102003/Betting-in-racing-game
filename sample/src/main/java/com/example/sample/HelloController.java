package com.example.sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

import javafx.scene.input.KeyEvent;
import javafx.stage.*;
import javafx.scene.shape.*;
public class HelloController  {


    @FXML
    private Ellipse e1;
    @FXML
      void display() {
          System.out.print(e1.getCenterX());
      }

}