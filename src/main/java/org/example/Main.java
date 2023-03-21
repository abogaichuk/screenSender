package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws AWTException, IOException {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);

        builder.headless(false);

        builder.run(args);
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("single-screen.bmp");
        ImageIO.write(capture, "bmp", imageFile );
    }
}