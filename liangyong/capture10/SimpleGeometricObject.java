package liangyong.capture10;

import java.time.LocalDateTime;

public class SimpleGeometricObject {
    private String color = "white";
    private boolean filled;
    private LocalDateTime dateCreated;

    public SimpleGeometricObject() {
        dateCreated = dateCreated.now();
    }
    public SimpleGeometricObject(String color, boolean filled) {
        dateCreated = dateCreated.now();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "liangyong.capture10.SimpleGeometricObject{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
