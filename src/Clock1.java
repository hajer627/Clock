/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import java.time.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author hajer
 */
public class Clock1 extends Pane{
int hour;
    int minute;
    int second;
    
    
    public Clock1(){
        setCurrentTime();
    }
   public Clock1(int h,int m, int s){
        hour=h;
        minute=m;
        second=s;
        
    }
    
    public void setCurrentTime(){
        Calendar calendar = new GregorianCalendar();
        // Set current hour, minute and second
        this.hour =calendar.get(Calendar.HOUR_OF_DAY);
        this.minute =calendar.get(Calendar.MINUTE);
        this.second =calendar.get(Calendar.SECOND);
        paintClock(); // Repaint the clock
    };
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paintClock();
    }
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock(); 
    }
    
    public int getHour(){return hour;}
    public int getMinute(){return minute;}
    public int getSecond(){return second;};
    public void setHour(int h){hour=h;}
    public void setMinute(int m){minute=m;}
    public void setSecond(int s){second=s;};
    
    public void paintClock(){
        // Initialize clock parameters
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() /2;
        double centerY = getHeight() /2;
        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);
        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);
        getChildren().clear();
        getChildren().addAll(circle, t1, t2,t3, t4, sLine, mLine, hLine);
    }; 
    
}
